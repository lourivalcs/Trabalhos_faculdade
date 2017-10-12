<html>
<body>
    <?php
        $texto = '082307';
        $texto = str_split($texto, 2);
        $texto = implode(':', $texto);
        echo $texto;
    ?>
</body>
</html>