<template>
  <div>
    <el-container>
      <el-header>
        <b-header></b-header>
      </el-header>
      <el-container>
        <el-aside width="200px">
          <b-sider></b-sider>
        </el-aside>
        <el-container>
          <el-main>
            <router-view/>
          </el-main>
        </el-container>
      </el-container>
    </el-container>
  </div>
</template>

<script>
    import BHeader from "./content/BHeader";
    import BSider from "./content/BSider";
    export default {
        name: "BHome",
      components: {BSider, BHeader},
      data(){
          return{

          }
      }
    }
</script>

<style scoped>
  div{
    height: 100%;
  }
  .el-container{
    height: 100%;
  }

  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }

  .el-aside {
    height: 100%;
    background-color: #ECECEC;
    color: #333;
  }

  .el-main {
    color: #333;
  }

</style>
