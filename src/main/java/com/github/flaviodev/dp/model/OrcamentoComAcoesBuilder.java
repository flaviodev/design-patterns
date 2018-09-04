package com.github.flaviodev.dp.model;

import java.util.ArrayList;
import java.util.List;

import com.github.flaviodev.dp.observer.OrcamentoObserver;
import com.github.flaviodev.dp.observer.base.Observer;


public class OrcamentoComAcoesBuilder extends Orcamento.OrcamentoBuilder
		implements Observer<String, Orcamento, OrcamentoObserver> {

	private List<OrcamentoObserver> acoes = new ArrayList<>();
	
	@Override
	public List<OrcamentoObserver> getAcoes() {
		return acoes;
	}
	
	public OrcamentoComAcoesBuilder(List<OrcamentoObserver> acoes) {
		this.acoes.addAll(acoes);
	}
	
	@Override
	public Orcamento build() {
		Orcamento orcamento = super.build();
		executaAcoes(orcamento);
		return orcamento;
	}
}
