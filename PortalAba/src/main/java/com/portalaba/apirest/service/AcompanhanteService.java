package com.portalaba.apirest.service;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portalaba.apirest.domain.Acompanhante;
import com.portalaba.apirest.domain.Endereco;
import com.portalaba.apirest.dto.AcompanhanteNewDTO;
import com.portalaba.apirest.repository.AcompanhanteRepository;


@Service
public class AcompanhanteService {

	@Autowired
	private AcompanhanteRepository repo;
	
	public Acompanhante find(long id) {
		
		Acompanhante obj = repo.findById(id);
		
			if (obj == null) {
				throw new ObjectNotFoundException(
						"Objeto não encontrado! Id: " + id + ", Tipo: " + Acompanhante.class.getName(), null);
			}
			return obj;
	}
	
	public Acompanhante insert(Acompanhante obj) {
		obj = repo.save(obj);
		return obj;
	}
	
	public Acompanhante fromDTO(AcompanhanteNewDTO objDto) {
		Acompanhante acompanhante = new Acompanhante(objDto.getPassword(), objDto.getNome(),objDto.getDataNascimento(), objDto.getTipoAcompanhante(), 
				objDto.getEmailAcompanhante(), objDto.getCpfAcompanhante(), objDto.getContatoAcompanhante(),objDto.getCrpAcompanhante());
		Endereco endereco = new Endereco(objDto.getLogradouro(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), objDto.getNumero(),acompanhante);
		acompanhante.getEnderecos().add(endereco);
		return acompanhante;
	}

	public Acompanhante update(Acompanhante obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(long id){
		repo.deleteById(id);	
	}

	public List<Acompanhante> findAll() {
		return (List<Acompanhante>) repo.findAll();
	}

}
