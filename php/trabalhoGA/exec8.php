<html>
<body>
    <?php
        $caminhoArquivo = 'C:/xampp/htdocs/aulas/trabalhoGA/texto.txt';
        gravarEmArquivo($caminhoArquivo,'Trabalho de PHP');

        function gravarEmArquivo($caminho, $texto){
            $arquivo = fopen($caminho,'a+');
            fwrite($arquivo, $texto);
            fclose($arquivo);
        }
    ?>
</body>
</html>