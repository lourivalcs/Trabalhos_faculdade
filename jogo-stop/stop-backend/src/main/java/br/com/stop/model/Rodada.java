package br.com.stop.model;

import java.util.ArrayList;
import java.util.List;

public class Rodada {
	private int idRodada;
	private List<LinhaPlanilha> linhasPlanilha;
	private char letra;
	private boolean isJogando;

	public Rodada() {
		
	}
	
	public Rodada(int idRodada, char letra) {
		this.idRodada = idRodada;
		this.letra = letra;
		this.isJogando = true;
		this.linhasPlanilha = new ArrayList<LinhaPlanilha>();				
	}
	
	
	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}

	public boolean isJogando() {
		return isJogando;
	}

	public void setJogando(boolean isJogando) {
		this.isJogando = isJogando;
	}

	public int getIdRodada() {
		return idRodada;
	}

	public List<LinhaPlanilha> getLinhasPlanilha() {
		return linhasPlanilha;
	}

	public void setIdRodada(int idRodada) {
		this.idRodada = idRodada;
	}

	public void setLinhasPlanilha(List<LinhaPlanilha> linhasPlanilha) {
		this.linhasPlanilha = linhasPlanilha;
	}
	
	
}
