<template>
    <div class="container-fluid acesso">
        <div class="row">
            <div class="col-md-5"></div>
            <div class="col-md-2">
                <div class="form-group">
                    <div class="row">
                        <input type="text" class="form-control" placeholder="Insira seu nome" v-model="nomeJogador"/>
                    </div>
                </div>
                <div class="row">
                    <button type="button" class="btn btn-success" v-on:click="enviar">Entrar</button>
                </div>
            </div>
            <div class="col-md-5"></div>
        </div>
    </div>
</template>

<script>
import SockJS from "sockjs-client";
import Stomp from "webstomp-client";

export default {
    name:"Acesso",
    data() {
        return {
            nomeJogador : null,
            stompClient : null
        };
  },
  methods: {
      enviar : function() {
          if(this.stompClient && this.stompClient.connected){
              this.enviarJogador();  
          }
      },
    connect : function()  {
        this.stompClient = Stomp.over(new SockJS("http://localhost:8080/WSocket"));
        this.stompClient.connect();
    },
    enviarJogador : function() {
        var self = this;
        this.$store.commit('addConexaoSocket', this.stompClient);
        this.axios.post('http://localhost:8080/adicionarJogador', { nome: this.nomeJogador })
            .then((response)=>{
                self.$store.commit('addIdPartida', response.data.idPartida);
                self.$store.commit('addIdJogador', response.data.idJogador);
                self.$store.commit('addNomeJogador', this.nomeJogador);
                self.$router.push({name:"Jogo"});
            });
    }
  },
  beforeMount(){
    this.connect()
  }
};
</script>


<style>
    .acesso{
        margin-top: 10%;
    }
</style>
