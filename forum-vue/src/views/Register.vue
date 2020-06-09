<template>
  <div class="registerForm">
    <el-form :model="registerForm" ref="registerForm" :rules="rules">
      <h3>请登录!</h3>
      <el-form-item label="用户名" prop="username">
        <el-input type="text" v-model="registerForm.username" auto-complete="false"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input type="password" v-model="registerForm.password" autocomplete="new-password"></el-input>
      </el-form-item>
      <el-form-item label="确认密码" prop="checkPassword">
        <el-input type="checkPassword" v-model="registerForm.checkPassword" autocomplete="new-password"></el-input>
      </el-form-item>
      <el-button type="primary" @click="onLogin">注册</el-button>
    </el-form>
  </div>
</template>
<script>
import { post, postJson } from "../utils/api";
import axios from "axios";
import { Message } from "element-ui";
export default {
  name: "Register",
  data() {
    return {
      registerForm: {
        username: "",
        password: ""
      },
      rules: {
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" }
        ],
        password: [{ required: true, message: "请输入密码", trigger: "blur" }],
        checkPassword: [{ required: true, message: "请输入确认密码", trigger: "blur" }]
      }
    };
  },
  methods: {
    onLogin() {
      this.$refs.registerForm.validate(valid => {
        if (valid) {
          postJson("/register", this.registerForm).then(res => {
            if (res.code == 0) {
              this.$router.replace("/");
            } else {
              this.$message.error(res.msg);
            }
          });
        } else {
          this.$message.error("请输入用户名或密码");
          return false;
        }
      });
    }
  }
};
</script>
<style scoped>
.registerForm {
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