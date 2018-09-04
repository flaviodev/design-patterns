package com.github.flaviodev.dp.observer;

import com.github.flaviodev.dp.model.Orcamento;

public class ImprimeOrcamento implements OrcamentoObserver {

	@Override
	public void executa(Orcamento orcamento) {

		System.out.println("imprime orcamento valor: " + orcamento.getValorTotal());
	}
}
