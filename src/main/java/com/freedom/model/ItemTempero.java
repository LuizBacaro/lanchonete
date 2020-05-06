package com.freedom.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_item_tempero")
public class ItemTempero implements Serializable {

	private static final long serialVersionUID = -5446115930564539620L;

	@Id
	@SequenceGenerator(name = "tb_item_tempero_gen", sequenceName = "tb_item_tempero_id_item_tempero_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_item_tempero_gen")
	@Column(name="id_item_tempero")
	private Long codigo;
	
	private Temperos tempero;
	
	@ManyToOne
	@JoinColumn(name="id_item_pedido")
	private ItemPedido itemPedido;
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Temperos getTempero() {
		return tempero;
	}

	public void setTempero(Temperos tempero) {
		this.tempero = tempero;
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
		ItemTempero other = (ItemTempero) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public ItemPedido getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(ItemPedido itemPedido) {
		this.itemPedido = itemPedido;
	}
}
