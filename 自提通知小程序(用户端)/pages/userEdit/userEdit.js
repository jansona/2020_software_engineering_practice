// pages/userInfo/userInfo.js

import {
  request
} from "../../utils/request.js"

Page({

  /**
   * 页面的初始数据
   */
  data: {
    type: "",
    user: {},
    starttime: "00:00",
    endtime: "23:59",
    disable: true,
    stay: 0,
    url: "/user/edit",
    reUrl: "/pages/userInfo/userInfo"
  },

  /**
   * 当输入框内容发生变化时的事件
   * @param {包含输入框的内容}} e 
   */
  formInputChange(e) {
    const {
      field
    } = e.currentTarget.dataset
    //存入的数据要过滤空格
    this.setData({
      disable: false,
      [`user.${field}`]: e.detail.value.replace(/\s+/g, "")
    })
  },

  /**
   * timePicker的值发生变化时调用的函数
   * @param {包含时间选择器的值}} e 
   */
  timeChange: function (e) {
    const {
      field
    } = e.currentTarget.dataset
    this.setData({
      disable: false,
      [`${field}`]: e.detail.value
    })
  },

  /**
   * 用户点击确定按钮时，提交信息
   */
  submitForm: function () {
    var user = this.data.user;
    var name = user.userName;
    var address = user.userAddress;
    var idcard = user.userIdcard;
    var pass = user.userPassword;
    var phone = user.userPhone;
    //手机号的正则表达式
    var regPhone = /^1(3|4|5|7|8)\d{9}$/;
    //身份证号码的正则表达式
    var regIdcard = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
    if (name.length < 2) {
      wx.showModal({
        title: "提示",
        content: '用户名长度至少为2(不含空格)',
        showCancel: false,
      })
    } else if (address.length == 0) {
      wx.showModal({
        title: "提示",
        content: '地址格式不正确',
        showCancel: false,
      })
    } else if (phone.length != 11 || !regPhone.test(phone)) {
      wx.showModal({
        title: "提示",
        content: '手机号格式不正确',
        showCancel: false,
      })
    } else if (idcard.length != 18 || !regIdcard.test(idcard)) {
      wx.showModal({
        title: "提示",
        content: '身份证格式不正确',
        showCancel: false,
      })
    } else if (pass.length < 6) {
      wx.showModal({
        title: "提示",
        content: '密码长度至少为6(不含空格)',
        showCancel: false,
      })
    } else { //格式校验通过之后，先计算timeStay
      var time1 = new Date("2020/04/13 " + this.data.starttime);
      var time2 = new Date("2020/04/13 " + this.data.endtime);
      var seconds = (time2.getTime() - time1.getTime()) / 1000;
      this.setData({
        [`user.userTimeStay`]: seconds,
        [`user.userFavoriteStarttime`]: "1970-01-01 "+this.data.starttime+":46"
      })
        //向服务器发送请求
        request({
          url: this.data.url,
          data: user,
          method: "POST",
          header: {
            "Cookie": getApp().globalData.cookie
          }
        }).then(res => {
          //成功发送请求
          var code = res.data.code;
          if (code == 200) {
            wx.showToast({
              title: '操作成功',
              icon: 'success',
              duration: 1000
            })
            if(this.data.type == "1"){
                this.setData({
                  user:  res.data.content
                })
            }
            getApp().globalData.user = user;
            var reUrl = this.data.reUrl
            setTimeout(function () {
              wx.reLaunch({
                url: reUrl,
              })
            }, 1000)
          } else { //提示用户错误信息
            wx.showModal({
              title: "提示",
              content: res.data.message,
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
    this.setData({
      type: options.type
    })
    //type不为1说明是修改用户信息
    if (options.type != "1") {
      this.setData({
        starttime: options.start,
        endtime: options.end,
        user: getApp().globalData.user
      })
    } else {
      this.setData({
        [`user.userPhone`]: options.phone,
        [`user.userPassword`]: options.pass,
        url: "/user/create",
        reUrl: "/pages/index/index"
      })
    }
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