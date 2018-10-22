package br.com.senai.confeitaria.domain;

import java.io.Serializable;
import java.util.Date;

public abstract class Ingrediente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private Date validade;
	private Marca marca;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	 
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	
	
}
