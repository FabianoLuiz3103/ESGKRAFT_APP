package br.com.fiap.controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import br.com.fiap.controller.PostController;
import br.com.fiap.redeSocial.Post;

/**
 * Servlet implementation class updatePostServlet
 */
@WebServlet("/atualizarPost")
public class updatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String idPost= request.getParameter("idPost").toUpperCase();
	   // this.idC = idCliente;
	    PostController postController = null;

	    try {
	        postController = new PostController();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }

	    Post postRecuperado = null;

	    for (Post p : postController.listarPosts()) {
	        if (p.getIdPost().trim().equalsIgnoreCase(idPost.trim())) {
	            postRecuperado = p;
	            break;
	        }
	    }

	    if (postRecuperado != null) {
	    	String idP = postRecuperado.getIdPost();
	        String mensagem = postRecuperado.getMensagem();
	        String tipoESG = postRecuperado.getTipoESG();
	        String idResponsavel = postRecuperado.getIdCliente();
	     
	        

	       
	        if (idP != null && !idP.isEmpty() && mensagem != null && !mensagem.isEmpty() && tipoESG != null && !tipoESG.isEmpty() && idResponsavel != null && !idResponsavel.isEmpty()) {
	            Gson gson = new Gson();
	            JsonObject jsonPost = new JsonObject();
	            jsonPost.addProperty("idPost", idP);
	            jsonPost.addProperty("mensagem", mensagem); 
	            jsonPost.addProperty("tipoESG", tipoESG);
	            jsonPost.addProperty("idResponsavel", idResponsavel);
	          
	            response.setContentType("application/json");
	            response.getWriter().write(gson.toJson(jsonPost));
	        } else {
	          
	            response.setStatus(HttpServletResponse.SC_NOT_FOUND); 
	        }
	    } else {
	       
	        response.setStatus(HttpServletResponse.SC_NOT_FOUND); 
	    }
	    
	    postController.encerrar();
	}

	



}
