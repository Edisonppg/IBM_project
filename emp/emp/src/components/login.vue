<template>
  <div id="all">
    <div id="header">
      <br />
      <br />
      <h1>欢迎使用员工管理系统</h1>
      <br />
      <br />
    </div>

  <div id="body">
    <div>
      <br />
      <h2>登录界面</h2>
      <br />
      <br />
      </div>
      <div id="loginform">
      <el-form>
          <div id="username">
                    <div id='usernameimg'>
            <img class="img" :src="userimg" alt="">
            </div>
            <div id="usernamelogin">
           <el-form-item>
            <el-input
              v-model="username"
              placeholder="请输入用户名"
              class="inputlogin"
            ></el-input>
           </el-form-item>
          </div>
        </div>
        <div id="password">
          <div id="pwdimg">
          <img class="img" :src="pwdimg" alt="">
          </div>
         <div id="pwdlogin">
            <el-form-item >
             <el-input
              class="inputlogin"
             placeholder="请输入密码"
             v-model="password"
             show-password
             style="ime-mode: disabled"
             ></el-input>
            </el-form-item>
          </div>
        </div>
        <div>
              <p class="tips" style="font-size: 15px; line-height: 30px; color: #d9d9d9">
                Tips : 请输入账号密码登陆
              </p>
              <br />
             <br />
        </div>
        <div>
           <el-form-item>
             <el-button class="button" @click="testLogin()">登录</el-button>
             <span></span><span></span><span></span>
              <router-link to="/register"
               ><el-button class="button">注册</el-button></router-link
            ><br />
            </el-form-item>
        </div>
      </el-form>
      </div>
    </div>
    <div><br /><br /><br /><br /></div>
  </div>
</template>

<style>
.inputlogin {
  width: 300px;
float: left;
}
#header {
  background: url(../assets/1234.jpg);
  color: aliceblue;
}

span {
  margin: 0 10px;
}
#usernameimg,#pwdimg{
  width: 40%;

}
#usernamelogin,#pwdlogin{
  width: 60%;

}
#usernameimg,#usernamelogin{
  float: left;
}
.img{
margin: 10px 10px;
float: right;

}
#pwdimg,#pwdlogin{
  float: left;
}



</style>
<script>
export default {
  data() {
    return {
      username: "",
      password: "",
      userimg:'https://mimg.127.net/p/freemail/index/lib/img/urs/ico-user.png',
      pwdimg:'https://mimg.127.net/p/freemail/index/lib/img/urs/ico-password.png'
   
   };
  },
  methods: {
    testLogin() {
      if (!this.username && !this.password) {
        alert("用户名和密码不能为空!");
        return;
      } else if (!this.username) {
        alert("用户名不能为空!");
        return;
      } else if (!this.password) {
        alert("密码不能为空!");
        return;
      } else {

      
      var json = {
        userName: this.username,
        password: this.password,
      };
      
      this.$axios.post("http://10.10.102.146:8090/user/login", this.$qs.stringify(json)).then((Response) => {
        let user = Response.data;
        if (user == "0" || user == "1") {
          alert("用户名不存在或密码错误！");
          return;
        } else {
          console.log(user);
          this.$router.push("/HelloWorld");
          return;
        }
      });
      }
    },
  },
};
</script>
