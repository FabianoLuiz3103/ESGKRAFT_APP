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

import br.com.fiap.controller.ClienteController;
import br.com.fiap.redeSocial.Cliente;

/**
 * Servlet implementation class deletarCliente
 */
@WebServlet("/deletarCliente")
public class deletarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String idCliente = request.getParameter("idCliente");
	    ClienteController clienteController = null;
	    
	    if (idCliente == null || idCliente.isEmpty()) {
	        // O parâmetro idCliente não está presente na URL, redirecione para a página de exclusão sem a mensagem de erro
	        response.sendRedirect("/SprintFinal/deletarCliente.jsp");
	        return; // Encerre o método, não há mais nada a fazer
	    }

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
	        String nome = clienteRecuperado.getNome();
	        String email = clienteRecuperado.getEmail();

	       
	        if (nome != null && !nome.isEmpty() && email != null && !email.isEmpty()) {
	            Gson gson = new Gson();
	            JsonObject jsonCliente = new JsonObject();
	            jsonCliente.addProperty("nome", nome); 
	            jsonCliente.addProperty("email", email); 

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

	
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String idInformado = request.getParameter("idCliente").toUpperCase();
	    System.out.println(idInformado);
	    String idClienteUpper = idInformado.toUpperCase();
	    ClienteController clienteController = null;

	    try {
	        clienteController = new ClienteController();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	    
	    Cliente clienteExc = null;
	    boolean validTudo = false;
	    
	    for (Cliente c : clienteController.listarClientes()) {
	        if (c.getIdCliente().trim().equalsIgnoreCase(idClienteUpper.trim())) {
	            validTudo = true;
	            clienteExc = c;
	            break;
	        }
	    }
	    
	    if (validTudo) {
	        // Verifique se o cliente existe na lista de clientes com posts
	        boolean valid = false;
	        for (Cliente cl : clienteController.listarComPosts()) {
	            if (cl.getIdCliente().trim().equalsIgnoreCase(idClienteUpper.trim())) {
	                valid = true;
	                break;
	            }
	        }

	        if (valid) {
	            // Cliente existe na lista de clientes com posts
	            request.setAttribute("mensagemErro", "O CLIENTE INFORMADO TEM POSTS CADASTRADOS! A exclusão não é permitida.");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/deletarCliente.jsp"); 
	            dispatcher.forward(request, response);
	        } else {
	            // Cliente existe na lista de clientes, mas não tem posts
	            clienteController.excluirCliente(idInformado);
	            request.setAttribute("clienteExcluido", clienteExc);
	            request.setAttribute("operacaoSucesso", true);
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/clienteExcluido.jsp"); 
	            dispatcher.forward(request, response);
	        }
	    } else {
	        // Cliente não existe
	        request.setAttribute("mensagemErro", "O CLIENTE INFORMADO NÃO EXISTE!");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/deletarCliente.jsp"); 
	        dispatcher.forward(request, response);
	    }

	    clienteController.encerrar();
	}

}
