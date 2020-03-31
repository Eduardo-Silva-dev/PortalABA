package com.portalaba.apirest.models;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.UniqueElements;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tb_acompanhante")
public class Acompanhante implements Serializable{

	private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAcompanhante;  

    @NotBlank
    @UniqueElements
    @Column(length=60)
    private String nomeAcompanhante;
    
    @NotBlank
    @Column(length=8)
    private Integer dataNascimento;

    @NotBlank
    @Column(length=30)
    private String tipoAcompanhante;
    
    @NotBlank
    @Column(length=60)
    @UniqueElements
    private String emailAcompanhante;
    
    @NotBlank
    @Column(length=11)
    @UniqueElements
    private String cpfAcompanhante;
    
    @NotBlank
    @Column(length=150)
    private String enderecoAcompanhante;
    
    @NotBlank
    @Column(length=11)
    @UniqueElements
    private String contatoAcompanhante;
    
    @NotBlank
    @Column(length=20)
    @UniqueElements
    private Integer crpAcompanhante;

	public long getIdAcompanhante() {
		return idAcompanhante;
	}

	public void setIdAcompanhante(long idAcompanhante) {
		this.idAcompanhante = idAcompanhante;
	}

	public String getNomeAcompanhante() {
		return nomeAcompanhante;
	}

	public void setNomeAcompanhante(String nomeAcompanhante) {
		this.nomeAcompanhante = nomeAcompanhante;
	}

	public Integer getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Integer dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public String getEnderecoAcompanhante() {
		return enderecoAcompanhante;
	}

	public void setEnderecoAcompanhante(String enderecoAcompanhante) {
		this.enderecoAcompanhante = enderecoAcompanhante;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idAcompanhante ^ (idAcompanhante >>> 32));
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
		Acompanhante other = (Acompanhante) obj;
		if (idAcompanhante != other.idAcompanhante)
			return false;
		return true;
	}
    
}
