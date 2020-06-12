package com.portalaba.apirest.dto;

import com.portalaba.apirest.domain.Empresa;

public class EmpresaDTO {

	private long id;  

    private String password; 

	private String cnpj;	

	private	String razao_social;	

	private	String nome_fantasia;	

	private	String contato;

	private	String telefone;

	private	String celular;

	private	String email;

	private	String perfil;

	public EmpresaDTO() {
		super();
	}

	public EmpresaDTO(Empresa empresa) {
		super();
		this.id = empresa.getId();
		this.password = empresa.getPassword();
		this.cnpj = empresa.getCnpj();
		this.razao_social = empresa.getRazao_social();
		this.nome_fantasia = empresa.getNome_fantasia();
		this.contato = empresa.getContato();
		this.telefone = empresa.getTelefone();
		this.celular = empresa.getCelular();
		this.email = empresa.getEmail();
		this.perfil = empresa.getPerfil();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazao_social() {
		return razao_social;
	}

	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}

	public String getNome_fantasia() {
		return nome_fantasia;
	}

	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
}
