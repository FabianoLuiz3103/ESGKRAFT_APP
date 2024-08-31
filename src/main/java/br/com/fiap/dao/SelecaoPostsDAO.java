package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.fiap.Kraft.SelecaoPosts;
import br.com.fiap.redeSocial.Post;

public class SelecaoPostsDAO {
	
	private Connection conexao;
	
	public SelecaoPostsDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public String salvarSelecao(Date data, String idFuncionario) {
	    PreparedStatement pstm = null;
	    ResultSet rst = null;
	    String sql = "INSERT INTO selecaoposts (dataselecao, funcionario_idfuncionario) VALUES (?, ?)";
	    String idGerado = null; 

	    try {
	        pstm = conexao.prepareStatement(sql, new String[]{"idselecao"});
	        pstm.setDate(1, new java.sql.Date(data.getTime()));
	        pstm.setString(2, idFuncionario);
	        pstm.executeUpdate();

	        rst = pstm.getGeneratedKeys();
	        if (rst.next()) {
	            idGerado = rst.getString(1);
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    } finally {
	        try {
	            if (pstm != null) {
	                pstm.close();
	            }
	            if (rst != null) {
	                rst.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    return idGerado; 
	}

	public List<SelecaoPosts> litaDeSelecoes(){
		List<SelecaoPosts> lista = new ArrayList<SelecaoPosts>();
		PreparedStatement pstm = null;
		ResultSet rst = null;
		String sql = "SELECT * FROM selecaoposts ORDER BY TO_NUMBER(SUBSTR(idselecao, 2)) ";
		
		try {
			pstm = conexao.prepareStatement(sql);
			rst = pstm.executeQuery();
			
			while(rst.next()) {
				SelecaoPosts selecao = new SelecaoPosts();
				selecao.setIdSelecao(rst.getString("idselecao"));
				selecao.setDataSelecao(rst.getDate("dataselecao"));
				selecao.setIdFuncionario(rst.getString("funcionario_idfuncionario"));
				lista.add(selecao);
			}
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}finally {
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
		return lista;
	}
	
	public List<SelecaoPosts> listarComPosts() {
		SelecaoPosts selecao = null;
		List<SelecaoPosts> lista = new ArrayList<SelecaoPosts>();
		String sql = "SELECT S.idselecao, S.dataselecao, S.funcionario_idfuncionario, P.idpost, P.mensagem, P.tipoesg, P.cliente_idcliente, P.selecaoposts_idselecao, P.datapostagem, P.dataupdate "
				+ "FROM selecaoposts S INNER JOIN post P ON S.idselecao = P.selecaoposts_idselecao order by S.idselecao";
		try {

			try (PreparedStatement pstm = conexao.prepareStatement(sql)) {
				pstm.execute();
				ResultSet rst = pstm.getResultSet();

				while (rst.next()) {
					if (selecao == null || !selecao.getIdSelecao().equals(rst.getString("idselecao"))) {
						SelecaoPosts selePosts = new SelecaoPosts();
						selePosts.setIdSelecao(rst.getString("idselecao"));
						selePosts.setDataSelecao(rst.getDate("dataselecao"));
						selePosts.setIdFuncionario(rst.getString("funcionario_idfuncionario"));
						lista.add(selePosts);
						selecao = selePosts;
					}
					
					if(rst.getString("idpost") != null) {
						
						Post posts = new Post();
						posts.setIdPost(rst.getString("idpost"));
						posts.setMensagem(rst.getString("mensagem"));
						posts.setTipoESG(rst.getString("tipoesg"));
						posts.setIdCliente(rst.getString("cliente_idcliente"));
						posts.setIdSelecao(rst.getString("selecaoposts_idselecao"));
						posts.setDataPostagem(rst.getDate("datapostagem"));
						posts.setDataUpdate(rst.getDate("dataupdate"));
						selecao.setPosts(posts);
					}
				}
				rst.close();
				pstm.close();
				return lista;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
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
