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
import com.portalaba.apirest.dto.AcompanhanteNewDTO;
import com.portalaba.apirest.dto.AcompanhanteTotalDTO;
import com.portalaba.apirest.dto.AnalistaDTO;
import com.portalaba.apirest.dto.PacienteDTO;

import com.portalaba.apirest.repository.AcompanhanteRepository;
import com.portalaba.apirest.repository.AnalistaRepository;
import com.portalaba.apirest.repository.PacienteRepository;

@Service
public class AcompanhanteService {
	
	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private AcompanhanteRepository repo;
	
	@Autowired
	private AnalistaRepository repoA;
	
	@Autowired
	private PacienteRepository repoP;
	
	public Acompanhante find(long id) {
		
		Acompanhante obj =  repo.findByID(id);
		
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Acompanhante.class.getName(), null);
		}
		
		return obj;
	}
	
	public Page<AcompanhanteTotalDTO> findAll(Pageable pageable) throws IOException {
		
		Page<Acompanhante> acompanhante = repo.findAll(pageable);
		
		Page<AcompanhanteTotalDTO> listDto = acompanhante.map(obj -> new AcompanhanteTotalDTO(obj));  
		
		for (AcompanhanteTotalDTO p : listDto){
			
			if(p.getImagem() != null) {
				
				File img = new File(p.getImagem().toString());
				FileInputStream fis = new FileInputStream(img);
				byte[] data = new byte[fis.available()];
				fis.read(data);
				p.setImage(data);
				
			}
		}
		
		return listDto;
	}
	
	public AcompanhanteDTO findParcial(long id) throws IOException {
		
		Acompanhante obj = find(id);
		AcompanhanteDTO obgDTO = new AcompanhanteDTO(obj);
		
		if(obj.getImage() != null) {
			File img = new File(obj.getImage().toString());
			FileInputStream fis = new FileInputStream(img);
			byte[] data = new byte[fis.available()];
			fis.read(data);
			obgDTO.setImage(data);
		}
		
		return obgDTO;
	}
	
	public AcompanhanteTotalDTO findTotal(long id) throws IOException {
		
		Acompanhante obj = find(id);
		
		AcompanhanteTotalDTO objTotalDTO = new AcompanhanteTotalDTO(obj);
		
		if(obj.getImage() != null) {
			File img = new File(obj.getImage().toString());
			FileInputStream fis = new FileInputStream(img);
			byte[] data = new byte[fis.available()];
			fis.read(data);
			objTotalDTO.setImage(data);
		}
		
		return objTotalDTO;
	}

	public Page<PacienteDTO> findAllPacientes(long id,Pageable pageable) throws IOException {
		
		find(id);
		
		Page<Paciente> paciente = repo.findAllPacientes(id,pageable);
		
		List<Paciente> list = paciente.stream().map(obj -> new Paciente(obj)).collect(Collectors.toList());  
		
		List<PacienteDTO> listDto = list.stream().map(obj -> new PacienteDTO(obj)).collect(Collectors.toList());  
		
		for (int i = 0; i<list.size() ; i++) {
				
			if(list.get(i).getImage() != null) {
				
				File img = new File(list.get(i).getImage().toString());
				FileInputStream fis = new FileInputStream(img);
				byte[] data = new byte[fis.available()];
				fis.read(data);
				
				listDto.get(i).setImage(data);
			}
		
		}

		Page<PacienteDTO> pages = new PageImpl<PacienteDTO>(listDto);
		
		return pages;
	}

	public Page<AnalistaDTO> findAllAnalistas(long id,Pageable pageable) throws IOException {
		
		find(id);
		
		Page<Analista> analista = repo.findAllAnalistas(id,pageable);
		
		List<Analista> list = analista.stream().map(obj -> new Analista(obj)).collect(Collectors.toList());  
		
		List<AnalistaDTO> listDto = list.stream().map(obj -> new AnalistaDTO(obj)).collect(Collectors.toList());  
		
		for (int i = 0; i<list.size() ; i++) {
				
			if(list.get(i).getImage() != null) {
				
				File img = new File(list.get(i).getImage().toString());
				FileInputStream fis = new FileInputStream(img);
				byte[] data = new byte[fis.available()];
				fis.read(data);
				
				listDto.get(i).setImage(data);
			}
		
		}

		Page<AnalistaDTO> pages = new PageImpl<AnalistaDTO>(listDto);
		
		return pages;
	}
	
	public Acompanhante fromDTO(AcompanhanteNewDTO objDto) {
		
		Acompanhante acompanhante = new Acompanhante(pe.encode(objDto.getPassword()),objDto.getNome(),objDto.getDataNascimento(),objDto.getTipoAcompanhante(), 
		objDto.getEmailAcompanhante(),objDto.getCpfAcompanhante(),objDto.getContatoAcompanhante(),objDto.getCrpAcompanhante());
		
		Endereco endereco = new Endereco(objDto.getLogradouro(),objDto.getComplemento(),objDto.getBairro(),objDto.getCep(),
		objDto.getNumero(),objDto.getCidade(),objDto.getEstado(),acompanhante);
		
		acompanhante.setEnderecos(endereco);
		
		return acompanhante;
	}
	
	public Acompanhante insert(Acompanhante obj,MultipartFile file) {
		
		obj = repo.save(obj);
		
		if(file == null) { return obj; }
		
		Path path = Paths.get("C:/Users/Eduardo/git/PortalABA/PortalAba/src/main/resources/imagensCadastro/acompanhante/"  + obj.getCpfAcompanhante()+".jpg");
		
		try {
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		obj.setImage(path.toString());
		
		return obj;
	}
	
	public Acompanhante insertAnalista(long id,long idA) {
		
		Acompanhante obj = find(id);
		
		Analista analista = repoA.findByID(idA);
		
		if (analista == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Analista.class.getName(), null);
		}
		
		Analista analist = repo.findAnalista(id);
		
		if (analist != null) {
			throw new ObjectNotFoundException(
					"Analista já inserido! Id: " + id + ", Tipo: " + Analista.class.getName(), null);
		}
		
		obj.getAnalistas().add(analista);
		
		analista.getAcompanhantes().add(obj);
		
		repoA.save(analista);
		
		return repo.save(obj);
	}

	public Acompanhante insertPaciente(long id,long idA) {
		
		Acompanhante obj = find(id);
		
		Paciente paciente = repoP.findByID(idA);
		
		if (paciente == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Paciente.class.getName(), null);
		}

		Paciente pacient = repo.findPaciente(id);
		
		if (pacient != null) {
			throw new ObjectNotFoundException(
					"Paciente já inserido! Id: " + id + ", Tipo: " + Paciente.class.getName(), null);
		}
		
		obj.getPacientes().add(paciente);
		
		paciente.setAcompanhante(obj);
		
		repoP.save(paciente);
		
		return repo.save(obj);
	}

	public Acompanhante update(Acompanhante obj,long id) {
		
		obj.setId(id);
		
		Acompanhante end = find(obj.getId());
		
		obj.getEnderecos().setId(end.getEnderecos().getId());
		
		return repo.save(obj);
	}
	
	public Acompanhante updateImage(long id,MultipartFile file) {
		
		Acompanhante obj = find(id);
		
		Path path = Paths.get("C:/Users/Eduardo/git/PortalABA/PortalAba/src/main/resources/imagensCadastro/acompanhante/"  + obj.getCpfAcompanhante()+".jpg");
		
		try {
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		obj.setImage(path.toString());
		
		return repo.save(obj);
	}
	
	public void delete(long id){
		
		repo.deleteById(id);	
	}
	
	public void removerPaciente(long id,long idP){
		
		Acompanhante obj = find(id);
		
		Paciente paciente = repoP.findByID(idP);
		
		if (paciente == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + idP + ", Tipo: " + Paciente.class.getName(), null);
		}
		
		obj.getPacientes().remove(paciente);
		
		paciente.setAcompanhante(null);
		
		repo.save(obj);
		
		repoP.save(paciente);
	}
	
	public void removerAnalista(long id,long idA){
		
		Acompanhante obj = find(id);
		
		Analista analista = repoA.findByID(idA);
		
		if (analista == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + idA + ", Tipo: " + Analista.class.getName(), null);
		}
		
		obj.getAnalistas().remove(analista);
		
		analista.getAcompanhantes().remove(obj);
		
		repo.save(obj);
		
		repoA.save(analista);
	}
}
