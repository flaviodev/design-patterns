package com.github.flaviodev.dp.builder;

import java.util.ArrayList;
import java.util.List;

import com.github.flaviodev.dp.model.ItemOrcamento;
import com.github.flaviodev.dp.model.Orcamento;
import com.github.flaviodev.dp.observer.AcaoAposCriarOrcamento;

public class OrcamentoBuilder {

	private String nomeCliente;
	private String nomeVendedor;
	private List<ItemOrcamento> itensOrcamento;
	private List<AcaoAposCriarOrcamento> acoes;

	public OrcamentoBuilder() {

		acoes = new ArrayList<>();
		itensOrcamento = new ArrayList<>();
	}

	public OrcamentoBuilder paraCliente(String nomeCliente) {

		this.nomeCliente = nomeCliente;
		return this;
	}

	public OrcamentoBuilder doVendedor(String nomeVendedor) {

		this.nomeVendedor = nomeVendedor;
		return this;
	}

	public OrcamentoBuilder adicionaItem(ItemOrcamento item) {

		itensOrcamento.add(item);
		return this;
	}

	public List<AcaoAposCriarOrcamento> getAcoes() {

		return acoes;
	}

	protected void setAcoes(List<AcaoAposCriarOrcamento> acoes) {

		this.acoes = acoes;
	}

	public OrcamentoBuilder adicionaAcao(AcaoAposCriarOrcamento acao) {

		getAcoes().add(acao);
		return this;
	}

	public Orcamento constroi() {
		Orcamento orcamento = new Orcamento();
		orcamento.setNomeCliente(nomeCliente);
		orcamento.setNomeVendedor(nomeVendedor);
		orcamento.getItens().addAll(itensOrcamento);

		getAcoes().forEach(acao -> acao.executa(orcamento));

		return orcamento;
	}

}
