<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- https://materializecss.com/icons.html -->
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<!-- 	CSS BOOTSTRAP -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<title>BABY CLOTHES - Login</title>


</head>

<body class="bg-dark">
	<div class="mt-0">
		<c:import url="pedacos/navbar.jsp" />
	</div>

	<div class="container mt-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card card-login mt-5">
					<div class="card-header">Login</div>
					<div class="card-body">

						<form action="Autenticacao" method="POST">
							<div class="form-group">
								<div class="form-label-group">
									<label for="inputEmail">E-mail</label> <input type="email"
										id="txtLogin" name="txtLogin" class="form-control"
										placeholder="Ex. abcde@gmail.com" required="required"
										autofocus="autofocus">
								</div>
							</div>
							<div class="form-group">
								<div class="form-label-group">
									<label for="inputPassword">Senha</label> <input type="password"
										id="txtSenha" name="txtSenha" class="form-control"
										placeholder="*******" required="required"> <a
										class="d-block small" href="#">Esqueceu sua senha?</a>
								</div>
							</div>
							<div class="form-group">
								<div class="checkbox">
									<label> <input type="checkbox" value="remember-me">
										Lembrar senha
									</label>
								</div>
							</div>
							<button type="submit" class="btn btn-primary btn-block"
								name="btnOperacao" value="CONSULTAR">Entrar</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="mt-5" >
		<c:import url="pedacos/footer.jsp" />
	</div>

<!-- Principal JavaScript do Bootstrap
    ================================================== -->
	<!-- Foi colocado no final para a página carregar mais rápido -->
	<!-- 	https://sweetalert2.github.io/-->
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
	
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	




</body>

</html>