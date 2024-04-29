# 实验名称：（宋体四号）
#     实验三：函数
# 实验目的：
# 1、掌握函数的定义和调用、变量作用域。
# 2、掌握匿名函数和递归函数。
# 实验内容（方法步骤及代码）：


# 1、定义一个函数实现计算机的四则运算，并可以连续计算操作。调用函数验证功能。
# 代码如下:
def calculator():
    result = 0
    while True:
        expression = input("输入表达式 (or 'q' to quit): ")
        if expression.lower() == 'q':
            break
        try:
            result = eval(expression)
            print("Result:", result)
        except Exception as e:
            print("Error:", e)


calculator()


def calcul():
    while True:
        expression = input("输入表达式：(q退出)")
        if expression.lower() == 'q':
            break
        try:
            result = eval(expression)
            print(f"结果为：{result}")
        except Exception as e:
            print(e)


# 2、定义一个函数，用冒泡排序法给列表排序。
# 代码如下:
def bubble_sort(arr):
    n = len(arr)
    for i in range(n):
        for j in range(0, n - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]


def bubble_sort(arr):
    n = len(arr)
    for i in range(n - 1):
        for j in range(n - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]


# 使用示例
my_list = [64, 34, 25, 12, 22, 11, 90]
print("Original list:", my_list)
bubble_sort(my_list)
print("Sorted list:", my_list)


# 3、定义一个函数，可以实现字典的键和值实现互换。
# 代码如下：
def swap_keys_and_values(input_dict):
    return {v: k for k, v in input_dict.items()}


def swap_key_value(input_dict):
    return {v: k for k, v in input_dict.items}


# 使用示例
original_dict = {'a': 1, 'b': 2, 'c': 3}
print("Original dictionary:", original_dict)
swapped_dict = swap_keys_and_values(original_dict)
print("Swapped dictionary:", swapped_dict)


# 4、定义一个函数，可以计算输入数据的前n项阶乘之和。
# 代码如下:
def factorial_sum(n):
    result = 0
    factorial = 1
    for i in range(1, n + 1):
        factorial *= i
        result += factorial
    return result


def factorial_sum(n):
    result = 0
    fac = 1
    for i in range(1, n + 1):
        fac *= i
        result += fac
    return result


# 使用示例
n = 5
print(f"The sum of factorials of the first {n} numbers is: {factorial_sum(n)}")


# 5、定义一个函数，计算给定字符串中的最长回文字符串。例如'abacddc'返回cddc。
# 代码如下:
def longest_palindrome(s):
    result = ""
    for i in range(len(s)):
        # 以当前字符为中心，向两边扩展
        palindrome1 = expand_around_center(s, i, i)
        # 以当前字符和下一个字符的间隙为中心，向两边扩展
        palindrome2 = expand_around_center(s, i, i + 1)
        # 选取最长的回文字符串
        result = max(result, palindrome1, palindrome2, key=len)
    return result


def expand_around_center(s, left, right):
    while left >= 0 and right < len(s) and s[left] == s[right]:
        left -= 1
        right += 1
    return s[left + 1:right]


# 使用示例
input_str = 'abacddc'
print("The longest palindrome in the input string is:", longest_palindrome(input_str))


def get_pal(input_str):
    result = ''
    for i in range(len(input_str)):
        pal1 = expend_around_center(input_str, i, i)
        pal2 = expend_around_center(input_str, i, i + 1)
        result = max(result, pal1, pal2, key=len)
    return result


def expend_around_center(s, left, right):
    while left > 0 and right < len(s) and s[left] == s[right]:
        left -= 1
        right += 1
    return s[left + 1, right]
