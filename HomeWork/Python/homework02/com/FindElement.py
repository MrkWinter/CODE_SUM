# 找列表中出现重复次数最大的元素及次数
def find(collection: list):
    temp_set = set(collection)
    max_appear_count: int = 0
    max_appear_ele = None
    for e1 in temp_set:
        if collection.count(e1) > max_appear_count:
            max_appear_count = collection.count(e1)
            max_appear_ele = e1
    return max_appear_ele, max_appear_count


if __name__ == '__main__':
    my_list = [1, 2, 3, 3, 3, 3, 3, 5, 7, 8, 9]
    m1, m2 = find(my_list)
    print(f"出现最多的元素{m1},出现次数{m2}")
