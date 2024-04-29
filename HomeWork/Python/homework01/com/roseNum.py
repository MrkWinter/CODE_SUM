def rose(num: int) -> bool:
    """
    判断是否为火仙花数
    :param num: 数字类型
    :return: 布尔值表是否为火仙花数
    """
    if len(str(num)) != 4:
        return False
    s = 0
    temp = num
    while temp != 0:
        s += (temp % 10) ** 4
        temp //= 10
    if s == num:
        return True
    else:
        return False


if __name__ == '__main__':
    print(rose(int(input("请输入数字"))))
