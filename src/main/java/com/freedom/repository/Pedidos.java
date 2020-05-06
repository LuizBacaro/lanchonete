package com.freedom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freedom.model.Pedido;

public interface Pedidos extends JpaRepository<Pedido, Long> {

}
