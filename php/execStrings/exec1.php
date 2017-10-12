<html>
<body>
    <?php
        $texto = "A) transformar uma string em letras maiúsculas.";
        echo strtoupper($texto) .'<br>';
        echo strtolower($texto) .'<br>';

        $texto = 'C) faça a maiúscula e minúscula de uma string.';
        echo strtoupper($texto) .'<br>' .strtolower($texto) .'<br>';

        $texto = 'D) faça o primeiro caractere de uma string de todas as palavras maiúsculas.';
        echo ucwords($texto);
    ?>
</body>
</html>