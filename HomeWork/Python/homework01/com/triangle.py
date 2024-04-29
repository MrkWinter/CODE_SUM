def cal_per(x: int, y: int, z: int) -> float:
    """
    计算三角形半周长
    :param x: 边
    :param y: 边
    :param z: 边
    :return: 浮点型
    """
    return (x + y + z) / 2


def cal_area(x: int, y: int, z: int) -> float:
    """
    计算三角形面积
    :param x: 边
    :param y: 边
    :param z: 边
    :return: 浮点型
    """
    q = cal_per(x, y, z)
    return (q * (q - x) * (q - y) * (q - z)) ** 0.5


if __name__ == '__main__':
    print("输入三边长")
    x = int(input())
    y = int(input())
    z = int(input())
    print(f"三边长为{x, y, z}的三角形,半周长为{cal_per(x, y, z)}")
    print("三边长为%.2f,%.2f,%.2f的三角形,面积为%.2f" % (x, y, z, cal_area(x, y, z)))
