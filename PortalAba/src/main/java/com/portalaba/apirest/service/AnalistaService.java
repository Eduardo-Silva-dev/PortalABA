package com.portalaba.apirest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.portalaba.apirest.repository.AnalistaRepository;


@Service
public class AnalistaService {

	@Autowired
	private AnalistaRepository repo;
	
	public AnalistaTotalDTO findTotal(long id) {
		long endId = 0;
		Analista obj = repo.findByID(id);
		for (int i =0;i<1;i++) {
			endId = obj.getEnderecos().get(i).getId();
		}
		Endereco endereco = repo.findEnderecos(endId);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Analista.class.getName(), null);
		}
		AnalistaTotalDTO obgTotalDTO = new AnalistaTotalDTO(obj,endereco);
			return obgTotalDTO;
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
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Analista.class.getName(), null);
		}
		AnalistaDTO obgDTO = new AnalistaDTO(obj);
		return obgDTO;
	}
	
	public Analista insert(Analista obj) {
		obj = repo.save(obj);
		return obj;
	}
	
	public Analista fromDTO(AnalistaNewDTO objDto) {
		Analista analista = new Analista(objDto.getPassword(), objDto.getNome(), objDto.getDataNascimento(), objDto.getTipoAnalista(), 
				objDto.getEmailAnalista(), objDto.getCpfAnalista(), objDto.getContatoAnalista(),objDto.getCrpAnalista(), objDto.getCnpjAnalista());
		Endereco endereco = new Endereco(objDto.getLogradouro(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), objDto.getNumero(),objDto.getCidade(),objDto.getEstado(),analista);
		analista.getEnderecos().add(endereco);
		return analista;
	}

	public Analista update(Analista obj,long id) {
		obj.setId(id);
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(long id){
		repo.deleteById(id);	
	}

	public List<Analista> findAll() {
		return (List<Analista>) repo.findAll();
	}

	public List<PacienteDTO> findAllPacientes(long id) {
		List<Paciente> list= repo.findAllPacientes(id);
		List<PacienteDTO> listDto = list.stream().map(obj -> new PacienteDTO(obj)).collect(Collectors.toList()); 
		return listDto ;
	}

	public List<AcompanhanteDTO> findAllAcompanhantes(long id) {
		List<Acompanhante> list = repo.findAllAcompanhantes(id);
		List<AcompanhanteDTO> listDto = list.stream().map(obj -> new AcompanhanteDTO(obj)).collect(Collectors.toList()); 
		return listDto ;
	}

}
