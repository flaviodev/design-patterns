package com.github.flaviodev.courses.dp;

import java.io.Serializable;

import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;

import com.github.flaviodev.courses.dp.model.base.Entidade;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Aplicacao implements Serializable {

	private static final long serialVersionUID = -3954490013272185190L;

	public static <R extends JpaRepository<E, I>, E extends Entidade<I>, I extends Serializable> R getRepository(
			Class<R> classeRepositorio) {
		ApplicationContext context = ApplicationContextProvider.getContext();

		return context.getBean(classeRepositorio);
	}
}
