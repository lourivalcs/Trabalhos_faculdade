package br.com.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		if(email.equals("teste@ftec.com.br") && senha.equals("teste")){
			req.getSession().setAttribute("usuario", email);
			return "index.jsp";
		}else{
			return "login.jsp";
		}
	}

}
