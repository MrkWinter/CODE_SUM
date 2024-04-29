### JQuery动画

* 常用动画方法

  1. 元素显示和隐藏

     show() hide() toggle() 方法

     hide(动画速度, 动画效果，回调函数)  隐藏元素 

     show(动画速度, 动画效果，回调函数)  显示元素

     toggle(动画速度, 动画效果，回调函数)  切换隐藏状态

  2. 元素的淡入和淡出

     fadeIn() fadeout() fadeTo() fadeToggle() 方法

     fadeIn(动画速度)  淡入 显示

     fadeout(动画速度)  淡出 隐藏

     fadeToggle(动画速度) 切换淡入(显示) 淡出(隐藏)

     fadeTo(动画速度，透明度) 淡到 指定元素到一定透明度 可以增加 或 减小

  3. 元素上滑下滑

     slidDown() slidUp() 方法

     slidDown(速度)  从上到下显示

     siidUp(速度) 从下向上显示 

* 自定动画

  1. animate() 方法

* 停止动画

  1. stop(stopAll goToEnd)

     第一个参数表示清除动画队列 是否停止所有

     第二个参数停止动画时当前动画是否完成

### Ajax

* Ajax简介
  1. 获取服务器数据
  2. 异步的界面数据获取与加载
  3. 动态获取数据显示
  
* AJax使用
  1. lode(url data 回调函数)  方法
  2. get(url data function(接收到的data) dataType)
  3. post(url data function(接收到的data) dataType)
  
* js数据格式

  1. xml数据格式

     xml数据为标签格式

     get方法获取xml数据 获取到的是文本形式的xml数据

  2. json数据格式

     key value数据格式 对象数组 

     可以使用for( var key int data[i])  data\[i][key] 来遍历json数组数据

  3. text数据格式

     text数据格式需要转换成json 或 xml text 存文本不支持

  4. 获取json数据

     JSON.parse(textData)可以将text字符串格式的数据转换成json数据

* $.ajax() 请求

  1. $.ajax(url,method, data,success:function() {},error:function() {},dataType)
  2. `url`：请求的 URL 地址。
  3. `method`：请求的方法，如 GET、POST、PUT、DELETE 等。
  4. `data`：发送到服务器的数据，可以是对象、字符串或数组。
  5. `success`：请求成功时的回调函数，参数为服务器返回的数据。
  6. `error`：请求失败时的回调函数，参数为错误信息

* Ajax相关事件 