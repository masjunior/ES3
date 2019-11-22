package br.edu.Baby_Clothes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.edu.Baby_Clothes.dao.filtro.FiltroFuncionario;
import br.edu.Baby_Clothes.util.Conexao;
import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Funcionario;
import br.edu.fatec.Baby_Clothes.model.Usuario;



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
		PreparedStatement pstm = null;
		Funcionario funcionario = (Funcionario)entidade;
		
		try {
			connection = Conexao.getConnection();
			connection.setAutoCommit(false);
			
			String sql = "UPDATE usuario SET usu_habilitado = ? WHERE usu_id = ?";
			pstm = connection.prepareStatement(sql);
			
			pstm.setBoolean(1, false);
			pstm.setLong(2, funcionario.getUsuario().getId());
			
			pstm.executeUpdate();
			connection.commit();
			
		}catch(Exception e) {
			try {
				connection.rollback();
			}catch(SQLException eSQL) {
				eSQL.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				pstm.close();
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		Funcionario funcionario = (Funcionario)entidade;
		PreparedStatement pstm = null;
		
		try {
			connection = Conexao.getConnection();
			String sql = "UPDATE funcionario INNER JOIN usuario ON fun_usuario = usu_id SET fun_nome = ?, fun_cpf = ?, usu_habilitado = ?, usu_email = ?, usu_senha = ?, usu_nivel_acesso = ? WHERE fun_id = ?";
			pstm = connection.prepareStatement(sql);
			
			pstm.setString(1, funcionario.getNome());
			pstm.setString(2, funcionario.getCpf());
			pstm.setBoolean(3, funcionario.isHabilitado());
			pstm.setString(4, funcionario.getEmail());
			pstm.setString(5, funcionario.getSenha());
			pstm.setInt(6, funcionario.getNivelAcesso().getValor());
			pstm.setLong(7, funcionario.getId());
			
			pstm.executeUpdate();
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(connection != null) {
					connection.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public List<EntidadeDominio> listar(EntidadeDominio entidade) {
		Funcionario funcionario = (Funcionario)entidade;
		PreparedStatement pstm = null;
		Usuario usuario = new Usuario();
		UsuarioDAO usuDao = new UsuarioDAO();
		
		
		
		List<EntidadeDominio>funcionarios = null;
		List<EntidadeDominio> usuarios = usuDao.listar(funcionario.getUsuario());
		FiltroFuncionario filtro = new FiltroFuncionario();
		String sql = filtro.gerarQuerry(funcionario);
		
		
		try {
			connection = Conexao.getConnection();
			funcionarios = new ArrayList<EntidadeDominio>();
			
			pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Funcionario fun = new Funcionario();
				Usuario usu = null;
				int i = 0;
				
				fun.setId(rs.getLong("fun_id"));
				fun.setCpf(rs.getString("fun_cpf"));
				
				if(usuarios != null && !usuarios.isEmpty()) {
					if(usuarios.get(i).getId() == fun.getId()) {
						usu = (Usuario)usuarios.get(0);
						fun.setUsuario(usuario);
						i++;
					}
				}
				
				funcionarios.add(fun);
				
			}
				
			return funcionarios;
				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(connection != null) {
					connection.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}



}
