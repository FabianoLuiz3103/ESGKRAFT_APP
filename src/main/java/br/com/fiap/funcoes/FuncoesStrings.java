package br.com.fiap.funcoes;

import java.util.List;

import br.com.fiap.Kraft.Funcionario;
import br.com.fiap.Kraft.SelecaoPosts;
import br.com.fiap.controller.ClienteController;
import br.com.fiap.controller.FuncionarioController;
import br.com.fiap.controller.PostController;
import br.com.fiap.controller.SelecaoPostsController;
import br.com.fiap.redeSocial.Cliente;
import br.com.fiap.redeSocial.Post;

public class FuncoesStrings {

	private StringBuffer sbf;

	public FuncoesStrings() {
	}

	// >>>>>>>>>>>>>>>>>>> CLIENTE <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	public String stringCliente(ClienteController clienteController) {
		this.sbf = new StringBuffer();
		for (Cliente c : clienteController.listarClientes()) {

			this.sbf.append("\n");
			this.sbf.append("----------------------------------------------------------------");
			this.sbf.append("");
			this.sbf.append("\nID_CLIENTE.....: ");
			this.sbf.append(c.getIdCliente());
			this.sbf.append("\nNOME.....: ");
			this.sbf.append(c.getNome());
			this.sbf.append("\nIDADE.....: ");
			this.sbf.append(c.getIdade());
			this.sbf.append("\nEMAIL.....: ");
			this.sbf.append(c.getEmail());
			this.sbf.append("\nTELEFONE.....: ");
			this.sbf.append(c.getTelefone());
			this.sbf.append("\nDATA DE CADASTRO.....:");
			this.sbf.append(c.getDataCadastro());
			if(c.getDataUpdate() == null) {
				this.sbf.append("\nDATA DE UPDATE.....:");
				this.sbf.append(" NULL!! CLIENTE SEM ATUALIZAÇÃO CADASTRAL! ");
			}else {
				this.sbf.append("\nDATA DE UPDATE.....:");
				this.sbf.append(c.getDataUpdate());
			}

		}

