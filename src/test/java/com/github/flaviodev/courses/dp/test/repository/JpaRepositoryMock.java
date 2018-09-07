package com.github.flaviodev.courses.dp.test.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.github.flaviodev.courses.dp.model.base.Entidade;

public abstract class JpaRepositoryMock<I extends Serializable, E extends Entidade<I>> implements JpaRepository<E, I> {

	private Map<I, E> entidades = new HashMap<>();

	private RuntimeException metodoNaoImplementadoParaOMetodo = new RuntimeException(
			"mock não implementado para o método");

	public abstract I generateId();

	@Override
	public Page<E> findAll(Pageable pageable) {
		throw metodoNaoImplementadoParaOMetodo;
	}

	@Override
	public <S extends E> S save(S entidade) {
		if (entidades == null)
			return null;

		if (entidade.getId() == null)
			entidade.setId(generateId());

		entidades.put(entidade.getId(), entidade);

		return entidade;
	}

	@Override
	public Optional<E> findById(I id) {
		return entidades.values().stream().filter(entidade -> entidade.getId().equals(id)).findFirst();
	}

	@Override
	public boolean existsById(I id) {
		return entidades.values().stream().filter(entidade -> entidade.getId().equals(id)).findFirst().isPresent();
	}

	@Override
	public long count() {
		return entidades.size();
	}

	@Override
	public void deleteById(I id) {
		entidades.remove(id);
	}

	@Override
	public void delete(E entidade) {
		if (entidade != null && existsById(entidade.getId()))
			entidades.remove(entidade.getId());
	}

	@Override
	public void deleteAll(Iterable<? extends E> entidadesARemover) {
		entidadesARemover.forEach(entidadeARemover -> delete(entidadeARemover));
	}

	@Override
	public void deleteAll() {
		entidades.clear();
	}

	@Override
	public <S extends E> Optional<S> findOne(Example<S> example) {
		throw metodoNaoImplementadoParaOMetodo;
	}

	@Override
	public <S extends E> Page<S> findAll(Example<S> example, Pageable pageable) {
		throw metodoNaoImplementadoParaOMetodo;
	}

	@Override
	public <S extends E> long count(Example<S> example) {
		throw metodoNaoImplementadoParaOMetodo;
	}

	@Override
	public <S extends E> boolean exists(Example<S> example) {
		throw metodoNaoImplementadoParaOMetodo;
	}

	@Override
	public void deleteAllInBatch() {
		throw metodoNaoImplementadoParaOMetodo;
	}

	@Override
	public void deleteInBatch(Iterable<E> arg0) {
		throw metodoNaoImplementadoParaOMetodo;
	}

	@Override
	public List<E> findAll() {
		return entidades.values().stream().collect(Collectors.toList());
	}

	@Override
	public List<E> findAll(Sort sort) {
		throw metodoNaoImplementadoParaOMetodo;
	}

	@Override
	public <S extends E> List<S> findAll(Example<S> arg0) {
		throw metodoNaoImplementadoParaOMetodo;
	}

	@Override
	public <S extends E> List<S> findAll(Example<S> arg0, Sort arg1) {
		throw metodoNaoImplementadoParaOMetodo;
	}

	@Override
	public List<E> findAllById(Iterable<I> ids) {
		return entidades.values().stream().filter(entidade -> {
			Iterator<I> iterator = ids.iterator();
			while (iterator.hasNext()) {
				I id = iterator.next();
				if (entidade.getId().equals(id))
					return true;
			}
			return false;
		}).collect(Collectors.toList());
	}

	@Override
	public void flush() {
		throw metodoNaoImplementadoParaOMetodo;
	}

	@Override
	public E getOne(I id) {
		return entidades.values().stream().filter(entidade -> entidade.getId().equals(id)).findAny().orElse(null);
	}

	@Override
	public <S extends E> List<S> saveAll(Iterable<S> entidadesASalvar) {
		List<S> entidadesSalvas = new ArrayList<>();
		Iterator<S> iterador = entidadesASalvar.iterator();

		while (iterador.hasNext()) {
			entidadesSalvas.add(save(iterador.next()));
		}

		return entidadesSalvas;
	}

	@Override
	public <S extends E> S saveAndFlush(S entidade) {
		return save(entidade);
	}

}
