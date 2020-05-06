package com.freedom.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = -5446115930564539620L;

	@Id
	@SequenceGenerator(name = "tb_pedido_gen", sequenceName = "tb_pedido_id_pedido_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_pedido_gen")
	@Column(name="id_pedido")
	private Long codigo;
	
	private String nome;
	private String endereco;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.PERSIST)
	private List<ItemPedido> itensPedidos = new ArrayList<>();
	
	@Column(name="forma_pagamento")
	@Enumerated(EnumType.STRING)
	private FormaPagamento formaPagamento;
	
	@Column(name="troco")
	@Enumerated(EnumType.STRING)
	private SimNao simNao;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	public BigDecimal getValorTotal() {
		return getItensPedidos()
				.stream()
				.map(ItemPedido::getValorTotal)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<ItemPedido> getItensPedidos() {
		return itensPedidos;
	}

	public void setItensPedidos(List<ItemPedido> itensPedidos) {
		this.itensPedidos = itensPedidos;
	}
	
	public boolean isNovo() {
		return getCodigo() == null;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public SimNao getSimNao() {
		return simNao;
	}

	public void setSimNao(SimNao simNao) {
		this.simNao = simNao;
	}

}
