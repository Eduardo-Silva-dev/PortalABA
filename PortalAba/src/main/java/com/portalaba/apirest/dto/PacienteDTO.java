package com.portalaba.apirest.dto;


import com.portalaba.apirest.domain.Paciente;

public class PacienteDTO {

    private long id; 

    private String nome;
    
    private String nomeResponsavel;
    
    private String contatoResponsavel;
    
    private String nivelAltismo;
	
	public PacienteDTO() {
		
	}
	
	public PacienteDTO(Paciente obj) {
		this.id = obj.getId();
		this.nomeResponsavel = obj.getNomeResponsavel();
		this.nome = obj.getNome();
		this.contatoResponsavel = obj.getContatoResponsavel();
		this.nivelAltismo = obj.getNivelAltismo();
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

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getContatoResponsavel() {
		return contatoResponsavel;
	}

	public void setContatoResponsavel(String contatoResponsavel) {
		this.contatoResponsavel = contatoResponsavel;
	}
	
	public String getNivelAltismo() {
		return nivelAltismo;
	}

	public void setNivelAltismo(String nivelAltismo) {
		this.nivelAltismo = nivelAltismo;
	}
}
