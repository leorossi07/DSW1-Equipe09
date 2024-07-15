package br.ufscar.dc.dsw.domain;

public class Vaga{
	private Long id;
	private String titulo;
	private Float remuneracao;
	private Empresa empresa;
	private String dataLimiteInscricao;
	
	public Vaga(Long id) {
		this.id = id;
	}
	
	
	public Vaga(String titulo, Float remuneracao, Empresa empresa, String dataLimiteInscricao) {
		
		this.titulo = titulo;
		this.remuneracao = remuneracao;
		this.empresa = empresa;
		this.dataLimiteInscricao = dataLimiteInscricao;
	}
	
	public Vaga(Long id, String titulo, Float remuneracao, Empresa empresa, String dataLimiteInscricao) {
		this(titulo, remuneracao, empresa, dataLimiteInscricao);
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public Float getRemuneracao() {
		return remuneracao;
	}
	
	public void setRemuneracao(Float remuneracao) {
		this.remuneracao = remuneracao;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public String getDataLimiteInscricao() {
		return dataLimiteInscricao;
	}
	
	public void setDataLimiteInscricao(String dataLimiteInscricao) {
		this.dataLimiteInscricao = dataLimiteInscricao;
	}
}

