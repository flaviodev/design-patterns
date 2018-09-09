package com.github.flaviodev.courses.dp.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.github.flaviodev.courses.dp.model.Orcamento;
import com.github.flaviodev.courses.dp.model.Produto;

public class OrcamentoBuilderTest {

	@Test
	public void deveCriarOrcamento() {

		Orcamento orcamento = Orcamento.builder().nomeCliente("José").nomeVendedor("João")
				.produto(Produto.builder().descricao("Notebook").quantidade(1).valor(1000).build()).build();

		assertThat(orcamento).isNotNull();
		assertThat( orcamento.getNomeCliente()).isEqualTo("José");
		assertThat( orcamento.getNomeVendedor()).isEqualTo("João");
	}

}
