# 列表去重并转换成元组
def distinct(list1: list):
    return tuple(set(list1))


if __name__ == '__main__':
    my_list = [1, 2, 3, 3, 3, 4, 5, 5]
    my_tuple = distinct(my_list)
    print(my_tuple)
