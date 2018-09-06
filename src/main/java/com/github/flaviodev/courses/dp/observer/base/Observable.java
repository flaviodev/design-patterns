package com.github.flaviodev.courses.dp.observer.base;

import java.io.Serializable;
import java.util.List;

import com.github.flaviodev.courses.dp.model.base.Entidade;

public interface Observable<I extends Serializable, E extends Entidade<I>, O extends Observer<E>> {

	List<O> getObservers();

	default void adiciona(O observer) {
		getObservers().add(observer);
	}
	
	default void retira(O observer) {
		getObservers().remove(observer);
	}

	default void notifica(E entidade) {

		getObservers().forEach(observer -> observer.atualiza(entidade));
	}
}
