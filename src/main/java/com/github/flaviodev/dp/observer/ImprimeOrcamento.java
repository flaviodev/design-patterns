package com.github.flaviodev.dp.observer;

import com.github.flaviodev.dp.model.Orcamento;

import lombok.extern.java.Log;

@Log
public class ImprimeOrcamento implements OrcamentoObserver {

	@Override
	public void executa(Orcamento orcamento) {
		orcamento.setImpresso(true);
		log.info("imprime orcamento valor: " + orcamento.getValorTotal());
	}
}
