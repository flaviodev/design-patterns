package com.github.flaviodev.courses.dp.chain.base;

import java.io.Serializable;

import com.github.flaviodev.courses.dp.model.base.Entidade;

public interface ChainOfResponsability<R, I extends Serializable, E extends Entidade<I>, C extends ChainOfResponsability<R, I, E, C>> {
	R executaResponsabilidade(E entidade);

	void proximo(C responsavel);
}
