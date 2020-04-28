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

  viewTap:function(e){
    wx.navigateTo({
      url: '/pages/dealInfo/dealInfo?item=' + encodeURIComponent(JSON.stringify(e.currentTarget.dataset.value))
    })
  },
  
  /**
   * 标签页切换
   * @param {*} e 
   */
  changeTabs: function(e) {
    this.setData({
      ispass: 1-e.detail.currentIndex,
      currentPage:1,
    })
    this.getData(0);
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getData(0);
  },

  getData: function(e) {
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
        var data = [];
        if(e == 0){
          data = res.data.content;
        }else{
          data = [...this.data.dealList, ...res.data.content]
        }
        this.setData({
          dealList: data,
          pagesTotal: res.data.total
        })
      } else { //错误信息提示
        if(res.data.code == 400)
          this.setData({
            dealList: [],
            currentPage: 1,
            pagesTotal: 1
          })
        else{
          wx.showModal({
            title: "提示",
            content: res.data.message,
            showCancel: false,
          })
        }
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
    var current = this.data.currentPage
    var total = this.data.pagesTotal
    if(current<total){
      current++;
      this.setData({
        currentPage: current
      })
      this.getData(1);
    }else{
      wx.showToast({
        title: '啊哦，已经到底了',
        icon: 'none',
        duration: 1000
      })
    }
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})