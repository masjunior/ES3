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

import br.edu.Baby_Clothes.dao.filtro.FiltroLote;
import br.edu.Baby_Clothes.util.Conexao;
import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Fornecedor;
import br.edu.fatec.Baby_Clothes.model.Lote;
import br.edu.fatec.Baby_Clothes.model.Roupa;

public class LoteDAO implements IDAO{

	private Connection conexao = null;
	
	@Override
	public void cadastrar(EntidadeDominio entidade) {
		Lote lote = (Lote)entidade;
		PreparedStatement pstm = null;
		
		try {
			conexao = Conexao.getConnection();
			
			String sql = "INSERT INTO lote(lot_data_criacao, lot_habilitado, lot_precoCompraUnidade, lot_quantidadePecas, lot_fornecedor) VALUES"
					+ "(?,?,?,?,?)";
			
			pstm = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			LocalDateTime date = lote.getDataCriacao();
			Date sqlDate = Date.valueOf(date.toLocalDate());
			pstm.setDate(1, sqlDate);
			
			pstm.setBoolean(2, true);
			pstm.setDouble(3, lote.getPrecoCompraUnidade());
			pstm.setInt(4, lote.getQuantidadePecas());
			pstm.setInt(5, Math.toIntExact(lote.getFornecedor().getId()));
			
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
		Lote lote = (Lote)entidade;
		PreparedStatement pstm = null;
		
		try {
			conexao = Conexao.getConnection();
			String sql = "UPDATE lote SET lot_habilitado = ? WHERE lot_id = ?";
			
			pstm = conexao.prepareStatement(sql);
			
			pstm.setBoolean(1, false);
			pstm.setInt(2, Math.toIntExact(lote.getId()));
			
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
		Lote lote = (Lote)entidade;
		PreparedStatement pstm = null;
		
		try {
			conexao = Conexao.getConnection();
			String sql = "UPDATE lote SET lot_habilitado = ?, lot_precoCompraUnidade = ?, lot_quantidadePecas = ?, lot_fornecedor = ? WHERE lot_id = ?";
			
			pstm = conexao.prepareStatement(sql);
			
			pstm.setBoolean(1, lote.isHabilitado());
			pstm.setDouble(2, lote.getPrecoCompraUnidade());
			pstm.setInt(3, lote.getQuantidadePecas());
			pstm.setInt(4, Math.toIntExact(lote.getFornecedor().getId()));
			pstm.setInt(5, Math.toIntExact(lote.getId()));
			
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
		Lote lote = (Lote)entidade;
		PreparedStatement pstm = null;
		List<EntidadeDominio> listaLotes = null;
		
		FiltroLote filtro = new FiltroLote();
		String sql = filtro.gerarQuerry(lote);
		
		try {
			conexao = Conexao.getConnection();
			listaLotes = new ArrayList<EntidadeDominio>();
			
			pstm = conexao.prepareStatement(sql);
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Lote lt = new Lote();
				
				lt.setId(rs.getLong("lot_id"));
				LocalDateTime date = rs.getTimestamp(2).toLocalDateTime();
				lt.setDataCriacao(date);
				lt.setHabilitado(rs.getBoolean("lot_habilitado"));
				lt.setPrecoCompraUnidade(rs.getDouble("lot_precoCompraUnidade"));
				lt.setQuantidadePecas(rs.getInt("lot_quantidadePecas"));
				
				Fornecedor frn = new Fornecedor();
				frn.setId(rs.getLong("lot_fornecedor"));
				
				FornecedorDAO dao = new FornecedorDAO();
				List<EntidadeDominio> fornecedores = dao.listar(frn);
				Fornecedor fornecedor = (Fornecedor)fornecedores.get(0);
				lt.setFornecedor(fornecedor);
				
				
				RoupaDAO rDao = new RoupaDAO();
				List<EntidadeDominio> roupas = rDao.listar(lt);
				List<Roupa> listaRoupas = (List<Roupa>)(Roupa)roupas;
				lt.setRoupas(listaRoupas);
				
				listaLotes.add(lt);
				
			}
			
			return listaLotes;
			
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
