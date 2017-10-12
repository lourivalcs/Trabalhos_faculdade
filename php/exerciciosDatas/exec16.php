<html>
<body>
    <?php
        $data1 = new DateTime('2011-01-01');
        $data1->sub(new DateInterval("P40D"));
        echo $data1->format('Y-m-d') .'<br>';
        $data1 = new DateTime('2011-01-01');
        $data1->add(new DateInterval("P40D"));
        echo $data1->format('Y-m-d');
    ?>
</body>
</html>