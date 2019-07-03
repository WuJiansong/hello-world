import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import b1 from '@/components/b'
import about from '../components/About'
import customers from '../components/Customers'
import add from '../components/Add'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/b',
      name: 'b',
      component: b1
    },
    {
      path: '/about',
      name: 'about',
      component: about
    },
    {
      path: '/customers',
      name: 'customers',
      component: customers
    },
    {
      path: '/add',
      name: 'add',
      component: add
    }
  ]
})
