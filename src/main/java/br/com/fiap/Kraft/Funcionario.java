package br.com.fiap.Kraft;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
	
	private String idFuncionario;
	private String nome;
	private String email;
	private String telefone;
	private List<SelecaoPosts> listaSelecao = new ArrayList<SelecaoPosts>();
	
	public Funcionario() {
		
	}
	
	public Funcionario(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	
	public String getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(String
			idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<SelecaoPosts> getListaSelecao() {
		return listaSelecao;
	}

	public void setListaSelecao(SelecaoPosts listaSelecao) {
		this.listaSelecao.add(listaSelecao);
	}


}
