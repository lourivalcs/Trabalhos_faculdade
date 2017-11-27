<?php
    require_once "acessoBanco.php";

    function inserirMarca($nome){
        $stringSQL = "INSERT INTO marca (nome) VALUES (?)";
        $acesso = acessarBanco()->prepare($stringSQL)->execute(array($nome));
        $acesso = null;
    }

    function BuscarTodasMarcas(){
        $stringSQL = "SELECT * FROM marca";
        $acesso = acessarBanco();
        $dados = $acesso->query($stringSQL)->fetchAll(PDO::FETCH_NUM);
        $acesso = null;
        return $dados;
    }

    function alterarMarca($idMarca, $nome){
        $stringSQL = "UPDATE marca SET nome = ? WHERE idMarca = ?";
        $acesso = acessarBanco()->prepare($stringSQL)->execute(array($nome, $idMarca));
        $acesso = null;
    }

    function buscarMarca($idMarca){
        $stringSQL = 'SELECT * FROM marca WHERE idMarca = :idMarca LIMIT 1';
        $acesso = acessarBanco();
        $stmt = $acesso->prepare($stringSQL);
        $stmt->bindValue(':idMarca', $idMarca);
        $stmt->execute();
        $dados = $stmt->fetchAll(PDO::FETCH_ASSOC);        
        $acesso = null;
        return $dados;
    }

    function deletarMarca($idMarca){
        $stringSQL = 'DELETE FROM marca WHERE idMarca = ? ';
        $acesso = acessarBanco()->prepare($stringSQL)->execute(array($idMarca));
        $acesso = null;
    }
?>