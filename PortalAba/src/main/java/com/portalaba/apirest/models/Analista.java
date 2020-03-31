package com.portalaba.apirest.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tb_analista")
public class Analista implements Serializable{

	private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAnalista;  

    @NotEmpty
    @Column(length=60,unique=true)
    private String nomeAnalista;
    
    @NotNull
    @Column(length=8)
    private Integer dataNascimento;

    @NotEmpty
    @Column(length=30)
    private String tipoAnalista;
    
    @NotEmpty
    @Column(length=60,unique=true)
    private String emailAnalista;
    
    @NotEmpty
    @Column(length=11,unique=true)
    private String cpfAnalista;
    
    @NotEmpty
    @Column(length=150)
    private String enderecoAnalista;
    
    @NotEmpty
    @Column(length=11,unique=true)
    private String contatoAnalista;
    
    @NotNull
    @Column(length=20,unique=true)
    private Integer crpAnalista;
    
    @NotEmpty
    @Column(length=14,unique=true)
    private String cnpjAnalista;

	public long getIdAnalista() {
		return idAnalista;
	}

	public String getNomeAnalista() {
		return nomeAnalista;
	}

	public void setNomeAnalista(String nomeAnalista) {
		this.nomeAnalista = nomeAnalista;
	}

	public Integer getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Integer dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public String getEnderecoAnalista() {
		return enderecoAnalista;
	}

	public void setEnderecoAnalista(String enderecoAnalista) {
		this.enderecoAnalista = enderecoAnalista;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idAnalista ^ (idAnalista >>> 32));
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
		Analista other = (Analista) obj;
		if (idAnalista != other.idAnalista)
			return false;
		return true;
	}
    
}
