package br.com.stop.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.stop.model.Configuracoes;
import br.com.stop.service.JogoService;

@RestController
public class ConfiguracoesController {

	@Autowired
	JogoService jogoService;
	
	@RequestMapping(method=RequestMethod.GET, value="/buscaConfiguracaoPartida/{idPartida}")
	public Configuracoes buscaConfiguracaoPartida(@PathVariable @NotNull int idPartida) {
		return jogoService.buscaConfiguracoesPartida(idPartida);
	}
}
