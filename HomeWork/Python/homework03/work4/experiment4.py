# 实验名称：（宋体四号）
#     实验四：类与对象
# 实验目的：
# 1、掌握类的定义与调用、面向对象概念。
# 2、掌握类的三大特性。
# 实验内容（方法步骤及代码）：


# 1、银行管理系统是一个集开户、查询、取款、存款、转账、锁定、解锁、退出等一系列的功能的管理系统。使用类编写此程序。
# 代码如下:
class BankAccount:
    def __init__(self, name, balance=0, locked=False):
        self.name = name
        self.balance = balance
        self.locked = locked

    def deposit(self, amount):
        if not self.locked:
            self.balance += amount
            print(f"存款 {amount} 成功.")
        else:
            print("账户被锁.")

    def withdraw(self, amount):
        if not self.locked:
            if self.balance >= amount:
                self.balance -= amount
                print(f"取款 {amount} 成功.")
            else:
                print("账户没钱.")
        else:
            print("账户被锁.")

    def transfer(self, recipient, amount):
        if not self.locked and not recipient.locked:
            if self.balance >= amount:
                self.balance -= amount
                recipient.balance += amount
                print(f"转账 {amount} to {recipient.name} 成功.")
            else:
                print("账户没钱.")
        else:
            print("账户被锁.")

    def lock_account(self):
        self.locked = True
        print("账户被锁.")

    def unlock_account(self):
        self.locked = False
        print("账户解锁.")

    def check_balance(self):
        print(f"当前账户余额: {self.balance}")


# 2、井字棋游戏有两名玩家，其中一个玩家画圈，另一个玩家画叉，轮流在3 * 3
# 格子上画上自己的符号，最先在横向、纵向或斜线方向连成一条线的人为胜利方。使用类编写此程序。
# 代码如下:


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
        if (self.board[0][0] == self.board[1][1] == self.board[2][2] != ' ') or (
                self.board[0][2] == self.board[1][1] == self.board[2][0] != ' '):
            return True
        return False

    def check_draw(self):
        for row in self.board:
            for cell in row:
                if cell == ' ':
                    return False
        return True
