package br.com.senai.confeitaria.domain;

import java.util.List;

public class Bolo {

	private long id;
	private double precoKg;
	private Sabor sabor;
	private boolean disponivel;
	private List<Ingrediente> ingredientes;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
 
	public double getPrecoKg() {
		return precoKg;
	}
	public void setPrecoKg(double precoKg) {
		this.precoKg = precoKg;
	}
	public Sabor getSabor() {
		return sabor;
	}
	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	public boolean isDisponivel() {
		return disponivel;
	}
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	
	
}
