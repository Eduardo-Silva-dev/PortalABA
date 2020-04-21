package com.portalaba.apirest.dto;


import com.portalaba.apirest.domain.Paciente;

public class PacienteDTO {

    private long id; 

    private String nome;
    
    private String emailPaciente;
    
    private String cpfPaciente;
	
	public PacienteDTO() {
		
	}
	
	public PacienteDTO(Paciente obj) {
		this.id = obj.getId();
		this.cpfPaciente = obj.getCpfPaciente();
		this.nome = obj.getNome();
		this.emailPaciente = obj.getEmailResponsavel();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmailPaciente() {
		return emailPaciente;
	}

	public void setEmailPaciente(String emailPaciente) {
		this.emailPaciente = emailPaciente;
	}

	public String getCpfPaciente() {
		return cpfPaciente;
	}

	public void setCpfPaciente(String cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}
}
