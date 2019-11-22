<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.edu.fatec.Baby_Clothes.model.Resultado" %>
<%@ page import="br.edu.fatec.Baby_Clothes.model.EntidadeDominio" %>
<%@ page import="br.edu.fatec.Baby_Clothes.model.Funcionario" %>
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

<body>

	<div class="">
		<c:import url="pedacos/navbar.jsp" />
	</div>

<div class"">
	<div class="row">
		
		<div class="container" style="margin-top: 5%">
		
			 <div class="col-m1 order-md-1">
			 
			 <table id="tabela-fornecedores" class="table table-striped table-bordered table-sm">
					<thead>
					<tr class="text-center">
						<c:if test="${usuarioAutenticado.nivelAcesso == 'ADMINISTRADOR' }">
							<th class="th-sm" scope="col">#</th>
						</c:if>
						<th class="th-sm" scope="col">Nome</th>
						<th class="th-sm" scope="col">CPF</th>
						<th class="th-sm" scope="col">Email</th>
						<th class="th-cm" scope="col">Nivel de Acesso</th>
						<c:if test="${usuarioAutenticado.nivelAcesso == 'ADMINISTRADOR' }">
							<th class="th-sm" scope="col">Excluir</th>
						</c:if>
					</tr>
					</thead>
					<c:if test="${usuarioAutenticado.nivelAcesso == 'ADMINISTRADOR'}">
						<div class="row text-right" >
							<a href="/ES3/cadastrarUsuario.jsp" class="botao-cadastrar col-12 text-truncate " value="">
				  				NOVO FUNCIONÁRIO <i class="material-icons large text-right">add</i>
							</a>
						</div>
					</c:if>
					<tbody>
				
				<c:if test="${usuarioAutenticado.nivelAcesso == 'ADMINISTRADOR'}">
				
				<%	
				//out.println(request.getAttributeNames().nextElement());
				Resultado resultado = (Resultado)request.getAttribute("ResultadoFuncionarioConsultar");
				List<EntidadeDominio> entidades = null;
				if(resultado != null){
						entidades = resultado.getEntidades();	
					}
				if(entidades != null && !entidades.isEmpty()){
					for(EntidadeDominio entidade : entidades){
						Funcionario funcionario = (Funcionario)entidade;	
					
				out.println("<tr scope = 'row'>");
				%>
				<c:if test="${usuarioAutenticado.nivelAcesso == 'ADMINSTRADOR'}">
				<td class="text-center">
					<a href="#" class="botao-remover" value="">
				  		<i class="material-icons medium ">update</i>
					</a>
				</td>
				</c:if>	
				<%
				out.println("<input type='hidden' value='" + Math.toIntExact(funcionario.getId()) + "' class='id'>");
				out.println("<td class='nome text-center'>"+ funcionario.getNome()+"</td>");
				out.println("<td class='cpf text-center'>"+funcionario.getCpf()+"</td>");
				out.println("<td class='email text-center'>"+funcionario.getEmail()+"</td>");
				out.println("<td class='nivelAcesso text-center'>" + funcionario.getNivelAcesso() + "</td>");
				%>
				<c:if test="${usuarioAutenticado.nivelAcesso == 'MODERADOR_SENIOR'}">
				<td>
					<a href="/LoteController" class="botao-remover" value="">
					  <i class="material-icons small">delete</i>
					</a>
				</td>
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
	<div class="footer-bar">
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