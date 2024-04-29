# 学生成绩管理

def manage_grade():
    grade_dict = dict()
    while True:
        choose = input("请输入选项：\n1.添加学生成绩\n2.删除学生成绩\n"
                       "3.查询学生成绩\n4.修改学生成绩\n5.查看所有学生成绩\n0.退出")
        if choose == '1':
            name = input("输入学生姓名")
            if name in grade_dict:
                print("该学生信息已存在")
                continue
            grade = input("输入学生分数")
            grade_dict[name] = grade
            print("添加成功")
        elif choose == '2':
            name = input("输入学生姓名")
            if name not in grade_dict:
                print("该学生信息不存在")
                continue
            del grade_dict[name]
            print("删除成功")
        elif choose == '3':
            name = input("输入学生姓名")
            if name not in grade_dict:
                print("该学生信息不存在")
                continue
            print(f"{name}:{grade_dict[name]}分")
        elif choose == '4':
            name = input("输入学生姓名")
            if name not in grade_dict:
                print("该学生信息不存在")
                continue
            grade = input("输入学生分数")
            grade_dict[name] = grade
            print("修改成功")
        elif choose == '5':
            for i in grade_dict:
                print(f"{i}:{grade_dict[i]}分")
        elif choose == '0':
            break


if __name__ == '__main__':
    manage_grade()
