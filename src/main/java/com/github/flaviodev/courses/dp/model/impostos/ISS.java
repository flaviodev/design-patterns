package com.github.flaviodev.courses.dp.model.impostos;

import com.github.flaviodev.courses.dp.model.Orcamento;

public class ISS extends Imposto {

	public ISS() {

	}

	public ISS(Imposto outroImposto) {

		super(outroImposto);
	}

	@Override
	public double calculaImposto(Orcamento orcamento) {

		return orcamento.getValorTotal() * 0.05 + calculaOutroImposto(orcamento);
	}

}
