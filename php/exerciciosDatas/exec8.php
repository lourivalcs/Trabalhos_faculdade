<html>
<body>
<?php
    $data1 = new DateTime('10-10-2010');
    echo 'Inicio mês ' .$data1->format('01/m/Y') .'<br>';
    echo 'Fim mês ' .$data1->format('t/m/Y');
?>
</body>
</html>