package com.portalaba.apirest.dto;

import com.portalaba.apirest.domain.Analista;

public class AnalistaDTO {

    private long id; 

    private String nome;
    
    private String email;
    
    private String cpf;
	
	public AnalistaDTO() {
		
	}
	
	public AnalistaDTO(Analista obj) {
		this.id = obj.getId();
		this.email = obj.getCpfAnalista();
		this.nome = obj.getNome();
		this.cpf = obj.getEmailAnalista();
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
		return email;
	}

	public void setEmailAcompanhante(String email) {
		this.email = email;
	}

	public String getCpfAcompanhante() {
		return cpf;
	}

	public void setCpfAcompanhante(String cpf) {
		this.cpf = cpf;
	}
}
