<template>
    <el-main>
    <el-form :inline="true" :model="formInline" class="demo-form-inline">
  <el-form-item label="员工序号">
    <el-input v-model="formInline.id" placeholder="员工序号"></el-input>
  </el-form-item>
  <el-form-item label="员工姓名">
    <el-input v-model="formInline.name" placeholder="员工姓名"></el-input>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="onSubmit">查询</el-button>
  </el-form-item>
</el-form>
      <el-table :data="tableData">
        <el-table-column prop="id" label="序号" width="160">
        </el-table-column>
        <el-table-column prop="name" label="姓名" width="160">
        </el-table-column>
        <el-table-column prop="salary" label="工资" width="160">
        </el-table-column>
        <el-table-column prop="age" label="年龄" width="160">
        </el-table-column>
        <el-table-column prop="empDate" label="入职时间" width="160">
        </el-table-column>
        <el-table-column prop="did" label="部门编号" width="160">
        </el-table-column>
        <el-table-column prop="quitDate" label="离职时间" width="160">
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
      salary:"",
      age:"",
      empDate:"",
      did:"",
      quitDate: "0202",
      
    };
    return {
      tableData: Array(20).fill(item),
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
      }
    
  },
};
</script>
<style>
.a {
  width: 50px;
}

</style>