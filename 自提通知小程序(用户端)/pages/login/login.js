// pages/login/login.js

//导入发送请求的方法
import {
  request
} from "../../utils/request.js"

Page({

  /**
   * 页面的初始数据
   */
  data: {
    userphone: "",
    password: ""
  },

  /**
   * 输入发生变化
   * @param {事件参数} e 
   */
  inputChange: function (e) {
    const {
      field
    } = e.currentTarget.dataset;
    //存入data中的字符串要过滤掉空格
    this.setData({
      [`${field}`]: e.detail.value.replace(/\s+/g, "")
    });
  },

  /**
   * 登录按钮点击操作
   * @param {事件参数} e 
   */
  loginTap: function (e) {
    var phone = this.data.userphone;
    var pass = this.data.password;
    var reg = /^1(3|4|5|7|8)\d{9}$/;
    //对输入的手机号和密码进行格式校验
    if ( phone.length != 11 || !reg.test(phone)) {
      wx.showModal({
        title: "提示",
        content: '手机号格式不正确',
        showCancel: false,
      })
    }else if (pass.length < 6) {
      wx.showModal({
        title: "提示",
        content: '密码长度至少为6(不含空格)',
        showCancel: false,
      })
    }else {
      //登录操作
      request({
        url: "/user/login",
        data: {
          phone: this.data.userphone,
          password: this.data.password,
        },
        method: "POST",
        header: {
          "content-type": "application/x-www-form-urlencoded"
        }
      }).then(result => {
        //成功发送请求
        var code = result.data.code;
        if (code == 200) {
          wx.showToast({
            title: '登录成功',
            icon: 'success',
            duration: 1000
          })
          getApp().globalData.user = result.data.content;
          //登录成功后一秒钟跳转至主页面
          setTimeout(function () {
            wx.reLaunch({
              url: '/pages/index/index',
            })
          }, 1000)
        } else { //提示用户错误信息
          wx.showModal({
            title: "提示",
            content: result.data.message,
            showCancel: false,
          })
        }
      })
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})