// pages/userInfo/userInfo.js
// Page({

//   /**
//    * 页面的初始数据
//    */
//   data: {

//   },

//   /**
//    * 生命周期函数--监听页面加载
//    */
//   onLoad: function (options) {

//   },

//   /**
//    * 生命周期函数--监听页面初次渲染完成
//    */
//   onReady: function () {

//   },

//   /**
//    * 生命周期函数--监听页面显示
//    */
//   onShow: function () {

//   },

//   /**
//    * 生命周期函数--监听页面隐藏
//    */
//   onHide: function () {

//   },

//   /**
//    * 生命周期函数--监听页面卸载
//    */
//   onUnload: function () {

//   },

//   /**
//    * 页面相关事件处理函数--监听用户下拉动作
//    */
//   onPullDownRefresh: function () {

//   },

//   /**
//    * 页面上拉触底事件的处理函数
//    */
//   onReachBottom: function () {

//   },

//   /**
//    * 用户点击右上角分享
//    */
//   onShareAppMessage: function () {

//   }
// })

Component({
  data: {
    showTopTips: false,
    starttime: "12:00",
    endtime: "13:00",
    staytime: 3600,
    communities: ["中国", "美国", "英国"],
    communityIndex: 0,
    formData: {

    },
    rules: [{
      name: 'name',
      rules: {
        required: true,
        message: '请输入姓名'
      },
    }, {
      name: 'address',
      rules: {
        required: true,
        message: 'address必填'
      },
    }, ]
  },
  methods: {
    formInputChange(e) {
      const {
        field
      } = e.currentTarget.dataset
      this.setData({
        [`formData.${field}`]: e.detail.value
      })
    },
    bindStartTimeChange: function (e) {
      this.setData({
        starttime: e.detail.value,
        [`formData.starttime`]: e.detail.value
      })
    },
    bindEndTimeChange: function (e) {
      this.setData({
        endtime: e.detail.value,
      })
    },
    bindCommunityChange: function (e) {
      console.log('picker community 发生选择改变，携带值为', e.detail.value);

      this.setData({
        communityIndex: e.detail.value
      })
    },
    submitForm() {
      this.selectComponent('#form').validate((valid, errors) => {
        console.log('valid', valid, errors)
        if (!valid) {
          const firstError = Object.keys(errors)
          if (firstError.length) {
            this.setData({
              error: errors[firstError[0]].message
            })

          }
        } else {
          var that = this;
          var time1 = new Date("2020/04/13 " + that.data.starttime);
          var time2 = new Date("2020/04/13 " + that.data.endtime);
          var seconds = (time2.getTime() - time1.getTime()) / 1000;
          console.log(seconds)
          this.setData({
            staytime: seconds
          })
          wx.showToast({
            title: '校验通过'
          })
        }
      })
      // this.selectComponent('#form').validateField('mobile', (valid, errors) => {
      //     console.log('valid', valid, errors)
      // })
    }

  }
});