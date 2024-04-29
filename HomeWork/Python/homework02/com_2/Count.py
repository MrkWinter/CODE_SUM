# 统计列表中元素出现个数
def count_num(list1):
    dict1 = dict()
    max_count = 0
    max_count_e = None
    for i in set(list1):
        dict1[i] = list1.count(i)
        if list1.count(i) > max_count:
            max_count = list1.count(i)
            max_count_e = i
    return dict1, max_count_e, max_count


if __name__ == '__main__':
    my_list = [1, 2, 3, 4, 5, 5, 5, 5]
    my_dict, max_count_e,max_count = count_num(my_list)
    print(f"每个元素出现的次数{my_dict}\n最多出现次数的元素:{max_count_e},出现的次数:{max_count}")
