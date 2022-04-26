package it.majorbit.model;

import java.util.ArrayList;
import java.util.List;

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
	private List<Animale> lista = new ArrayList<>();
	@OneToOne
	private Settore settore;
	
	public Specie() {
		
	}
	

	public List<Animale> getLista() {
		return lista;
	}


	public void setLista(List<Animale> lista) {
		this.lista = lista;
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

	public Settore getSettore() {
		return settore;
	}

	public void setSettore(Settore settore) {
		this.settore = settore;
	}

	@Override
	public String toString() {
		return "Specie [idSpecie=" + idSpecie + ", rarita=" + rarita + ", listaAnimali=" + lista + ", settore="
				+ settore + "]";
	}
	
	
	

}
