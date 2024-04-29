def bubble_sort(arr: list) -> list:
    length = len(arr)
    i = 0
    while i < length - 1:
        flag = True
        j = 0
        length2 = length - i - 1
        while j < length2:
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                flag = False
            j += 1
        if flag:
            return arr
        i += 1

    return arr


if __name__ == '__main__':
    my_list = bubble_sort([1, 6, 3, 4, 5, 0])
    print(my_list)
