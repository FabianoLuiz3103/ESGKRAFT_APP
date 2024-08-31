package br.com.fiap.controller;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.Kraft.Funcionario;
import br.com.fiap.dao.FuncionarioDAO;
import br.com.fiap.factory.ConnectionFactory;

public class FuncionarioController {
	
	private FuncionarioDAO funcionarioDAO;
	
	public FuncionarioController() throws ClassNotFoundException {
		Connection conexao = new ConnectionFactory().conexao();
		this.funcionarioDAO = new FuncionarioDAO(conexao);
	}
	
	public List<Funcionario> listarTodos(){
		return this.funcionarioDAO.listarTodos();
	}
	
	public List<Funcionario> listarComSelecao(){
		return this.funcionarioDAO.listarComSelecao();
	}
	
	  public void encerrar() {
	        this.funcionarioDAO.fecharConexao();
	    }

}
