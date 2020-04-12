package com.portalaba.apirest.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Endereco implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String logradouro;
	
	private String complemento;
	
	private String bairro;
	
	private String cep;
	
	private String numero;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="analista_id")
	private Analista analista;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="acompanhante_id")
	private Acompanhante acompanhante;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="paciente_id")
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name="cidade_id")
	private Cidade cidade;
	
	public Endereco(String logradouro, String complemento, String bairro, String cep, String numero,Analista analista) {
		super();
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.numero = numero;
		this.analista = analista;
	}
	
	public Endereco(String logradouro, String complemento, String bairro, String cep, String numero,Acompanhante acompanhante) {
		super();
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.numero = numero;
		this.acompanhante = acompanhante;
	}

	public Endereco(String logradouro, String complemento, String bairro, String cep, String numero,Paciente paciente) {
		super();
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.numero = numero;
		this.paciente = paciente;
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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public Analista getAnalista() {
		return analista;
	}

	public void setAnalista(Analista analista) {
		this.analista = analista;
	}

	public Acompanhante getAcompanhante() {
		return acompanhante;
	}

	public void setAcompanhante(Acompanhante acompanhante) {
		this.acompanhante = acompanhante;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
}