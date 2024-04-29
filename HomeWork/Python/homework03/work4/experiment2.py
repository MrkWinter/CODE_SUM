# 实验名称：（宋体四号）
#     实验二：字典和集合
# 实验目的：
# 1、掌握字典的创建与访问、添加、删除、修改列表元素的方式。
# 2、掌握集合的创建与访问、添加、删除、修改列表元素的方式。
# 实验内容（方法步骤及代码）：


# 1、统计字符串中每个字符出现的次数，将结果存入字典，并计算字符串中出现次数最多的字符以及次数。
# 代码如下：
def count_characters(input_string):
    char_count = {}
    for char in input_string:
        if char in char_count:
            char_count[char] += 1
        else:
            char_count[char] = 1

    max_char = max(char_count, key=char_count.get)
    max_count = char_count[max_char]
    return char_count, max_char, max_count


def count_characters(input_string):
    count_dict = {}
    for i in input_string:
        if i in count_dict:
            count_dict[i] += 1
        else:
            count_dict[i] = 1
    max_key = max(count_dict, key=count_dict.get)
    max_count = count_dict[max_key]
    return max_key, max_count


# 2、用字典创建一个学生成绩管理系统，可以进行查看学生成绩、增加学生成绩、修改学校成绩、删除学生成绩、退出系统。
# 代码如下:
class ScoreManager:
    def __init__(self):
        self.scores = {}

    def add_score(self, name, score):
        self.scores[name] = score
        print(f"已添加成绩 {name}.")

    def remove_score(self, name):
        if name in self.scores:
            del self.scores[name]
            print(f"已删除成绩 {name}.")
        else:
            print(f"{name} 成绩未添加.")

    def update_score(self, name, new_score):
        if name in self.scores:
            self.scores[name] = new_score
            print(f"已修改成绩 {name}.")
        else:
            print(f"{name} 成绩未添加.")

    def show_scores(self):
        if len(self.scores):
            print("学生成绩:")
            for name, score in self.scores.items():
                print(f"{name}: {score}")
        else:
            print("没有学生成绩.")


# 3、编写生词本程序，该程序具有查看生词列表、背单词、添加新单词、删除单词和清空生词本的功能。
# 代码如下:
class VocabularyBook:
    def __init__(self):
        self.vocabulary = {}

    def add_word(self, word, mean):
        self.vocabulary[word] = mean
        print(f"单词已经添加: {word}:{mean}.")

    def remove_word(self, word):
        if word in self.vocabulary:
            del self.vocabulary[word]
            print(f"已移除: {word}.")
        else:
            print(f"{word} 不在单词本中.")

    def clear_vocabulary(self):
        self.vocabulary = {}
        print("单词已清空.")

    def show_vocabulary(self):
        if len(self.vocabulary):
            print("单词如下:")
            for word, mean in self.vocabulary.items():
                print(f"单词{word}:{mean}")
        else:
            print("单词本为空.")

    def learn_word(self):
        import random
        if len(self.vocabulary):
            random_key = random.choice(self.vocabulary)
            print(f"单词{random_key}:{self.vocabulary[random_key]}")
        else:
            print("单词本为空.")
