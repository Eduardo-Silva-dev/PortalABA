package com.portalaba.apirest.service;

import com.portalaba.apirest.service.exception.ObjectNotFoundException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.portalaba.apirest.domain.Acompanhante;
import com.portalaba.apirest.domain.Analista;
import com.portalaba.apirest.domain.Endereco;
import com.portalaba.apirest.domain.Paciente;

import com.portalaba.apirest.dto.AcompanhanteDTO;
import com.portalaba.apirest.dto.AnalistaDTO;
import com.portalaba.apirest.dto.PacienteDTO;
import com.portalaba.apirest.dto.PacienteNewDTO;
import com.portalaba.apirest.dto.PacienteTotalDTO;

import com.portalaba.apirest.repository.AcompanhanteRepository;
import com.portalaba.apirest.repository.AnalistaRepository;
import com.portalaba.apirest.repository.PacienteRepository;

@Service
public class PacienteService {
	
//	@Autowired
//	private BCryptPasswordEncoder pe;

	@Autowired
	private PacienteRepository repo;
	
	@Autowired
	private AnalistaRepository repoA;
	
	@Autowired
	private AcompanhanteRepository repoT;
	
	@Autowired
	private AnalistaService analistaService;
	
	@Autowired
	private AcompanhanteService acompanhanteService;
	
	@Autowired
	private EmpresaService empresaService;
	
