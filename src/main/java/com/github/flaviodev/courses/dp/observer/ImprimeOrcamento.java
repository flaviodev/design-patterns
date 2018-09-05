package com.github.flaviodev.courses.dp.observer;

import com.github.flaviodev.courses.dp.model.Orcamento;

import lombok.extern.java.Log;

@Log
public class ImprimeOrcamento implements OrcamentoObserver {

	@Override
	public void executa(Orcamento orcamento) {
		orcamento.setImpresso(true);
		log.info(orcamento.getPeloId("2222").toString());
		log.info("imprime orcamento valor: " + orcamento.getValorTotal());
	}
}