package br.com.senai.confeitaria.dao;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.senai.confeitaria.domain.Bolo;
import br.com.senai.confeitaria.domain.Confete;
import br.com.senai.confeitaria.domain.Ingrediente;
import br.com.senai.confeitaria.domain.Marca;
import br.com.senai.confeitaria.domain.Sabor;
import br.com.senai.confeitaria.domain.Trigo;

public class BoloDAO {

	private static List<Bolo> bolos;

	public BoloDAO() {
		if (bolos == null) {
			mock();
		}
	}

	private void mock() {
		bolos = new ArrayList<>();

		List<Ingrediente> ingredientes = new ArrayList<>();
		Trigo trigo = new Trigo();
		trigo.setId(1);
		trigo.setIntegral(true);
		trigo.setMarca(new Marca());
		trigo.getMarca().setId(1);
		trigo.getMarca().setNome("Dona Benta");
		trigo.setValidade(new Date());
		Confete confete = new Confete();
		confete.setId(1);
		confete.setMarca(new Marca());
		confete.getMarca().setId(1);
		confete.setValidade(new Date());
		confete.setColorido(true);

		ingredientes.add(trigo);
		ingredientes.add(confete);

		Bolo b1 = new Bolo();
		b1.setId(1);
		b1.setPrecoKg(20.3);
		b1.setSabor(new Sabor());
		b1.getSabor().setId(1);
		b1.getSabor().setDescricao("Morango");
		b1.setIngredientes(ingredientes);
		b1.setDisponivel(true);

		Bolo b2 = new Bolo();
		b2.setId(2);
		b2.setPrecoKg(23.3);
		b2.setSabor(new Sabor());
		b2.getSabor().setId(2);
		b2.getSabor().setDescricao("Chocolate");
		b2.setIngredientes(ingredientes);
		b2.setDisponivel(false);

		bolos.add(b1);
		bolos.add(b2);
	}

	public List<Bolo> consultar(boolean apenasDisponiveis) {

		if (apenasDisponiveis) {
			return bolos.stream().filter(x -> x.isDisponivel()).collect(Collectors.toList());
		} else
			return bolos;

	}

	public Bolo incluir(Bolo bolo) {
		bolo.setId(bolos.size() + 1);
		bolos.add(bolo);
		return bolo;
	}

	public Bolo atualizar(Bolo bolo) throws FileNotFoundException {

		for (int index = 0; index < bolos.size(); index++) {
			if (bolo.getId() == bolos.get(index).getId()) {
				bolo.setIngredientes(bolos.get(index).getIngredientes());
				bolos.add(index, bolo);
				return bolo;
			}
		}
		throw new FileNotFoundException("Bolo não localizado!");

	}

	public void remover(long id) throws FileNotFoundException{
		for(int index = 0; index < bolos.size(); index++){
			if(id== bolos.get(index).getId()){
				bolos.remove(index);
				return;
			}
		}
		throw new FileNotFoundException("Bolo não localizado!");
	}

}
