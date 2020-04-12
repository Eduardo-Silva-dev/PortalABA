package com.portalaba.apirest.service;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portalaba.apirest.domain.Analista;
import com.portalaba.apirest.domain.Endereco;
import com.portalaba.apirest.domain.Paciente;
import com.portalaba.apirest.dto.PacienteNewDTO;
import com.portalaba.apirest.repository.PacienteRepository;


@Service
public class PacienteService {

	@Autowired
	private PacienteRepository repo;
	
	public Paciente find(long id) {
		
		Paciente obj = repo.findById(id);
		
			if (obj == null) {
				throw new ObjectNotFoundException(
						"Objeto não encontrado! Id: " + id + ", Tipo: " + Analista.class.getName(), null);
			}
			return obj;
	}
	
	public Paciente insert(Paciente obj) {
		obj = repo.save(obj);
		return obj;
	}
	
	public Paciente fromDTO(PacienteNewDTO objDto) {
		Paciente paciente = new Paciente(objDto.getPassword(), objDto.getNome(), objDto.getDataNascimento(), objDto.getNomePai(),
				objDto.getNomeMae(),objDto.getDataNascimentoPai(),objDto.getDataNascimentoMae(),objDto.getEmailResponsavel(),
				objDto.getCpfPaciente(),objDto.getCpfPai(),objDto.getCpfMae(),objDto.getContatoPaciente(),objDto.getContatoPai(),objDto.getContatoMae(),null,null);
		Endereco endereco = new Endereco(objDto.getLogradouro(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), objDto.getNumero(),paciente);
		paciente.getEnderecos().add(endereco);
		return paciente; 
	}

	public Paciente update(Paciente obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(long id){
		repo.deleteById(id);	
	}

	public List<Paciente> findAll() {
		return (List<Paciente>) repo.findAll();
	}

}
