<html>
<body>
    <?php
        $data1 = new DateTime('2017-09-02');
        $diaSemana = $data1->format('w');
        if($diaSemana == 0 || $diaSemana == 6)
            echo 'Fim de semana';
        else
            echo 'Dia útil';
    ?>
</body>
</html>