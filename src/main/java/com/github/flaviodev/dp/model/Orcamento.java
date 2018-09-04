package com.github.flaviodev.dp.model;

import java.util.Arrays;
import java.util.List;

import com.github.flaviodev.dp.model.base.Entidade;
import com.github.flaviodev.dp.observer.ImprimeOrcamento;
import com.github.flaviodev.dp.observer.NotificaDepartamentoDeVendas;
import com.github.flaviodev.dp.observer.OrcamentoObserver;
import com.github.flaviodev.dp.observer.base.Observer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public @Getter @Setter class Orcamento extends Entidade<String> {

	private String id;
	private String nomeCliente;
	private String nomeVendedor;
	@Singular
	private @Getter List<Produto> produtos;

	public void adicionaItem(Produto produto) {

		getProdutos().add(produto);
	}

	public double getValorTotal() {

		return getProdutos().stream().mapToDouble(Produto::getTotalItem).sum();
	}

	public static OrcamentoBuilder builder() {
		return new CustomOrcamentoBuilder();
	}

	private static class CustomOrcamentoBuilder extends OrcamentoBuilder
			implements Observer<String, Orcamento, OrcamentoObserver> {

		@Override
		public Orcamento build() {
			Orcamento orcamento = super.build();
			executaAcoes(Arrays.asList(new ImprimeOrcamento(), new NotificaDepartamentoDeVendas()), orcamento);
			return orcamento;
		}
	}
}
