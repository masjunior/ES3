<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.edu.fatec.Baby_Clothes.model.Resultado" %>
<%@ page import="br.edu.fatec.Baby_Clothes.model.EntidadeDominio" %>
<%@ page import="br.edu.fatec.Baby_Clothes.model.Fornecedor" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap Stack Path -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous">
	</script>
<title>Cadastro de Fornecedor</title>

</head>

<body>

	<div class="row">
		<c:import url="pedacos/navbar.jsp" />
	</div>

	<div class="row">
		
		<div class="container" style="margin-top: 4%">
		
			 <div class="col-m1 order-md-1">
			 
			 <table class="table">
					<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Razão Social</th>
						<th scope="col">CNPJ</th>
						<th scope="col">Nome Fantasia</th>
						<th scope="col">Nome Responsável</th>
						<th scope="col">Email</th>
						<th scope="col">Telefone</th>
					</tr>
					</thead>
					
					<tbody>
			 
				<%		
					Resultado resultado = (Resultado)request.getAttribute("ResultadoFornecedorConsultar");
					List<EntidadeDominio> entidades = resultado.getEntidades();
					
					if(entidades != null && !entidades.isEmpty()){
						for(EntidadeDominio entidade : entidades){
							Fornecedor fornecedor = (Fornecedor)entidade;	
					
					
<<<<<<< HEAD
	
				out.println("<tr scope = 'row'></th>");
=======
				out.println("<tr scope = 'row'></tr>");
>>>>>>> 21388a3bac312fdfae0d6905cdf405726057172f
				out.println("<td> " + Math.toIntExact(fornecedor.getId()) + "</td>");
				out.println("<td>"+ fornecedor.getRazaoSocial()+"</td>");
				out.println("<td>"+fornecedor.getCnpj()+"</td>");
				out.println("<td>"+fornecedor.getNomeFantasia()+"</td>");
				out.println("<td>"+fornecedor.getRazaoResponsavel()+"</td>");
				out.println("<td>"+fornecedor.getEmail()+"</td>");
				out.println("<td>"+fornecedor.getTelefone()+"</td>");
				
						
						
						
						}
						out.println("<br>");
					}
				%>
					</tbody>
				
				</table>
	
	
						
								
			 
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
	
	

</body>

</html>