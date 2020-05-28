package com.portalaba.apirest.dto;

import com.portalaba.apirest.domain.Analista;

public class AnalistaDTO {

    private long id; 

    private String nome;
    
    private String email;
    
    private String cpf;
    
    private byte[] image;
	
	public AnalistaDTO() {
		
	}
	
	public AnalistaDTO(Analista obj) {
		this.id = obj.getId();
		this.email = obj.getEmailAnalista();
		this.nome = obj.getNome();
		this.cpf = obj.getCpfAnalista();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public byte[] getImage() {
	  return image;
	}

	public void setImage(byte[] img) {
		this.image = img;
	}
}
