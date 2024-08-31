package br.com.fiap.controll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.fiap.controller.PostController;
import br.com.fiap.redeSocial.Post;

/**
 * Servlet implementation class filterDoisServlet
 */
@WebServlet("/filterDois")
public class filterDoisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PostController postController = null;
		try {
			postController = new PostController();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		List<String> tipos = new ArrayList<>();
		for(Post p : postController.listarPosts()) {
			tipos.add(p.getTipoESG());
		}
	     int contE = Collections.frequency(tipos, "E");
	     int contS = Collections.frequency(tipos, "S");
	     int contG = Collections.frequency(tipos, "G");
	     Gson gson = new Gson();
	     int[] numeroTipo = {contE, contS, contG};
		 String quantidadeTipoJson = gson.toJson(numeroTipo);
		 response.setContentType("application/json");
		 response.getWriter().write(quantidadeTipoJson );
		 
		 postController.encerrar();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
