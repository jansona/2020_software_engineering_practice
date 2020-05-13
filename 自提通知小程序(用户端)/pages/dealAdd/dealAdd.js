// pages / dealAdd / dealAdd.js

import {
  request
} from "../../utils/request.js";

Page({

  /**
   * 页面的初始数据
   */
  data: {
    max: 300, //限制最大输入字符数
    min: 10, //限制最小输入字符数
    disable: true,
    currentWordNumber: 0,
    deal_package: -1,
    deal_type: 0,
    deal_content: "",
    radioItems: [{
        name: '延迟取货',
        value: 0,
        checked: true
      },
      {
        name: '送货上门',
        value: 1
      }
    ],
  },

  //单选框变化
  radioChange: function (e) {
    var radioItems = this.data.radioItems;
    for (var i = 0, len = radioItems.length; i < len; ++i) {
      radioItems[i].checked = radioItems[i].value == e.detail.value;
    }
    this.setData({
      radioItems: radioItems,
      deal_type: e.detail.value
    });
  },

  //获取文本区域输入长度
  getValueLength: function (e) {
    let value = e.detail.value
    let len = parseInt(value.length)
    //最少字数限制
    if (len <= this.data.min)
      this.setData({
        disable: true,
        deal_content: value
      })
    else if (len > this.data.min)
      this.setData({
        disable: false,
        deal_content: value
      })
    //最多字数限制
    if (len > 300) return;
    this.setData({
      currentWordNumber: len //当前字数 
    })
  },

  submitForm: function (e) {
    if (!this.data.currentWordNumber >= 10) {
      wx.showModal({
        title: "提示",
        content: "最少输入十个字",
        showCancel: false
      })
    } else {
      request({
        url: "/deal/add",
        data: {
          dealPackage: this.data.deal_package,
          dealContent: this.data.deal_content,
          dealType: this.data.deal_type
        },
        method: "POST",
        header: {
          "Cookie": getApp().globalData.Cookie
        }
      }).then(result => {
        //成功发送请求
        var code = result.data.code;
        if (code == 200) {
          wx.showToast({
            title: '提交成功',
            icon: 'success',
            duration: 1000
          })
          setTimeout(function () {
            wx.navigateBack({
              delta: 1 
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
    this.setData({
      deal_package: options.package_id
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