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
<!-- Bootstrap Stack Path -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous">
	</script>
<title>Cadastro de Lote</title>

</head>

<body>

	<%
	
		Resultado resultado = (Resultado)request.getAttribute("ResultadoFornecedorConsultar");	
		List<EntidadeDominio> fornecedores = null;
		if(resultado.getEntidades() != null){
			fornecedores = resultado.getEntidades();
		};
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
			 		
			 			<div class="com-md-12 mb-3">
	 				        <c:set var = "teste" scope = "session" value = "${ResultadoLoteSalvo.mensagem}"/>
						    <c:if test = "${teste.length() != 0}">
						    	<p>Mensagem de retorno:  <c:out value = "${teste}"/><p>
						    </c:if>
						    <c:set var = "teste" scope = "session" value = ""/>
						    <c:out value="${teste.length() }"/>
			 			</div>
			 		
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
			 				<input type="text" class="form-control" name="txtQuantidadePecas" id="txtQuantidadePecas" placeholder="" value="" required>		
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
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	

</body>

</html>