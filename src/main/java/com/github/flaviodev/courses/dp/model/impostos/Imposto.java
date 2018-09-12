package com.github.flaviodev.courses.dp.model.impostos;

import com.github.flaviodev.courses.dp.model.Orcamento;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class Imposto {

	private Imposto outroImposto;

	public Imposto(Imposto outroImposto) {
		this.outroImposto = outroImposto;
	}

	public abstract double calculaImposto(Orcamento orcamento);

	public double calculaOutroImposto(Orcamento orcamento) {
		if (outroImposto == null)
			return 0;

		return outroImposto.calculaImposto(orcamento);
	}
}
