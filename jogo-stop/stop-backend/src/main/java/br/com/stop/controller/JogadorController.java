package br.com.stop.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.stop.model.Jogador;
import br.com.stop.model.Partida;
import br.com.stop.service.EnvioMensagensSocketService;
import br.com.stop.service.JogoService;

@RestController
public class JogadorController {

	@Autowired
	JogoService jogoService;
	
	@RequestMapping(method=RequestMethod.GET, value="/listarJogador")
	public String listarJogador() {
		return "teste";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/adicionarJogador")
	public String adicionarJogador(@RequestBody Jogador jogador) {
		String mensagem = jogoService.adicinarJogadorPartida(jogador);
		EnvioMensagensSocketService.enviarSocker("/socket/novoJogador", mensagem);
		return mensagem;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/listarPartidas")
	public List<Partida> listarPartidas() {
		return jogoService.getPartidas();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/listarJogadoresPartida/{idPartida}")
	public List<Jogador> listarJogadoresPartida(@PathVariable @NotNull int idPartida) {
		return jogoService.retornaJogadoresPartida(idPartida);
	}
}
