<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.edu.fatec.Baby_Clothes.model.Resultado" %>
<%@ page import="br.edu.fatec.Baby_Clothes.model.EntidadeDominio" %>
<%@ page import="br.edu.fatec.Baby_Clothes.model.Fornecedor" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- https://materializecss.com/icons.html -->
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<!-- 	CSS BOOTSTRAP -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	
	

	<title>Listar de Fornecedores</title>
</head>

<body onload="window.location.reload">
	<div>
		<c:import url="pedacos/navbar.jsp" />
	</div>
<div class="" style="height: 90vh">
	
	<div class="row">
		<div class="container" style="margin-top: 4%">
			 <div class="col-m1 order-md-1">
			 <table class="table">
					<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Razão Social</th>
						<th scope="col">CNPJ</th>
						<th scope="col">Nome Fantasia</th>
						<th scope="col">Nome Responsável</th>
						<th scope="col">Email</th>
						<th scope="col">Telefone</th>
					</tr>
					</thead>
					
				<div class="row text-right" >
					<a href="/ES3/cadastrarFornecedor.jsp" class="botao-cadastrar col-12 text-truncate " value="">
		  				NOVO FORNECEDOR <i class="material-icons large text-right">add</i>
					</a>
				</div>
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
							Fornecedor fornecedor = (Fornecedor)entidade;	
					
					

	
				out.println("<tr scope = 'row'>");
				%>
				<c:if test="${usuarioAutenticado.nivelAcesso == 'MODERADOR_SENIOR'}">
				<td>
					<a href="/LoteController" class="botao-remover" value="">
				  		<i class="material-icons small ">update</i>
					</a>
				</td>
				</c:if>	
				<c:if test="${usuarioAutenticado.nivelAcesso == 'MODERADOR_PLENO'}">
				<td>
					<a href="/LoteController" class="botao-remover" value="testedobotao">
				  		<i class="material-icons small ">update</i>
					</a>
				</td>
				</c:if>	
				<%
				out.println("<input type='hidden' value='" + Math.toIntExact(fornecedor.getId()) + "' class='id'>");
// 				out.println("<td class='id' name='id'> " + Math.toIntExact(fornecedor.getId()) + "</td>");
				out.println("<td class='razaoSocial' name='razaoSocial'>"+ fornecedor.getRazaoSocial()+"</td>");
				out.println("<td class='cnpj' name='cnpj'>"+fornecedor.getCnpj()+"</td>");
				out.println("<td class='nomeFantasia' name='nomeFantasia'>"+fornecedor.getNomeFantasia()+"</td>");
				out.println("<td class='razaoResponsavel' name='razaoResponsavel'>"+fornecedor.getRazaoResponsavel()+"</td>");
				out.println("<td class='email' name='email'>"+fornecedor.getEmail()+"</td>");
				out.println("<td class='telefone' name='telefone'>"+fornecedor.getTelefone()+"</td>");
				%>
				
				<c:if test="${usuarioAutenticado.nivelAcesso == 'MODERADOR_SENIOR'}">
				<td>
					<a href="/LoteController" class="botao-remover" value="">
				  		<i class="material-icons small text-danger">delete</i>
					</a>
				</td>
				<c:if test="${usuarioAutenticado.nivelAcesso == 'MODERADOR_PLENO'}">
				<td>
					<a href="/LoteController" class="botao-remover" value="testedobotao">
				  		<i class="material-icons small text-danger">delete</i>
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
</div>
		<c:import url="pedacos/footer.jsp" />
	<!-- Principal JavaScript do Bootstrap
    ================================================== -->
	<!-- Foi colocado no final para a página carregar mais rápido -->
	
<!-- 	https://sweetalert2.github.io/-->
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
	
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script src="JAVASCRIPT/listarFornecedor.js"></script>
	
</body>

</html>