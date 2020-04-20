// pages/dealList/dealList.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    dealList:[
      {
        deal_id:1,
        deal_ispass: -1,
        deal_type:0,
        deal_time:"2020/01/01 12:01",
        deal_content:"延迟一小时取货",
        deal_response:""
      },
      {
        deal_id:2,
        deal_ispass: 0,
        deal_type:1,
        deal_time:"2020/02/02 12:02",
        deal_content:"两点送货上门",
        deal_response:"人手不够"
      },
      {
        deal_id:3,
        deal_ispass: 1,
        deal_type:0,
        deal_time:"2020/03/03 12:03",
        deal_content:"延迟三小时取货",
        deal_response:"将为您延迟三个小时"
      },
      {
        deal_id:4,
        deal_ispass: 0,
        deal_type:1,
        deal_time:"2020/04/04 12:04",
        deal_content:"四点送货上门",
        deal_response:""
      },
  ]
  },

  //总页数
  pagesTotal:1,

  viewTap:function(event){
    var content = event.currentTarget.dataset.value.deal_content;
    var type = event.currentTarget.dataset.value.deal_type;
    var time = event.currentTarget.dataset.value.deal_time;
    var response = event.currentTarget.dataset.value.deal_response;
    var ispass = event.currentTarget.dataset.value.deal_ispass;
    var state = "未处理";
    if(ispass == 0)
      state = "未通过";
    else if(ispass == 1)
      state = "已通过"  
    wx.navigateTo({
      url: '/pages/dealInfo/dealInfo?content='+content+'&type ='+type+'&time='+time
      +'&response='+response+'&state='+state,
    })
  },
  
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