import Vue from 'vue'
import Router from 'vue-router'
import Acesso from '@/components/Acesso'
import Jogo from '@/components/Jogo'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Acesso',
      component: Acesso,
      props: true
    },
    {
      path: '/Jogo',
      name: 'Jogo',
      component: Jogo,
      props: true
    }
  ]
})
