package com.github.flaviodev.dp.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public @Data class ItemOrcamento {

	public ItemOrcamento() {
	}
	
	public ItemOrcamento(String descricao) {
		this.descricao = descricao;
	}
	
	private @Getter @Setter double valor;
	private @Getter @Setter String descricao;
	private @Getter @Setter double quantidade;

	public double getTotalItem() {
		return valor * quantidade;
	}

}
