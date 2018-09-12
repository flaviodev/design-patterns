package com.github.flaviodev.courses.dp.model.impostos;

import com.github.flaviodev.courses.dp.model.Orcamento;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ISS extends Imposto {

	public ISS(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public double calculaImposto(Orcamento orcamento) {
		return orcamento.getValorTotal() * 0.05 + calculaOutroImposto(orcamento);
	}

}
