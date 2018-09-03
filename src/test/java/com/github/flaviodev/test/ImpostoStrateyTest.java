package com.github.flaviodev.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.flaviodev.dp.builder.ItemOrcamentoBuilder;
import com.github.flaviodev.dp.builder.OrcamentoBuilder;
import com.github.flaviodev.dp.model.Orcamento;
import com.github.flaviodev.dp.model.impostos.ICMS;
import com.github.flaviodev.dp.model.impostos.ISS;
import com.github.flaviodev.dp.model.impostos.Imposto;

public class ImpostoStrateyTest {

	@Test
	public void deveComporOsImpostos() {

		Orcamento orcamento = new OrcamentoBuilder().paraCliente("cliente").doVendedor("vendedor")
				.adicionaItem(
						new ItemOrcamentoBuilder().comDescricao("Notebook").comQuantidade(1).deValor(2000).constroi())
				.constroi();
		
		Imposto imposto1 = new ICMS();
		Imposto imposto2 = new ISS();
		
		assertEquals(new Double(200), new Double(imposto1.calculaImposto(orcamento)));
		assertEquals(new Double(100), new Double(imposto2.calculaImposto(orcamento)));
	}
}
