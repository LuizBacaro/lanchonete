package com.freedom.service;

import java.util.List;
import java.util.Optional;

import com.freedom.model.Grupo;
import com.freedom.repository.Grupos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GrupoService {
	
	@Autowired
	private Grupos grupos;
	
	
	@Transactional
	public Grupo cadastro(Grupo grupo){
		
		Optional<Grupo> grp = grupos.findByNomeIgnoreCase(grupo.getNome());
		
		if(grp.isPresent()){
			
			throw new com.freedom.service.exception.GrupoCadastradoException("Grupo já cadastrado !");
		}
		
		return grupos.saveAndFlush(grupo);
		
	}
	
	
	@Transactional
	public Grupo cadastroAcesso(Grupo grupo){
		
		/*Optional<Categoria> cat = categorias.findByNomeIgnoreCase(categoria.getNome());
		
		if(cat.isPresent()){
			
			throw new NomeCategoriaCadastradoException("Categoria já cadastrada!");
		}*/
		
		return grupos.saveAndFlush(grupo);
		
	}
	
	public List<Grupo> findAllGrupos(){
		
		return grupos.findAll();
	}
	
	
}
