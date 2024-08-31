package br.com.fiap.controller;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.redeSocial.Cliente;

public class ClienteController {
	
	private ClienteDAO clienteDAO;
	
	public ClienteController() throws ClassNotFoundException {
		Connection conexao = new ConnectionFactory().conexao();
		this.clienteDAO = new ClienteDAO(conexao);
	}
	
	public String salvarCliente(Cliente cliente) {
		return this.clienteDAO.salvarCliente(cliente);
	}
	
	public List<Cliente> listarComPosts(){
		return this.clienteDAO.listarComPosts();
	}
	public List<Cliente> listarClientes(){
		return this.clienteDAO.listarClientes();
	}
	
	public void alterarCliente(String nome, int idade, String email, String telefone, Date dataUpdate, String idCliente) {
		this.clienteDAO.alterarCliente(nome, idade, email, telefone, dataUpdate, idCliente);
	}
	
	public void excluirCliente(String id) {
		this.clienteDAO.excluirCliente(id);
	}
	  public void encerrar() {
	        this.clienteDAO.fecharConexao();
	    }

}
