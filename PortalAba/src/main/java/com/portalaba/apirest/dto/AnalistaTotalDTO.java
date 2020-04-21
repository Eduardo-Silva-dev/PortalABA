package com.portalaba.apirest.dto;

import java.io.Serializable;
import java.sql.Date;
import com.portalaba.apirest.domain.Analista;

public class AnalistaTotalDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

    private long id; 
    
    private String password; 

    private String nome;
    
    private Date dataNascimento;

    private String tipoAnalista;
    
    private String emailAnalista;
    
    private String cpfAnalista;

    private String contatoAnalista;
    
    private Integer crpAnalista;
    
    private String cnpjAnalista;
    
    private String logradouro;
	
	private String complemento;
	
	private String bairro;
	
	private String cep;
	
	private String numero;
    
	private String cidade;
    
	private String estado;
	
	public AnalistaTotalDTO() {
		
	}

	public AnalistaTotalDTO(Analista obj) {
		super();
		this.id = obj.getId();
		this.password = obj.getPassword();
		this.nome = obj.getNome();
		this.dataNascimento = obj.getDataNascimento();
		this.tipoAnalista = obj.getTipoAnalista();
		this.emailAnalista = obj.getEmailAnalista();
		this.cnpjAnalista = obj.getCnpjAnalista();
		this.cpfAnalista = obj.getCpfAnalista();
		this.contatoAnalista = obj.getContatoAnalista();
		this.crpAnalista = obj.getCrpAnalista();
//		this.logradouro = obj.getEnderecos().getLogradouro();
//		this.complemento = obj.getEnderecos().getComplemento();
//		this.bairro = obj.getEnderecos().getBairro();
//		this.cep = obj.getEnderecos().getCep();
//		this.numero = obj.getEnderecos().getNumero();
//		this.cidade = obj.getEnderecos().getCidade();
//		this.estado = obj.getEnderecos().getEstado();
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

	public String getTipoAnalista() {
		return tipoAnalista;
	}

	public void setTipoAnalista(String tipoAnalista) {
		this.tipoAnalista = tipoAnalista;
	}

	public String getEmailAnalista() {
		return emailAnalista;
	}

	public void setEmailAnalista(String emailAnalista) {
		this.emailAnalista = emailAnalista;
	}

	public String getCpfAnalista() {
		return cpfAnalista;
	}
	
	public String getCnpjAnalista() {
		return cnpjAnalista;
	}

	public void setCnpjAnalista(String cnpjAnalista) {
		this.cnpjAnalista = cnpjAnalista;
	}

	public void setCpfAnalista(String cpfAnalista) {
		this.cpfAnalista = cpfAnalista;
	}

	public String getContatoAnalista() {
		return contatoAnalista;
	}

	public void setContatoAnalista(String contatoAnalista) {
		this.contatoAnalista = contatoAnalista;
	}

	public Integer getCrpAnalista() {
		return crpAnalista;
	}

	public void setCrpAnalista(Integer crpAnalista) {
		this.crpAnalista = crpAnalista;
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
