package br.com.stop.model;

public class Jogador {
	
	private static int idJogadorGeral = 0;
	
	private int idJogador;
	private String nome;
	
	public Jogador() {
		this.idJogador = idJogadorGeral++;
	}
	
	/*public Jogador(String nome) {
		this.idJogador = idJogadorGeral++;
		this.nome = nome;
	}*/
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdJogador() {
		return idJogador;
	}

	public void setIdJogador(int idJogador) {
		this.idJogador = idJogador;
	}
}
