package com.github.flaviodev.courses.dp;

import java.io.Serializable;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

import com.github.flaviodev.courses.dp.model.Orcamento;
import com.github.flaviodev.courses.dp.model.Produto;
import com.github.flaviodev.courses.dp.model.base.Entidade;
import com.github.flaviodev.courses.dp.observer.ImprimeOrcamento;

@SpringBootApplication
public class AplicacaoDesignPatterns {

	public static void main(String[] args) {
		SpringApplication.run(AplicacaoDesignPatterns.class);
	}

	
	public static <R extends JpaRepository<E, I>, E extends Entidade<I>, I extends Serializable> R getRepository(
			Class<R> classeRepositorio) {
			ApplicationContext context = Aplicacao.getContext();
		
			return context.getBean(classeRepositorio);
	}

	@Bean
	public CommandLineRunner demo() {
		return (args) -> {

			Orcamento orcamento = Orcamento.builderComAcoes(Arrays.asList(new ImprimeOrcamento())).nomeCliente("José")
					.nomeVendedor("João")
					.produto(Produto.builder().descricao("Notebook").quantidade(1).valor(1000).build()).build();

		};
	}
}
