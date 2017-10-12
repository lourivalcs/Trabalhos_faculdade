<html>
<body>
    <?php
        $string1= 'futebol';
        $string2= 'footboll';
        $string3 = strpbrk($string1, $string2);
        $string4 = strpos($string1, $string3);
        $string5 = substr($string1, $string4-1,$string4+1);
        var_dump($string1);
        echo '<br>';
        var_dump($string2);
        echo '<br>';
        var_dump($string3);
        echo '<br>';
        var_dump($string4);
        echo '<br>';
        var_dump($string5);
        echo '<br>';
        echo 'primeira diferença entre duas cordas na posição '. $string4 
             .': ' .$string5 .'vs o';
    ?>
</body>
</html>