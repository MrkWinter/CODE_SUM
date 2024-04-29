### 第二章

* 布尔类型和比较运算符

  1. 比较运算符 

     ![image-20230918141031075](img\image-20230918141031075.png)

  2. 真为True 假为False 比较运算返回的是布尔类型

* if语句的基本格式

  1. 语法

     ```python
     if 条件:
         条件成立执行代码    
     # python 是通过4缩进(规范为4)来判断归属的  异常缩进 无归属的代码会报错
     age = 19
     if age>18:
         print("已经成年")
     ```

* if else 语句

  1. 语法

     ```python
     if 条件:
         条件成立执行代码
     else:
         条件不成立执行代码 
         
     age = 19
     if age>18:
         print("已经成年")
     else:
         print("未成年")
     ```

* if elif else语句

  1. 语法

     ```python
     if 条件:
         条件成立执行代码
     elif 条件2:
     else:
         条件不成立执行代码 
         
     age = 19
     if age>18:
         print("已经成年")
     elif age == 18:
         print("刚成年")
     else:
         print("未成年")
     ```

* 判断语句的嵌套

  嵌套注意缩进

  ```python
  # tip 产生随机数 
  import random
  num = random.randint(1,10)
  ```

### 循环语句

* while循环基础语法

  1. 语法

     ```、
     while 条件:
         满足条件代码
     
     age = 12;
     while age>0:
         age-=age
         print(age)
         
         
     tip 
     print(end = "") 指明不换行
     python中好像没有 ++ -- 
     ```
     
     

* while循环嵌套使用

  注意缩进

* for循环语法

  1. 语法

     ```python
     for 临时变量 in 待处理数据集:
         取出数据集中一个元素后 执行的代码
         
     for i in "你好":
         print(i)
     ```

     **tip for循环无法定义循环条件 只能被动取出数据处理**

  2. range 语句

     上面待处理的数据集 指 序列类型 其内容可以一个个依次取出的一种类型 包括 字符串 列表 元组 等

     ```python
     # range 语句可以获得一个简单的数字序列
     # 语法1 得到一个0 - num的数字序列 (不包含num)
     range(5)
     # 语法2 得到一个num1 - num2的数字序列 (不包含num2)
     range(num1,num2) 
     # 语法3 得到一个num1 - num2(不包含) 步长为 step的数字序列  默认步长为1
     range(num1,num2,step)
     ```

     

* for循环嵌套使用

  注意缩进

* break 和 continue

  正常使用
  
* 循环与else语句 

  可以与循环并列行上加上else 表示循环正常执行后执行 如果循环中遭遇break或者抛出异常 亦或者遇到return语句后 则判定循环为非正常退出 不去执行else 

  代码实例

  ```python
  for i in range(5):
      if i == 3:
          print("Breaking for loop at i =", i)
          break
  else:
      print("For loop finished normally")
  # 上述代码不会执行else
  ```

### 函数

* 函数介绍

  函数是指组织好的可重复使用的 用来实现特定功能的代码段

  **tip len(数据容器) len 函数统计数据容器长度**

* 函数的定义

  1. 语法

     ```python
     def 函数名(传入参数):
         函数体
         return 返回值
     # 无返回值 也有返回值 返回的 是特殊字面量None
     函数名(传入实参)
     
     # 例
     def my_len(str):
         count = 0
         for i in str:
             count+=1
         return count
     #调用
     length  =  my_len("你好呀")
     ```

     

* 函数的参数

  可以一个 也可以多个

* 函数的返回值 

  ```python
  函数没有返回值 默认为 None 类型  (用于函数返回值)
  
  Node是特殊对象  None 等同于假  返回None 和 False 差不多  (用于if判断)
  
  None 可以用于给暂不赋值的变量赋值  (用于定义变量)
  
  **tip python 中 ! 用 not 替换**
  ```

* 函数说明文档

  多行注释 说明文档

  ```python
  def func(x,y):
      """
      函数说明
      :pararm x: 形式参数解释
      :pararm y: 形式参数解释
      :return: 返回值说明
      """
      函数体
  tip pycharm 在函数下面 直接写多行注释回车 生成函数解释文档   ideal 应该也行
  ```

  

* 函数的嵌套使用

  函数套函数

* 变量的作用域

  局部变量 定义在函数体内部

  全局变量 定义在函数外 函数内外都能使用

  ```python
  # global 关键字
  #python中 全局变量 在函数内重新赋值时 函数内修改的变量为局部变量 如果想在函数内部修改全局变量 使用global关键字声明为全局变量 修改
  num = 200
  def test():
      global num = 100
      return None
  # 解释  python全局变量在函数中能够直接访问 函数内并没有对全局变量进行赋值的权限 如果出现 默认为重新定义名和全局变量名相同的局部变量 只有用global 关键字声明后才能正式使用全局变量(进行修改赋值运算操作)
  ```



如果不使用 `global` 关键字，而是直接在函数内部修改 `num` 的值，Python 会将 `num` 视为函数内部的局部变量，而不是修改全局变量的值。这意味着在函数内部修改 `num` 的值不会影响到全局变量 `num`。

```python
num = 200
def test():
    num = num + 3  # 这里的num被当做局部变量处理
    return num
```

在这种情况下，当你调用 `test` 函数后，会发生 UnboundLocalError 错误，因为在函数内部的 `num` 在赋值之前被引用了。

因此，如果你想在函数内部修改全局变量的值，需要使用 `global` 关键字声明，或者通过函数的返回值来传递修改后的值。
