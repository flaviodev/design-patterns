package com.github.flaviodev.courses.dp.model.impostos;

import com.github.flaviodev.courses.dp.model.Orcamento;

public class ICMS extends Imposto {

	public ICMS() {

	}

	public ICMS(Imposto outroImposto) {

		super(outroImposto);
	}

	@Override
	public double calculaImposto(Orcamento orcamento) {

		return orcamento.getValorTotal() * 0.1 + calculaOutroImposto(orcamento);
	}

}
