package br.com.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import br.com.mvc.dao.ContatoDAO;

public class ListarContatos implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		 req.setAttribute("contatos", new ContatoDAO((Connection)req.getAttribute("connection")).BuscarContatos());
		 return "WEB-INF/jsp/listar-contatos.jsp";
	}

}
