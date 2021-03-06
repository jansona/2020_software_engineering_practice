//promise方法发送请求
export const request=(params)=>{
  //定义公共url
  const baseUrl = "https://www.liyiersan.club:8443"
  return new Promise((resolve, reject)=>{
    wx.request({
      ...params,
      url:baseUrl+params.url,
      success:(res)=>{
        if(!getApp().globalData.cookie && res.cookies[0] || getApp().globalData.reLogin && res.cookies[0]){
          getApp().globalData.cookie = res.cookies[0].split(";")[0]
        }
        resolve(res);
      },
      fail:(err)=>{
        wx.showModal({
          title: "提示",
          content: '哎呀，网络出现了错误',
          showCancel: false,
        })
        reject(err);
      },
      complete:()=>{
        if(getApp().globalData.reLogin){
          getApp().globalData.reLogin = false
        }
      }
    })
  })
}