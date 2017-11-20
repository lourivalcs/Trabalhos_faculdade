package br.com.ftec.email.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class EmailUsuario implements Serializable{
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue
	private long IdEmailUsuario;
	private long IdEmail;
	private long IdUsuario;
	private int IdTipoEmailUsuario;
	@Transient
	@OneToOne(fetch=FetchType.EAGER)
	private Email email = new Email();
	@Transient
	@OneToOne(fetch=FetchType.EAGER)
	private Usuario usuario = new Usuario();
	@Transient
	@OneToOne(fetch=FetchType.EAGER)
	private TipoEmailUsuario tipoEmailUsuario = new TipoEmailUsuario();
	private boolean lido;
	
	public EmailUsuario() {
	}
	
	public EmailUsuario(long IdEmail, long IdUsuario, int IdTipoEmailUsuario, boolean lido) {
		this.IdEmail = IdEmail;
		this.IdUsuario = IdUsuario;
		this.IdTipoEmailUsuario = IdTipoEmailUsuario;
		this.lido = lido;
	}
	
	public long getIdEmailUsuario() {
		return IdEmailUsuario;
	}
	public void setIdEmailUsuario(long idEmailUsuario) {
		IdEmailUsuario = idEmailUsuario;
	}
	public long getIdEmail() {
		return IdEmail;
	}
	public void setIdEmail(long idEmail) {
		IdEmail = idEmail;
	}
	public long getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		IdUsuario = idUsuario;
	}
	public int getIdTipoEmailUsuario() {
		return IdTipoEmailUsuario;
	}
	public void setIdTipoEmailUsuario(int idTipoEmailUsuario) {
		IdTipoEmailUsuario = idTipoEmailUsuario;
	}
	public Email getEmail() {
		return email;
	}
	public void setEmail(Email email) {
		this.email = email;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public TipoEmailUsuario getTipoEmailUsuario() {
		return tipoEmailUsuario;
	}
	public void setTipoEmailUsuario(TipoEmailUsuario tipoEmailUsuario) {
		this.tipoEmailUsuario = tipoEmailUsuario;
	}
	public boolean isLido() {
		return lido;
	}
	public void setLido(boolean lido) {
		this.lido = lido;
	}	
}
