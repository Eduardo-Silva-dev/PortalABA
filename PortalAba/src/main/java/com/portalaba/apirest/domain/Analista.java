package com.portalaba.apirest.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "analistas")
public class Analista extends Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotEmpty
    @Column(name = "tipo",length=30)
    private String tipoAnalista;
    
	@NotEmpty
    @Column(name = "email",length=60,unique = true)
    private String emailAnalista;
	
    @Column(name = "image",unique = true)
    private String image;
    
	@NotEmpty
    @Column(name = "cpf",length=11,unique = true)
    private String cpfAnalista;

	@NotEmpty
    @Column(name = "contato",length=11,unique = true)
    private String contatoAnalista;
    
	@NotEmpty
    @Column(name = "crp",length=20,unique = true)
    private String crpAnalista;
    
    @Column(name = "cnpj",length=14,unique = true)
    private String cnpjAnalista;
    
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "ANALISTA_ACOMPANHANTE",
		joinColumns = @JoinColumn(name = "analista_id"),
		inverseJoinColumns = @JoinColumn(name = "acompanhante_id")
	)
	private List<Acompanhante> acompanhantes = new ArrayList<>();
    
    @Column(name = "dataInicio",length=8)
    private Date dataInicio;
    
    @OneToOne(mappedBy="analista", cascade=CascadeType.ALL)
  	private Endereco enderecos = new Endereco();
    
    @JsonIgnore
	@ManyToMany
	@JoinTable(name = "ANALISTA_PACIENTE",
		joinColumns = @JoinColumn(name = "analista_id"),
		inverseJoinColumns = @JoinColumn(name = "paciente_id")
	)
   	private List<Paciente> pacientes = new ArrayList<>();

	public Analista(String password, String nome, LocalDate dataNascimento,
			String tipoAnalista, String emailAnalista, String cpfAnalista, String contatoAnalista,
			String crpAnalista, String cnpjAnalista) {
		super();
		setPassword(password);
		setNome(nome);
		setDataNascimento(dataNascimento);
		this.tipoAnalista = tipoAnalista;
		this.emailAnalista = emailAnalista;
		this.cpfAnalista = cpfAnalista;
		this.contatoAnalista = contatoAnalista;
		this.crpAnalista = crpAnalista;
		this.cnpjAnalista = cnpjAnalista;
		this.dataInicio = new Date();
	}

	public Analista() {
		
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTipoAnalista() {
		return tipoAnalista;
	}

	public void setTipoAnalista(String tipoAnalista) {
		this.tipoAnalista = tipoAnalista;
	}

	public String getEmailAnalista() {
		return emailAnalista;
	}

	public void setEmailAnalista(String emailAnalista) {
		this.emailAnalista = emailAnalista;
	}

	public String getCpfAnalista() {
		return cpfAnalista;
	}

	public void setCpfAnalista(String cpfAnalista) {
		this.cpfAnalista = cpfAnalista;
	}

	public String getContatoAnalista() {
		return contatoAnalista;
	}

	public void setContatoAnalista(String contatoAnalista) {
		this.contatoAnalista = contatoAnalista;
	}

	public String getCrpAnalista() {
		return crpAnalista;
	}

	public void setCrpAnalista(String crpAnalista) {
		this.crpAnalista = crpAnalista;
	}

	public String getCnpjAnalista() {
		return cnpjAnalista;
	}

	public void setCnpjAnalista(String cnpjAnalista) {
		this.cnpjAnalista = cnpjAnalista;
	}

	public Endereco getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Endereco enderecos) {
		this.enderecos = enderecos;
	}

	public List<Acompanhante> getAcompanhantes() {
		return acompanhantes;
	}

	public void setAcompanhantes(List<Acompanhante> acompanhantes) {
		this.acompanhantes = acompanhantes;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
}
