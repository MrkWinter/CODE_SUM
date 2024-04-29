def calculator():
    while True:
        expression = input("请输入要计算的表达式（或输入 q 退出）：")
        if expression == 'q':
            print("计算器已退出。")
            break
        try:
            # 解析表达式
            operator = expression[1]
            num1 = float(expression[0])
            num2 = float(expression[2])

            # 执行运算
            if operator == '+':
                result = num1 + num2
            elif operator == '-':
                result = num1 - num2
            elif operator == '*':
                result = num1 * num2
            elif operator == '/':
                # 处理除零错误
                if num2 == 0:
                    print("除数不能为零，请重新输入。")
                    continue
                result = num1 / num2
            else:
                print("不支持的运算符，请重新输入。")
                continue
            print("计算结果：", result)
        except Exception as e:
            print("发生错误，请重新输入。错误信息：", str(e))




if __name__ == '__main__':
    calculator()

