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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="acompanhante")
public class Acompanhante extends Pessoa implements Serializable{

	private static final long serialVersionUID = 1l;

    @Column(length=30)
    private String tipoAcompanhante;
    
    @Column(length=60)
    private String emailAcompanhante;
    
    @Column(length=11)
    private String cpfAcompanhante;
    
    @Column(length=11)
    private String contatoAcompanhante;
    
    @Column(length=20)
    private Integer crpAcompanhante;

    @OneToMany(mappedBy="acompanhante", cascade=CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>();
    
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="analista_id")
	private Analista analista;
    
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="paciente_id")
	private Paciente paciente;

	@JsonIgnore
    @OneToMany(mappedBy="acompanhante", cascade=CascadeType.ALL)
	private List<Analista> analistas = new ArrayList<>();
    
	@JsonIgnore
    @OneToMany(mappedBy="acompanhante", cascade=CascadeType.ALL)
	private List<Paciente> pacientes = new ArrayList<>();

	public Acompanhante(String password,String nome,Date dataNascimento,String tipoAcompanhante,
			String emailAcompanhante,String cpfAcompanhante,String contatoAcompanhante,Integer crpAcompanhante,Analista analista) {
		super();
		setPassword(password);
		setNome(nome);
		setDataNascimento(dataNascimento);
		this.tipoAcompanhante = tipoAcompanhante;
		this.emailAcompanhante = emailAcompanhante;
		this.cpfAcompanhante = cpfAcompanhante;
		this.contatoAcompanhante = contatoAcompanhante;
		this.crpAcompanhante = crpAcompanhante;
		this.analista = (analista == null) ? null : analista;
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

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
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
