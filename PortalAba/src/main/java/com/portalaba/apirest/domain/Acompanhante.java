package com.portalaba.apirest.domain;

import java.io.Serializable;
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
@Table(name="acompanhante")
public class Acompanhante extends Pessoa implements Serializable{

	private static final long serialVersionUID = 1l;

	@NotEmpty
    @Column(name = "tipo",length=30)
    private String tipoAcompanhante;
    
	@NotEmpty
    @Column(name = "email",length=60,unique = true)
    private String emailAcompanhante;
    
	@NotEmpty
    @Column(name = "cpf",length=11,unique = true)
    private String cpfAcompanhante;
    
    @Column(name = "image",unique = true)
    private String image;
	
	@NotEmpty
    @Column(name = "contato",length=11,unique = true)
    private String contatoAcompanhante;
    
	@NotEmpty
    @Column(name = "crp",length=20,unique = true)
    private String crpAcompanhante;

    @OneToOne(mappedBy="acompanhante", cascade=CascadeType.ALL)
  	private Endereco enderecos = new Endereco();
	
    @Column(name = "dataInicio",length=8)
    private Date dataInicio;
    
    @JsonIgnore
	@ManyToMany(mappedBy="acompanhantes")
	private List<Analista> analistas = new ArrayList<>();
    
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "ACOMPANHANTE_PACIENTE",
		joinColumns = @JoinColumn(name = "acompanhante_id"),
		inverseJoinColumns = @JoinColumn(name = "paciente_id")
	)
	private List<Paciente> pacientes = new ArrayList<>();

	public Acompanhante(String password,String nome,Date dataNascimento,String tipoAcompanhante,
			String emailAcompanhante,String cpfAcompanhante,String contatoAcompanhante,String crpAcompanhante) {
		super();
		setPassword(password);
		setNome(nome);
		setDataNascimento(dataNascimento);
		this.tipoAcompanhante = tipoAcompanhante;
		this.emailAcompanhante = emailAcompanhante;
		this.cpfAcompanhante = cpfAcompanhante;
		this.contatoAcompanhante = contatoAcompanhante;
		this.crpAcompanhante = crpAcompanhante;
		this.dataInicio = new Date();
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
	
	public String getCrpAcompanhante() {
		return crpAcompanhante;
	}
	
	public void setCrpAcompanhante(String crpAcompanhante) {
		this.crpAcompanhante = crpAcompanhante;
	}

	public Endereco getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Endereco enderecos) {
		this.enderecos = enderecos;
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

	public List<Analista> getAnalistas() {
		return analistas;
	}

	public void setAnalistas(List<Analista> analistas) {
		this.analistas = analistas;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
