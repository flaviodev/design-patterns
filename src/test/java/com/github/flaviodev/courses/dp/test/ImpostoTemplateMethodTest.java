package com.github.flaviodev.courses.dp.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.github.flaviodev.courses.dp.model.Orcamento;
import com.github.flaviodev.courses.dp.model.Produto;
import com.github.flaviodev.courses.dp.model.impostos.ICMS;
import com.github.flaviodev.courses.dp.model.impostos.IPI;

public class ImpostoTemplateMethodTest {
	
	@Test
	public void deveAplicarTaxacaoMaxima() {

		Orcamento orcamento = Orcamento.builder().nomeCliente("José").nomeVendedor("João")
				.produto(Produto.builder().descricao("Notebook").quantidade(1).valor(1000).build()).build();

		IPI ipi = new IPI();
		assertThat(ipi).isNotNull();
		assertThat(ipi.calculaImposto(orcamento)).isEqualTo(70);
	}
	
	@Test
	public void deveAplicarTaxacaoMinima() {

		Orcamento orcamento = Orcamento.builder().nomeCliente("José").nomeVendedor("João")
				.produto(Produto.builder().descricao("Mochila notebook").quantidade(1).valor(200).build()).build();

		IPI ipi = new IPI();
		assertThat(ipi).isNotNull();
		assertThat(ipi.calculaImposto(orcamento)).isEqualTo(2);
	}
	
	@Test
	public void deveAplicarTaxacaoMaximaCompostoDeOutroImposto() {

		Orcamento orcamento = Orcamento.builder().nomeCliente("José").nomeVendedor("João")
				.produto(Produto.builder().descricao("notebook").quantidade(1).valor(1000).build()).build();

		IPI ipi = new IPI(new ICMS());
		assertThat(ipi).isNotNull();
		assertThat(ipi.calculaImposto(orcamento)).isEqualTo(170);
	}
}

