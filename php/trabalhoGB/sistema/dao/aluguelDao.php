<?php
    require_once "acessoBanco.php";

    function inserirAluguel($idAutomovel, $idUsuario){
        $stringSQL = "INSERT INTO locacao (idAutomovel, idUsuario, DataAlugado) VALUES (:idAutomovel, :idUsuario, (select now()))";
        $acesso = acessarBanco();
        $stmt = $acesso->prepare($stringSQL);

        $stmt->bindParam(':idAutomovel', $idAutomovel, PDO::PARAM_INT);
        $stmt->bindParam(':idUsuario', $idUsuario, PDO::PARAM_INT);
        return $stmt->execute();  
        $acesso = null;
    }

    function buscarAlugueis(){
        $stringSQL = "SELECT l.idLocacao, l.idAutomovel, l.idUsuario, u.nome, a.placa FROM locacao l join usuario u on u.idUsuario = l.idUsuario join automovel a on a.idAutomovel = l.idAutomovel order by 1 desc";
        $acesso = acessarBanco();
        $dados = $acesso->query($stringSQL)->fetchAll(PDO::FETCH_NUM);
        $acesso = null;
        return $dados;
    }

    function buscarAluguel($idAluguel){
        $stringSQL = 'SELECT * FROM locacao WHERE idlocacao = :idAluguel LIMIT 1';
        $acesso = acessarBanco();
        $stmt = $acesso->prepare($stringSQL);
        $stmt->bindValue(':idAluguel', $idAluguel);
        $stmt->execute();
        $dados = $stmt->fetchAll(PDO::FETCH_ASSOC);        
        $acesso = null;
        return $dados;
    }

    function alterarAluguel($idAluguel, $idAutomovel, $idUsuario,$devolver){
        $stringSQL = "UPDATE locacao SET idAutomovel = ?, idUsuario = ?";
        
        if($devolver == 'true'){
            $stringSQL .= ", DataDevolucao = (select now())";
        }
        
        $stringSQL .= " WHERE idLocacao = ?";
        $acesso = acessarBanco()->prepare($stringSQL)->execute(array($idAutomovel, $idUsuario,$idAluguel));
        $acesso = null;
    }

    function deletarAluguel($idAluguel){
        $stringSQL = 'DELETE FROM locacao WHERE idlocacao = :idAluguel';
        $acesso = acessarBanco();
        $stmt = $acesso->prepare($stringSQL);
        $stmt->bindValue(':idAluguel', $idAluguel);
        $stmt->execute();
        $acesso = null;
    }
?>