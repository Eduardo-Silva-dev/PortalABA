package com.portalaba.apirest.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.portalaba.apirest.domain.Acompanhante;
import com.portalaba.apirest.domain.Analista;
import com.portalaba.apirest.domain.Empresa;
import com.portalaba.apirest.domain.Endereco;
import com.portalaba.apirest.domain.Paciente;

import com.portalaba.apirest.dto.AcompanhanteDTO;
import com.portalaba.apirest.dto.AnalistaDTO;
import com.portalaba.apirest.dto.EmpresaDTO;
import com.portalaba.apirest.dto.EmpresaNewDTO;
import com.portalaba.apirest.dto.EmpresaTotalDTO;
import com.portalaba.apirest.dto.PacienteDTO;

import com.portalaba.apirest.repository.AcompanhanteRepository;
import com.portalaba.apirest.repository.AnalistaRepository;
import com.portalaba.apirest.repository.EmpresaRepository;
import com.portalaba.apirest.repository.PacienteRepository;

import com.portalaba.apirest.service.exception.ObjectNotFoundException;

@Service
public class EmpresaService {
	
	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private EmpresaRepository repo;
	
	@Autowired
	private AnalistaRepository repoAn;
	
	@Autowired
	private PacienteRepository repoP;
	
	@Autowired
	private AcompanhanteRepository repoA;

