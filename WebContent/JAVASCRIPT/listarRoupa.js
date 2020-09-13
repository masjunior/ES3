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
	let id = $(this).closest("tr").find(".txtRoupaId").val();
	let marca = $(this).closest("tr").find(".marca").text();
	let precoVenda = $(this).closest("tr").find(".precoVenda").text();
	let quantidadeDisponivel= $(this).closest("tr").find(".quantidadeDisponivel").text();
	let tamanho = $(this).closest("tr").find(".tamanho").text();
	let cor = $(this).closest("tr").find(".cor").text();
	let lote = $(this).closest("tr").find(".lote").text();

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
				url: "http://localhost:8080/es3_2020/ProdutoController",
				async: true,
				sucess: function(data){

					Swal.fire({
						title: "Exclusão realizada com sucesso",

					})
					botao.closest("tr").fadeOut(1500);

				},
				data :{txtRoupaId : $(this).closest("tr").find(".txtRoupaId").val(), operacao: "EXCLUIR"},				
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
