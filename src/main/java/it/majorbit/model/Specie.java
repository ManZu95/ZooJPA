package it.majorbit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Specie {
	@Id
	private Integer idSpecie;
	private String rarita;
	@OneToMany
	private Animale animale;
	@OneToOne
	private Settore settore;
	
	public Specie() {
		
	}

	public Integer getIdSpecie() {
		return idSpecie;
	}

	public void setIdSpecie(Integer idSpecie) {
		this.idSpecie = idSpecie;
	}

	public String getRarita() {
		return rarita;
	}

	public void setRarita(String rarita) {
		this.rarita = rarita;
	}

	public Animale getAnimale() {
		return animale;
	}

	public void setAnimali(Animale Animale) {
		this.animale= Animale;
	}

	public Settore getSettore() {
		return settore;
	}

	public void setSettore(Settore settore) {
		this.settore = settore;
	}

	@Override
	public String toString() {
		return "Specie [idSpecie=" + idSpecie + ", rarita=" + rarita + ", listaAnimali=" + animale + ", settore="
				+ settore + "]";
	}
	
	
	

}
