package com.portalaba.apirest.models;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.UniqueElements;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tb_paciente")
public class Paciente implements Serializable{

	private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPaciente; 

    @NotBlank
    @UniqueElements
    @Column(length=60)
    private String nomePaciente;
    
    @Column(length=60)
    private String nomePai;
    
    @Column(length=60)
    private String nomeMae;
    
    @NotBlank
    @Column(length=8)
    private Integer dataNascimentoPaciente;
    
    @Column(length=8)
    private Integer dataNascimentoPai;
    
    @Column(length=8)
    private Integer dataNascimentoMae;
    
    @NotBlank
    @Column(length=60)
    @UniqueElements
    private String emailResponsavel;

    @Column(length=11)
    @UniqueElements
    private String cpfPaciente;
    
    @Column(length=11)
    @UniqueElements
    private String cpfPai;
    
    @Column(length=11)
    @UniqueElements
    private String cpfMae;
    
    @NotBlank
    @Column(length=150)
    private String enderecoPaciente;
    
    @Column(length=11)
    @UniqueElements
    private String contatoPaciente;

    @Column(length=11)
    @UniqueElements
    private String contatoPai;
    
    @Column(length=11)
    @UniqueElements
    private String contatoMae;

	public long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public Integer getDataNascimentoPaciente() {
		return dataNascimentoPaciente;
	}

	public void setDataNascimentoPaciente(Integer dataNascimentoPaciente) {
		this.dataNascimentoPaciente = dataNascimentoPaciente;
	}

	public Integer getDataNascimentoPai() {
		return dataNascimentoPai;
	}

	public void setDataNascimentoPai(Integer dataNascimentoPai) {
		this.dataNascimentoPai = dataNascimentoPai;
	}

	public Integer getDataNascimentoMae() {
		return dataNascimentoMae;
	}

	public void setDataNascimentoMae(Integer dataNascimentoMae) {
		this.dataNascimentoMae = dataNascimentoMae;
	}

	public String getEmailResponsavel() {
		return emailResponsavel;
	}

	public void setEmailResponsavel(String emailResponsavel) {
		this.emailResponsavel = emailResponsavel;
	}

	public String getCpfPaciente() {
		return cpfPaciente;
	}

	public void setCpfPaciente(String cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}

	public String getCpfPai() {
		return cpfPai;
	}

	public void setCpfPai(String cpfPai) {
		this.cpfPai = cpfPai;
	}

	public String getCpfMae() {
		return cpfMae;
	}

	public void setCpfMae(String cpfMae) {
		this.cpfMae = cpfMae;
	}

	public String getEnderecoPaciente() {
		return enderecoPaciente;
	}

	public void setEnderecoPaciente(String enderecoPaciente) {
		this.enderecoPaciente = enderecoPaciente;
	}

	public String getContatoPaciente() {
		return contatoPaciente;
	}

	public void setContatoPaciente(String contatoPaciente) {
		this.contatoPaciente = contatoPaciente;
	}

	public String getContatoPai() {
		return contatoPai;
	}

	public void setContatoPai(String contatoPai) {
		this.contatoPai = contatoPai;
	}

	public String getContatoMae() {
		return contatoMae;
	}

	public void setContatoMae(String contatoMae) {
		this.contatoMae = contatoMae;
	}
	
    
}
