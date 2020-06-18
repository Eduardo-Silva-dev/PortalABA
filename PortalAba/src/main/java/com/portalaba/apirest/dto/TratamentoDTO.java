package com.portalaba.apirest.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.portalaba.apirest.domain.Tratamento;

public class TratamentoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long id;  
	
	private long analista;

	private long acompanhante;

	private String nome;

	private String tipo;

	private long paciente;

	private String file;
	
	@JsonIgnore
	private Date data_Cadastro;
	
    @JsonFormat(pattern="dd/MM/yyyy")
	private Date data_envio;
	
	public TratamentoDTO( ) {

	}

	public TratamentoDTO(Tratamento obj) {
		super();
		this.id = obj.getId();
		this.analista = obj.getAnalista();
		this.acompanhante = obj.getAcompanhante();
		this.nome = obj.getNome();
		this.paciente = obj.getPaciente();
		this.file = obj.getFile();
		this.data_Cadastro = obj.getData_Cadastro();
		this.data_envio = obj.getData_envio();
		this.tipo = obj.getTipo();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAnalista() {
		return analista;
	}

	public void setAnalista(long analista) {
		this.analista = analista;
	}

	public long getAcompanhante() {
		return acompanhante;
	}

	public void setAcompanhante(long acompanhante) {
		this.acompanhante = acompanhante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getPaciente() {
		return paciente;
	}

	public void setPaciente(long paciente) {
		this.paciente = paciente;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Date getData_Cadastro() {
		return data_Cadastro;
	}

	public void setData_Cadastro(Date data_Cadastro) {
		this.data_Cadastro = data_Cadastro;
	}

	public Date getData_envio() {
		return data_envio;
	}

	public void setData_envio(Date data_envio) {
		this.data_envio = data_envio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
