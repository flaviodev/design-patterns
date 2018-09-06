package com.github.flaviodev.courses.dp.chain;

import com.github.flaviodev.courses.dp.model.Orcamento;

public class DescontoCincoProdutos implements DescontoDeOrcamento {

	private DescontoDeOrcamento proximo;

	@Override
	public Double executaResponsabilidade(Orcamento entidade) {
		if(entidade.getProdutos().size() >=5)
			return entidade.getValorTotal() * 0.1;
		else
			return proximo.executaResponsabilidade(entidade);
	}

	@Override
	public void proximo(DescontoDeOrcamento proximo) {
		this.proximo = proximo;
	}
}
