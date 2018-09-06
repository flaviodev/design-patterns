package com.github.flaviodev.courses.dp.observer.base;

import java.io.Serializable;
import java.util.List;

import com.github.flaviodev.courses.dp.model.base.Entidade;

public interface Observer<I extends Serializable, E extends Entidade<I>, A extends AcaoObserver<E>> {

	List<A> getAcoes();

	default void executaAcoes(E entidade) {

		getAcoes().forEach(acao -> acao.executa(entidade));
	}
}
