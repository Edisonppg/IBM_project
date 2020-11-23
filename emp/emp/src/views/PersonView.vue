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
        <el-table-column prop="id" label="序号" width="120">
        </el-table-column>
        <el-table-column prop="name" label="姓名" width="120">
        </el-table-column>
        <el-table-column prop="salary" label="工资" width="120">
        </el-table-column>
        <el-table-column prop="age" label="年龄" width="120">
        </el-table-column>
        <el-table-column prop="empDate" label="入职时间" width="120">
        </el-table-column>
        <el-table-column prop="did" label="部门编号" width="120">
        </el-table-column>
        <el-table-column prop="quitDate" label="离职时间" width="120">
        </el-table-column>
        <el-table-column
      fixed="right"
      label="操作"
      width="200">
<div slot-scope="scope">
        <el-button @click.native.prevent="deleteRow" type="text" width="50%" class="a" @click="Del">删除</el-button>
        <router-link to="/Personcompile">
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
    // const item = {
    //   id:"",
    //   name: "王小虎",
    //   salary:"",
    //   age:"",
    //   empDate:"",
    //   did:"",
    //   quitDate: "0202",
      
    // };
    return {
      tableData: [],
       formInline: {
          id: '',
          name: ''
        }
      }
    },
    created() {
      this.$axios.get("http://10.10.102.146:8090/doemp/initSelect")
      .then((Response)=>{
        let emplist=Response.data;
        if(emplist=="0"){
          alert("不能同时使用两种查询");
        }else{
          this.tableData=emplist;
        }
      })
    },
    methods: {
      onSubmit() {
        if(this.formInline.id&&this.formInline.name){
          alert("只能选一种方式查询");
        }else{
          if(this.formInline.id){
            this.$axios.post("http://10.10.102.146:8090/doemp/select",{"id":this.formInline.id})
            .then((Response)=>{
              let emplist=Response.data;
              if(emplist=="0"){
                alert("不能同时使用两种查询");
              }else if(emplist=="1"){
                alert("无匹配信息");
              }
              else{
                this.tableData=emplist;
              }
            })
          }
        }
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