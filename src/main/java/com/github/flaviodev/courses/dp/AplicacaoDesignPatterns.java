package com.github.flaviodev.courses.dp;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.flaviodev.courses.dp.model.Orcamento;
import com.github.flaviodev.courses.dp.model.Produto;
import com.github.flaviodev.courses.dp.observer.ImprimeOrcamento;
import com.github.flaviodev.courses.dp.observer.PersisteOrcamento;

@SpringBootApplication
public class AplicacaoDesignPatterns {

	public static void main(String[] args) {
		SpringApplication.run(AplicacaoDesignPatterns.class);
	}

	@Bean
	public CommandLineRunner demo() {
		return (args) -> {

			Orcamento.observableBuilder(Arrays.asList(new ImprimeOrcamento(), new PersisteOrcamento()))
					.nomeCliente("José").nomeVendedor("João")
					.produto(Produto.builder().descricao("Notebook").quantidade(1).valor(1000).build()).build();

		};
	}
}
