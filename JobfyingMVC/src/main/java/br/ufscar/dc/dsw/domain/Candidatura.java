package br.ufscar.dc.dsw.domain;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference; // Import added

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Candidatura")
public class Candidatura extends AbstractEntity<Long> {

    @NotNull
    @Column(nullable = false)
    private String data;

    @NotNull
    @Column(nullable = false, columnDefinition = "DECIMAL(8,2) DEFAULT 0.0")
    private BigDecimal salario;

    @Column()
    private String status;

    @NotNull(message = "{NotNull.candidatura.vaga}")
    @ManyToOne
    @JoinColumn(name = "vaga_id")
    @JsonBackReference(value = "vaga-candidatura") // Annotation added with value
    private Vaga vaga;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    // Assuming you have a similar relationship in Usuario
    @JsonBackReference(value = "usuario-candidatura") // Annotation added with value
    private Usuario usuario;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
		setSalario(vaga.getSalario());
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getStatus(){
		return status;
	}

	public void setStatus(String status){
		this.status = status;
	}
}