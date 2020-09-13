<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.edu.fatec.Baby_Clothes.model.Resultado" %>
<%@ page import="br.edu.fatec.Baby_Clothes.model.EntidadeDominio" %>
<%@ page import="br.edu.fatec.Baby_Clothes.model.Lote" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!-- https://materializecss.com/icons.html -->
		<link rel="stylesheet" href="_CSS/materialIcons.css" >
		<!-- 	CSS BOOTSTRAP -->
		<link rel="stylesheet" href="_CSS/bootstrap.min.css">

	<title>Lista de Lotes</title>
</head>

<body style="margin-top:30px">
	<div class="">
		<c:import url="pedacos/navbar.jsp" />
	</div>

	<div class="row">
		
		<div class="container" style="margin-top: 5%">
		
			 <div class="col-m1 order-md-1">
			 
			 <table id="tabela-fornecedores" class="table table-striped table-bordered table-sm">
					<thead>
					<tr class="text-center">
						<c:if test="${usuarioAutenticado.nivelAcesso != 'MODERADOR_JUNIOR' }">
							<th class="th-sm" scope="col">#</th>
						</c:if>
						<th class="th-sm" scope="col">Preço por unidade</th>
						<th class="th-sm" scope="col">Quantidade de Peças</th>
						<th class="th-sm" scope="col">Fornecedor</th>
						<c:if test="${usuarioAutenticado.nivelAcesso == 'MODERADOR_SENIOR' }">
							<th class="th-sm" scope="col">Excluir</th>
						</c:if>
					</tr>
					</thead>
					<c:if test="${usuarioAutenticado.nivelAcesso == 'MODERADOR_SENIOR' or usuarioAutenticado.nivelAcesso == 'MODERADOR_PLENO' }">
						<div class="row text-right" >
							<a href="/es3_2020/cadastrarLote.jsp" class="botao-cadastrar col-12 text-truncate " value="">
				  				NOVO LOTE <i class="material-icons large text-right">add</i>
							</a>
						</div>
					</c:if>
					<tbody>
				
				<c:if test="${usuarioAutenticado.nivelAcesso == 'MODERADOR_SENIOR' or usuarioAutenticado.nivelAcesso == 'MODERADOR_PLENO' or usuarioAutenticado.nivelAcesso == 'MODERADOR_JUNIOR' }">
				
				<%	
				Resultado resultado = (Resultado)request.getAttribute("ResultadoLoteConsulta");
				List<EntidadeDominio> entidades = null;
				if(resultado != null){
						entidades = resultado.getEntidades();	
					}
				if(entidades != null && !entidades.isEmpty()){
					for(EntidadeDominio entidade : entidades){
						Lote lote = (Lote)entidade;	
					
				out.println("<tr scope = 'row'>");
				%>
				<c:if test="${usuarioAutenticado.nivelAcesso == 'MODERADOR_SENIOR' || usuarioAutenticado.nivelAcesso == 'MODERADOR_PLENO'}">
				<td class="text-center">
				<form action="editarLote.jsp" method="POST">
				<% 
				out.println("<input type='hidden' name='txtLoteId' value='" + Math.toIntExact(lote.getId()) + "' class='txtLoteId form-control'>");
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
				out.println("<input type='hidden' value='" + Math.toIntExact(lote.getId()) + "' class='txtLoteId'>");
				out.println("<td class='quantidadePecas text-center'>"+lote.getQuantidadePecas()+"</td>");
				out.println("<td class='nomeFantasia text-center'>"+lote.getFornecedor().getNomeFantasia()+"</td>");
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
	<script src="JAVASCRIPT/listarLote.js"></script>

</body>

</html>