package br.com.fiap.controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class deletarPost
 */
@WebServlet("/deletarPost")
public class deletarPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String idPost = request.getParameter("idPost").toUpperCase();
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
		        String mensagem = postRecuperado.getMensagem();
		        String tipoESG = postRecuperado.getTipoESG();
		        String idResponsavel = postRecuperado.getIdCliente();

		        if (mensagem != null && !mensagem.isEmpty() && tipoESG != null && !tipoESG.isEmpty()&& idResponsavel != null && !idResponsavel.isEmpty()) {
		            Gson gson = new Gson();
		            JsonObject jsonCliente = new JsonObject();
		            jsonCliente.addProperty("mensagem", mensagem);
		            jsonCliente.addProperty("tipoESG", tipoESG);
		            jsonCliente.addProperty("idResponsavel", idResponsavel);

		            response.setContentType("application/json");
		            response.getWriter().write(gson.toJson(jsonCliente));
		        } else {
		            // Caso nome ou email sejam nulos ou vazios, retorne uma resposta indicando isso
		            response.setStatus(HttpServletResponse.SC_NOT_FOUND); // Por exemplo, pode retornar 404 (Not Found)
		        }
		    } else {
		        // Caso o cliente não seja encontrado, retorne uma resposta indicando isso
		        response.setStatus(HttpServletResponse.SC_NOT_FOUND); // Por exemplo, pode retornar 404 (Not Found)
		    }
		    postController.encerrar();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idInformado = request.getParameter("idPost").toUpperCase();
		PostController postController = null;

		try {
			postController = new PostController();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		boolean valid = false;
		Post postExc = null;
		for (Post p : postController.listarPosts()) {
			if (p.getIdPost().trim().equalsIgnoreCase(idInformado.trim())) {
				valid = true;
				postExc = p;
				break;
			}
		}

		if (valid && postExc != null) {
			postController.excluirPost(idInformado);

			request.setAttribute("postExcluido", postExc);
			request.setAttribute("operacaoSucesso", true);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/postExcluido.jsp");
			dispatcher.forward(request, response);
		} else {
			//request.setAttribute("mensagemErro", "O POST INFORMADO NÃO EXISTE! ");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/deletarPost.jsp");
			dispatcher.forward(request, response);
		}
		
		postController.encerrar();

	}

}
