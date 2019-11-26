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
import br.edu.fatec.Baby_Clothes.model.Fornecedor;
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
			
			if(roupa.getLote().getId() != null ) {
			
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
				pstm.setInt(6, roupa.getTamanho().getValor());
				pstm.setLong(7, roupa.getLote().getId());
				pstm.setString(8, roupa.getCor().getDescricao());
				
				System.out.println("ROUPADAO " + roupa.getTamanho().getValor());
				
				pstm.executeUpdate();
				
			}else {
				LoteDAO dao = new LoteDAO();
				Lote lote = roupa.getLote();
				
				dao.cadastrar(lote);
				
				List<EntidadeDominio> lotes = new ArrayList<EntidadeDominio>();
				lotes = dao.listar(lote);
				
				Long id = lotes.get(0).getId();
	
				roupa.getLote().setId(id);
				
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
				
			}
			
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
			conexao.setAutoCommit(false);
			String sql = "UPDATE roupa SET rou_habilitado = ?, rou_marca = ?, rou_preco_venda = ?, rou_quantidade_disponivel = ?, rou_tamanho = ?, rou_lote = ?, rou_cor = ? WHERE"
					+ " rou_id = ?";
			
			pstm = conexao.prepareStatement(sql);
			
			pstm.setBoolean(1, roupa.isHabilitado());
			pstm.setString(2, roupa.getMarca());
			pstm.setDouble(3, roupa.getPrecoVenda());
			pstm.setInt(4, roupa.getQuantidadeDisponivel());
			pstm.setInt(5, roupa.getTamanho().getValor());
			pstm.setLong(6, roupa.getLote().getId());
			pstm.setString(7, roupa.getCor().getDescricao());
			pstm.setLong(8, roupa.getId());
			
			System.out.println("ROUPA DAO ID " + roupa.getId());
			System.out.println("ROUPA DAO Habilitado " + roupa.isHabilitado());
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
			
			while(rs.next()) {
				Roupa rp = new Roupa();
				Lote lt = new Lote();
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
				
				lt.setId(rs.getLong("rou_lote"));
				date = rs.getTimestamp(2).toLocalDateTime();
				lt.setDataCriacao(date);
				lt.setHabilitado(rs.getBoolean("lot_habilitado"));
				lt.setPrecoCompraUnidade(rs.getDouble("lot_precoCompraUnidade"));
				lt.setQuantidadePecas(rs.getInt("lot_quantidadePecas"));
				lt.setFornecedor(frn);

				
				
				rp.setId(rs.getLong("rou_id"));
				
				date = rs.getTimestamp(2).toLocalDateTime();
				rp.setDataCriacao(date);
				
				rp.setHabilitado(rs.getBoolean("rou_habilitado"));
				rp.setMarca(rs.getString("rou_marca"));
				rp.setPrecoVenda(rs.getDouble("rou_preco_venda"));
				rp.setQuantidadeDisponivel(rs.getInt("rou_quantidade_disponivel"));
				
				int tamanho = rs.getInt("rou_tamanho");
				Tamanho tm = Tamanho.getByName(tamanho);
				rp.setTamanho(tm);
				
				rp.setLote(lt);
				
				Cor cor = new Cor();
				cor.setDescricao(rs.getString("rou_cor"));
				rp.setCor(cor);
				
				listaRoupa.add(rp);
			}
			System.out.println("SALOMAO ROUPA DAO TAMANHO LISTA " + listaRoupa.size());
			return listaRoupa;
			
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
				conexao.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return null;
	}



}
