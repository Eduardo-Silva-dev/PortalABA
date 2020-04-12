package com.portalaba.apirest.domain;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="paciente")
public class Paciente extends Pessoa  implements Serializable{

	private static final long serialVersionUID = 1l;
	
    @Column(length=60)
    private String nomePai;
    
    @Column(length=60)
    private String nomeMae;
    
    @Column(length=8)
    private Integer dataNascimentoPai;
    
    @Column(length=8)
    private Integer dataNascimentoMae;
    
    @NotEmpty
    @Column(length=60,unique = true)
    private String emailResponsavel;

    @Column(length=11,unique = true)
    private String cpfPaciente;
    
    @Column(length=11,unique = true)
    private String cpfPai;
    
    @Column(length=11,unique = true)
    private String cpfMae;
    
    @Column(length=11,unique = true)
    private String contatoPaciente;

    @Column(length=11,unique = true)
    private String contatoPai;
    
    @Column(length=11,unique = true)
    private String contatoMae;
    
    @OneToMany(mappedBy="paciente", cascade=CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>();
    
    @OneToMany(mappedBy="paciente", cascade=CascadeType.ALL)
	private List<Acompanhante> acompanhantes = new ArrayList<>();
    
    private Analista analista;
    
    private Acompanhante acompanhante;

	public Paciente(String password, String nome, Date dataNascimento,String nomePai, String nomeMae, Integer dataNascimentoPai, Integer dataNascimentoMae,
			String emailResponsavel, String cpfPaciente, String cpfPai, String cpfMae,
			String contatoPaciente, String contatoPai, String contatoMae,Analista analista,Acompanhante acompanhante) {
		super();
		this.nomePai = nomePai;
		this.nomeMae = nomeMae;
		this.dataNascimentoPai = dataNascimentoPai;
		this.dataNascimentoMae = dataNascimentoMae;
		this.emailResponsavel = emailResponsavel;
		this.cpfPaciente = cpfPaciente;
		this.cpfPai = cpfPai;
		this.cpfMae = cpfMae;
		this.contatoPaciente = contatoPaciente;
		this.contatoPai = contatoPai;
		this.contatoMae = contatoMae;
		this.analista = (analista == null) ? null : analista;
		this.acompanhante = (acompanhante == null) ? null : acompanhante;
	}

	public Paciente() {
		
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

	public Analista getAnalista() {
		return analista;
	}

	public void setAnalista(Analista analista) {
		this.analista = analista;
	}

	public Acompanhante getAcompanhante() {
		return acompanhante;
	}

	public void setAcompanhante(Acompanhante acompanhante) {
		this.acompanhante = acompanhante;
	}
}