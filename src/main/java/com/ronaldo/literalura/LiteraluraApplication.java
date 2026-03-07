package com.ronaldo.literalura;

import com.ronaldo.literalura.principal.Principal;
import com.ronaldo.literalura.repository.AutorRepository;
import com.ronaldo.literalura.repository.LivroRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	private final LivroRepository livroRepository;
	private final AutorRepository autorRepository;

	public LiteraluraApplication(LivroRepository livroRepository, AutorRepository autorRepository) {
		this.livroRepository = livroRepository;
		this.autorRepository = autorRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) {

		Principal principal = new Principal(livroRepository, autorRepository);
		principal.exibeMenu();

	}
}