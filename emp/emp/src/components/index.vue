<template>
<el-container style="height: 500px; border: 1px solid #eee">
<el-aside width="200px" style="background-color: rgb(238, 241, 246)">
    <el-menu :default-openeds="['1', '2']">
      <el-submenu index="1">
        <template slot="title"><i class="el-icon-menu"></i>员工模块</template>
          <router-link  to="/Pview"><el-button index="1-1">查询</el-button></router-link>

      </el-submenu>
      <el-submenu index="2">
        <template slot="title"><i class="el-icon-menu"></i>部门模块</template>
          <router-link  to="/Dview"><el-button index="2-1">查询</el-button></router-link>

      </el-submenu>
    </el-menu>
  </el-aside>
  
  <el-container>
    
    <el-header style="text-align: right; font-size: 12px">
      <el-dropdown>
        <i class="el-icon-setting" style="margin-right: 15px"></i>
        <el-dropdown-menu slot="dropdown">
          <router-link to="/password"><el-dropdown-item>修改密码</el-dropdown-item></router-link>
          <router-link to="/"><el-dropdown-item>退出</el-dropdown-item></router-link>
        </el-dropdown-menu>
      </el-dropdown>
      <span>普通用户</span>
 
    </el-header>

    <router-view></router-view>

  </el-container>
</el-container>
</template>

<script>

</script>


<style>
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }
  
  .el-aside {
    color: #333;
  }
</style>
