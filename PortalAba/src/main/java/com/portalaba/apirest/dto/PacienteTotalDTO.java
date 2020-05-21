package com.portalaba.apirest.dto;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.portalaba.apirest.domain.Endereco;
import com.portalaba.apirest.domain.Paciente;

public class PacienteTotalDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

    private long id; 
    
    private String password; 

    private String nome;
    
    private LocalDate dataNascimento;
    
    private String nomeResponsavel;
    
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataNascimentoResponsavel;
    
    private String emailResponsavel;
    
    private String cpfResponsavel;
    
    private String contatoResponsavel;
    
    private String contatoAuxiliar;
    
    private String logradouro;
	
	private String complemento;
	
	private String bairro;
	
	private String cep;
	
	private String numero;
    
	private String cidade;
	
	private String estado;
	
	private String nivelAltismo;
    
	
	public PacienteTotalDTO() {
		
	}

	public PacienteTotalDTO(Paciente obj,Endereco endereco) {
		super();
		this.id = obj.getId();
		this.password = obj.getPassword();
		this.nome = obj.getNome();
		this.dataNascimento = obj.getDataNascimento();
		this.nomeResponsavel = obj.getNomeResponsavel();
		this.dataNascimentoResponsavel = obj.getDataNascimentoResponsavel();
		this.emailResponsavel = obj.getEmailResponsavel();
		this.cpfResponsavel = obj.getCpfResponsavel();
		this.contatoResponsavel = obj.getContatoResponsavel();
		this.contatoAuxiliar = obj.getContatoAuxiliar();
		this.bairro = endereco.getBairro();
		this.cep = endereco.getCep();
		this.cidade = endereco.getCidade();
		this.complemento = endereco.getComplemento();
		this.estado = endereco.getEstado();
		this.logradouro = endereco.getLogradouro();
		this.numero = endereco.getNumero();
		this.nivelAltismo = obj.getNivelAltismo();
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public Date getDataNascimentoResponsavel() {
		return dataNascimentoResponsavel;
	}

	public void setDataNascimentoResponsavel(Date dataNascimentoResponsavel) {
		this.dataNascimentoResponsavel = dataNascimentoResponsavel;
	}

	public String getEmailResponsavel() {
		return emailResponsavel;
	}

	public void setEmailResponsavel(String emailResponsavel) {
		this.emailResponsavel = emailResponsavel;
	}

	public String getCpfResponsavel() {
		return cpfResponsavel;
	}

	public void setCpfResponsavel(String cpfResponsavel) {
		this.cpfResponsavel = cpfResponsavel;
	}

	public String getContatoResponsavel() {
		return contatoResponsavel;
	}

	public void setContatoResponsavel(String contatoResponsavel) {
		this.contatoResponsavel = contatoResponsavel;
	}

	public String getContatoAuxiliar() {
		return contatoAuxiliar;
	}

	public void setContatoAuxiliar(String contatoAuxiliar) {
		this.contatoAuxiliar = contatoAuxiliar;
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

	public String getNivelAltismo() {
		return nivelAltismo;
	}

	public void setNivelAltismo(String nivelAltismo) {
		this.nivelAltismo = nivelAltismo;
	}
}
