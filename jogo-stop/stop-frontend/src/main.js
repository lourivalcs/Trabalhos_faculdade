// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import Vuex from 'vuex'
import axios from 'axios'
import VueAxios from 'vue-axios'
import 'bootstrap/dist/css/bootstrap.min.css'

Vue.use(Vuex)
Vue.use(VueAxios, axios)

const store = new Vuex.Store({
  state: {
      nomeJogador:'',
      idJogador: null,
      idPartida: null,
      conexaoSocket:null
  },
  mutations:{
    addConexaoSocket(state, conexao){
      state.conexaoSocket = conexao
    },
    addNomeJogador(state, nome){
      state.nomeJogador = nome
    },
    addIdJogador(state, idJogador){
      state.idJogador = idJogador
    },
    addIdPartida(state, idPartida){
      state.idPartida = idPartida
    }
  },
  getters:{
    nomeJogador: state => {
      return state.nomeJogador
    },
    socket: state =>{
      return state.conexaoSocket
    },
    idJogador: state =>{
      return state.idJogador
    },
    idPartida: state =>{
      return state.idPartida
    }
  },
  actions:{
    addConexaoSocket(context, conexao){
      context.commit('addConexaoSocket', conexao)
    },
    addNomeJogador(context, nome){
      context.commit('addNomeJogador', nome)
    },
    addIdJogador(context, idJogador){
      context.commit('addIdJogador', idJogador)
    },
    addIdPartida(context, idPartida){
      context.commit('addIdPartida', idPartida)
    }    
  }
})

Vue.config.productionTip = false


/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>',
  store : store
})
