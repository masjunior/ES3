<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.edu.fatec.Baby_Clothes.model.Resultado" %>
<%@ page import="br.edu.fatec.Baby_Clothes.model.EntidadeDominio" %>
<%@ page import="br.edu.fatec.Baby_Clothes.model.Roupa" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap Stack Path -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous">
	</script>
	<!-- https://materializecss.com/icons.html -->
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<title>Listar Roupas</title>

</head>

<body>

	<div class="row">
		<c:import url="pedacos/navbar.jsp" />
	</div>

	<div class="row">
		
		<div class="container" style="margin-top: 4%">
		
			 <div class="col-m1 order-md-1">
			 
			 <table class="table">
					<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Marca</th>
						<th scope="col">Preço de Venda</th>
						<th scope="col">Quantidade Disponível</th>
						<th scope="col">Tamanho</th>
						<th scope="col">Cor</th>
						<th scope="col">Lote</th>
					</tr>
					</thead>
					<tbody>
				<c:if test="${usuarioAutenticado.nivelAcesso == 'MODERADOR_SENIOR' or usuarioAutenticado.nivelAcesso == 'MODERADOR_PLENO' or usuarioAutenticado.nivelAcesso == 'MODERADOR_JUNIOR' }">
				
				<%		
					Resultado resultado = (Resultado)request.getAttribute("ResultadoFornecedorConsultar");
					List<EntidadeDominio> entidades = null;
					if(resultado != null){
						entidades = resultado.getEntidades();	
					}
					
					if(entidades != null && !entidades.isEmpty()){
						for(EntidadeDominio entidade : entidades){
							Roupa roupa = (Roupa)entidade;	
					
					

	
				out.println("<tr scope = 'row'>");
				out.println("<td class='id' name='id'> " + Math.toIntExact(roupa.getId()) + "</td>");
				out.println("<td class='marca' name='marca'>"+ roupa.getMarca()+"</td>");
				out.println("<td class='precoVenda' name='precoVenda' R$>"+roupa.getPrecoVenda()+"</td>");
				out.println("<td class='quantidadeDisponivel' name='quantidadeDisponivel'>"+roupa.getQuantidadeDisponivel()+"</td>");
				out.println("<td class='tamanho' name='tamanho'>"+roupa.getTamanho()+"</td>");
				out.println("<td class='cor' name='cor'>"+roupa.getCor().getDescricao()+"</td>");
				out.println("<td class='lote' name='lote'>"+roupa.getLote().getId()+"</td>");
				%>
				
				<c:if test="${usuarioAutenticado.nivelAcesso == 'MODERADOR_SENIOR'}">
				<td>
					<a href="/LoteController" class="botao-remover" value="">
				  		<i class="material-icons small">delete</i>
					</a>
				</td>
				<c:if test="${usuarioAutenticado.nivelAcesso == 'MODERADOR_PLENO'}">
				<td>
					<a href="/LoteController" class="botao-editar" value="">
				  		<i class="material-icons small">border_color</i>
					</a>
				</td>
				</c:if>	
				</c:if>	
				<c:if test="${usuarioAutenticado.nivelAcesso == 'MODERADOR_JUNIOR'}">
				<td>SOU JUNIOR</td>
				</c:if>	
						
				<%		
						}
						out.println("</th>");
					}
				%>
				</c:if>
				
					</tbody>
				
				</table>
	
	
						
								
			 
			 </div>
			
		</div>
	
	</div>

	<div class="" style="margin-top: 8%;">
		<c:import url="pedacos/footer.jsp" />
	</div>
	

	<!-- Principal JavaScript do Bootstrap
    ================================================== -->
	<!-- Foi colocado no final para a página carregar mais rápido -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	
	<script src="JAVASCRIPT/listarFornecedor.js"></script>

</body>

</html>