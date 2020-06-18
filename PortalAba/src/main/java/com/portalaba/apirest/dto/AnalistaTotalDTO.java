package com.portalaba.apirest.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.portalaba.apirest.domain.Analista;

public class AnalistaTotalDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

    private long id; 
    
    @JsonIgnore
    private String password; 

    private String nome;
    
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataNascimento;

    private String tipoAnalista;
    
    private String emailAnalista;
    
    private String cpfAnalista;

    private String contatoAnalista;
    
    private String perfil;
    
    private String crpAnalista;
    
    private String cnpjAnalista;
    
    private String logradouro;
	
	private String complemento;
	
	private String bairro;
	
	private String cep;
	
	private String numero;
    
	private String cidade;
    
	private String estado;
	
	@JsonIgnore
	private String imagem;
    
    private byte[] image;
	
	public AnalistaTotalDTO() {
		
	}

	public AnalistaTotalDTO(Analista analista) {
		this.id = analista.getId();
		this.password = analista.getPassword();
		this.nome = analista.getNome();
		this.perfil = analista.getPerfil();
		this.dataNascimento = analista.getDataNascimento();
		this.tipoAnalista = analista.getTipoAnalista();
		this.emailAnalista = analista.getEmailAnalista();
		this.cnpjAnalista = analista.getCnpjAnalista();
		this.cpfAnalista = analista.getCpfAnalista();
		this.contatoAnalista = analista.getContatoAnalista();
		this.crpAnalista = analista.getCrpAnalista();
		this.bairro = analista.getEnderecos().getBairro();
		this.cep = analista.getEnderecos().getCep();
		this.cidade = analista.getEnderecos().getCidade();
		this.complemento = analista.getEnderecos().getComplemento();
		this.estado = analista.getEnderecos().getEstado();
		this.logradouro = analista.getEnderecos().getLogradouro();
		this.numero = analista.getEnderecos().getNumero();
		this.imagem = analista.getImage();
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

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getCpfAnalista() {
		return cpfAnalista;
	}
	
	public String getCnpjAnalista() {
		return cnpjAnalista;
	}

	public void setCnpjAnalista(String cnpjAnalista) {
		this.cnpjAnalista = cnpjAnalista;
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

	public String getCrpAnalista() {
		return crpAnalista;
	}

	public void setCrpAnalista(String crpAnalista) {
		this.crpAnalista = crpAnalista;
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
