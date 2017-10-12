<html>
<body>
    <?php
        $texto = "rayy@example.com";
        $va = strrpos($texto,'@');
        echo substr($texto,0, $va);
    ?>
</body>
</html>