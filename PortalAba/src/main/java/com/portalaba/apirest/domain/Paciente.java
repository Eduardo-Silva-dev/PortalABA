package com.portalaba.apirest.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="paciente")
public class Paciente extends Pessoa  implements Serializable{

	private static final long serialVersionUID = 1l;
	
	@Column(name = "nome_responsavel",length=60)
    private String nomeResponsavel;

    @Column(name = "dataNascimento_responsavel",length=8)
    private LocalDate dataNascimentoResponsavel;
    
    @NotEmpty
    @Column(name = "emailResponsavel",length=60)
    private String emailResponsavel;
    
    @Column(name = "cpf_responsavel",length=11)
    private String cpfResponsavel;

    @Column(name = "contato_responsavel",length=11)
    private String contatoResponsavel;
    
    @Column(name = "contato_auxiliar",length=11)
    private String contatoAuxiliar;
    
    @Column(name = "nivel_altismo",length=8)
    private String nivelAltismo;
    
    @Column(name = "dataInicio",length=8)
    private LocalDate dataInicio;
    
    @OneToOne(mappedBy="paciente", cascade=CascadeType.ALL)
  	private Endereco enderecos = new Endereco();
    
    @JsonIgnore
	@ManyToOne
	@JoinColumn(name="acompanhante_id")
	private Acompanhante acompanhante;
	
	@JsonIgnore
    @ManyToOne
	@JoinColumn(name="analista_id")
    private Analista analista;

	public Paciente() {
		
	}

	public Paciente(String password,String nome,LocalDate dataNascimento,String nomeResponsavel, 
			LocalDate dataNascimentoResponsavel, String emailResponsavel,
			String cpfResponsavel, String contatoResponsavel, String contatoAuxiliar, String nivelAltismo) {
		super();
		setPassword(password);
		setNome(nome);
		setDataNascimento(dataNascimento);
		this.nomeResponsavel = nomeResponsavel;
		this.dataNascimentoResponsavel = dataNascimentoResponsavel;
		this.emailResponsavel = emailResponsavel;
		this.cpfResponsavel = cpfResponsavel;
		this.contatoResponsavel = contatoResponsavel;
		this.contatoAuxiliar = contatoAuxiliar;
		this.nivelAltismo = nivelAltismo;
		this.dataInicio = LocalDate.now();
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public LocalDate getDataNascimentoResponsavel() {
		return dataNascimentoResponsavel;
	}

	public void setDataNascimentoResponsavel(LocalDate dataNascimentoResponsavel) {
		this.dataNascimentoResponsavel = dataNascimentoResponsavel;
	}

	public String getEmailResponsavel() {
		return emailResponsavel;
	}

	public void setEmailResponsavel(String emailResponsavel) {
		this.emailResponsavel = emailResponsavel;
	}

	public String getCpfResponsavel() {
		return cpfResponsavel;
	}

	public void setCpfResponsavel(String cpfResponsavel) {
		this.cpfResponsavel = cpfResponsavel;
	}

	public String getContatoResponsavel() {
		return contatoResponsavel;
	}

	public void setContatoResponsavel(String contatoResponsavel) {
		this.contatoResponsavel = contatoResponsavel;
	}

	public String getContatoAuxiliar() {
		return contatoAuxiliar;
	}

	public void setContatoAuxiliar(String contatoAuxiliar) {
		this.contatoAuxiliar = contatoAuxiliar;
	}

	public String getNivelAltismo() {
		return nivelAltismo;
	}

	public void setNivelAltismo(String nivelAltismo) {
		this.nivelAltismo = nivelAltismo;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Endereco getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Endereco enderecos) {
		this.enderecos = enderecos;
	}

	public Acompanhante getAcompanhante() {
		return acompanhante;
	}

	public void setAcompanhante(Acompanhante acompanhante) {
		this.acompanhante = acompanhante;
	}

	public Analista getAnalista() {
		return analista;
	}

	public void setAnalista(Analista analista) {
		this.analista = analista;
	}
}