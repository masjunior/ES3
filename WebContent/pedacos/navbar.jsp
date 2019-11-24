<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark rounded"
	style="justify-content: space-between">
	<a class="navbar-brand" href="login.jsp">BABY_CLOTHES</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample09"
		aria-controls="navbarsExample09" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<c:if test="${usuarioAutenticado.nivelAcesso == 'ADMINISTRADOR' }">
		<div class="collapse navbar-collapse" id="navbar">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="listaFuncionario.jsp">Listar Funcionário</a></li>
				<li class="nav-item"><a class="nav-link" href="cadastrarUsuario.jsp">Cadastrar Funcionário</a></li>
			</ul>

		</div>
		<form method="link" action="logout.jsp" class="form-inline my-2 my-md-0">
			<input type="submit" class="form-control" value="Logout" />
		</form>
	</c:if>


	<c:if test="${usuarioAutenticado.nivelAcesso != null }">
		<c:if test="${usuarioAutenticado.nivelAcesso != 'ADMINISTRADOR' }">
			<div class="collapse navbar-collapse" id="navbar">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item"><a class="nav-link" href="listarFornecedor.jsp">Fornecedor</a></li>
					<li class="nav-item"><a class="nav-link" href="listarLote.jsp">Lote</a></li>
					<li class="nav-item"><a class="nav-link " href="listarRoupa.jsp">Roupa</a></li>
				</ul>

			</div>
			<form method="link" action="logout.jsp" class="form-inline my-2 my-md-0">
				<input type="submit" class="form-control" value="Logout" />
			</form>
		</c:if>
	</c:if>
</nav>

