package com.github.flaviodev.courses.dp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.github.flaviodev.courses.dp.model.base.EntidadeCRUD;
import com.github.flaviodev.courses.dp.observer.OrcamentoObserver;
import com.github.flaviodev.courses.dp.persistence.UUIDGenerator;
import com.github.flaviodev.courses.dp.repository.OrcamentoRepository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "produtos")
@EqualsAndHashCode(callSuper = true)
@Builder
public @Getter @Setter class Orcamento extends EntidadeCRUD<String, Orcamento, OrcamentoRepository> {

	private static final long serialVersionUID = 3770137614175816963L;

	@Id
	@GeneratedValue(generator = UUIDGenerator.NAME)
	@GenericGenerator(name = UUIDGenerator.NAME, strategy = UUIDGenerator.PACKAGE_PATH)
	@Column(name = "id_orcamento", length = 32)
	private String id;

	private String nomeCliente;
	private String nomeVendedor;
	private boolean enviadoParaCliente;
	private boolean impresso;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orcamento")
	private @Singular @Getter List<Produto> produtos;

	public void adicionaItem(Produto produto) {

		getProdutos().add(produto);
	}

	public double getValorTotal() {
		return getProdutos().stream().mapToDouble(Produto::getTotalItem).sum();
	}

	public static OrcamentoBuilder builderComAcoes(List<OrcamentoObserver> acoes) {
		return new OrcamentoComAcoesBuilder(acoes);
	}

}
