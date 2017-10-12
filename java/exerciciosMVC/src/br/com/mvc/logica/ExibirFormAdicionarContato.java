package br.com.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExibirFormAdicionarContato implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return "WEB-INF/jsp/adicionar-contato.jsp";
	}

}
