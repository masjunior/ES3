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
	let nome = $(this).closest("tr").find(".nome").text();
	let cpf = $(this).closest("tr").find(".cpf").text();
	let email= $(this).closest("tr").find(".email").text();
	let senha = $(this).closest("tr").find(".senha").text();
	let nivelAcesso = $(this).closest("tr").find(".nivelAcesso").text();
	

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
				url: "http://localhost:8080/ES3/FuncionarioController",
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
