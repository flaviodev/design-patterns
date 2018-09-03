package com.github.flaviodev.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.github.flaviodev.dp.builder.OrcamentoBuilder;
import com.github.flaviodev.dp.model.ItemOrcamento;
import com.github.flaviodev.dp.model.Orcamento;

public class OrcamentoBuilderTest {

	@Test
	public void deveCriarOrcamento() {

		Orcamento orcamento = new OrcamentoBuilder().paraCliente("José de Oliveira").doVendedor("Anselmo da Cruz")
				.adicionaItem(new ItemOrcamento("Notebook")).constroi();

		assertNotNull("Orcamento não deve ser null", orcamento);
		assertEquals("José de Oliveira", orcamento.getNomeCliente());
		assertEquals("Anselmo da Cruz", orcamento.getNomeVendedor());
		
		
	}

}
