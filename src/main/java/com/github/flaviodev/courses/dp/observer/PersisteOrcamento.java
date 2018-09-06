package com.github.flaviodev.courses.dp.observer;

import com.github.flaviodev.courses.dp.AplicacaoDesignPatterns;
import com.github.flaviodev.courses.dp.model.Orcamento;
import com.github.flaviodev.courses.dp.repository.OrcamentoRepository;

import lombok.extern.java.Log;

@Log
public class PersisteOrcamento implements OrcamentoObserver {

	@Override
	public void atualiza(Orcamento orcamento) {

		orcamento.salvar();

		log.info("=====================================================================");
		log.info("Persistindo Orcamento:  " + orcamento);
		log.info("=====================================================================\n\n");

		AplicacaoDesignPatterns.getRepository(OrcamentoRepository.class).findAll().forEach(System.out::println);

		log.info("=====================================================================\n\n");
	}
}
