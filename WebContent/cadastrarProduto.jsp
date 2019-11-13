<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="br.edu.fatec.Baby_Clothes.model.Resultado" %>
<%@ page import="br.edu.fatec.Baby_Clothes.model.Funcionario" %>
<%@ page import="br.edu.fatec.Baby_Clothes.model.EntidadeDominio" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Cadastro de Roupa</title>
</head>
<body>

	<%
		/* HttpSession sessao = request.getSession();
		Resultado resultado = (Resultado)sessao.getAttribute("Resultado");
		List<EntidadeDominio> entidades = resultado.getEntidades();
		Funcionario funcionario = (Funcionario)entidades.get(0);
	
		
		if(funcionario == null || funcionario.getNivelAcesso().ordinal() < 2 ){
			response.sendRedirect("acessoNegado.jsp");
		}
		 */
	
	%>
	<div>
		<c:import url="pedacos/navbar.jsp"/>
	</div>
	
	<div class="row">
	
		<div class="container" style="margin-top: 4%">
			<div class="col-ml-12 order-md-1">
				<form class="needs-validation" action="RoupaController" method="post" novalidate>
				
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
							<label for="txtMarca">Marca</label>
							<input type="text" class="form-control" name="txtMarca" id="txtmarca" placeholder="" value="" required>
							<div class="invalid-feedback">É obrigatório inserir uma marca valido!</div>
						</div>
					</div>
					
					<div class="row">
						<div class="com-md-12 mb-3">
							<label for="txtPrecoVenda">Preço de Venda</label>
							<input type="text" class="form-control" name="txtPrecoVenda" id="txtPrecoVenda" placeholder="" value="" required>
							<div class="invalid-feedback">É necessário inserir um preço valido!</div>
						</div>
					</div>
					
					<div class="row">
						<div class="com-md-12 mb-3">
							<label for="txtQuantidadeDisponivel">Quantidade disponível</label>
							<input type="number" class="form-control" name="txtQuantidadeDisponivel" id="txtQuantidadeDisponivel" min="0" step="1" placeholde="" value="" required>
							<div class="invalid-feedback">É obrigatório inserir uma quantidade valida</div>
						</div>
					</div>
					
					<div class="row">
						<div class="com-md-12 mb-3">
							<label for="cbTamanho">Tamanho</label>
							<select class="form-control" name="cbTamanho" id="cbTamanho" required>
								<option value="">Selecione uma Opção</option>
								<option value="RN">Recém-Nascido</option> 
								<option value="P">Pequeno</option>
								<option value="M">Médio</option>
								<option value="G">Grande</option>
								<option value="GG">Extra Grande</option>
							</select>
							<div class="invalid-feedback">É necessário a escolha de um tamanho válido!</div>
						</div>
					</div>
					
					<div class="row">
						<div class="com-md-12 mb-3">
							<label for="txtCor">Cor</label>
							<input type="text" class="form-control" name="txtCor" id="txtCor" placeholder="" value="" required>
							<div class="invalid-feedback">Necessário inserir uma Cor válida!</div>
						</div>
					</div>
					
					<div class="row">
						<div class="com-md-12 mb-3">
							<label for="txtLote">Lote</label>
							<input type="text" class="form-control" name="txtLote" id="txtLote" placeholder="" value="" required>
							<div class="invalid-feedback">Necessário inserir um lote válido!</div>
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
	<!-- <h1>passou por todos os processos, falta cadastrar no DAO, Ver mensagens de erros e direcionar para pagina correta conforme nivel de acesso.</h1> -->
</body>
</html>