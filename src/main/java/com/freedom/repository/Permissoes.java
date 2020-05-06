package com.freedom.repository;

import java.util.Optional;

import com.freedom.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Permissoes extends JpaRepository<Permissao, Long> {
	Optional<Permissao> findByNomeIgnoreCase(String nome);
}
