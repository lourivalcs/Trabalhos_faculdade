package br.com.ftec.email.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.ftec.email.modelo.Email;
import br.com.ftec.email.modelo.EmailUsuario;

public class EmailDAO {
	
	public void gravaEmail(Email email, long idUsuarioEnvio) {
		Date data = new Date(Calendar.getInstance().getTimeInMillis());
		email.setDataEnvio(data);
		email = new DAO<Email>(Email.class).adiciona(email);		
		
		List<EmailUsuario> emailsUsuario = new ArrayList<EmailUsuario>();		
		
		for(int i = 0; i < email.getIdUsuarioEmails().size(); i++ )
		{
			long idUsuarioLong = Long.parseLong(email.getIdUsuarioEmails().get(i));
			emailsUsuario.add(new EmailUsuario(email.getIdEmail(), idUsuarioLong, 2, false));
		}
		
		emailsUsuario.add(new EmailUsuario(email.getIdEmail(), idUsuarioEnvio, 1, true));
		new DAO<EmailUsuario>(EmailUsuario.class).adicionaLista(emailsUsuario);
	}
	
	public List<Email> BuscaEmails(long idUsuario, int idTipoEmail){		
		EntityManager em = new JPAUtil().getEntityManager();
		
		 Query query = em.createNativeQuery("SELECT e.idEmail, e.assunto, e.texto, e.dataEnvio FROM email e JOIN emailusuario em on em.idEmail = e.idEmail WHERE em.idUsuario = :pIdUsuario and em.idTipoEmailUsuario = :pIdTipoEmailUsuario order by e.dataEnvio desc", Email.class);
		
		 query.setParameter("pIdUsuario", idUsuario);
		 query.setParameter("pIdTipoEmailUsuario", idTipoEmail);
		 
		 List<Email> result = query.getResultList();
		 em.close();
		 return result;
	}
	
	public void RemoveEmailUsuario(long idUsuario, long idEmail , int idTipoEmail) {
		EntityManager em = new JPAUtil().getEntityManager();
		

		em.getTransaction().begin();
		
		Query query = em.createNativeQuery("DELETE FROM emailusuario where idUsuario = :pIdUsuario and idTipoEmailUsuario = :pIdTipoEmailUsuario and idEmail = :pIdEmail ");
		query.setParameter("pIdUsuario", idUsuario);
		query.setParameter("pIdTipoEmailUsuario", idTipoEmail);
		query.setParameter("pIdEmail", idEmail);
		
		query.executeUpdate();
		
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	public long BuscaQtdEmailNaoLido(long idUsuario) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		 Query query = em.createNativeQuery("SELECT em.idUsuario FROM emailusuario em WHERE em.idUsuario = :pIdUsuario and em.idTipoEmailUsuario = :pIdTipoEmailUsuario and lido = :pLido");
		
		 query.setParameter("pIdUsuario", idUsuario);
		 query.setParameter("pIdTipoEmailUsuario", 2);
		 query.setParameter("pLido", 0);
		 
		 long result = query.getResultList().size();
		 em.close();
		 return result;
	}
}
