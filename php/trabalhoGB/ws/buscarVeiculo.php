<?php
    require_once "../sistema/dao/veiculoDao.php";
    require_once "../sistema/sessao/sessao.php";

    if(!sessaoUsuarioAtiva()){
        header("Location: /trabalhogb/index.php");
    }else{

        $idAutomovel = $_POST['idAutomovel'];

        if($idAutomovel !== 0){
            echo json_encode(buscarVeiculo($idAutomovel));
        }else{
            echo json_encode(BuscarTodosVeiculos());
        }
    }
?>