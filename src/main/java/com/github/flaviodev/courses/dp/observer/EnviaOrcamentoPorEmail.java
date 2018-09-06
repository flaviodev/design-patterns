package com.github.flaviodev.courses.dp.observer;

import com.github.flaviodev.courses.dp.model.Orcamento;

import lombok.extern.java.Log;

@Log
public class EnviaOrcamentoPorEmail implements OrcamentoObserver {

	@Override
	public void atualiza(Orcamento orcamento) {
		orcamento.setEnviadoParaCliente(true);
		log.info("envia orcamento por e-mail para: " + orcamento.getNomeCliente());
	}
}
