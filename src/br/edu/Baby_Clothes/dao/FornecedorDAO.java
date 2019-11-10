package br.edu.Baby_Clothes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			String sql = "INSERT INTO fornecedor(frn_razaoSocial, frn_nomeFantasia, frn_razaoResponsavel, frn_cnpj, frn_email,"
					+ " frn_telefone) VALUES (?,?,?,?,?,?)";
			
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, fornecedor.getRazaoSocial());
			pstm.setString(2, fornecedor.getNomeFantasia());
			pstm.setString(3, fornecedor.getRazaoResponsavel());
			pstm.setString(4, fornecedor.getCnpj());
			pstm.setString(5, fornecedor.getEmail());
			pstm.setString(6, fornecedor.getTelefone());
					
			pstm.executeUpdate();
			
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
	public void remover(EntidadeDominio entidade) {
		PreparedStatement pstm = null;
		Fornecedor fornecedor = (Fornecedor)entidade;
		
		try {
			conexao = Conexao.getConnection();
			
			String sql = "DELETE FROM fornecedor WHERE frn_id = ?";
			pstm = conexao.prepareStatement(sql);
			
			pstm.setLong(1, fornecedor.getId());
			
			pstm.executeUpdate();
			
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
			String sql = "UPDATE fornecedor SET frn_razaoSocial = ?, frn_nomeFantasia = ?, frn_razaoResponsavel = ?, frn_cnpj = ?, frn_email = ?, frn_telefone = ?";
			pstm = conexao.prepareStatement(sql);
			
			pstm.setString(1, fornecedor.getRazaoSocial());
			pstm.setString(2, fornecedor.getNomeFantasia());
			pstm.setString(3, fornecedor.getRazaoResponsavel());
			pstm.setString(4, fornecedor.getCnpj());
			pstm.setString(5, fornecedor.getEmail());
			pstm.setString(6, fornecedor.getTelefone());
			
			pstm.executeUpdate();
			
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
	public List<EntidadeDominio> listar(EntidadeDominio entidade) {
		Fornecedor fornecedor =(Fornecedor)entidade;
		PreparedStatement pstm = null;
		
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
				
				frn.setId(rs.getLong("fnr_id"));
				//frn.setDataCriacao(rs.getString("fnr_dtCadastro"));
				frn.setRazaoSocial(rs.getString("frn_razaoSocial"));
				frn.setNomeFantasia(rs.getString("frn_nomeFantasia"));
				frn.setRazaoResponsavel(rs.getString("frn_razaoResponsavel"));
				frn.setCnpj(rs.getString("frn_cnpj"));
				frn.setEmail(rs.getString("frn_email"));
				frn.setTelefone(rs.getString("frn_telefone"));
				
				LoteDAO loteDao = new LoteDAO();
				List<EntidadeDominio> lotesEntidade = loteDao.listar(frn);
				List<Lote> lotes = (List<Lote>)(Lote)lotesEntidade;
				
				frn.setLotes(lotes);
				
				
				
				listaFornecedores.add(frn);
			}
			
			return listaFornecedores;
			
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
		return null;
	}

}