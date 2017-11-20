package br.com.ftec.email.modeloBean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.ftec.email.dao.UsuarioDAO;
import br.com.ftec.email.modelo.Usuario;

@ManagedBean
@SessionScoped
public class LoginBean {
	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}
	
	public String logar() {

	    FacesContext context = FacesContext.getCurrentInstance();
	    usuario = new UsuarioDAO().existe(this.usuario);

	    if (usuario != null) {

	        context.getExternalContext().getSessionMap().put("usuarioLogado", usuario);
	        return "email?faces-redirect=true";
	    }else {
	    	usuario = new Usuario();
	    }

	    context.getExternalContext().getFlash().setKeepMessages(true);
	    context.addMessage(null, new FacesMessage("Usuário não encontrado"));

	    return "login?faces-redirect=true";
	}
	
	public String deslogar() {

	    FacesContext context = FacesContext.getCurrentInstance();
	    context.getExternalContext().getSessionMap().remove("usuarioLogado");
	    usuario = new Usuario();
	    return "login?faces-redirect=true";
	}
	
	public String cadastrar() {	    
		new UsuarioDAO().gravaUsuario(usuario);
		return this.logar();
	}
	
	public String apagarConta() {
		new UsuarioDAO().removerUsuario(usuario.getIdUsuario());
		FacesContext context = FacesContext.getCurrentInstance();
	    context.getExternalContext().getSessionMap().remove("usuarioLogado");
		usuario = new Usuario();
		return "login?faces-redirect=true";
	}
}
