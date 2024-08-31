package br.com.fiap.controll;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class tablePostServlet
 */
@WebServlet("/tablePost")
public class tablePostServlet extends HttpServlet {
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
		List<Post> posts = new ArrayList<>();
		for(Post p: postController.listarPosts()) {
			posts.add(p);
		}
		
		Gson gson = new Gson();
		String clientesJson = gson.toJson(posts);
		
		response.setContentType("application/json");
		response.getWriter().write(clientesJson);
		
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
