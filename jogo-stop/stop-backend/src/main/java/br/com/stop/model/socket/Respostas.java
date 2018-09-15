package br.com.stop.model.socket;

public class Respostas {
	private int idPartida;
	private int idRodada;
	private int idJogador;
	private String[] respostas;
	
	public int getIdPartida() {
		return idPartida;
	}
	public int getIdRodada() {
		return idRodada;
	}
	public int getIdJogador() {
		return idJogador;
	}
	public String[] getRespostas() {
		return respostas;
	}
	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}
	public void setIdRodada(int idRodada) {
		this.idRodada = idRodada;
	}
	public void setIdJogador(int idJogador) {
		this.idJogador = idJogador;
	}
	public void setRespostas(String[] respostas) {
		this.respostas = respostas;
	}
}
