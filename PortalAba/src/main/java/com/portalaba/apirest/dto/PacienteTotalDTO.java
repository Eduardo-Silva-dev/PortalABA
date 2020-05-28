package com.portalaba.apirest.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.portalaba.apirest.domain.Paciente;

public class PacienteTotalDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

    private long id; 
    
    private String password; 

    private String nome;
    
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataNascimento;
    
    private String nomeResponsavel;
    
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataNascimentoResponsavel;
    
    private String emailResponsavel;
    
    private String cpfResponsavel;
    
    private String contatoResponsavel;
    
    private String contatoAuxiliar;
    
    private String logradouro;
	
	private String complemento;
	
	private String bairro;
	
	private String cep;
	
	private String numero;
    
	private String cidade;
	
	private String estado;
	
	private String nivelAutismo;
    
	@JsonIgnore
    private String imagem;
    
    private byte[] image;
	
	public PacienteTotalDTO() {
		
	}
	
	public PacienteTotalDTO(Paciente paciente) {
		super();
		this.id = paciente.getId();
		this.password = paciente.getPassword();
		this.nome = paciente.getNome();
		this.dataNascimento = paciente.getDataNascimento();
		this.nomeResponsavel = paciente.getNomeResponsavel();
		this.dataNascimentoResponsavel = paciente.getDataNascimentoResponsavel();
		this.emailResponsavel = paciente.getEmailResponsavel();
		this.cpfResponsavel = paciente.getCpfResponsavel();
		this.contatoResponsavel = paciente.getContatoResponsavel();
		this.contatoAuxiliar = paciente.getContatoAuxiliar();
		this.bairro = paciente.getEnderecos().getBairro();
		this.cep = paciente.getEnderecos().getCep();
		this.cidade = paciente.getEnderecos().getCidade();
		this.complemento = paciente.getEnderecos().getComplemento();
		this.estado = paciente.getEnderecos().getEstado();
		this.logradouro = paciente.getEnderecos().getLogradouro();
		this.numero = paciente.getEnderecos().getNumero();
		this.nivelAutismo = paciente.getNivelAltismo();
		this.imagem = paciente.getImage();
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public Date getDataNascimentoResponsavel() {
		return dataNascimentoResponsavel;
	}

	public void setDataNascimentoResponsavel(Date dataNascimentoResponsavel) {
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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNivelAutismo() {
		return nivelAutismo;
	}

	public void setNivelAutismo(String nivelAutismo) {
		this.nivelAutismo = nivelAutismo;
	}
	
	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public byte[] getImage() {
	    return image;
	}

	public void setImage(byte[] img) {
		this.image = img;
	}
}
