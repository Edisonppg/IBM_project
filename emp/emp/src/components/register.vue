<template>
  <div>
    <div id="header">
      <br />
      <br />
      <h1>欢迎使用员工管理系统</h1>
      <br />
      <br />
    </div>
    <div id="body">
      <br />
      <h2>注册界面</h2>
      <br />
      <br />
      <el-form>
        <el-form-item >
          <el-input v-model="username" maxlength="30" class="inputregister"
          placeholder="用户名"
          ></el-input>
        </el-form-item>
        <el-form-item id="realname">
          <el-input
            id="name"
            class="inputregister"
            v-model="name"
            maxlength="20"
            placeholder="真实姓名"
            @change="testchinese()"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-input
          id="password"
            class="inputregister"
            v-model="password"
            show-password
            maxlength="30"
            placeholder="密码"
            style="ime-mode:disabled"
            @keydown.native="tipshide()"
            @blur="tipshide()"
          ></el-input>
        </el-form-item>
        <el-form-item >
          <el-input
            class="inputregister"
            v-model="confirmpwd"
            show-password
            maxlength="30"
            placeholder="确认密码"
            style="ime-mode:disabled"
          ></el-input>
          <div id="pwddif" v-show="isShow" ><p>密码不一致，请重新输入！</p>
          </div>
        </el-form-item>
        <el-form-item ><b>性别：</b>
          <el-radio v-model="sex" label="男">男</el-radio><span></span>
          <el-radio v-model="sex" label="女">女</el-radio>
        </el-form-item>
        <div id="code">
        
      
            <el-input
            id="codeinput"
            style="width: 150px;ime-mode:disabled"
            v-model="key"
            maxlength="4"
            class="inputregister"
            placeholder="请输入4位有效验证码"
            ></el-input>
        <span></span>

            <img id="codeimg" :src="imgsrc" alt="点击图片刷新" @click="coderefresh()" />

        
        </div>
        <el-row>
          <div id="button">
            <el-button round class="button" @click="register()" >提交</el-button>
          </div>
        </el-row>
      </el-form>
    </div>
  </div>
</template>

<style>
.inputregister {
  width: 300px;
}
#body {
  position: relative;
}
#codeinput {
  padding: 0px 6px;
}
.button {
  width: 100px;
  background-color: #cccccc;
  text-align: center;
}

span {
  margin: 0 10px;
}
input::-webkit-input-placeholder{
  color:#cccccc;
}
input::-moz-placeholder{   /* Mozilla Firefox 19+ */
  color:#cccccc;
}
input:-moz-placeholder{    /* Mozilla Firefox 4 to 18 */
  color:#cccccc;
}
input:-ms-input-placeholder{  /* Internet Explorer 10-11 */
  color:#cccccc;
}
#codeimg{
  
size: 50px;
}
#codeinput{
  margin-bottom: 20px;
}
#pwddif{
  width: auto;
  height: auto;
  transition:height 2s;
	-webkit-transition:height 2s;
  color: red;
}
</style>
<script>

export default {
  data() {
    return {
      sex: "男",
      username: "",
      name: "",
      password: "",
      confirmpwd: "",
      uuid:"",
      key: "",
      imgsrc: "",
      isShow:false
    };
  },
  mounted() {
    let suuid=sessionStorage.getItem("uuid");
    if(suuid==null||suuid==""||suuid==undefined){
      alert("aaa");
      this.uuid = new Date().getTime()+Math.random();
      sessionStorage.setItem("uuid",this.uuid);
      this.imgsrc="http://10.10.102.146:8090/kaptcha?uuid="+this.uuid;
      // document.getElementById("codeimg").setAttribute("src","http://10.10.102.146:8090/kaptcha?uuid="+this.uuid);
    }else{
      this.uuid=suuid;
      this.imgsrc="http://10.10.102.146:8090/kaptcha?uuid="+this.uuid;
    }
  },
  methods: {
    tipshide(){
      this.isShow=false
    }
    ,
    testchinese(){
      var obj=document.getElementById("name").value;
      var zj='^[\u4e00-\u9fa5]+$'
      var ex = new RegExp(zj);
      if(obj.search(ex) != -1){
        return true;
      }else{
                alert("请输入中文！")
                this.name='';
                document.getElementById("name").focus();
      }
    }
    ,
    register() {
      if (!this.username) {
        alert("用户名不能为空！");
        return;
      }
      if (!this.name) {
        alert("真实姓名不能为空！");
        return;
      }
      if (!this.password) {
        alert("密码不能为空！");
        return;
      }
      if (!this.key) {
        alert("验证码不能为空！");
        return;
      }
      if (this.password != this.confirmpwd) {
        this.password="",
        this.confirmpwd=""
        this.isShow=!this.isShow
        document.getElementById("password").focus();
        
        return;
      } else {
        
        
            // this.$router.push("/Loading");
            //       sessionStorage.setItem("userName", this.username)

      var json = {
        userName: this.username,
        password: this.password,
        realName: this.name,
        sex: this.sex,
      };
      this.$axios
        .post("http://10.10.102.146:8090/user/regist?key=" + this.key+"&uuid="+this.uuid, json)
        .then((Response) => {
          let user = Response.data;
          console.log(user);
          if (user == "1") {
            alert("用户已存在！");
          } else if (user == "0") {
            alert("验证码错误，请重新输入验证码！");
          } else {
            sessionStorage.setItem("userName", user.userName);
            alert("注册成功！将在3秒后跳转注册页面！");
            this.$router.push("/login");
          }
        });
      }
    },
    coderefresh() {
      let time = new Date().getTime();
      this.imgsrc = "http://10.10.102.146:8090/kaptcha?time=" + time+"&uuid="+this.uuid;
    },
  },
};
</script>
