package com.github.flaviodev.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.github.flaviodev.dp.model.Produto;
import com.github.flaviodev.dp.observer.EnviaOrcamentoPorEmail;
import com.github.flaviodev.dp.observer.ImprimeOrcamento;
import com.github.flaviodev.dp.observer.PersisteOrcamento;
import com.github.flaviodev.dp.model.Orcamento;

public class OrcamentoObserverTest {

	@Test
	public void deveCriarOrcamentoComObserver() {

		Orcamento orcamento = Orcamento
				.builderComAcoes(Arrays.asList(new ImprimeOrcamento(), new EnviaOrcamentoPorEmail(), new PersisteOrcamento()))
				.nomeCliente("José").nomeVendedor("João")
				.produto(Produto.builder().descricao("Notebook").quantidade(1).valor(1000).build()).build();

		assertNotNull("Orcamento não deve ser null", orcamento);
		assertEquals("José", orcamento.getNomeCliente());
		assertEquals("João", orcamento.getNomeVendedor());
		assertTrue("Devia ter sido impresso", orcamento.isImpresso());
		assertTrue("Devia ter sido enviado ao cliente", orcamento.isEnviadoParaCliente());
	}

}
