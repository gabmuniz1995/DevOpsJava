package br.com.senai.confeitaria.domain;

public class Trigo extends Ingrediente {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private boolean integral;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isIntegral() {
		return integral;
	}

	public void setIntegral(boolean integral) {
		this.integral = integral;
	}

}
