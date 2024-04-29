word_list = ["零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"]


def str_to_word(str1):
    str_list = list(str1)
    str_list = [str(i) if not str(i).isdigit() else word_list[int(i)] for i in str_list]
    return str_list


if __name__ == '__main__':
    num_str = "你好123.344"
    word_str = str_to_word(num_str)
    print(word_str)
