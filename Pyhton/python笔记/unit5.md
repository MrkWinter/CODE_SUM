## 第五章

### python异常、模块与包

* 了解异常

  bug

* 异常捕获方法

  1. 语法

  ```python
  # 方式1 直接处理
  try:
      可能发生异常的代码
  except:
      如果出现异常执行的代码
      
  # 方式2 进行捕获
  try:
      可能发生异常的代码
  except NameError as e: # 捕获变量未定义异常 封装为对象e
      如果出现异常执行的代码
      
  # 方式3 捕获多个异常
  try:
      可能发生异常的代码
  except (NameError,ZeroDivisionError) as e:
      如果出现异常执行的代码
      
  # 方式4 捕获所有异常
  try:
      可能发生异常的代码
  except Exception as e:
      如果出现异常执行的代码
  # 可以加else 表示没有异常执行代码块 和except里的代码表并列
  else
  # 可以加finally 无论是否有异常都会执行 
  finally
  ```

  2. 特点

  异常具有传递(推锅性) 异常只有被处理或者直接抛出给系统才会终止 否则会一直向调用者抛出

* Python模块

  1. 什么是模块

     头文件

     ![image-20230919202005707](img\image-20230919202005707.png)

  2. Python内置模块的导入

     ```python
     # 语法
     [from 模块名] import [模块 | 类 | 变量 | 函数 | * ] [as 别名]
     # 常用的组合形式有:
     import 模块名
     from 模块名 import 类、变量、方法等
     from 模块名 import *
     from 模块名 import 功能名 as 别名
     
     -- 例
     # 1
     import time # 导入python time模块 (time.py文件)
       # 导入模块后可以通过. 来使用其中的 函数 变量 类
     time.sleep(45) 睡眠45秒
     # 2
     from time import sleep 
       # 只导入模块中一个函数 使用sleep函数 单独导入可直接使用
     sleep(3)
     # 3
     from time import * 
       # 导入所有功能模块 函数 变量 类等 可以直接使用
     sleep(3)
     # 4
     import time as ti 
     from time import sleep as sl
       # as 可以给模块或功能赋予别名 起别名后原名不能使用
     # 5
     ```

  3. 自定义模块

     1. 就是c语言自定义头文件 将自己写的文件(模块名)当做模块使用

     2. 注意 导入功能模块 或者 功能名相同时 新定义的会覆盖旧的

     3. 导入自定义模块或功能后运行被导入的文件 导入的(文件)模块也会执行 可以用以下方法防止被导入文件调用导入文件

        ```python
        if __name__ == "__main__":
            想要在导入模块运行的代码
        ```

     4. __all\__变量

        ```python
        解释 使用__all__ 变量定义的列表中包含着所有直接导入功能可以用的功能(函数 变量 类等)
        若__all__ 变量列表中没有写人该文件中的功能 则别的文件使用from 文件名 import * 时 无法导入未写入列表中的功能也就无法使用 注: 使用模块导入或者指定功能导入 仍可导入使用 只是规定了* 导入的功能
        __all__ = ["test_a",... 表示可导入的变量]
        ```

* Python包

  1. 什么是Python包

     __init\__.py文件 为特殊文件 有该文件表示该文件夹为Python包 没有就是普通的文件夹 类比java包作用

     ```python
     # 1. 导入包
     import 包名.模块名
     #  调用模块功能
     包名.模块名.功能名
     
     # 2. 导入包中模块
     from 包名 import 模块名
     # 调用模块功能
     模块名.功能名
     
     # 3. 导入包中模块的功能
     from 包名.模块名 import 功能名
     # 调用模块功能
     功能名
     
     注意:无论导入模块还是包 调用功能时 前缀为import后的东西
     
     __init__ 文件中可以定义 __all__ 变量 列表中为模块名  表示在使用from 该包 import * 时导入的模块  当然 和在模块中控制功能一样 直接导入指定模块也能使用
     ```

  2. 自定义Python包

     就是自己建的包

* 安装第三方Python包

  1. 第三方Python包

     ![image-20230919211836602](img\image-20230919211836602.png)

  2. pip安装第三方包

     命令行 安装
     ```python
     # 使用国外网安装
     pip install 包名
     numpy 有关科学计算包
     
     # 使用国内网安装
     pip install -i https://pypi.tuna.tsinghua.edu.cn/simple 包名
     ```

     