	public Paciente find(long id) {
		
		Paciente obj =  repo.findByID(id);
		
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Paciente.class.getName(), null);
		}
	    
		return obj;
	}
	
	public Page<PacienteTotalDTO> findAll(Pageable pageable) throws IOException {
		
		Page<Paciente> paciente = repo.findAll(pageable);
		
		List<Paciente> list = paciente.stream().map(obj -> new Paciente(obj)).collect(Collectors.toList());  
		
		List<PacienteTotalDTO> listDto = list.stream().map(obj -> new PacienteTotalDTO(obj)).collect(Collectors.toList());  
		
		for (int i = 0; i<list.size() ; i++) {
				
			if(list.get(i).getImage() != null) {
				
				File img = new File(list.get(i).getImage().toString());
				FileInputStream fis = new FileInputStream(img);
				byte[] data = new byte[fis.available()];
				fis.read(data);
				
				listDto.get(i).setImage(data);
			}
		
		}

		Page<PacienteTotalDTO> pages = new PageImpl<PacienteTotalDTO>(listDto);
		
		return pages;
	}
	
	public PacienteDTO findParcial(long id) throws IOException {
		
		Paciente obj = find(id);
		
		PacienteDTO obgDTO = new PacienteDTO(obj);
		
		if(obj.getImage() != null) {
		
			File img = new File(obj.getImage().toString());
			FileInputStream fis = new FileInputStream(img);
			byte[] data = new byte[fis.available()];
			fis.read(data);
			obgDTO.setImage(data);
			
		}
	
		return obgDTO;
	}
	
	public PacienteTotalDTO findTotal(long id) throws IOException {
		
		Paciente obj = find(id);
		
		PacienteTotalDTO obgTotalDTO = new PacienteTotalDTO(obj);
		
		if(obj.getImage() != null) {
			
			File img = new File(obj.getImage().toString());
			FileInputStream fis = new FileInputStream(img);
			byte[] data = new byte[fis.available()];
			fis.read(data);
			obgTotalDTO.setImage(data);
			
		}
		
		return obgTotalDTO;
	}
	
	public AnalistaDTO findAnalista(long id) throws IOException{
		
		Paciente paciente = find(id);
		
		Analista analista = repoA.findByID(paciente.getAnalista().getId());
		
		AnalistaDTO analistaDTO = new AnalistaDTO(analista);
		
		if(analista.getImage() != null) {
			
			File img = new File(analista.getImage().toString());
			FileInputStream fis = new FileInputStream(img);
			byte[] data = new byte[fis.available()];
			fis.read(data);
			analistaDTO.setImage(data);
		}
		
		return analistaDTO;
	}
	
	public AcompanhanteDTO findAcompanhante(long id) throws IOException{
		
		Paciente paciente = find(id);
		
		Acompanhante acompanhante = repoT.findByID(paciente.getAcompanhante().getId());
		
		AcompanhanteDTO obj = new AcompanhanteDTO(acompanhante);
		
		if(acompanhante.getImage() != null) {
			
			File img = new File(acompanhante.getImage().toString());
			FileInputStream fis = new FileInputStream(img);
			byte[] data = new byte[fis.available()];
			fis.read(data);
			obj.setImage(data);
			
		}
		
		return obj;
	}
	
	public Paciente fromDTO(PacienteNewDTO objDto) {
		
		Paciente paciente = new Paciente(/*pe.encode(objDto.getPassword())*/objDto.getPassword(), objDto.getNome(), objDto.getDataNascimento(), objDto.getNomeResponsavel(),
				objDto.getDataNascimentoResponsavel(),objDto.getEmailResponsavel(),objDto.getCpfResponsavel(),objDto.getContatoResponsavel(),
				objDto.getContatoAuxiliar(),objDto.getNivelAltismo());
		 
		Endereco endereco = new Endereco(objDto.getLogradouro(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), objDto.getNumero(),paciente,objDto.getCidade(),objDto.getEstado());
		
		paciente.setEnderecos(endereco);
		
		return paciente; 
	}
	
	public Paciente insert(Paciente obj,MultipartFile file) {
		
		obj = repo.save(obj);
		
		if(file == null) { 
			return obj; 
		}
		
		Path path = Paths.get("C:/Users/Eduardo/git/PortalABA/PortalAba/src/main/resources/imagensCadastro/paciente/"  + obj.getCpfResponsavel()+".jpg");
		
		try {
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		obj.setImage(path.toString());
		
		return obj;
	}
	
	public Paciente insertAcompanhante(long idP, long idA) {
		
		Paciente paciente = find(idP);
		
		Acompanhante acompanhante = repoT.findByID(idA);
		
		if (acompanhante == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + idA + ", Tipo: " + Acompanhante.class.getName(), null);
		}
		
		paciente.setAcompanhante(acompanhante);
		
		return repo.save(paciente);
	}
	
	public Paciente insertAnalista(long id,long idA) {
		
		Paciente obj = find(id);
		
		Analista analista = repoA.findByID(idA);
		
		if (analista == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Analista.class.getName(), null);
		}
		
		obj.setAnalista(analista);
		
		return repo.save(obj);
	}

	public Paciente update(Paciente obj,long id) {
		
		obj.setId(id);
		
		Paciente end = find(obj.getId());
		
		obj.getEnderecos().setId(end.getEnderecos().getId());
		
		return repo.save(obj);
	}
	
	public Paciente updateImage(long id,MultipartFile file) {
		
		Paciente obj = find(id);
		
		Path path = Paths.get("C:/Users/Eduardo/git/PortalABA/PortalAba/src/main/resources/imagensCadastro/paciente/"  + obj.getCpfResponsavel()+".jpg");
		
		try {
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		obj.setImage(path.toString());
		
		return repo.save(obj);
	}
	
	public void delete(long id){
		
		Paciente obj = find(id);
		if(obj.getAnalista() != null) {
		analistaService.removerPaciente(obj.getAnalista().getId(),id);
		obj.setAnalista(null);}
		if(obj.getAcompanhante() != null) {
		acompanhanteService.removerPaciente(obj.getAcompanhante().getId(), id);
		obj.setAcompanhante(null);}
		if(obj.getEmpresa() != null) {
		empresaService.removerPaciente(obj.getEmpresa().getId(), id);
		obj.setEmpresa(null);}
		
		repo.deleteById(id);	
	}
	
	public void removerAnalista(long id,long idP){
		
		Paciente obj = find(id);
		
		Analista analista = repoA.findByID(idP);
		
		if (analista == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + idP + ", Tipo: " + Analista.class.getName(), null);
		}
		
		obj.setAnalista(null);
		
		analista.getPacientes().remove(obj);
		
		repo.save(obj);
		
		repoA.save(analista);
	}
	
	public void removerAcompanhante(long id,long idP){
		
		Paciente obj = find(id);
		
		Acompanhante acompanhante = repoT.findByID(idP);
		
		if (acompanhante == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + idP + ", Tipo: " + Acompanhante.class.getName(), null);
		}
		
		obj.setAcompanhante(null);
		
		acompanhante.getPacientes().remove(obj);
		
		repo.save(obj);
		
		repoT.save(acompanhante);
	}
}
