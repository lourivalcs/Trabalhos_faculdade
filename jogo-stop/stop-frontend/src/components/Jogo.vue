<template>
    <div class="container-fluid">
        <div class="row">
            <div class="cols-md-12 infoJogo">
                <span class="label label-info">{{ this.nomeJogador }}</span>
                <span class="label label-info">Pontuação: {{ this.pontuacao }}</span>
                <span class="label label-info">Vitórias: {{ this.vitorias }}</span>
            </div>
        </div>
        <div class="row letraRodada">
            <span class="label label-info">{{ counterTime }}</span>
            <span class="label label-success">{{ letra }}</span>
            <button type="button" class="btn btn-danger" v-on:click="stop" :disabled="btnStop">STOP</button>
        </div>
        <div class="row col-md-10">
            <table class="table table-striped table-bordered">
                <thead>
                    <tr v-if="configuracoesPartida != null">
                        <th v-for="categoria in configuracoesPartida.categorias" :key="categoria">
                            {{ categoria }}
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-if="configuracoesPartida != null && !partidaConcluida">
                        <td v-for="categoria in configuracoesPartida.categorias" :key="categoria">
                            <input type="text" :id="categoria" :disabled="btnStop"/>
                        </td>
                    </tr>
                    <tr v-for="resposta in rodadas" :key="resposta.idRodada">
                        <td v-for="(value, index) in resposta.respostas" :key="index">
                            <input type="text" disabled :value="value" />
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="row col-md-2 listJogadores">
            <ul class="list-group" >
                <li class="list-group-item list-group-item-info" v-for="jogador in listaJogadores" :key="jogador.idJogador">
                    {{ jogador.nome }}
                </li>
            </ul>
        </div>
    </div>
</template>

<script>
export default {
    name:"Jogo",
    data() {
        return {
            listaJogadores:[],
            socketCon : this.$store.getters.socket,
            nomeJogador : this.$store.getters.nomeJogador,
            idJogador : this.$store.getters.idJogador,
            idPartida : this.$store.getters.idPartida,
            stopRodada : true,
            counterTime : 10,
            timer : null,
            letra : '',
            configuracoesPartida : null,
            idRodada : 0,
            rodadas : [],
            pontuacao : 0,
            vitorias : 0
        };
    },
    computed : {
        btnStop : function() {
            return this.stopRodada;
        },
        partidaConcluida : function(){
             return (this.rodadas.length >= this.configuracoesPartida.qtdRodadas);
        }
    },
    methods : {
        setTimer : function(){
            this.timer = setInterval( () => {
                if (this.counterTime > 0) {
                    this.counterTime--;
                } else {
                    clearInterval(this.timer);
                    this.timer = null;
                    this.stopRodada = !this.stopRodada;
                    
                    if(this.stopRodada){
                        this.pegaValoresRodada();
                    }
                }
            }, 1000 )
        },
        stop() {
            this.socketCon.send("/api/stop", JSON.stringify({nome:this.nomeJogador}), {});
        },
        enviarRespostas(respostas) {
            this.socketCon.send("/api/respostas",
                                JSON.stringify({
                                                    idPartida : this.idPartida,
                                                    idRodada : this.idRodada,
                                                    idJogador : this.idJogador,
                                                    respostas : respostas
                                                }), {});
        },
        conectSocket(){
            self = this;
            this.socketCon.subscribe(
                "/socket/novoJogador", 
                (retorno)=>{
                    var novoJogador = (JSON.parse(retorno.body));
                    if(novoJogador.idPartida == self.idPartida)
                        self.listaJogadores.push({idJogador:novoJogador.idJogador,nome:novoJogador.nome});
                }
            );

            this.socketCon.subscribe(
                "/socket/stop", 
                (retorno)=>{
                    this.pegaValoresRodada();
                    this.stopRodada = JSON.parse(retorno.body);
                    self.controleTimer(10);
                }
            );

            this.socketCon.subscribe(
                "/socket/enviaLetraRandomica", 
                (retorno)=>{
                    var rodada = (JSON.parse(retorno.body));
                    if(rodada.idPartida == self.idPartida){
                        self.letra = rodada.letra;
                        self.stopRodada = false;
                        self.controleTimer(rodada.tempo);
                    }
                }
            );

            this.socketCon.subscribe(
                "/socket/rodada", 
                (retorno)=>{
                    var rodada = (JSON.parse(retorno.body));
                    if(rodada.idPartida == self.idPartida){
                        self.idRodada = rodada.idRodada;
                        self.controleTimer(10);
                    }
                }
            );
        },
        buscaListaJogadoresPartida(){
            this.axios.get('http://localhost:8080/listarJogadoresPartida/'+this.idPartida)
                .then((response)=>{
                    this.listaJogadores = response.data;
                });
        },
        buscaConfiguracoesPartida(){
            this.axios.get('http://localhost:8080/buscaConfiguracaoPartida/'+this.idPartida)
                .then((response)=>{
                    this.configuracoesPartida = response.data;
                });
        },
        controleTimer(tempo){
            clearInterval(this.timer);
            this.timer = null;
            this.counterTime = tempo;
            this.setTimer();
        },
        pegaValoresRodada(){
            self = this;
            var respostas = [];
            for(var categoria in this.configuracoesPartida.categorias){
                respostas.push(document.getElementById(this.configuracoesPartida.categorias[categoria]).value);
                document.getElementById(this.configuracoesPartida.categorias[categoria]).value = "";
            }
            this.enviarRespostas(respostas);
            self.rodadas.unshift({idRodada : this.idRodada,respostas : respostas});
        }
    },
    beforeMount(){
        this.conectSocket();        
    },
    mounted(){
        this.buscaListaJogadoresPartida();
        this.buscaConfiguracoesPartida();
    }
};
</script>

<style>
    .infoJogo{
        font-size: 150%;
    }
    .letraRodada{
        font-size: 400%;
        margin-bottom: 1%;
    }
    .listJogadores{
        margin-left: 1%;
    }
</style>
