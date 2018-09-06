package com.github.flaviodev.courses.dp.chain;

import com.github.flaviodev.courses.dp.model.Orcamento;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access=AccessLevel.PRIVATE)
public class CalculadoraDeDescontoDeOrcamento {
	
	public static Double calcula(Orcamento orcamento) {
		DescontoDeOrcamento descontoCincoProdutos = new DescontoCincoProdutos();
		DescontoDeOrcamento descontoQuinhentosReais = new DescontoQuinhentosReais();
		DescontoDeOrcamento semDesconto = new SemDesconto();
		
		descontoCincoProdutos.proximo(descontoQuinhentosReais);
		descontoQuinhentosReais.proximo(semDesconto);
		
		return descontoCincoProdutos.executaResponsabilidade(orcamento);
	}
}
