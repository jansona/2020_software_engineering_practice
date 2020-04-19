// pages/userInfo/userInfo.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    idcard:"421022199009092226",
    name:"李三",
    address:"三单元四号楼401",
    starttime: "12:00",
    endtime: "13:00",
    staytime: 3600,
    community:"中国"
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