package com.portalaba.apirest.domain;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	@Column(name = "nome_tratamento")
	private String nome;

	@Column(name = "paciente_id")
	private long paciente;

	@Column(name = "nome_paciente")
	private String nomePaciente;

	@Column(name = "nome_acompanhante")
	private String nomeAcompanhante;

	@Column(name = "nome_analista")
	private String nomeAnalista;

	@Column(name = "endereco_arquivo")
	private String file;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "data_Cadastro")
	private Date data_Cadastro;

	@Column(name = "data_envio")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date data_envio;

	
	
	public Tratamento(long analista, long acompanhante,  long paciente, String nome,String tipo,String nomePaciente,
			String nomeAcompanhante, String nomeAnalista) {
		super();
		this.analista = analista;
		this.acompanhante = acompanhante;
		this.nome = nome;
		this.paciente = paciente;
		this.nomePaciente = nomePaciente;
		this.nomeAcompanhante = nomeAcompanhante;
		this.nomeAnalista = nomeAnalista;
		this.tipo = tipo;
		this.data_Cadastro = new Date();
		this.data_envio = new Date(System.currentTimeMillis());
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getPaciente() {
		return paciente;
	}

	public void setPaciente(long paciente) {
		this.paciente = paciente;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getNomeAcompanhante() {
		return nomeAcompanhante;
	}

	public void setNomeAcompanhante(String nomeAcompanhante) {
		this.nomeAcompanhante = nomeAcompanhante;
	}

	public String getNomeAnalista() {
		return nomeAnalista;
	}

	public void setNomeAnalista(String nomeAnalista) {
		this.nomeAnalista = nomeAnalista;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getData_Cadastro() {
		return data_Cadastro;
	}

	public void setData_Cadastro(Date data_Cadastro) {
		this.data_Cadastro = data_Cadastro;
	}

	public Date getData_envio() {
		return data_envio;
	}

	public void setData_envio(Date data_envio) {
		this.data_envio = data_envio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (acompanhante ^ (acompanhante >>> 32));
		result = prime * result + (int) (analista ^ (analista >>> 32));
		result = prime * result + ((data_Cadastro == null) ? 0 : data_Cadastro.hashCode());
		result = prime * result + ((data_envio == null) ? 0 : data_envio.hashCode());
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nomeAcompanhante == null) ? 0 : nomeAcompanhante.hashCode());
		result = prime * result + ((nomeAnalista == null) ? 0 : nomeAnalista.hashCode());
		result = prime * result + ((nomePaciente == null) ? 0 : nomePaciente.hashCode());
		result = prime * result + (int) (paciente ^ (paciente >>> 32));
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tratamento other = (Tratamento) obj;
		if (acompanhante != other.acompanhante)
			return false;
		if (analista != other.analista)
			return false;
		if (data_Cadastro == null) {
			if (other.data_Cadastro != null)
				return false;
		} else if (!data_Cadastro.equals(other.data_Cadastro))
			return false;
		if (data_envio == null) {
			if (other.data_envio != null)
				return false;
		} else if (!data_envio.equals(other.data_envio))
			return false;
		if (file == null) {
			if (other.file != null)
				return false;
		} else if (!file.equals(other.file))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nomeAcompanhante == null) {
			if (other.nomeAcompanhante != null)
				return false;
		} else if (!nomeAcompanhante.equals(other.nomeAcompanhante))
			return false;
		if (nomeAnalista == null) {
			if (other.nomeAnalista != null)
				return false;
		} else if (!nomeAnalista.equals(other.nomeAnalista))
			return false;
		if (nomePaciente == null) {
			if (other.nomePaciente != null)
				return false;
		} else if (!nomePaciente.equals(other.nomePaciente))
			return false;
		if (paciente != other.paciente)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		StringBuilder builder = new StringBuilder();
		builder.append("NOVO TRATAMENTO: \n");
		builder.append("O Analista: ");
		builder.append(getNomeAnalista() + "\n");
		builder.append("Enviou um novo tramento para o seu Anjinho: ");
		builder.append(getNomePaciente() + "\n");
		builder.append("Tratamento enviado as: \n");
		builder.append(sdf.format(getData_Cadastro()) );
		return builder.toString();
	}
	
}
