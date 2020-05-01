<template>
  <el-form :model="registerForm" :rules="registerRule" ref="registerForm" label-position="left" label-width="0px" class="demo-ruleForm login-container">
    <h3 class="title">管理系统客户端账号注册（工作人员）</h3>
    <el-form-item prop="communityName">
      <el-input type="text" v-model="registerForm.communityName" auto-complete="off" placeholder="社区名称"></el-input>
    </el-form-item>
    <el-form-item prop="communityLocation">
      <el-input type="text" v-model="registerForm.communityLocation" auto-complete="off" placeholder="社区地址"></el-input>
    </el-form-item>
    <el-form-item prop="communityPassword">
      <el-input type="password" v-model="registerForm.communityPassword" auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item style="width:100%;">
      <el-button type="primary" style="width:100%;" @click.native.prevent="handleRegister" :loading="logining">注册</el-button>
      <el-button type="text" size="medium" @click.native.prevent="route2login">已有账号，登录</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
  import { requestRegister } from '../api/api';
  //import NProgress from 'nprogress'
  export default {
    data() {
      return {
        logining: false,
        registerForm: {
          communityName: '',
          communityLocation: '',
          communityPassword: ''
        },
        registerRule: {
          communityName: [
            { required: true, message: '请输入账号' },
            //{ validator: validaePass }
          ],
          communityLocation: [
            { required: true, message: '请输入地址', trigger: 'blur' },
          ],
          communityPassword: [
            { required: true, message: '请输入密码', trigger: 'blur' },
            //{ validator: validaePass2 }
          ]
        },
      };
    },
    methods: {
      route2login() {
          this.$router.push({ path: '/login' });
      },
      handleRegister(ev) {
        var _this = this;
        this.$refs.registerForm.validate((valid) => {
          if (valid) {
            this.logining = true;
            var registerParams = { name: this.registerForm.communityName,
                location: this.registerForm.communityLocation,
                password: this.registerForm.communityPassword };
            requestRegister(registerParams).then(res => {
              this.logining = false;
              let code = res.data.code;
              if (code !== 200) {
                this.$message({
                  type: 'error',
                  message: '该账号已被使用',
                });
              } else {
                sessionStorage.setItem('user',
                JSON.stringify({
                  communityId: res.data.content.communityId,
                  username: res.data.content.communityName,
                  password: undefined,
                  avatar: 'https://avatars3.githubusercontent.com/u/24268919?s=60&v=4',
                  name: res.data.content.communityName,
                }));
                this.$message({
                  type: 'success',
                  message: '注册成功，请配置相应属性',
                });
                this.$router.push({ path: '/community' });
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