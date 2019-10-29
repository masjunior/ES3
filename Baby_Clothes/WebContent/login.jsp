<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

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


	<!-- Bootstrap core JavaScript-->
	<script src="../assets/javascripts/vendors/jquery.min.js"></script>
	<script src="../assets/javascripts/vendors/bootstrap.min.js"></script>

	<!-- Bootstrap Stack Path -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>


	<!-- Custom styles for this template -->
	<link href="../assets/stylesheets/shop-homepage.css" rel="stylesheet">
	<link href="../assets/stylesheets/style.css" rel="stylesheet">


</body>

</html>