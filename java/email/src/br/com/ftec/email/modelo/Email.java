package br.com.ftec.email.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name = "Email")
public class Email implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long idEmail;
	private String assunto;
	private String texto;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEnvio;
	@Transient
	private List<String> idUsuarioEmails = new ArrayList<String>();
	
	public long getIdEmail() {
		return idEmail;
	}
	public void setIdEmail(long idEmail) {
		this.idEmail = idEmail;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getDataEnvio() {
		return dataEnvio;
	}
	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}
	public List<String> getIdUsuarioEmails() {
		return idUsuarioEmails;
	}
	public void setIdUsuarioEmails(ArrayList<String> idUsuarioEmails) {
		this.idUsuarioEmails = idUsuarioEmails;
	}
}
