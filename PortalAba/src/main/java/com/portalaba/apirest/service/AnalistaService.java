package com.portalaba.apirest.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.portalaba.apirest.domain.Acompanhante;
import com.portalaba.apirest.domain.Analista;
import com.portalaba.apirest.domain.Endereco;
import com.portalaba.apirest.domain.Paciente;
import com.portalaba.apirest.domain.Tratamento;

import com.portalaba.apirest.dto.AcompanhanteDTO;
import com.portalaba.apirest.dto.AnalistaDTO;
import com.portalaba.apirest.dto.AnalistaNewDTO;
import com.portalaba.apirest.dto.AnalistaTotalDTO;
import com.portalaba.apirest.dto.PacienteDTO;

import com.portalaba.apirest.repository.AcompanhanteRepository;
import com.portalaba.apirest.repository.AnalistaRepository;
import com.portalaba.apirest.repository.PacienteRepository;
import com.portalaba.apirest.repository.TratamentoRepository;

import com.portalaba.apirest.service.exception.ObjectNotFoundException;

@Service
public class AnalistaService {

	@Autowired
	private AnalistaRepository repo;
	
	@Autowired
	private PacienteRepository repoP;
	
	@Autowired
	private AcompanhanteRepository repoA;
	
	@Autowired
	private TratamentoRepository repoT;
	
	public Page<AnalistaTotalDTO> findAll(Pageable pageable) throws IOException {
		
		Page<Analista> analista = repo.findAll(pageable);
		
		Page<AnalistaTotalDTO> listDto = analista.map(obj -> new AnalistaTotalDTO(obj));  
		
		for (AnalistaTotalDTO p : listDto){
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

	public Page<PacienteDTO> findAllPacientes(long id,Pageable pageable) throws IOException {
		
		Analista analista = find(id);
		
		Page<PacienteDTO> pacientes = repoP.findAllPacientes(analista,pageable);
		
		for (PacienteDTO p : pacientes){
		
			if(p.getImage() != null) {
			
				File img = new File(p.getImage().toString());
				FileInputStream fis = new FileInputStream(img);
				byte[] data = new byte[fis.available()];
				fis.read(data);
				p.setImage(data);
			
			}
		}
		
		return pacientes;
	}

	public Page<AcompanhanteDTO> findAllAcompanhantes(long id,Pageable pageable) throws IOException {

		find(id);
		
		Page<Acompanhante> acompanhantes = repo.findAllAcompanhantes(id,pageable);
		
		Page<AcompanhanteDTO> listDto = acompanhantes.map(obj -> new AcompanhanteDTO(obj));
		
		for (AcompanhanteDTO p : listDto){
		
			File img = new File(p.getImage().toString());
			FileInputStream fis = new FileInputStream(img);
			byte[] data = new byte[fis.available()];
			fis.read(data);
			p.setImage(data);
		
		}
		
		return listDto;
	}
	
	public Analista find(long id) {
		
		Analista obj =  repo.findByID(id);
		
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Analista.class.getName(), null);
		}
		
		return obj;
	}
	
	public Page<Tratamento> findTratamentos(long id,long idP,Pageable pageable) {
		
		Page<Tratamento> tratamento = repoT.findTratamentos(id,idP,pageable);
		
		return tratamento;
	}
	
	public AnalistaDTO findParcial(long id) throws IOException {
		
		Analista obj = find(id);
		
		AnalistaDTO obgDTO = new AnalistaDTO(obj);
		
		if(obj.getImage() != null) {
		
			File img = new File(obj.getImage().toString());
			FileInputStream fis = new FileInputStream(img);
			byte[] data = new byte[fis.available()];
			fis.read(data);
			
			obgDTO.setImage(data);
		}
		
		return obgDTO;
	}
	
	public AnalistaTotalDTO findTotal(long id) throws IOException {
		
		long endId = 0;
		
		Analista obj = find(id);
		
		AnalistaTotalDTO obgTotalDTO = new AnalistaTotalDTO(obj);
		
		if(obj.getImage() != null) {
		
			File img = new File(obj.getImage().toString());
			FileInputStream fis = new FileInputStream(img);
			byte[] data = new byte[fis.available()];
			fis.read(data);
			obgTotalDTO.setImage(data);
		}
		
		return obgTotalDTO;
	}

