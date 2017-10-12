<html>
<body>
    <?php
        $txt = 'teste';
        reverteString($txt);

        function reverteString($texto){
            $txt2 = strrev($texto);
            if(strcasecmp($txt2, $texto) == 0)
                echo 'A palavra ' .$texto .' é um palíndromo';
            else
                echo 'A palavra ' .$texto .' não é um palíndromo';
        }
    ?>
</body>
</html>