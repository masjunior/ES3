<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!-- https://materializecss.com/icons.html -->
		<link rel="stylesheet" href="_CSS/materialIcons.css" >
		<!-- 	CSS BOOTSTRAP -->
		<link rel="stylesheet" href="_CSS/bootstrap.min.css">
		<title>Listar Funcionarios</title>
	</head>
	<body>
	<h1>Funcionarios</h1>

	<table>
		<tr>
			<th> Nome </th>
			<th> CPF </th>
			<th> Descrição </th>
		</tr>
		<c:forEach var="func" items="${funcionarios}">
			<tr>
				<td> ${func.nome} </td>
				<td> ${func.cpf} </td>
				<td> ${func.usuario.email} </td>
				<td> ${func.usuario.nivelAcesso} </td>
			</tr>
		</c:forEach>
	</table>
	
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