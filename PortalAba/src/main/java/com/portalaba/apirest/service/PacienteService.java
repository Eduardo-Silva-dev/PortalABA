package com.portalaba.apirest.service;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	public PacienteTotalDTO findTotal(long id) {
		Paciente obj = find(id);
		
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Paciente.class.getName(), null);
		}
		PacienteTotalDTO obgTotalDTO = new PacienteTotalDTO(obj);
			return obgTotalDTO;
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
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Paciente.class.getName(), null);
		}
		PacienteDTO obgDTO = new PacienteDTO(obj);
		return obgDTO;
	}
	
	public Paciente insert(Paciente obj) {
		obj = repo.save(obj);
		return obj;
	}
	
	public AnalistaDTO findAnalista(long id){
		Paciente paciente = repo.findByID(id);
		long idA = paciente.getAnalista().getId();
		AnalistaDTO analistaDTO = new AnalistaDTO(repoA.findByID(idA));
		return analistaDTO;
	}
	
	public AcompanhanteDTO findAcompanhante(long id){
		Paciente paciente = repo.findByID(id);
		long idT = paciente.getAcompanhante().getId();
		AcompanhanteDTO obj = new AcompanhanteDTO(repoT.findByID(idT));
		return obj;
	}
	
	public Paciente fromDTO(PacienteNewDTO objDto) {
		Analista analista = repoA.findByID(objDto.getAnalista());
		
		Acompanhante acompanhante = repoT.findByID(objDto.getAcompanhante());
		
		Paciente paciente = new Paciente(objDto.getPassword(), objDto.getNome(), objDto.getDataNascimento(), objDto.getNomePai(),
				objDto.getNomeMae(),objDto.getDataNascimentoPai(),objDto.getDataNascimentoMae(),objDto.getEmailResponsavel(),
				objDto.getCpfPaciente(),objDto.getCpfPai(),objDto.getCpfMae(),objDto.getContatoPaciente(),objDto.getContatoPai(),objDto.getContatoMae(),analista,acompanhante);
		
		Endereco endereco = new Endereco(objDto.getLogradouro(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), objDto.getNumero(),paciente,objDto.getCidade(),objDto.getEstado());
		
		paciente.getEnderecos().add(endereco);
		
		return paciente; 
	}

	public Paciente update(Paciente obj,long id) {
		obj.setId(id);
		find(obj.getId());
		return repo.save(obj);
	}
	
	public Paciente inserirAcompanhante(long idP, long idA) {
		Paciente paciente = find(idP);
		Acompanhante acompanhante = repoT.findByID(idA);
		paciente.setAcompanhante(acompanhante);
		return paciente;
	}

	public void delete(long id){
		repo.deleteById(id);	
	}

	public List<Paciente> findAll() {
		return (List<Paciente>) repo.findAll();
	}
}
