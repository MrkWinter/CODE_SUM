## 第九章

### PySpark使用

* 前言介绍

  Spark是分布式计算框架 用于大数据计算

  pySpark是Pyton语言第三方库 用于支持Spark对Python的支持

  ![image-20230921162921515](img\image-20230921162921515.png)

* 基础准备

  ```python
  # 安装
  pip install pyspark
  pip install -i https://pypi.tuna.tsinghua.edu.cn/simple pyspark
  # 基本使用
  # 导入包
  from pyspark import SparkConf, SparkContext
  
  # 创建SparkConf对象
  conf = SparkConf().setMaster("local[*]").setAppName("test_spark_app")
  # 基于SparkConf类对象创建SparkContext对象
  sc = SparkContext(conf=conf)
  # 打印PySpark的运行版本
  print(sc.version)
  # 停止SparkCntext对象的运行(停止PySpark程序)
  sc.stop()
  
  # SparkContext类对象是PySpark编程中一切功能的入口
  
  # PySpark的编程 主要分为如下三个步骤
  1. 数据输入
  通过SparkContext类对象的成员方法完成数据的读取操作读取后得到RDD类对象
  2. 数据处理计数
  数据处理计算 通过RDD类对象的成员方法 完成各种数据计算的需求
  3. 数据输出
  将处理完成后的RDD对象 调用各种成员方法完成写出文件 转换为list等操作
  ```

* 数据输入

  1. RDD对象

     ```python
     RDD 称为 弹性分布式数据集
     ```

  2. 输入方法

     ```python
     # 第一种 将python中的数据容器转换成RDD对象
     SparkConetxt对象.parallelize(数据容器对象) 该方法返回RDD对象
     from pyspark import SparkContext, SparkConf
     
     conf = SparkConf().setMaster("local[*]").setAppName("test_spark")
     sc = SparkContext(conf=conf)
     # 将数据容器转换成RDD对象
     rdd = sc.parallelize([1, 2, 3, 4, 5, 6])
     # 收集并输出数据
     print(rdd.collect())
     
     # 第二种 通过文件得到RDD对象
     SparkConetxt对象.textFile(文件路径) 该方法返回RDD对象
     ```

