// pages/community/community.js

import {
  request
} from "../../utils/request.js";

Page({

  /**
   * 页面的初始数据
   */
  data: {
    time: "1970-01-01 00:00:00",
    communities: [],
    communityName: "",
    communityAddress:"",
    ispass: -1,
    results: [],
    addresses: [],
    application: null,
    index: 0,
  },

  /**
   * 清除搜索内容，就是将搜索结果初始化
   */
  searchClear: function () {
    this.setData({
      results: this.data.communities
    })
  },


  /**
   * 进行加入集群申请
   * @param {*} e 
   */
  apply: function (e) {
    var id = e.currentTarget.dataset.value.communityId;
    var name = e.currentTarget.dataset.value.communityName;
    wx.showModal({
      title: "提示",
      content: "您将要加入" + name,
      success(res) {
        if (res.confirm) {
          //用户点击确定后，向服务器发送请求加入集群
          request({
            url: "/application/add",
            data: {
              applicationCommunity: id,
              applicationUser: getApp().globalData.user.userId
            },
            method: "POST",
            header: {
              "Cookie": getApp().globalData.cookie
            },
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
      }
    })
  },

  /**
   * 当搜索框内容发生变化时，进行搜索
   * @param {事件参数，传递搜索框的值} e 
   */
  textChange: function (e) {
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
    //查看当前用户下有没有对应的application，如有，取出相关信息
    request({
      url: "/application/info",
      header: {
        "Cookie": getApp().globalData.cookie
      }
    }).then(res => {
      if (res.data.code == 200) {
        this.setData({
          application: res.data.content
        })
      } else { //错误信息提示
        wx.showModal({
          title: "提示",
          content: res.data.message,
          showCancel: false,
          success(res) {}
        })
      }
      if (this.data.application) {
        this.setData({
            time:this.data.application.key.applicationTime,
            communityName: this.data.application.value.communityName,
            ispass: this.data.application.key.applicationIspass,
            communityAddress:this.data.application.value.communityAddress
        })
        
      }else{
        //如没有application，就获取集群列表
        request({
          url: "/community/list",
          method: "POST",
          header: {
            "content-type": "application/x-www-form-urlencoded",
            "Cookie": getApp().globalData.cookie
          }
        }).then(res => {
          if (res.data.code == 200) {
            this.setData({
              communities: res.data.content,
              results: res.data.content,
              addresses: [...new Set(res.data.content.map(item => item.communityAddress))] 
            })
          } else { //错误信息提示
            wx.showModal({
              title: "提示",
              content: res.data.message,
              showCancel: false,
              success(res) {}
            })
          }
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