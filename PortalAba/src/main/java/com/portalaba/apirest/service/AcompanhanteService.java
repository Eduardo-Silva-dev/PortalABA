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
import com.portalaba.apirest.dto.AcompanhanteNewDTO;
import com.portalaba.apirest.dto.AcompanhanteTotalDTO;
import com.portalaba.apirest.dto.AnalistaDTO;
import com.portalaba.apirest.dto.PacienteDTO;
import com.portalaba.apirest.repository.AcompanhanteRepository;
import com.portalaba.apirest.repository.AnalistaRepository;


@Service
public class AcompanhanteService {

	@Autowired
	private AcompanhanteRepository repo;
	
	@Autowired
	private AnalistaRepository repoA;
	
	public AcompanhanteTotalDTO findTotal(long id) {
		Acompanhante obj = repo.findByID(id);
		Endereco endereco = repo.findEnderecos(repo.findByID(id));
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Acompanhante.class.getName(), null);
		}
		
		System.out.print(obj.getEnderecos().getClass().toString());
		AcompanhanteTotalDTO objTotalDTO = new AcompanhanteTotalDTO(obj);
		
			return objTotalDTO;
	}
	
	public Acompanhante find(long id) {
		Acompanhante obj =  repo.findByID(id);
				if (obj == null) {
					throw new ObjectNotFoundException(
							"Objeto não encontrado! Id: " + id + ", Tipo: " + Acompanhante.class.getName(), null);
				}
					return obj;
	}
	
	public AcompanhanteDTO findParcial(long id) {
		Acompanhante obj = repo.findByID(id);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Acompanhante.class.getName(), null);
		}
		AcompanhanteDTO obgDTO = new AcompanhanteDTO(obj);
		return obgDTO;
	}
	
	public Acompanhante insert(Acompanhante obj) {
		obj = repo.save(obj);
		return obj;
	}
	
	public Acompanhante fromDTO(AcompanhanteNewDTO objDto) {
		Analista analista = repoA.findByID(objDto.getAnalista());
		
		Acompanhante acompanhante = new Acompanhante(objDto.getPassword(),objDto.getNome(),objDto.getDataNascimento(),objDto.getTipoAcompanhante(), 
		objDto.getEmailAcompanhante(),objDto.getCpfAcompanhante(),objDto.getContatoAcompanhante(),objDto.getCrpAcompanhante(),analista);
		
		Endereco endereco = new Endereco(objDto.getLogradouro(),objDto.getComplemento(),objDto.getBairro(),objDto.getCep(),
		objDto.getNumero(),objDto.getCidade(),objDto.getEstado(),acompanhante);
		
		acompanhante.getAnalistas().add(analista);
		acompanhante.getEnderecos().add(endereco);
		
		return acompanhante;
	}

	public Acompanhante update(Acompanhante obj,long id) {
		obj.setId(id);
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(long id){
		repo.deleteById(id);	
	}

	public List<Acompanhante> findAll() {
		return (List<Acompanhante>) repo.findAll();
	}

	public List<PacienteDTO> findAllPacientes(long id) {
		List<Paciente> list = repo.findAllPacientes(id);
		List<PacienteDTO> listDto = list.stream().map(obj -> new PacienteDTO(obj)).collect(Collectors.toList()); 
		return listDto ;
	}

	public List<AnalistaDTO> findAllAnalistas(long id) {
		List<Analista> list = repo.findAllAnalistas(id);
		List<AnalistaDTO> listDto = list.stream().map(obj -> new AnalistaDTO(obj)).collect(Collectors.toList()); 
		return listDto ;
	}

}
