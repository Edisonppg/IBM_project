<template>
<div id="a">
<el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
  <el-form-item label="旧密码" prop="pass">
    <el-input type="password" v-model="ruleForm.pass" autocomplete="off" maxlength="30"></el-input>
  </el-form-item>
  <el-form-item label="新密码" prop="newPass">
    <el-input type="password" v-model="ruleForm.newPass" autocomplete="off" maxlength="30"></el-input>
  </el-form-item>
  <el-form-item label="确认新密码" prop="checkNewPass">
    <el-input type="password" v-model.number="ruleForm.checkNewPass" autocomplete="off" maxlength="30"></el-input>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
  </el-form-item>
</el-form>
</div>
</template>

<script>
  export default {
    data() {
      var checkpass = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('密码不能为空'));
        }
        setTimeout(() => {
          if (!Number.isInteger(value)) {
            callback(new Error('请输入数字值'));
          } else {
              callback();
          }
        }, 1000);
      };
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.ruleForm.checkPass !== '') {
            this.$refs.ruleForm.validateField('checkPass');
          }
          callback();
        }
      };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.ruleForm.pass) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
      return {
        ruleForm: {
          pass: '',
          newPass: '',
          checkNewPass: ''
        },
        rules: {
          newPass: [
            { validator: validatePass, trigger: 'blur' }
          ],
          checkNewPass: [
            { validator: validatePass2, trigger: 'blur' }
          ],
          Pass: [
            { validator: checkpass, trigger: 'blur' }
          ]
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

.a {
    margin-top: 20px;
}

</style>