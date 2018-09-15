package br.com.stop.model;

public class LinhaPlanilha {
	private String[] respostas;
	private int pontuacao;
	private int idJogador;
	private boolean jogando;
	
	public LinhaPlanilha(int idJogador, String[] respostas) {
		this.idJogador = idJogador;
		this.respostas = respostas;
		this.jogando = false;
	}
	
	public String[] getRespostas() {
		return respostas;
	}
	public int getPontuacao() {
		return pontuacao;
	}
	public boolean isJogando() {
		return jogando;
	}
	public void setRespostas(String[] respostas) {
		this.respostas = respostas;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	public void setJogando(boolean jogando) {
		this.jogando = jogando;
	}
	public int getIdJogador() {
		return idJogador;
	}
	public void setIdJogador(int idJogador) {
		this.idJogador = idJogador;
	}	
}
