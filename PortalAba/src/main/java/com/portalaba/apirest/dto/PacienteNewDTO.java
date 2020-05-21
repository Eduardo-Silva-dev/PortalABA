package com.portalaba.apirest.dto;

import java.util.Date;
import java.time.LocalDate;
import java.util.Calendar;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.portalaba.apirest.domain.Paciente;

public class PacienteNewDTO {

	private long id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=8, max=16, message="O tamanho deve ser entre 8 e 16 caracteres")
    private String password; 

	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
    private String nome;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
    private String nomeResponsavel;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimentoResponsavel;

	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=11, max=11, message="Preencha um cpf valido")
    private String cpfResponsavel;

	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=11, max=11, message="Preencha um numero de telefone valido valido")
    private String contatoResponsavel;

	@Length(min=11, max=11, message="Preencha um numero de telefone valido valido")
    private String contatoAuxiliar;
    
    @NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
    private String emailResponsavel;

    @NotEmpty(message="Preenchimento obrigatório")
	@Length(min=4, max=8, message="Escolha uma opção valida")
    private String nivelAltismo;
    
    @NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
    private String logradouro;
	
	private String complemento;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String bairro;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=8, max=8, message="Preencha um cep valido")
	private String cep;
	
	private String numero;
    
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String cidade;
    
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=2, max=2, message="O tamanho deve ser de 2 caracteres")
	private String estado;
	
	public PacienteNewDTO() {
		
	}
	
	public PacienteNewDTO(Paciente paciente) {
		
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
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

	public String getEmailResponsavel() {
		return emailResponsavel;
	}

	public void setEmailResponsavel(String emailResponsavel) {
		this.emailResponsavel = emailResponsavel;
	}

	public String getNivelAltismo() {
		return nivelAltismo;
	}

	public void setNivelAltismo(String nivelAltismo) {
		this.nivelAltismo = nivelAltismo;
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
