// pages/userInfo/userInfo.js

import {
  request
} from "../../utils/request.js";

Page({

  /**
   * 页面的初始数据
   */
  data: {
    user: {},
    endtime: "",
    starttime: ""
  },

  /**
   * 修改按钮的点击事件
   * 传入的参数包括type(0表示修改，1表示注册)，开始时间和结束时间
   */
  btnTap: function () {
    wx.navigateTo({
      url: '/pages/userEdit/userEdit?type=0&start='+this.data.starttime+'&end='+this.data.endtime
    })
  },

  /**
   * 将2000-01-01 00:00:00形式的时间转化为Date对象
   * @param {*} date 
   */
  createDate: function (date) {
    var ps = date.split(" ");
    var pd = ps[0].split("-");
    var pt = ps.length > 1 ? ps[1].split(":") : [0, 0, 0];
    return new Date(pd[0], pd[1] - 1, pd[2], pt[0], pt[1], pt[2]);
  },

  /**
   * 获取数据
   */
  getData: function(){
    //获取个人信息
    this.setData({
      user: getApp().globalData.user
    })
    var time = getApp().globalData.user.userFavoriteStarttime;
    var start = this.createDate(time);
    var stay = getApp().globalData.user.userTimeStay;
    var end = new Date(start.getTime()+stay*1000);
    this.setData({
      starttime:start.toTimeString().substring(0,5),
      endtime:end.toTimeString().substring(0,5)
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getData()
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
    this.getData()
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