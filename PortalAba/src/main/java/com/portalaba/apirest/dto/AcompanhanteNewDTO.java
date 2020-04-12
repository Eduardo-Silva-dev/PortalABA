package com.portalaba.apirest.dto;

import java.sql.Date;

public class AcompanhanteNewDTO {

    private String password; 

    private String nome;
    
    private Date dataNascimento;

    private String tipoAcompanhante;
    
    private String emailAcompanhante;
    
    private String cpfAcompanhante;
    
    private String contatoAcompanhante;
    
    private Integer crpAcompanhante;
    
    private String logradouro;
	
	private String complemento;
	
	private String bairro;
	
	private String cep;
	
	private String numero;
    
	private Integer cidade;
	
	public AcompanhanteNewDTO() {
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTipoAcompanhante() {
		return tipoAcompanhante;
	}

	public void setTipoAcompanhante(String tipoAcompanhante) {
		this.tipoAcompanhante = tipoAcompanhante;
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

	public String getContatoAcompanhante() {
		return contatoAcompanhante;
	}

	public void setContatoAcompanhante(String contatoAcompanhante) {
		this.contatoAcompanhante = contatoAcompanhante;
	}

	public Integer getCrpAcompanhante() {
		return crpAcompanhante;
	}

	public void setCrpAcompanhante(Integer crpAcompanhante) {
		this.crpAcompanhante = crpAcompanhante;
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

	public Integer getCidade() {
		return cidade;
	}

	public void setCidade(Integer cidade) {
		this.cidade = cidade;
	}
}
