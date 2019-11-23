<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- https://materializecss.com/icons.html -->
	<link rel="stylesheet" href="_CSS/materialIcons.css" >
	<!-- 	CSS BOOTSTRAP -->
	<link rel="stylesheet" href="_CSS/bootstrap.min.css">
	<title>Fomulario Usuário</title>

</head>

<body style="margin-top:30px">
	<div class="row">
		<c:import url="pedacos/navbar.jsp" />
	</div>

	<div class="row" >

		<div class="container" style=" margin-top: 4%;">
			<div class="col-ml-12 order-md-1">
			
				<div class="row d-none">
			 		
			 			<div class="com-md-12 mb-3">
			 				
			 				<label for="txtId">ID</label>
			 				<input type="text" class="form-control" name="txtId" id="txtId" placeholder="" value='<c:out value="${txtID}"></c:out>' required>		
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

				<form class="needs-validation" action="FuncionarioController" method="post" novalidate>
					<div class="row">
						<div class="col-md-12 mb-3">
							<label for="txtNome">Nome</label> <input type="text"
								class="form-control" name="txtNome" id="txtNome" placeholder="" value=""
								required>
							<div class="invalid-feedback">É obrigatório inserir um nome
								válido.</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 mb-3">
							<label for="txtCPF">CPF</label> <input type="text"
								class="form-control" name="txtCPF" id="txtCPF"
								placeholder="Insira somente numeros" value="" maxlength="11"
								onkeypress="return event.charCode >= 48 && event.charCode <= 57"
								required>
							<div class="invalid-feedback">É obrigatório inserir um CPF
								válido.</div>
						</div>
					</div>

					<div class="mb-3">
						<label for="txtEmail">Email</label>
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text">@</span>
							</div>
							<input type="email" class="form-control" name="txtEmail" id="txtEmail"
								placeholder="abc@123.com" required>
							<div class="invalid-feedback" style="width: 100%;">É
								obrigatório inserir um e-mail válido.</div>
						</div>
					</div>
					<div>
						<label for="txtNivelAcesso">Nível de Acesso</label>
						<div class="input-group">
							<select class="form-control" name="txtNivelAcesso" id="txtNivelAcesso"
								data-placeholder="Selecione o nível de acesso" required>
								<option value="" selected="selected" disabled>
									Selecione um nível de acesso
								</option>
								<option value="ADMINISTRADOR" name="Administrador">
									Administrador
								</option>
								<option value="MODERADOR_JUNIOR" name="Moderador_Junior">
									Moderador Junior
								</option>
								<option value="MODERADOR_PLENO" name="Moderador_Pleno">
									Moderador Pleno
								</option>
								<option value="MODERADOR_SENIOR" name="Moderador_Senior">
									Moderador Senior
								</option>
							</select>
							<div class="invalid-feedback" style="width: 100%;">
								É obrigatório inserir um nível de acesso.
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
</body>

</html>