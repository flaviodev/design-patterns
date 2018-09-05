package com.github.flaviodev.dp.observer;

import com.github.flaviodev.dp.model.Orcamento;

import lombok.extern.java.Log;

@Log
public class PersisteOrcamento implements OrcamentoObserver {

	@Override
	public void executa(Orcamento orcamento) {

		orcamento.salvar();

		log.info("=====================================================================");
		log.info("Persistindo Orcamento:  " + orcamento);
		log.info("=====================================================================\n\n");
	}
}
