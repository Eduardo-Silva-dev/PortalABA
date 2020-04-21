package com.portalaba.apirest.dto;

import java.io.Serializable;
import java.sql.Date;

import com.portalaba.apirest.domain.Acompanhante;
import com.portalaba.apirest.domain.Endereco;

public class AcompanhanteTotalDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

    private long id; 
    
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
    
	private String cidade;
	
	private String estado;
	
	public AcompanhanteTotalDTO() {
		
	}

	public AcompanhanteTotalDTO(Acompanhante obj, Endereco endereco) {
		super();
		this.id = obj.getId();
		this.password = obj.getPassword();
		this.nome = obj.getNome();
		this.dataNascimento = obj.getDataNascimento();
		this.tipoAcompanhante = obj.getTipoAcompanhante();
		this.emailAcompanhante = obj.getEmailAcompanhante();
		this.cpfAcompanhante = obj.getCpfAcompanhante();
		this.contatoAcompanhante = obj.getContatoAcompanhante();
		this.crpAcompanhante = obj.getCrpAcompanhante();
		this.bairro = endereco.getBairro();
		this.cep = endereco.getCep();
		this.cidade = endereco.getCidade();
		this.complemento = endereco.getComplemento();
		this.estado = endereco.getEstado();
		this.logradouro = endereco.getLogradouro();
		this.numero = endereco.getNumero();
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
