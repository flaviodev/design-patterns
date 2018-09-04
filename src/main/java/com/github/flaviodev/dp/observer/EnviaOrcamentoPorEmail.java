package com.github.flaviodev.dp.observer;

import com.github.flaviodev.dp.model.Orcamento;

import lombok.extern.log4j.Log4j;

@Log4j
public class EnviaOrcamentoPorEmail implements OrcamentoObserver {

	@Override
	public void executa(Orcamento orcamento) {
		orcamento.setEnviadoParaCliente(true);
		log.info("envia orcamento por e-mail para: " + orcamento.getNomeCliente());
	}
}
