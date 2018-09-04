package com.github.flaviodev.dp.model;

import com.github.flaviodev.dp.model.base.Entidade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public @Getter @Setter class Produto extends Entidade<String> {

	private String id;
	private double valor;
	private String descricao;
	private double quantidade;

	public double getTotalItem() {
		return valor * quantidade;
	}
}
