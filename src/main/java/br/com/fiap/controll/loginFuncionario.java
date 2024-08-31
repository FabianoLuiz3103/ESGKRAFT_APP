package br.com.fiap.controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.Kraft.Funcionario;
import br.com.fiap.controller.FuncionarioController;

/**
 * Servlet implementation class homeServlet
 */
@WebServlet("/logarFuncionario")
public class loginFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("loginFuncionario.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailInstitucional = request.getParameter("email");
		String idFuncionario = null, nomeFuncionario = null;
		FuncionarioController funcionarioController = null;
		try {
			funcionarioController = new FuncionarioController();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		boolean valid = false;
		for(Funcionario f : funcionarioController.listarTodos()) {
			if(f.getEmail().trim().equalsIgnoreCase(emailInstitucional.trim())) {
				valid = true;
				idFuncionario = f.getIdFuncionario();
				nomeFuncionario = f.getNome();
				break;
			}
		}
		HttpSession session = request.getSession();
		session.setAttribute("idFuncionario", idFuncionario);
		session.setAttribute("nomeFuncionario", nomeFuncionario);
		
		if(valid) {
			//String url = "logarCliente?idFuncionario=" + idFuncionario + "&nomeFuncionaio" + nomeFuncionario;
			
			session.setAttribute("usuAutenticado", true);
			response.sendRedirect("menuPrincipal");

		} else {
		    request.setAttribute("mensagemErro", "LOGIN INVÁLIDO! POR FAVOR, TENTE NOVAMENTE.");
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/loginFuncionario.jsp"); 
		    dispatcher.forward(request, response);
		}
		
		funcionarioController.encerrar();
		
	}

}
