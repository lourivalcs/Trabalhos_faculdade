<html>
<body>
    <?php
        $txt = 'exercicio de reverter string';
        
        echo reverteString($txt);

        function reverteString($texto){
            return strrev($texto);
        }
    ?>
</body>
</html>