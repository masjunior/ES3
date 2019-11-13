package br.edu.Baby_Clothes.dao;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

import br.edu.Baby_Clothes.util.Conexao;
import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Funcionario;



public class FuncionarioDAO implements IDAO{
	Connection connection = null;
	

	@Override
	public void cadastrar(EntidadeDominio entidade) {
		
		Funcionario funcionario = (Funcionario)entidade;
		
		PreparedStatement pst;
		 
		try {
			connection = Conexao.getConnection();
			connection.setAutoCommit(false);
			
			StringBuilder sqlUsu = new StringBuilder();
			sqlUsu.append("INSERT INTO site_roupa.usuario(usu_data_criacao, usu_habilitado, usu_email,usu_senha, usu_nivel_acesso, usu_id) VALUES (?,?,?,?,?,?);");
			pst = connection.prepareStatement(sqlUsu.toString(),Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, LocalDateTime.now().toString());
			pst.setBoolean(2, true );
			pst.setString(3, funcionario.getEmail());
			pst.setString(4, funcionario.getSenha());
			pst.setInt(5, funcionario.getNivelAcesso().getValor());
			pst.setInt(6, 6);
			
			pst.executeUpdate();
					
			ResultSet rs = pst.getGeneratedKeys();
			int idUsuario=0;
			if(rs.next()) {
				idUsuario = rs.getInt(1);
			}
			
			connection.commit();
			
			connection.setAutoCommit(false);
			
			//salvar funcionario
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO site_roupa.funcionario (fun_nome, fun_cpf, fun_usuario,fun_id) VALUES (?,?,?,?)");
	
			pst = connection.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
	
			pst.setString(1, funcionario.getNome());
			pst.setString(2, funcionario.getCpf());
			pst.setInt(3, idUsuario );
			pst.setInt(4, 5 );
			
	
			pst.executeUpdate();
	
			connection.commit();
		
		}catch (Exception e) {
			System.out.println("teste erro " + e.toString());
			try {
				System.out.println("passei");
				connection.rollback();
			}catch (SQLException ee) {
				ee.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				Conexao.fechar(connection);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
		

	@Override
	public void remover(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EntidadeDominio> listar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}



}
