package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.fiap.redeSocial.Post;

public class PostDAO {

	// Conecatando com o banco
	private Connection conexao;

	public PostDAO(Connection conexao) {
		this.conexao = conexao;
	}

	// Salva o post com o id do cliente e o id da consulta
	public String salvarPost(Post post) {
		PreparedStatement pstm = null;
		String sql = "INSERT INTO post (mensagem, tipoesg, cliente_idcliente, selecaoposts_idselecao, datapostagem) VALUES (?, ?, ?, ?, ?)";
		String postID = null;
		ResultSet generatedKeys = null;
		try {

			pstm = conexao.prepareStatement(sql, new String[]{"idpost"});

			pstm.setString(1, post.getMensagem());

			// Convertendo java.util.Date para java.sql.Date
			java.util.Date dataPostagem = post.getDataPostagem();
			java.sql.Date sqlDate = new java.sql.Date(dataPostagem.getTime());

			pstm.setString(2, post.getTipoESG());
			pstm.setString(3, post.getIdCliente());
			pstm.setString(4, post.getIdSelecao());
			pstm.setDate(5, sqlDate);

			pstm.executeUpdate();
			
			 generatedKeys = pstm.getGeneratedKeys();

		        if (generatedKeys.next()) {
		            postID = generatedKeys.getString(1); // Obtenha o valor do ID gerado
		        }

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			// Fechar as conexão pstm
			try {
				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return postID;
	}

	public List<Post> listarPosts() {
		List<Post> listaPosts = new ArrayList<Post>();
		PreparedStatement pstm = null;
		ResultSet rst = null;
		String sql = "SELECT * FROM post ORDER BY TO_NUMBER(SUBSTR(idPost, 2)) ";

		try {
			pstm = conexao.prepareStatement(sql);
			rst = pstm.executeQuery();

			while (rst.next()) {
				Post post = new Post();
				post.setIdPost(rst.getString("idpost"));
				post.setMensagem(rst.getString("mensagem"));
				post.setTipoESG(rst.getString("tipoesg"));
				post.setIdCliente(rst.getString("cliente_idcliente"));
				post.setIdSelecao(rst.getString("selecaoposts_idselecao"));
				post.setDataPostagem(rst.getDate("datapostagem"));
				post.setDataUpdate(rst.getDate("dataupdate"));

				listaPosts.add(post);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}
				if (pstm != null) {
					pstm.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listaPosts;

	}
	
	public List<Post> listarPorCliente(String idCliente) {
		List<Post> listaPosts = new ArrayList<Post>();
		PreparedStatement pstm = null;
		ResultSet rst = null;
		String sql = "SELECT * FROM post WHERE cliente_idcliente = ? ORDER BY TO_NUMBER(SUBSTR(idPost, 2))";

		try {
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, idCliente);
			rst = pstm.executeQuery();

			while (rst.next()) {
				Post post = new Post();
				post.setIdPost(rst.getString("idpost"));
				post.setMensagem(rst.getString("mensagem"));
				post.setTipoESG(rst.getString("tipoesg"));
				post.setIdCliente(rst.getString("cliente_idcliente"));
				post.setIdSelecao(rst.getString("selecaoposts_idselecao"));
				post.setDataPostagem(rst.getDate("datapostagem"));
				post.setDataUpdate(rst.getDate("dataupdate"));

				listaPosts.add(post);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}
				if (pstm != null) {
					pstm.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listaPosts;
	}

	public void alterarPost(String mensagem, String tipoESG, Date dataUpdate, String idPost) {
		PreparedStatement pstm = null;
		String sql = "UPDATE post P SET P.mensagem = ?, P.tipoesg = ?, P.dataupdate = ? WHERE P.idpost = ? ";
		try {
			
			pstm = conexao.prepareStatement(sql);

			pstm.setString(1, mensagem);
			pstm.setString(2, tipoESG);
			pstm.setDate(3, new java.sql.Date(dataUpdate.getTime()));
			pstm.setString(4, idPost);
			pstm.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void excluirPost(String idPost) {
		PreparedStatement pstm = null;
		String sql = "DELETE FROM post WHERE idpost = ?";

		try {
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, idPost);
			pstm.execute();
			System.out.println("\n\nFOI EXCLUÍDO COM SUCESSO! ");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	public void fecharConexao() {
        try {
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	

}
