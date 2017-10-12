package br.com.mvc.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class FiltraLogin implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest)request).getSession();
		String user = (String)session.getAttribute("usuario");
		String uri = ((HttpServletRequest)request).getRequestURI();
		String uriSistema = ((HttpServletRequest)request).getContextPath() + "/Sistema";
		String uriLogin = ((HttpServletRequest)request).getContextPath() + "/login.jsp";
		String logica = request.getParameter("logica");
		if(logica == null)
			logica="";
		
		if(user == null && (uri.equals(uriLogin) || uri.equals(uriSistema)) && !logica.equals("Login")){
			((HttpServletRequest)request).getRequestDispatcher("login.jsp").forward(request, response);
		}else if(user == null && !uri.equals(uriSistema)){
			((HttpServletRequest)request).getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			chain.doFilter(request, response);			
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
