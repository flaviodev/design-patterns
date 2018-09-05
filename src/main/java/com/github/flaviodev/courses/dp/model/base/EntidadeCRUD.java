package com.github.flaviodev.courses.dp.model.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Optional;

import javax.persistence.Transient;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.flaviodev.courses.dp.AplicacaoDesignPatterns;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@SuppressWarnings("unchecked")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public abstract class EntidadeCRUD<I extends Serializable, E extends Entidade<I>, R extends JpaRepository<E, I>>
		extends Entidade<I> {

	private static final long serialVersionUID = 8260439965955361380L;

	@Transient
	private R repositorio;


	private Class<R> getClasseRepositorio() {
		return (Class<R>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
	}

	protected R getRepositorio() {
		if (repositorio == null)
			repositorio = AplicacaoDesignPatterns.getRepository(getClasseRepositorio());

		return repositorio;
	}

	@Transactional
	public E salvar() {
		return getRepositorio().save((E) this);
	}

	@Transactional
	public void excluir() {
		getRepositorio().delete((E) this);
	}

	public Optional<E> getPeloId(I id) {
		return getRepositorio().findById(id);
	}
}
