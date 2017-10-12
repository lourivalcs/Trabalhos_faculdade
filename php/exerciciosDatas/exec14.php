<html>
<body>
    <?php
        $fuso = new DateTimeZone('Australia/Melbourne');
        $data1 = new DateTime();
        $data1->setTimezone($fuso);        
        echo $data1->format('d/m/Y h:m:s');
    ?>
</body>
</html>