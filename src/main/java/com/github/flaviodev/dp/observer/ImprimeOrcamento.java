package com.github.flaviodev.dp.observer;

import com.github.flaviodev.dp.model.Orcamento;

import lombok.extern.log4j.Log4j;

@Log4j
public class ImprimeOrcamento implements OrcamentoObserver {

	@Override
	public void executa(Orcamento orcamento) {
		orcamento.setImpresso(true);
		log.info("imprime orcamento valor: " + orcamento.getValorTotal());
	}
}
