<template>
  <div>
    <el-container>
      <el-header class="home-header">
        <h1 class="header-title">
          <a href="#" style="text-decoration:none">Slump</a>
        </h1>
        <el-menu class='main-menu' :default-active="activeIndex" mode="horizontal" background-color="#0099ff"
          text-color="#000000" active-text-color="#cac6c6" @open="openSubMenu" @select="openSubMenu">
          <el-menu-item index='1'>
            主页
          </el-menu-item>
          <el-menu-item index='2'>
            分享
          </el-menu-item>
          <el-menu-item index='3'>
            博客
          </el-menu-item>
          <el-submenu index='4'>
            <template slot="title">源码</template>
            <el-menu-item>Github</el-menu-item>
            <el-menu-item>Gitee</el-menu-item>
          </el-submenu>
        </el-menu>
        <div v-if="user">
          <el-dropdown>
            <span class="el-dropdown-link">
              <el-avatar class="avatar" :size="48" :src="user.avatarUrl"></el-avatar>
              {{user.nickname}}
              <i class="el-icon-arrow-down el-icon--right"></i>
            </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>个人信息</el-dropdown-item>
              <el-dropdown-item>设置</el-dropdown-item>
              <el-dropdown-item>修改密码</el-dropdown-item>
              <el-dropdown-item divided @click.native="logout">注销</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
        <div v-else>
          <a @click="toLogin">请登录</a>
        </div>
      </el-header>
      <el-main>
        <router-view />
      </el-main>
      <el-footer></el-footer>
    </el-container>
  </div>
</template>
<script>
  export default {
    name: "Home",
    data() {
      return {
        user: JSON.parse(sessionStorage.getItem("user")),
        activeIndex: '1'
      };
    },
    methods: {
      logout() {
        sessionStorage.removeItem("user");
        this.$router.replace("/login");
      },
      toLogin() {
        this.$router.replace("/login");
      },
      openSubMenu(index,indexPath) {
        console.log('open');
      }
    }
  };
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
    padding: 0% 20%;
  }

  .el-dropdown-link {
    cursor: pointer;
  }

  .el-icon-arrow-down {
    font-size: 12px;
  }

  .el-dropdown-link {
    display: flex;
    align-items: center;
    margin-right: 8px;
  }

  .el-dropdown-link .avatar {
    margin-right: 8px;
  }

  .main-menu {
    margin-right: 40%;
    background-color: #0099ff;
  }
</style>
<style>
  .el-menu--horizontal .el-menu--popup  {
    background: #ffffff !important;
  }
  .el-menu--horizontal .el-menu--popup .el-menu-item {
    background: #ffffff !important;
  }
  .el-menu--horizontal .el-menu--popup .el-menu-item:hover {
    background: #cac6c6 !important;
  }
  .el-submenu__icon-arrow {
    color:black !important;
  }
</style>