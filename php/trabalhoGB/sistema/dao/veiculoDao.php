<?php
    require_once "acessoBanco.php";

    function inserirVeiculo($idMarca, $placa, $valorAluguel){
        $stringSQL = "INSERT INTO automovel (idMarca, placa, valorAluguel) VALUES (?,?,?)";
        $acesso = acessarBanco()->prepare($stringSQL)->execute(array($idMarca, $placa, $valorAluguel));
        $acesso = null;
    }

    function BuscarTodosVeiculos(){
        $stringSQL = "SELECT * FROM automovel";
        $acesso = acessarBanco();
        $dados = $acesso->query($stringSQL)->fetchAll(PDO::FETCH_NUM);
        $acesso = null;
        return $dados;
    }

    function buscarVeiculo($idAutomovel){
        $stringSQL = 'SELECT * FROM automovel WHERE idAutomovel = :idAutomovel LIMIT 1';
        $acesso = acessarBanco();
        $stmt = $acesso->prepare($stringSQL);
        $stmt->bindValue(':idAutomovel', $idAutomovel);
        $stmt->execute();
        $dados = $stmt->fetchAll(PDO::FETCH_ASSOC);        
        $acesso = null;
        return $dados;
    }

    function alterarVeiculo($idAutomovel, $idMarca, $placa, $valorAluguel){
        $stringSQL = "UPDATE automovel SET idMarca = ?, placa = ?, valorAluguel = ? WHERE idAutomovel = ?";
        $acesso = acessarBanco()->prepare($stringSQL)->execute(array($idMarca, $placa, $valorAluguel, $idAutomovel));
        $acesso = null;
    }

    function deletarVeiculo($idAutomovel){
        $stringSQL = 'DELETE FROM automovel WHERE idAutomovel = ? ';
        $acesso = acessarBanco()->prepare($stringSQL)->execute(array($idAutomovel));
        $acesso = null;
    }

    function buscarVeiculosDisponiveis(){
        $stringSQL = 'SELECT a.* from automovel a left join locacao l on l.idAutomovel = a.idAutomovel
                      WHERE (l.DataAlugado is null) or (l.DataAlugado is not null and l.DataDevolucao is not null)';

        $acesso = acessarBanco();
        $dados = $acesso->query($stringSQL)->fetchAll(PDO::FETCH_NUM);
        $acesso = null;
        return $dados;
    }
?>