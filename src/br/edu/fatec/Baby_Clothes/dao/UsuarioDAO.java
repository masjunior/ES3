package br.edu.fatec.Baby_Clothes.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.edu.fatec.Baby_Clothes.dao.filtro.FiltroUsuario;
import br.edu.fatec.Baby_Clothes.util.Conexao;
import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.NivelAcesso;
import br.edu.fatec.Baby_Clothes.model.Usuario;

public class UsuarioDAO implements IDAO {

	Connection conexao = null;
	
	@Override
	public void cadastrar(EntidadeDominio entidade) {
		Usuario usuario = (Usuario)entidade;
		PreparedStatement pstm = null; 
		String sql;
		
		try {
			conexao = Conexao.getConnection();
			conexao.setAutoCommit(false);
			sql = "INSERT INTO site_roupa.usuario(usu_data_criacao, usu_habilitado, usu_email, usu_senha, usu_nivel_acesso, usu_id) VALUES (?,?,?,?,?)";
			pstm = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			LocalDateTime date = usuario.getDataCriacao();
			Date sqlDate = Date.valueOf(date.toLocalDate());
			pstm.setDate(1, sqlDate);
			
			pstm.setBoolean(2, true );
			pstm.setString(3, usuario.getEmail());
			pstm.setString(4, usuario.getSenha());
			pstm.setInt(5, usuario.getNivelAcesso().getValor());
			
			pstm.executeUpdate();
			conexao.commit();
			
		}catch(Exception e) {
			try {
				conexao.rollback();
			}catch(SQLException eSQL) {
				eSQL.printStackTrace();
			}
		e.printStackTrace();
		}finally {
			try {
				pstm.close();
				Conexao.fechar(conexao);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public void remover(EntidadeDominio entidade) {
		Usuario usuario = (Usuario)entidade;
		String sql;
		PreparedStatement pstm = null;
		
		try {
			conexao = Conexao.getConnection();
			conexao.setAutoCommit(false);
			sql = "UPDATE usuario SET usu_habilitado = ? WHERE usu_id = ?";
			
			pstm = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstm.setBoolean(1, false);
			pstm.setLong(2, usuario.getId());
			
			pstm.executeUpdate();
			conexao.commit();
			
		}catch(Exception e) {
			try {
				conexao.rollback();
			}catch(SQLException eSQL) {
				eSQL.printStackTrace();
			}
		e.printStackTrace();
		}finally {
			try {
				pstm.close();
				Conexao.fechar(conexao);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		Usuario usuario = (Usuario)entidade;
		String sql;
		PreparedStatement pstm = null;
		
		try {
			conexao = Conexao.getConnection();
			conexao.setAutoCommit(false);
			sql = "UPDATE usuario SET usu_data_criacao = ?, usu_habilitado = ?, usu_email = ?, usu_senha = ?, usu_nivel_acesso = ?"
					+ " WHERE usu_id = ?";
			pstm = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			LocalDateTime date = usuario.getDataCriacao();
			Date sqlDate = Date.valueOf(date.toLocalDate());
			pstm.setDate(1, sqlDate);
			
			
			pstm.setBoolean(2, usuario.isHabilitado());
			pstm.setString(3, usuario.getEmail());
			pstm.setString(4,  usuario.getSenha());
			pstm.setInt(5, usuario.getNivelAcesso().ordinal());
			pstm.setLong(6, usuario.getId());
			
			pstm.executeUpdate();
			conexao.commit();
			
		}catch(Exception e) {
			try {
				conexao.rollback();
			}catch(SQLException eSQL) {
				eSQL.printStackTrace();
			}
		e.printStackTrace();
		}finally {
			try {
				pstm.close();
				Conexao.fechar(conexao);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public List<EntidadeDominio> listar(EntidadeDominio entidade) {
		Usuario usuario = (Usuario)entidade;
		FiltroUsuario filtro = new FiltroUsuario();
		String sql = filtro.gerarQuerry(usuario);
		List<EntidadeDominio> listaUsuario = null;
		PreparedStatement pstm = null;
		
		try {
			conexao = Conexao.getConnection();
			listaUsuario = new ArrayList<EntidadeDominio>();
			
//			conexao.setAutoCommit(false);
			pstm = conexao.prepareStatement(sql);
//			System.out.println(sql);
//			conexao.commit();
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Usuario usr = new Usuario();
				
				usr.setId(rs.getLong("usu_id"));
				usr.setHabilitado(rs.getBoolean("usu_habilitado"));
				LocalDateTime date = rs.getTimestamp(2).toLocalDateTime();
				usr.setDataCriacao(date);
				usr.setEmail(rs.getString("usu_email"));
				usr.setSenha(rs.getString("usu_senha"));
				
				int acesso = rs.getInt("usu_nivel_acesso");
				NivelAcesso NA = NivelAcesso.getByName(acesso);
				
				usr.setNivelAcesso(NA);
				
				listaUsuario.add(usr);
				
			}
			
			return listaUsuario;
			
			
		}catch(Exception e) {
//			try {
//				conexao.rollback();
//			}catch(SQLException eSQL) {
//				eSQL.printStackTrace();
//			}
		e.printStackTrace();
		}finally {
			try {
				pstm.close();
				Conexao.fechar(conexao);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return null;
	}
	
	
	public EntidadeDominio listarUsuario(EntidadeDominio entidade) {
		Usuario usuario = (Usuario)entidade;
		FiltroUsuario filtro = new FiltroUsuario();
		String sql = filtro.gerarQuerry(usuario);
		EntidadeDominio usuarioBanco = null;
		PreparedStatement pstm = null;
		
		try {
			conexao = Conexao.getConnection();
			usuarioBanco = new EntidadeDominio();
			
			pstm = conexao.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Usuario usr = new Usuario();

				usr.setId(rs.getLong("usu_id"));
				usr.setHabilitado(rs.getBoolean("usu_habilitado"));
				LocalDateTime date = rs.getTimestamp(2).toLocalDateTime();
				usr.setDataCriacao(date);
				usr.setEmail(rs.getString("usu_email"));
				usr.setSenha(rs.getString("usu_senha"));
				
				int acesso = rs.getInt("usu_nivel_acesso");
				String a = String.valueOf(acesso);
				NivelAcesso NA = NivelAcesso.getByName(acesso);
				
				usr.setNivelAcesso(NA);
				
				usuarioBanco = usr;
				
			}
			if(usuarioBanco.getId() == null) {
				return null;
			}
			
			return usuarioBanco;
			
			
		}catch(Exception e) {
//			try {
//				conexao.rollback();
//			}catch(SQLException eSQL) {
//				eSQL.printStackTrace();
//			}
		e.printStackTrace();
		}finally {
			try {
				pstm.close();
				Conexao.fechar(conexao);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
//		System.out.println("vou retornar null");
		return null;
	}
	
	

}
