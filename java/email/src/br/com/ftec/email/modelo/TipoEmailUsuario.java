package br.com.ftec.email.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TipoEmailUsuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int IdTipoEmailUsuario;
	private String Descricao;
	
	public int getIdTipoEmailUsuario() {
		return IdTipoEmailUsuario;
	}
	public void setIdTipoEmailUsuario(int idTipoEmailUsuario) {
		IdTipoEmailUsuario = idTipoEmailUsuario;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	
}
