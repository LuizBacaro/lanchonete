package com.freedom.service;

import java.util.List;
import java.util.Optional;

import com.freedom.model.Permissao;
import com.freedom.repository.Permissoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PermissaoService {
	
	@Autowired
	private Permissoes permissoes;
	
	
	@Transactional
	public Permissao cadastro(Permissao permissao){
		
		Optional<Permissao> cat = permissoes.findByNomeIgnoreCase(permissao.getNome());
		
		if(cat.isPresent()){
			
			throw new com.freedom.service.exception.PermissaoCadastradaException("Permissão já cadastrada!");
		}
		
		return permissoes.saveAndFlush(permissao);
		
	}
	
	public List<Permissao> findAllPermissoes(){
		return permissoes.findAll();
	} 

}
