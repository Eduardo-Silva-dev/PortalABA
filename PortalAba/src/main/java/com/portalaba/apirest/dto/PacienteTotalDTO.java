package com.portalaba.apirest.dto;

import java.io.Serializable;
import java.sql.Date;
import com.portalaba.apirest.domain.Paciente;

public class PacienteTotalDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

    private long id; 
    
    private String password; 

    private String nome;
    
    private Date dataNascimento;
    
    private String nomePai;
    
    private String nomeMae;
    
    private Integer dataNascimentoPai;
    
    private Integer dataNascimentoMae;
    
    private String emailResponsavel;

    private String cpfPaciente;
    
    private String cpfPai;
    
    private String cpfMae;
    
    private String contatoPaciente;

    private String contatoPai;
    
    private String contatoMae;
    
    private String logradouro;
	
	private String complemento;
	
	private String bairro;
	
	private String cep;
	
	private String numero;
    
	private String cidade;
	
	private String estado;
    
	
	public PacienteTotalDTO() {
		
	}

	public PacienteTotalDTO(Paciente obj) {
		super();
		this.id = obj.getId();
		this.password = obj.getPassword();
		this.nome = obj.getNome();
		this.dataNascimento = obj.getDataNascimento();
		nomePai = obj.getNomePai();
		nomeMae = obj.getNomeMae();
		dataNascimentoPai = obj.getDataNascimentoPai();
		dataNascimentoMae = obj.getDataNascimentoMae();
		emailResponsavel = obj.getEmailResponsavel();
		cpfPaciente = obj.getCpfPaciente();
		cpfPai = obj.getCpfPai();
		cpfMae = obj.getCpfMae();
		contatoPaciente = obj.getContatoPaciente();
		contatoPai = obj.getContatoPai();
		contatoMae = obj.getContatoMae();
//		this.logradouro = obj.getEnderecos().getLogradouro();
//		this.complemento = obj.getEnderecos().getComplemento();
//		this.bairro = obj.getEnderecos().getBairro();
//		this.cep = obj.getEnderecos().getCep();
//		this.numero = obj.getEnderecos().getNumero();
//		this.cidade = obj.getEnderecos().getCidade();
//		this.estado = obj.getEnderecos().getEstado();
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
