package br.com.fiap.controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class successCadastroPost
 */
@WebServlet("/successCadastroPost")
public class successCadastroPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String idSelecao = null;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	this.idSelecao = request.getParameter("idSelecao");
		response.sendRedirect("cadastroPostRealizado.jsp");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String botaoClicado = request.getParameter("adicionarMaisPost");

	    if ("Adicionar Mais Post".equals(botaoClicado)) {
	        String url = "novoPost?idSelecao=" + this.idSelecao;
	        response.sendRedirect(url);
	    } else {
	        String urlSair = "logarCliente?idSelecao=" + this.idSelecao;
	        response.sendRedirect(urlSair);
	    }
	}

}
