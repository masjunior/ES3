<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Funcionarios</title>
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
	</body>
</html>