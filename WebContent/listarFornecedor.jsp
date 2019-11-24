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
	
	<!-- https://materializecss.com/icons.html -->
	<link rel="stylesheet" href="_CSS/materialIcons.css" >
	<!-- 	CSS BOOTSTRAP -->
	<link rel="stylesheet" href="_CSS/bootstrap.min.css">

	<title>Listar de Fornecedores</title>
</head>

<body style="margin-top:30px">
	<div>
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
						<th class="th-sm" scope="col">Razão Social</th>
						<th class="th-sm" scope="col">CNPJ</th>
						<th class="th-sm" scope="col">Nome Fantasia</th>
						<th class="th-sm" scope="col">Nome Responsável</th>
						<th class="th-sm" scope="col">Email</th>
						<th class="th-sm" scope="col">Telefone</th>
						<c:if test="${usuarioAutenticado.nivelAcesso == 'MODERADOR_SENIOR' }">
							<th class="th-sm" scope="col">Excluir</th>
						</c:if>
					</tr>
					</thead>
				<c:if test="${usuarioAutenticado.nivelAcesso == 'MODERADOR_SENIOR' or usuarioAutenticado.nivelAcesso == 'MODERADOR_PLENO' }">
				<div class="row text-right" >
					<a href="/ES3/cadastrarFornecedor.jsp" class="botao-cadastrar col-12 text-truncate " value="">
		  				NOVO FORNECEDOR <i class="material-icons large text-right">add</i>
					</a>
				</div>
				</c:if>
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
				<c:if test="${usuarioAutenticado.nivelAcesso == 'MODERADOR_SENIOR' || usuarioAutenticado.nivelAcesso == 'MODERADOR_PLENO'}">
				<td class="text-center">
				<form action="/ES3/editarFornecedor.jsp" method="POST">
				<% 
				out.println("<input type='hidden' name='txtId' value='" + Math.toIntExact(fornecedor.getId()) + "' class='id form-control'>");
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
				out.println("<td class='razaoSocial text-center' name='razaoSocial'>"+ fornecedor.getRazaoSocial()+"</td>");
				out.println("<td class='cnpj text-center' name='cnpj'>"+fornecedor.getCnpj()+"</td>");
				out.println("<td class='nomeFantasia text-center' name='nomeFantasia'>"+fornecedor.getNomeFantasia()+"</td>");
				out.println("<td class='razaoResponsavel text-center' name='razaoResponsavel'>"+fornecedor.getRazaoResponsavel()+"</td>");
				out.println("<td class='email text-center' name='email'>"+fornecedor.getEmail()+"</td>");
				out.println("<td class='telefone text-center' name='telefone'>"+fornecedor.getTelefone()+"</td>");
				%>
				
				<c:if test="${usuarioAutenticado.nivelAcesso == 'MODERADOR_SENIOR'}">
				<td class="text-center">
					<a href="" class="botao-remover " value="">
				  		<i class="material-icons large text-danger ">delete</i>
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
	<script src="JAVASCRIPT/listarFornecedor.js"></script>
	
	
</body>

</html>