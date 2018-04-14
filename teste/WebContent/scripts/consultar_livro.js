$(document).ready(function () {
	$('#formConsulta').submit(function (e){
		
		e.preventDefault();
		
		$.get({
			url: 'consultar_livro',
			data: $('#formConsulta').serialize(),
			success: function (data) {
				processarResposta(data);
			}
		});
	});
});


function processarResposta (data) {
	
}