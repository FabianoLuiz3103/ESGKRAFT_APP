package br.com.fiap.controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import br.com.fiap.controller.ClienteController;
import br.com.fiap.redeSocial.Cliente;

/**
 * Servlet implementation class updateClienteServlet
 */
@WebServlet("/atualizarCliente")
public class updateClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String idCliente = request.getParameter("idCliente").toUpperCase();
	   // this.idC = idCliente;
	    ClienteController clienteController = null;

	    try {
	        clienteController = new ClienteController();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }

	    Cliente clienteRecuperado = null;

	    for (Cliente c : clienteController.listarClientes()) {
	        if (c.getIdCliente().trim().equalsIgnoreCase(idCliente.trim())) {
	            clienteRecuperado = c;
	            break;
	        }
	    }

	    if (clienteRecuperado != null) {
	    	String idCli = clienteRecuperado.getIdCliente();
	        String nome = clienteRecuperado.getNome();
	        int idade = clienteRecuperado.getIdade();
	        String email = clienteRecuperado.getEmail();
	        String telefone = clienteRecuperado.getTelefone();
	        

	       
	        if (idCli != null && !idCli.isEmpty() && nome != null && !nome.isEmpty() && email != null && !email.isEmpty() && telefone != null && !telefone.isEmpty()) {
	            Gson gson = new Gson();
	            JsonObject jsonCliente = new JsonObject();
	            jsonCliente.addProperty("idCliente", idCli);
	            jsonCliente.addProperty("nome", nome); 
	            jsonCliente.addProperty("idade", idade);
	            jsonCliente.addProperty("email", email);
	            jsonCliente.addProperty("telefone", telefone);

	            response.setContentType("application/json");
	            response.getWriter().write(gson.toJson(jsonCliente));
	        } else {
	          
	            response.setStatus(HttpServletResponse.SC_NOT_FOUND); 
	        }
	    } else {
	       
	        response.setStatus(HttpServletResponse.SC_NOT_FOUND); 
	    }
	    
	    clienteController.encerrar();
	    
	    
	}

	



}
