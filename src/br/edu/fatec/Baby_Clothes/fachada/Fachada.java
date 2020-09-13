package br.edu.fatec.Baby_Clothes.fachada;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.fatec.Baby_Clothes.dao.FornecedorDAO;
import br.edu.fatec.Baby_Clothes.dao.FuncionarioDAO;
import br.edu.fatec.Baby_Clothes.dao.IDAO;
import br.edu.fatec.Baby_Clothes.dao.LoteDAO;
import br.edu.fatec.Baby_Clothes.dao.RoupaDAO;
import br.edu.fatec.Baby_Clothes.strategy.ComplementarDataCadastro;
import br.edu.fatec.Baby_Clothes.strategy.IStrategy;
import br.edu.fatec.Baby_Clothes.strategy.ValidarCNPJ;
import br.edu.fatec.Baby_Clothes.strategy.ValidarCPF;
import br.edu.fatec.Baby_Clothes.strategy.ValidarExistencia;
import br.edu.fatec.Baby_Clothes.strategy.ValidarPrecoVenda;
import br.edu.fatec.Baby_Clothes.strategy.ValidarQuantidadePeca;
import br.edu.fatec.Baby_Clothes.strategy.ValidarSenha;
import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Fornecedor;
import br.edu.fatec.Baby_Clothes.model.Funcionario;
import br.edu.fatec.Baby_Clothes.model.Lote;
import br.edu.fatec.Baby_Clothes.model.Resultado;
import br.edu.fatec.Baby_Clothes.model.Roupa;

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
		IStrategy validarCPF = new ValidarCPF();
		IStrategy complementarDataCadastro = new ComplementarDataCadastro();
		IStrategy validarCNPJ = new ValidarCNPJ();
		IStrategy validarExistencia = new ValidarExistencia();
		IStrategy validarPrecoVenda =  new ValidarPrecoVenda();
		IStrategy validarQuantidadePeca = new ValidarQuantidadePeca();
		IStrategy validarSenha = new ValidarSenha();
		
		// FUNCIONARIO
		daos.put(Funcionario.class.getName(), new FuncionarioDAO());

		List<IStrategy> funcionarioRns = new ArrayList<IStrategy>();
		funcionarioRns.add(validarCPF);
		funcionarioRns.add(complementarDataCadastro);
		funcionarioRns.add(validarSenha);
		funcionarioRns.add(validarExistencia);

		strategies.put(Funcionario.class.getName(), funcionarioRns);
		
		//FORNECEDOR
		daos.put(Fornecedor.class.getName(), new FornecedorDAO());

		List<IStrategy> fornecedorRns = new ArrayList<IStrategy>();
//		TODO: tira o comentario da validacao
		fornecedorRns.add(validarExistencia);
		fornecedorRns.add(validarCNPJ);
		fornecedorRns.add(complementarDataCadastro);
		
		
		strategies.put(Fornecedor.class.getName(), fornecedorRns);
		
		//LOTES
		daos.put(Lote.class.getName(), new LoteDAO());
		
		List<IStrategy> loteRns = new ArrayList<IStrategy>();
		
		loteRns.add(complementarDataCadastro);
		
		strategies.put(Lote.class.getName(), loteRns);
		
		//ROUPA
		daos.put(Roupa.class.getName(), new RoupaDAO());
		List<IStrategy> roupaRns = new ArrayList<IStrategy>();
		//TODO: arrumar validar preco, esta null em compra
		roupaRns.add(validarPrecoVenda);
		roupaRns.add(validarQuantidadePeca);
		roupaRns.add(complementarDataCadastro);
		strategies.put(Roupa.class.getName(), roupaRns);

	}

	@Override
	public Resultado salvar(EntidadeDominio entidade, String operacao) {
		resultado = new Resultado();
		nomeClasse = entidade.getClass().getName();
		strategy = strategies.get(nomeClasse);
		sb.setLength(0);

		
		
		executarMensagem(strategy, entidade, operacao);
		
		//System.out.println("tamanho SB " + sb.length());
		
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
	public Resultado alterar(EntidadeDominio entidade, String operacao) {
		resultado = new Resultado();
		sb.setLength(0);
		
		nomeClasse = entidade.getClass().getName();
		executarMensagem(strategies.get(nomeClasse), entidade, operacao);
		
		if(sb.toString().trim().equalsIgnoreCase("")) {
			try {
				dao = daos.get(nomeClasse);
				dao.alterar(entidade);
				resultado.adicionarEntidades(entidade);
				
			}catch (Exception e) {
				e.printStackTrace();
				resultado.setMensagem(sb + "N�o foi poss�vel alterar...");
			}
		}
		
		return resultado;
	}

	@Override
	public Resultado excluir(EntidadeDominio entidade, String operacao) {
		resultado = new Resultado();
		String nomeClasse = entidade.getClass().getName();
		dao = daos.get(nomeClasse);
		
		try {
			dao.remover(entidade);
			resultado.adicionarEntidades(entidade);
		}catch (Exception e) {
			e.printStackTrace();
			resultado.setMensagem("N�o foi poss�vel excluir...");
		}
		
		return resultado;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade, String operacao) {
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
	
	private void executarMensagem(List<IStrategy> rngEntidade, EntidadeDominio entidade, String operacao) {
		String msg = "";
		if(operacao.equals("ALTERAR")) {
			for (IStrategy strategy : rngEntidade) {
				if(!strategy.getClass().getSimpleName().equals("ValidarExistencia")) {
					msg = strategy.processar(entidade);
					if (msg != null) {
						sb.append(msg);
					}
				}
			}
		}else {
			for (IStrategy strategy : rngEntidade) {
				msg = strategy.processar(entidade);
				if (msg != null) {
					sb.append(msg);
				}
			}
			
		}
	}
}
