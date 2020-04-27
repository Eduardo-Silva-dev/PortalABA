package com.portalaba.apirest.service;

import com.portalaba.apirest.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portalaba.apirest.domain.Analista;
import com.portalaba.apirest.domain.Endereco;
import com.portalaba.apirest.dto.AcompanhanteDTO;
import com.portalaba.apirest.dto.AnalistaDTO;
import com.portalaba.apirest.dto.AnalistaNewDTO;
import com.portalaba.apirest.dto.AnalistaTotalDTO;
import com.portalaba.apirest.dto.PacienteDTO;
import com.portalaba.apirest.repository.AnalistaRepository;

@Service
public class AnalistaService {

	@Autowired
	private AnalistaRepository repo;
	
	public Page<Analista> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public Page<PacienteDTO> findAllPacientes(long id,Pageable pageable) {
		find(id);
		return repo.findAllPacientes(id,pageable);
	}

	public Page<AcompanhanteDTO> findAllAcompanhantes(long id,Pageable pageable) {
		find(id);
		return repo.findAllAcompanhantes(id,pageable);
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
	
	public void delete(long id){
		repo.deleteById(id);	
	}

}
