package com.portalaba.apirest.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

@Entity
@Table(name = "empresas")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;  
	
	@NotEmpty
	@Column(name = "password",length=60)
    private String password; 
	
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
		super();
	}

	public Empresa(String password,String cnpj, String razao_social, String nome_fantasia, String contato,
			String telefone, String celular, String email) {
		super();
		this.password = password;
		this.cnpj = cnpj;
		this.razao_social = razao_social;
		this.nome_fantasia = nome_fantasia;
		this.contato = contato;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.dataInicio = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acompanhantes == null) ? 0 : acompanhantes.hashCode());
		result = prime * result + ((analistas == null) ? 0 : analistas.hashCode());
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((contato == null) ? 0 : contato.hashCode());
		result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((enderecos == null) ? 0 : enderecos.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nome_fantasia == null) ? 0 : nome_fantasia.hashCode());
		result = prime * result + ((pacientes == null) ? 0 : pacientes.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((razao_social == null) ? 0 : razao_social.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (acompanhantes == null) {
			if (other.acompanhantes != null)
				return false;
		} else if (!acompanhantes.equals(other.acompanhantes))
			return false;
		if (analistas == null) {
			if (other.analistas != null)
				return false;
		} else if (!analistas.equals(other.analistas))
			return false;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (contato == null) {
			if (other.contato != null)
				return false;
		} else if (!contato.equals(other.contato))
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (enderecos == null) {
			if (other.enderecos != null)
				return false;
		} else if (!enderecos.equals(other.enderecos))
			return false;
		if (id != other.id)
			return false;
		if (nome_fantasia == null) {
			if (other.nome_fantasia != null)
				return false;
		} else if (!nome_fantasia.equals(other.nome_fantasia))
			return false;
		if (pacientes == null) {
			if (other.pacientes != null)
				return false;
		} else if (!pacientes.equals(other.pacientes))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (razao_social == null) {
			if (other.razao_social != null)
				return false;
		} else if (!razao_social.equals(other.razao_social))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}
}
