package br.com.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import br.com.mvc.dao.ContatoDAO;
import br.com.mvc.modelo.Contato;


public class AdicionarContato implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String id = req.getParameter("id");
		Contato contato = new Contato();
		contato.setNome(req.getParameter("nome"));
		contato.setRg(req.getParameter("rg"));
		contato.setEndereco(req.getParameter("endereco"));
		contato.setDataNascimento(contato.convertData(req.getParameter("dataNascimento")));
		contato.setEmail(req.getParameter("email"));
		
		if(id != null){
			contato.setMatricula(Long.parseLong(id));
			new ContatoDAO((Connection)req.getAttribute("connection")).alterarContato(contato);
		}else{
			
			new ContatoDAO((Connection)req.getAttribute("connection")).inserir(contato);
		}
		
		return "Sistema?logica=ListarContatos";
	}
	
}
