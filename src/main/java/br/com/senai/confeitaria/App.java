package br.com.senai.confeitaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.confeitaria.domain.ErroMsg;
import ch.qos.logback.core.db.dialect.MsSQLDialect;

/**
 * Hello world!
 *
 */
@RestController
@SpringBootApplication
@EnableAutoConfiguration
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@GetMapping(value="/home")
	public String start(){
		return "aplicação iniciada com sucesso";
	}
	
}
