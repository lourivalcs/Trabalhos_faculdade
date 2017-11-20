package br.com.ftec.email.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.ftec.email.modelo.Usuario;

public class UsuarioDAO {
	public Usuario existe(Usuario usuario) {

		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<Usuario> query = em.createQuery("select u from Usuario u where u.login = :pLogin and u.senha = :pSenha",Usuario.class);

		query.setParameter("pLogin", usuario.getLogin());
		query.setParameter("pSenha", usuario.getSenha());
		
		Usuario resultado = null;
		try {
			resultado = query.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}

		em.close();

		return resultado;
	}
	
	public void gravaUsuario(Usuario usuario) {
		if(usuario.getIdUsuario() == 0) {
			usuario = new DAO<Usuario>(Usuario.class).adiciona(usuario);
		}else {
			new DAO<Usuario>(Usuario.class).atualiza(usuario);
		}
	}
	
	public List<Usuario> buscaUsuarios(){
		return new DAO<Usuario>(Usuario.class).listaTodos();
	}
	
	public void removerUsuario(long idUsuario) {
		EntityManager em = new JPAUtil().getEntityManager();		

		em.getTransaction().begin();		
		Query query = em.createNativeQuery("DELETE FROM emailusuario where idUsuario = :pIdUsuario ");
		query.setParameter("pIdUsuario", idUsuario);		
		query.executeUpdate();
		
		query = em.createNativeQuery("DELETE FROM usuario where idUsuario = :pIdUsuario ");
		query.setParameter("pIdUsuario", idUsuario);		
		query.executeUpdate();		
		
		em.getTransaction().commit();
		
		em.close();
	}
}
