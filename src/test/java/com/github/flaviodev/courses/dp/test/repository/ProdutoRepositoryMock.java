package com.github.flaviodev.courses.dp.test.repository;

import com.github.flaviodev.courses.dp.model.Produto;
import com.github.flaviodev.courses.dp.persistence.UUIDGenerator;
import com.github.flaviodev.courses.dp.repository.ProdutoRepository;

public class ProdutoRepositoryMock extends JpaRepositoryMock<String, Produto> implements ProdutoRepository {

	@Override
	public String generateId() {
		return UUIDGenerator.uuid();
	}

}
