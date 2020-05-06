package com.freedom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freedom.model.Adicional;
import com.freedom.model.TipoAdicional;

public interface Adicionais extends JpaRepository<Adicional, Long>{

	List<Adicional> findByTipo(TipoAdicional tipo);
	
}
