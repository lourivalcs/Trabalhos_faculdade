<?php
    function acessarBanco(){
        $acessoBanco = null;
       // try{
            $usuario = 'root';
            $senha = '';
            $stringConexao = "mysql:host=localhost;dbname=locadoraautomoveis";
            $acessoBanco = new PDO($stringConexao, $usuario, $senha);
        //}catch(PDOException $ex){
           // echo "Erro de conexão com o banco de dados <br>" .$ex->getMessage() ."<br>"; 
         /*   exit;
        }*/
        return $acessoBanco;
    }
?>