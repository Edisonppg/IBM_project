<template>
  <div id="a">
    <el-form ref="form" label-width="80px">
    <el-form-item label="部门序号">
        <el-input type="text" v-model="id" placeholder="请输入部门序号" oninput="value=value.replace(/[^\d]/g,'')"></el-input>
      </el-form-item>
      <el-form-item label="部门名称">
        <el-input type="text" placeholder="请输入部门名称" v-model="text" maxlength="30" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="创建时间">
         <el-date-picker v-model="value1" type="datetime" placeholder="选择日期时间" class="b"></el-date-picker>
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
         numberValidateForm: {
          age: ''
        }
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
      }
      }
    }
    
 
</script>

<style>
.b{
    width: 100%;
}
</style>