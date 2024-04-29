## 第七章

### 面向对象

* 类和对象

  类 对象 成员变量 (属性) 成员方法

  ```python
  # 语法
  class 类名称:
      类的属性 (成员变量 属性)
      类的行为 (成员方法 )
      
  # 成员方法
  def say_hi(self):
      print(self.name)
      -- 成员方法中必须有self参数 表示调用该方法的对象 自动传入到该方法中去 相当于this 但访问成员属性必须使用self 当传入实际参数时 可以不去理会这个形参
      
      
  import winsound
  winsound.Beep(频率,时间) 
  winsound.Beep(2000,3000) 该方法可以发出声音
  ```

* 构造方法

  ```python
  class Stundnt:
      name = None 
      age = None
      tel = None
       # python中属性可以不声明 在构造方法中可以直接声明并赋值
          
      # 构造方法 固定名
      def __init__(self,name,age,tel):
          self.name = name
          self.age = age
          self.tel = tel
   student = Student("张三",23,"233424235")
  ```

  

* 其他类内置方法

  类内置方法被称为魔术方法 构造方法也是类内置方法

  ```python
  # 1. __init__(self) 构造方法
  还是构造方法 有默认构造方法 （会覆盖吗？）
  # 2. __str__(self) 字符串方法
  就是toString() 没有从写默认返回地址
  # 3. __lt__(self) 小于 大于符号比较
  < > 运输符重载  例接上
  def __lt__(self,other):
      return self.age < other.age
  student1<student2 -- True
  # 4. __le__(self) 小于等于 大于等于 符号比较
  <=  >= 运算符重载 同上相似
  # 5. __eq__(self)  ==符号比较
  就是equals()  没有重写默认比较地址
  ```

* 封装

  1. 概念

     就是封装啊

  2. 私有成员的使用

     ```python
     # __成员变量名 就是私有成员
     # __成员方法名 就是私有方法
     # 私有成员不能通过对象调用使用 但可以被类中的成员方法使用
     ```

     

* 继承

  1. 继承概念

     就是继承 继承

  2. 继承使用方式

     ```python
     # 单继承
     class 类名(父类名):
         类内容
     # 多继承
     class 类名(父类名1,父类名2...):
     ```

     

  3. pass关键字

     ```python
     用于在不想要额外功能时 用于补充语法
     如类继承后不做改变
     class MyPhone(Phone,NFCReader):
         pass
      
     # 注意 多继承下 如果成员名相同 左边父类优先 不会覆盖  调用时优先调用左边父类
     ```

  4. 子类复写父类成员

     重写啊重写

     ```python
     #  python中可以复写所有成员 包括属性和方法
     ```

  5. 在子类中调用父类成员

     ```python
     # 复写后仍可使用父类成员 用
     # 方式1
     父类名.成员属性
     父类名.成员方法(self) -- ？self不名所以 为什么要用self？
     # 方式2
     super().成员属性
     super().成员方法()
     
     # 多继承下先继承的父类优先级高
     ```

* 类型注解

  ```python
  # 就是标记数据类型 便于识别 -- 弱语言类型的缺点啊
  # 1. 对变量进行类型注解
   -- 基础数据类型注解
  var_1: int = 10
  var_2: float = 3.14
  var_3: bool = True
  var_4: str = "it"
  stu: Student = Student()
   -- 容器数据类型注解
  my_list: list = [1,2,3]
  my_tuple: tuple = (1,2,3)
  my_set: set = {1,2,3}
  my_dict: dict = {"i":1,"d":2}
  my_str: str = "hhh"
   -- 容器数据类型注解详解
  my_list: list[int] = [1,2,3]
  my_tuple: tuple[str,int,bool] = ("s",33,True)
  my_set: set[int] = {1,2,3}
  my_dict: dict[str,int] = {"i":1,"d":2}
  注意: 元组类型设置类型详解注解 需要将每一个元素都标记出来
      : 字典类型设置类型详细注解 需要两个类型 第一个是key 第二个个是value
      此外还有注释类型注解
      var_1 = 1 # type: int
      
  注解只是提示性的 乱写也不会报错
  
  # 2. 函数(方法) 形参列表和返回值的类型注解
   # 形参类型注解
  def add(x: int,y: int):
      return x+y
   # 返回类型注解
  def add(x, y) ->int:
      return x+y
  
  # 3. Union类型 及注解
   # 语法
     Union[类型1,类型2...] Union 类型用于描述注解中的混合类型
   -- 例
  from typing import Union
  变量:
  my_list:list[Union[int,str]] = [2,3,"it","ss"]
  函数(方法)
  def func(data: Union[int,str]) ->Union[int,str]:
      return data
  ```

* 多态

  多态  继承向上转型

  ```python
  #定义普及
  # 抽象类(接口  Python中抽象类和接口合并 因为有多继承机制)
  class Animal:
      def speak(self):
          pass
  继承父类向上转型实现多态
  继承抽象类向上转型实现多态
  ```

* 面向对象编程 

  Python也面向对象编程