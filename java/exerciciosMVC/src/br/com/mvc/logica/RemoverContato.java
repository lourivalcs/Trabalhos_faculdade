package br.com.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import br.com.mvc.dao.ContatoDAO;

public class RemoverContato implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		long id = Long.parseLong(req.getParameter("id"));
		new ContatoDAO((Connection)req.getAttribute("connection")).removerContato(id);
		return "Sistema?logica=ListarContatos";
	}
}
