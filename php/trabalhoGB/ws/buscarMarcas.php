<?php
    require_once "../sistema/dao/marcaDao.php";
    require_once "../sistema/sessao/sessao.php";

    if(!sessaoUsuarioAtiva()){
        header("Location: /trabalhogb/index.php");
    }else{

        $idMarca = $_POST['marcaEdicao'];

        if($idMarca !== 0){
            echo json_encode(buscarMarca($idMarca));
        }else{
            echo json_encode(BuscarTodasMarcas());
        }
    }
?>