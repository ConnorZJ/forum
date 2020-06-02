<template>
  <div class="loginForm">
    <el-form :model="loginForm" ref="loginForm" :rules="rules">
      <h3>请登录!</h3>
      <el-form-item label="用户名" prop="username">
        <el-input type="text" v-model="loginForm.username" auto-complete="false"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input type="password" v-model="loginForm.password" auto-complete="false"></el-input>
      </el-form-item>
      <el-button type="primary" @click="onLogin">登录</el-button>
    </el-form>
  </div>
</template>
<script>
import { post } from '../utils/api'
import axios from 'axios'
import { Message } from 'element-ui'
export default {
  name: 'Login',
  data() {
    return {
      loginForm: {
        username: '',
        password: ''
      },
      rules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' }
        ],
        password: [{ required: true, message: '请输入密码', trigger: 'blur' }]
      }
    }
  },
  methods: {
    onLogin() {
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          post('/doLogin', this.loginForm).then(res => {
            if (res.code == 0) {
              sessionStorage.setItem('user', JSON.stringify(res.data))
              this.$router.replace('/home')
            } else {
              this.$message.error('用户名或密码错误，请重试！')
            }
          })
        } else {
          this.$message.error('请输入用户名或密码')
          return false
        }
      })
    }
  }
}
</script>
<style scoped>
.loginForm {
  width: 50%;
  text-align: center;
  border-radius: 15px;
  background-clip: padding-box;
  margin: 180px auto;
  padding: 35px 35px 15px 35px;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}
</style>