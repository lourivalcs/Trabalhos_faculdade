<?php
    class Usuario{
        private $idUsuario;
        private $idTipoUsuario;
        private $nome;
        private $login;        
        private $senha;
        
        public function getIdTipoUsuario(){
            return $this->idTipoUsuario;
        }

        public function setIdTipoUsuario($idTipoUsuario){
           $this->idTipoUsuario = $idTipoUsuario;
        }

        public function getIdUsuario(){
            return $this->idUsuario;
        }

        public function setIdUsuario($idUsuario){
           $this->idUsuario = $idUsuario;
        }

        public function getNome(){
            return $this->nome;
        }

        public function setNome($nome) {
            $this->nome = $nome;
        }
        public function getLogin() {
            return $this->login;
        }
        public function setLogin($login) {
            $this->login = $login;
        }
        public function getSenha() {
            return $this->senha;
        }
        public function setSenha($senha) {
            $this->senha = $senha;
        }
    }

?>