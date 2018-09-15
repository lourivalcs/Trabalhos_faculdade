package br.com.stop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.stop.model.Configuracoes;
import br.com.stop.model.Jogador;
import br.com.stop.model.LinhaPlanilha;
import br.com.stop.model.Partida;
import br.com.stop.model.Rodada;
import br.com.stop.model.socket.Respostas;

@Service
public class JogoService {

	public static List<Partida> partidas = new ArrayList<Partida>();
	
	public String adicinarJogadorPartida(Jogador jogador) {
		Partida partida = null;
		for (Partida part : partidas) {
			if(part.getJogadores().size() < part.getConfiguracaoPartida().getMaximoJogadores() && !part.isEmCurso()) {
				part.getJogadores().add(jogador);
				partida = part;
				break;
			}
		}
		
		if(partida == null) {
			partida = new Partida();
			partida.getJogadores().add(jogador);
			partidas.add(partida);
		}
		
		return "{\"idPartida\":" + partida.getIdPartida() + ",\"idJogador\":" + jogador.getIdJogador() + ",\"nome\":\"" + jogador.getNome() + "\"}";
	}
	
	public List<Jogador> retornaJogadoresPartida(int idPartida) {
		Partida part = null;
		for (Partida partida : partidas) {
			if(partida.getIdPartida() == idPartida){
				part = partida;
				break;
			}
		}
		
		return part != null ? part.getJogadores() : null;
	}
	
	public List<Partida> getPartidas() {
		return partidas;
	}
	
	public Configuracoes buscaConfiguracoesPartida(int idPartida) {
		return partidas.stream().filter(f -> f.getIdPartida() == idPartida).findFirst().get().getConfiguracaoPartida();
	}
	
	public void adicionaRespostasRodada(Respostas respostas) {
		Rodada rodada = partidas.stream()
				.filter(f -> f.getIdPartida() == respostas.getIdPartida())
				.findFirst()
				.get()
					.getRodadas()
					.stream()
					.filter(f -> f.getIdRodada() == respostas.getIdRodada())
					.findFirst()
					.get();
		
			rodada.getLinhasPlanilha()
						.add(new LinhaPlanilha(respostas.getIdJogador(), respostas.getRespostas()));
			rodada.setJogando(false);
		/*Rodada rodada = part.getRodadas().stream().filter(f -> f.getIdRodada() == respostas.getIdRodada()).findFirst().get();
		new LinhaPlanilha(respostas.getIdJogador(), respostas.getRespostas());
		rodada.getLinhasPlanilha()*/
	}
}
