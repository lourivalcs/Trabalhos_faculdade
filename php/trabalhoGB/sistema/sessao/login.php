<?php
    require_once "sessao.php";
    require_once "../dao/usuarioDao.php";

    if( $_SERVER['REQUEST_METHOD'] !== "POST" ){
        echo "Método de requisição não aceito.";
    }else{

        $txtLogin = $_POST['login'];
        $txtSenha = $_POST['senha'];
        
        if($txtLogin !== "" && $txtSenha !== ""){
            $usuario = buscarUsuarioParaLogin($txtLogin, $txtSenha);
            if(count($usuario) > 0){
                login($usuario);
                header("Location: /trabalhogb/sistema/locadora.php");
            }else{
                header("Location: /trabalhogb/index.php");
            }
        }else{
            header("Location: /trabalhogb/index.php");
        }
    }
?>