package com.portalaba.apirest.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TratamentoNewDTO {
	
	@NotNull(message = "Codigo é obrigatório")
	private long id;
	
	@NotNull(message = "Codigo é obrigatório")
	private long acompanhante;
	
	@NotNull(message = "Codigo é obrigatório")
	private long paciente;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String nome;

	public TratamentoNewDTO() {
		
	}
	
	public TratamentoNewDTO(long acompanhante,long paciente,String nome) {
		this.acompanhante = acompanhante;
		this.paciente = paciente;
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAcompanhante() {
		return acompanhante;
	}

	public void setAcompanhante(long acompanhante) {
		this.acompanhante = acompanhante;
	}

	public long getPaciente() {
		return paciente;
	}

	public void setPaciente(long paciente) {
		this.paciente = paciente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
