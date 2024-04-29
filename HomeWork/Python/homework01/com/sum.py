def sum1(x: int, y: int) -> int:
    """
    两数相加
    :param x:
    :param y:
    :return:
    """
    return x + y


if __name__ == "__main__":
    print("请输入两个数字")
    x = int(input())
    y = int(input())
    print(f"两数相加为{sum1(x, y)}")
