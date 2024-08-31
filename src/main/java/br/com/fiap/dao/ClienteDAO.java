package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.fiap.redeSocial.Cliente;
import br.com.fiap.redeSocial.Post;

public class ClienteDAO {

	// Conecatando com o banco
	private Connection conexao;

	public ClienteDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public String salvarCliente(Cliente cliente) {
	    PreparedStatement pstm = null;
	    ResultSet generatedKeys = null;
	    String sql = "INSERT INTO cliente (nome, idade, email, telefone, datacadastro) VALUES (?, ?, ?, ?, ?)";
	    String clienteID = null; 

	    try {
	        pstm = conexao.prepareStatement(sql, new String[]{"idcliente"}); 
	        java.util.Date dataCadastro = cliente.getDataCadastro();
	        java.sql.Date sqlDate = new java.sql.Date(dataCadastro.getTime());

	        pstm.setString(1, cliente.getNome());
	        pstm.setInt(2, cliente.getIdade());
	        pstm.setString(3, cliente.getEmail());
	        pstm.setString(4, cliente.getTelefone());
	        pstm.setDate(5, sqlDate);

	        pstm.executeUpdate();

	       
	        generatedKeys = pstm.getGeneratedKeys();

	        if (generatedKeys.next()) {
	            clienteID = generatedKeys.getString(1); 
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    } finally {
	        // Fechar as conexões e recursos
	        try {
	            if (generatedKeys != null) {
	                generatedKeys.close();
	            }
	            if (pstm != null) {
	                pstm.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    return clienteID; // Retorna o ID gerado
	}


	

	public List<Cliente> listarComPosts() {
	    Cliente cliente = null;
	    List<Cliente> lista = new ArrayList<Cliente>();
	    String sql = "SELECT C.idcliente, C.nome, C.idade, C.email, C.telefone, C.datacadastro, C.dataupdate, P.idpost, P.mensagem, P.tipoesg, P.cliente_idcliente, P.selecaoposts_idselecao, P.datapostagem, P.dataupdate "
	            + "FROM cliente C INNER JOIN post P ON C.idcliente = P.cliente_idcliente order by C.idcliente, TO_NUMBER(SUBSTR(P.idPost, 2))";

	    try {
	        try (PreparedStatement pstm = conexao.prepareStatement(sql)) {
	            pstm.execute();
	            ResultSet rst = pstm.getResultSet();

	            while (rst.next()) {
	                if (cliente == null || !cliente.getEmail().equals(rst.getString("email"))) {
	                    Cliente clie = new Cliente();
	                    clie.setIdCliente(rst.getString("idcliente"));
	                    clie.setNome(rst.getString("nome"));
	                    clie.setIdade(rst.getInt("idade"));
	                    clie.setEmail(rst.getString("email"));
	                    clie.setTelefone(rst.getString("telefone"));
	                    clie.setDataCadastro(rst.getDate("datacadastro"));
	                    clie.setDataUpdate(rst.getDate("dataupdate"));
	                    lista.add(clie);
	                    cliente = clie;
	                }

	                if (rst.getString("idpost") != null) { 
	                    Post posts = new Post();
	                    posts.setIdPost(rst.getString("idpost"));
	                    posts.setMensagem(rst.getString("mensagem"));
	                    posts.setTipoESG(rst.getString("tipoesg"));
	                    posts.setIdCliente(rst.getString("cliente_idcliente"));
	                    posts.setIdSelecao(rst.getString("selecaoposts_idselecao"));
	                    posts.setDataPostagem(rst.getDate("datapostagem"));
	                    posts.setDataUpdate(rst.getDate("dataupdate"));
	                    cliente.setPosts(posts);
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
	
	public List<Cliente> listarClientes() {
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		PreparedStatement pstm = null;
		ResultSet rst = null;
		String sql = "SELECT * FROM cliente ORDER BY TO_NUMBER(SUBSTR(idcliente, 2)) ";

		try {
			pstm = conexao.prepareStatement(sql);
			rst = pstm.executeQuery();

			while (rst.next()) {
				Cliente cliente = new Cliente();

				cliente.setIdCliente(rst.getString("idCliente"));
				cliente.setNome(rst.getString("nome"));
				cliente.setIdade(rst.getInt("idade"));
				cliente.setEmail(rst.getString("email"));
				cliente.setTelefone(rst.getString("telefone"));
				cliente.setDataCadastro(rst.getDate("datacadastro"));
				cliente.setDataUpdate(rst.getDate("dataupdate"));

				listaClientes.add(cliente);
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

		return listaClientes;
	}


	public void alterarCliente(String nome, int idade, String email, String telefone, Date dataUpdate, String idCliente) {
		PreparedStatement pstm = null;
		String sql = "UPDATE cliente C SET C.nome = ?, C.idade = ?, C.email = ?, C.telefone = ?, C.dataupdate = ? WHERE C.idcliente = ? ";
		try {
			pstm = conexao.prepareStatement(sql);

			pstm.setString(1, nome);
			pstm.setInt(2, idade);
			pstm.setString(3, email);
			pstm.setString(4, telefone);
			pstm.setDate(5, new java.sql.Date(dataUpdate.getTime()));
			pstm.setString(6, idCliente);
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

	public void excluirCliente(String idCliente) {
	    String sqlVerifcarPosts = "SELECT COUNT(*) FROM post WHERE cliente_idcliente = ?";
	    String sqlDeleteCliente = "DELETE FROM cliente WHERE idcliente = ?";
	    
	    PreparedStatement pstmVerificarPosts = null;
	    PreparedStatement pstmDeleteCliente = null;
	    ResultSet rst = null;
	    
	    try {
	        // Verifica se o cliente tem posts associados
	        pstmVerificarPosts = conexao.prepareStatement(sqlVerifcarPosts);
	        pstmVerificarPosts.setString(1, idCliente);
	        rst = pstmVerificarPosts.executeQuery();
	        
	        if (rst.next() && rst.getInt(1) == 0) {//O rst.next() nesse caso atua não nos dados retornados da tabela
	        	//mas sim no resultado que COUNT retorna, que é a quandtidade de posts associados ao cliente do id x.
	            pstmDeleteCliente = conexao.prepareStatement(sqlDeleteCliente);
	            pstmDeleteCliente.setString(1, idCliente);
	            pstmDeleteCliente.execute();
	            System.out.println("\n\nFOI EXCLUÍDO COM SUCESSO! ");
	        } else {
	            System.out.println("\n\n >> O CLIENTE TEM POSTS CADASTRADOS!"
	                    + "\n >> NÃO É POSSÍVEL DELETAR ELE DO BANCO!");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rst != null) {
	                rst.close();
	            }
	            if (pstmVerificarPosts != null) {
	                pstmVerificarPosts.close();
	            }
	            if (pstmDeleteCliente != null) {
	                pstmDeleteCliente.close();
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
