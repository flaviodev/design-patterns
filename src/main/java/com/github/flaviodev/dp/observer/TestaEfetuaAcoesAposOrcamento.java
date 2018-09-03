package com.github.flaviodev.dp.observer;

import com.github.flaviodev.dp.builder.ItemOrcamentoBuilder;
import com.github.flaviodev.dp.builder.OrcamentoBuilder;
import com.github.flaviodev.dp.model.Orcamento;

public class TestaEfetuaAcoesAposOrcamento {
	public static void main(String[] args) {

		Orcamento orcamento = new OrcamentoBuilder().paraCliente("cliente").doVendedor("vendedor")
				.adicionaItem(
						new ItemOrcamentoBuilder().comDescricao("Notebook").comQuantidade(2).deValor(2500).constroi())
				.adicionaAcao(new EnviaOrcamentoPorEmail()).adicionaAcao(new ImprimeOrcamento())
				.adicionaAcao(new NotificaDepartamentoDeVendas()).constroi();

		System.out.println(orcamento.getValorTotal());
	}
}
