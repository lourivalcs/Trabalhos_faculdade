<?php
    require_once "acessoBanco.php";

    function inserirUsuario($nome, $login, $senha, $idtipousuario){
        $stringSQL = "INSERT INTO usuario (nome,login, senha, idTipoUsuario) VALUES (?,?,?,?)";
        $acesso = acessarBanco()->prepare($stringSQL)->execute(array($nome,$login,$senha,$idtipousuario));
        $acesso = null;
    }

    function alterarUsuario($id, $nome, $login, $senha, $idtipousuario){
        $stringSQL = "UPDATE usuario SET nome = ?, login = ?, senha = ?, idTipoUsuario = ? WHERE idUsuario = ?";
        $acesso = acessarBanco()->prepare($stringSQL)->execute(array($nome,$login, $senha, $idtipousuario, $id));
        $acesso = null;
    }

    function buscarUsuario($id){
        $stringSQL = "SELECT * FROM usuario WHERE idUsuario = " .$id;
        $acesso = acessarBanco();
        $dados = $acesso->query($stringSQL)->fetchAll(PDO::FETCH_NUM);
        $acesso = null;
        return $dados;
    }

    function buscarUsuarioParaLogin($login, $senha){
        $stringSQL = 'SELECT * FROM usuario WHERE login = :pLogin and senha = :pSenha LIMIT 1';
        $acesso = acessarBanco();
        $stmt = $acesso->prepare($stringSQL);
        $stmt->bindValue(':pLogin', $login);
        $stmt->bindValue(':pSenha', $senha);

        $stmt->execute();
        $dados = $stmt->fetchAll(PDO::FETCH_ASSOC);        
        $acesso = null;
        return $dados;
    }
    
    function deletarUsuario($id){
        $stringSQL = "DELETE FROM usuario WHERE idUsuario = ?";
        $acesso = acessarBanco()->prepare($stringSQL)->execute(array($id));
        $acesso = null;
    }

    function BuscarTodosUsuarios(){
        $stringSQL = "SELECT * FROM usuario";
        $acesso = acessarBanco();
        $dados = $acesso->query($stringSQL)->fetchAll(PDO::FETCH_NUM);
        $acesso = null;
        return $dados;
    }

    function BuscarTodosUsuariosClientes(){
        $stringSQL = "SELECT * FROM usuario WHERE idTipoUsuario = 1";
        $acesso = acessarBanco();
        $dados = $acesso->query($stringSQL)->fetchAll(PDO::FETCH_NUM);
        $acesso = null;
        return $dados;
    }

    function gravarLog($dados){
        $arquivo = fopen("arquivo.log",'a+');
        $texto = "\n" .print_r($dados, true);
        fwrite($arquivo, $texto);
        fclose($arquivo);
    }
?>