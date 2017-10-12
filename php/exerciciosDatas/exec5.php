<html>
<body>
    <?php
        $data = '2012-09-12';
        $data = new DateTime($data);
        $data = $data->format('d-m-Y');
        echo $data .'<br>';
    ?>
</body>
</html>