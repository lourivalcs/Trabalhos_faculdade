<html>
<body>
    <?php
        $txt = "a raposa marrom rápida salta sobre o cão preguiçoso";
        $primeiraOcorrencia = strpos($txt, 'a');
        $txt = substr($txt, 1,$primeiraOcorrencia) .'aquela'.substr($txt,1, strlen($txt));
        echo $txt;
    ?>
</body>
</html>