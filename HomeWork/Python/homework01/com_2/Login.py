def information(_user: str, _password: str):
    def login(user: str, password: str) -> bool:
        if user == _user and password == _password:  # 闭包
            return True
        else:
            return False

    return login


if __name__ == '__main__':
    login1 = information("root", "123456")
    count: int = 3
    while True:
        if login1(input("请输入账号:"), input("请输入密码")):
            print("登录成功")
            break
        else:
            count -= 1
            if count <= 0:
                print("错误次数过多 请稍后重试")
                break
            print(f"您还有{count}次机会")
