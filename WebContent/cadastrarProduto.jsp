<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="br.edu.fatec.Baby_Clothes.model.Resultado" %>
<%@ page import="br.edu.fatec.Baby_Clothes.model.Funcionario" %>
<%@ page import="br.edu.fatec.Baby_Clothes.model.Roupa" %>
<%@ page import="br.edu.fatec.Baby_Clothes.model.EntidadeDominio" %>
<%@ page import="br.edu.fatec.Baby_Clothes.model.Lote" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- https://materializecss.com/icons.html -->
	<link rel="stylesheet" href="_CSS/materialIcons.css" >
	<!-- 	CSS BOOTSTRAP -->
	<link rel="stylesheet" href="_CSS/bootstrap.min.css">
	<title>Cadastro de Roupa</title>
</head>
<body style="margin-top:30px">

	<%
		/* HttpSession sessao = request.getSession();
		Resultado resultado = (Resultado)sessao.getAttribute("Resultado");
		List<EntidadeDominio> entidades = resultado.getEntidades();
		Funcionario funcionario = (Funcionario)entidades.get(0);
	
		
		if(funcionario == null || funcionario.getNivelAcesso().ordinal() < 2 ){
			response.sendRedirect("acessoNegado.jsp");
		}
		 */
		 
		 Resultado resultado = (Resultado)request.getAttribute("ResultadoLoteConsulta");
		 List<EntidadeDominio>lotes = null;
		 if(resultado != null){
			 if(resultado.getEntidades() != null){
					lotes = resultado.getEntidades();
				}
		 }
	
	%>
	<div>
		<c:import url="pedacos/navbar.jsp"/>
	</div>
	
	<div class="row">
	
		<div class="container" style="margin-top: 4%">
			<div class="col-ml-12 order-md-1">
			 <%
			 
			 Resultado resultado2 = (Resultado)request.getSession().getAttribute("ResultadoRoupa");
			 List<EntidadeDominio> entidades = null;
			 Roupa roupa = null;
			 
			 if(resultado2 != null){
				 	out.println("<p style='color:red; font-size:32px;'>"+resultado2.getMensagem()+"</p>");
				 entidades = resultado2.getEntidades();
				 
				 if(entidades != null && !entidades.isEmpty()){
					 roupa = (Roupa)entidades.get(0);
				 }
			 }
			 %>
				<form class="needs-validation" action="RoupaController" method="post" novalidate>
				
					<div class="row d-none">
			 		
			 			<div class="com-md-12 mb-3">
			 				
			 				<label for="txtRoupaId">ID</label>
			 				<input type="text" class="form-control" name="txtRoupaId" id="txtRoupaId" placeholder="" value="" required>		
			 				<div class="invalid-feedback">É obragatório inserir um ID válido.</div>
			 				
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
							<input type="text" class="form-control" name="txtMarca" id="txtMarca" placeholder="" value="<%if(roupa != null){out.println(roupa.getMarca());} %>" required>
							<div class="invalid-feedback">É obrigatório inserir uma marca valido!</div>
						</div>
					</div>
					
					<div class="row">
						<div class="com-md-12 mb-3">
							<label for="txtPrecoVenda">Preço de Venda</label>
							<input type="text" class="form-control" name="txtPrecoVenda" id="txtPrecoVenda" placeholder="" value="<%if(roupa != null){out.println(roupa.getPrecoVenda());} %>" required>
							<div class="invalid-feedback">É necessário inserir um preço valido!</div>
						</div>
					</div>
					
					<div class="row">
						<div class="com-md-12 mb-3">
							<label for="txtQuantidadeDisponivel">Quantidade disponível</label>
							<input type="number" class="form-control" name="txtQuantidadeDisponivel" id="txtQuantidadeDisponivel" min="0" step="1" placeholde="" value="<%if(roupa != null){out.println(roupa.getQuantidadeDisponivel());} %>" required>
							<div class="invalid-feedback">É obrigatório inserir uma quantidade valida</div>
						</div>
					</div>
					
					<div class="row">
						<div class="com-md-12 mb-3">
							<label for="cbTamanho">Tamanho</label>
							<select class="form-control" name="cbTamanho" id="cbTamanho" required>
								<option value="">Selecione uma Opção</option>
								<option value="RN" class="RN">Recém-Nascido</option> 
								<option value="P" class="P">Pequeno</option>
								<option value="M" class="M">Médio</option>
								<option value="G" class="G">Grande</option>
								<option value="GG" class="GG">Extra Grande</option>
							</select>
							<div class="invalid-feedback">É necessário a escolha de um tamanho válido!</div>
						</div>
					</div>
					
					<div class="row">
						<div class="com-md-12 mb-3">
							<label for="txtCor">Cor</label>
							<input type="text" class="form-control" name="txtCor" id="txtCor" placeholder="" value="<%if(roupa != null){if(roupa.getCor() != null){out.println(roupa.getCor().getDescricao());}} %>" required>
							<div class="invalid-feedback">Necessário inserir uma Cor válida!</div>
						</div>
					</div>
					
					<div class="row">
						<div class="com-md-12 mb-3">
							<label for="txtLote">Lote</label>
							<select class="form-control" name="txtLote" id="txtLote" required>
								<opiton value="">Selecione</opiton>
								<%
								if(roupa != null){
									if(roupa.getLote() != null){
										out.println("<option value='" + roupa.getLote().getId() + "' selected>" + roupa.getLote().getId() + "</option>");	
									}
									
								}
								
								if(lotes != null && !lotes.isEmpty()){
									
									for(EntidadeDominio entidade : lotes){
										Lote lote = (Lote)entidade;
										
										out.println("<option value='" + lote.getId() + "'>" + lote.getId() + "</option>");
									}
								}
								
								%>
							</select>
							<!-- <input type="text" class="form-control" name="txtLote" id="txtLote" placeholder="" value="" required> -->
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
	
	<!-- 	https://sweetalert2.github.io/-->
	<script src="plugins/sweetalert2.js"></script>
	<script src="plugins/jquery-3.1.1.min.js"></script>
    <script src="plugins/popper.min.js"></script>
    <script src="plugins/bootstrap.min.js"></script>
	<script src="JAVASCRIPT/listarFornecedor.js"></script>
</body>
</html>