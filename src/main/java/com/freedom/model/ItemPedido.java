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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_item_pedido")
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = -5446115930564539620L;

	@Id
	@SequenceGenerator(name = "tb_item_pedido_gen", sequenceName = "tb_item_pedido_id_item_pedido_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_item_pedido_gen")
	@Column(name="id_item_pedido")
	private Long codigo;
	
	@ManyToOne
	@JoinColumn(name = "id_lanche")
	private Lanche lanche;

	@ManyToOne
	@JoinColumn(name = "tipo_pao", referencedColumnName = "id_adicional")
	private Adicional tipoPao;
	
	@ManyToOne
	@JoinColumn(name = "tipo_queijo", referencedColumnName = "id_adicional")
	private Adicional tipoQueijo;
	
	@ManyToOne
	@JoinColumn(name = "tipo_recheio", referencedColumnName = "id_adicional")
	private Adicional tipoRecheio;
	
	@Enumerated(EnumType.STRING)
	private Saladas salada;
	
	private Integer quantidade = 1;
	private BigDecimal valor;
	
	@OneToMany(mappedBy = "itemPedido", cascade = CascadeType.PERSIST)
	private List<ItemMolho> itensMolho = new ArrayList<>();
	
	@OneToMany(mappedBy = "itemPedido", cascade = CascadeType.PERSIST)
	private List<ItemTempero> itensTempero = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="id_pedido")
	private Pedido pedido = new Pedido();
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Lanche getLanche() {
		return lanche;
	}

	public void setLanche(Lanche lanche) {
		this.lanche = lanche;
	}

	public Adicional getTipoPao() {
		return tipoPao;
	}

	public void setTipoPao(Adicional tipoPao) {
		this.tipoPao = tipoPao;
	}

	public Adicional getTipoQueijo() {
		return tipoQueijo;
	}

	public void setTipoQueijo(Adicional tipoQueijo) {
		this.tipoQueijo = tipoQueijo;
	}

	public Adicional getTipoRecheio() {
		return tipoRecheio;
	}

	public void setTipoRecheio(Adicional tipoRecheio) {
		this.tipoRecheio = tipoRecheio;
	}

	public Saladas getSalada() {
		return salada;
	}

	public void setSalada(Saladas salada) {
		this.salada = salada;
	}

	public List<ItemMolho> getItensMolho() {
		return itensMolho;
	}

	public void setItensMolho(List<ItemMolho> itensMolho) {
		this.itensMolho = itensMolho;
	}

	public List<ItemTempero> getItensTempero() {
		return itensTempero;
	}

	public void setItensTempero(List<ItemTempero> itensTempero) {
		this.itensTempero = itensTempero;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
			
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	public BigDecimal getValorTotal() {
		
		if(valor == null) {
			return BigDecimal.ZERO;
		}
		
		return valor.multiply(new BigDecimal(quantidade));
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
