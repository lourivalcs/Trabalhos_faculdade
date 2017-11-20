package br.com.ftec.email.modeloBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.ftec.email.dao.EmailDAO;
import br.com.ftec.email.dao.UsuarioDAO;
import br.com.ftec.email.modelo.Email;
import br.com.ftec.email.modelo.Usuario;

@RequestScoped
@ManagedBean
public class EmailBean {
	private Email email = new Email();
	private int tipoEmail = 2;
	
	public Email getEmail() {
		return email;
	}

	public void alteraTipoEmail(int idTipoEmail) {
		this.tipoEmail = idTipoEmail;
	}
	
	public List<Email> getEmails(){
		return new EmailDAO().BuscaEmails(retornaIdUsuario(), tipoEmail);
	}
	
	public void enviar() {    
	    new EmailDAO().gravaEmail(email, retornaIdUsuario());
	}
	
	public List<Usuario> getUsers(){
		return new UsuarioDAO().buscaUsuarios();
	}
	
	public void apagarEmail(long idEmailRemocao) {
		
		new EmailDAO().RemoveEmailUsuario(retornaIdUsuario(), idEmailRemocao, tipoEmail);
	}
	
	public void teste(javax.faces.event.AjaxBehaviorEvent event) {
		System.out.println("teste ajax");
	}

	public long getQtdLido() {
		return new EmailDAO().BuscaQtdEmailNaoLido(retornaIdUsuario());
	}
	
	private long retornaIdUsuario() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Usuario usuarioSessao = (Usuario)((HttpSession)fc.getExternalContext().getSession(false)).getAttribute("usuarioLogado");
		return usuarioSessao.getIdUsuario();
	}
	
}
