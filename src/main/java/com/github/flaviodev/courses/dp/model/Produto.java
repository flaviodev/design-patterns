package com.github.flaviodev.courses.dp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.github.flaviodev.courses.dp.model.base.Entidade;
import com.github.flaviodev.courses.dp.persistence.UUIDGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public @Getter @Setter class Produto extends Entidade<String> {

	private static final long serialVersionUID = -4986824735185394270L;

	@Id
	@GeneratedValue(generator = UUIDGenerator.NAME)
	@GenericGenerator(name = UUIDGenerator.NAME, strategy = UUIDGenerator.PACKAGE_PATH)
	@Column(name = "id_produto", length = 32)
	private String id;

	private double valor;
	private String descricao;
	private double quantidade;

	@ManyToOne(fetch = FetchType.LAZY)
	private Orcamento orcamento;

	public double getTotalItem() {
		return valor * quantidade;
	}
}
