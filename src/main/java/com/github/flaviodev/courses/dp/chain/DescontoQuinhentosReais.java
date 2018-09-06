package com.github.flaviodev.courses.dp.chain;

import com.github.flaviodev.courses.dp.model.Orcamento;

public class DescontoQuinhentosReais implements DescontoDeOrcamento {

	private DescontoDeOrcamento proximo;

	@Override
	public Double executaResponsabilidade(Orcamento entidade) {
		if(entidade.getValorTotal() >=500)
			return entidade.getValorTotal() * 0.07;
		else
			return proximo.executaResponsabilidade(entidade);
	}

	@Override
	public void proximo(DescontoDeOrcamento proximo) {
		this.proximo = proximo;
	}
}
