<template>
  <div class="b_background">
    <div class="b_login">
      <h1>FNDSOFT</h1>
      <br/>
      <el-form :model="loginForm">
        <el-form-item>
          <el-input placeholder="用户名" v-model="loginForm.username"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input type="password" placeholder="密码" v-model="loginForm.password"></el-input>
        </el-form-item>
        <el-form-item size="small">
          <el-button type="primary" @click="login()">登录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  import router from '../router'

  export default {
    name: "BLogin",
    data() {
      return {
        loginForm: {
          username: '',
          password: ''
        },
        apiUrl: "http://127.0.0.1:8082/api/login"
      }
    },
    methods: {
      login() {
        this.$axios.post(this.apiUrl, this.loginForm).then((response) => {
          console.log(response)
          if (response.data.result == true) {
            // alert("登录成功")
            this.$message.success("登录成功")
            router.push("/home")
          }else {
            this.$message.error("登录失败")
          }
        }).catch(function (error) {
          console.log(error)
        })
      }
    }
  }
</script>

<style scoped>
  .b_login {
    border: 1px solid #F5F5F5;
    width: 300px;
    margin: 120px auto;
    text-align: center;
    padding: 25px;
    border-radius: 15px;
    background-color: #fff;
  }

  .b_background {
    background-color: #F5F5F5;
    position: absolute;
    height: 100%;
    width: 100%;
  }
</style>
