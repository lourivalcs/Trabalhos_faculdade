function cadastraNovoUsuario(pagina){
    var idUsuario = $('#idUsuarioEdicao').val();
    var nome = $('#newUser-nome').val();
    var login = $('#newUser-login').val();
    var senha = $('#newUser-senha').val();
    var tpUsuario = $('#newUser-tpUsuario').val();

    var url = "";
    var url1 = "";
    var url2 = "";
    
    if(pagina == 'index'){
        url = 'ws/salvarUsuario.php';
        url1 = 'sistema/sessao/login.php';
        url2 = 'sistema/locadora.php';
    }else{
        url = '../ws/salvarUsuario.php';
        url1 = 'sessao/login.php';
        url2 = 'locadora.php';
    }
    
    $.ajax({
        type: "POST",
        data: {
                idUsuario : idUsuario,
                nome : nome,
                login : login,
                senha : senha,
                idTipoUsuario : tpUsuario
            },
        url: url,
        success: function(resposta){
            console.log(resposta);
        }  
      });

      $.ajax({
        type: "POST",
        data: {
                login : login,
                senha : senha,
            },
        url: url1,
        success: function(resposta){
            window.location.href = url2;
        }  
      });
}

$(document).ready(function() {
	$('#veiculosCadastrados').select2();
});

$(document).ready(function() {
	$('#marcasCadastradas').select2();
});

$(document).ready(function() {
	$('#veiculosAluguel').select2();
});

$(document).ready(function() {
	$('#clientesAluguel').select2();
});

$(document).ready(function() {
	$('#aluguelCadastrados').select2();
});

function cadastrarVeiculo(){
    var idAutomovel = $('#idAutomovel').val();
    var idMarca = $('#nomeMarca').val();
    var placa = $('#placa').val();
    var valorAluguel = $('#valorAluguel').val();

    $.ajax({
        type: "POST",
        data: {
            idAutomovel : idAutomovel,
            idMarca : idMarca,
            placa : placa,
            valorAluguel : valorAluguel
            },
        url: '../ws/salvarVeiculo.php',
        success: function(resposta){
            window.location.href = 'locadora.php';
        }  
      });
}

function habilitarBotoesCadastroVeiculo(habilitar){
    $('#idAutomovel').val('0');
    limparSelect2('veiculosCadastrados');
    $('#nomeMarca').attr("disabled", habilitar).val('');
    $('#placa').attr("disabled", habilitar).val('');
    $('#valorAluguel').attr("disabled", habilitar).val('');
    $('#cancelar').attr("disabled", habilitar);
    $('#salvar').attr("disabled", habilitar);
    $('#apagarVeiculo').attr("disabled", habilitar);
}

function habilitarBotoesCadastroMarca(habilitar){
    $('#marcaEdicao').val('0');
    limparSelect2('marcasCadastradas');
    $('#txtMarca').attr("disabled", habilitar).val('');
    $('#cancelarMarca').attr("disabled", habilitar);
    $('#salvarMarca').attr("disabled", habilitar);
    $('#apagarMarca').attr("disabled", habilitar);
}

function cadastrarMarca(){
    var marcaEdicao = $('#marcaEdicao').val();
    var txtMarca = $('#txtMarca').val();

    $.ajax({
        type: "POST",
        data: {
            marcaEdicao : marcaEdicao,
            txtMarca : txtMarca
            },
        url: '../ws/salvarMarca.php',
        success: function(resposta){
            window.location.href = 'locadora.php';
        }  
      });
}

function buscarMarcas(){
    var marcaEdicao = $('#marcasCadastradas').val();
    if(marcaEdicao > 0){
        $.ajax({
            type: "POST",
            data: {
                marcaEdicao : marcaEdicao
            },
            url: '../ws/buscarMarcas.php',
            success: function(resposta){
                habilitarBotoesCadastroMarca(false);
                var respJson= JSON.parse(resposta);
                $('#marcaEdicao').val(respJson[0]["idMarca"]);
                $('#txtMarca').val(respJson[0]["nome"]);
            }  
        });
    }
}

function buscarVeiculos(){
    var idAutomovel = $('#veiculosCadastrados').val();
    if(idAutomovel > 0){
        $.ajax({
            type: "POST",
            data: {
                idAutomovel : idAutomovel
            },
            url: '../ws/buscarVeiculo.php',
            success: function(resposta){
                habilitarBotoesCadastroVeiculo(false);
                var respJson= JSON.parse(resposta);
                $('#idAutomovel').val(respJson[0]["idAutomovel"]);            
                $('#nomeMarca').val(respJson[0]["idMarca"]);
                $('#placa').val(respJson[0]["placa"]);
                $('#valorAluguel').val(respJson[0]["valorAluguel"]);
            }  
        });
    }
}

