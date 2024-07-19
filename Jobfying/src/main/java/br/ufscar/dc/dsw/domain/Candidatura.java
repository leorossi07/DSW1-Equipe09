package br.ufscar.dc.dsw.domain;

public class Candidatura{
	
	private Long id;
	private String data;
	private String status;
	private Vaga vaga; // still to be implemented
	private Profissional profissional; // still to be implemented
	
	public Candidatura( String data, String status, Vaga vaga, Profissional profissional) {
	
		this.data = data;
		this.status = status;
		this.vaga = vaga;
		this.profissional = profissional;
	}
	
	public Candidatura(Long id, String data, String status, Vaga vaga, Profissional profissional) {
		this.id = id;
		this.data = data;
		this.status = status;
		this.vaga = vaga;
		this.profissional = profissional;
	}
	
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;	
	}
	
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Vaga getVaga() {
		return vaga;
	}
	
	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}
	
	public Profissional getProfissional() {
		return profissional;
	}
	
	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}
}
