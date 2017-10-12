<html>
<body>
    <form method="POST">
        <label>
            Data de aniversario
            <input type="date" name="dataAniversario">
        </label>
        <button type="submit">Calcular</button>
    </form>

    <?php
        if($_SERVER['REQUEST_METHOD']=='POST'){
            $dataAtual = new DateTime();
            $dataAniversario = $_POST['dataAniversario'];
            $data = explode('-',$dataAniversario);
            $data[0] = date("Y");
            $data = implode('-', $data);
            
            $dataAniversario = new DateTime($data);

            if($dataAtual > $dataAniversario)
                $dataAniversario->add(new DateInterval("P1Y"));

            echo 'QTD dias para o próximo aniversário: ' .$dataAniversario->diff($dataAtual)->days;
        }
    ?>
</body>
</html>