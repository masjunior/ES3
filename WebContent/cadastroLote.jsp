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
<title>Cadastro de Lote</title>

</head>

<body>
	<div class="row">
		<c:import url="pedacos/navbar.jsp" />
	</div>

	<div class="row">
		
		<div class="container" style="margin-top: 4%">
		
			 <div class="col-m1 order-md-1">
			 
			 	<form class="needs-validation" action="LoteController" method="post" novalidate>
			 	
			 		<div class="row">
			 		
			 			<div class="com-md-12 mb-3">
			 			
			 				<label for="txtPrecoCompraUnidade">Preço por Unidade</label>
			 				<input type="text" class="form-control" name="txtPrecoCompraUnidade" id="txtPrecoCompraUnidadel" placeholder="" value="" required>		
			 				<div class="invalid-feedback">É obragatório inserir um Preço válido</div>
			 				
			 			</div>
			 		
			 		</div>
			 		
			 		<div class="row">
			 		
			 			<div class="com-md-12 mb-3">
			 			
			 				<label for="txtQuantidadePecas">Quantidade de Peças</label>
			 				<input type="text" class="form-control" name="txtQUantidadePecas" id="txtQuantidadePecas" placeholder="" value="" required>		
			 				<div class="invalid-feedback">É obragatório inserir uma Quantidade válida.</div>
			 				
			 			</div>
			 		
			 		</div>
			 		
			 		<div class="row">
			 		
			 			<div class="com-md-12 mb-3">
			 			
			 				<label for="txtFornecedor">Fornecedor</label>
			 				<input type="text" class="form-control" name="txtFornecedor" id="txtFornecedor" placeholder="" value="" required>		
			 				<div class="invalid-feedback">É obragatório inserir um Fornecedor válido.</div>
			 				
			 			</div>
			 		
			 		</div>
			 		
			 		<hr class="mb-4">
			 		<button class="btn btn-primary btn-lg btn-block" name="operacao" id="SALVAR" type="submit" value="SALVAR">SALVAR</button> 
			 		
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