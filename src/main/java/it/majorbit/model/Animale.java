package it.majorbit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Animale {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codice;
	private Double eta;
	private String nome;
	
	public Animale() {
		
	}
	
	public Animale(Integer codice, Double eta, String nome) {
		this.codice = codice;
		this.eta = eta;
		this.nome = nome;
	}

	public Integer getCodice() {
		return codice;
	}

	public void setCodice(Integer codice) {
		this.codice = codice;
	}

	public Double getEta() {
		return eta;
	}

	public void setEta(Double eta) {
		this.eta = eta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Animale [codice=" + codice + ", eta=" + eta + ", nome=" + nome + "]";
	}
	
	
}
