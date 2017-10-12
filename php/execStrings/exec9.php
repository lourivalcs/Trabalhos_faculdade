<html>
<body>
    <?php
        $txt = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcefghijklmnopqrstuvwxyz";
        $txt = str_split($txt);
        shuffle($txt);
        $txt = implode($txt);
        echo substr($txt,0,8);
    ?>
</body>
</html>