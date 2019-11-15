<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Cadastro de Fornecedor</title>

</head>

<body>
	<div class="row">
		<c:import url="pedacos/navbar.jsp" />
	</div>

	<div class="row">
		
		<div class="container" style="margin-top: 4%">
		
			 <div class="col-m1 order-md-1">
			 
			 	<form class="needs-validation" action="/FornecedorController" method="post" novalidate>
			 	
			 		<div class="row d-none">
			 		
			 			<div class="com-md-12 mb-3">
			 				
			 				<label for="txtId">ID</label>
			 				<input type="text" class="form-control" name="txtId" id="txtId" placeholder="" value="" required>		
			 				<div class="invalid-feedback">É obragatório inserir um ID válido.</div>
			 				
			 			</div>
			 		
			 		</div>
			 		
			 		<div class="row d-none">
			 		
			 			<div class="com-md-12 mb-3">
			 				
			 				<label for="txtDataCadastro">Data de Cadastro</label>
			 				<input type="text" class="form-control" name="txtDatacadastro" id="txtDataCadastro" placeholder="" value="" required>		
			 				<div class="invalid-feedback">É obragatório inserir uma Data de Cadastro válida.</div>
			 				
			 			</div>
			 		
			 		</div>
			 	
			 		<div class="row">
			 		
			 			<div class="com-md-12 mb-3">
			 				
			 				<label for="txtRazaoSocial">Razão Social</label>
			 				<input type="text" class="form-control" name="txtRazaoSocial" id="txtRazaoSocial" placeholder="" value="" required>		
			 				<div class="invalid-feedback">É obragatório inserir uma Razão Social válida.</div>
			 				
			 			</div>
			 		
			 		</div>
			 		
			 		<div class="row">
			 		
			 			<div class="com-md-12 mb-3">
			 			
			 				<label for="txtCNPJ">CNPJ</label>
			 				<input type="text" class="form-control" name="txtCNPJ" id="txtCNPJ" placeholder="" value="" required>		
			 				<div class="invalid-feedback">É obragatório inserir um CNPJ válido.</div>
			 				
			 			</div>
			 		
			 		</div>
			 		
			 		<div class="row">
			 		
			 			<div class="com-md-12 mb-3">
			 			
			 				<label for="txtNomeFantasia">Nome Fantasia</label>
			 				<input type="text" class="form-control" name="txtNomeFantasia" id="txtNomeFantasia" placeholder="" value="" required>		
			 				<div class="invalid-feedback">É obragatório inserir um Nome Fantasia válido.</div>
			 				
			 			</div>
			 		
			 		</div>
			 		
			 		<div class="row">
			 		
			 			<div class="com-md-12 mb-3">
			 			
			 				<label for="txtRazaoResponsavel">Nome do Responsável</label>
			 				<input type="text" class="form-control" name="txtRazaoResponsavel" id="txtRazaoResponsavel" placeholder="" value="" required>		
			 				<div class="invalid-feedback">É obragatório inserir um Nome de Responsável válido.</div>
			 				
			 			</div>
			 		
			 		</div>
			 		
			 		<div class="row">
			 		
			 			<div class="com-md-12 mb-3">
			 			
			 				<label for="txtEmail">Email</label>
			 				<input type="text" class="form-control" name="txtEmail" id="txtEmail" placeholder="" value="" required>		
			 				<div class="invalid-feedback">É obragatório inserir um Email válido.</div>
			 				
			 			</div>
			 		
			 		</div>
			 		
			 		<div class="row">
			 		
			 			<div class="com-md-12 mb-3">
			 			
			 				<label for="txtTelefone">Telefone</label>
			 				<input type="text" class="form-control" name="txtTelefone" id="txtTelefone" placeholder="" value="" required>		
			 				<div class="invalid-feedback">É obragatório inserir um Telefone válido.</div>
			 				
			 			</div>
			 		
			 		</div>
			 		
			 		<hr class="mb-4">
			 		<button class="btn btn-primary btn-lg btn-block" name="operacao" id="SALVAR" type="submit" value="SALVAR">SALVAR</button> 
			 		
			 	</form>
			 	
			 	<form class="needs-validation" action="listarFornecedor.jsp" method="post" novalidate>
			 	<button class="btn btn-primary btn-lg btn-block" name="operacao" id="CONSULTAR" type="submit" value="CONSULTAR">CONSULTAR</button>
			 	</form>
			 
			 
			 </div>
			
		</div>
	
	</div>

	<div class="row" style="margin-top: 8%;">
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