package com.github.flaviodev.courses.dp.model.impostos;

import com.github.flaviodev.courses.dp.model.Orcamento;
import com.github.flaviodev.courses.dp.templatemethod.TemplateDeImpostoCondicional;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IPI extends TemplateDeImpostoCondicional {

	public IPI(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public boolean deveUsarTaxacaoMaxima(Orcamento orcamento) {
		return orcamento.getValorTotal() > 300;
	}

	@Override
	public double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValorTotal() * 0.07;
	}

	@Override
	public double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValorTotal() * 0.01;
	}
}
