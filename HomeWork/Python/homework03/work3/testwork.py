import random


# 1、使用count函数找出列表中出现次数最多的元素，以及该元素出现的次数。
# 代码如下:

# def findENums(list: list):
#     max:int = 0
#     e = None
#     for i in set(list):
#         if list.count(i) > max:
#             max = list.count(i)
#             e = i
#     return max, e
#
# if __name__ == '__main__':
#     list1 = [1,2,2,2,3,3,5,5,6];
#     max,e = findENums(list1)
#     print(max,e)

# 2、定义一个列表，将列表中重复的元素去掉，只保留一个即可。并将新的列表转换成元组。
# 代码如下:
# def turnTuple(list:list) -> tuple:
#     list1 = []
#     for i in list:
#         if i not in list1:
#             list1.append(i)
#     return tuple(list1)
#
# if __name__ == '__main__':
#     list1 = [1,2,3,45,4,4,4,4,4]
#     tuple2 = turnTuple(list1)
#     print(tuple2)
# 3、编写好友管理系统，包括添加好友、删除好友、备注好友、展示好友等。
# 代码如下:
# def startFriend() :
#     friend:list = list()
#     isReturn = False
#     while isReturn != True:
#         option = input("输入数据12345")
#         if option == '1':
#             friendName = input("好友信息")
#             friend.append(friendName)
#         if option == '2':
#             friend.remove(input("好友信息"))
#         if option == '3':
#             friend[friend.index(input("好友名"))] = input("备注名")
#         if option == '4':
#             print(friend)
#         if option == '5':
#             isReturn = True
# if __name__ == '__main__':
#     startFriend()
# 4、中文数字对照表，实现将输入的阿拉伯数字转为中文大写数字的功能。
# 代码如下:
# def upperWord(string: str) -> str:
#     wordList = ['零', '一', '二', '三', '四', '五', '流', '七', '八', '九']
#     listStr = list(string)
#     for i in string:
#         if str(i).isdigit():
#             c = listStr.index(i)
#             listStr[c] = wordList[int(i)]
#     return str(listStr)
#
#
# if __name__ == '__main__':
#     print(upperWord("12,er3,46,4"))
#
#
# if __name__ == '__main__':

# 1、统计字符串中每个字符出现的次数，将结果存入字典，并计算字符串中出现次数最多的字符以及次数。
# def count_str_number(str: str) -> dict:
#     str_dict: dict = dict()
#     for i in set(str):
#         num = str.count(i)
#         str_dict[i] = num
#     max = 0
#     return_str = ''
#     for i in str_dict:
#         if str_dict[i]>max:
#             max = str_dict[i]
#             return_str = i
#     print(str_dict)
#     return return_str,max
#
# if __name__ == '__main__':
#     i,j = count_str_number("aabbccddeeffghiogldoafg")
#     print(f"次数最多字符{i},次数{j}")
# 2、用字典创建一个学生成绩管理系统，可以进行查看学生成绩、增加学生成绩、修改学校成绩、删除学生成绩、退出系统。
# def grade_manger():
#     grade_dict = {}
#     is_return = False
#     while not is_return:
#         option = input("输入选项增1删2改3查4退5")
#         if option == '1':
#             name = input("学生名")
#             print("现在输入各科成绩 0返回 1添加")
#             fl = True
#             grade_d = {}
#             while fl:
#                 op = input("选择")
#                 if op == '0':
#                     fl = False
#                 if op == '1':
#                     subject = input("学科名")
#                     grade = input("分数")
#                     grade_d[subject] = grade
#             grade_dict[name] = grade_d
#             print("success")
#         if option == '2':
#             del_name = input("删除学生姓名")
#             if del_name in grade_dict.keys():
#                 del grade_dict[del_name]
#                 print("success")
#         if option == '3':
#             print(grade_dict)
#         if option == '4':
#             up_name = input("修改学生名")
#             if up_name in grade_dict.keys():
#                 for i in grade_dict[up_name].keys():
#                     grade = input(f"{i}成绩为")
#                     grade_dict[up_name][i] = grade
#             print("success")
#         if option == '5':
#             is_return = True
#
# if __name__ == '__main__':
#     grade_manger()
# 3、编写生词本程序，该程序具有查看生词列表、背单词、添加新单词、删除单词和清空生词本的功能。
# def new_word():
#     word = dict()
#     is_return = False
#     while not is_return:
#         option = input("选项 1添加 2删除 3清空 4查询 5背 6退出")
#         if (option == '1'):
#             word_sp = input("单词")
#             word_mn = input("意思")
#             word[word_sp] = word_mn
#             print("success")
#         if (option == '2'):
#             word_sp = input("单词")
#             word.pop(word_sp)
#             print("success")
#         if (option == '3'):
#             word.clear()
#             print("success")
#         if (option == '4'):
#             print(word)
#         if (option == '5'):
#
#             word_list = list(word.keys())
#             if len(word_list) == 0:
#                 continue
#             i = random.randint(0, len(word_list) - 1)
#             print(word_list[i], word[word_list[i]])
#         if option == '6'
#             is_return = True
#
# if __name__ == '__main__':
#     new_word()

# 1、定义一个函数实现计算机的四则运算，并可以连续计算操作。调用函数验证功能。
# def calcul():
#     get_result = False
#     num = float(input('数字'))
#     while not get_result:
#         option = input("加1 减2 乘3 除4 计算0")
#         if option == '1':
#             n = float(input("加上"))
#             num += n
#         if option == '2':
#             n = float(input("减去"))
#             num -= n
#         if option == '3':
#             n = float(input("乘上"))
#             num *= n
#         if option == '4':
#             n = float(input("除以"))
#             num /= n
#         if option == '0':
#             get_result = True
#     print(num)
#
#
# if __name__ == '__main__':
#     calcul()


