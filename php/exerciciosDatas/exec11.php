<html>
<body>
    <?php
        $data1 = new DateTime('2010-11-04 09:00:01');
        $data2 = new DateTime('2013-09-05 10:07:06');
        $intervalo = $data1->diff($data2);
        echo $intervalo->format('%y anos, %m meses, %d dias, %h horas, %i minutos, %s segundos');
    ?>
</body>
</html>