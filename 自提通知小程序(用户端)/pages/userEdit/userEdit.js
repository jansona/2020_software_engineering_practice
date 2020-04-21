// pages/userInfo/userInfo.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    type: "",
    name_dis: false,
    user_name: "",
    user_address: "",
    user_idcard: "",
    user_favorite_starttime: "",
    endtime: "",
    disable: true,
    user_time_stay: 0,
    user_password:""
  },

  formInputChange(e) {
    const {
      field
    } = e.currentTarget.dataset
    this.setData({
      disable: false,
      [`${field}`]: e.detail.value
    })
  },
  bindStartTimeChange: function (e) {
    this.setData({
      disable: false,
      user_favorite_starttime: e.detail.value
    })
  },

  bindEndTimeChange: function (e) {
    this.setData({
      disable: false,
      endtime: e.detail.value,
    })
  },

  submitForm: function () {
    var name = this.data.user_name.replace(/(^s*)|(s*$)/g, "");
    var address = this.data.user_address.replace(/(^s*)|(s*$)/g, "");
    var idcard = this.data.user_idcard.replace(/(^s*)|(s*$)/g, "");
    if (name.length == 0 || address.length == 0 || idcard.length != 18) {
      wx.showToast({
        title: '输入不合法',
        icon: 'none'
      })
    } else {
      var that = this;
      var time1 = new Date("2020/04/13 " + that.data.user_favorite_starttime);
      var time2 = new Date("2020/04/13 " + that.data.endtime);
      var seconds = (time2.getTime() - time1.getTime()) / 1000;
      this.setData({
        user_time_stay: seconds
      })
      wx.showToast({
        title: '校验通过'
      })
    }
  },


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    //type为1说明是注册
    console.log(options.type)
    if (options.type == "1") {
      this.setData({
        type: "1",
        name_dis:true,
        user_password:options.pass,
        user_name:options.name
      })
    } else { //否则是修改用户个人信息
      this.setData({
        user_name: options.name,
        user_address: options.addr,
        user_idcard: options.idcard,
        user_favorite_starttime: options.start,
        endtime: options.end
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