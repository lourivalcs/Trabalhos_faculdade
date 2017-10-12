<html>
<body>
    <?php
        $color = array('verde', 'branco', 'vermelho');
        
        foreach($color as $var){
            echo $var .',';
        }

        sort($color);
        echo '<ul>';
        foreach($color as $var){
            echo '<li>' .$var .'</li>';
        }
        echo '</ul>';
    ?>
</body>
</html>