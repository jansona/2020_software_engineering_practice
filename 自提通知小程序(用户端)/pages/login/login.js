// pages/login/login.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    username:"",
    password:""
  },

  /**
   * 输入发生变化
   * @param {事件参数} e 
   */
  inputChange: function(e){
    const {
      field
    } = e.currentTarget.dataset;
    this.setData({
      [`${field}`]: e.detail.value
    });
  },

  /**
   * 登录按钮点击操作
   * @param {事件参数} e 
   */
  loginTap: function(e){
      var name = this.data.username.replace(/(^s*)|(s*$)/g, "");
      var pass = this.data.password.replace(/(^s*)|(s*$)/g, "");
      if(name.length < 3 )
      {
          wx.showModal({
            title: "提示",
            content: '用户名长度至少为3(不含空格)',
            showCancel: false,
            success(res){}
          })
      }
      if(pass.length < 8 )
      {
          wx.showModal({
            title: "提示",
            content: '密码长度至少为8(不含空格)',
            showCancel: false,
            success(res){}
          })
      }
      if(name.length >= 3 && pass.length >= 8)
      {
          //登录操作
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