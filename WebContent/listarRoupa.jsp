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
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<!-- https://materializecss.com/icons.html -->
	<link rel="stylesheet" href="_CSS/materialIcons.css" >
	<!-- 	CSS BOOTSTRAP -->
	<link rel="stylesheet" href="_CSS/bootstrap.min.css">

	<title>Listar Roupas</title>

</head>

<body style="margin-top:30px">
	<div>
		<c:import url="pedacos/navbar.jsp" />
	</div>

	<div class="row">
		
		<div class="container" style="margin-top: 5%">
		
			 <div class="col-m1 order-md-1">
			 
			 <table id="tabela-roupas" class="table table-striped table-bordered table-sm">
					<thead>
					<tr class="text-center">
						<c:if test="${usuarioAutenticado.nivelAcesso != 'MODERADOR_JUNIOR' }">
							<th class="th-sm" scope="col">#</th>
						</c:if>
						<th class="th-sm" scope="col">Marca</th>
						<th class="th-sm" scope="col">Preço de Venda</th>
						<th class="th-sm" scope="col">Quantidade Disponível</th>
						<th class="th-sm" scope="col">Tamanho</th>
						<th class="th-sm" scope="col">Cor</th>
						<th class="th-sm" scope="col">Lote</th>
						<c:if test="${usuarioAutenticado.nivelAcesso == 'MODERADOR_SENIOR' }">
							<th class="th-sm" scope="col">Excluir</th>
						</c:if>
					</tr>
					</thead>
					<c:if test="${usuarioAutenticado.nivelAcesso == 'MODERADOR_SENIOR' or usuarioAutenticado.nivelAcesso == 'MODERADOR_PLENO' }">
						<div class="row text-right" >
							<a href="/es3_2020/cadastrarRoupa.jsp" class="botao-cadastrar col-12 text-truncate " value="">
				  				NOVA ROUPA <i class="material-icons large text-right">add</i>
							</a>
						</div>
					</c:if>
					<tbody>
					
				<c:if test="${usuarioAutenticado.nivelAcesso == 'MODERADOR_SENIOR' or usuarioAutenticado.nivelAcesso == 'MODERADOR_PLENO' or usuarioAutenticado.nivelAcesso == 'MODERADOR_JUNIOR' }">
				
				<%		
					Resultado resultado = (Resultado)request.getAttribute("ResultadoRoupaConsultar");
					List<EntidadeDominio> entidades = null;
					if(resultado != null){
						entidades = resultado.getEntidades();	
					}
				if(entidades != null && !entidades.isEmpty()){
						//out.println("nao e nulo 2");
						for(EntidadeDominio entidade : entidades){
							Roupa roupa = (Roupa)entidade;	
				out.println("<tr scope = 'row'>");
				%>
				<c:if test="${usuarioAutenticado.nivelAcesso == 'MODERADOR_SENIOR' || usuarioAutenticado.nivelAcesso == 'MODERADOR_PLENO'}">
				<td class="text-center">
				<form action="/es3_2020/editarRoupa.jsp" method="POST">
				<% 
				out.println("<input type='hidden' name='txtRoupaId' value='" + Math.toIntExact(roupa.getId()) + "' class='txtRoupaId form-control'>");
				%>
				<button name="operacao" id="CONSULTAR" type="submit" value="CONSULTAR" style="border-width: inherit; background: border-box;">
					<a href="" class="botao-alterar">
				  		<i class="material-icons medium ">update</i>
					</a>
				</button>
				</form>
				</td>
				</c:if>
				
				
				<%
				out.println("<input type='hidden' value='" + Math.toIntExact(roupa.getId()) + "' class='id'>");
				out.println("<td class='marca text-center' name='marca'>"+ roupa.getMarca()+"</td>");
				out.println("<td class='precoVenda text-center' name='precoVenda' R$>"+roupa.getPrecoVenda()+"</td>");
				out.println("<td class='quantidadeDisponivel text-center' name='quantidadeDisponivel'>"+roupa.getQuantidadeDisponivel()+"</td>");
				out.println("<td class='tamanho text-center' name='tamanho'>"+roupa.getTamanho()+"</td>");
				out.println("<td class='cor text-center' name='cor'>"+roupa.getCor().getDescricao()+"</td>");
				out.println("<td class='lote text-center' name='lote'>"+roupa.getLote().getId()+"</td>");
				%>
				
				<c:if test="${usuarioAutenticado.nivelAcesso == 'MODERADOR_SENIOR'}">
				<td class="text-center">
					<a href="" class="botao-remover" value="">
				  		<i class="material-icons large text-danger">delete</i>
					</a>
				</td>
				</c:if>	
				<%		
						out.println("</tr>");
						}
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
	
	<!-- 	https://sweetalert2.github.io/-->
	<script src="plugins/sweetalert2.js"></script>
	<script src="plugins/jquery-3.1.1.min.js"></script>
    <script src="plugins/popper.min.js"></script>
    <script src="plugins/bootstrap.min.js"></script>
    <script src="JAVASCRIPT/listarRoupa.js"></script>
	

</body>

</html>