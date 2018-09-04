package com.github.flaviodev.dp.model;

import java.util.List;

import com.github.flaviodev.dp.model.base.Entidade;
import com.github.flaviodev.dp.observer.OrcamentoObserver;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public @Getter @Setter class Orcamento extends Entidade<String> {

	private String id;
	private String nomeCliente;
	private String nomeVendedor;
	private boolean enviadoParaCliente;
	private boolean impresso;
	private @Singular @Getter List<Produto> produtos;

	public void adicionaItem(Produto produto) {

		getProdutos().add(produto);
	}

	public double getValorTotal() {

		return getProdutos().stream().mapToDouble(Produto::getTotalItem).sum();
	}

	public static OrcamentoBuilder builderComAcoes(List<OrcamentoObserver> acoes) {
		return new OrcamentoComAcoesBuilder(acoes);
	}
}
