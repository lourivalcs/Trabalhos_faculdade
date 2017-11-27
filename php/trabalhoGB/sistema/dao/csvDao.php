<?php
    require_once "acessoBanco.php";
    $csv = $_POST['selectCSV'];

    if($csv !== 0){
        $stringSQL = "";
        if($csv == 1){
            $stringSQL = 'SELECT * FROM locacao';
        }else if($csv == 2){
            $stringSQL = 'SELECT * FROM automovel';                
        }else if($csv == 3){
            $stringSQL = 'SELECT * FROM marca';                
        }else if($csv == 4){
            $stringSQL = 'SELECT * FROM usuario';                
        }

        header( 'Content-type: application/csv' );   
        header( 'Content-Disposition: attachment; filename=file.csv' );   
        header( 'Content-Transfer-Encoding: binary' );
        header( 'Pragma: no-cache');

        $results = acessarBanco()->query($stringSQL)->fetchAll(PDO::FETCH_NUM);

        $out = fopen( 'php://output', 'w' );
        foreach ( $results as $result ) 
        {
            fputcsv( $out, $result );
        }
        fclose( $out );
        $acesso = null;
    }
?>