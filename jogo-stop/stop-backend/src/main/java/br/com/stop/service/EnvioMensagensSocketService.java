package br.com.stop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class EnvioMensagensSocketService {
	
	@Autowired
    private static SimpMessagingTemplate controlador;
	
	//Threads para socket
	public static void socketIniciaRodada(int partida, int rodada, char letraRandomica, int limiteTempo) {
		new Thread() {
  			@Override
  			public void run() {
  				try{

					if(controlador == null)
						System.out.println("O Controlador esta null");
				 
					String mensagem = "{\"idPartida\":" + partida + ",\"idRodada\":" + rodada + ",\"iniciar\":" + true + "}";
					
					System.out.println(mensagem);
  					controlador.convertAndSend("/socket/rodada", mensagem);
  					
  					Thread.sleep(10000);
  					
  					mensagem = "{\"idPartida\":" + partida + ",\"idRodada\":" + rodada + ",\"tempo\":" + limiteTempo + ",\"letra\":\"" + letraRandomica + "\"}";
  					System.out.println(mensagem);
  					controlador.convertAndSend("/socket/enviaLetraRandomica", mensagem);
  					
  					System.out.println("enviado para iniciar a rodada");
  		        } catch (Exception e){
  		        	e.printStackTrace();
  		        }
  			}
  		}.start();
	}
	
	public static void enviarSocker(String socket, String mensagem) {
		new Thread() {
  			@Override
  			public void run() {
  				try{
  					controlador.convertAndSend(socket, mensagem);
  		        } catch (Exception e){
  		        	e.printStackTrace();
  		        }
  			}
  		}.start();
	}
	
	public static void setControlador(SimpMessagingTemplate template) {
	    controlador = template;
	  }
}
