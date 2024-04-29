from typing import Union


def get_prime1(ranges: int) -> list:
    """
    埃氏筛法
    :param ranges: 素数筛选范围 2 - ranges
    :return: 返回一个 列表 list[int]
    """
    if ranges <= 1:
        return list()
    ret_list = list(range(2, ranges + 1))
    i: int = ret_list[0]
    while i <= int(pow(ranges, 0.5)):
        ret_list = [x for x in ret_list if x == i or x % i != 0]  # 列表推导式
        i = ret_list[ret_list.index(i) + 1]
    return ret_list


def get_prime2(ranges: int) -> list:
    """
    常规素数求法
    :param ranges: 素数筛选范围 2 - ranges
    :return: 返回一个 列表 list[int]
    """
    ret_list = list()
    if ranges <= 1:
        return ret_list
    if ranges >= 2:
        ret_list.append(2)
    for i in range(3, ranges + 1, 2):
        flag = True
        for j in range(3, int(pow(i, 0.5) + 1), 2):  # 优化: 只遍历除2奇数
            if i % j == 0:
                flag = False
                break
        if flag:
            ret_list.append(i)
    return ret_list


if __name__ == '__main__':
    value = int(input("请输入素数求取范围上限:"))
    print(get_prime1(value))
    print(get_prime2(value))