		return this.sbf.toString();
	}

	public String stringClienteById(ClienteController clienteController, String idCliente) {
		this.sbf = new StringBuffer();
		for (Cliente c : clienteController.listarClientes()) {

			if (c.getIdCliente().trim().equalsIgnoreCase(idCliente.trim())) {

				this.sbf.append("\n");
				this.sbf.append("----------------------------------------------------------------");
				this.sbf.append("");
				this.sbf.append("\nID_CLIENTE.....: ");
				this.sbf.append(c.getIdCliente());
				this.sbf.append("\nNOME.....: ");
				this.sbf.append(c.getNome());
				this.sbf.append("\nIDADE.....: ");
				this.sbf.append(c.getIdade());
				this.sbf.append("\nEMAIL.....: ");
				this.sbf.append(c.getEmail());
				this.sbf.append("\nTELEFONE.....: ");
				this.sbf.append(c.getTelefone());
				this.sbf.append("\nDATA DE CADASTRO.....:");
				this.sbf.append(c.getDataCadastro());
				if(c.getDataUpdate() == null) {
					this.sbf.append("\nDATA DE UPDATE.....:");
					this.sbf.append(" NULL!! CLIENTE SEM ATUALIZAÇÃO CADASTRAL! ");
				}else {
					this.sbf.append("\nDATA DE UPDATE.....:");
					this.sbf.append(c.getDataUpdate());
				}
			}

		}

		return this.sbf.toString();
	}


	public String stringClientePosts(ClienteController clienteController) {
	    this.sbf = new StringBuffer();
	    for (Cliente c : clienteController.listarComPosts()) { 

	        this.sbf.append("\n");
	        this.sbf.append("----------------------------------------------------------------");
	        this.sbf.append("");
	        this.sbf.append("\nID_CLIENTE.....: ");
	        this.sbf.append(c.getIdCliente());
	        this.sbf.append("\nNOME.....: ");
	        this.sbf.append(c.getNome());

	        List<Post> listaPosts = c.getPosts();
	        if (listaPosts.isEmpty()) {
	            this.sbf.append("\n");
	            this.sbf.append("\n >>>> CLIENTE SEM POSTS CADASTRADOS! <<<<\n ");
	        } else {
	            for (Post postDoCliente : listaPosts) {
	                this.sbf.append("\n");
	                this.sbf.append("--------------------------");
	                this.sbf.append("\nID_POST.....: ");
	                this.sbf.append(postDoCliente.getIdPost());
	                this.sbf.append("\nMENSAGEM.....: ");
	                this.sbf.append(postDoCliente.getMensagem());
	                this.sbf.append("\nTIPO ESG:.....: ");
	                this.sbf.append(postDoCliente.getTipoESG());
	            }
	        }
	    }
	    return this.sbf.toString();
	}



	// >>>>>>>>>>>>>>>>>>>>>>>>>>> FIM CLIENTE <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	// >>>>>>>>>>>>>>>>>>>>>>>>>>> FUNCIONÁRIO <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	public String stringFuncionario(FuncionarioController funcionarioController) {
		this.sbf = new StringBuffer();
		for (Funcionario f : funcionarioController.listarTodos()) {

			this.sbf.append("\n");
			this.sbf.append("----------------------------------------------------------------");
			this.sbf.append("");
			this.sbf.append("\nID_FUNCIONÁRIO.....: ");
			this.sbf.append(f.getIdFuncionario());
			this.sbf.append("\nNOME.....: ");
			this.sbf.append(f.getNome());
			this.sbf.append("\nEMAIL.....: ");
			this.sbf.append(f.getEmail());
			this.sbf.append("\nTELEFONE.....: ");
			this.sbf.append(f.getTelefone());

		}

		return this.sbf.toString();
	}

	public String stringFunciorioSelecao(FuncionarioController funcionarioController) {
		this.sbf = new StringBuffer();
		for (Funcionario f : funcionarioController.listarComSelecao()) {

				this.sbf.append("\n");
				this.sbf.append("----------------------------------------------------------------");
				this.sbf.append("");
				this.sbf.append("\nID_FUNCIONÁRIO.....: ");
				this.sbf.append(f.getIdFuncionario());
				this.sbf.append("\nNOME.....: ");
				this.sbf.append(f.getNome());
				
				List<SelecaoPosts> listaSelecao = f.getListaSelecao();
				if(listaSelecao.isEmpty()) {
					this.sbf.append("\n");
					this.sbf.append("\n >>>> FUNCIONÁRIO SEM SELEÇÕES REALIZADAS! <<<<\n");
				}else {
					
					for (SelecaoPosts selecaoDoFuncionario : listaSelecao) {
						this.sbf.append("\n");
						this.sbf.append("--------------------------");
						this.sbf.append("\nID_SELEÇÃO POSTS.....: ");
						this.sbf.append(selecaoDoFuncionario.getIdSelecao());
						this.sbf.append("\nDATA DA SELEÇÃO.....: ");
						this.sbf.append(selecaoDoFuncionario.getDataSelecao());
					}
				}
		}
		return this.sbf.toString();
	}

	// >>>>>>>>>>>>>>>>>>>>>>> FIM FUNCIONÁRIO <<<<<<<<<<<<<<<<<<<<<<<<<<<<

	// >>>>>>>>>>>>>>>>>>>>>>> SELEÇÃO DE POSTS <<<<<<<<<<<<<<<<<<<<<<<<<<<
	public String stringSelecao(SelecaoPostsController selecaoController) {
		this.sbf = new StringBuffer();
		for (SelecaoPosts sp : selecaoController.listaDeSelecoes()) {

			this.sbf.append("\n");
			this.sbf.append("----------------------------------------------------------------");
			this.sbf.append("");
			this.sbf.append("\nID_SELEÇÃO POSTS.....: ");
			this.sbf.append(sp.getIdSelecao());
			this.sbf.append("\nDATA DA SELÇÃO.....: ");
			this.sbf.append(sp.getDataSelecao());
			this.sbf.append("\nID_FUNCIONÁRIO RESPONSÁVEL PELA SELEÇÃO.....: ");
			this.sbf.append(sp.getIdFuncionario());
		}

		return this.sbf.toString();
	}

	public String stringSelecaoComPosts(SelecaoPostsController selecaoController) {
		this.sbf = new StringBuffer();
		for (SelecaoPosts sp : selecaoController.listaComPosts()) {
			this.sbf.append("\n");
			this.sbf.append("----------------------------------------------------------------");
			this.sbf.append("");
			this.sbf.append("\nID_SELEÇÃO POSTS.....: ");
			this.sbf.append(sp.getIdSelecao());
			this.sbf.append("\nDATA DA SELEÇÃO.....: ");
			this.sbf.append(sp.getDataSelecao());

			List<Post> listaPost = sp.getPosts();
			if (listaPost.isEmpty()) {
				this.sbf.append("\n");
				this.sbf.append("\n >>>> SELEÇÃO SEM POSTS CADASTRADOS! <<<<\n ");
			} else {
				for (Post postDaSelecao : listaPost) {
					this.sbf.append("\n");
					this.sbf.append("--------------------------");
					this.sbf.append("\nID_POST.....: ");
					this.sbf.append(postDaSelecao.getIdPost());
					this.sbf.append("\nMENSAGEM.....: ");
					this.sbf.append(postDaSelecao.getMensagem());
					this.sbf.append("\nTIPO ESG:.....: ");
					this.sbf.append(postDaSelecao.getTipoESG());
				}
			}
		}
		return this.sbf.toString();
	}

	// >>>>>>>>>>>>>>>>>>>>>>>> FIM DE SELEÇÃO DE POSTS
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	// >>>>>>>>>>>>>>>>>>>>>>>>>>> POSTS
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	public String stringPost(PostController postController) {
		this.sbf = new StringBuffer();
		for (Post p : postController.listarPosts()) {

			this.sbf.append("\n");
			this.sbf.append("----------------------------------------------------------------");
			this.sbf.append("");
			this.sbf.append("\nID_POST....: ");
			this.sbf.append(p.getIdPost());
			this.sbf.append("\nMENSAGEM.....: ");
			this.sbf.append(p.getMensagem());
			this.sbf.append("\nTIPO ESG.....: ");
			this.sbf.append(p.getTipoESG());
			this.sbf.append("\nID_CLIENTE (RESPONSÁVEL PELA POSTAGEM).....: ");
			this.sbf.append(p.getIdCliente());
			this.sbf.append("\nID_SELEÇÃO (SELEÇÃO EM QUE O POST FOI SELECIONADO).....: ");
			this.sbf.append(p.getIdSelecao());
			this.sbf.append("\nDATA DA POSTAGEM.....: ");
			this.sbf.append(p.getDataPostagem());
			if(p.getDataUpdate() == null) {
				this.sbf.append("\nDATA DE UPDATE.....:");
				this.sbf.append(" NULL!! POST SEM ATUALIZAÇÃO CADASTRAL! ");
			}else {
				this.sbf.append("\nDATA DE UPDATE.....:");
				this.sbf.append(p.getDataUpdate());
			}
		}

		return this.sbf.toString();
	}

	public String stringPostById(PostController postController, String idPost) {
		this.sbf = new StringBuffer();
		for (Post p : postController.listarPosts()) {

			if (p.getIdPost().trim().equalsIgnoreCase(idPost.trim())) {

				this.sbf.append("\n");
				this.sbf.append("----------------------------------------------------------------");
				this.sbf.append("");
				this.sbf.append("\nID_POST....: ");
				this.sbf.append(p.getIdPost());
				this.sbf.append("\nMENSAGEM.....: ");
				this.sbf.append(p.getMensagem());
				this.sbf.append("\nTIPO ESG.....: ");
				this.sbf.append(p.getTipoESG());
				this.sbf.append("\nID_CLIENTE (RESPONSÁVEL PELA POSTAGEM).....: ");
				this.sbf.append(p.getIdCliente());
				this.sbf.append("\nID_SELEÇÃO (SELEÇÃO EM QUE O POST FOI SELECIONADO).....: ");
				this.sbf.append(p.getIdSelecao());
				this.sbf.append("\nDATA DA POSTAGEM.....: ");
				this.sbf.append(p.getDataPostagem());
				if(p.getDataUpdate() == null) {
					this.sbf.append("\nDATA DE UPDATE.....:");
					this.sbf.append(" NULL!! POST SEM ATUALIZAÇÃO CADASTRAL! ");
				}else {
					this.sbf.append("\nDATA DE UPDATE.....:");
					this.sbf.append(p.getDataUpdate());
				}
			}

		}

		return this.sbf.toString();
	}

	public String stringPostPorCliente(PostController postController, String idCliente) {
		this.sbf = new StringBuffer();
		List<Post> postsDoCliente = postController.listarPorCliente(idCliente);

		if (postsDoCliente.isEmpty()) {
			this.sbf.append("\n");
			this.sbf.append("\n >> CLIENTE SEM POSTS CADASTRADOS! ");
		} else {

			for (Post p : postsDoCliente) {

				this.sbf.append("\n");
				this.sbf.append("--------------------------");
				this.sbf.append("\nID_POST....: ");
				this.sbf.append(p.getIdPost());
				this.sbf.append("\nMENSAGEM.....: ");
				this.sbf.append(p.getMensagem());
				this.sbf.append("\nTIPO ESG.....: ");
				this.sbf.append(p.getTipoESG());
				this.sbf.append("\nID_CLIENTE (RESPONSÁVEL PELA POSTAGEM).....: ");
				this.sbf.append(p.getIdCliente());
				this.sbf.append("\nID_SELEÇÃO (SELEÇÃO EM QUE O POST FOI SELECIONADO).....: ");
				this.sbf.append(p.getIdSelecao());
				this.sbf.append("\nDATA DA POSTAGEM.....: ");
				this.sbf.append(p.getDataPostagem());
				if(p.getDataUpdate() == null) {
					this.sbf.append("\nDATA DE UPDATE.....:");
					this.sbf.append(" NULL!! POST SEM ATUALIZAÇÃO CADASTRAL! ");
				}else {
					this.sbf.append("\nDATA DE UPDATE.....:");
					this.sbf.append(p.getDataUpdate());
				}
			}
		}
		return this.sbf.toString();
	}

}
