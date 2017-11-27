<?php
    require_once "../sistema/dao/aluguelDao.php";
    require_once "../sistema/sessao/sessao.php";

    if(!sessaoUsuarioAtiva()){
        header("Location: /trabalhogb/index.php");
    }else{
        
        $acao = $_POST['acao'];
        $idAluguel = $_POST['idAluguel'];
        
        if($acao === "buscarPorID"){
            echo json_encode(buscarAluguel($idAluguel));
        }else{
            if($acao === "remover" && $idAluguel > 0){
                deletarAluguel($idAluguel);
            }else{
                $idUsuario = $_POST['idUsuario'];
                $idAutomovel = $_POST['idAutomovel'];
                if($acao === "inserir"){
                    inserirAluguel($idAutomovel, $idUsuario);
                 }else if($acao === "editar" && $idAluguel > 0){
                    $devolver = $_POST['devolver'];
                    alterarAluguel($idAluguel, $idAutomovel, $idUsuario, $devolver);
                 }             
            }
        }
    }
?>