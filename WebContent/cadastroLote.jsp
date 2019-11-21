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
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- https://materializecss.com/icons.html -->
	<link rel="stylesheet" href="css/materialIcons.css" >
	<!-- 	CSS BOOTSTRAP -->
	<link rel="stylesheet" href="css/bootstrap.min.css">
	
	<title>Cadastro de Lote</title>

</head>

<body>

	<%
		Resultado resultado = (Resultado)request.getAttribute("ResultadoFornecedorConsultar");	
		List<EntidadeDominio> fornecedores = null;
		if(resultado != null){
			if(resultado.getEntidades() != null){
				fornecedores = resultado.getEntidades();
			}
		}
	%>

	<div class="row">
		<c:import url="pedacos/navbar.jsp" />
	</div>

	<div class="row">
		
		<div class="container" style="margin-top: 4%">
		
			 <div class="col-m1 order-md-1">
			 
			 	<form class="needs-validation" action="LoteController" method="post" novalidate>
			 	
			 		<div class="row d-none">
			 		
			 			<div class="com-md-12 mb-3">
			 				
			 				<label for="txtId">ID</label>
			 				<input type="text" class="form-control" name="txtId" id="txtId" placeholder="" value="" required>		
			 				<div class="invalid-feedback">É obrigatório inserir um ID válido.</div>
			 				
			 			</div>
			 		
			 		</div>
			 		
			 		<div class="row d-none">
			 		
			 			<div class="com-md-12 mb-3">
			 				
			 				<label for="txtDataCadastro">Data de Cadastro</label>
			 				<input type="text" class="form-control" name="txtDatacadastro" id="txtDataCadastro" placeholder="" value="" required>		
			 				<div class="invalid-feedback">É obrigatório inserir uma Data de Cadastro válida.</div>
			 				
			 			</div>
			 		
			 		</div>
			 		
			 		<div class="row ">
			 		
						    <c:if test = "${ResultadoLoteSalvo.mensagem != null}">
						    	<p><c:out value = "${ResultadoLoteSalvo.mensagem}"/><p>
						    </c:if>
			 		
			 		</div>
			 	
			 		<div class="row">
			 		
			 			<div class="com-md-12 mb-3">
			 			
			 				<label for="txtPrecoCompraUnidade">Preço por Unidade</label>
			 				<input type="text" class="form-control" name="txtPrecoCompraUnidade" id="txtPrecoCompraUnidadel" placeholder="" value="" required>		
			 				<div class="invalid-feedback">É obrigatório inserir um Preço válido</div>
			 				
			 			</div>
			 		
			 		</div>
			 		
			 		<div class="row">
			 		
			 			<div class="com-md-12 mb-3">
			 			
			 				<label for="txtQuantidadePecas">Quantidade de Peças</label>
			 				<input type="number" class="form-control" name="txtQuantidadePecas" id="txtQuantidadePecas" placeholder="" value="" min="1" max="6" required>		
			 				<div class="invalid-feedback">É obrigatório inserir uma Quantidade válida.</div>
			 				
			 			</div>
			 		
			 		</div>
			 		
			 		<div class="row">
			 		
			 			<div class="com-md-12 mb-3">
			 			
			 				<label for="txtFornecedor">Fornecedor</label>
			 			<!-- 	<input type="text" class="form-control" name="txtFornecedor" id="txtFornecedor" placeholder="" value="" required> -->
			 				<select class="form-control" name="txtFornecedor" id="txtFornecedor" required>
			 				<option value="">Selecione</option>
			 				
			 				<%
			 				
			 				if(fornecedores != null && !fornecedores.isEmpty()){
			 					for(EntidadeDominio entidade : fornecedores){
			 						Fornecedor fornecedor = (Fornecedor)entidade;
			 						
			 						out.println("<option value= '" + fornecedor.getId() +"'>"+ fornecedor.getNomeFantasia() +"</option>");
			 					}
			 						
			 				}
			 				
			 				%>
			 				
			 				
			 				</select>		
			 				<div class="invalid-feedback">É obrigatório inserir um Fornecedor válido.</div>
			 				<%
// 			 				out.println(request.getAttributeNames().nextElement());
			 				%>
			 			</div>
			 		
			 		</div>
			 		
			 		<hr class="mb-4">
			 		<button class="btn btn-primary btn-lg btn-block" name="operacao" id="SALVAR" type="submit" value="SALVAR">SALVAR</button> 
			 		
			 	</form>
			 	
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