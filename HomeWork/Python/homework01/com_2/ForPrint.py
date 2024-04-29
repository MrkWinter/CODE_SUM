def print_right(edge1_len: int, edge2_len: int) -> None:
    """
    打印直角三角形
    :param edge1_len:  表示行高
    :param edge2_len:  表示列长
    :return: 无
    """
    add = avg = int(edge2_len / edge1_len)
    if avg == 0:
        add = 1
    for i in range(edge1_len):
        print("*" * add)
        add += avg


def print_equilateral(high: int) -> None:
    """
    打印等腰三角形
    :param high: 三角形高
    :return: 无
    """
    for i in range(1, high + 1):
        print(" " * (high - i), "*" * (2 * i - 1))


if __name__ == '__main__':
    print_right(3, 3)
    print_equilateral(3)

