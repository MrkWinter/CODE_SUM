# 生词本
import random


def new_word():
    word_dict = dict()
    while True:
        choose = input("请输入选项：\n1.添加单词\n2.删除单词\n"
                       "3.显示单词\n4.背单词\n5.清空单词\n0.退出")
        if choose == '1':
            word = input("输入单词")
            if word in word_dict:
                print("该单词已存在")
                continue
            china = input("输入翻译")
            word_dict[word] = china
            print("添加成功")
        elif choose == '2':
            if len(word_dict) == 0:
                print("单词表为空")
                continue
            word = input("输入单词")
            if word not in word_dict:
                print("该单词不存在")
                continue
            del word_dict[word]
            print("删除成功")
        elif choose == '3':
            if len(word_dict) == 0:
                print("单词表为空")
                continue
            for i in word_dict:
                print(f"{i}:{word_dict[i]}")
        elif choose == '4':
            if len(word_dict) == 0:
                print("单词表为空")
                continue
            i = 3
            random_word = random.choice(list(word_dict.keys()))  # 随机得到字典中的一个word
            print(random_word)
            while i != 0:
                china = input("输入汉语意思")
                if china == word_dict[random_word]:
                    print("正确")
                    break
                else:
                    print("再想想")
                i -= 1
            if i == 0:
                print(f"正确翻译为{word_dict[random_word]}")
        elif choose == '5':
            if len(word_dict) == 0:
                print("单词表为空")
                continue
            cho = input("确认清空?  y/n)")
            if cho == 'y' or cho == 'Y':
                word_dict.clear()
                print("清除成功")
        elif choose == '0':
            break


if __name__ == '__main__':
    new_word()
