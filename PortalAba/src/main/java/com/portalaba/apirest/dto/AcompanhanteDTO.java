package com.portalaba.apirest.dto;

import com.portalaba.apirest.domain.Acompanhante;

public class AcompanhanteDTO {

    private long id; 

    private String nome;
    
    private String emailAcompanhante;
    
    private String cpfAcompanhante;
    
    private String perfil;
  
    private byte[] image;

	public AcompanhanteDTO() {
		
	}

	public AcompanhanteDTO(Acompanhante obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.emailAcompanhante = obj.getEmailAcompanhante();
		this.cpfAcompanhante = obj.getCpfAcompanhante();
		this.perfil = obj.getPerfil();
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

	public byte[] getImage() {
			return image;
	}

	public void setImage(byte[] img) {
		this.image = img;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
}
