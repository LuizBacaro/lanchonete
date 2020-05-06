package com.freedom.repository;

import java.util.List;
import java.util.Optional;

import com.freedom.model.Usuario;
import com.freedom.repository.helper.usuario.UsuariosQueries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Usuarios extends JpaRepository<Usuario, Long>, UsuariosQueries {
	Optional<Usuario> findByEmail(String email);
	List<Usuario> findByCodigoIn(Long[] codigos);
}
