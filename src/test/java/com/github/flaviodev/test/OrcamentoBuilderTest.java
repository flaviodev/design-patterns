package com.github.flaviodev.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.github.flaviodev.dp.model.Produto;
import com.github.flaviodev.dp.model.Orcamento;

public class OrcamentoBuilderTest {

	@Test
	public void deveCriarOrcamento() {

		Orcamento orcamento = Orcamento.builder().nomeCliente("José").nomeVendedor("João")
				.produto(Produto.builder().descricao("Notebook").quantidade(1).valor(1000).build()).build();

		assertNotNull("Orcamento não deve ser null", orcamento);
		assertEquals("José", orcamento.getNomeCliente());
		assertEquals("João", orcamento.getNomeVendedor());

	}

}
