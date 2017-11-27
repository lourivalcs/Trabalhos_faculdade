<?php
    require_once "../sistema/dao/usuarioDao.php";
    require_once "../sistema/sessao/sessao.php";

    if( $_SERVER['REQUEST_METHOD'] !== "POST" ){
        echo "Método de requisição não aceito.";
    }else{
        $idUsuario = $_SESSION['usuario'][0]['idUsuario'];
        if($idUsuario > 0){
            deletarUsuario($idUsuario);
            logout();
            header("Location: /trabalhogb/index.php");
        }
    }
?>