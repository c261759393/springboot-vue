<template>
  <div id="app">
    <router-view v-if="isRouterAlive"/>
  </div>
</template>

<script>
  export default {
    name: 'App',
    provide() {
      return{
        reload:this.reload
      }
    },
    data(){
      return{
        isRouterAlive:true
      }
    },
    methods: {
      reload(){
        this.isRouterAlive=false
        this.$nextTick(()=>{
          this.isRouterAlive=true
        })
      }
    }
  }
</script>

<style>
  * {
    margin: 0;
    padding: 0;
  }

  a {
    text-decoration: none;
  }

  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    color: #2c3e50;
    position: absolute;
    width: 100%;
    height: 100%;
  }
</style>
