package br.com.stop.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import br.com.stop.model.Partida;
import br.com.stop.model.Rodada;

@Service
public final class ControladorService{
	
	//Início métodos de start de threads do controlador
	public static void iniciaThreadStartPartida() {
		new Thread() {
  			@Override
  			public void run() {
  				try{
  		            while(true) {
  		            	Thread.sleep(1000);
  		            	controlaInicioPartida();
  		            }
  		        } catch (Exception e){}
  			}
  		}.start();
	}
	
	public static void iniciaThreadControladorSTOP() {
		new Thread() {
  			@Override
  			public void run() {
  				try{
  		        	int cont = 0;
  		            while(true) {
  		            	Thread.sleep(1000);
  		            	controlaStopRodada(cont++);
  		            }
  		        } catch (Exception e){}
  			}
  		}.start();
	}
	
	public static void iniciaThreadValidacaoRespostas() {
		new Thread() {
  			@Override
  			public void run() {
  				try{
  		        	int cont = 0;
  		            while(true) {
  		            	Thread.sleep(1000);
  		            	controlaValidacaoResposta(cont++);
  		            }
  		        } catch (Exception e){}
  			}
  		}.start();
	}
	
	public static void iniciaThreadEncerramentoPartida() {
		new Thread() {
  			@Override
  			public void run() {
  				try{
  		        	int cont = 0;
  		            while(true) {
  		            	Thread.sleep(1000);
  		            	controlaEncerramentoPartida(cont++);
  		            }
  		        } catch (Exception e){}
  			}
  		}.start();
	}
	//Fim métodos de start de threads do controlador	
    
	private static void controlaInicioPartida() {
		for(Partida partida : JogoService.partidas) {
			int numRodada = partida.getNumRodadas();
			
			
			if(verificaQuantidadeMinimaJogadores(partida) && numRodada == 0) {
				
				char letraRandomica = geraLetraRandomica();
				partida.setNumRodadas(++numRodada);
				partida.getRodadas().add(new Rodada(numRodada, letraRandomica));
				EnvioMensagensSocketService.socketIniciaRodada(
												partida.getIdPartida(),
												numRodada,
												letraRandomica,
												partida.getConfiguracaoPartida().getLimiteTempo());
				partida.setEmCurso(true);
				
			}else if(numRodada < partida.getConfiguracaoPartida().getQtdRodadas() && numRodada > 0) {
				Rodada rodada = partida.getRodadas().stream().filter(f -> f.getIdRodada() == partida.getNumRodadas()).findFirst().get();
				if(!rodada.isJogando()) {
					char letraRandomica = geraLetraRandomica();
					partida.setNumRodadas(++numRodada);
					partida.getRodadas().add(new Rodada(numRodada, letraRandomica));
					EnvioMensagensSocketService.socketIniciaRodada(
													partida.getIdPartida(),
													numRodada,
													letraRandomica,
													partida.getConfiguracaoPartida().getLimiteTempo());
				}
			}
		}
  	}
  	
  	private static void controlaStopRodada(int cont) {
  		System.out.println("Teste stop Rodada " + cont);
  	}
  	
  	private static void controlaValidacaoResposta(int cont) {
  		System.out.println("Teste valida��o respostas " + cont);
  	}
  	
  	private static void controlaEncerramentoPartida(int cont) {
  		System.out.println("Teste encerramento partida " + cont);
  	}
	
  	
  	private static boolean verificaQuantidadeMinimaJogadores(Partida partida) {
  		if(partida.getJogadores().size() >= partida.getConfiguracaoPartida().getMinimoJogadores())
  			return true;
  		else
  			return false;
  	}
  	
  	
  	/*
  	 * métodos de auxilio - passar para outra classe
  	 */
  	private static char geraLetraRandomica() {
  		//65-90 A até Z maíusculos
  		return (char)((new Random().nextInt(26))+65);
  	}
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
    
  
  	
  	
  	/*private static boolean stopRodada(Jogador jogador) {
		boolean stopRodada = false;
		for (Partida partida : JogoService.partidas) {
			if(partida.getJogadores().stream().anyMatch(a -> a.getNome().equals(jogador.getNome()))) {
				partida.getRodadas().stream()
				.filter(f -> f.isJogando())
				.findFirst().get()
				.setJogando(false);
				stopRodada = true;
				break;
			}
		}
		
		return stopRodada;
	}*/
}
