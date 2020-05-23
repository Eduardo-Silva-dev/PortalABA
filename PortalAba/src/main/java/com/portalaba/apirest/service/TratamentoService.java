package com.portalaba.apirest.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.portalaba.apirest.dto.TratamentoNewDTO;
import com.portalaba.apirest.repository.AcompanhanteRepository;
import com.portalaba.apirest.repository.AnalistaRepository;
import com.portalaba.apirest.repository.PacienteRepository;
import com.portalaba.apirest.repository.TratamentoRepository;
import com.portalaba.apirest.domain.Acompanhante;
import com.portalaba.apirest.domain.Analista;
import com.portalaba.apirest.domain.Paciente;
import com.portalaba.apirest.domain.Tratamento;

@Service
public class TratamentoService {

	@Autowired
	private PacienteRepository repoP;
	
	@Autowired
	private AnalistaRepository repoA;
	
	@Autowired
	private AcompanhanteRepository repoT;
	
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private TratamentoRepository repo;
	
//	public Tratamento insert (TratamentoNewDTO tratamentoNewDTO , long id,MultipartFile file) {
//		Acompanhante acompanhante = repoT.findByID(tratamentoNewDTO.getAcompanhante());
//		long pacienteID = tratamentoNewDTO.getPaciente();
//		System.out.println(pacienteID);
//		Paciente paciente = pacienteService.find(pacienteID);
//		String nomeArquivo = id+"-"+paciente.getCpfResponsavel();
//		String caminho = insertImage(file, nomeArquivo);
//		Tratamento tratamento = new Tratamento(id,caminho);
//		return tratamento;
//	}
	
	private String insertImage (MultipartFile file,String nome) {
		if(file != null) {
			Path path = Paths.get("C:/Users/Eduardo/git/PortalABA/PortalAba/src/main/resources/tratamentos/"  + nome +".jpg");
			try {
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
			}
			String nomeArquivo = path.toString();
			return nomeArquivo;
			}
		String nomeA = "C:/Users/Eduardo/git/PortalABA/PortalAba/src/main/resources/tratamentos/"  + nome +".jpg" ;
		return nomeA;
	}
	
	public void save (Tratamento tratamento) {
		repo.save(tratamento);
	}
}
