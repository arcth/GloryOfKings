//index.js
//获取应用实例
const app = getApp()
var util = require('../../utils/util.js')

Page({
  data: {
    PageCur: 'basics',
    TabCur: 0,
    scrollLeft: 0,
    userInfo: {},
    hasUserInfo: false, 
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },

  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },

  onLoad: function () {
    console.log("1 app.globalData.userInfo =" + app.globalData.userInfo)
    
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse){
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
        
      }
    } else {
      
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
  }, 
  bindgetuserinfo: function(e) {
    
    app.globalData.userInfo = e.detail.userInfo
    
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    }) 

    var data = { 
      encryptedData: e.detail.encryptedData, 
      iv: e.detail.iv, 
      code: app.globalData.code,
      userinfo: JSON.stringify(e.detail.userInfo)
      } 
    util.commonAjax('/api/login', 0, data) 
      .then(function (resolve) {
        // 这里自然不用解释了，这是接口返回的参数  
        console.log("resolve.data.state =" + resolve.data.state)
        if (resolve.data.state === 0) {
          // 成功  
          console.log("openid =" + resolve.data.data.open_id)
          wx.setStorageSync('userInfo', resolve.data.data)
          // 新手们注意一下，记得把下面这个写到这里，有好处。  
          typeof cb == "function" && cb(app.globalData.userInfo)
          console.log("openid =" + app.globalData.userInfo.open_id)
        } else {
          // 失败  
        }
      })
  
    
  

    wx.redirectTo ({ 
      url: '../index/index' 
    })
  }
})
