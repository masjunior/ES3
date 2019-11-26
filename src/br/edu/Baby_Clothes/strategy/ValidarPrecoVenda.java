package br.edu.Baby_Clothes.strategy;

import java.util.List;

import br.edu.Baby_Clothes.dao.LoteDAO;
import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Lote;
import br.edu.fatec.Baby_Clothes.model.Roupa;

public class ValidarPrecoVenda implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Roupa roupa = (Roupa)entidade;
		String msgRetorno = "";
		
		Lote lote = roupa.getLote();
		LoteDAO dao = new LoteDAO();
		
		List<EntidadeDominio>lotes = dao.listar(lote);
		lote = (Lote)lotes.get(0);
		double valorCompra = lote.getPrecoCompraUnidade();
		
		
		
		if(valorCompra > roupa.getPrecoVenda()) {
			System.out.println("preço vendo invalido");
			msgRetorno = "Preço de venda inválido";
		}
		
		
		return msgRetorno;
	}

}
