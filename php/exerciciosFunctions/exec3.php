<html>
<body>
    <?php
        $array = array ('a','b','c','d','a','20', '2','7','8','5','100');
        
        classificaArray($array);

        for ($i = 0; $i < count($array); $i++) {
            echo $array[$i] .'<br>';
        }

        function classificaArray(&$arr){
           sort($arr);
        }
    ?>
</body>
</html>