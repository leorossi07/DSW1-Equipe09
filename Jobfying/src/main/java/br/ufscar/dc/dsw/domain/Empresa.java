package br.ufscar.dc.dsw.domain;

public class Empresa {
	private Long id;
	private String cnpj;
	private String nome;
	private String descricao;
	private String cidade;
	private Usuario usuario;

	
	public Empresa(Long id, String cnpj, String nome, String descricao, String cidade, Usuario usuario) {
		this.id = id;
		this.cnpj = cnpj;
		this.nome = nome;
		this.descricao = descricao;
		this.cidade = cidade;
		this.usuario = usuario;

	}
	
	public Empresa(String cnpj, String nome) {
		this.cnpj = cnpj;
		this.nome = nome;
	}

	public Empresa(Long id, String cnpj, String nome) {
		this.id = id;
		this.cnpj = cnpj;
		this.nome = nome;
	}
	
	public Empresa(Long id) {
		this.id = id;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setID(Long id) {
		this.id = id;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	

}
