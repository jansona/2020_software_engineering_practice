<template>
  <el-form :model="loginForm" :rules="loginRule" ref="loginForm" label-position="left" label-width="0px" class="demo-ruleForm login-container">
    <h3 class="title">自提智能管理系统登录</h3>
    <el-form-item prop="account">
      <el-input type="text" v-model="loginForm.account" auto-complete="off" placeholder="账号"></el-input>
    </el-form-item>
    <el-form-item prop="checkPass">
      <el-input type="password" v-model="loginForm.checkPass" auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <el-checkbox v-model="checked" checked class="remember">记住密码</el-checkbox>
    <el-form-item style="width:100%;">
      <el-button type="primary" style="width:100%;" @click.native.prevent="handleLogin" :loading="logining">登录</el-button>
      <el-button type="text" size="medium" @click.native.prevent="route2register">注册新账号</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
  import { requestLogin } from '../api/api';
  //import NProgress from 'nprogress'
  export default {
    data() {
      return {
        logining: false,
        loginForm: {
          account: '1',
          checkPass: '123456'
        },
        loginRule: {
          account: [
            { required: true, message: '请输入账号', trigger: 'blur' },
            //{ validator: validaePass }
          ],
          checkPass: [
            { required: true, message: '请输入密码', trigger: 'blur' },
            //{ validator: validaePass2 }
          ]
        },
        checked: true,
      };
    },
    methods: {
      route2register() {
        this.$router.push({ path: '/register' });
      },
      handleLogin(ev) {
        var _this = this;
        this.$refs.loginForm.validate((valid) => {
          if (valid) {
            this.logining = true;
            var loginParams = { id: this.loginForm.account, password: this.loginForm.checkPass };
            requestLogin(loginParams).then(res => {
              this.logining = false;
              let code = res.data.code;
              debugger;
              if (code !== 200) {
                this.$message({
                  type: 'error',
                  message: '账号或密码错误',
                });
              } else {
                // sessionStorage.setItem('user', JSON.stringify(user));
                sessionStorage.setItem('user',
                JSON.stringify({
                  communityId: res.data.content.communityId,
                  username: res.data.content.communityName,
                  password: undefined,
                  avatar: 'https://avatars3.githubusercontent.com/u/24268919?s=60&v=4',
                  name: res.data.content.communityName,
                }));
                this.$router.push({ path: '/arrangements' });
              }
            });
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      }
    }
  }

</script>

<style lang="scss" scoped>
  .login-container {
    /*box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.06), 0 1px 0px 0 rgba(0, 0, 0, 0.02);*/
    -webkit-border-radius: 5px;
    border-radius: 5px;
    -moz-border-radius: 5px;
    background-clip: padding-box;
    margin: 180px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
    .title {
      margin: 0px auto 40px auto;
      text-align: center;
      color: #505458;
    }
    .remember {
      margin: 0px 0px 35px 0px;
    }
  }
</style>