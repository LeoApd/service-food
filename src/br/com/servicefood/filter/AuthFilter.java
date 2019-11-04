package br.com.servicefood.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.servicefood.controller.ControllerLogin;

public class AuthFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		ControllerLogin usuarioLogado = (ControllerLogin) 
										((HttpServletRequest) req).getSession().getAttribute("controllerLogin");
		
		if(usuarioLogado == null || !usuarioLogado.isLoggerIn()) {
			String contextPath = ((HttpServletRequest) req).getContextPath();
			((HttpServletResponse) resp).sendRedirect(contextPath + "/login/login.xhtml");
		}else {
			//segue o fluxo
			chain.doFilter(req, resp);
		}
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	 public void init(FilterConfig arg0) throws ServletException {
	       // TODO Auto-generated method stub
	 
	  }

}
