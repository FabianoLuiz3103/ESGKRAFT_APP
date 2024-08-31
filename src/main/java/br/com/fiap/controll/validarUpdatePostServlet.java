package br.com.fiap.controll;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.controller.PostController;

/**
 * Servlet implementation class validarUpdatePostServlet
 */
@WebServlet("/validarUpdatePost")
public class validarUpdatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String idP = null;
	private String tipo = null;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idPost = request.getParameter("idPost").toUpperCase();
		String tipoESG = request.getParameter("tipoESG");
		this.idP = idPost;
		this.tipo = tipoESG;
		//System.out.println(idPost);
	}

	
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensagem = request.getParameter("mensagemPost");
		Date dataUpdate = new Date();
		PostController postController = null;
		try {
			postController = new PostController();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		//System.out.println(idP);
		postController.alterarPost(mensagem, this.tipo, dataUpdate, this.idP);
		response.sendRedirect("successUpdatePost.jsp");
		
		postController.encerrar();
		
		
	}


}
