package com.github.flaviodev.courses.dp.test.repository;

import com.github.flaviodev.courses.dp.model.Orcamento;
import com.github.flaviodev.courses.dp.persistence.UUIDGenerator;
import com.github.flaviodev.courses.dp.repository.OrcamentoRepository;

public class OrcamentoRepositoryMock extends JpaRepositoryMock<String, Orcamento> implements OrcamentoRepository {

	@Override
	public String generateId() {
		return UUIDGenerator.uuid();
	}

}
