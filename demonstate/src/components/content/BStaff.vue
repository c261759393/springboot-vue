<template>
  <div>
    <h1>员工资料</h1>
    <br/>
    <el-form :inline="true">
      <el-form-item>
        <el-input placeholder="姓名" v-model="nameSearch"></el-input>
      </el-form-item>
      <el-form-item label="省份">
        <el-select v-model="selectProvince" placeholder="请选择活动省份">
          <el-option
            v-for="item in provinces"
            :key="item.id"
            :label="item.province"
            :value="item.province">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onQuery">查询</el-button>
      </el-form-item>
      <el-form-item>
        <el-button type="danger" @click="onAdd">新增</el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="tableData"
      border
      style="width: 1000px">
      <el-table-column
        fixed
        prop="id"
        label="ID"
        width="150">
      </el-table-column>
      <el-table-column
        fixed
        prop="name"
        label="姓名"
        width="120">
      </el-table-column>
      <el-table-column
        :formatter="sex"
        fixed
        prop="sex"
        label="性别"
        width="120">
      </el-table-column>
      <el-table-column
        fixed
        prop="province"
        label="省份"
        width="120">
      </el-table-column>
      <el-table-column
        fixed
        prop="description"
        label="描述"
        width="300">
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作">
        <template slot-scope="scope">
          <el-button @click="onDetail(scope.row)" type="text" size="small">查看</el-button>
          <el-button @click="onEdit(scope.$index,tableData)" type="text" size="small">编辑</el-button>
          <el-button
            @click.native.prevent="deleteRow(scope.$index,tableData)"
            type="text"
            size="small">
            删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <br/>
    <div>
      <el-pagination
        @current-change="handleCurrentChange"
        background
        layout="prev, pager, next"
        :total="pages">
      </el-pagination>
    </div>
    <b-staff-model :dialogFormVisible="dialogFormVisible" :form="form" :provinces="provinces"
                   :options="options" v-on:canclemodal="dialogVisible"></b-staff-model>
  </div>
</template>

<script>
  import BStaffModel from "./BStaffModel";
  import request from "../../api/request";

  export default {
    name: "BStaff",
    components: {BStaffModel},
    inject: ['reload'],
    data() {
      return {
        tableData: [],
        nameSearch: '',
        selectProvince: '',
        pageNum: 1,
        pages: 50,
        provinces: '',
        dialogFormVisible: false,
        form: {},
        options: {
          submit: false,
          save: false
        },
        totalCount: ''
      }
    },
    mounted() {
      this.getStaff();
      this.getProvinces();
    },
    methods: {
      //查询列表
      getStaff() {
        request({
          url: '/api/staff?pageNum=' + this.pageNum + '&likeName=' + this.nameSearch + "&likeProvince=" + this.selectProvince,
          method: 'get'
        }).then((response) => {
          this.totalCount = response.data.totalCount
          this.pages = response.data.totalPages * 10
          this.tableData = response.data.list;
        }).catch((error) => {
          console.log(error)
        })
      },
      //获取省份内容
      getProvinces() {
        request({
          methods: 'get',
          url: '/api/provinces'
        }).then((response) => {
          this.provinces = response.data
        }).catch((error) => {
          console.log(error)
        })
      },
      onQuery() {
        this.getStaff();
      },
      handleCurrentChange(btn) {
        this.pageNum = btn;
        this.onQuery()
      },
      sex(row, column, cellValue, index) {
        if (cellValue == 1) {
          return '男';
        }
        if (cellValue == 0) {
          return '女';
        }
      },
      dialogVisible() {
        this.dialogFormVisible = false;
        this.options.submit = false;
        this.options.save = false;
        this.form = {};
        this.getStaff()
      },
      onAdd() {
        this.dialogFormVisible = true;
        this.options.submit = true;
      },
      onEdit(index) {
        this.dialogFormVisible = true;
        this.options.save = true;
        const editId = this.tableData[index].id;
        request({
          url: '/api/staff/' + editId,
          methods: 'get'
        }).then((response) => {
          this.form = response.data;
        }).catch(function (response) {
          console.log(response)
        })
      },
      deleteRow(index) {
        const delId = this.tableData[index].id;
        this.$confirm('确定删除此员工信息?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
        }).then(() => {
          request({
            method: 'delete',
            url: '/api/staff/' + delId
          }).then(() => {
            this.$message({
              type: 'success',
              message: '删除成功!'
            });
            const m = (this.totalCount - 1) / 5
            if (/^\d+$/.test(m)) {
              console.log("减少一个页面")
              this.pageNum -= 1
              this.getStaff();
            } else {
              this.getStaff();
            }
            // this.reload();
          }).catch(function (error) {
            console.log(error)
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      }
    }
  }
</script>

<style scoped>

</style>
