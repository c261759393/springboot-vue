<template>
  <el-dialog
    title="员工信息"
    :visible.sync="dialogFormVisible"
    :close-on-click-model="false"
    :before-close="handleClose"
    width="30%">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="省份">
        <el-select v-model="form.provinceId" placeholder="请选择活动省份">
          <el-option
            v-for="item in provinces"
            :key="item.id"
            :label="item.province"
            :value="item.id">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="性别">
        <el-select v-model="form.sex" placeholder="请选择性别">
          <el-option
            v-for="item in sexs"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="员工名称">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="描述">
        <el-input v-model="form.description"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button type="primary" @click="onSubmit" v-if="options.submit">立即创建</el-button>
      <el-button type="primary" @click="onSave" v-if="options.save">修改</el-button>
      <el-button @click="cancleModal">取消</el-button>
    </div>
  </el-dialog>
</template>

<script>
  export default {
    name: "BStaffModel",
    data() {
      return {
        sexs: [{
          value: 0,
          label: '女'
        }, {
          value: 1,
          label: '男'
        }]
      }
    },
    props: ['dialogFormVisible', 'form', 'provinces', 'options', 'apiUrl'],
    methods: {
      handleClose() {
        this.$emit("canclemodal");
      },
      onSubmit() {
        if (this.form.provinceId == null) {
          this.$notify({
            title: '警告',
            message: '请选择省份',
            type: 'warning'
          });
        }else if(this.form.sex == null){
          this.$notify({
            title: '警告',
            message: '请选择性别',
            type: 'warning'
          });
        }else if(this.form.name == null){
          this.$notify({
            title: '警告',
            message: '请填写姓名',
            type: 'warning'
          });
        } else {
          this.$axios.post(this.apiUrl + 'staff', this.form).then(function (response) {
            console.log(response)
          }).catch(function (error) {
            console.log(error)
          })
          this.handleClose();
        }
      },
      onSave() {
        if(this.form.name == '') {
          this.$notify({
            title: '警告',
            message: '请填写姓名',
            type: 'warning'
          });
        }else {
          this.$axios.put(this.apiUrl+'staff',this.form).then((response)=>{
            console.log(response)
          }).catch((error)=>{
            console.log(error)
          })
          this.handleClose();
        }
      },
      cancleModal() {
        this.handleClose();
      }
    }
  }
</script>

<style scoped>

</style>
