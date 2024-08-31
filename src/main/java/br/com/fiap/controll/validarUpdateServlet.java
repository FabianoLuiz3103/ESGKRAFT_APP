package br.com.fiap.controll;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import br.com.fiap.controller.ClienteController;
import br.com.fiap.funcoes.Funcoes;

/**
 * Servlet implementation class updateClienteServlet
 */
@WebServlet("/validarUpdate")
public class validarUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String idC = null;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String idCliente = request.getParameter("idCliente").toUpperCase();
	    this.idC = idCliente;
	}

	
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Funcoes funcao = new Funcoes();
		String nome = request.getParameter("nomeCliente");
	    String idade = request.getParameter("idadeCliente");
		String email = request.getParameter("emailCliente");
		String telefone = request.getParameter("telefoneCliente");
		Date dataUpdate = new Date();
		int idadeInt = Integer.parseInt(idade);
		ClienteController clienteController = null;
		try {
			clienteController = new ClienteController();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		boolean idadeInvalida = funcao.verificarIdade(idadeInt);;
		boolean existeEmail = false, existeTelefone = false;
		if(funcao.verificaEmailUpdate(clienteController, this.idC, email)) {
			existeEmail = false;
		}else {
			existeEmail = funcao.verificarEmail(email, clienteController);
		}
		if(funcao.verificaTelefoneUpdate(clienteController, this.idC, telefone)) {
			existeTelefone = false;
		}else {
			existeTelefone = funcao.verificarTelefone(telefone, clienteController);
		}
		
        //String errorX = null;
		if (idadeInvalida || existeEmail || existeTelefone) {
			response.setContentType("application/json");
			Gson gson = new Gson();
			JsonObject jsonCliente = new JsonObject();
			String errorX = "";

			if (idadeInvalida) {
			    jsonCliente.addProperty("erroIdade", "IDADE INVÁLIDA! O CLIENTE DEVE SER MAIOR DE 18 ANOS.");
			    errorX += "errorIdade=true&";
			}

			if (existeEmail) {
			    jsonCliente.addProperty("erroEmail", "EMAIL INVÁLIDO! O EMAIL JÁ ESTÁ CADASTRADO.");
			    errorX += "errorEmail=true&";
			}

			if (existeTelefone) {
			    jsonCliente.addProperty("erroTelefone", "TELEFONE INVÁLIDO! O TELEFONE JÁ ESTÁ CADASTRADO.");
			    errorX += "errorTelefone=true&";
			}

			// Remova o último "&" se necessário
			if (!errorX.isEmpty()) {
			    errorX = errorX.substring(0, errorX.length() - 1);
			}

			response.getWriter().write(gson.toJson(jsonCliente));
		    String url = "updateCliente.jsp?error=true&" + errorX;
            response.sendRedirect(url);
//		    RequestDispatcher dispatcher = request.getRequestDispatcher("/updateCliente.jsp");
//		    dispatcher.forward(request, response);
		} else {
		    clienteController.alterarCliente(nome, idadeInt, email, telefone, dataUpdate, this.idC);;
		    //request.setAttribute("cliente", cliente);
		    response.sendRedirect("successUpdateCliente.jsp");
		}
		
		clienteController.encerrar();
	}


}
