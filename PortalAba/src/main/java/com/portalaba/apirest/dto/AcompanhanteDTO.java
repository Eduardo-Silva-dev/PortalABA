package com.portalaba.apirest.dto;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.portalaba.apirest.domain.Acompanhante;

public class AcompanhanteDTO {

    private long id; 

    private String nome;
    
    private String emailAcompanhante;
    
    private String cpfAcompanhante;
    
    private File img = null;
	
	public AcompanhanteDTO() {
		
	}
	
	public AcompanhanteDTO(Acompanhante obj) {
		this.id = obj.getId();
		this.cpfAcompanhante = obj.getCpfAcompanhante();
		this.nome = obj.getNome();
		this.emailAcompanhante = obj.getEmailAcompanhante();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmailAcompanhante() {
		return emailAcompanhante;
	}

	public void setEmailAcompanhante(String emailAcompanhante) {
		this.emailAcompanhante = emailAcompanhante;
	}

	public String getCpfAcompanhante() {
		return cpfAcompanhante;
	}

	public void setCpfAcompanhante(String cpfAcompanhante) {
		this.cpfAcompanhante = cpfAcompanhante;
	}

	public byte[] getImg() {
		 if(img != null) {
			try {
				return Files.readAllBytes(img.toPath());
			} catch (IOException e) {
				return null;
			}
		 }
	  return null;
	}

	public void setImg(File img) {
		this.img = img;
	}
}
