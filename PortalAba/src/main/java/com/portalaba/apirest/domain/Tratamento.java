package com.portalaba.apirest.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tratamento")
public class Tratamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;  
	
	@Column(name = "analista_id")
	private long analista;

	@Column(name = "acompanhante_id")
	private long acompanhante;

	@Column(name = "paciente_id")
	private long paciente;

	@Column(name = "endereco_arquivo")
	private String file;

	@Column(name = "data_Cadastro")
	private Date data_Cadastro;

	public Tratamento(long analista,long acompanhante ,long paciente, String file) {
		super();
		this.analista = analista;
		this.acompanhante = acompanhante;
		this.paciente = paciente;
		this.file = file;
		this.data_Cadastro = new Date();
	}
	
	public Tratamento() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAnalista() {
		return analista;
	}

	public void setAnalista(long analista) {
		this.analista = analista;
	}

	public long getAcompanhante() {
		return acompanhante;
	}

	public void setAcompanhante(long acompanhante) {
		this.acompanhante = acompanhante;
	}

	public long getPaciente() {
		return paciente;
	}

	public void setPaciente(long paciente) {
		this.paciente = paciente;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Date getData_Cadastro() {
		return data_Cadastro;
	}

	public void setData_Cadastro(Date data_Cadastro) {
		this.data_Cadastro = data_Cadastro;
	}
}
