<template>
  <div>
    <el-container>
      <el-header class="home-header">
        <div class="header-title">Slump</div>
        <el-dropdown>
          <span class="el-dropdown-link">
            {{user.nickname}}
            <i class="el-icon-arrow-down el-icon--right"></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>个人信息</el-dropdown-item>
            <el-dropdown-item>设置</el-dropdown-item>
            <el-dropdown-item>修改密码</el-dropdown-item>
            <el-dropdown-item divided>注销</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </el-header>
      <el-main></el-main>
      <el-footer></el-footer>
    </el-container>
  </div>
</template>
<script>
export default {
  name: 'Home',
  data() {
    return {
      user: JSON.parse(sessionStorage.getItem('user'))
    }
  }
}
</script>
<style scoped>
.home-header {
  background-color: #0099ff;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 15px;
  box-sizing: border-box;
  box-shadow: 0 0 25px #cac6c6;
}
.el-dropdown-link {
  cursor: pointer;
}
.el-icon-arrow-down {
  font-size: 12px;
}
</style>