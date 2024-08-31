package br.com.fiap.controll;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.Kraft.SelecaoPosts;
import br.com.fiap.controller.ClienteController;
import br.com.fiap.controller.SelecaoPostsController;
import br.com.fiap.redeSocial.Cliente;

/**
 * Servlet implementation class loginCliente
 */
@WebServlet("/logarCliente")
public class loginClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String idSelecaoRecebido = null;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.idSelecaoRecebido = request.getParameter("idSelecao");
		String idClienteCad = request.getParameter("idCliente");
		if(idClienteCad == null) {
			response.sendRedirect("loginCliente.jsp");
		}else {
			String url = "loginCliente.jsp?idCliente=" + idClienteCad;
			response.sendRedirect(url);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String idInformado = request.getParameter("idCliente");
		String idClienteUpper = idInformado.toUpperCase();
		ClienteController clienteController = null;
		String idFuncionario = (String) session.getAttribute("idFuncionario");
		
		SelecaoPostsController selecaoPostsController = null;
		try {
			selecaoPostsController = new SelecaoPostsController();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			clienteController = new ClienteController();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		boolean valid = false;
		for(Cliente c : clienteController.listarClientes()) {
			if(c.getIdCliente().trim().equalsIgnoreCase(idClienteUpper.trim())) {
				valid = true;
				break;
			}
		}
		session.setAttribute("idCliente", idClienteUpper);
		
		
		SelecaoPosts selecaoPosts = new SelecaoPosts();
		selecaoPosts.setDataSelecao(new Date());
		if(this.idSelecaoRecebido != null && valid) {
			String url = "novoPost?idSelecao=" + this.idSelecaoRecebido;
		    response.sendRedirect(url);
		}else
		if(valid) {
			String idSelecaoGerado = (String) selecaoPostsController.salvarSelecao(selecaoPosts.getDataSelecao(),idFuncionario);
			  String url = "novoPost?idSelecao=" + idSelecaoGerado;
			    response.sendRedirect(url);
		} else {
		    request.setAttribute("mensagemErro", "LOGIN INVÁLIDO! POR FAVOR, TENTE NOVAMENTE.");
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/loginCliente.jsp"); 
		    dispatcher.forward(request, response);
		}
		
		clienteController.encerrar();
		selecaoPostsController.encerrar();
	}

}
