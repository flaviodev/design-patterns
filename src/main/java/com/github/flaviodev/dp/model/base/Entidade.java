package com.github.flaviodev.dp.model.base;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import com.github.flaviodev.dp.persistence.Dao;

@SuppressWarnings("rawtypes")
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