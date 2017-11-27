<?php
session_start();

function sessaoUsuarioAtiva() {
    return isset($_SESSION["usuario"]);
}

function usuarioLogado() {
    return $_SESSION['usuario'];
}

function login($usuario) {
    $_SESSION["usuario"] = $usuario;
}

function logout() {
    session_destroy();
}

function atualizarSessao($txtNome, $txtLogin, $txtSenha, $idTipoUsuario){
    $_SESSION['usuario'][0]['nome'] = $txtNome;
    $_SESSION['usuario'][0]['login'] = $txtLogin;
    $_SESSION['usuario'][0]['senha'] = $txtSenha;
    $_SESSION['usuario'][0]['idTipoUsuario'] = $idTipoUsuario;    
}
?>