package com.freedom.repository.helper.usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.freedom.model.Usuario;

public class UsuariosImpl implements UsuariosQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Usuario> porEmailEAtivo(String email) {
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Usuario> q = cb.createQuery(Usuario.class);
		Root o = q.from(Usuario.class);
		q.select(o);
		q.where(cb.equal(cb.lower(o.get("email")), email.toLowerCase()), cb.isTrue(o.get("ativo")));

		try {
			return manager.createQuery(q).getResultList();
		}catch (NoResultException e){
			//Se não houver resultado na query
			return null;
		}
	}
	
	@Override
	public List<String> permissoes(Usuario usuario) {
		return manager.createQuery(
				"select distinct p.nome from Usuario u inner join u.grupos g inner join g.permissoes p where u = :usuario", String.class)
				.setParameter("usuario", usuario)
				.getResultList();
	}

	@Override
	public Usuario buscarComGrupos(Long codigo) {

		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Usuario> q = cb.createQuery(Usuario.class);
		Root o = q.from(Usuario.class);
		o.fetch("grupos", javax.persistence.criteria.JoinType.LEFT);
		q.select(o);
		q.where(cb.equal(o.get("codigo"), codigo));

		try {
			return manager.createQuery(q).getSingleResult();
		}catch (NoResultException e){
			//Se não houver resultado na query
			return null;
		}
	}

}