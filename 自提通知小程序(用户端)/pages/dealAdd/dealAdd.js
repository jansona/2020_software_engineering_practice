// pages / dealAdd / dealAdd.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    showTopTips: false,
    content: "",
    max: 300, //限制最大输入字符数
    min: 10, //限制最小输入字符数
    minWord: '', //提示语句
    disable: true,
    currentWordNumber: 0,
    package_id:0
  },

  //或者文本区域输入长度
  getValueLength: function (e) {
    let value = e.detail.value
    let len = parseInt(value.length)
    //最少字数限制
    if (len <= this.data.min)
      this.setData({
        minWord: "至少填写10个字哦～",
        disable: true
      })
    else if (len > this.data.min)
      this.setData({
        minWord: " ",
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
      content: e.detail.value
    })

  },
  submitForm() {
    if (!this.data.currentWordNumber >= 10) {
      wx.showToast({
        title: '字数不能少于十个字',
        icon: "none",
        duration: 1000,
      })
    } else {
      console.log(this.data.content);
      wx.showToast({
        title: '校验通过'
      })
    }
    // this.selectComponent('#form').validateField('mobile', (valid, errors) => {
    //     console.log('valid', valid, errors)
    // })
  },


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options)
    this.setData({
      package_id:options
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


// Component({
//   data: {
//       showTopTips: false,
//       content: "",
//       max: 300, //限制最大输入字符数
//       min: 10,  //限制最小输入字符数
//       minWord: '',//提示语句
//       disable: true,
//       currentWordNumber:0
//   },
//   methods: {
//     //或者文本区域输入长度
//     getValueLength: function (e) {
//       let value = e.detail.value
//       let len = parseInt(value.length)
//       //最少字数限制
//       if (len <= this.data.min)
//         this.setData({
//           minWord: "至少填写10个字哦～",
//           disable: true
//         })
//       else if (len > this.data.min)
//         this.setData({
//           minWord: " ",
//           disable: false
//         })
//       //最多字数限制
//       if (len > 300) return;
//       this.setData({
//         currentWordNumber: len //当前字数 
//       })
//     },
//     //文本区失去焦点时的操作
//     bindTextAreaBlur: function(e) {
//       this.setData({
//        content:e.detail.value
//       }) 

//    },   
//   submitForm() {     
//               if (!this.data.currentWordNumber >= 10) {
//                 wx.showToast({
//                   title: '字数不能少于十个字',
//                   icon :"none",
//                   duration: 1000,
//               })
//               } else {
//                   console.log(this.data.content);
//                   wx.showToast({
//                       title: '校验通过'
//                   })
//               }
//           // this.selectComponent('#form').validateField('mobile', (valid, errors) => {
//           //     console.log('valid', valid, errors)
//           // })
//       }

//   }
// });