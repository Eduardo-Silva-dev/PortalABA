package com.portalaba.apirest.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.portalaba.apirest.domain.enums.Perfil;

@Entity
@Table(name = "empresas")
public class Empresa extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty
    @Column(name = "cnpj",length=14,unique = true)
	private String cnpj;	
	
	@NotEmpty
    @Column(name = "razao_social",length=60,unique = true)	
	private	String razao_social;	
	
	@NotEmpty
    @Column(name = "nome_fantasia",length=60,unique = true)
	private	String nome_fantasia;	
	
	@NotEmpty
    @Column(name = "contato",length=60,unique = true)
	private	String contato;

	@NotEmpty
    @Column(name = "telefone",length=10,unique = true)
	private	String telefone;

	@NotEmpty
    @Column(name = "celular",length=11,unique = true)	
	private	String celular;
    
	@NotEmpty
    @Column(name = "email",length=60,unique = true)
	private	String email;
	
    @Column(name = "dataInicio",length=8)
    private Date dataInicio;
    
    @OneToOne(mappedBy="empresa", cascade=CascadeType.ALL)
  	private Endereco enderecos = new Endereco();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "EMPRESA_ACOMPANHANTE",
		joinColumns = @JoinColumn(name = "empresa_id"),
		inverseJoinColumns = @JoinColumn(name = "acompanhante_id")
	)
	private List<Acompanhante> acompanhantes = new ArrayList<>();
   
    @JsonIgnore
	@ManyToMany
	@JoinTable(name = "EMPRESA_PACIENTE",
		joinColumns = @JoinColumn(name = "empresa_id"),
		inverseJoinColumns = @JoinColumn(name = "paciente_id")
	)
   	private List<Paciente> pacientes = new ArrayList<>();
    
    @JsonIgnore
	@ManyToMany
	@JoinTable(name = "EMPRESA_ANALISTA",
		joinColumns = @JoinColumn(name = "empresa_id"),
		inverseJoinColumns = @JoinColumn(name = "analista_id")
	)
   	private List<Analista> analistas = new ArrayList<>();
    
	public Empresa() {
		this.dataInicio = new Date();
		setPerfil("EMPRESA");
	}

	public Empresa(String password,String cnpj, String razao_social, String nome_fantasia, String contato,
			String telefone, String celular, String email) {
		super();
		setPassword(password);
		setNome(nome_fantasia);
		setPerfil("EMPRESA");
		this.cnpj = cnpj;
		this.razao_social = razao_social;
		this.nome_fantasia = nome_fantasia;
		this.contato = contato;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.dataInicio = new Date();
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazao_social() {
		return razao_social;
	}

	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}

	public String getNome_fantasia() {
		return nome_fantasia;
	}

	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
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

	public List<Analista> getAnalistas() {
		return analistas;
	}

	public void setAnalistas(List<Analista> analistas) {
		this.analistas = analistas;
	}
}
