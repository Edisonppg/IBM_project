<template>
  <div id="a">
    <el-form ref="form" :model="form" label-width="80px">
    <el-form-item label="员工序号">
        <el-input type="text" v-model="id" placeholder="请输入员工序号" oninput="value=value.replace(/[^\d]/g,'')"></el-input>
      </el-form-item>
      <el-form-item label="员工姓名">
        <el-input type="text" placeholder="请输入员工姓名" v-model="text" maxlength="30" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="工资">
        <el-input type="text" v-model="salary" placeholder="请录入工资" oninput="value=value.replace(/[^\d]/g,'')"
        ></el-input>
      </el-form-item>
      <el-form-item
    label="年龄"
    prop="age" >
    <el-input type="age" v-model="age" placeholder="请输入年龄" maxlength="2" oninput="value=value.replace(/[^\d]/g,'')"
        ></el-input>
  </el-form-item>
      <el-form-item label="入职时间">
         <el-date-picker v-model="value1" type="datetime" placeholder="选择日期时间"></el-date-picker>
      </el-form-item>
      <el-form-item label="部门">
        <el-select v-model="value" placeholder="请选择">
    <el-option
      v-for="item in options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
      </el-form-item>
      <el-form-item label="离职时间">
         <el-date-picker v-model="value2" type="datetime" placeholder="选择日期时间"></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('numberValidateForm')"> 保存</el-button>
    
      </el-form-item>
    </el-form>
  </div>
</template>


<style>

#a{
    margin-top: 20px;
      width: 50%;
    position: relative;
    left:275px;
}

</style>
<script>
export default {
    data() {
      return {
        text: '',
        id: '',
        age: '',
        salary: '',
        value1: '',
        value2: '',
        options: [{
          value: '选项1',
          label: '黄金糕'
        }, {
          value: '选项2',
          label: '双皮奶'
        }
        ],
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
    //   @keyup.native="inputChange($event)"
    //     @keydown.native="inputChange($event)"
    //   inputChange(e) {
    //   const o = e.target;
    //   o.value = o.value.replace(/[^0-9]/g, ""); // 清除除了数字以外的输入的字符
    //   this.name = o.value;
    // }
      }
    }
    
 
</script>