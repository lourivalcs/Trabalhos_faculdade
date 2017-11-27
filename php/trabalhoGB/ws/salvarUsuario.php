<?php
    require_once "../sistema/dao/usuarioDao.php";
    require_once "../sistema/sessao/sessao.php";

    if( $_SERVER['REQUEST_METHOD'] !== "POST" ){
        echo "Método de requisição não aceito.";
    }else{

        $idUsuario = $_POST['idUsuario'];
        $txtNome = $_POST['nome'];
        $txtLogin = $_POST['login'];
        $txtSenha = $_POST['senha'];
        $idTipoUsuario = $_POST['idTipoUsuario'];    
        
        if($txtNome !== "" && $txtLogin !== "" && $txtSenha !== "" && $idTipoUsuario !== ""){
            if($idUsuario == 0){
                inserirUsuario($txtNome, $txtLogin, $txtSenha, $idTipoUsuario);
            }
            else{
                alterarUsuario($idUsuario, $txtNome, $txtLogin, $txtSenha, $idTipoUsuario);
                atualizarSessao($txtNome, $txtLogin, $txtSenha, $idTipoUsuario);
            }
        }
        else
            echo "Campos não preenchidos corretamente." ;
    }
?>