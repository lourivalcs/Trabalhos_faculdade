<html>
<body>
<?php
    $data = '30-02-2010';
    $data = explode('-', $data);
    $valida = checkdate($data[0], $data[1], $data[2]);
    echo 'Data válida: '; 
    echo $valida ? 'Sim' : 'Não';
?>
</body>
</html>