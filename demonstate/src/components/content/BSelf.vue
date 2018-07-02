<template>
  <div>
    <h1>个人中心</h1>
    <el-form :label-position="labelPosition" label-width="80px" :model="formSelf">
      <el-form-item label="头像">
        <el-upload class="avatar-uploader"
                   :show-file-list="false"
                   :on-success="handleAvatarSuccess"
                   :before-upload="beforeAvatarUpload"
                   action="http://127.0.0.1:8082/api/uploadimg">
          <img v-if="formSelf.imgpath" :src="formSelf.imgpath" class="avatar">
          <i v-else class="el-icon-picture avatar-uploader-icon" slot="trigger"></i>
        </el-upload>
      </el-form-item>
      <el-form-item label="名称">
        <el-input v-model="formSelf.name" disabled="disabled"></el-input>
      </el-form-item>
      <el-form-item label="账号">
        <el-input v-model="formSelf.username" disabled="disabled"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="formSelf.password" type="password"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmitSelf">提交</el-button>
      </el-form-item>
    </el-form>

  </div>
</template>

<script>
  import request from "../../api/request"

  export default {
    name: "BSelf",
    inject:['reload'],
    data() {
      return {
        labelPosition: 'right',
        formSelf: {
          name: '',
          username: '',
          password: '',
          imgpath: ''
        },
        disabled: false
      };
    },
    mounted() {
      this.getSelf();
    },
    methods: {
      getSelf() {
        request({
          url: '/api/self?username=' + JSON.parse(localStorage.getItem('username')),
          method: 'get'
        }).then((response) => {
          this.formSelf = response.data;
        }).catch((error) => {
          console.log(error)
        })
      },
      handleAvatarSuccess(res) {
        this.formSelf.imgpath = res
      },
      beforeAvatarUpload(file) {
        const isJPG = file.type === 'image/jpeg';
        const isLt2M = file.size / 1024 / 1024 < 2;

        if (!isJPG) {
          this.$message.error('上传头像图片只能是 JPG 格式!');
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!');
        }
        return isJPG && isLt2M;
      },
      onSubmitSelf() {
        request({
          method: 'put',
          url: '/api/self',
          data:this.formSelf
        }).then((response)=>{
          // console.log(response)
          this.reload();
        }).catch((error)=>{
          console.log(error)
        })
      }
    }
  }
</script>

<style scoped>
  .el-form {
    width: 400px;
    margin: 100px auto;
    text-align: center;
  }

  img {
    top: 0px;
    border-radius: 50px;
  }

  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }

  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }

  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 100px;
    height: 100px;
    line-height: 100px;
    text-align: center;
  }

  .avatar {
    width: 100px;
    height: 100px;
    display: block;
  }
</style>
