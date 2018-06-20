import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import BLogin from '@/components/BLogin'
import BHome from '@/components/BHome'
import BUser from '@/components/content/BUser'
import BStaff from '@/components/content/BStaff'
import Bhomer from '@/components/content/Bhomer'

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
      meta: {
        requireAuth: true
      },
      component: BHome,
      children: [
        {path: '', component: Bhomer},
        {path: 'staff', component: BStaff},
        {path: 'user', component: BUser}
      ]
    }
  ]
})

router.beforeEach((to, from, next) => {
  console.log(router)
  next()
  // if (to.meta.requireAuth) {
  //   console.log(111111)
  //   next()
  // } else {
  //   console.log(66666)
  // }
  // if (to.meta.requireAuth) {  // 判断该路由是否需要登录权限
  //   if (store.state.token) {  // 通过vuex state获取当前的token是否存在
  //     next();
  //   }
  //   else {
  //     next({
  //       path: '/login',
  //       query: {redirect: to.fullPath}  // 将跳转的路由path作为参数，登录成功后跳转到该路由
  //     })
  //   }
  // }
  // else {
  //   next();
  // }
})

export default router
