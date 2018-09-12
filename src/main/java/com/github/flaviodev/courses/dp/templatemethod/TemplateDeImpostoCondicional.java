package com.github.flaviodev.courses.dp.templatemethod;

import com.github.flaviodev.courses.dp.model.Orcamento;
import com.github.flaviodev.courses.dp.model.impostos.Imposto;

import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
public abstract class TemplateDeImpostoCondicional extends Imposto {
	
	public  TemplateDeImpostoCondicional(Imposto outroImposto) {

		super(outroImposto);
	}
	
	public abstract boolean deveUsarTaxacaoMaxima(@NonNull Orcamento orcamento);
	
	public abstract double maximaTaxacao(@NonNull Orcamento orcamento);
	
	public abstract double minimaTaxacao(@NonNull Orcamento orcamento);
	
	@Override
	public final double calculaImposto(@NonNull Orcamento orcamento) {
		double valorImposto;
		
		if(deveUsarTaxacaoMaxima(orcamento))
			valorImposto = maximaTaxacao(orcamento);
		else 
			valorImposto = minimaTaxacao(orcamento);
		
		return valorImposto + calculaOutroImposto(orcamento);
	}
	
}
