package br.com.granbery.tigershoes.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception {
		
		String uri = request.getRequestURI();
		
		//if(uri.endsWith(suffix))
		
		if(request.getSession().getAttribute("clienteLogado")!=null) {
			
			return true;
		} else {
			response.sendRedirect("index.jsp");
			return false;
		}
		
	}

}
