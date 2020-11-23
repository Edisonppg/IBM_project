<template>
    <el-main>
    <el-form :inline="true" :model="formInline" class="demo-form-inline">
  <el-form-item label="部门序号">
    <el-input v-model="formInline.id" placeholder="部门序号"></el-input>
  </el-form-item>
  <el-form-item label="部门名称">
    <el-input v-model="formInline.name" placeholder="部门名称"></el-input>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="onSubmit">查询</el-button>
  </el-form-item>
</el-form>
      <el-table :data="tableData">
        <el-table-column prop="id" label="部门编号" width="300">
        </el-table-column>
        <el-table-column prop="name" label="部门名称" width="300">
        </el-table-column>
        <el-table-column prop="creDate" label="创建日期" width="300">
        </el-table-column>

        <el-table-column
      fixed="right"
      label="操作"
      width="200">
<div slot-scope="scope">
        <el-button @click.native.prevent="deleteRow" type="text" width="50%" class="a" @click="Del">删除</el-button>
        <router-link to="/Depcompile">
        <el-button @click="handleClick(scope.row)" type="text"  width="50%" class="a">编辑</el-button>
        </router-link>
</div>
    </el-table-column>
      </el-table>
    </el-main>
</template>

<script>
export default {
  data() {
    const item = {
      id:"",
      name: "王小虎",
      creDate: "0202",
      
    };
    return {
      tableData: Array(5).fill(item),
       formInline: {
          id: '',
          name: ''
        }
      }
    },
    methods: {
      onSubmit() {
        console.log('submit!');
      },
      deleteRow(index){
        this.tableData.splice(index, 1);
      },
      Del(){
        alert("已删除")
      }
  },
  
};
</script>
<style>
.a {
  width: 50px;
}
</style>