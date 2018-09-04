package com.github.flaviodev.dp.model.base;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import com.github.flaviodev.dp.persistence.Dao;

@MappedSuperclass
public abstract class Entidade<I extends Serializable> implements Serializable {

	private static final long serialVersionUID = 7373447920782854276L;

	@Version
	private Integer version;

	public abstract I getId();

	public Integer getVersion() {
		
		return version;
	}

	public boolean isTransient() {
		
		return getId() == null;
	}

	public EntityManager getEntityManager() {

		return Dao.getEntityManager();
	}

	@SuppressWarnings("unchecked")
	public <E extends Entidade<I>> E persiste() {

		E entidade = (E) this;
		EntityManager dao = getEntityManager();
		dao.getTransaction().begin();

		if (!isTransient())
			dao.persist(this);
		else
			entidade = (E) dao.merge(this);

		dao.getTransaction().commit();
		dao.close();

		return entidade;
	}

	public void exclui() {

		if (isTransient())
			throw new IllegalStateException("Entidade não está persistida");

		EntityManager dao = getEntityManager();
		dao.getTransaction().begin();
		dao.remove(dao.merge(this));
		dao.getTransaction().commit();
		dao.close();
	}
	
	@SuppressWarnings("unchecked")
	public <E extends Entidade<I>> E get(I id) {
		
		return (E) getEntityManager().find(getClass(), id);
	}

	@SuppressWarnings("unchecked")
	public <E extends Entidade<I>> List<E> get() {
		
		return Dao.createCriteria(getClass()).list();
	}

	
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		@SuppressWarnings("rawtypes")
		Entidade other = (Entidade) obj;
		if (getId() == null) {

			if (other.getId() != null)
				return false;

		} else if (!getId().equals(other.getId())) {

			return false;
		}

		return true;
	}
}