	public Empresa find(long id) {
		
		Empresa obj =  repo.findByID(id);
		
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Empresa.class.getName(), null);
		}
		
		return obj;
	}
	
	public Page<EmpresaTotalDTO> findAll(Pageable pageable) throws IOException {
		
		Page<Empresa> analista = repo.findAll(pageable);
		
		Page<EmpresaTotalDTO> listDto = analista.map(obj -> new EmpresaTotalDTO(obj));  
		
		return listDto;
	}
	
	public EmpresaDTO findParcial(long id) throws IOException {
		
		Empresa obj = find(id);
		
		EmpresaDTO obgDTO = new EmpresaDTO(obj);
		
		return obgDTO;
	}
	
	public EmpresaTotalDTO findTotal(long id) throws IOException {
		
		Empresa obj = find(id);
		
		EmpresaTotalDTO obgTotalDTO = new EmpresaTotalDTO(obj);
		
		return obgTotalDTO;
	}
	
	public Page<AnalistaDTO> findAllAnalista (long id, Pageable pageable) throws IOException{
		
		Page<Analista> analista = repo.findAllAnalistas(id, pageable);
		
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
	
	public Page<AcompanhanteDTO> findAllAcompanhante (long id, Pageable pageable) throws IOException{
		
		Page<Acompanhante> acompanhante = repo.findAllAcompanhante(id, pageable);
		
		List<Acompanhante> list = acompanhante.stream().map(obj -> new Acompanhante(obj)).collect(Collectors.toList());  
		
		List<AcompanhanteDTO> listDto = list.stream().map(obj -> new AcompanhanteDTO(obj)).collect(Collectors.toList());  
		
		for (int i = 0; i<list.size() ; i++) {
				
			if(list.get(i).getImage() != null) {
				
				File img = new File(list.get(i).getImage().toString());
				FileInputStream fis = new FileInputStream(img);
				byte[] data = new byte[fis.available()];
				fis.read(data);
				listDto.get(i).setImage(data);
			}
		
		}

		Page<AcompanhanteDTO> pages = new PageImpl<AcompanhanteDTO>(listDto);
		
		return pages;
		
	}
	public Page<PacienteDTO> findAllPaciente (long id, Pageable pageable) throws IOException{
		
		Page<Paciente> paciente = repo.findAllPaciente(id, pageable);
		
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

	public Page<PacienteDTO> findAnalista_Paciente (long idE,long id, Pageable pageable) throws IOException{
		
		Analista analista = repoAn.findByID(id);
		
		Empresa empresa = find(idE);
		
		Page<Paciente> paciente = repoP.findPacientesAnalista(analista,empresa, pageable);
		
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

//	public Page<PacienteDTO> findAcomapanhante_Paciente (long idE,long id, Pageable pageable) throws IOException{
//			
//			Acompanhante acompanhante = repoA.findByID(id);
//			
//			Empresa empresa = find(idE);
//			
//			Page<Paciente> paciente = repoP.findPacientesAcompanhante(acompanhante,empresa, pageable);
//			
//			List<Paciente> list = paciente.stream().map(obj -> new Paciente(obj)).collect(Collectors.toList());  
//			
//			List<PacienteDTO> listDto = list.stream().map(obj -> new PacienteDTO(obj)).collect(Collectors.toList());  
//			
//			for (int i = 0; i<list.size() ; i++) {
//					
//				if(list.get(i).getImage() != null) {
//					
//					File img = new File(list.get(i).getImage().toString());
//					FileInputStream fis = new FileInputStream(img);
//					byte[] data = new byte[fis.available()];
//					fis.read(data);
//					listDto.get(i).setImage(data);
//				}
//			
//			}
//
//		Page<PacienteDTO> pages = new PageImpl<PacienteDTO>(listDto);
//		
//		return pages;
//		
//	}
	
	public Empresa fromDTO(EmpresaNewDTO objDto) {

		Empresa empresa = new Empresa(pe.encode(objDto.getPassword()),objDto.getCnpj(),objDto.getRazao_social(),objDto.getNome_fantasia(),
				objDto.getContato(),objDto.getTelefone(),objDto.getCelular(),objDto.getEmail());
		
		Endereco endereco = new Endereco(objDto.getLogradouro(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), 
				objDto.getNumero(),empresa,objDto.getCidade(),objDto.getEstado());
		
		empresa.setEnderecos(endereco);
		
		return empresa;
	}

	public Empresa insert(Empresa obj) {
	
		return repo.save(obj);
		
	}
	
	public Empresa insertAnalista(long id,long idA) {
		
		Empresa obj = find(id);
		
		Analista analista = repoAn.findByID(idA);
		
		if (analista == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Analista.class.getName(), null);
		}
		
		obj.getAnalistas().add(analista);
		
		analista.getEmpresas().add(obj);
		
		repoAn.save(analista);
		
		return repo.save(obj);
	}
	
	public Empresa insertAcompanhante(long id,long idA) {
		
		Empresa obj = repo.findByID(id);
		
		Acompanhante acompanhante = repoA.findByID(idA);
		
		if (acompanhante == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Acompanhante.class.getName(), null);
		}
		
		obj.getAcompanhantes().add(acompanhante);
	
		acompanhante.getEmpresas().add(obj);
	
		repoA.save(acompanhante);
		
		return repo.save(obj);
	}
	
	public Empresa insertPaciente(long id,long idA) {
		
		Empresa obj = find(id);
		
		Paciente paciente = repoP.findByID(idA);
		
		if (paciente == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Paciente.class.getName(), null);
		}
		
		obj.getPacientes().add(paciente);
		
		paciente.setEmpresa(obj);
		
		repoP.save(paciente);
		
		return repo.save(obj);		
	}

	public Empresa update(Empresa obj,long id) {
		
		obj.setId(id);

		Empresa end = find(obj.getId());

		obj.getEnderecos().setId(end.getEnderecos().getId());

		return repo.save(obj);
	}
	
	public void delete(long id){
		repo.deleteById(id);	
	}
	
	public void removerPaciente(long id,long idP){
		
		Empresa obj = find(id);
		
		Paciente paciente = repoP.findByID(idP);
		
		if (paciente == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + idP + ", Tipo: " + Paciente.class.getName(), null);
		}
		
		obj.getPacientes().remove(paciente);
		
		paciente.setEmpresa(null);
		
		repo.save(obj);
		
		repoP.save(paciente);
	}
	
	public void removerAcompanhante(long id,long idP){
		
		Empresa obj = find(id);
		
		Acompanhante acompanhante = repoA.findByID(idP);
		
		if (acompanhante == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + idP + ", Tipo: " + Acompanhante.class.getName(), null);
		}
		
		obj.getAcompanhantes().remove(acompanhante);
		
		acompanhante.getEmpresas().remove(obj);
		
		repo.save(obj);
		
		repoA.save(acompanhante);
	}
	
	public void removerAnalista(long id,long idP){
		
		Empresa obj = find(id);
		
		Analista analista = repoAn.findByID(idP);
		
		if (analista == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + idP + ", Tipo: " + Acompanhante.class.getName(), null);
		}
		
		obj.getAnalistas().remove(analista);
		
		analista.getEmpresas().remove(obj);
		
		repo.save(obj);
		
		repoAn.save(analista);
	}
}
