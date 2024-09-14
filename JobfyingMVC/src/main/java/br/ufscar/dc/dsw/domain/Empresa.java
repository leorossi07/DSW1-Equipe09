package br.ufscar.dc.dsw.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import br.ufscar.dc.dsw.validation.UniqueCNPJ;

@Entity
@Table(name = "Empresa")
public class Empresa extends AbstractEntity<Long> {

    @UniqueCNPJ(message = "{Unique.empresa.CNPJ}")
    @NotBlank
    @Size(min = 18, max = 18, message = "{Size.empresa.CNPJ}")
    @Column(nullable = false, unique = true, length = 18) // Adjusted length to match size
    private String CNPJ;

    @NotBlank
    @Size(min = 3, max = 60)
    @Column(nullable = false, unique = true, length = 60)
    private String nome;

    @OneToMany(mappedBy = "empresa")
    @JsonIgnore
    private List<Vaga> vagas;
	
	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Vaga> getVagas() {
		return vagas;
	}

	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}
}