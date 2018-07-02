<template>
  <div>
    <router-link to="/home">
      <span class="home_title">菲耐得</span>
    </router-link>
    <div class="home_title_right">
      <i class="el-icon-bell" style="margin-right: 10px"></i>
      <el-dropdown @command="handleCommand">
        <span class="el-dropdown-link home_userinfo">
          {{username}}<i v-if="src"><img :src="src"/></i>
                      <i v-else class="el-icon-picture"></i>

        </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item command="admin">个人中心</el-dropdown-item>
          <el-dropdown-item command="setup">设置</el-dropdown-item>
          <el-dropdown-item divided command="logout">注销</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
  import request from "../../api/request"

    export default {
        name: "BHeader",
      data(){
          return{
            username:'',
            src:''
          }
      },
      mounted() {
        this.getAdmin();
      },
      methods:{
        handleCommand(index){
          if(index === "admin"){
            this.$router.push({name:'self',params:{name:this.username}})
          }else if (index ==="setup"){
            this.$router.replace({path:'/home/setting'})
          } else if (index === "logout"){
            this.$confirm('注销登录，是否继续','提示',{
              confirmButtonText:'确定',
              cancelButtonText:'取消',
              type:"warning"
            }).then(()=>{
              this.$router.replace({path: '/login'});
            }).catch(()=>{
              this.$message({
                type: 'info',
                message: '已取消删除'
              });
            })
          }
        },
        getAdmin() {
          request({
            url:'/api/self?username='+JSON.parse(localStorage.getItem('username')),
            method:'get'
          }).then((response)=>{
            this.src = response.data.imgpath;
            this.username = response.data.name;
          }).catch((error) => {
            console.log(error)
          })
        }
      }
    }
</script>

<style scoped>

  .home_title {
    color: #fff;
    font-size: 22px;
    display: inline;
    margin-left: 8px;
  }
  .home_title_right{
    width: 200px;
    height: 40px;
    position: absolute;
    top: 10px;
    right: 30px;
    line-height: 40px;
    text-align: center;
  }
  img {
    position: absolute;
    top: 0px;
    width: 40px;
    height: 40px;
    border-radius: 40px;
    margin-left: 5px;
  }
  .home_userinfo{
    color: #fff;
    cursor: pointer;
  }

</style>
