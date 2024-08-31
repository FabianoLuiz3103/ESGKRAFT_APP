package br.com.fiap.controll;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.controller.PostController;
import br.com.fiap.redeSocial.Post;

/**
 * Servlet implementation class novoPostServlet
 */

@WebServlet("/novoPost")
public class novoPostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String idSelecao = null;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	this.idSelecao = request.getParameter("idSelecao");
    
    	response.sendRedirect("cadastrarPost.jsp");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
        String mensagem = request.getParameter("mensagem");
        String tipoESG = request.getParameter("tipoESG");
        String idCliente = (String) session.getAttribute("idCliente");

        PostController postController = null;
        Post post = null;

        	post = new Post(mensagem, tipoESG, idCliente, this.idSelecao, new Date());
        	try {
				postController = new PostController();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
        postController.salvarPost(post);
        request.setAttribute("post", post);
	    //response.sendRedirect("successCadastroPost");
	    
	    String url = "successCadastroPost?idSelecao=" + this.idSelecao;
	    response.sendRedirect(url);
	    
	    postController.encerrar();
        
    }

}