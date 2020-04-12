package com.portalaba.apirest.service;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portalaba.apirest.domain.Analista;
import com.portalaba.apirest.domain.Endereco;
import com.portalaba.apirest.dto.AnalistaNewDTO;
import com.portalaba.apirest.repository.AnalistaRepository;


@Service
public class AnalistaService {

	@Autowired
	private AnalistaRepository repo;
	
	public Analista find(long id) {
		
	    Analista obj = repo.findById(id);
		
			if (obj == null) {
				throw new ObjectNotFoundException(
						"Objeto não encontrado! Id: " + id + ", Tipo: " + Analista.class.getName(), null);
			}
			return obj;
	}
	
	public Analista insert(Analista obj) {
		obj = repo.save(obj);
		return obj;
	}
	
	public Analista fromDTO(AnalistaNewDTO objDto) {
		Analista analista = new Analista(objDto.getPassword(), objDto.getNome(), objDto.getDataNascimento(), objDto.getTipoAnalista(), 
				objDto.getEmailAnalista(), objDto.getCpfAnalista(), objDto.getContatoAnalista(),objDto.getCrpAnalista(), objDto.getCnpjAnalista());
		Endereco endereco = new Endereco(objDto.getLogradouro(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), objDto.getNumero(),analista);
		analista.getEnderecos().add(endereco);
		return analista;
	}

	public Analista update(Analista obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(long id){
		repo.deleteById(id);	
	}

	public List<Analista> findAll() {
		return (List<Analista>) repo.findAll();
	}

}
