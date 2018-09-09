package com.github.flaviodev.courses.dp.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.github.flaviodev.courses.dp.Aplicacao;
import com.github.flaviodev.courses.dp.model.Orcamento;
import com.github.flaviodev.courses.dp.model.Produto;
import com.github.flaviodev.courses.dp.observer.EnviaOrcamentoPorEmail;
import com.github.flaviodev.courses.dp.observer.ImprimeOrcamento;
import com.github.flaviodev.courses.dp.observer.PersisteOrcamento;
import com.github.flaviodev.courses.dp.repository.OrcamentoRepository;
import com.github.flaviodev.courses.dp.repository.ProdutoRepository;
import com.github.flaviodev.courses.dp.test.repository.OrcamentoRepositoryMock;
import com.github.flaviodev.courses.dp.test.repository.ProdutoRepositoryMock;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Aplicacao.class })
public class OrcamentoObserverTest {

	@Before
	public void preparaTeste() {
		mockStatic(Aplicacao.class);

		when(Aplicacao.getRepository(OrcamentoRepository.class)).thenReturn(new OrcamentoRepositoryMock());
		when(Aplicacao.getRepository(ProdutoRepository.class)).thenReturn(new ProdutoRepositoryMock());
	}

	@Test
	public void deveCriarOrcamentoComObserver() {

		Orcamento orcamento = Orcamento
				.observableBuilder(
						Arrays.asList(new ImprimeOrcamento(), new EnviaOrcamentoPorEmail(), new PersisteOrcamento()))
				.nomeCliente("José").nomeVendedor("João")
				.produto(Produto.builder().descricao("Notebook").quantidade(1).valor(1000).build()).build();

		assertThat(orcamento).isNotNull();
		assertThat(orcamento.getNomeCliente()).isEqualTo("José");
		assertThat(orcamento.getNomeVendedor()).isEqualTo("João");
		assertThat(orcamento.isImpresso()).isTrue();
		assertThat(orcamento.isEnviadoParaCliente()).isTrue();
	}

}
