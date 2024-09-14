package br.ufscar.dc.dsw.domain;

import java.math.BigDecimal;
import java.util.List; // Import added

import com.fasterxml.jackson.annotation.JsonBackReference; // Import added
import com.fasterxml.jackson.annotation.JsonIgnore;
// import com.fasterxml.jackson.annotation.JsonManagedReference; // Import added

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany; // Import added
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Vaga")
public class Vaga extends AbstractEntity<Long> {

    @NotBlank(message = "{NotBlank.vaga.titulo}")
    @Size(max = 60)
    @Column(nullable = false, length = 60)
    private String titulo;

    @NotBlank(message = "{NotBlank.vaga.descricao}")
    @Size(max = 120)
    @Column(nullable = false, length = 120) // Adjusted length to match size
    private String descricao;

    @NotNull(message = "{NotNull.vaga.cargaHoraria}")
    @Column(nullable = false)
    private Integer cargaHoraria;

    @NotNull(message = "{NotNull.vaga.salario}")
    @Column(nullable = false, columnDefinition = "DECIMAL(8,2) DEFAULT 0.0")
    private BigDecimal salario;

    @NotNull(message = "{NotNull.vaga.empresa}")
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    @JsonBackReference // Annotation added
    private Empresa empresa;

    @OneToMany(mappedBy = "vaga")
    @JsonIgnore
    private List<Candidatura> candidaturas;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}