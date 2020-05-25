package com.portalaba.apirest.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.portalaba.apirest.domain.Tratamento;

public class TratamentoDTO {

	private long id;  
	
	private long analista;

	private long acompanhante;

	private String nome;

	private long paciente;

	private String file;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date data_Cadastro;
	
	
	public TratamentoDTO(Tratamento obj) {

	}
	
	public TratamentoDTO( ) {

	}

	public TratamentoDTO(long id, long analista, long acompanhante, String nome, long paciente, String file, Date data_Cadastro) {
		super();
		this.id = id;
		this.analista = analista;
		this.acompanhante = acompanhante;
		this.nome = nome;
		this.paciente = paciente;
		this.file = file;
		this.data_Cadastro = data_Cadastro;
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
}
