<html>
<body>
    <?php
        $texto = "www.example.com/public_html/index.php";
        $va = strrpos($texto,'/')+1;
        echo substr($texto, $va);
    ?>
</body>
</html>