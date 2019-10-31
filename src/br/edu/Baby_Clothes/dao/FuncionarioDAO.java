package br.edu.Baby_Clothes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.edu.Baby_Clothes.util.Conexao;
import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Funcionario;

public class FuncionarioDAO implements IDAO{
	
	private Connection connection = null;

	@Override
	public void cadastrar(EntidadeDominio entidade) {
		
		PreparedStatement pst = null;
		Funcionario funcionario = (Funcionario)entidade;
		
		try {
			connection = Conexao.getConnection();
			
		}catch (Exception e) {
			try {
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
