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
        <el-table-column prop="id" label="部门编号" width="360">
        </el-table-column>
        <el-table-column prop="name" label="部门名称" width="360">
        </el-table-column>
        <el-table-column prop="creDate" label="创建日期" width="360">
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
      deleteRow(index,row){
        console.log(row.name)
        this.tableData.splice(index, 1);
      }
  },
  
};
</script>
<style>
.a {
  width: 50px;
}
</style>