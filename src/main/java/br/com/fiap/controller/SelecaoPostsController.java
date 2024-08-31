package br.com.fiap.controller;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import br.com.fiap.Kraft.SelecaoPosts;
import br.com.fiap.dao.SelecaoPostsDAO;
import br.com.fiap.factory.ConnectionFactory;

public class SelecaoPostsController {
	
	private SelecaoPostsDAO selecaoPostsDAO;
	
	public SelecaoPostsController() throws ClassNotFoundException {
		Connection conexao = new ConnectionFactory().conexao();
		this.selecaoPostsDAO = new SelecaoPostsDAO(conexao);
	}
	
	public String salvarSelecao(Date data, String idFuncionario) {
		return this.selecaoPostsDAO.salvarSelecao(data, idFuncionario);
	}
	
	public List<SelecaoPosts> listaDeSelecoes(){
		return this.selecaoPostsDAO.litaDeSelecoes();
	}
	
	public List<SelecaoPosts> listaComPosts(){
		return this.selecaoPostsDAO.listarComPosts();
	}
	

	
	  public void encerrar() {
	        this.selecaoPostsDAO.fecharConexao();
	    }

}
