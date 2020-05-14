package com.portalaba.apirest.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public abstract class Pessoa  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;  
	
	@NotEmpty
	@Column(name = "password",length=60)
    private String password; 

	@NotEmpty
    @Column(name = "nome",length=60,unique = true)
    private String nome;
    
    @Column(name = "dataNascimento",length=8)
    private LocalDate dataNascimento;
    
//    @JsonIgnore
//	@ManyToMany
//	@JoinTable(name = "PESSOA_TRATAMENTO",
//		joinColumns = @JoinColumn(name = "pessoa_id"),
//		inverseJoinColumns = @JoinColumn(name = "tratamento_id")
//	)
//    private List<Tratamento> tratamento = new ArrayList<>() ;
    
    public Pessoa() {
    	
    }
    
	public Pessoa(String password, String nome, LocalDate dataNascimento) {
		super();
		this.password = password;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
//	public List<Tratamento> getTratamento() {
//		return tratamento;
//	}
//
//	public void setTratamento(List<Tratamento> tratamento) {
//		this.tratamento = tratamento;
//	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
