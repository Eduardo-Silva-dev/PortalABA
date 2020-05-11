package com.portalaba.apirest.service;

import com.portalaba.apirest.service.exception.ObjectNotFoundException;
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
import com.portalaba.apirest.dto.PacienteDTO;
import com.portalaba.apirest.dto.PacienteNewDTO;
import com.portalaba.apirest.dto.PacienteTotalDTO;
import com.portalaba.apirest.repository.AcompanhanteRepository;
import com.portalaba.apirest.repository.AnalistaRepository;
import com.portalaba.apirest.repository.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository repo;
	
	@Autowired
	private AnalistaRepository repoA;
	
	@Autowired
	private AcompanhanteRepository repoT;
	
	public Page<Paciente> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	public Paciente find(long id) {
		Paciente obj =  repo.findByID(id);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Paciente.class.getName(), null);
		}
				return obj;
	}
	
	public PacienteDTO findParcial(long id) {
		Paciente obj = find(id);
		PacienteDTO obgDTO = new PacienteDTO(obj);
		return obgDTO;
	}
	
	public PacienteTotalDTO findTotal(long id) {
		long endId = 0;
		Paciente obj = find(id);
		Endereco endereco = repo.findEnderecos(obj.getEnderecos().getId());
		if (endereco == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + endId + ", Tipo: " + Endereco.class.getName(), null);
		}
		PacienteTotalDTO obgTotalDTO = new PacienteTotalDTO(obj,endereco);
			return obgTotalDTO;
	}
	
	public AnalistaDTO findAnalista(long id){
		Paciente paciente = find(id);
		System.out.println(paciente.getAnalista().getId());
		AnalistaDTO analistaDTO = new AnalistaDTO(repoA.findByID(paciente.getAnalista().getId()));
		return analistaDTO;
	}
	
	public AcompanhanteDTO findAcompanhante(long id){
		Paciente paciente = find(id);
		AcompanhanteDTO obj = new AcompanhanteDTO(repoT.findByID(paciente.getAcompanhante().getId()));
		return obj;
	}
	
	public Paciente insert(Paciente obj) {
		obj = repo.save(obj);
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
	
	public Paciente fromDTO(PacienteNewDTO objDto) {
		
		Paciente paciente = new Paciente(objDto.getPassword(), objDto.getNome(), objDto.getDataNascimento(), objDto.getNomeResponsavel(),
				objDto.getDataNascimentoResponsavel(),objDto.getEmailResponsavel(),objDto.getCpfResponsavel(),objDto.getContatoResponsavel(),
				objDto.getContatoAuxiliar(),objDto.getNivelAltismo());
		
		Endereco endereco = new Endereco(objDto.getLogradouro(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), objDto.getNumero(),paciente,objDto.getCidade(),objDto.getEstado());
		
		paciente.setEnderecos(endereco);
		
		return paciente; 
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
	
	public void delete(long id){
		repo.deleteById(id);	
	}
	
	public void removerAnalista(long id,long idP){
		Paciente obj = find(id);
		Analista analista = repoA.findByID(idP);
		if (analista == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + idP + ", Tipo: " + Analista.class.getName(), null);
		}
		obj.setAcompanhante(null);
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
