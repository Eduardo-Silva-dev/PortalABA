package com.portalaba.apirest.service;

import com.portalaba.apirest.service.exception.ObjectNotFoundException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
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
import com.portalaba.apirest.repository.PacienteRepository;

@Service
public class AcompanhanteService {

	@Autowired
	private AcompanhanteRepository repo;
	
	@Autowired
	private AnalistaRepository repoA;
	
	@Autowired
	private PacienteRepository repoP;
	
	public Page<Acompanhante> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public Page<PacienteDTO> findAllPacientes(long id,Pageable pageable) throws IOException {
		find(id);
		Page<Paciente> paciente = repo.findAllPacientes(id,pageable);
		Page<PacienteDTO> listDto = paciente.map(obj -> new PacienteDTO(obj));  
		for (PacienteDTO p : listDto){
			File img = new File(p.getImage().toString());
			FileInputStream fis = new FileInputStream(img);
			byte[] data = new byte[fis.available()];
			fis.read(data);
			p.setImage(data);
		}
		return  listDto; 
	}

	public Page<AnalistaDTO> findAllAnalistas(long id,Pageable pageable) throws IOException {
		find(id);
		Page<Analista> analista = repo.findAllAnalistas(id,pageable);
		Page<AnalistaDTO> listDto = analista.map(obj -> new AnalistaDTO(obj));  
		for (AnalistaDTO p : listDto){
			File img = new File(p.getImage().toString());
			FileInputStream fis = new FileInputStream(img);
			byte[] data = new byte[fis.available()];
			fis.read(data);
			p.setImage(data);
		}
		return listDto ;
	}
	
	public Acompanhante find(long id) {
		Acompanhante obj =  repo.findByID(id);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Acompanhante.class.getName(), null);
		}
				return obj;
	}
	
	public AcompanhanteDTO findParcial(long id) throws IOException {
		Acompanhante obj = find(id);
		AcompanhanteDTO obgDTO = new AcompanhanteDTO(obj);
		if(obj.getImage() != null) {
			File img = new File(obj.getImage().toString());
			FileInputStream fis = new FileInputStream(img);
			byte[] data = new byte[fis.available()];
			fis.read(data);
			obgDTO.setImage(data);}
		return obgDTO;
	}
	
	public AcompanhanteTotalDTO findTotal(long id) {
		Acompanhante obj = find(id);
		Endereco endereco = repo.findEnderecos(obj.getEnderecos().getId());
		if (endereco == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Endereco.class.getName(), null);
		}
		AcompanhanteTotalDTO objTotalDTO = new AcompanhanteTotalDTO(obj, endereco);
		return objTotalDTO;
	}
	
	public Acompanhante insert(Acompanhante obj,MultipartFile file) {
		obj = repo.save(obj);
		if(file == null) { return obj; }
		Path path = Paths.get("C:/Users/Eduardo/git/PortalABA/PortalAba/src/main/resources/imagensCadastro/acompanhante/"  + obj.getCpfAcompanhante()+".jpg");
		try {
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		obj.setImage(path.toString());
		return obj;
	}
	
	public Acompanhante fromDTO(AcompanhanteNewDTO objDto) {
		
		Acompanhante acompanhante = new Acompanhante(objDto.getPassword(),objDto.getNome(),objDto.getDataNascimento(),objDto.getTipoAcompanhante(), 
		objDto.getEmailAcompanhante(),objDto.getCpfAcompanhante(),objDto.getContatoAcompanhante(),objDto.getCrpAcompanhante());
		
		Endereco endereco = new Endereco(objDto.getLogradouro(),objDto.getComplemento(),objDto.getBairro(),objDto.getCep(),
		objDto.getNumero(),objDto.getCidade(),objDto.getEstado(),acompanhante);
		
		acompanhante.setEnderecos(endereco);
		
		return acompanhante;
	}

	public Acompanhante update(Acompanhante obj,long id) {
		obj.setId(id);
		Acompanhante end = find(obj.getId());
		obj.getEnderecos().setId(end.getEnderecos().getId());
		return repo.save(obj);
	}
	
	public Acompanhante updateImage(long id,MultipartFile file) {
		Acompanhante obj = find(id);
		Path path = Paths.get("C:/Users/Eduardo/git/PortalABA/PortalAba/src/main/resources/imagensCadastro/acompanhante/"  + obj.getCpfAcompanhante()+".jpg");
		try {
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		obj.setImage(path.toString());
		return repo.save(obj);
	}
	
	public Acompanhante insertAnalista(long id,long idA) {
		Acompanhante obj = find(id);
		Analista analista = repoA.findByID(idA);
		if (analista == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Analista.class.getName(), null);
		}
		Analista analist = repo.findAnalista(id);
		if (analist != null) {
			throw new ObjectNotFoundException(
					"Analista já inserido! Id: " + id + ", Tipo: " + Analista.class.getName(), null);
		}
		obj.getAnalistas().add(analista);
		analista.getAcompanhantes().add(obj);
		repoA.save(analista);
		return repo.save(obj);
	}

	public Acompanhante insertPaciente(long id,long idA) {
		Acompanhante obj = find(id);
		Paciente paciente = repoP.findByID(idA);
		if (paciente == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Paciente.class.getName(), null);
		}

		Paciente pacient = repo.findPaciente(id);
		if (pacient != null) {
			throw new ObjectNotFoundException(
					"Paciente já inserido! Id: " + id + ", Tipo: " + Paciente.class.getName(), null);
		}
		obj.getPacientes().add(paciente);
		paciente.setAcompanhante(obj);
		repoP.save(paciente);
		return repo.save(obj);
	}
	
	public void delete(long id){
		repo.deleteById(id);	
	}
	
	public void removerPaciente(long id,long idP){
		Acompanhante obj = find(id);
		Paciente paciente = repoP.findByID(idP);
		if (paciente == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + idP + ", Tipo: " + Paciente.class.getName(), null);
		}
		obj.getPacientes().remove(paciente);
		paciente.setAcompanhante(null);
		repo.save(obj);
		repoP.save(paciente);
	}
	
	public void removerAnalista(long id,long idA){
		Acompanhante obj = find(id);
		Analista analista = repoA.findByID(idA);
		if (analista == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + idA + ", Tipo: " + Analista.class.getName(), null);
		}
		obj.getAnalistas().remove(analista);
		analista.getAcompanhantes().remove(obj);
		repo.save(obj);
		repoA.save(analista);
	}
}
