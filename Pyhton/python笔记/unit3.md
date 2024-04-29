## 第三章

### 数据容器

* 数据容器入门

  1. 定义

     ```python
     # 批量存储和批量处理的容器  一种可以容纳多份数据的数据类型 容纳的一份数据称为有1个元素 每个元素都可以是任意的数据 如字符串 数字 布尔等
     数据容器的分类有  
     1. 列表(list)
     2. 元组(tuple)
     3. 字符串(str)
     4. 集合(set)
     5. 字典(dict)
     不同特点有 是否可重复 是否可修改 是否有序
     ```

     

* 数据容器 list(列表)

  1. 定义

     ```python
     # 字面量
     [元素1,元素2,元素3...]
     # 定义变量
     变量名称 = [元素1,元素2,元素3...]
     # 定义空列表
     变量名称 = []
     变量名称 = list()
     # 列表中的元素类型不受限制 可以套娃
     ```

  2. 索引

     ```python
     1. 正向索引
         --- 同数组索引
     2. 反向索引
         --- 反向数组索引
     两层列表 相似与 二维数组
     ```

  3. 常用操作

     python中也有类的概念 类中函数称为方法 方法需要对象.方法调用

     ```python
     # 方法演示
     my_list[1,2,3,True,"n"]
     
     # 1. index(元素) 返回元素下标索引 不存在报错
     my_list.index(3)
     # 2. 修改下标元素值
     my_list[3] = False
     # 3. insert(下标,元素)指定下标插入元素
     my_list.insert(2,"j")
     # 4. append(元素)追加元素到尾部
     my_list.append("k")
     # 5. expend(其他数据容器)在列表的尾部追加 一批元素
     list2 = [1,2,3]
     my_list.expend(list2)
      -- 列表可以直接相加 list3 = my_list + list2
      -- 列表可以重复 list3 = my_list*3
     # 6. del 列表[下标] \ pop(下标)删除列表元素
     del my_list[2]
     element = my_list.pop(3) # 移除元素并取出
     # 7. remove(元素) 移除第一个指定元素
     my_list.remove("n")
     # 8. clear() 清空列表
     my_list.clear()
     # 9. count(元素)统计元素个数
     count = my_list.count(3)
     # 10. 统计列表中元素数量 非list方法
     length = len(my_list)
     # 11. sort(key = 排序方法,reverse = True) 是否逆序  该函数为内部排序
     my_list.sort(key = lambda x: x**2,reverse = True)
     #  这里为降序排序  默认reverse为false升序排序
      #基于lambda匿名函数传入实现排序
     ```

     ![image-20230918201933160](img\image-20230918201933160.png)

     列表特点

     ![image-20230918202124717](img\image-20230918202124717.png)

  4. 列表的遍历

     ```python
     my_list = [1,2,3,4,5,"df"]
     i = 0
     while i < len(my_lsit):
         print(my_list[i])
         i = i + 1
         
     for i in my_list:
         print(i)
     ```

* 数据容器 tuple(元组)

  1. 元组定义格式

     ![image-20230918204428915](img\image-20230918204428915.png)

     ```python
     # 定义元组
     my_tuple = (1,2,3,4,"2")
       -- 注意 如果元组中只有一个元素 需要在后面加上逗号 防止认为是括号包括 如
         tup = ("nn",) 不写逗号认为是字符串
     # 定义空元组
     tu = ()
     tu = tuple()
     
     # 元组仍可用下标取出元素
     ```

     

  2. 元组特点

     特点 元组一旦定义完成 就不能被修改  可以看成是不可修改的list

     如果元组中嵌套了list 则元组支持其中list中的内容修改  元组元素不能修改 元素的元素可以修改

  3. 元组常见操作

     ![image-20230918205113745](img\image-20230918205113745.png)

     ```python
     my_tuple = (1,2,3,4,"2")
     # 1. index()
     index = my_tuple.index(3)
     # 2. count()
     count = my_tuple.count(2)
     # 3. len(元组)
     lengeh = len(my_tuple)
     ```

  4. 元组遍历

     元组遍历与列表相同

* 数据容器 str(字符串)

  1. 字符串常见操作

     ```python
     # 1. 字符串不可否认的也是数据容器 字符串是字符的容器 可以存放任意数量的字符
     # 2. 字符串同样支持下标索引
     # 3. 字符串不可修改
     
     # 方法
     srt = " mrkwinter "
     # 1. index(str1) 返回第一次出现str1的下标位置
     value = str.index("rk")
     # 2. replace(str1,str2) 将原字符串中出现的str1 改成str2 返回新的字符串
     value = str.relace("winter","win")
     # 3. split(str1) 将原字符串根据 str1分割 得到一个字符串的list列表对象
     my_list = str.split("")
     # 4. strip(str1) 去除原字符串两边的str1中包含的字符 不填默认为" " 去除空格以及换行符 返回去除后的字符串
     value = str.strip(" ")
     # 5. count(str1)统计str1出现的次数
     count = str.count("w")
     # 6. len(字符串) 统计字符串长度
     count = len(str)
     ```

     ![image-20230918211415332](img\image-20230918211415332.png)

  2. 字符串遍历

     while 和 for 都行

  3. 特点

     ![image-20230918211610012](img\image-20230918211610012.png)

