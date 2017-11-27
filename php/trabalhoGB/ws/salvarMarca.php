<?php
    require_once "../sistema/dao/marcaDao.php";
    require_once "../sistema/sessao/sessao.php";

    if(!sessaoUsuarioAtiva()){
        header("Location: /trabalhogb/index.php");
    }else{

        $idMarca = $_POST['marcaEdicao'];
        $nome = "";
        $remover = "";

        if(isset($_POST['remover'])){
            $remover = $_POST['remover'];
        }

        if(isset($_POST['txtMarca'])){
            $nome = $_POST['txtMarca'];
        }

        if($remover === "remover" && $idMarca > 0){
            echo "remover";
            deletarMarca($idMarca);
        }else{
            if($idMarca !== "" && $nome !== ""){
                if($idMarca == 0){
                    inserirMarca($nome);
                }
                else{
                    alterarMarca($idMarca, $nome);
                }
            }else{
                echo "Campos preenchidos incorretamente";
            }
        }
        
    }
?>