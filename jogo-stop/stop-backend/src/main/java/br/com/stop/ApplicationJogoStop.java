package br.com.stop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.stop.service.ControladorService;

@SpringBootApplication
@EnableAutoConfiguration
public class ApplicationJogoStop {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationJogoStop.class, args);
		ControladorService.iniciaThreadStartPartida();
		//ControladorService.iniciaThreadControladorSTOP();
		//ControladorService.iniciaThreadValidacaoRespostas();
		//ControladorService.iniciaThreadEncerramentoPartida();
	}
}
