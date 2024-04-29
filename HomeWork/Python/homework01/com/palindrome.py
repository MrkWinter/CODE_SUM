from typing import Union


def isp(num: Union[str, int]) -> bool:
    """
    判断是否为回文数
    :param num: 判断的数字或字符
    :return: 布尔值表示是否为回文数
    """
    if str(num)[::-1] == str(num):
        return True
    else:
        return False


if __name__ == '__main__':
    print(isp(input("请输入数字或字符")))
