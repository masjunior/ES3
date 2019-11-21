<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.edu.fatec.Baby_Clothes.model.EntidadeDominio" %>
<%@ page import="br.edu.fatec.Baby_Clothes.model.Fornecedor" %>
<%@ page import="br.edu.fatec.Baby_Clothes.model.Resultado" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- https://materializecss.com/icons.html -->
	<link rel="stylesheet" href="_CSS/materialIcons.css" >
	<!-- 	CSS BOOTSTRAP -->
	<link rel="stylesheet" href="_CSS/bootstrap.min.css">
	<title>Cadastro de Fornecedor</title>

</head>

<body >
	
	<div class="row">
		<c:import url="pedacos/navbar.jsp" />
	</div>

	<div class="row">
		
		<div class="container" style="margin-top: 4%">
		
			 <div class="col-m1 order-md-1">
			 
			 <%
			 
			 Resultado resultado = (Resultado)request.getSession().getAttribute("ResultadoFornecedor");
			 List<EntidadeDominio> entidades = null;
			 Fornecedor fornecedor = null;
			 
			 if(resultado != null){
				 	out.println("<p style='color:red; font-size:32px;'>"+resultado.getMensagem()+"</p>");
				 entidades = resultado.getEntidades();
				 
				 if(entidades != null && !entidades.isEmpty()){
					 fornecedor = (Fornecedor)entidades.get(0);
				 }
			 }
			 %>
			 	<form class="needs-validation" action="FornecedorController" method="post" novalidate>
			 		<div class="row d-none">
			 			<div class="com-md-12 mb-3">
			 				<label for="txtId">ID</label>
			 				<input type="text" class="form-control" name="txtId" id="txtId" placeholder="" value="" required>		
			 				<div class="invalid-feedback">
			 					É obrigatório inserir um ID válido.
			 				</div>
			 			</div>
			 		</div>
			 		<div class="row d-none">
			 			<div class="com-md-12 mb-3">
			 				<label for="txtDataCadastro">Data de Cadastro</label>
			 				<input type="text" class="form-control" name="txtDatacadastro" id="txtDataCadastro" placeholder="" value="" required>		
			 				<div class="invalid-feedback">
			 					É obrigatório inserir uma Data de Cadastro válida.
			 				</div>
			 			</div>
			 		</div>
			 		<div class="row">
			 			<div class="com-md-12 mb-3">
			 				<label for="txtRazaoSocial">Razão Social</label>
			 				<input type="text" class="form-control" name="txtRazaoSocial" id="txtRazaoSocial" placeholder="" value="<%if(fornecedor != null){out.println(fornecedor.getRazaoSocial());} %>" required>		
			 				<div class="invalid-feedback">
			 					É obrigatório inserir uma Razão Social válida.
			 				</div>
			 			</div>
			 		</div>
			 		<div class="row">
			 			<div class="com-md-12 mb-3">
			 				<label for="txtCNPJ">CNPJ</label>
			 				<input type="text" class="form-control" name="txtCNPJ" id="txtCNPJ" placeholder="" value="<%if(fornecedor != null){out.println(fornecedor.getCnpj());} %>" required>		
			 				<div class="invalid-feedback">
			 					É obrigatório inserir um CNPJ válido.
			 				</div>
			 			</div>
			 		</div>
			 		<div class="row">
			 			<div class="com-md-12 mb-3">
			 				<label for="txtNomeFantasia">Nome Fantasia</label>
			 				<input type="text" class="form-control" name="txtNomeFantasia" id="txtNomeFantasia" placeholder="" value="<%if(fornecedor != null){out.println(fornecedor.getNomeFantasia());} %>" required>		
			 				<div class="invalid-feedback">
			 					É obrigatório inserir um Nome Fantasia válido.
			 				</div>
			 			</div>
			 		</div>
			 		<div class="row">
			 			<div class="com-md-12 mb-3">
			 				<label for="txtRazaoResponsavel">Nome do Responsável</label>
			 				<input type="text" class="form-control" name="txtRazaoResponsavel" id="txtRazaoResponsavel" placeholder="" value="<%if(fornecedor != null){out.println(fornecedor.getRazaoResponsavel());} %>" required>		
			 				<div class="invalid-feedback">
			 					É obrigatório inserir um Nome de Responsável válido.
			 				</div>
			 			</div>
			 		</div>
			 		<div class="row">
			 			<div class="com-md-12 mb-3">
			 				<label for="txtEmail">Email</label>
			 				<input type="text" class="form-control" name="txtEmail" id="txtEmail" placeholder="" value="<%if(fornecedor != null){out.println(fornecedor.getEmail());} %>" required>		
			 				<div class="invalid-feedback">
			 					É obrigatório inserir um Email válido.
			 				</div>
			 			</div>
			 		</div>
			 		<div class="row">
			 			<div class="com-md-12 mb-3">
			 				<label for="txtTelefone">Telefone</label>
			 				<input type="text" class="form-control" name="txtTelefone" id="txtTelefone" placeholder="" value="<%if(fornecedor != null){out.println(fornecedor.getTelefone());} %>" required>		
			 				<div class="invalid-feedback">
			 					É obrigatório inserir um Telefone válido.
			 				</div>
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