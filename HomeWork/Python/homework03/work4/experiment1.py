# 实验名称：（宋体四号）
#     实验一：列表和元组
# 实验目的：
# 1、掌握列表的创建与访问、添加、删除、修改列表元素的方式。
# 2、掌握元组的创建与访问。
# 实验内容（方法步骤及代码）：


# 1、使用count函数找出列表中出现次数最多的元素，以及该元素出现的次数。
# 代码如下:

def find_most_frequent_element(input_list):
    max_count = 0
    most_frequent_element = None
    for element in set(input_list):  # 使用 set 函数获取列表中的唯一元素
        count = input_list.count(element)
        if count > max_count:
            max_count = count
            most_frequent_element = element
    return most_frequent_element, max_count


def find_most_frequent_ele(input_list):
    max_count = 0
    max_frequent_ele = None
    for i in set(input_list):
        count = input_list.count(i)
        if count > max_count:
            max_count = count
            max_frequent_ele = i
    return max_count, max_frequent_ele


# 2、定义一个列表，将列表中重复的元素去掉，只保留一个即可。并将新的列表转换成元组。
# 代码如下:
original_list = [1, 2, 2, 3, 4, 4, 5, 5, 5]
unique_list = list(set(original_list))  # 使用 set 函数去除重复元素，再转换为列表
unique_tuple = tuple(unique_list)  # 将列表转换为元组
print(unique_tuple)


def tran_list_to_distinct_tup(input_list):
    return tuple(set(input_list))


# 3、编写好友管理系统，包括添加好友、删除好友、备注好友、展示好友等。
# 代码如下:


class FriendManager:
    def __init__(self):
        self.friends = {}

    def add_friend(self, name):
        if name not in self.friends:
            self.friends[name] = {'name': name, 'note': ''}
            print(f"{name} 添加成功")
        else:
            print(f"{name} 已经是你的好友.")

    def remove_friend(self, name):
        if name in self.friends:
            del self.friends[name]
            print(f"{name} 已移除.")
        else:
            print(f"{name} 不是你的好友.")

    def note_friend(self, name, note):
        if name in self.friends:
            self.friends[name]['note'] = note
            print(f"备注已添加 {name}: {note}.")
        else:
            print(f"{name} 不是你的好友.")

    def show_friends(self):
        if len(self.friends):
            print("你的朋友:")
            for friend in self.friends.values():
                print(friend['name'], "- 备注:", friend['note'])
        else:
            print("你没有朋友.")


# 4、中文数字对照表，实现将输入的阿拉伯数字转为中文大写数字的功能。
# 代码如下:


def number_to_chinese(number):
    chinese_map = {0: '零', 1: '一', 2: '二', 3: '三', 4: '四', 5: '五', 6: '六   ', 7: '七', 8: '八', 9: '九'}
    chinese_str = ''
    for digit in str(number):
        chinese_str += chinese_map[int(digit)]
    return chinese_str


def number_to_chinese(number):
    chinese_dict = {0: '零', 1: '一', 2: '二', 3: '三', 4: '四', 5: '五', 6: '六', 7: '七', 8: '八', 9: '九'}
    chinese_str = ''
    for i in str(number):
        chinese_str += chinese_dict[int(i)]
    return chinese_str