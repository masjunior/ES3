<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.edu.fatec.Baby_Clothes.model.EntidadeDominio" %>
<%@ page import="br.edu.fatec.Baby_Clothes.model.Lote" %>
<%@ page import="br.edu.fatec.Baby_Clothes.model.Roupa" %>
<%@ page import="br.edu.fatec.Baby_Clothes.model.Tamanho" %>
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
		
		<title>Editar Roupa</title>
	</head>

	<body style="margin-top: 30px">
	
		<div class="row">
			<c:import url="pedacos/navbar.jsp" />
		</div>
	
		<div class="row">
	
			<div class="container" style="margin-top: 4%">
	
				<div class="col-m1 order-md-1">
	
					<%
				 Resultado resultado = (Resultado)request.getAttribute("ResultadoRoupaConsultar");
					Resultado resultadoLote = (Resultado)request.getAttribute("ResultadoLoteConsulta");
				 List<EntidadeDominio> entidades = null;
				 List<EntidadeDominio> entidadesLotes = null;
				 Roupa roupa = null;
				 Lote lote = null;
				 Tamanho tamanho = null;
				 
				 if(resultado != null){
					 entidades = resultado.getEntidades();
					 
					 if(entidades != null && !entidades.isEmpty()){
						 roupa = (Roupa)entidades.get(0);
					 }
				 }
				 %>
					<form class="needs-validation" action="ProdutoController" method="post" novalidate>
						<div class="row d-none">
							<div class="com-md-12 mb-3">
								<label for="txtRoupaId">ID</label>
								 <input type="text" class="form-control" name="txtRoupaId" id="txtRoupaId" placeholder="" value="<% if(roupa != null){out.println(roupa.getId());} %>" required>
								<div class="invalid-feedback">É obrigatório inserir um ID válido.</div>
							</div>
						</div>
						<div class="row d-none">
							<div class="com-md-12 mb-3">
								<label for="txtDataCadastro">Data de Cadastro</label> <input type="text" class="form-control"
									name="txtDataCadastro" id="txtDataCadastro" placeholder="" value="<%if(roupa != null){out.println(roupa.getDataCriacao());} %>" required>
								<div class="invalid-feedback">É obrigatório inserir uma Data de Cadastro válida.</div>
							</div>
						</div>
						<div class="row d-none">
							<div class="com-md-12 mb-3">
								<label for="txtHabilitado">HABILITADO?</label> <input type="text" class="form-control"
									name="txtHabilitado" id="txtHabilitado" placeholder="" value="<%if(roupa != null){out.println(roupa.isHabilitado());} %>" required>
								<div class="invalid-feedback">É obrigatório inserir uma Data de Cadastro válida.</div>
							</div>
						</div>
						<div class="row">
							<div class="com-md-12 mb-3">
								<label for="txtMarca">Marca</label> <input type="text" class="form-control"
									name="txtMarca" id="txtMarca" placeholder=""
									value="<%if(roupa != null){out.println(roupa.getMarca());} %>" required>
								<div class="invalid-feedback">É obrigatório inserir uma Marca válida.</div>
							</div>
						</div>
						<div class="row">
							<div class="com-md-12 mb-3">
								<label for="txtPrecoVenda">Preço de Venda</label>
									<input type="text" class="form-control" name="txtPrecoVenda" id="txtPrecoVenda" placeholder="" value="<%if(roupa != null){out.println(roupa.getPrecoVenda());} %>" required min="1" step="1">
								<div class="invalid-feedback">É obrigatório inserir um Preço válido.</div>
							</div>
						</div>
						<div class="row">
							<div class="com-md-12 mb-3">
								<label for="txtQuantidadeDisponivel">Quantidade Disponível</label>
								<input type="text" class="form-control" name="txtQuantidadeDisponivel" id="txtQuantidadeDisponivel" placeholder="" value="<%if(roupa != null){out.println(roupa.getQuantidadeDisponivel());} %>" required min="1" step="1">
								<div class="invalid-feedback">É obrigatório inserir um Fornecedor válido.</div>
							</div>
						</div>
						<div class="row">
							<div class="com-md-12 mb-3">
								<label for="cbTamanho">Tamanho</label>
								<select class="form-control" name="cbTamanho" id="cbTamanho" required>
								<option value="">Selecione uma Opção</option>
								
							<%
							out.println("<option value='" + roupa.getTamanho()+"' selected>"+ roupa.getTamanho() + "</option>");
							%>
								<option value="RN" <%if(roupa != null){if(roupa.getTamanho().equals("RN")){out.println("selected");}};%> class="RN">Recém-Nascido</option> 
								<option value="P"  <%if(roupa != null){if(roupa.getTamanho().equals("P")){out.println("selected");}};%>class="P">Pequeno</option>
								<option value="M"  <%if(roupa != null){if(roupa.getTamanho().equals("M")){out.println("selected");}};%>class="M">Médio</option>
								<option value="G"  <%if(roupa != null){if(roupa.getTamanho().equals("G")){out.println("selected");}};%>class="G">Grande</option>
								<option value="GG"  <%if(roupa != null){if(roupa.getTamanho().equals("GG")){out.println("selected");}}%>class="GG">Extra Grande</option>
							</select>
								<div class="invalid-feedback">É obrigatório inserir um Tmanho válido.</div>
							</div>
						</div>
						<div class="row">
							<div class="com-md-12 mb-3">
								<label for="txtCor">Cor</label>
								<input type="text" class="form-control" name="txtCor" id="txtCor" placeholder="" value="<%if(roupa != null){out.println(roupa.getCor().getDescricao());} %>" required min="1" step="1">
								<div class="invalid-feedback">É obrigatório inserir uma Cor válida.</div>
							</div>
						</div>
						<div class="row">
							<div class="com-md-12 mb-3">
								<label for="txtLote">Lote</label>
								<select class="form-control" name="txtLote" id="txtLote" required>
									<%
									 out.println("<option value='" + roupa.getLote().getId()+"' selected>"+roupa.getLote().getId()+"</option>");
									 if(resultadoLote != null){
										 entidadesLotes = resultadoLote.getEntidades();
										 
										 if(entidadesLotes != null){
											 for(EntidadeDominio entidadeLote : entidadesLotes){
												 lote = (Lote)entidadeLote;
													if(lote.getId() != roupa.getLote().getId()){
														 out.println("<option value='"+lote.getId()+"'>"+lote.getId()+"</option>");
													}
											 }
										 }
									 }
									%>
								</select>
								<div class="invalid-feedback">É obrigatório inserir um Lote válido.</div>
							</div>
						</div>
						<hr class="mb-4">
						<button class="btn btn-primary btn-lg btn-block" name="operacao" id="ALTERAR" type="submit" value="ALTERAR">ALTERAR</button>
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