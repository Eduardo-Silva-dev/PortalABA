package com.portalaba.apirest.dto;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AnalistaNewDTO {

	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=8, max=16, message="O tamanho deve ser entre 8 e 16 caracteres")
    private String password; 

	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
    private String nome;
    
	//@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataNascimento;

	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=1, max=20, message="O tamanho deve ser entre 1 e 20 caracteres")
    private String tipoAnalista;
    
    @NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
    private String emailAnalista;
    
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=11, max=11, message="O tamanho deve ter 11 caracteres")
    private String cpfAnalista;

	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=11, max=11, message="O tamanho deve ter 11 caracteres")
    private String contatoAnalista;
    
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=1, max=20, message="O tamanho deve ser entre 1 e 20 caracteres")
    private String crpAnalista;

	@Length(min=14, max=14, message="O tamanho deve ter 14 caracteres")
    private String cnpjAnalista;
    
    @NotEmpty(message="Preenchimento obrigatório")
   	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
    private String logradouro;
   	
   	private String complemento;
   	
   	@NotEmpty(message="Preenchimento obrigatório")
   	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
   	private String bairro;
   	
   	@NotEmpty(message="Preenchimento obrigatório")
   	@Length(min=8, max=8, message="O tamanho deve ser de 8 caracteres")
   	private String cep;
   	
   	private String numero;
       
   	@NotEmpty(message="Preenchimento obrigatório")
   	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
   	private String cidade;
       
   	@NotEmpty(message="Preenchimento obrigatório")
   	@Length(min=2, max=2, message="O tamanho deve ser de 2 caracteres")
   	private String estado;
	
	public AnalistaNewDTO() {
		
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

	public String getCrpAnalista() {
		return crpAnalista;
	}

	public void setCrpAnalista(String crpAnalista) {
		this.crpAnalista = crpAnalista;
	}

	public String getCnpjAnalista() {
		return cnpjAnalista;
	}

	public void setCnpjAnalista(String cnpjAnalista) {
		this.cnpjAnalista = cnpjAnalista;
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
}