* 数据计算 (RDD类的成员方法(算子))

  1. map算子

     ```python
     # 将RDD数据一个个处理(通过传入的函数对每一条数据进行运算) 并返回运算后的RDD
     以下rdd同为 
     conf = SparkConf().setMaster("local[*]").setAppName("test_spark")
     sc = SparkContext(conf=conf)
     rdd = sc.parallelize([1, 2, 3, 4, 5, 6])
     -- 例  要通过os模块 指定python解释器的路径
     
     from pyspark import SparkConf, SparkContext
     import os
     
     os.environ['PYSPARK_PYTHON'] = "C:/Users/MrkWinter/AppData/Local/Programs/Python/Python38/python.exe"
     
     conf = SparkConf().setMaster("local[*]").setAppName("test_spark")
     sc = SparkContext(conf=conf)
     rdd = sc.parallelize([1, 2, 3, 4, 5, 6])
     
     def func(data: int) -> int:
         return data * 10
     
     # 注意 算子可以进行链式调用
     rdd1 = rdd.map(func).map(lambda x: x + 5)
     print(rdd1.collect())
     sc.stop()
     ```

  2. flatMap算子

     ```python
     flatMap 和 Map相同 但flatMap有解除嵌套的效果
     类似于java8中StreamAPI中的映射的flatMap
     flatMap会运算结果进行解除嵌套
     ```

  3. reduceByKey算子

     ```python
     # 针对k v型的RDD 自动按照key分组 然后根据你提供的聚合逻辑 完成组内数据(value)的聚合操作
     kv型rdd -- 二元元组 (k可重复)
     如[("a",3),("a",6),("b",2),("b",4),("b",7)]
      -- 例
     from pyspark import SparkConf, SparkContext
     import os
     
     os.environ['PYSPARK_PYTHON'] = "C:/Users/MrkWinter/AppData/Local/Programs/Python/Python38/python.exe"
     
     conf = SparkConf().setMaster("local[*]").setAppName("test_spark")
     sc = SparkContext(conf=conf)
     rdd = sc.parallelize([("a", 3), ("a", 6), ("b", 2), ("b", 4), ("b", 7)])
     rdd1 = rdd.reduceByKey(lambda x, y: x + y)
     print(rdd1.collect())
     sc.stop()
     ```

  4. filter算子

     ```python
     # 根据指定逻辑来保留或去除原数据 返回新的RDD对象
     -- 例
     from pyspark import SparkContext, SparkConf
     import os
     
     os.environ['PYSPARK_PYTHON'] = "C:/Users/MrkWinter/AppData/Local/Programs/Python/Python38/python.exe"
     
     conf = SparkConf().setMaster("local[*]").setAppName("test_spark")
     sc = SparkContext(conf=conf)
     rdd = sc.parallelize([1, 2, 3, 4, 5, 6])
     rdd1 = rdd.filter(lambda x: x % 2 == 0)
     print(rdd1.collect())
     sc.stop()
     ```

  5. distinct算子

     ```python
     # 去重rdd数据 并返回新的rdd对象
     from pyspark import SparkContext, SparkConf
     import os
     
     os.environ['PYSPARK_PYTHON'] = "C:/Users/MrkWinter/AppData/Local/Programs/Python/Python38/python.exe"
     
     conf = SparkConf().setMaster("local[*]").setAppName("test_spark")
     sc = SparkContext(conf=conf)
     rdd = sc.parallelize([1, 2, 3, 4, 1, 1])
     rdd1 = rdd.distict()
     print(rdd1.collect())
     sc.stop()
     ```

  6. sortBy算子

     ```python
     # 对rdd数据进行排序 并且可以指定排序逻辑
     sortBy(func,ascending = Flase,numPartitions = 1)
     func : 返回rdd数据中的数据作为排序依据
     ascending  是否升序 True表示升序 Flase表降序
     numPartitions  使用分区数 设为1 与分布式相关
     
     -- 例
     from pyspark import SparkContext, SparkConf
     import os
     
     os.environ['PYSPARK_PYTHON'] = "C:/Users/MrkWinter/AppData/Local/Programs/Python/Python38/python.exe"
     
     conf = SparkConf().setMaster("local[*]").setAppName("test_spark")
     sc = SparkContext(conf=conf)
     rdd = sc.parallelize([1, 2, 3, 4, 1, 1])
     rdd1 = rdd.sortBy(lambda x: x, ascending=True, numPartitions=1)
     print(rdd1.collect())
     sc.stop()
     ```

* 数据输出

  1. 将rdd的结果输出为python对象

     ```python
     # 将rdd的结果输出为python对象的各类方法
     #1. collect算子 将RDD对象转换成List数据容器
     l :list = rdd.collect()
     #2. reduce 算子 和reduceByKey相似 但是返回具体累加得到的值
     value = rdd.reduce(fun)
     #3. take 算子 取RDD的前n个元素 组合成list返回
     l :list = rdd.take(3)
     #4. count 算子 计算RDD有多少条数据 返回值是一个数
     c :int = rdd.count()
     ```

  2. 将数据输出到文件中

     ```python
     # saveASTextFile(文件路径(文件夹)) 将RDD输出到文件中
     # 需要配置Hadoop依赖 如图1
     # 有多少个分区就有多少个文件 默认为16
     # 如何修改分区 如图2
     ```

     图1

     ![image-20230921193515667](img\image-20230921193515667.png)

     图2

     ![image-20230921193934351](img\image-20230921193934351.png)

    tip \ 可以将一行代码换为多行使用

* 分布式集群运行

  ```python
  # 代码可以在spark分布式集群中运算 需要服务器
  ```

  

