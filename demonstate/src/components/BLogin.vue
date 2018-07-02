<template>
  <div class="b_background">
    <div class="b_login">
      <h1>FNDSOFT</h1>
      <br/>
      <el-form :model="loginForm" :rules="rules">
        <el-form-item>
          <el-input placeholder="账号" v-model="loginForm.username" @keyup.enter.native="login"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input type="password" placeholder="密码" v-model="loginForm.password"
                    @keyup.enter.native="login"></el-input>
        </el-form-item>
        <el-form-item>
          <el-checkbox v-model="checked" checked>记住密码</el-checkbox>
        </el-form-item>
        <el-form-item size="small">
          <el-button type="primary" @click="login()">登录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import request from '../api/request'

  export default {
    name: "BLogin",
    data() {
      return {
        loginForm: {
          username: '',
          password: ''
        },
        rules: {
          username: [{required: true, message: '请输入账号', trigger: 'blur'}],
          password: [{required: true, message: '请输入密码', trigger: 'blur'}]
        },
        checked: true
      }
    },
    mounted(){
      this.getCookie();
    },
    methods: {
      login() {
        // 账号密码不能为空
        if (this.loginForm.username == "") {
          this.$message.error("请输入账号")
        } else if (this.loginForm.password == "") {
          this.$message.error("请输入密码")
        } else {
          request({
            method:'post',
            url:'/api/login',
            data:this.loginForm
          }).then((response) => {
            // console.log(response.data)
            if (response.data.result == true) {
              this.$message.success("登录成功");

              //将用户名保存到本地
              // localStorage.setItem('name', JSON.stringify(response.data.name));
              localStorage.setItem('username',JSON.stringify(this.loginForm.username));

              sessionStorage.setItem('access-token', response.data.token);
              //判断复选框是否被勾选 勾选则调用配置cookie方法
              if(this.checked==true){
                //传入账号名，密码，和保存天数3个参数
                this.setCookie(this.loginForm.username,this.loginForm.password,7);
                this.$message.success("已保存账号密码")
              }else {
                this.clearCookie()
                this.$message.success("已清除账号密码")
              }
              this.$router.push({path:"/home"})
            } else {
              this.$message.error("登录失败，请输入正确的账号密码")
            }
          }).catch(function (error) {
            console.log(error)
          })
        }
      },
      setCookie(username, password, exdays) {
        var exdate = new Date();
        exdate.setTime(exdate.getTime() + 24 * 60 * 60 * 1000 * exdays)   //保存的天数
        //字符串拼接cookie
        window.document.cookie = "userName" + "=" + username + ";path=/;expires=" + exdate.toGMTString();
        window.document.cookie = "userPwd" + "=" + password + ";path=/;expires=" + exdate.toGMTString();
      },
      getCookie(){
        if (document.cookie.length>0) {
          var arr=document.cookie.split('; ');//这里显示的格式需要切割一下自己可输出看下
          for(var i=0;i<arr.length;i++){
            var arr2=arr[i].split('=');//再次切割
            //判断查找相对应的值
            if(arr2[0]=='userName'){
              this.loginForm.username=arr2[1];//保存到保存数据的地方
            }else if(arr2[0]=='userPwd'){
              this.loginForm.password=arr2[1];
            }
          }
        }
      },
      //清除cookie
      clearCookie() {
        this.setCookie("","",-1);//修改2值都为空，天数为负1天就好了
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
