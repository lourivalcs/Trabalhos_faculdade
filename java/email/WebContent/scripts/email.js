function populaModal(idEmail, tipoEmail, enviarPara, assunto, texto){
	$('#modalEmail').on('show.bs.modal', function (event) {
	  var modal = $(this);
	  $("#IDemailForm").val(idEmail);
	  $('#modalTitle').text(tipoEmail);
	  modal.find('.modal-body #enviar-para').val(enviarPara);
	  modal.find('.modal-body #txt-assunto').val(assunto);
	  modal.find('.modal-body #tx-texto').val(texto);
	});
}

function buscaEmail(idEmail, tipoEmail){
	var assunto = $('.assunto'+idEmail).text();
	var texto = $('.texto'+idEmail).text();
	
	if(idEmail == 0)
		populaModal(idEmail, tipoEmail,"","","");
	else{
		populaModal(idEmail, tipoEmail,"", assunto, texto);
	}
}


function responder(idEmail){
	buscaEmail(idEmail, "Responder para todos");
}

function encaminhar(idEmail){
	buscaEmail(idEmail, "Encaminhar");
}

function novoEmail(){
	limparSelect2();
	buscaEmail(0,'Novo e-mail');
}

$(document).ready(function() {
	$('#enviarParaSelect').select2();
});

function limparSelect2(){
	$('#enviarParaSelect > option').prop("selected", false);
	$("li.select2-selection__choice").remove();
}

function remover(idEmail){
	console.log(idEmail);
	$("#idEmailRemocao").val(idEmail);
}