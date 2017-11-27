<?php
    require_once "../sistema/dao/veiculoDao.php";
    require_once "../sistema/sessao/sessao.php";

    if(!sessaoUsuarioAtiva()){
        header("Location: /trabalhogb/index.php");
    }else{

        if(isset($_POST['remover'])){
            $idAutomovel = $_POST['idAutomovel'];
            $remover = $_POST['remover'];
            if($remover === "remover" &&  $idAutomovel > 0)
                deletarVeiculo($idAutomovel);
        }else{
            $idAutomovel = $_POST['idAutomovel'];
            $idMarca = $_POST['idMarca'];
            $placa = $_POST['placa'];
            $valorAluguel = $_POST['valorAluguel'];
            
            if($idAutomovel !== "" && $idMarca !== "" && $placa !== "" && $valorAluguel !== ""){
                if($idAutomovel == 0){
                    inserirVeiculo($idMarca, $placa, $valorAluguel);
                }
                else{
                    alterarVeiculo($idAutomovel, $idMarca, $placa, $valorAluguel);
                }
            }else{
                echo "Campos preenchidos incorretamente";
            }
        }
    }
?>