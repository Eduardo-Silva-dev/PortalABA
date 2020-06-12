package com.portalaba.apirest.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.portalaba.apirest.domain.Acompanhante;

public class AcompanhanteTotalDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

    private long id; 
    
    private String password; 

    private String nome;
    
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataNascimento;

    private String tipoAcompanhante;
    
    private String emailAcompanhante;
    
    private String cpfAcompanhante;
    
    private String contatoAcompanhante;
    
    private String crpAcompanhante;
    
    private String perfil;
    
    private String logradouro;
	
	private String complemento;
	
	private String bairro;
	
	private String cep;
	
	private String numero;
    
	private String cidade;
	
	private String estado;
	
	private byte[] image;
	
	@JsonIgnore
	private String imagem;
	
	public AcompanhanteTotalDTO() {
		
	}
	
	public AcompanhanteTotalDTO(Acompanhante acompanhante) {
		this.id = acompanhante.getId();
		this.password = acompanhante.getPassword();
		this.nome = acompanhante.getNome();
		this.perfil = acompanhante.getPerfil();
		this.dataNascimento = acompanhante.getDataNascimento();
		this.tipoAcompanhante = acompanhante.getTipoAcompanhante();
		this.emailAcompanhante = acompanhante.getEmailAcompanhante();
		this.cpfAcompanhante = acompanhante.getCpfAcompanhante();
		this.contatoAcompanhante = acompanhante.getContatoAcompanhante();
		this.crpAcompanhante = acompanhante.getCrpAcompanhante();
		this.bairro = acompanhante.getEnderecos().getBairro();
		this.cep = acompanhante.getEnderecos().getCep();
		this.cidade = acompanhante.getEnderecos().getCidade();
		this.complemento = acompanhante.getEnderecos().getComplemento();
		this.estado = acompanhante.getEnderecos().getEstado();
		this.logradouro = acompanhante.getEnderecos().getLogradouro();
		this.numero = acompanhante.getEnderecos().getNumero();
		this.imagem = acompanhante.getImage();
		
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
	
	public byte[] getImage() {
			return image;
	}

	public void setImage(byte[] img) {
		this.image = img;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
}
