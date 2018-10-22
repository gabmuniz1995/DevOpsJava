package br.com.senai.confeitaria.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.confeitaria.dao.BoloDAO;
import br.com.senai.confeitaria.domain.Bolo;
import br.com.senai.confeitaria.domain.ErroMsg;

@RestController
@RequestMapping("/bolo")
public class ControllerBolo {

	private BoloDAO boloDao;

	public ControllerBolo() {
		boloDao = new BoloDAO();
	}
	@GetMapping
	public ResponseEntity<List<Bolo>> obterBolos(
			@RequestParam(value = "apenasDisponiveis", defaultValue = "false") boolean apenasDisponiveis) {
		return  new ResponseEntity<>(boloDao.consultar(apenasDisponiveis), HttpStatus.OK);

	}
	@PostMapping
	public ResponseEntity<Bolo> incluirBolo(@RequestBody Bolo bolo) {
		return new ResponseEntity<>(boloDao.incluir(bolo), HttpStatus.OK);

	}

	@PutMapping
	public ResponseEntity<Object> atualizarBolo(@RequestBody Bolo bolo) {
		try {
			return new ResponseEntity<>(boloDao.atualizar(bolo), HttpStatus.OK);
		} catch (FileNotFoundException e) {
			return new ResponseEntity<>(new ErroMsg("Id do bolo informado não localizado!"), HttpStatus.NOT_FOUND);
		}

	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> removerBolo(@PathVariable long id) {
		try {
			boloDao.remover(id);
			return new ResponseEntity<>(null, HttpStatus.OK);
		} catch (FileNotFoundException e) {
			return new ResponseEntity<>(new ErroMsg("Id do bolo informado não localizado!"), HttpStatus.NOT_FOUND);
		}

	}

}
