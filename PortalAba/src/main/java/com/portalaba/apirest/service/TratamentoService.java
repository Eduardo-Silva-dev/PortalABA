package com.portalaba.apirest.service;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.portalaba.apirest.domain.Acompanhante;
import com.portalaba.apirest.domain.Paciente;
import com.portalaba.apirest.domain.Tratamento;

import com.portalaba.apirest.dto.TratamentoNewDTO;

import com.portalaba.apirest.repository.AcompanhanteRepository;
import com.portalaba.apirest.repository.PacienteRepository;
import com.portalaba.apirest.repository.TratamentoRepository;

@Service
public class TratamentoService {
	
	@Autowired
	private TratamentoRepository tratamentoRepository;
	
	@Autowired
	private PacienteRepository repoP;
	
	@Autowired
	private AcompanhanteRepository repoA;
	
	public String findEnd(long id) {
	
		Tratamento tratamento = tratamentoRepository.findByID(id);
		
		return tratamento.getFile();
	}
	
	
	public Tratamento fromDTO (TratamentoNewDTO objDto,long id,MultipartFile file) {
		
		Tratamento tratamento = new Tratamento(id,objDto.getAcompanhante(),objDto.getPaciente(),objDto.getNome());
		
		tratamentoRepository.save(tratamento);
		
		String caminho = insertPDF(file,String.valueOf(tratamento.getId()));
		
		tratamento.setFile(caminho);
		
		tratamentoRepository.save(tratamento);
		
		Paciente paciente = repoP.findByID(objDto.getPaciente());
		
		Acompanhante acompanhante = repoA.findByID(objDto.getAcompanhante());
		
		//emailService.sendOrderConfirmationEmail(tratamento,acompanhante.getEmailAcompanhante(),paciente.getNome());
		
		return tratamento;
	}
	
	private String insertPDF (MultipartFile file,String nome) {
		
		Path path = Paths.get("C:/Users/Eduardo/git/PortalABA/PortalAba/src/main/resources/tratamentos/"  + nome +".pdf");
		
		try {
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String nomeArquivo = path.toString();
		
		return nomeArquivo;	
	}
	
	public Tratamento fromDTOR (TratamentoNewDTO objDto,long id,MultipartFile file) {
		
		Tratamento tratamento = new Tratamento(id,objDto.getAcompanhante(),objDto.getPaciente(),objDto.getNome());
		
		tratamentoRepository.save(tratamento);
		
		String caminho = retornoTratamentoPDF(file,String.valueOf(tratamento.getId()));
		
		tratamento.setFile(caminho);
		
		tratamentoRepository.save(tratamento);
		
		Paciente paciente = repoP.findByID(objDto.getPaciente());
		
		Acompanhante acompanhante = repoA.findByID(objDto.getAcompanhante());
		
		//emailService.sendOrderConfirmationEmail(tratamento,acompanhante.getEmailAcompanhante(),paciente.getNome());
		
		return tratamento;
	}
	
	private String retornoTratamentoPDF (MultipartFile file,String nome) {
		
		Path path = Paths.get("C:/Users/Eduardo/git/PortalABA/PortalAba/src/main/resources/retorno-tratamento/"  + nome +".pdf");
		
		try {
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String nomeArquivo = path.toString();
		
		return nomeArquivo;	
	}
	
	public Tratamento fromDTOMP4 (TratamentoNewDTO objDto,long id,MultipartFile file) {
		
		Tratamento tratamento = new Tratamento(id,objDto.getAcompanhante(),objDto.getPaciente(),objDto.getNome());
		
		tratamentoRepository.save(tratamento);
		
		String caminho = insertMP4(file,String.valueOf(tratamento.getId()));
		
		tratamento.setFile(caminho);
		
		tratamentoRepository.save(tratamento);
		
		Paciente paciente = repoP.findByID(objDto.getPaciente());
		
		Acompanhante acompanhante = repoA.findByID(objDto.getAcompanhante());
		
		//emailService.sendOrderConfirmationEmail(tratamento,acompanhante.getEmailAcompanhante(),paciente.getNome());
		
		return tratamento;
	}
			
	private String insertMP4 (MultipartFile file,String nome) {
		
		Path path = Paths.get("C:/Users/Eduardo/git/PortalABA/PortalAba/src/main/resources/tratamento-video/"  + nome +".mp4");
		
		try {
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String nomeArquivo = path.toString();
		
		return nomeArquivo;
	}
	
	public Tratamento fromDTORelatorio (TratamentoNewDTO objDto,long id,MultipartFile file) {
		
		Tratamento tratamento = new Tratamento(id,objDto.getAcompanhante(),objDto.getPaciente(),objDto.getNome());
		
		tratamentoRepository.save(tratamento);
		
		String caminho = RelatorioAnalistaPaciente(file,String.valueOf(tratamento.getId()));
		
		tratamento.setFile(caminho);
		
		tratamentoRepository.save(tratamento);
		
		Paciente paciente = repoP.findByID(objDto.getPaciente());
		
		Acompanhante acompanhante = repoA.findByID(objDto.getAcompanhante());
		
		//emailService.sendOrderConfirmationEmail(tratamento,acompanhante.getEmailAcompanhante(),paciente.getNome());
		
		return tratamento;
	}
	
	private String RelatorioAnalistaPaciente (MultipartFile file,String nome) {
		
		Path path = Paths.get("C:/Users/Eduardo/git/PortalABA/PortalAba/src/main/resources/relatorio/"  + nome +".pdf");
		
		try {
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String nomeArquivo = path.toString();
		
		return nomeArquivo;	
	}

}
