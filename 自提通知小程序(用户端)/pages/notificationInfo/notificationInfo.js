// pages/packageInfo/packageInfo.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    package_id:0,
    name:"",
    time:"",
    content:"请于半小时之内取走物资",
    location:""
  },

  dealAdd: function(){
    var id = this.data.package_id
    wx.navigateTo({
      url: '/pages/dealAdd/dealAdd?package_id=' + id,
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      package_id: options.package_id,
      name: options.package_name,
      time: options.time,
      location: options.location
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