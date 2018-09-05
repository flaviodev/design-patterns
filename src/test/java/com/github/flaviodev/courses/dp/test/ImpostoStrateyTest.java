package com.github.flaviodev.courses.dp.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.flaviodev.courses.dp.model.Orcamento;
import com.github.flaviodev.courses.dp.model.Produto;
import com.github.flaviodev.courses.dp.model.impostos.ICMS;
import com.github.flaviodev.courses.dp.model.impostos.ISS;
import com.github.flaviodev.courses.dp.model.impostos.Imposto;

public class ImpostoStrateyTest {

	@Test
	public void deveComporOsImpostos() {

		Orcamento orcamento = Orcamento.builder().nomeCliente("José").nomeVendedor("João")
				.produto(Produto.builder().descricao("Notebook").quantidade(1).valor(1000).build()).build();

		Imposto imposto1 = new ICMS();
		Imposto imposto2 = new ISS();

		assertEquals(new Double(100), new Double(imposto1.calculaImposto(orcamento)));
		assertEquals(new Double(50), new Double(imposto2.calculaImposto(orcamento)));
	}
}
