/**
 * 
 */

$(".botao-remover").click(function(){
	event.preventDefault();
		
		console.log($(this).closest("tr"));
		$(this).closest("tr").children().each(function(){
			console.log($(this).text());
		});
		let id = $(this).closest("tr").find(".id").text();
		let razaoSocial = $(this).closest("tr").find(".razaoSocial").text();
		let cnpj = $(this).closest("tr").find(".cnpj").text();
		let nomeFantasia= $(this).closest("tr").find(".nomeFantasia").text();
		let razaoResponsavel = $(this).closest("tr").find(".razaoResponsavel").text();
		let email = $(this).closest("tr").find(".email").text();
		let telefone = $(this).closest("tr").find(".telefone").text();
		alert(id + razaoSocial + cnpj + nomeFantasia + razaoResponsavel + email + telefone );
		console.log("consegui o valor do id " + $(this).closest("tr").find(".id").text());
		console.log("consegui o valor do razaoSocial " + $(this).closest("tr").find(".razaoSocial").text());
		console.log("consegui o valor do cnpj " + $(this).closest("tr").find(".cnpj").text());
		console.log("consegui o valor do nomeFantasia " + $(this).closest("tr").find(".nomeFantasia").text());
		console.log("consegui o valor do razaoResponsavel " + $(this).closest("tr").find(".razaoResponsavel").text());
		console.log("consegui o valor do email " + $(this).closest("tr").find(".email").text());
		console.log("consegui o valor do telefone " + $(this).closest("tr").find(".telefone").text());
	
})
	
