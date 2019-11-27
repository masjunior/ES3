<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.edu.fatec.Baby_Clothes.model.EntidadeDominio" %>
<%@ page import="br.edu.fatec.Baby_Clothes.model.Lote" %>
<%@ page import="br.edu.fatec.Baby_Clothes.model.Fornecedor" %>
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
		
		<title>Editar Lote</title>
	</head>

	<body style="margin-top: 30px">
	
		<div class="row">
			<c:import url="pedacos/navbar.jsp" />
		</div>
	
		<div class="row">
	
			<div class="container" style="margin-top: 4%">
	
				<div class="col-m1 order-md-1">
	
					<%
				 Resultado resultado = (Resultado)request.getAttribute("ResultadoLoteConsulta");
				 Resultado resultado2 = (Resultado)request.getAttribute("ResultadoFornecedorConsultar");
				 List<EntidadeDominio> entidades = null;
				 Lote lote = null;
				 
				 List<EntidadeDominio> entidades2 = null;
				 Fornecedor fornecedor = null;
				 
				 if(resultado != null){
					 entidades = resultado.getEntidades();
					 
					 if(entidades != null && !entidades.isEmpty()){
						 lote = (Lote)entidades.get(0);
					 }
				 }
				 
				 
				 %>
					<form class="needs-validation" action="LoteController" method="post" novalidate>
						<div class="row d-none">
							<div class="com-md-12 mb-3">
								<label for="txtLoteId">ID</label>
								 <input type="text" class="form-control" name="txtLoteId" id="txtLoteId"	placeholder="" value="<% if(lote != null){out.println(lote.getId());} %>" required>
								<div class="invalid-feedback">É obrigatório inserir um ID válido.</div>
							</div>
						</div>
						<div class="row d-none">
							<div class="com-md-12 mb-3">
								<label for="txtDataCadastro">Data de Cadastro</label>
								 <input type="text" class="form-control" name="txtDataCadastro" id="txtDataCadastro" placeholder="" value="<%if(lote != null){out.println(lote.getDataCriacao());} %>" required>
								<div class="invalid-feedback">É obrigatório inserir uma Data de Cadastro válida.</div>
							</div>
						</div>
						<div class="row d-none">
							<div class="com-md-12 mb-3">
								<label for="txtHabilitado">HABILITADO?</label>
								 <input type="text" class="form-control" name="txtHabilitado" id="txtHabilitado" placeholder="" value="<%if(lote != null){out.println(lote.isHabilitado());} %>" required>
								<div class="invalid-feedback">É obrigatório inserir uma Data de Cadastro válida.</div>
							</div>
						</div>
						<div class="row">
							<div class="com-md-12 mb-3">
								<label for="txtPrecoCompraUnidade">Preço de compra por Unidade</label>
								<input type="text" class="form-control" name="txtPrecoCompraUnidade" id="txtPrecoCompraUnidade" placeholder=""
									value="<%if(lote != null){out.println(lote.getPrecoCompraUnidade());} %>" required min="1" step="0.01">
								<div class="invalid-feedback">É obrigatório inserir um valor válido.</div>
							</div>
						</div>
						<div class="row">
							<div class="com-md-12 mb-3">
								<label for="txtQuantidadePecas">Quantidade de Peças</label>
								<input type="text" class="form-control" name="txtQuantidadePecas" id="txtQuantidadePecas" placeholder=""
									value="<%if(lote != null){out.println(lote.getQuantidadePecas());} %>" required min="1" step="1">
								<div class="invalid-feedback">É obrigatório inserir uma Quantidade válida.</div>
							</div>
						</div>
						<div class="row">
							<div class="com-md-12 mb-3">
								<label for="txtFornecedor">Fornecedor</label>
								<select class="form-control" name="cbFornecedor" id="cbFornecedor" required>
									<%
									if(lote.getFornecedor() != null){
										out.println("<option value='" + lote.getFornecedor().getId()+"' selected>"+lote.getFornecedor().getNomeFantasia()+"</option>");
									}
									 
									 if(resultado2 != null){
										 entidades2 = resultado2.getEntidades();
										 
										 if(entidades2 != null){
											 for(EntidadeDominio entidade2 : entidades2){
												 fornecedor = (Fornecedor)entidade2;
													if(lote.getFornecedor().getId() != fornecedor.getId()){
														 out.println("<option value='"+fornecedor.getId()+"'>"+fornecedor.getNomeFantasia()+"</option>");
													}
											 }
										 }
									 }
									
									
									%>
								
								</select>
								<div class="invalid-feedback">É obrigatório inserir um Fornecedor válido.</div>
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