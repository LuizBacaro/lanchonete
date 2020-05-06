package com.freedom.repository.helper.usuario;

import java.util.List;

import com.freedom.model.Usuario;

public interface UsuariosQueries {

	List<Usuario> porEmailEAtivo(String email);

	List<String> permissoes(Usuario usuario);
	
	Usuario buscarComGrupos(Long codigo);

}
