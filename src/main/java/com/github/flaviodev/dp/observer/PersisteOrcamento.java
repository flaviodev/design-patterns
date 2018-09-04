package com.github.flaviodev.dp.observer;

import com.github.flaviodev.dp.model.Orcamento;

import lombok.extern.log4j.Log4j;

@Log4j
public class PersisteOrcamento implements OrcamentoObserver {

	@Override
	public void executa(Orcamento orcamento) {

		orcamento.persiste();

		log.info("=====================================================================");
		log.info("Persistindo Orcamento:  " + orcamento);
		log.info("=====================================================================\n\n");
	}
}
