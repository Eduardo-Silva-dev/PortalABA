//package com.portalaba.apirest.domain;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;
//import javax.validation.constraints.NotEmpty;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//@Entity
//@Table(name = "tratamento")
//public class Tratamento {
//	
//	@Id
//	@Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    protected Long id;  
//	
//	@NotEmpty
//	@Column(name = "titulo",length=60)
//	private String titulo;
//	
//	@Column(name = "subtitulo",length=100)
//	private String subtitulo;
//	
//	@NotEmpty
//	@Column(name = "descrição")
//	private String descrição;
//
//	@NotEmpty
//	@Column(name = "objetivos")
//	private List<String> objetivos = new ArrayList<>();
//	
//	@Column(name = "ambienteFisico")
//	private List<String> ambienteFisico = new ArrayList<>();  
//	
//	@Column(name = "material") 
//	private List<String> material = new ArrayList<>(); 
//	
//	@Column(name = "planejamentoDasSessões")
//	private List<String> planejamentoDasSessões = new ArrayList<>();
//	
//	@Column(name = "procedimento")
//	private String procedimento;
//	
//	@Column(name = "ajudas")
//	private List<String> ajudas = new ArrayList<>(); 
//	
//	@Column(name = "observações")
//	private List<String> observações = new ArrayList<>(); 
//	
//	@Column(name = "intruçõesSimples")
//	private List<String> intruçõesSimples = new ArrayList<>();
//	
//    @JsonIgnore
//	@ManyToMany(mappedBy="tratamento")
//	private List<Pessoa> pessoas = new ArrayList<>();
//    
//    @Column(name = "dataInicio",length=8)
//    private Date dataInicio;
//    
//	public Tratamento() {
//		super();
//	}
//	
//	public Tratamento(String titulo, String subtitulo, String descrição, List<String> objetivos,
//			List<String> ambienteFisico, List<String> material, List<String> planejamentoDasSessões,
//			String procedimento, List<String> ajudas, List<String> observações, List<String> intruçõesSimples) {
//		super();
//		this.titulo = titulo;
//		this.subtitulo = subtitulo;
//		this.descrição = descrição;
//		this.objetivos = objetivos;
//		this.ambienteFisico = ambienteFisico;
//		this.material = material;
//		this.planejamentoDasSessões = planejamentoDasSessões;
//		this.procedimento = procedimento;
//		this.ajudas = ajudas;
//		this.observações = observações;
//		this.intruçõesSimples = intruçõesSimples;
//		this.dataInicio = new Date();
//	}
//	
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public String getTitulo() {
//		return titulo;
//	}
//	public void setTitulo(String titulo) {
//		this.titulo = titulo;
//	}
//	public String getSubtitulo() {
//		return subtitulo;
//	}
//	public void setSubtitulo(String subtitulo) {
//		this.subtitulo = subtitulo;
//	}
//	public String getDescrição() {
//		return descrição;
//	}
//	public void setDescrição(String descrição) {
//		this.descrição = descrição;
//	}
//	public List<String> getObjetivos() {
//		return objetivos;
//	}
//	public void setObjetivos(List<String> objetivos) {
//		this.objetivos = objetivos;
//	}
//	public List<String> getAmbienteFisico() {
//		return ambienteFisico;
//	}
//	public void setAmbienteFisico(List<String> ambienteFisico) {
//		this.ambienteFisico = ambienteFisico;
//	}
//	public List<String> getMaterial() {
//		return material;
//	}
//	public void setMaterial(List<String> material) {
//		this.material = material;
//	}
//	public List<String> getPlanejamentoDasSessões() {
//		return planejamentoDasSessões;
//	}
//	public void setPlanejamentoDasSessões(List<String> planejamentoDasSessões) {
//		this.planejamentoDasSessões = planejamentoDasSessões;
//	}
//	public String getProcedimento() {
//		return procedimento;
//	}
//	public void setProcedimento(String procedimento) {
//		this.procedimento = procedimento;
//	}
//	public List<String> getAjudas() {
//		return ajudas;
//	}
//	public void setAjudas(List<String> ajudas) {
//		this.ajudas = ajudas;
//	}
//	public List<String> getObservações() {
//		return observações;
//	}
//	public void setObservações(List<String> observações) {
//		this.observações = observações;
//	}
//	public List<String> getIntruçõesSimples() {
//		return intruçõesSimples;
//	}
//	public void setIntruçõesSimples(List<String> intruçõesSimples) {
//		this.intruçõesSimples = intruçõesSimples;
//	}
//
//	public List<Pessoa> getPessoas() {
//		return pessoas;
//	}
//
//	public void setPessoas(List<Pessoa> pessoas) {
//		this.pessoas = pessoas;
//	} 	
//}
