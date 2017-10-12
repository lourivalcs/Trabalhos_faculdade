<?php
    function criaArquivo($nomeArquivo, $caminho){
        echo $caminho .$nomeArquivo;
        fopen($caminho.$nomeArquivo.'.txt','w+');
    }
?>