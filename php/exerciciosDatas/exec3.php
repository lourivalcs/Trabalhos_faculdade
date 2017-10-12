<html>
<body>
    <?php
        $data = new DateTime();
        echo $data->format('d/m/Y') .'<br>';
        echo $data->format('d.m.Y') .'<br>';
        echo $data->format('d-m-Y');
    ?>
</body>
</html>