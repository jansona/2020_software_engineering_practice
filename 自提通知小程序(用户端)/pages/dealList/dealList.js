// pages/dealList/dealList.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    dealList:[
      {
        deal_id:1,
        deal_isdone:true,
        deal_content:"第一条"
      },
      {
        deal_id:2,
        deal_isdone:true,
        deal_content:"第二条"
      },
      {
        deal_id:3,
        deal_isdone:true,
        deal_content:"第三条"
      },
      {
        deal_id:4,
        deal_isdone:true,
        deal_content:"第四条"
      },
  ]
  },

  //总页数
  pagesTotal:1,

  
  changeTabs: function(e){
    console.log(e)
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