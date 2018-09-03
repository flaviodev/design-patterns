package com.github.flaviodev.dp.builder;

import org.apache.log4j.Logger;

import com.github.flaviodev.dp.model.ItemOrcamento;

public class ItemOrcamentoBuilder {

	private Logger logger = Logger.getLogger(ItemOrcamentoBuilder.class);

	private String descricao;
	private double quantidade;
	private double valor;

	public ItemOrcamentoBuilder comDescricao(String descricao) {

		this.descricao = descricao;
		return this;
	}

	public ItemOrcamentoBuilder comQuantidade(double quantidade) {

		this.quantidade = quantidade;
		return this;
	}

	public ItemOrcamentoBuilder deValor(double valor) {

		this.valor = valor;
		return this;
	}

	public ItemOrcamento constroi() {

		logger.info("Criando item do orçamento");

		ItemOrcamento item = new ItemOrcamento();
		item.setDescricao(descricao);
		item.setQuantidade(quantidade);
		item.setValor(valor);

		return item;
	}

}
