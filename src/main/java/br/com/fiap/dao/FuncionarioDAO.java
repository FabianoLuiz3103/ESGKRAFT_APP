package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.Kraft.Funcionario;
import br.com.fiap.Kraft.SelecaoPosts;

public class FuncionarioDAO {

	private Connection conexao;

	public FuncionarioDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public List<Funcionario> listarTodos() {
		List<Funcionario> lista = new ArrayList<Funcionario>();
		PreparedStatement pstm = null;
		ResultSet rst = null;
		String sql = "SELECT * FROM funcionario";
		
		try {
			pstm = conexao.prepareStatement(sql);
			rst = pstm.executeQuery();
			
			while(rst.next()) {
				Funcionario funcionario = new Funcionario();
				
				funcionario.setIdFuncionario(rst.getString("idfuncionario"));
				funcionario.setNome(rst.getString("nome"));
				funcionario.setEmail(rst.getString("email"));
				funcionario.setTelefone(rst.getString("telefone"));
				
				lista.add(funcionario);
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
	
	
	public List<Funcionario> listarComSelecao(){
		List<Funcionario> lista = new ArrayList<Funcionario>();
		Funcionario funcionario = null;
		ResultSet rst = null;
		String sql = "SELECT F.idfuncionario, F.nome, F.email, F.telefone, S.idselecao, S.dataselecao, S.funcionario_idfuncionario "
				+ "FROM funcionario F INNER JOIN selecaoposts S ON F.idfuncionario = S.funcionario_idfuncionario order by F.idfuncionario";
		try {
			try(PreparedStatement pstm = conexao.prepareStatement(sql)){
				pstm.execute();
				rst = pstm.getResultSet();
				
				while(rst.next()) {
					if(funcionario == null || !funcionario.getEmail().equals(rst.getString("email"))){
						Funcionario func = new Funcionario();
						func.setIdFuncionario(rst.getString("idfuncionario"));
						func.setNome(rst.getString("nome"));
						func.setEmail(rst.getString("email"));
						func.setTelefone(rst.getString("telefone"));
						lista.add(func);
						funcionario = func;
					}
					if(rst.getString("idselecao")!=null) {
						
						SelecaoPosts selecao = new SelecaoPosts();
						selecao.setIdSelecao(rst.getString("idselecao"));
						selecao.setDataSelecao(rst.getDate("dataselecao"));
						selecao.setIdFuncionario(rst.getString("funcionario_idfuncionario"));
						funcionario.setListaSelecao(selecao);
					}
				}
				rst.close();
				pstm.close();
				return lista;
			}
			
		}catch(SQLException e) {
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
