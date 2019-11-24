package br.edu.Baby_Clothes.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.edu.Baby_Clothes.dao.filtro.FiltroFornecedor;
import br.edu.Baby_Clothes.util.Conexao;
import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Fornecedor;
import br.edu.fatec.Baby_Clothes.model.Lote;

public class FornecedorDAO implements IDAO {

	private Connection conexao = null;
	
	@Override
	public void cadastrar(EntidadeDominio entidade) {
		PreparedStatement pstm = null;
		Fornecedor fornecedor = (Fornecedor)entidade;
		
		try {
			conexao = Conexao.getConnection();
			conexao.setAutoCommit(false);
			String sql = "INSERT INTO site_roupa.fornecedor(frn_data_criacao, frn_habilitado, frn_razaoSocial, frn_nomeFantasia, frn_razaoResponsavel, frn_cnpj, frn_email, frn_telefone) VALUES (?,?,?,?,?,?,?,?)";
			
			pstm = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			LocalDateTime date = fornecedor.getDataCriacao();
			Date sqlDate = Date.valueOf(date.toLocalDate());
			pstm.setDate(1, sqlDate);
			
			pstm.setBoolean(2, true);
			pstm.setString(3, fornecedor.getRazaoSocial());
			pstm.setString(4, fornecedor.getNomeFantasia());
			pstm.setString(5, fornecedor.getRazaoResponsavel());
			pstm.setString(6, fornecedor.getCnpj());
			pstm.setString(7, fornecedor.getEmail());
			pstm.setString(8, fornecedor.getTelefone());
					
			pstm.executeUpdate();
			
			conexao.commit();
			
			ResultSet rs = pstm.getGeneratedKeys();
			
			while(rs.next()) {
				fornecedor.setId(rs.getLong(1));
			}
			
		}catch(Exception e) {
			try {
				System.out.println("entrei no exception");
				conexao.rollback();
				
			}catch(SQLException eSQL) {
				eSQL.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				pstm.close();
				conexao.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void remover(EntidadeDominio entidade) {
		PreparedStatement pstm = null;
		Fornecedor fornecedor = (Fornecedor)entidade;
		
		try {
			conexao = Conexao.getConnection();
			conexao.setAutoCommit(false);
			
			String sql = "UPDATE fornecedor SET frn_habilitado = ? WHERE frn_id = ?";
			pstm = conexao.prepareStatement(sql);
			
			pstm.setBoolean(1, false);
			
			pstm.setLong(2, fornecedor.getId());
			
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
				conexao.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor)entidade;
		PreparedStatement pstm = null;
		
		try {
			conexao = Conexao.getConnection();
			String sql = "UPDATE fornecedor SET frn_habilitado = ?, frn_razaoSocial = ?, frn_nomeFantasia = ?, frn_razaoResponsavel = ?, frn_cnpj = ?, frn_email = ?, frn_telefone = ? WHERE frn_id = ?";
			pstm = conexao.prepareStatement(sql);
			
			pstm.setBoolean(1, fornecedor.isHabilitado());
			pstm.setString(2, fornecedor.getRazaoSocial());
			pstm.setString(3, fornecedor.getNomeFantasia());
			pstm.setString(4, fornecedor.getRazaoResponsavel());
			pstm.setString(5, fornecedor.getCnpj());
			pstm.setString(6, fornecedor.getEmail());
			pstm.setString(7, fornecedor.getTelefone());
			pstm.setLong(8, fornecedor.getId());
			
			pstm.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstm.close();
				conexao.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public List<EntidadeDominio> listar(EntidadeDominio entidade) {
		Fornecedor fornecedor =(Fornecedor)entidade;
		PreparedStatement pstm = null;
		
		System.out.println("ID FORNECEDOR DAO" + fornecedor.getId());
		
		List<EntidadeDominio> listaFornecedores = null;
		FiltroFornecedor filtro = new FiltroFornecedor();
		String sql = filtro.gerarQuerry(fornecedor);
		
		try {
			conexao = Conexao.getConnection();
			listaFornecedores = new ArrayList<EntidadeDominio>();
			
			pstm = conexao.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Fornecedor frn = new Fornecedor();
				
				frn.setId(rs.getLong("frn_id"));
				LocalDateTime date = rs.getTimestamp(2).toLocalDateTime();
				frn.setDataCriacao(date);
				frn.setHabilitado(rs.getBoolean("frn_habilitado"));
				frn.setRazaoSocial(rs.getString("frn_razaoSocial"));
				frn.setNomeFantasia(rs.getString("frn_nomeFantasia"));
				frn.setRazaoResponsavel(rs.getString("frn_razaoResponsavel"));
				frn.setCnpj(rs.getString("frn_cnpj"));
				frn.setEmail(rs.getString("frn_email"));
				frn.setTelefone(rs.getString("frn_telefone"));
				
				listaFornecedores.add(frn);
			}
			
			return listaFornecedores;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conexao != null) {
					conexao.close();
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
