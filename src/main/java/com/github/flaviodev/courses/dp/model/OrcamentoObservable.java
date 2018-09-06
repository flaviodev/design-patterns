package com.github.flaviodev.courses.dp.model;

import java.util.ArrayList;
import java.util.List;

import com.github.flaviodev.courses.dp.observer.OrcamentoObserver;
import com.github.flaviodev.courses.dp.observer.base.Observable;

public class OrcamentoObservable extends Orcamento.OrcamentoBuilder
		implements Observable<String, Orcamento, OrcamentoObserver> {

	private List<OrcamentoObserver> observers = new ArrayList<>();

	@Override
	public List<OrcamentoObserver> getObservers() {
		return observers;
	}

	public OrcamentoObservable(List<OrcamentoObserver> acoes) {
		this.observers.addAll(acoes);
	}

	@Override
	public Orcamento build() {
		Orcamento orcamento = super.build();
		notifica(orcamento);
		return orcamento;
	}

}
