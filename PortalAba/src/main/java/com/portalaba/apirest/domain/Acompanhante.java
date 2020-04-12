package com.portalaba.apirest.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="acompanhante")
public class Acompanhante extends Pessoa  implements Serializable{

	private static final long serialVersionUID = 1l;

    @NotEmpty
    @Column(length=30)
    private String tipoAcompanhante;
    
    @NotEmpty
    @Column(length=60)
    private String emailAcompanhante;
    
    @NotEmpty
    @Column(length=11)
    private String cpfAcompanhante;
    
    @NotEmpty
    @Column(length=11)
    private String contatoAcompanhante;
    
    @NotBlank
    @Column(length=20)
    private Integer crpAcompanhante;

    @OneToMany(mappedBy="acompanhante", cascade=CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>();
    
    @JsonIgnore
	@ManyToOne
	@JoinColumn(name="paciente_id")
	private Paciente paciente;
    
    @JsonIgnore
	@ManyToOne
	@JoinColumn(name="analista_id")
	private Analista analista;
    
    @OneToMany(mappedBy="acompanhante", cascade=CascadeType.ALL)
	private List<Analista> analistas = new ArrayList<>();

	public Acompanhante(String password,String nome,Date dataNascimento,String tipoAcompanhante,
			String emailAcompanhante,String cpfAcompanhante,String contatoAcompanhante,Integer crpAcompanhante) {
		super();
		this.tipoAcompanhante = tipoAcompanhante;
		this.emailAcompanhante = emailAcompanhante;
		this.cpfAcompanhante = cpfAcompanhante;
		this.contatoAcompanhante = contatoAcompanhante;
		this.crpAcompanhante = crpAcompanhante;
	}
    
   public Acompanhante() {
	   
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

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Analista getAnalista() {
		return analista;
	}

	public void setAnalista(Analista analista) {
		this.analista = analista;
	}

	public List<Analista> getAnalistas() {
		return analistas;
	}

	public void setAnalistas(List<Analista> analistas) {
		this.analistas = analistas;
	}
}
