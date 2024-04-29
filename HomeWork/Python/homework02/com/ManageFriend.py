def manage():
    choice = 0
    friend_list = list()
    while choice != '5':
        print("1: 添加好友\n2: 删除好友\n3: 备注好友\n4: 展示好友\n5: 退出")
        choice = input("请输入")
        if choice == '1':
            name = input("输入好友名称")
            friend_list.append(name)
            print("添加成功")
        elif choice == '2':
            name = input("输入好友名称")
            friend_list.remove(name)
            print("删除成功")
        elif choice == '3':
            name = input("输入原始好友名称")
            update_name = input("输入修改后的好友名称")
            friend_list[friend_list.index(name)] = update_name
            print("备注成功")
        elif choice == '4':
            print("当前好友列表" + str(friend_list))
        else:
            print("输入有误")


if __name__ == '__main__':
    manage()
