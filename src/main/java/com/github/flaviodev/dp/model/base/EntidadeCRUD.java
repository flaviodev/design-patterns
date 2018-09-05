package com.github.flaviodev.dp.model.base;

import java.io.Serializable;
import java.util.Optional;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@SuppressWarnings("unchecked")
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
public abstract class EntidadeCRUD<I extends Serializable, E extends Entidade<I>, R extends CrudRepository<E, I>> extends Entidade<I> {

	private static final long serialVersionUID = 8260439965955361380L;
	
	@Autowired
	private R repositorio;
	
	protected R getRepositorio() {
		return repositorio;
	}
	
	public E salvar() {
		return repositorio.save((E) this);
	}
	
	public void excluir() {
		repositorio.delete((E) this);
	}
	
	public Optional<E> getPeloId(I id) {
		return repositorio.findById(id);
	}
}
