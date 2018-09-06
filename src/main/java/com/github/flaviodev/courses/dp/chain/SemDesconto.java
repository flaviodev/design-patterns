package com.github.flaviodev.courses.dp.chain;

import com.github.flaviodev.courses.dp.model.Orcamento;

public class SemDesconto implements DescontoDeOrcamento {


	@Override
	public Double executaResponsabilidade(Orcamento entidade) {
		return 0.0;
	}

	@Override
	public void proximo(DescontoDeOrcamento proximo) {
	}
}