	public Analista insert(Analista obj,MultipartFile file) {
	
		obj = repo.save(obj);
		
		if(file == null) { 
			return obj; 
		}
		
		Path path = Paths.get("C:/Users/Eduardo/git/PortalABA/PortalAba/src/main/resources/imagensCadastro/analista/"  + obj.getCpfAnalista()+".jpg");
		
		try {
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		obj.setImage(path.toString());
		
		return obj;
	}
	
	public Analista fromDTO(AnalistaNewDTO objDto) {
		
		Analista analista = new Analista(objDto.getPassword(), objDto.getNome(), objDto.getDataNascimento(), objDto.getTipoAnalista(), 
		objDto.getEmailAnalista(), objDto.getCpfAnalista(), objDto.getContatoAnalista(),objDto.getCrpAnalista(),objDto.getCnpjAnalista());
		
		Endereco endereco = new Endereco(objDto.getLogradouro(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), 
				objDto.getNumero(),objDto.getCidade(),objDto.getEstado(),analista);
		analista.setEnderecos(endereco);
		
		return analista;
	}


	public Analista update(Analista obj,long id) {
		
		obj.setId(id);
		
		Analista end = find(obj.getId());
		
		obj.getEnderecos().setId(end.getEnderecos().getId());
		
		return repo.save(obj);
	}
	
	public Analista updateImage(long id,MultipartFile file) {
		
		Analista obj = find(id);
		
		Path path = Paths.get("C:/Users/Eduardo/git/PortalABA/PortalAba/src/main/resources/imagensCadastro/analista/"  + obj.getCpfAnalista()+".jpg");
		
		try {
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		obj.setImage(path.toString());
		
		return repo.save(obj);
	}
	
	public Analista insertAcompanhante(long id,long idA) {
		
		Analista obj = find(id);
		
		Acompanhante acompanhante = repoA.findByID(idA);
		
		if (acompanhante == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Acompanhante.class.getName(), null);
		}
		
		Acompanhante acom = repo.findAcompanhante(id);
		
		if (acom != null) {
			throw new ObjectNotFoundException(
					"Acompanhante já inserido! Id: " + id + ", Tipo: " + Acompanhante.class.getName(), null);
		}
		
		obj.getAcompanhantes().add(acompanhante);
	
		acompanhante.getAnalistas().add(obj);
	
		repoA.save(acompanhante);
		
		return repo.save(obj);
	}
	
	public Analista insertPaciente(long id,long idA) {
		
		Analista obj = find(id);
		
		Paciente paciente = repoP.findByID(idA);
		
		if (paciente == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Acompanhante.class.getName(), null);
		}
		
		Paciente paci = repo.findPaciente(id);
		
		if (paci != null) {
			throw new ObjectNotFoundException(
					"Paciente já inserido! Id: " + id + ", Tipo: " + Paciente.class.getName(), null);
		}
		
		obj.getPacientes().add(paciente);
		
		paciente.setAnalista(obj);
		
		repoP.save(paciente);
		
		return repo.save(obj);		
	}
	
	public void delete(long id){
		repo.deleteById(id);	
	}
	
	public void removerPaciente(long id,long idP){
		
		Analista obj = find(id);
		
		Paciente paciente = repoP.findByID(idP);
		
		if (paciente == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + idP + ", Tipo: " + Paciente.class.getName(), null);
		}
		
		obj.getPacientes().remove(paciente);
		
		paciente.setAnalista(null);
		
		repo.save(obj);
		
		repoP.save(paciente);
	}
	
	public void removerAcompanhante(long id,long idP){
		
		Analista obj = find(id);
		
		Acompanhante acompanhante = repoA.findByID(idP);
		
		if (acompanhante == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + idP + ", Tipo: " + Acompanhante.class.getName(), null);
		}
		
		obj.getAcompanhantes().remove(acompanhante);
		
		acompanhante.getAnalistas().remove(obj);
		
		repo.save(obj);
		
		repoA.save(acompanhante);
	}
}
