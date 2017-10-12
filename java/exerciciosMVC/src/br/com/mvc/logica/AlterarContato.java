package br.com.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import br.com.mvc.dao.ContatoDAO;

public class AlterarContato implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		long id = Long.parseLong(req.getParameter("id"));
		req.setAttribute("contato", new ContatoDAO((Connection)req.getAttribute("connection")).BuscaContato(id));
		return "Sistema?logica=ExibirFormAdicionarContato";
	}

}