* 数据容器的切片

  1. 序列

     序列是指 内容连续 有序 可以使用下标索引的一类数据容器 列表 元组 字符串 均可视为序列

  2. 序列的切片

     切片是指从一个序列中 取出一个字序列

     ![image-20230918213107345](img\image-20230918213107345.png)

     ```python
     #语法
     序列[起始下标:结束下标:步长]
     -- 例
     my_list =[0,1,2,3,4,5,6]
     result1 = my_list[0:4]
     result2 = my_list[:4:2]
     result3 = my_list[0::3]
     result4 = my_list[2:5:2]
     result5 = my_list[::-1]
     result6 = my_list[5:3:-1]
     
     # 解释 布长为负数 表示倒序取 起始下标和结束下标都需要从后往前 正向下标和反向下标都可以使用
     
     tip 切片可以连续使用  如
     value = my_list[::-1][1:4]
     ```

* 数据容器 set(集合)

  1. 集合定义格式

     ```python
     # 语法
     # 定义集合
     变量名称 = {元素1,元素2,元素2,...}
     # 定义空集合
     变量名称 = set()
      -- 例
     my_set = {"n","3",3,1,6,8,True}
     
     注意：集合不支持下标索引 但支持修改
     ```

     

  2. 集合特点

     不可重复  无序 不支持下标索引

     ![image-20230918215839592](img\image-20230918215839592.png)

  3. 集合常见操作

     ![image-20230918215757615](img\image-20230918215757615.png)

     ```python
     # 1. add(元素1) 添加元素1
     # 2. remove(元素1) 移除元素1
     # 3. pop() 随机取出一个元素 并返回 取出后原集合不存在了就
     # 4. clear() 清空集合
     # 5. 集合1.difference(集合2) 取集合1 和集合2 的差集 并返回新集合 (集合1中有 集合2 中无) 
     # 6. 集合2.dfference_update(集合2) 消除集合1中集合1 与集合2 的差集 (删除在集合1中 集合1中有的集合2中没有的元素 集合1被改变 集合2 不变)
     # 7. 集合1.union(集合2) 合并集合1和集合2中的元素 并返回新集合
     # 8. len(集合) 得到集合中的所有元素个数
     ```

  4. 集合的遍历

     集合不能使用whie循环遍历 但可以使用for循环遍历

     ```python
     set1 = {1,2,3,45,5}
     for i in set1:
         print(i)
     ```

     

* 数据容器 dict(字典 映射)

  1. 字典的定义

     ```python
     # 字典是通过 key valeu 键值对存储数据
     # 语法 定义字典
     my_dict = {key1: value1,key2 value2...}
     # 定义空字典
     my_dict = {}
     my_dict = dict()
      -- 例
     my_dict = {"wang":33,"li":22,"shun":55}
     
     # 字典的key 不允许重复 添加重复key value会覆盖 
     # 字典不允许下标索引 但允许key索引
     # 字典key不允许为字典 除此所有类型都可以充当key和value 所以字典可以嵌套
     ```

  2. 字典的相关操作

     ![image-20230918222225165](img\image-20230918222225165.png)

     ```python
     # 1. 通过key得到value
     value = my_dict["wang"]
     嵌套字典 可以用 字典[key][key]
     嵌套列表 或元组 字典[key][index]
     
     # 2. 新增/更新字典
     字典[key] = value
     如果key存在 则为更新
     如果key不存在 则为添加
     # 3. pop(key) 删除字典元素 并返回对应value
     # 4. clear() 清空字典元素
     # 5. key() 得到字典中全部key 返回的是列表  可以通过此方法通过key取出value
     
     解释: 直接对字典使用for循环遍历会依次取出所有key值 和使用for while循环依次取出key()方法返回的列表中的key一样
     # 6. len(字典) 得到字典中元素个数
     ```

  3. 字典特点

     ![image-20230918222332503](img\image-20230918222332503.png)

* 数据容器通用操作

  1. 分类

     ![image-20230918223010251](img\image-20230918223010251.png)

  2. 遍历

     ![image-20230918223224615](img\image-20230918223224615.png)

  3. 统计

     ![image-20230918223321201](img\image-20230918223321201.png)

  4. 容器转换

     ![image-20230918223457713](img\image-20230918223457713.png)

  5. 容器排序

     注意逆序为sorted(容器,reverse = True) 排序后原容器不变 返回排序完成后新的列表

     ![image-20230918223816456](img\image-20230918223816456.png)

  6. 检测元素

     可迭代对象(列表  元组 字符串 集合  字典)可以中in 或 not in 来判定某个对象是否在对象中  如
  
     ```python
     my_list = [1, 2, 3, 4, 5]
     if 3 in my_list:
         print("3 is in the list")
     else:
         print("3 is not in the list")
     ```
  
     
  
  7. 总览
  
     ![image-20230918224321525](img\image-20230918224321525.png)