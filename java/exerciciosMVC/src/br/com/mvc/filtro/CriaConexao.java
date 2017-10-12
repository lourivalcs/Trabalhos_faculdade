package br.com.mvc.filtro;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.mysql.jdbc.Connection;

import br.com.mvc.persistencia.SingletonConnection;

@WebFilter("/*")
public class CriaConexao implements Filter {

	@Override
	public void destroy() {
		
	}
	
	@Override
   	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Connection connection = new SingletonConnection().getConnection();
		try{
		    request.setAttribute("connection", connection);
		    
		    chain.doFilter(request, response);
	
		    connection.close();
		} catch (SQLException e) {
	        throw new ServletException(e);
	    }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