function limparSelect2(idSelect){
	$('#'+idSelect).val('0').trigger('change');
}

function deletarMarca(){
    var marcaEdicao = $('#marcaEdicao').val();

    $.ajax({
        type: "POST",
        data: {
            marcaEdicao : marcaEdicao,
            remover : 'remover'
            },
        url: '../ws/salvarMarca.php',
        success: function(resposta){
            window.location.href = 'locadora.php';
        }  
      });
}

function deletarVeiculo(){
    var idAutomovel = $('#idAutomovel').val();
    $.ajax({
        type: "POST",
        data: {
            idAutomovel : idAutomovel,
            remover : 'remover'
            },
        url: '../ws/salvarVeiculo.php',
        success: function(resposta){
            window.location.href = 'locadora.php';
        }  
      });
}

function habilitarBotoesCadastroAluguel(habilitar){

    limparSelect2('clientesAluguel');
    limparSelect2('veiculosAluguel');
    limparSelect2('aluguelCadastrados');

    $('#idAluguelSelecionado').val('0');
    $('#dataAluguel').val('');
    $('#dataDevolucao').val('');
    $('#devolver').attr("disabled", habilitar).attr('checked',false);    
    $('#clientesAluguel').attr("disabled", habilitar);
    $('#veiculosAluguel').attr("disabled", habilitar);
    $('#cancelarAluguel').attr("disabled", habilitar);
    $('#salvarAluguel').attr("disabled", habilitar);
    $('#apagarAluguel').attr("disabled", habilitar);
}

function buscarAluguel(){
    var idAluguel = $('#aluguelCadastrados').val();
    if(idAluguel > 0){
        $.ajax({
            type: "POST",
            data: {
                idAluguel : idAluguel,
                acao : 'buscarPorID'
            },
            url: '../ws/aluguel.php',
            success: function(resposta){
                habilitarBotoesCadastroAluguel(false);
                var respJson= JSON.parse(resposta);
                $('#idAluguelSelecionado').val(respJson[0]["idLocacao"]);            
                $('#veiculosAluguel').val(respJson[0]["idAutomovel"]);
                $('#clientesAluguel').val(respJson[0]["idUsuario"]).trigger('change');
                $('#dataAluguel').val(respJson[0]["DataAlugado"]);
                $('#dataDevolucao').val(respJson[0]["DataDevolucao"]);
                if($('#dataDevolucao').val() != ''){
                    $('#devolver').attr("disabled", true).attr('checked',true);  
                }
            }  
        });
    }
}

function salvarAluguel(){
    var acao = "";
    var idAluguel = $('#idAluguelSelecionado').val();
    var idUsuario = $('#clientesAluguel').val();
    var idAutomovel = $('#veiculosAluguel').val();
    var devolver = $('#devolver').prop('checked');

    if(idAluguel > 0){
        acao = "editar";
    }else{
        acao = "inserir";
    }

    $.ajax({
        type: "POST",
        data: {
            idAluguel : idAluguel,
            acao : acao,
            idUsuario : idUsuario,
            idAutomovel : idAutomovel,
            devolver : devolver
        },
        url: '../ws/aluguel.php',
        success: function(resposta){
            window.location.href = 'locadora.php';
        }  
    });
}

function deletarAluguel(){
    var idAluguel = $('#idAluguelSelecionado').val();

    if(idAluguel > 0){
        var acao = "remover";
        
        $.ajax({
            type: "POST",
            data: {
                idAluguel : idAluguel,
                acao : acao
            },
            url: '../ws/aluguel.php',
            success: function(resposta){
                window.location.href = 'locadora.php';
            }  
        });
    }
}

function linksMenuLateral(opcao){
    $('#aluguel').hide();
    $('#veiculo').hide();
    $('#marca').hide();
    $('#csv').hide();
    habilitarBotoesCadastroAluguel(true);
    habilitarBotoesCadastroMarca(true);
    habilitarBotoesCadastroVeiculo(true);

    $('#'+opcao).show();
    
}

$(document).ready(function() {
    $('li').click(function() {
        $('li.active').removeClass("active");
        $(this).addClass("active"); 
    });
});

function deletarUsuario(){        
    $.ajax({
        type: "POST",
        url: '../ws/removerUsuario.php',
        success: function(resposta){
            window.location.href = 'locadora.php';
        }  
    });
}