<html>
<body>
    <?php
        $ceu = array ("Itália" => "Roma",
                      "Luxemburgo" => "Luxemburgo",
                      "Bélgica" => "Bruxelas", 
                      "Dinamarca" => "Copenhague", 
                      "Finlândia" => "Helsínquia", 
                      "França" => "Paris", 
                      "Eslováquia" => "Bratislava", 
                      "Eslovênia" => "Liubliana", 
                      "Alemanha" => "Berlim", 
                      "Grécia" => "Atenas", 
                      "Irlanda" => "Dublin", 
                      "Holanda" => "Amsterdam", 
                      "Portugal" => "Lisboa", 
                      "Espanha" => "Madrid", 
                      "Suécia" => "Estocolmo", 
                      "Reino Unido" => "Londres", 
                      "Chipre" => "Nicosia", 
                      "Lituânia" => "Vilnius", 
                      "República Checa" => "Praga", 
                      "Estónia" => "Tallin", 
                      "Hungria" => "Budapeste", 
                      "Letónia" => "Riga", 
                      "Malta" => "Valetta", 
                      "Áustria" => "Viena", 
                      "Polónia" => "Varsóvia");

        asort($ceu);
        foreach($ceu as $key => $val){
            echo 'A capital de '.$key .' é ' .$val .'<br>';
        }
    ?>
</body>
</html>