/**
 * 
 */
$(".botao-remover").click(function(){
	event.preventDefault();

//	console.log($(this).closest("tr"));
//	$(this).closest("tr").children().each(function(){
//	console.log($(this).text());
//	});
	let botao = $(this);
	let id = $(this).closest("tr").find(".id").val();
	let razaoSocial = $(this).closest("tr").find(".razaoSocial").text();
	let cnpj = $(this).closest("tr").find(".cnpj").text();
	let nomeFantasia= $(this).closest("tr").find(".nomeFantasia").text();
	let razaoResponsavel = $(this).closest("tr").find(".razaoResponsavel").text();
	let email = $(this).closest("tr").find(".email").text();
	let telefone = $(this).closest("tr").find(".telefone").text();

	Swal.fire({
		title: "DELETAR?",
		text: "Após confirmar, não será possível retornar ",
		icon: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#d33',
		cancelButtonColor: '#3085d6',
		confirmButtonText: 'SIM!',
		cancelButtonText: 'NÃO!',
		dangerMode: true,
		closeOnClickOutside: true,
	}).then((result) => {
		if(result.value){
			$.ajax({
				type: "POST",
				url: "http://localhost:8080/es3_2020/FornecedorController",
				async: true,
				sucess: function(data){

					Swal.fire({
						title: "Exclusão realizada com sucesso",

					})
					botao.closest("tr").fadeOut(1500);

				},
				data :{txtId : $(this).closest("tr").find(".id").val(), operacao: "EXCLUIR"},				
			}).fail(function() {
				Swal.fire({
					title: "Algo deu errado",

				})
			}).done(function(){
				botao.closest("tr").fadeOut(1500);
				//botao.closest("tr").remove();
			});
		} else { 
			return
		}
	});
})
