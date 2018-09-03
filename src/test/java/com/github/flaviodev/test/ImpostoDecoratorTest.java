package com.github.flaviodev.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.github.flaviodev.dp.builder.ItemOrcamentoBuilder;
import com.github.flaviodev.dp.builder.OrcamentoBuilder;
import com.github.flaviodev.dp.model.Orcamento;
import com.github.flaviodev.dp.model.impostos.ICMS;
import com.github.flaviodev.dp.model.impostos.ISS;

public class ImpostoDecoratorTest {

	@Test
	public void deveComporOsImpostos() {

		Orcamento orcamento = new OrcamentoBuilder().paraCliente("cliente").doVendedor("vendedor")
				.adicionaItem(
						new ItemOrcamentoBuilder().comDescricao("Notebook").comQuantidade(2).deValor(2500).constroi())
				.constroi();

		ICMS icmsCompostoComISS = new ICMS(new ISS());

		assertNotNull("Imposto composto não deve ser null", icmsCompostoComISS);
		assertEquals(new Double(750), new Double(icmsCompostoComISS.calculaImposto(orcamento)));
	}
}
