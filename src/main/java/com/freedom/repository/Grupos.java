package com.freedom.repository;

import java.util.Optional;

import com.freedom.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Grupos extends JpaRepository<Grupo, Long> {
	Optional<Grupo> findByNomeIgnoreCase(String nome);
}
