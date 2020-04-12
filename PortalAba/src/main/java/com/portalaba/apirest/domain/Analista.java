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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Analista extends Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Column(length=30)
    private String tipoAnalista;
    

    @Column(length=60)
    private String emailAnalista;
    

    @Column(length=11)
    private String cpfAnalista;

    @Column(length=11)
    private String contatoAnalista;
    

    @Column(length=20)
    private Integer crpAnalista;
    

    @Column(length=14)
    private String cnpjAnalista;
    
    @OneToMany(mappedBy="analista", cascade=CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>();
    
    @OneToMany(mappedBy="analista", cascade=CascadeType.ALL)
   	private List<Acompanhante> acompanhantes = new ArrayList<>();
    
    @JsonIgnore
	@ManyToOne
	@JoinColumn(name="acompanhante_id")
	private Acompanhante acompanhante;

	public Analista(String password, String nome, Date dataNascimento,
			String tipoAnalista, String emailAnalista, String cpfAnalista, String contatoAnalista,
			Integer crpAnalista, String cnpjAnalista) {
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
	}

	public Analista() {
		
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

	public Integer getCrpAnalista() {
		return crpAnalista;
	}

	public void setCrpAnalista(Integer crpAnalista) {
		this.crpAnalista = crpAnalista;
	}

	public String getCnpjAnalista() {
		return cnpjAnalista;
	}

	public void setCnpjAnalista(String cnpjAnalista) {
		this.cnpjAnalista = cnpjAnalista;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Acompanhante> getAcompanhantes() {
		return acompanhantes;
	}

	public void setAcompanhantes(List<Acompanhante> acompanhantes) {
		this.acompanhantes = acompanhantes;
	}

	public Acompanhante getAcompanhante() {
		return acompanhante;
	}

	public void setAcompanhante(Acompanhante acompanhante) {
		this.acompanhante = acompanhante;
	}
}
