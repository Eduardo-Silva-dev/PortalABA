package com.portalaba.apirest.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class EmpresaNewDTO {

	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=8, max=16, message="O tamanho deve ser entre 8 e 16 caracteres")
    private String password; 

    @NotEmpty(message="Preenchimento obrigatório")
	@Length(min=14, max=14, message="O tamanho deve ter 14 caracteres")
    private String cnpj;

	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private	String razao_social;	

	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private	String nome_fantasia;	

	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
    private String contato;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=10, max=11, message="O tamanho deve ser entre 10 e 11 caracteres")
    private String telefone;

	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=11, max=11, message="O tamanho deve ter 11 caracteres")
    private String celular;
	
    @NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
    private String email;
	
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

	public EmpresaNewDTO() {
		super();
	}
	
	

	public EmpresaNewDTO(String password,String cnpj,String razao_social,String nome_fantasia,String contato,
			String telefone,String celular,String email,String logradouro,String complemento, String bairro,
			String cep,String numero,String cidade,String estado) {
		super();
		this.password = password;
		this.cnpj = cnpj;
		this.razao_social = razao_social;
		this.nome_fantasia = nome_fantasia;
		this.contato = contato;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRazao_social() {
		return razao_social;
	}

	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}

	public String getNome_fantasia() {
		return nome_fantasia;
	}

	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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