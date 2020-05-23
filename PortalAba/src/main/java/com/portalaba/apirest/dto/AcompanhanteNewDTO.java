package com.portalaba.apirest.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AcompanhanteNewDTO {

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
    private String tipoAcompanhante;
    
    @NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
    private String emailAcompanhante;
    
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=11, max=11, message="O tamanho deve ter 11 caracteres")
    private String cpfAcompanhante;
    
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=11, max=11, message="O tamanho deve ter 11 caracteres")
    private String contatoAcompanhante;
    
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=1, max=20, message="O tamanho deve ser entre 1 e 20 caracteres")
    private String crpAcompanhante;
    
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
	
	//@NotBlank(message="Preenchimento obrigatório")
	private long analista;
	
	public AcompanhanteNewDTO() {
		
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

	public long getAnalista() {
		return analista;
	}

	public void setAnalista(long analista) {
		this.analista = analista;
	}
}
