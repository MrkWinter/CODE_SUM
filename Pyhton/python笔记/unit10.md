## 第十章

### python高阶技巧

* 闭包

  ```python
  # 闭包是为了解决全局变量数据数据不安全的问题  锁定外部变量
  # 两个函数嵌套定义 得到固定依赖变量的内部闭包函数
  -- 例
  def outer(name: str): 
      def inner(age: int):  # 闭包函数
          print(f"{name}今年{age}岁")
  
      return inner
  
  
  if __name__ == '__main__':
      i = outer("张三")  # i为inner的函数类型
      i(19)
      
      
  # 使用nolocal 修饰声明可以在闭包函数中修改外部锁定变量
  
  def outer(name: str):
      def inner(age: int):  # 闭包函数
          nonlocal name
          name = "李四"
          print(f"{name}今年{age}岁")
  
      return inner
  
  
  if __name__ == '__main__':
      i = outer("张三")  # i为inner的函数类型
      i(19)
      
  # 在外部变量定义后 除了闭包函数能修改 外部都无法修改
  
  # 缺点 闭包会持续占用内存
  ```

* 装饰器

  ```python
  # 装饰器也是一种闭包 其功能就是在不破坏目标函数原有的代码和功能的前提下 为目标函数增加新功能 -- 将目标函数作为闭包函数外部形参 闭包函数调用 得到装饰函数的功能
  -- 例
  def sleep(name: str):
      print("%s在碎觉" % name)
  
  
  def sleep1(name: str):
      print("%s在玩手机" % name)
  
  
  def outer(func):
      def inner(name):
          print("碎觉啦")
          func(name)
          print("起床啦")
  
      return inner
  
  
  if __name__ == '__main__':
      c = outer(sleep)
      c("王五")
      c = outer(sleep1)
      c("王二")
      
  -- 高阶调用
  
  def outer(func):
      def inner(name):
          print("碎觉啦")
          func("o")
          print("起床啦")
  
      return inner
  
  
  @outer
  def sleep(name: str):
      print("%s在碎觉" % name)
  
  
  if __name__ == '__main__':
      sleep("王五")  # 使用@外部函数名后 相当于运行下面代码
      # c = outer(sleep)
      # c("王五")
     	将sleep函数传入outer "王五"传入inner直接调用
      本质上调用的是inner
      
  # 注意 @outer后相当于 闭包函数和原函数建立联系 相当于使用sleep函数名 直接调用闭包函数  闭包函数的参数类型要和使用sleep函数时的参数列表一致
  ```

* 设计模式

  1. 单例模式

     ```python
     -- 文件 --
     class StrTools:
         pass
     
     
     str_tools = StrTools()
     -- 文件 --
     
     想要使用该类时
     from 文件名 import str_tools 即可
     ```

  2. 工厂模式

     ```python
     # 大批量生成类 通过工厂类返回类
     
     from typing import Union
     
     
     class Person:
         pass
     
     
     class Worker(Person):
         pass
     
     
     class Student(Person):
         pass
     
     
     class Teacher(Person):
         pass
     
     
     class Factory:
         def get_person(self, p_type: str) -> Union[Worker, Student, Teacher]:
             if p_type == "w":
                 return Worker()
             elif p_type == "s":
                 return Student()
             elif p_type == "t":
                 return Teacher()
     
     
     if __name__ == '__main__':
         f = Factory()
         worker = f.get_person("w")
     ```
     
     

* 多线程

  ![image-20230921210430255](img\image-20230921210430255.png)

  代码

  ```python
  # threading 模块实现多线程
  import time
  import threading
  
  
  def song(args: str):
      while True:
          print(args + "在唱歌")
          time.sleep(1)
  
  
  def dance(kwargs: str):
      while True:
          print(kwargs + "在跳舞")
          time.sleep(1)
  
  
  if __name__ == '__main__':
      t1 = threading.Thread(target=song, args=("张三",))
      t2 = threading.Thread(target=dance, kwargs={"kwargs": "李四"})
      t1.start()
      t2.start()
  ```

  

* 网络编程

  1. 服务端开发

     ![image-20230921211903295](img\image-20230921211903295.png)

     ![image-20230921212059096](img\image-20230921212059096.png)

     代码

     ```python
     # 七步
     # 导入socket模块
     import socket
     # 1. 创建Socket对象
     socket_server = socket.socket()
     # 2. 绑定ip地址和端口
     socket_server.bind("localhost", 8888)
     # 3. 监听端口
     socket_server.listen(1)  # listen 方法接收一个整形参数 表示接收的连接数量
     # 4. 得到连接对象 和客户端地址信息
     conn, address = socket_server.accept()  # 该方法返回的是一个二元元组
     print(f"接收到了客户端的连接 信息为{address}")
     while True:
         # 5. 使用连接对象 接收客户端发送的信息
         data: str = conn.recv(1024).decode('UTF-8')  # 得到的是字节数据 1024为缓存区 decode以utf-8解码成字符串
         print(f"客户端发来了信息{data}")
         # 6. 回复发送信息
         message = input("输入信息:")
         if message == "exit":
             break
         conn.send(message.encode("UTF-8"))  # 字符串编码成字节数组发送
     # 7. 关闭连接
     conn.close()
     socket_server.close()
     ```

  2. 客户端开发

     ![image-20230921214622684](img\image-20230921214622684.png)

     ![image-20230921214722351](img\image-20230921214722351.png)

     代码

     ```python
     # 五步
     # 引入模块
     import socket
     # 1. 获得套接字对象
     socket_client = socket.socket()
     # 2. 获取连接
     socket_client.connect(("localhost", 8888))
     while True:
         # 3. 发送消息
         message: str = input("请输入信息")
         if message == "exit":
             break
         socket_client.send(message.encode("UTF-8"))
         # 4. 接收信息
         receive: str = socket_client.recv(1024).decode("UTF-8")
         print(f"服务端发来了信息:{receive}")
     # 5. 关闭连接
     socket_client.close()
     ```

* 正则表达式

   ~ 正 ~ 则 ~表 ~ 达 ~式 ~ 

  ```python
  #  常用方法
  import re
  
  # 1. match()  从头开始匹配 匹配第一个命中项  开头必须相同才能找到
  str_ = "I love you iii ttt jjj kkk"
  result = re.match("I", str_)  # match方法返回的是 一个特殊类
  print(result.span())  # span() 返回匹配命中字符串的起始下标和结束下标
  print(result.group())  # group()返回匹配命中的字符串
  # 2. search() 全局匹配 匹配第一个命中项 在字符串中去寻找 只找第一个 
  
  # 3. findall() 全局匹配 匹配所有命中项  用于找到所有匹配项 findall使用时 如果正则表达式中有括号 那么会根据括号将每一个组匹配的内容得到 可以将正则表达式填上整体() 来整体匹配 或者直接使用match()
  
  ---- 元字符匹配 ------ 见图1
  . [] \d \D \s \S \w \W
  ? + * 
  {m,n}
  ^ $ \b \ \B
  | ()
  正则表达式中不要随意加空格 如限制长度的{1, 2} error
  ```

  **tip: python中   r"特殊字符串" 使特殊字符转义字符无效 按字面匹配  如 f"\d" 匹配所有数字**

  图1

  ![image-20230921221841809](img\image-20230921221841809.png)

* 递归