# 2、定义一个函数，用冒泡排序法给列表排序。
# def bubble_sort(list1: list) -> list:
#     for i in range(0, len(list1) - 1):
#         flag = False
#         for j in range(0, len(list1) - 1 - i):
#             if list1[j] > list1[j + 1]:
#                 flag = True
#                 list1[j] = list1[j] ^ list1[j + 1]
#                 list1[j + 1] = list1[j] ^ list1[j + 1]
#                 list1[j] = list1[j] ^ list1[j + 1]
#         if not flag:
#             break
#     return list1
#
#
# if __name__ == '__main__':
#     sort_list = bubble_sort([1, 4, 8, 2, 5, 3, 7, 4])
#     print(sort_list)
# 3、定义一个函数，可以实现字典的键和值实现互换。
# def change_dict(dict1: dict) -> dict:
#     return_dict = dict()
#     for i in dict1:
#         return_dict[dict1[i]] = i
#     return return_dict
#
# if __name__ == '__main__':
#     dict2 = change_dict({1:"22",2:"32"})
#     print(dict2)
# 4、定义一个函数，可以计算输入数据的前n项阶乘之和。

# def getSSum(num: int) -> int:
#     mNum = 1
#     result = 0
#     for i in range(1, num + 1):
#         mNum *= i
#         result += mNum
#     return result
#
# if __name__ == '__main__':
#     result = getSSum(4)
#     print(result)

# 5、定义一个函数，计算给定字符串中的最长回文字符串。例如'abacddc'返回cddc。
# def getStr(str1: str) -> [str, int]:
#     maxLen = 0
#     maxstr = 'a'
#     for i in range(0, len(str1)):
#         j = 0
#         while i + j < len(str1):
#             if str1[i: i + j + 1: 1] == str1[i + j: i - 1: -1]:
#                 if maxLen < j:
#                     maxLen = j
#                     maxstr = str1[i:i + j + 1]
#             j += 1
#     return maxstr
#
#
# if __name__ == '__main__':
#     str1 = getStr("abacddc")
#     print(str1)
#
# 1、银行管理系统是一个集开户、查询、取款、存款、转账、锁定、解锁、退出等一系列的功能的管理系统。使用类编写此程序。
# class bank_manager:
#
#     def __init__(self):
#         self.__bank_account = dict()  # 账号名 与密[码 锁 余额]
#
#     def open_account(self):
#         name = input("账号名")
#         password = input("密码")
#         if name not in self.__bank_account.keys():
#             self.__bank_account[name] = [password, True, 0]
#
#     def search_account(self):
#         name = input("账号名")
#         password = input("密码")
#         if name in self.__bank_account.keys() and self.__bank_account[name][0] == password and \
#                 self.__bank_account[name][1]:
#             print(self.__bank_account[name])
#
#     def get_maney(self):
#         name = input("账户名")
#         password = input("密码")
#         if name in self.__bank_account.keys() and self.__bank_account[name][0] == password and \
#                 self.__bank_account[name][1]:
#             number = input("取款数")
#             self.__bank_account[name][2] -= number
#
#     def seve_money(self):
#         name = input("账户名")
#         password = input("密码")
#         if name in self.__bank_account.keys() and self.__bank_account[name][0] == password and \
#                 self.__bank_account[name][1]:
#             number = input("存款数")
#             self.__bank_account[name][2] += number
#
#     def tan_maney(self):
#         name = input("账户名")
#         password = input("密码")
#         t_name = input("转账用户")
#         if name in self.__bank_account.keys() and self.__bank_account[name][0] == password and \
#                 t_name in self.__bank_account.keys() and self.__bank_account[name][1]:
#             number = input("转账数")
#             self.__bank_account[name][2] -= number
#             self.__bank_account[t_name][2] += number
#
#     def lock(self):
#         name = input("账户名")
#         password = input("密码")
#         if name in self.__bank_account.keys() and self.__bank_account[name][0] == password:
#             self.__bank_account[name][1] += False
#
#     def un_lock(self):
#         name = input("账户名")
#         password = input("密码")
#         if name in self.__bank_account.keys() and self.__bank_account[name][0] == password:
#             self.__bank_account[name][1] += True

# 2、井字棋游戏有两名玩家，其中一个玩家画圈，另一个玩家画叉，轮流在3 * 3格子上画上自己的符号，最先在横向、纵向或斜线方向连成一条线的人为胜利方。使用类编写此程序。
class TicTacToe:
    def __init__(self):
        self.board = [[' ' for _ in range(3)] for _ in range(3)]
        self.current_player = 'X'
    def print_board(self):
        for row in self.board:
            print("|".join(row))
            print("-----")
    def make_move(self, row, col):
        if self.board[row][col] == ' ':
            self.board[row][col] = self.current_player
            if self.check_winner(row, col):
                print(f"Player {self.current_player} wins!")
                self.print_board()
                return True
            elif self.check_draw():
                print("It's a draw!")
                self.print_board()
                return True
            else:
                self.current_player = 'O' if self.current_player == 'X' else 'X'
                return False
        else:
            print("Invalid move. Please try again.")
            return False

    def check_winner(self, row, col):
        # Check row
        if self.board[row][0] == self.board[row][1] == self.board[row][2] != ' ':
            return True
        # Check column
        if self.board[0][col] == self.board[1][col] == self.board[2][col] != ' ':
            return True
        # Check diagonals
        if (self.board[0][0] == self.board[1][1] == self.board[2][2] != ' ') or (self.board[0][2] == self.board[1][1] == self.board[2][0] != ' '):
            return True
        return False
    def check_draw(self):
        for row in self.board:
            for cell in row:
                if cell == ' ':
                    return False
        return True
