import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import BLogin from '@/components/BLogin'
import BHome from '@/components/BHome'
import BUser from '@/components/content/BUser'
import BStaff from '@/components/content/BStaff'
import Bhomer from '@/components/content/Bhomer'
import BSelf from '@/components/content/BSelf'
import BSetting from '@/components/content/BSetting'

Vue.use(Router)

const router = new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/login',
      name: 'Login',
      component: BLogin
    },
    {
      path: '/home',
      component: BHome,
      children: [
        {path: '', component: Bhomer},
        {name:'staff',path: 'staff', component: BStaff},
        {name:'user',path: 'user', component: BUser},
        {name:'self',path: 'self', component: BSelf},
        {name:'setting',path: 'setting', component: BSetting}
      ]
    }
  ]
})

router.beforeEach((to, from, next) => {
  if (to.path.startsWith('/login')) {
    window.sessionStorage.removeItem('access-token')
    next()
  } else {
    let token = window.sessionStorage.getItem('access-token')
    if (!token) {
      next({path: 'login'})
    } else {
      next()
    }
  }
});

export default router
