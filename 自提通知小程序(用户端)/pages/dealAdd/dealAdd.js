// pages / dealAdd / dealAdd.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    max: 300, //限制最大输入字符数
    min: 10, //限制最小输入字符数
    disable: true,
    currentWordNumber: 0,
    deal_package:-1,
    deal_type:-1,
    deal_content:"",
    radioItems: [
      {name: '延迟取货', value: 0, checked: true},
      {name: '送货上门', value: 1}
    ],
  },

  //单选框变化
  radioChange: function (e) {
    var radioItems = this.data.radioItems;
    for (var i = 0, len = radioItems.length; i < len; ++i) {
        radioItems[i].checked = radioItems[i].value == e.detail.value;
    }

    this.setData({
        radioItems: radioItems,
        deal_type: e.detail.value
    });
},

  //获取文本区域输入长度
  getValueLength: function (e) {
    let value = e.detail.value
    let len = parseInt(value.length)
    //最少字数限制
    if (len <= this.data.min)
      this.setData({
        disable: true
      })
    else if (len > this.data.min)
      this.setData({
        disable: false
      })
    //最多字数限制
    if (len > 300) return;
    this.setData({
      currentWordNumber: len //当前字数 
    })
  },
  //文本区失去焦点时的操作
  bindTextAreaBlur: function (e) {
    this.setData({
      deal_content: e.detail.value
    })

  },
  
  submitForm:function(e) {
    if (!this.data.currentWordNumber >= 10) {
      wx.showToast({
        title: '字数不能少于十个字',
        icon: "none",
        duration: 1000,
      })
    } else {
      wx.showToast({
        title: '校验通过'
      })
    }
  },


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      deal_package:options
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
