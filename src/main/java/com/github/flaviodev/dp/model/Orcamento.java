package com.github.flaviodev.dp.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public @Data class Orcamento {

	private @Getter @Setter String nomeCliente;
	private @Getter @Setter String nomeVendedor;
	private @Getter List<ItemOrcamento> itens;

	public Orcamento() {

		itens = new ArrayList<>();
	}

	public void adicionaItem(ItemOrcamento item) {

		getItens().add(item);
	}

	public double getValorTotal() {

		return getItens().stream().mapToDouble(ItemOrcamento::getTotalItem).sum();
	}
}
