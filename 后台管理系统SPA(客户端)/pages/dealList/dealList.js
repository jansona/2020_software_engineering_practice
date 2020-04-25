// pages/dealList/dealList.js

import {request}  from "../../utils/request.js";

Page({

  /**
   * 页面的初始数据
   */
  data: {
    dealList:[],
    ispass: 1,
    currentPage:1,
    pagesTotal:1,
  },

  //总页数

  viewTap:function(e){
    wx.navigateTo({
      url: '/pages/dealInfo/dealInfo?item=' + encodeURIComponent(JSON.stringify(e.currentTarget.dataset.value))
    })
  },
  
  changeTabs: function(e){
    console.log(e)
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    request({
      url: "/deal/list",
      method:"POST",
      data: {
        page: this.data.currentPage,
        dealIspass: this.data.ispass
      },
      header: {
        "Cookie": getApp().globalData.cookie,
        "content-type": "application/x-www-form-urlencoded"
      }
    }).then(res => {
      if (res.data.code == 200) {
        this.setData({
          dealList: res.data.content
        })
      } else { //错误信息提示
        wx.showModal({
          title: "提示",
          content: res.data.message,
          showCancel: false,
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