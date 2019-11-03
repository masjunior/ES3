<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Fomulario Usuário</title>

</head>

<body>
	<div class="row">
		<c:import url="pedacos/navbar.jsp" />
	</div>

	<div class="row" >

		<div class="container" style=" margin-top: 4%;">
			<div class="col-ml-12 order-md-1">

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
								<option value="" selected="selected" disabled>Selecione
									um nível de acesso</option>
								<option value="ADMINISTRADOR">Administrador</option>
								<option value="MODERADOR_JUNIOR">Moderador Junior</option>
								<option value="MODERADOR_PLENO">Moderador Pleno</option>
								<option value="MODERADOR_SENIOR">Moderador Senior</option>
							</select>
							<div class="invalid-feedback" style="width: 100%;">É
								obrigatório inserir um nível de acesso.</div>
						</div>
					</div>
					<hr class="mb-4">
					<button class="btn btn-primary btn-lg btn-block" name="operacao" id="operacao" type="submit" value="SALVAR">SALVAR</button>
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
	<script>
		window.jQuery
				|| document
						.write(
								'<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')
	</script>
	<script src="../../assets/js/vendor/popper.min.js"></script>
	<script src="../../dist/js/bootstrap.min.js"></script>
	<script src="../../assets/js/vendor/holder.min.js"></script>
	<!-- Bootstrap Stack Path -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous">
	</script>
	
	<script>
        // Exemplo de JavaScript para desativar o envio do formulário, se tiver algum campo inválido.
        (function() {
            'use strict';
            window.addEventListener(
                'load',function() {
                    // Selecione todos os campos que nós queremos aplicar estilos Bootstrap de validação customizados.
                    var forms = document.getElementsByClassName('needs-validation');
                    // Faz um loop neles e previne envio
                    var validation = Array.prototype.filter.call(
                        forms, function(form) {
                            form.addEventListener(
                                'submit',function(event) {
                                    if (form.checkValidity() === false) {
                                        event.preventDefault();
                                        event.stopPropagation();
                                    }
                                    form.classList.add('was-validated');
                                },
                            false);
                        });
                }, false);
        })();
    </script>

</body>

</html>