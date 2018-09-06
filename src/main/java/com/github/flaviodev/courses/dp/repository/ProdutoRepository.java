package com.github.flaviodev.courses.dp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.flaviodev.courses.dp.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, String> {

}
