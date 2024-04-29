def exchange(dict1: dict) -> dict:
    result = dict()
    for i in dict1:
        result[dict1[i]] = i
    return result


if __name__ == '__main__':
    dict2 = exchange({"a": 1, "b": 2, "c": 3, "d": 4, "e": 5, "f": 6})
    print(dict2)
