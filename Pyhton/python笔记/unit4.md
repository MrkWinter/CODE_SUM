## 第四章

### 函数进阶

* 函数多返回值

  1. 介绍 

     python  支持多返回值

  2. 语法

     ```python
     def 函数():
     return 返回值1,返回值2
     
     x , y  = 函数()
     # 注意 返回值一一对应 返回值可以是多种类型
     ```

* 函数多种传参方式

  1. 位置参数

     根据传入参数位置决定对应传入参数

  2. 关键字参数

     ```python
     def usr_info(name,age,gender):
     
     # 调用
     user_info(name="小明",gender = "男",age = 23)
     # 关键字参数可以不按参数定义顺序传参
     # 注意 位置参数和关键字参数可以混用 但位置参数必须放在最前面
     ```

  3. 缺省参数

     ```python
     def usr_info(name,age,gender = "男"):
     #gender 为默认参数
     # gender可传可不传 不传默认为男
     user_info("小例",12)
     #默认参数必须在最后
     ```

  4. 不定长参数 (可变参数)

     ```python
     # 类型1 位置传递的不定长参数
     def usr_info(*arges):
        args使用时按元组使用
     user_info('tom','12') 
     # 类型2 关键字传递的不定长参数
     def usr_info(**kwargs):
        kwargs使用时按字典使用
     user_info('tom':'12',"liming":1) 
     ```

* 匿名函数

  1. 函数作为参数传入

     ```python
     def computer(x ,y):
         return x+y
     def test_func(compute):
         result = cumpute(1,2)
         print(result)
     # 函数作为参数传递 (执行逻辑的传递)
     test_func(cumputer)
     ```

  2. lambda匿名函数 

     ```python
     lambda 传入参数: 函数体 (一行代码)
     函数体只能写一行代码  直接return函数体中的内容
      -- 如
     test_func(lambda x , y : x + y)
      括号中的函数只能使用一次 
     ```
  
* isinstance()函数

  python中可以使用isinstance(对象1，类名) 来判定对象1是否为某类的实例 如

  ```python
  class MyClass:
      pass
  
  obj = MyClass()
  
  if isinstance(obj, MyClass):
      print("obj is an instance of MyClass")
  else:
      print("obj is not an instance of MyClass")
  
  ```

### python文件操作

* 文件的编码

  内容和二进制直接的转换逻辑 -- 编码

* 文件的读取

  1. 文件操作的作用

     打开 读写 关闭  -- 记录数据

  2. 文件的打开 读取 关闭

     ```python
     # 1. 打开open()
     open(文件路径,mode,encoding)
     # 注意 encoding的顺序不是第3位 encoding 要使用关键字参数指定 
     mode：r(默认)只读   
           w写 覆盖写 无文件则创建文件 使用覆盖模式
           a写 追加写 无文件则创建文件 使用追加模式
     f = open("D:/test.text","r",encoding = "utf-8")
     f为文件对象
     
     # 2. read() readlines() readline()方法
     str = f.read(num)  # 读取文件中nums长度的数据 单位是字节 如果没有传入num 默认读取文件中所有内容 
     str_list = f.readlines() # 按照行的方式把整个文件中的内容进行一次读取 并且返回的是一个列表 其中的每一行数据为一个元素 
     str = f.readline() # 读取一行数据返回
     
      -- 注意： 程序中多次read 或readlines 会使文件指针后移 下次读取时会从指针处读取
     
     可以使用for循环直接遍历文件每一行内容
     for line in f
      print(line) 
     每次遍历得到文件对象中的一行数据
     
     # 3 close() 关闭文件对象
     f.close  -- 解除文件的占用
     
     # 4.with open(文件路径,mode,encoding) as f (with open(..) as 文件对象名 为打开方式  采用open()方法打开 指定文件对象名接收 该打开方法会在读取文件内容完成后自动关闭文件对象 解除对文件的占用)
     with open("D:/test.text","r",encoding = "utf-8") as f
     ```

     ![image-20230919155714671](img\image-20230919155714671.png)

* 文件的写入

  ```python
  # 1. 写入文件
  write(内容)
  # 2. 刷新写入硬盘
  flush()
  
  -- 例
  f = open("D:/test.txt","w",enconing = "utf_8")
  f.write("hello,world")
  f.flush()
  f.close
  # close方法内置flush()功能
  ```

* 文件的追加

  open   w替换成a模式  追加模式是文件尾部追加