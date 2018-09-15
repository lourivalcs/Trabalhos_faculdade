package br.com.stop.model;

import java.util.ArrayList;
import java.util.List;

public class Partida {
	private static int contadorGeralPartidas = 0;
	
	private int idPartida;
	private boolean emCurso;
	private int numRodadas;
	private List<Jogador> jogadores;
	private List<Rodada> rodadas;
	private Configuracoes configuracaoPartida;
	
	public Partida() {
		this.idPartida = contadorGeralPartidas++;
		this.setConfiguracaoPartida(new Configuracoes());
		this.setNumRodadas(0);
		this.setEmCurso(false);
		this.setJogadores(new ArrayList<Jogador>());
		this.setRodadas(new ArrayList<Rodada>());
	}
	
	public boolean isEmCurso() {
		return emCurso;
	}
	public int getNumRodadas() {
		return numRodadas;
	}
	public List<Jogador> getJogadores() {
		return jogadores;
	}
	public List<Rodada> getRodadas() {
		return rodadas;
	}
	public Configuracoes getConfiguracaoPartida() {
		return configuracaoPartida;
	}
	public void setEmCurso(boolean emCurso) {
		this.emCurso = emCurso;
	}
	public void setNumRodadas(int numRodadas) {
		this.numRodadas = numRodadas;
	}
	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	public void setRodadas(List<Rodada> rodadas) {
		this.rodadas = rodadas;
	}
	public void setConfiguracaoPartida(Configuracoes configuracaoPartida) {
		this.configuracaoPartida = configuracaoPartida;
	}

	public int getIdPartida() {
		return idPartida;
	}
}
