<html>
<body>
<?php
    $data1 = new DateTime('10-10-2010');
    $data2 = new DateTime('15-10-2010');
    echo $data1->diff($data2)->days;
?>
</body>
</html>