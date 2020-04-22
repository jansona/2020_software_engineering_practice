// pages/userInfo/userInfo.js

import {request}  from "../../utils/request.js";

Page({

  /**
   * 页面的初始数据
   */
  data: {
    idcard:"",
    name:"",
    address:"",
    starttime: "",
    endtime: "",
    staytime: 0,
    community:""
  },

  btnTap: function(){
    wx.redirectTo({
      url: '/pages/userEdit/userEdit?idcard='+this.data.idcard+'&start='+this.data.starttime
      +'&end='+this.data.endtime+'&address='+this.data.address+'&name='+this.data.name+'&addr='+this.data.address,
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
      //获取个人信息
      request({
        url: "/user/login",
        data: {
          id: 1,
          password: this.data.password,
        },
        method: "POST",
        header: {
          "content-type": "application/x-www-form-urlencoded"
        }
      }).then(result => {
        var code = result.data.code;
        if (code == 200) {
          wx.showToast({
            title: '登录成功',
            icon: 'success',
            duration: 1000
          })
          getApp().globalData.user.name = this.data.username
          setTimeout(function () {
            wx.reLaunch({
              url: '/pages/index/index',
            })
          }, 1000)

        } else {
          wx.showModal({
            title: "提示",
            content: result.data.message,
            showCancel: false,
            success(res) {}
          })
        }
      })
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