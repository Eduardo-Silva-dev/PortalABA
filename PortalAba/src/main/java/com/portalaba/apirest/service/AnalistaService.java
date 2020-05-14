package com.portalaba.apirest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portalaba.apirest.domain.Acompanhante;
import com.portalaba.apirest.domain.Analista;
import com.portalaba.apirest.domain.Endereco;
import com.portalaba.apirest.domain.Paciente;
import com.portalaba.apirest.dto.AcompanhanteDTO;
import com.portalaba.apirest.dto.AnalistaDTO;
import com.portalaba.apirest.dto.AnalistaNewDTO;
import com.portalaba.apirest.dto.AnalistaTotalDTO;
import com.portalaba.apirest.dto.PacienteDTO;
import com.portalaba.apirest.repository.AcompanhanteRepository;
import com.portalaba.apirest.repository.AnalistaRepository;
import com.portalaba.apirest.repository.PacienteRepository;
import com.portalaba.apirest.service.exception.ObjectNotFoundException;

@Service
public class AnalistaService {

	@Autowired
	private AnalistaRepository repo;
	
	@Autowired
	private PacienteRepository repoP;
	
	@Autowired
	private AcompanhanteRepository repoA;
	
	public Page<Analista> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public Page<PacienteDTO> findAllPacientes(long id,Pageable pageable) {
		Analista analista = find(id);
		Page<PacienteDTO> pacientes = repoP.findAllPacientes(analista,pageable);
		return pacientes;
	}

	public Page<AcompanhanteDTO> findAllAcompanhantes(long id,Pageable pageable) {
		find(id);
		Page<Acompanhante> acompanhantes = repo.findAllAcompanhantes(id,pageable);
		Page<AcompanhanteDTO> listDto = acompanhantes.map(obj -> new AcompanhanteDTO(obj));  
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
	
	public AnalistaDTO findParcial(long id) {
		Analista obj = find(id);
		AnalistaDTO obgDTO = new AnalistaDTO(obj);
		return obgDTO;
	}
	
	public AnalistaTotalDTO findTotal(long id) {
		long endId = 0;
		Analista obj = find(id);
		Endereco endereco = repo.findEnderecos(obj.getEnderecos().getId());
		if (endereco == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + endId + ", Tipo: " + Endereco.class.getName(), null);
		}
		AnalistaTotalDTO obgTotalDTO = new AnalistaTotalDTO(obj,endereco);
			return obgTotalDTO;
	}

	public Analista insert(Analista obj) {
		obj = repo.save(obj);
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
