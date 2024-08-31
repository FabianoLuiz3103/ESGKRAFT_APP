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
 * Servlet implementation class tableClienteServlet
 */
@WebServlet("/tableCliente")
public class tableClienteServlet extends HttpServlet {
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
		List<Cliente> clientes = new ArrayList<>();
		for(Cliente c: clienteController.listarClientes()) {
			clientes.add(c);
		}
		
		Gson gson = new Gson();
		String clientesJson = gson.toJson(clientes);
		
		response.setContentType("application/json");
		response.getWriter().write(clientesJson);
		
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
