package br.ufscar.dc.dsw.domain;

public class Profissional{
    
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String sexo;
    private String dataNascimento;
    private Usuario usuario;

    
    public Profissional(Long id, String nome, String cpf, String telefone, String sexo, String dataNascimento, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.usuario = usuario;
    }
    
    public Profissional(String nome, String cpf) {
    	this.nome = nome;
    	this.cpf = cpf;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getSexo() {
        return sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public String getDataNascimento() {
        return dataNascimento;
    }
    
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
