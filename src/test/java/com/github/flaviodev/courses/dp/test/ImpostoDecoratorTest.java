package com.github.flaviodev.courses.dp.test;

import static org.assertj.core.api.Assertions.assertThat;

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

		assertThat(icmsCompostoComISS).isNotNull();
		assertThat(icmsCompostoComISS.calculaImposto(orcamento)).isEqualTo(150);
	}
}
