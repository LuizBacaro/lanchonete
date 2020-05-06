package com.freedom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freedom.model.Pedido;
import com.freedom.repository.Pedidos;

@Service
public class PedidoService {
	
	@Autowired
	private Pedidos pedidos;
	
	@Transactional
	public Pedido salvar(Pedido pedido){
		
		pedido.getItensPedidos().forEach(i -> {
			i.setPedido(pedido);
			i.getItensMolho().forEach( m -> m.setItemPedido(i));
			i.getItensTempero().forEach( t -> t.setItemPedido(i));
		});
		
		return pedidos.saveAndFlush(pedido);
	}

	public Pedido findOne(Long pedido) {
		return pedidos.getOne(pedido);
	}
	
}
