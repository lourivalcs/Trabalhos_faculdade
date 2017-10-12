<html>
<body>
    <?php
        $data1 = new DateTime('1981-11-04');
        $data2 = new DateTime('2013-09-04');
        $intervalo = $data1->diff($data2);
        echo $intervalo->format('%y anos, %m meses, %d dias');
    ?>
</body>
</html>