def get_factorial(num: int) -> int:
    if num == 1:
        return 1
    else:
        return num * get_factorial(num - 1)


def get_sum(num: int) -> int:
    sum = 0
    for i in range(1, num + 1):
        sum += get_factorial(i)
    return sum


if __name__ == '__main__':
    num2 = get_sum(4)
    print(num2)
