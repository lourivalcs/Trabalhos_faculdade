<html>
<body>
    <?php
        $texto = 'string BlablablaA';
        $textMin = mb_strtolower($texto);

        if($texto == $textMin)
            echo 'string toda minúscula';
        else
            echo 'string não é toda minúscula';
    ?>
</body>
</html>