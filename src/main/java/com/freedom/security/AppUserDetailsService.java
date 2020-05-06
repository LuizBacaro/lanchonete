package com.freedom.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.freedom.model.Usuario;
import com.freedom.repository.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private Usuarios usuarios;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        List<Usuario> usuarioList = usuarios.porEmailEAtivo(mail);
        if(usuarioList == null || usuarioList.size() == 0)
            throw new UsernameNotFoundException("Usuário e/ou senha incorretos");

        Optional<Usuario> usuarioOptinal = usuarioList.stream().findFirst();
        Usuario usuario = usuarioOptinal.orElseThrow(() -> new UsernameNotFoundException("Usuário e/ou senha incorretos"));

        return new UsuarioSistema(usuario, getPermissoes(usuario));
    }

    private Collection<? extends GrantedAuthority> getPermissoes(Usuario usuario) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        List<String> permissoes = usuarios.permissoes(usuario);
        permissoes.forEach(p -> authorities.add(new SimpleGrantedAuthority(p.toUpperCase())));
        return authorities;
    }
}
