import random

# 用户类
class User:
    def __init__(self, name, id_card, phone, balance, password):
        self.name = name
        self.id_card = id_card
        self.phone = phone
        self.balance = balance
        self.password = password

# 银行类
class Bank:
    def __init__(self):
        self.users = {}  # 存储用户信息的字典

    # 开户功能
    def create_account(self):
        name = input("请输入姓名: ")
        id_card = input("请输入身份证号: ")
        phone = input("请输入手机号: ")
        balance = float(input("请输入预存金额: "))
        password = input("请输入密码: ")

        # 生成一个不重复的 6 位数字卡号
        card_number = str(random.randint(100000, 999999))
        while card_number in self.users:
            card_number = str(random.randint(100000, 999999))

        # 创建用户对象并存储到字典中
        user = User(name, id_card, phone, balance, password)
        self.users[card_number] = user

        print("开户成功，您的卡号是:", card_number)

    # 查询功能
    def query_balance(self):
        card_number = input("请输入卡号: ")
        password = input("请输入密码: ")

        if card_number in self.users and self.users[card_number].password == password:
            print("您的余额是:", self.users[card_number].balance)
        else:
            print("卡号或密码错误")

    # 取款功能
    def withdraw(self):
        card_number = input("请输入卡号: ")
        password = input("请输入密码: ")

        if card_number in self.users and self.users[card_number].password == password:
            user = self.users[card_number]
            print("您的余额是:", user.balance)

            for _ in range(3):
                password = input("请输入密码: ")
                if password == user.password:
                    amount = float(input("请输入取款金额: "))
                    if amount > user.balance or amount < 0:
                        print("取款金额错误")
                    else:
                        user.balance -= amount
                        print("取款成功，您的余额是:", user.balance)
                    break
                else:
                    print("密码错误")
            else:
                print("密码错误次数超过限制，卡号被锁定")
        else:
            print("卡号或密码错误")

    # 存款功能
    def deposit(self):
        card_number = input("请输入卡号: ")
        password = input("请输入密码: ")

        if card_number in self.users and self.users[card_number].password == password:
            user = self.users[card_number]
            print("您的余额是:", user.balance)

            for _ in range(3):
                password = input("请输入密码: ")
                if password == user.password:
                    amount = float(input("请输入存款金额: "))
                    if amount < 0:
                        print("存款金额错误")
                    else:
                        user.balance += amount
                        print("存款成功，您的余额是:", user.balance)
                    break
                else:
                    print("密码错误")
            else:
                print("密码错误次数超过限制，卡号被锁定")
        else:
            print("卡号或密码错误")

    # 转账功能
    def transfer(self):
        from_card_number = input("请输入转出卡号: ")
        from_password = input("请输入转出卡密码: ")
        to_card_number = input("请输入转入卡号: ")

        if from_card_number in self.users and self.users[from_card_number].password == from_password:
            from_user = self.users[from_card_number]
            to_user = self.users.get(to_card_number)

            if to_user:
                print("转出卡余额:", from_user.balance)

                for _ in range(3):
                    from_password = input("请输入转出卡密码: ")
                    if from_password == from_user.password:
                        amount = float(input("请输入转账金额: "))
                        if amount > from_user.balance or amount < 0:
                            print("转账金额错误")
                        else:
                            from_user.balance -= amount
                            to_user.balance += amount
                            print("转账成功")
                        break
                    else:
                        print("密码错误")
                else:
                    print("密码错误次数超过限制，卡号被锁定")
            else:
                print("转入卡号不存在")
        else:
            print("转出卡号或密码错误")

    # 锁定功能
    def lock_card(self):
        card_number = input("请输入卡号: ")
        password = input("请输入密码: ")

        if card_number in self.users and self.users[card_number].password == password:
            del self.users[card_number]
            print("卡号已被锁定")
        else:
            print("卡号或密码错误")

    # 解锁功能
    def unlock_card(self):
        card_number = input("请输入卡号: ")
        password = input("请输入密码: ")

        if card_number not in self.users:
            name = input("请输入姓名: ")
            id_card = input("请输入身份证号: ")
            phone = input("请输入手机号: ")
            balance = float(input("请输入预存金额: "))
            new_password = input("请输入新密码: ")

            user = User(name, id_card, phone, balance, new_password)
            self.users[card_number] = user
            print("卡号已解锁")
        else:
            print("卡号已存在")

    # 退出功能
    def exit_system(self):
        admin_account = input("请输入管理员账户: ")
        admin_password = input("请输入管理员密码: ")

        if admin_account == "admin" and admin_password == "admin123":
            # 执行存盘操作
            self.save_data()
            print("存盘成功，系统已退出")
            exit()
        else:
            print("管理员账户或密码错误")

    # 存盘功能
    def save_data(self):
        with open("data.txt", "w") as file:
            for card_number, user in self.users.items():
                data = f"{card_number},{user.name},{user.id_card},{user.phone},{user.balance},{user.password}\n"
                file.write(data)

    # 加载数据
    def load_data(self):
        try:
            with open("data.txt", "r") as file:
                for line in file:
                    card_number, name, id_card, phone, balance, password = line.strip().split(",")
                    user = User(name, id_card, phone, float(balance), password)
                    self.users[card_number] = user
        except FileNotFoundError:
            pass

# 主函数
if __name__ == '__main__':
    bank = Bank()
    bank.load_data()

    while True:
        print("1. 开户")
        print("2. 查询")
        print("3. 取款")
        print("4. 存款")
        print("5. 转账")
        print("6. 锁定")
        print("7. 解锁")
        print("8. 退出")

        choice = input("请选择功能: ")
        if choice == "1":
            bank.create_account()
        elif choice == "2":
            bank.query_balance()
        elif choice == "3":
            bank.withdraw()
        elif choice == "4":
            bank.deposit()
        elif choice == "5":
            bank.transfer()
        elif choice == "6":
            bank.lock_card()
        elif choice == "7":
            bank.unlock_card()
        elif choice == "8":
            bank.exit_system()
        else:
            print("无效的选择，请重新输入")
