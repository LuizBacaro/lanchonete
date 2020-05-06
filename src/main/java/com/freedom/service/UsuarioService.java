package com.freedom.service;

import java.util.List;
import java.util.Optional;

import com.freedom.model.Usuario;
import com.freedom.repository.Usuarios;
import com.freedom.service.exception.SenhaObrigatoriaUsuarioException;
import com.freedom.service.exception.UsuarioCadastradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class UsuarioService {
	
	@Autowired
	private Usuarios usuarios;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional
	public Usuario cadastro(Usuario usuario){
		Optional<Usuario> usu = usuarios.findByEmail(usuario.getEmail());
		if(usu.isPresent() && !usu.get().equals(usuario)){
			throw new UsuarioCadastradoException("Email já cadastrado !");
		}
		
		if (usuario.isNovo() && StringUtils.isEmpty(usuario.getSenha())) {
			throw new SenhaObrigatoriaUsuarioException("Senha é obrigatória para novo usuário");
		}
		
		if (usuario.isNovo() || !StringUtils.isEmpty(usuario.getSenha())) {
			usuario.setSenha(this.passwordEncoder.encode(usuario.getSenha()));
		} else if (StringUtils.isEmpty(usuario.getSenha())) {
			usuario.setSenha(usu.get().getSenha());
		}
		usuario.setConfirmacaoSenha(usuario.getSenha());
		
		if (!usuario.isNovo() && usuario.getAtivo() == null) {
			usuario.setAtivo(usu.get().getAtivo());
		}
		
		return usuarios.saveAndFlush(usuario);
		
	}
	
	public List<Usuario> findAll(){
		return usuarios.findAll();
	}
	

	@Transactional
	public void alterarStatus(Long[] codigos, StatusUsuario statusUsuario) {
		statusUsuario.executar(codigos, usuarios);
	}

}
