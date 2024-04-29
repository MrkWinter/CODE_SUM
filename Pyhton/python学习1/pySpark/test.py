# # 导入包
# from pyspark import SparkConf, SparkContext
#
# # 创建SparkConf对象
# conf = SparkConf().setMaster("local[*]").setAppName("test_spark_app")
# # 基于SparkConf类对象创建SparkContext对象
# sc = SparkContext(conf=conf)
# # 打印PySpark的运行版本
# print(sc.version)
# # 停止SparkCntext对象的运行(停止PySpark程序)
# sc.stop()

# from pyspark import SparkContext, SparkConf
#
# conf = SparkConf().setMaster("local[*]").setAppName("test_spark")
# sc = SparkContext(conf=conf)
# # 将数据容器转换成RDD对象
# rdd = sc.parallelize([1, 2, 3, 4, 5, 6])
# rdd2 = sc.textFile("rddtext.txt")
# # 收集并输出数据
# print(rdd.collect())
# print(rdd2.collect())

# from pyspark import SparkConf, SparkContext
# import os
#
# os.environ['PYSPARK_PYTHON'] = "C:/Users/MrkWinter/AppData/Local/Programs/Python/Python38/python.exe"
#
# conf = SparkConf().setMaster("local[*]").setAppName("test_spark")
# sc = SparkContext(conf=conf)
# rdd = sc.parallelize([1, 2, 3, 4, 5, 6])
#
#
# def func(data: int) -> int:
#     return data * 10
#
#
# rdd1 = rdd.map(func).map(lambda x: x + 5)
#
# print(rdd1.collect())
#
# sc.stop()

# from pyspark import SparkConf, SparkContext
# import os
#
# os.environ['PYSPARK_PYTHON'] = "C:/Users/MrkWinter/AppData/Local/Programs/Python/Python38/python.exe"
#
# conf = SparkConf().setMaster("local[*]").setAppName("test_spark")
# sc = SparkContext(conf=conf)
# rdd = sc.parallelize([("a", 3), ("a", 6), ("b", 2), ("b", 4), ("b", 7)])
# rdd1 = rdd.reduceByKey(lambda x, y: x + y)
# print(rdd1.collect())
# sc.stop()

# from pyspark import SparkContext, SparkConf
# import os
#
# os.environ['PYSPARK_PYTHON'] = "C:/Users/MrkWinter/AppData/Local/Programs/Python/Python38/python.exe"
#
# conf = SparkConf().setMaster("local[*]").setAppName("test_spark")
# sc = SparkContext(conf=conf)
# rdd = sc.parallelize([1, 2, 3, 4, 5, 6])
# rdd1 = rdd.filter(lambda x: x % 2 == 0)
# print(rdd1.collect())
# sc.stop()


from pyspark import SparkContext, SparkConf
import os

os.environ['PYSPARK_PYTHON'] = "C:/Users/MrkWinter/AppData/Local/Programs/Python/Python38/python.exe"

conf = SparkConf().setMaster("local[*]").setAppName("test_spark")
sc = SparkContext(conf=conf)
rdd = sc.parallelize([1, 2, 3, 4, 1, 1])
rdd1 = rdd.sortBy(lambda x: x, ascending=True, numPartitions=1)
print(rdd1.collect())
sc.stop()
