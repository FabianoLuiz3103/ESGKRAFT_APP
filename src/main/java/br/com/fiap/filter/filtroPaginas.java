package br.com.fiap.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class filtroPaginas
 */
@WebFilter("/*")
public class filtroPaginas extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    public filtroPaginas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
	    String url = httpServletRequest.getRequestURI();
	    HttpSession sessao = httpServletRequest.getSession();
	    
	    if (url.endsWith("favicon.ico")) {
	        chain.doFilter(request, response);
	        return;
	    }

	    
	    
	    if (sessao.getAttribute("usuAutenticado") != null || 
	        url.endsWith("loginFuncionario.jsp") || 
	        url.endsWith("logarFuncionario") || 
	        url.endsWith("home.jsp") ||
	        url.endsWith(".css") ||  // Adicione aqui outras extensões de recursos estáticos
	        url.endsWith(".js") ||
	        url.endsWith(".png") ||
	        url.endsWith(".jpg")) {
	        chain.doFilter(request, response);
	    } else {
	        ((HttpServletResponse) response).sendRedirect("home.jsp");
	    }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
