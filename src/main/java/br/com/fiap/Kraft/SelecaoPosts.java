package br.com.fiap.Kraft;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.fiap.redeSocial.Post;

public class SelecaoPosts {

	private String idSelecao;
	private Date dataSelecao;
	private String idFuncionario;
	private List<Post> posts = new ArrayList<Post>();

	public SelecaoPosts() {

	}

	public SelecaoPosts(Date dataSelecao, String idFuncionario, List<Post> posts) {
		this.dataSelecao = dataSelecao;
		this.idFuncionario = idFuncionario;
		this.posts = posts;
	}

	public String getIdSelecao() {
		return idSelecao;
	}

	public void setIdSelecao(String idSelecao) {
		this.idSelecao = idSelecao;
	}

	public Date getDataSelecao() {
		return dataSelecao;
	}

	public void setDataSelecao(Date dataSelecao) {
		this.dataSelecao = dataSelecao;
	}

	public String getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(String idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(Post posts) {
		this.posts.add(posts);
	}
	
}

	