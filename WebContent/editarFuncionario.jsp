<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.edu.fatec.Baby_Clothes.model.EntidadeDominio" %>
<%@ page import="br.edu.fatec.Baby_Clothes.model.Lote" %>
<%@ page import="br.edu.fatec.Baby_Clothes.model.Funcionario" %>
<%@ page import="br.edu.fatec.Baby_Clothes.model.Resultado" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!-- https://materializecss.com/icons.html -->
		<link rel="stylesheet" href="_CSS/materialIcons.css" >
		<!-- 	CSS BOOTSTRAP -->
		<link rel="stylesheet" href="_CSS/bootstrap.min.css">
		
		<title>Editar Funcionario</title>
	</head>

	<body style="margin-top: 30px">
	
		<div class="row">
			<c:import url="pedacos/navbar.jsp" />
		</div>
	
		<div class="row">
	
			<div class="container" style="margin-top: 4%">
	
				<div class="col-m1 order-md-1">
	
					<%
				 Resultado resultado = (Resultado)request.getSession().getAttribute("ResultadoFuncionarioConsultar");
				 
				 List<EntidadeDominio> entidades = null;
				 Funcionario funcionario = null;
				 
				 
				 if(resultado != null){
					 entidades = resultado.getEntidades();
					 
					 if(entidades != null && !entidades.isEmpty()){
						 funcionario = (Funcionario)entidades.get(0);
					 }
				 }
				 
				 
				 %>
					<form class="needs-validation" action="FuncionarioController" method="post" novalidate>
						<div class="row d-none">
							<div class="com-md-12 mb-3">
								<label for="txtId">ID</label> <input type="text" class="form-control" name="txtId" id="txtId"
									placeholder="" value="<% if(funcionario != null){out.println(funcionario.getId());} %>" required>
								<div class="invalid-feedback">É obrigatório inserir um ID válido.</div>
							</div>
						</div>
						<div class="row d-none">
							<div class="com-md-12 mb-3">
								<label for="txtDataCadastro">Data de Cadastro</label> <input type="text" class="form-control"
									name="txtDataCadastro" id="txtDataCadastro" placeholder="" value="<%if(funcionario != null){out.println(funcionario.getUsuario().getDataCriacao());} %>" required>
								<div class="invalid-feedback">É obrigatório inserir uma Data de Cadastro válida.</div>
							</div>
						</div>
						<div class="row d-none">
							<div class="com-md-12 mb-3">
								<label for="txtHabilitado">HABILITADO?</label> <input type="text" class="form-control"
									name="txtHabilitado" id="txtHabilitado" placeholder="" value="<%if(funcionario != null){out.println(funcionario.isHabilitado());} %>" required>
								<div class="invalid-feedback">É obrigatório inserir uma Data de Cadastro válida.</div>
							</div>
						</div>
						<div class="row">
							<div class="com-md-12 mb-3">
								<label for="txtNome">Nome</label> <input type="text" class="form-control"
									name="txtNome" id="txtNome" placeholder=""
									value="<%if(funcionario != null){out.println(funcionario.getNome());} %>" required>
								<div class="invalid-feedback">É obrigatório inserir um nome válido.</div>
							</div>
						</div>
						<div class="row">
							<div class="com-md-12 mb-3">
								<label for="txtCPF">CPF</label> <input type="text" class="form-control" name="txtCPF"
									id="txtCPF" placeholder=""
									value="<%if(funcionario != null){out.println(funcionario.getCpf());} %>" required>
								<div class="invalid-feedback">É obrigatório inserir um CPF válido.</div>
							</div>
						</div>
						<div class="row">
							<div class="com-md-12 mb-3">
								<label for="txtEmail">Email</label> <input type="text" class="form-control" name="txtEmail"
									id="txtEmail" placeholder=""
									value="<%if(funcionario != null){out.println(funcionario.getUsuario().getEmail());} %>" required>
								<div class="invalid-feedback">É obrigatório inserir um Email válido.</div>
							</div>
						</div>
						<div class="row">
							<div class="com-md-12 mb-3">
								<label for="txtSenha">Senha</label> <input type="text" class="form-control" name="txtSenha"
									id="txtSenha" placeholder=""
									value="<%if(funcionario != null){out.println(funcionario.getUsuario().getSenha());} %>" required>
								<div class="invalid-feedback">É obrigatório inserir uma Senha válido.</div>
							</div>
						</div>
						<div class="row">
							<div class="com-md-12 mb-3">
								<label for="txtNivelAcesso">Nivel de Acesso</label> <input type="text" class="form-control" name="txtNivelAcesso"
									id="txtNivelAcesso" placeholder=""
									value="<%if(funcionario != null){out.println(funcionario.getUsuario().getNivelAcesso());} %>" required>
								<div class="invalid-feedback">É obrigatório inserir um CPF válido.</div>
							</div>
						</div>
						<hr class="mb-4">
						<button class="btn btn-primary btn-lg btn-block" name="operacao" id="ALTERAR" type="submit"
							value="ALTERAR">ALTERAR</button>
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
	
	</body>

</html>