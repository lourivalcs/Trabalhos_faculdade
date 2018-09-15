package br.com.stop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.stop.model.Jogador;
import br.com.stop.model.socket.Respostas;
import br.com.stop.service.JogoService;

@Controller
public class JogoController {
	
	@Autowired
	JogoService jogoService;
	
	@MessageMapping(value="/stop")
	@SendTo("/socket/stop")
	public boolean stop(@RequestBody Jogador jogador) {
		return true;
	}
	
	@MessageMapping(value="/respostas")
	public void respostas(@RequestBody Respostas respostas) {
		jogoService.adicionaRespostasRodada(respostas);
	}
}
