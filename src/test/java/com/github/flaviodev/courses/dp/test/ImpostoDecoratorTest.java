package com.github.flaviodev.courses.dp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.github.flaviodev.courses.dp.model.Orcamento;
import com.github.flaviodev.courses.dp.model.Produto;
import com.github.flaviodev.courses.dp.model.impostos.ICMS;
import com.github.flaviodev.courses.dp.model.impostos.ISS;

public class ImpostoDecoratorTest {

	@Test
	public void deveComporOsImpostos() {

		Orcamento orcamento = Orcamento.builder().nomeCliente("José").nomeVendedor("João")
				.produto(Produto.builder().descricao("Notebook").quantidade(1).valor(1000).build()).build();

		ICMS icmsCompostoComISS = new ICMS(new ISS());

		assertNotNull("Imposto composto não deve ser null", icmsCompostoComISS);
		assertEquals(new Double(150), new Double(icmsCompostoComISS.calculaImposto(orcamento)));
	}
}
