<html>
<body>
    <?php
        $data1 = new DateTime();
        $data1->sub(new DateInterval("P1D"));
        echo $data1->format('d/m/Y');
    ?>
</body>
</html>