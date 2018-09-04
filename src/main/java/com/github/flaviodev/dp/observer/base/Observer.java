package com.github.flaviodev.dp.observer.base;

import java.io.Serializable;
import java.util.List;

import com.github.flaviodev.dp.model.base.Entidade;

public interface Observer<I extends Serializable, E extends Entidade<I>, A extends AcaoObserver<E>> {

	default void executaAcoes(List<A> acoes, E entidade) {

		acoes.forEach(acao -> acao.executa(entidade));
	}
}
