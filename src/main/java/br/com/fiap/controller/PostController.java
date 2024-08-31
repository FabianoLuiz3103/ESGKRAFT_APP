package br.com.fiap.controller;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import br.com.fiap.dao.PostDAO;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.redeSocial.Post;

public class PostController {

	private PostDAO postDAO;

	public PostController() throws ClassNotFoundException {
		Connection conexao = new ConnectionFactory().conexao();
		this.postDAO = new PostDAO(conexao);
	}

	public String salvarPost(Post post) {
		return this.postDAO.salvarPost(post);
	}

	public List<Post> listarPosts() {
		return this.postDAO.listarPosts();
	}

	public List<Post> listarPorCliente(String idCliente) {
		return this.postDAO.listarPorCliente(idCliente);
	}

	public void alterarPost(String mensagem, String tipoESG, Date dataUpdate, String idPost) {
		this.postDAO.alterarPost(mensagem, tipoESG,dataUpdate, idPost);
	}

	public void excluirPost(String idPost) {
		this.postDAO.excluirPost(idPost);
	}

	public void encerrar() {
		this.postDAO.fecharConexao();
	}

}
