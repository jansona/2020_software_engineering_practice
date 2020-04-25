// pages/register/register.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userphone: "",
    password1: "",
    password2: ""
  },

  /**
   * 输入发生改变事件
   * @param {事件参数} e 
   */
  inputChange: function (e) {
    const {
      field
    } = e.currentTarget.dataset;
    this.setData({
      [`${field}`]: e.detail.value.replace(/\s+/g, "")
    });
  },

  /**
   * 下一步按钮点击操作
   * @param {事件参数} e 
   */
  nextTap: function (e) {
    var phone = this.data.userphone;
    var pass1 = this.data.password1;
    var pass2 = this.data.password2;
    var reg = /^1(3|4|5|7|8)\d{9}$/;
    if (phone.length != 11 || !reg.test(phone)) {
      wx.showModal({
        title: "提示",
        content: '手机号码格式不对',
        showCancel: false,
      })
    }else if (pass1.length < 6) {
      wx.showModal({
        title: "提示",
        content: '密码长度至少为6(不含空格)',
        showCancel: false,
      })
    } else if (pass1 != pass2) {
      wx.showModal({
        title: "提示",
        content: '前后密码输入不一致',
        showCancel: false,
      })
    } else {
      wx.navigateTo({
        url: '/pages/userEdit/userEdit?type=1&phone=' + phone + "&pass=" + pass1,
      })
    }

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