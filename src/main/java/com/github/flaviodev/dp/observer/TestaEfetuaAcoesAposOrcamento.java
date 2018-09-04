package com.github.flaviodev.dp.observer;

import com.github.flaviodev.dp.model.Orcamento;
import com.github.flaviodev.dp.model.Produto;

import lombok.extern.log4j.Log4j;

@Log4j
public class TestaEfetuaAcoesAposOrcamento {
	public static void main(String[] args) {

		Orcamento orcamento = Orcamento.builder().nomeCliente("José").nomeVendedor("João")
				.produto(Produto.builder().descricao("Notebook").quantidade(1).valor(1000).build()).build();

		log.info(orcamento.getValorTotal());
	}
}
