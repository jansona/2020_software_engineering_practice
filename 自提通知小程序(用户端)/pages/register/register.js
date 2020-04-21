// pages/register/register.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
      username:"",
      password1:'',
      password2: ""
  },

  /**
   * 输入发生改变事件
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
   * 下一步按钮点击操作
   * @param {事件参数} e 
   */
  nextTap: function(e){
    var name = this.data.username.replace(/(^s*)|(s*$)/g, "");
    var pass1 = this.data.password1.replace(/(^s*)|(s*$)/g, "");
    var pass2 = this.data.password2.replace(/(^s*)|(s*$)/g, "");
      if(name.length < 3 )
      {
          wx.showModal({
            title: "提示",
            content: '用户名长度至少为3(不含空格)',
            showCancel: false,
            success(res){}
          })
      }
      if(pass1.length < 8 )
      {
          wx.showModal({
            title: "提示",
            content: '密码长度至少为8(不含空格)',
            showCancel: false,
            success(res){}
          })
      }
      if(pass1 != pass2 )
      {
          wx.showModal({
            title: "提示",
            content: '前后密码输入不一致',
            showCancel: false,
            success(res){}
          })
      }
      if(name.length >= 3 && pass1.length >= 8 && pass1 == pass2)
      {
        wx.navigateTo({
          url: '/pages/userEdit/userEdit?type=1&name='+name+"&pass="+pass1,
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