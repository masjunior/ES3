package br.edu.Baby_Clothes.fachada;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.Baby_Clothes.dao.FornecedorDAO;
import br.edu.Baby_Clothes.dao.FuncionarioDAO;
import br.edu.Baby_Clothes.dao.IDAO;
import br.edu.Baby_Clothes.strategy.ComplementarDataCadastro;
import br.edu.Baby_Clothes.strategy.IStrategy;
import br.edu.Baby_Clothes.strategy.ValidarCNPJ;
import br.edu.Baby_Clothes.strategy.ValidarCPF;
import br.edu.Baby_Clothes.strategy.ValidarSenha;
import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Fornecedor;
import br.edu.fatec.Baby_Clothes.model.Funcionario;
import br.edu.fatec.Baby_Clothes.model.Resultado;

public class Fachada implements IFachada {
	
	private Map<String, IDAO> daos;
	private Map<String, List<IStrategy>> strategies;
	private StringBuilder sb = new StringBuilder();
	Resultado resultado;

	IDAO dao = null;
	String nomeClasse = null;
	List<IStrategy> strategy = null;
	
	public Fachada() {
		daos = new HashMap<String, IDAO>();
		strategies = new HashMap<String, List<IStrategy>>();
		IStrategy validarCPF;
		IStrategy complementarDataCadastro;
		IStrategy validarCNPJ;
		IStrategy validarExistencia;
		IStrategy validarPrecoVenda;
		IStrategy validarQuantidadePeca;
		IStrategy validarSenha;
		
		// FUNCIONARIO
		daos.put(Funcionario.class.getName(), new FuncionarioDAO());

		validarCPF = new ValidarCPF();
		complementarDataCadastro = new ComplementarDataCadastro();
		validarSenha = new ValidarSenha();

		List<IStrategy> funcionario = new ArrayList<IStrategy>();
		funcionario.add(validarCPF);
		funcionario.add(complementarDataCadastro);
		funcionario.add(validarSenha);

		strategies.put(Funcionario.class.getName(), funcionario);
		
		//FORNECEDOR
		daos.put(Fornecedor.class.getName(), new FornecedorDAO());

		validarCNPJ = new ValidarCNPJ();
		complementarDataCadastro = new ComplementarDataCadastro();

		List<IStrategy> fornecedor = new ArrayList<IStrategy>();
//		TODO: tira o comentario da validacao
//		fornecedor.add(validarCNPJ);
		fornecedor.add(complementarDataCadastro);

		strategies.put(Fornecedor.class.getName(), fornecedor);

	}

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		resultado = new Resultado();
		nomeClasse = entidade.getClass().getName();
		strategy = strategies.get(nomeClasse);
		sb.setLength(0);

		executarMensagem(strategy, entidade);

		// se tem msg de erro ele não salva
		if (sb.length() == 0 || sb.toString().trim().equals("")) {
			try {
				//TODO: DAO ESTA NULL
				dao = daos.get(nomeClasse);
				dao.cadastrar(entidade);
				resultado.adicionarEntidades(entidade);
			} catch (Exception e) {
				e.printStackTrace();
				resultado.setMensagem("Não foi possível Salvar...");
			}
		} else {

			resultado.adicionarEntidades(entidade);
			resultado.setMensagem(sb.toString());
		}

		return resultado;
	}

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		sb.setLength(0);
		resultado = new Resultado();
		
		nomeClasse = entidade.getClass().getName();
		
		dao = daos.get(nomeClasse);
		
		try {
			resultado.setEntidades(dao.listar(entidade));
		}catch(Exception e) {
			e.printStackTrace();
			resultado.setMensagem("Não foi possível realizar a consulta...");
		}
		return resultado;
		
	}
	
	private void executarMensagem(List<IStrategy> rngEntidade, EntidadeDominio entidade) {
		String msg = "";
		for (IStrategy strategy : rngEntidade) {
			msg = strategy.processar(entidade);
			if (msg != null) {
				sb.append(msg);
			}
		}
	}
}
