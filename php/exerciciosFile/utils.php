<?php
    function sobrescreverArquivo($caminho, $texto){
        $arquivo = fopen($caminho,'w+');
        fwrite($arquivo, $texto);
        fclose($arquivo);
    }

    function gravarEmArquivo($caminho, $texto){
        $arquivo = fopen($caminho,'a+');
        fwrite($arquivo, $texto);
        fclose($arquivo);
    }

    function abrirArquivoEmModoLeitura($caminho){
        $arquivo = fopen($caminho,'r');
        echo file_get_contents($caminho, true);
        fclose($arquivo);
    }

    function excluirArquivo($caminho){
        unlink($caminho);
    }

    function criarDiretorio($caminho){
        mkdir($caminho);
    }

    function excluirDiretorio($caminho){
        rmdir($caminho);
    }

    function moverDiretorio($caminhoAntigo, $caminhoAtual){
        rename($caminhoAntigo, $caminhoAtual);
    }

    function renomearArquivo($caminho, $nomeNovo){
         $va = strripos($caminho,'/');
         $caminhoNovo = substr($texto,0, $va);
         $caminhoNovo.$nomeNovo;
        rename($caminho, $caminhoNovo);
    }
?>