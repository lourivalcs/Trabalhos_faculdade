package br.com.mvc.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Contato {
	private long matricula;
	private String nome;
	private String rg;
	private String endereco;
	private Date dataNascimento;
	private String email;

	public Contato() {
	}

	public Contato(long matricula, String nome, String rg, String endereco, Date dataNascimento, String email) {
		this.matricula = matricula;
		this.nome = nome;
		this.rg = rg;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento; //this.convertData(dataNascimento);
		this.email = email;
	}

	public long getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date convertData(String dat) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date data = null;
		try {
			data = format.parse(dat);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return data;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}
}
