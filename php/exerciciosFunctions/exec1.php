<html>
<body>
    <?php
        $numero = (int)4;

        if($numero > 0)
            echo 'O fatorial de ' .$numero .' é: ' .calculoFatorial($numero);

        function calculoFatorial($num){
            $fat = $num;
            for ($i = $num-1; $i > 0; $i--) {
               $fat *= $i;
            }
            return $fat;
        }
    ?>
</body>
</html>