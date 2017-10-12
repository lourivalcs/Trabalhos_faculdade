<html>
<body>
    <?php
        $data = '12-05-2014';
        $data = new DateTime($data);
        echo $data->getTimestamp();
    ?>
</body>
</html>