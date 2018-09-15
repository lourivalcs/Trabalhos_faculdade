package br.com.stop.model;

public class Configuracoes {
	private String [] Categorias;
	private int minimoJogadores;
	private int maximoJogadores;
	private int limiteTempo;
	private int qtdRodadas;
	
	public Configuracoes () {
		String cat[] = {"Nome", "Cidade", "Carro","Fruta", "Animal"};
		this.setCategorias(cat);
		this.setMinimoJogadores(2);
		this.setMaximoJogadores(10);
		this.setLimiteTempo(60);
		this.setQtdRodadas(3);
	}
	
	public String[] getCategorias() {
		return Categorias;
	}
	public int getMinimoJogadores() {
		return minimoJogadores;
	}
	public int getMaximoJogadores() {
		return maximoJogadores;
	}
	public int getLimiteTempo() {
		return limiteTempo;
	}
	public int getQtdRodadas() {
		return qtdRodadas;
	}
	public void setCategorias(String[] categorias) {
		Categorias = categorias;
	}
	public void setMinimoJogadores(int minimoJogadores) {
		this.minimoJogadores = minimoJogadores;
	}
	public void setMaximoJogadores(int maximoJogadores) {
		this.maximoJogadores = maximoJogadores;
	}
	public void setLimiteTempo(int limiteTempo) {
		this.limiteTempo = limiteTempo;
	}
	public void setQtdRodadas(int qtdRodadas) {
		this.qtdRodadas = qtdRodadas;
	}
	
}
