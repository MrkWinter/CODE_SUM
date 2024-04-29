# print('你好', 6 ** 2)
#
# print("你好%-3d%s" % (1, "n"))
#
# if 12 < 32:
#     print("n")
# print("d")
#
# i = 1
# while i <= 9:
#     j = 1
#     while j <= i:
#         print("%d * %d = %-3d" % (j, i, (j * i)), end='')
#         j += 1
#     print()
#     i += 1
# num = 100
#
#
# def test():
#     global num
#     num += 100
#     print(num)
#     return None
#
#
# test()

# my_list = [1, 2, 3, 4, 5, 6]
# # new_list = my_list[5:-3: -1]
# # print(new_list)
# my_list = sorted(my_list, reverse=True)
# print(my_list)


# def outer(name: str):
#     def inner(age: int):  # 闭包函数
#         nonlocal name
#         name = "李四"
#         print(f"{name}今年{age}岁")
#
#     return inner
#
#
# if __name__ == '__main__':
#     i = outer("张三")  # i为inner的函数类型
#     i(19)

# def sleep(name: str):
#     print("%s在碎觉" % name)
#
#
# def sleep1(name: str):
#     print("%s在玩手机" % name)
#
#
# def outer(func):
#     def inner(name):
#         print("碎觉啦")
#         func(name)
#         print("起床啦")
#
#     return inner
#
#
# if __name__ == '__main__':
#     c = outer(sleep)
#     c("王五")
#     c = outer(sleep1)
#     c("王二")

# def outer(func):
#     def inner(name):
#         print("碎觉啦")
#         func("o")
#         print("起床啦")
#
#     return inner
#
#
# @outer
# def sleep(name: str):
#     print("%s在碎觉" % name)
#
#
# if __name__ == '__main__':
#     sleep("王五")  # 使用@外部函数名后 相当于运行下面代码
#     # c = outer(sleep)
#     # c("王五")
#
#
# # 注意 @outer后相当于 闭包函数和原函数建立联系 相当于使用sleep函数名 直接调用闭包函数  闭包函数的参数类型要和使用sleep函数时的参数列表一致
#
#
# class StrTools:
#     pass
#
#
# str_tools = StrTools()
#
# from typing import Union
#
#
# class Person:
#     pass
#
#
# class Worker(Person):
#     pass
#
#
# class Student(Person):
#     pass
#
#
# class Teacher(Person):
#     pass
#
#
# class Factory:
#     def get_person(self, p_type: str) -> Union[Worker, Student, Teacher]:
#         if p_type == "w":
#             return Worker()
#         elif p_type == "s":
#             return Student()
#         elif p_type == "t":
#             return Teacher()
#
#
# if __name__ == '__main__':
#     f = Factory()
#     worker = f.get_person("w")
#
# import time
# import threading
#
#
# def song(args: str):
#     while True:
#         print(args + "在唱歌")
#         time.sleep(1)
#
#
# def dance(kwargs: str):
#     while True:
#         print(kwargs + "在跳舞")
#         time.sleep(1)
#
#
# if __name__ == '__main__':
#     t1 = threading.Thread(target=song, args=("张三",))
#     t2 = threading.Thread(target=dance, kwargs={"kwargs": "李四"})
#     t1.start()
#     t2.start()


import re

# match()  用于判断是否匹配
str_ = "I love you iii ttt jjj kkk"
result = re.match("I", str_)  # match方法返回的是 一个特殊类
print(result.span())  # 返回第一次匹配的起始下标和结束下标
print(result.group())
# search() 在字符串中去寻找 只找第一个

# findall() 用于找到所有匹配项
