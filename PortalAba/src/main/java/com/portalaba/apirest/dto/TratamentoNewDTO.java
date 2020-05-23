package com.portalaba.apirest.dto;

public class TratamentoNewDTO {

	private long id;

	private long acompanhante;
	
	private long paciente;

	public TratamentoNewDTO() {
		
	}
	
	public TratamentoNewDTO(long acompanhante,long paciente) {
		this.acompanhante = acompanhante;
		this.paciente = paciente;
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
}
