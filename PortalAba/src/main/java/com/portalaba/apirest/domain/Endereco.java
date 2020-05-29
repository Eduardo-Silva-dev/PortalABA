package com.portalaba.apirest.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Endereco implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	@Column(name = "logradouro")
	private String logradouro;
	
	@Column(name = "complemento")
	private String complemento;
	
	@NotEmpty
	@Column(name = "bairro")
	private String bairro;
	
	@NotEmpty
	@Column(name = "cep")
	private String cep;
	
	@Column(name = "numero")
	private String numero;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="acompanhante")
	private Acompanhante acompanhante;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="analista_id")
	private Analista analista;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="empresa_id")
	private Empresa empresa;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="paciente_id",unique = true)
	private Paciente paciente;
	
	@NotEmpty
	@Column(name = "cidade")
	private String cidade;
	
	@NotEmpty
	@Column(name = "estado")
	private String estado;
	
	public Endereco(String logradouro, String complemento, String bairro, String cep, String numero,
			String cidade, String estado,Analista analista) {
		super();
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.analista = analista;
	}
	
	public Endereco(String logradouro, String complemento, String bairro, String cep, String numero,
			String cidade, String estado,Acompanhante acompanhante) {
		super();
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.acompanhante = acompanhante;
	}

	public Endereco(String logradouro, String complemento, String bairro, String cep, String numero,Paciente paciente,
			String cidade, String estado) {
		super();
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.paciente = paciente;
	}

	public Endereco(String logradouro, String complemento, String bairro, String cep, String numero,Empresa empresa,
			String cidade, String estado) {
		super();
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.empresa = empresa;
	}
	public Endereco(Endereco endereco) {

	}
	
	public Endereco() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Analista getAnalista() {
		return analista;
	}

	public void setAnalista(Analista analista) {
		this.analista = analista;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Acompanhante getAcompanhante() {
		return acompanhante;
	}

	public void setAcompanhante(Acompanhante acompanhante) {
		this.acompanhante = acompanhante;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}