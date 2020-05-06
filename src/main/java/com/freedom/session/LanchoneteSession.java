package com.freedom.session;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.freedom.model.ItemPedido;
import com.freedom.model.Pedido;

@Component
@SessionScope
public class LanchoneteSession {

	private Pedido pedido = new Pedido();
	
	public void addItem(ItemPedido itemPedido) {
		pedido.setEndereco(itemPedido.getPedido().getEndereco());
		pedido.setNome(itemPedido.getPedido().getNome());
		pedido.getItensPedidos().add(itemPedido);
	}

	public List<ItemPedido> getItensPedidos() {
		return pedido.getItensPedidos();
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public void clear() {
		pedido = new Pedido();
	}
}
