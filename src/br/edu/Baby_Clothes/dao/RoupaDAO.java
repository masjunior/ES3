/**
 * 
 */
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

import br.edu.Baby_Clothes.dao.filtro.FiltroRoupa;
import br.edu.Baby_Clothes.util.Conexao;
import br.edu.fatec.Baby_Clothes.model.Cor;
import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Lote;
import br.edu.fatec.Baby_Clothes.model.Roupa;
import br.edu.fatec.Baby_Clothes.model.Tamanho;

/**
 * @author Marco_Aurelio_de_Sa_Junior 
 *
 */
public class RoupaDAO implements IDAO{

	private Connection conexao;
	
	@Override
	public void cadastrar(EntidadeDominio entidade) {
		Roupa roupa = (Roupa)entidade;
		PreparedStatement pstm = null;
		
		try {
			conexao = Conexao.getConnection();
			String sql = "INSERT INTO roupa (rou_data_criacao,rou_habilitado, rou_marca, rou_preco_venda, rou_quantidade_disponivel, rou_tamanho, rou_lote, rou_cor)"
					+ " VALUES (?,?,?,?,?,?,?,?)";
			
			pstm = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			LocalDateTime date = roupa.getDataCriacao();
			Date sqlDate = Date.valueOf(date.toLocalDate());
			pstm.setDate(1, sqlDate);
			
			pstm.setBoolean(2, true);
			pstm.setString(3, roupa.getMarca());
			pstm.setDouble(4, roupa.getPrecoVenda());
			pstm.setInt(5, roupa.getQuantidadeDisponivel());
			pstm.setInt(6, roupa.getTamanho().ordinal());
			pstm.setLong(7, roupa.getLote().getId());
			pstm.setString(8, roupa.getCor().getDescricao());
			
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
		Roupa roupa = (Roupa)entidade;
		PreparedStatement pstm = null;
		
		try {
			conexao = Conexao.getConnection();
			String sql = "UPDATE roupa SET rou_habilitado = ? WHERE rou_id = ?";
			
			pstm = conexao.prepareStatement(sql);
			
			pstm.setBoolean(1, false);
			pstm.setLong(2, roupa.getId());
			
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
		Roupa roupa = (Roupa)entidade;
		PreparedStatement pstm = null;
		
		try {
			conexao = Conexao.getConnection();
			String sql = "UPDATE roupa SET rou_habilitado = ?, rou_marca = ?, rou_preco_venda = ?, rou_quantidade_diosponivel = ?, rou_tamanho = ?, rou_lote = ?, rou_cor = ? WHERE"
					+ " rou_id = ?";
			
			pstm = conexao.prepareStatement(sql);
			
			pstm.setBoolean(1, roupa.isHabilitado());
			pstm.setString(2, roupa.getMarca());
			pstm.setDouble(3, roupa.getPrecoVenda());
			pstm.setInt(4, roupa.getQuantidadeDisponivel());
			pstm.setInt(5, roupa.getTamanho().ordinal());
			pstm.setLong(6, roupa.getLote().getId());
			pstm.setLong(7, roupa.getId());
			pstm.setString(8, roupa.getCor().getDescricao());
			
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
		Roupa roupa = (Roupa)entidade;
		List<EntidadeDominio> listaRoupa = null;
		FiltroRoupa filtro = new FiltroRoupa();
		String sql = filtro.gerarQuerry(roupa);
		PreparedStatement pstm = null;
		
		try {
			conexao = Conexao.getConnection();
			listaRoupa = new ArrayList<EntidadeDominio>();
			
			pstm = conexao.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(!rs.next()) {
				Roupa rp = new Roupa();
				Lote lote = new Lote();
				
				rp.setId(rs.getLong("rou_id"));
				
				LocalDateTime date = rs.getTimestamp(2).toLocalDateTime();
				rp.setDataCriacao(date);
				
				rp.setHabilitado(rs.getBoolean("rou_habilitado"));
				rp.setMarca(rs.getString("rou_marca"));
				rp.setPrecoVenda(rs.getDouble("rou_preco_venda"));
				rp.setQuantidadeDisponivel(rs.getInt("rou_quantidade_disponivel"));
				
				int tamanho = rs.getInt("rou_tamaanho");
				Tamanho tm = Tamanho.getByName(tamanho);
				rp.setTamanho(tm);
				
				lote.setId(rs.getLong("rou_lote"));
				rp.setLote(lote);
				
				Cor cor = new Cor();
				cor.setDescricao(rs.getString("rou_cor"));
				rp.setCor(cor);
				
				listaRoupa.add(rp);
			}
			
			return listaRoupa;
			
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
