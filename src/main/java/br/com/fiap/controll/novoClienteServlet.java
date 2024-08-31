package br.com.fiap.controll;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.controller.ClienteController;
import br.com.fiap.funcoes.Funcoes;
import br.com.fiap.redeSocial.Cliente;

/**
 * Servlet implementation class novoCliente
 */
@WebServlet("/novoCliente")
public class novoClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("cadastrarCliente.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Funcoes funcao = new Funcoes();
		String nome = request.getParameter("nome");
	    String idade = request.getParameter("idade");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		Date dataCadastro = new Date();
		int idadeInt = Integer.parseInt(idade);
		Cliente cliente = new Cliente(nome,idadeInt,email,telefone, dataCadastro);
		ClienteController clienteController = null;
		try {
			clienteController = new ClienteController();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		boolean idadeInvalida = funcao.verificarIdade(idadeInt);
		boolean emailInvalido = funcao.verificarEmail(email, clienteController);
		boolean telefoneInvalido = funcao.verificarTelefone(telefone, clienteController);

		if (idadeInvalida || emailInvalido || telefoneInvalido) {
		    if (idadeInvalida) {
		        request.setAttribute("mensagemErroIdade", "IDADE INVÁLIDA! O CLIENTE DEVE SER MAIOR DE 18 ANOS.");
		    }
		    if (emailInvalido) {
		        request.setAttribute("mensagemErroEmail", "EMAIL INVÁLIDO! O EMAIL JÁ ESTÁ CADASTRADO.");
		    }
		    if (telefoneInvalido) {
		        request.setAttribute("mensagemErroTelefone", "TELEFONE INVÁLIDO! O TELEFONE JÁ ESTÁ CADASTRADO.");
		    }

		    RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastrarCliente.jsp");
		    dispatcher.forward(request, response);
		} else {
		    String idGerado = clienteController.salvarCliente(cliente);
		   // request.setAttribute("cliente", cliente);
		    //response.sendRedirect("successCadastro");
		    //System.out.println(idGerado);
		    request.setAttribute("idGerado", idGerado);
	        request.setAttribute("clienteCadastrado", cliente);
	        request.setAttribute("operacaoSucesso", true);

	        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastroRealizado.jsp"); 
	        dispatcher.forward(request, response);
		}
		clienteController.encerrar();
	}

}
