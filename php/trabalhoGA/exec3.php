<html>
<body>
    <?php
        $matriz = retornaMatrizQuadrada(6);
        exibirMatriz($matriz);
        echo "Soma Diagonal Principal:" .somaDiagonalPrincilalMatrizQuadrada($matriz);
        function retornaMatrizQuadrada($n){
            $Matriz = array();
            for($i = 0; $i < $n; $i++){
                $linha = array();
                for($j = 0; $j < $n; $j++){
                    $linha[] = $j;
                }
                $Matriz[] = $linha;
            }
            return $Matriz;
        }
        function exibirMatriz($matriz){
            $tamanho = count($matriz);
            for($i = 0; $i < $tamanho; $i++){
                $linha = $matriz[$i];
                foreach ($linha as $k => $v) {
                    echo $v ."    ";
                }
                echo "<br>";
            }
        }
        function somaDiagonalPrincilalMatrizQuadrada($matriz){
            $tamanho = count($matriz);
            $somaDiagonal = 0;
            for($i = 0; $i < $tamanho; $i++){
                for($j = 0; $j < $tamanho; $j++){
                    if($i == $j)
                        $somaDiagonal += $j;
                }
            }
            return $somaDiagonal;
        }
    ?>
</body>
</html>