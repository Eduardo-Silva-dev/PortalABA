package com.portalaba.apirest.dto;

import com.portalaba.apirest.domain.Empresa;

public class EmpresaTotalDTO {
	
	private long id;  

    private String password; 

	private String cnpj;	

	private	String razao_social;	

	private	String nome_fantasia;	

	private	String contato;

	private	String telefone;

	private	String celular;

	private	String email;
	
	private String logradouro;
		
	private String complemento;
	
	private String bairro;
	
	private String cep;
	
	private String numero;
    
	private String cidade;
    
	private String estado;

	public EmpresaTotalDTO() {
		super();
	}

	public EmpresaTotalDTO(Empresa empresa) {
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
		this.bairro = empresa.getEnderecos().getBairro();
		this.cep = empresa.getEnderecos().getCep();
		this.cidade = empresa.getEnderecos().getCidade();
		this.complemento = empresa.getEnderecos().getComplemento();
		this.estado = empresa.getEnderecos().getEstado();
		this.logradouro = empresa.getEnderecos().getLogradouro();
		this.numero = empresa.getEnderecos().getNumero();
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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}