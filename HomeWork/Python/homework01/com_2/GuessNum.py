import random


class GuessNum:
    def __init__(self, lower: int, upper: int, times: int):
        self.__lower__ = lower
        self.__upper__ = upper
        self.__times__ = times

    def guess_num(self) -> None:
        print(f"开始猜数字 数字范围为{self.__lower__}到{self.__upper__} 共有{self.__times__}次机会")
        guess_num = random.randint(self.__lower__, self.__upper__)
        count = self.__times__
        while count > 0:
            gus = int(input("请输入数字"))
            count -= 1
            if gus < guess_num:
                print(f"猜小了 还有{count}次机会")
            elif gus > guess_num:
                print(f"猜大了 还有{count}次机会")
            else:
                print(f"猜对了 游戏结束  共用{self.__times__ - count}次猜对数字")
                return None
        print("次数用完 猜数字失败 游戏结束 ")


if __name__ == '__main__':
    g = GuessNum(0, 10, 5)
    g.guess_num()
