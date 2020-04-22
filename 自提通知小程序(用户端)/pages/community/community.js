// pages/community/community.js

import {
  request
} from "../../utils/request.js";

Page({

  /**
   * 页面的初始数据
   */
  data: {
    time: "2020-04-21 12:55:03",
    ispass: -1,
    community_name: '',
    communities: [],
    results: []
  },

  /**
   * 清除搜索内容
   */
  searchClear: function() {
    this.setData({
      results: this.data.communities
    })
  },


  /**
   * 进行加入集群申请
   * @param {*} e 
   */
  apply: function(e){
    var id = e.currentTarget.dataset.value.communityId;
    var name = e.currentTarget.dataset.value.communityName;
    wx.showModal({
      title: "提示",
      content: "您将要加入"+name,
      success(res) {
        if (res.confirm) {
          request({
            url: "/application/add",
            method: "POST",
          }).then(res => {
            if (res.data.code == 200) {
              this.setData({
                communities: res.data.content,
                results: res.data.content
              })
            } else { //错误信息提示
              wx.showModal({
                title: "提示",
                content: result.data.message,
                showCancel: false,
                success(res) {}
              })
            }
          })
        } else if (res.cancel) {}
      }
    })
  },

  /**
   * 当搜索框内容发生变化时，进行搜索
   * @param {事件参数，传递搜索框的值} e 
   */
  textChange: function(e) {
    var searchValue = e.detail.value.replace(/(^s*)|(s*$)/g, "");
    var result = this.data.communities.filter(item => item.communityName.search(searchValue) != -1);
    this.setData({
      results: result
    })
  },


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    //判断用户是否已经加入集群，若没有加入就请求集群列表数据
    if (getApp().globalData.user.community != "") {
      this.setData({
        community_name: getApp().globalData.user.community
      })
    } else {
      request({
        url: "/community/list",
        method: "POST",
      }).then(res => {
        if (res.data.code == 200) {
          this.setData({
            communities: res.data.content,
            results: res.data.content
          })
        } else { //错误信息提示
          wx.showModal({
            title: "提示",
            content: result.data.message,
            showCancel: false,
            success(res) {}
          })
        }
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