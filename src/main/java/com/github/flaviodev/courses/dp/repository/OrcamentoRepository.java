package com.github.flaviodev.courses.dp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.flaviodev.courses.dp.model.Orcamento;

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento, String>{

}
