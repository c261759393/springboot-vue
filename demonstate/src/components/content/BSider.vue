<template>
    <div>
      <el-menu default-active="1" class="el-menu-vertical-demo" background-color="#ECECEC" @open="handleOpen" @close="handleClose">
        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-setting"></i>
            <span>用户管理</span>
          </template>
          <el-menu-item-group>
            <router-link to="/home/user">
              <el-menu-item index="1-1">用户信息</el-menu-item>
            </router-link>
          </el-menu-item-group>
        </el-submenu>
      </el-menu>
      <el-menu default-active="2" class="el-menu-vertical-demo" background-color="#ECECEC" @open="handleOpen" @close="handleClose">
        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-tickets"></i>
            <span>员工资料</span>
          </template>
          <el-menu-item-group>
            <router-link to="/home/staff">
              <el-menu-item index="1-1">基本资料</el-menu-item>
            </router-link>
          </el-menu-item-group>
        </el-submenu>
      </el-menu>
    </div>
</template>

<script>
    export default {
        name: "BSider",
      methods: {
        handleOpen(key, keyPath) {
          console.log(key, keyPath);
        },
        handleClose(key, keyPath) {
          console.log(key, keyPath);
        }
      }
    }
</script>

<style scoped>

</style>
