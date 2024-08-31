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

import br.com.fiap.controller.ClienteController;
import br.com.fiap.redeSocial.Cliente;

/**
 * Servlet implementation class filterServlet
 */
@WebServlet("/filter")
public class filterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteController clienteController = null;
		try {
			clienteController = new ClienteController();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		List<Integer> idades = new ArrayList<>();
		for(Cliente c: clienteController.listarClientes()) {
			idades.add(c.getIdade());
		}
		
		Gson gson = new Gson();
		String idadesJson = gson.toJson(idades);
		
		response.setContentType("application/json");
		response.getWriter().write(idadesJson);
		
		clienteController.encerrar();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
