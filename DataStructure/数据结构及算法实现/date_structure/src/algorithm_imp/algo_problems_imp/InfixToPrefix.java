package algorithm_imp.algo_problems_imp;

/**
 * @author MrkWinter
 * @version 1.0
 * 3. 中缀表达式转后缀表达式问题
 */
public class InfixToPrefix {
    public static void main(String[] args) {
        String s = new InfixToPrefix().infixToPrefix("(1+1)*3");
        System.out.println(s);
    }

    public String infixToPrefix(String expression) {
        //初始化数字栈 和 符号栈
        ArrayStack2 numStack = new ArrayStack2(20);
        ArrayStack2 opeStack = new ArrayStack2(20);
        char[] charArray = expression.toCharArray();
        //使用到的变量
        String spl = "";
        String opera = null;
        String result = "";
        //循环符号 在栈中进行操作 得到 后序表达式
        for (int i = 0; i < charArray.length; i++) {
            char curChar = charArray[i];
            if (ArrayStack2.isOperator(curChar)) {
                //1 如果是符号
                if (curChar == ')') {
                    //1.1 如果是) 不断将符号栈出栈压入数字栈中
                    while (true) {
                        opera = opeStack.pop();
                        if (opera.charAt(0) == '(')
                            break;
                        numStack.push(opera);
                    }
                } else {
                    //1.2 如果是+ - * / 将符号放到符号栈合适的位置
                    while (true) {
                        //如果符号栈为空 放入 如果符号为( 放入 如果符号小于符号栈栈顶优先级 放入 然后跳出
                        if (opeStack.isEmpty() || curChar == '(' ||
                                ArrayStack2.priority(opeStack.peek().charAt(0)) < ArrayStack2.priority(curChar)) {
                            opeStack.push(curChar + "");
                            break;
                        } else {
                            //否则 一直将符号栈中的符号压入数字栈
                            numStack.push(opeStack.pop());
                        }
                    }
                }
            } else {
                //2 如果是数字
                spl += curChar;
                //考虑多位数问题 直接压入数字栈
                if (i + 1 == charArray.length || ArrayStack2.isOperator(charArray[i + 1])) {
                    numStack.push(spl);
                    spl = "";
                }
            }
        }
        while (!opeStack.isEmpty()) {
            //3将符号栈中符号全部压入数字栈
            numStack.push(opeStack.pop());
        }
        while (!numStack.isEmpty()) {
            //4数字栈取出的数据即为逆波兰表达式
            result = numStack.pop() + result;
        }
        return result;
    }
}

class ArrayStack2 {
    private int maxSize;
    private int top;
    private String[] stackArr;

    //初始化栈
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        stackArr = new String[maxSize];
    }

    //判断栈为空
    public boolean isEmpty() {
        return top == -1;
    }

    //判断栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //入栈
    public void push(String num) {
        if (isFull()) {
            throw new RuntimeException("栈满");
        }
        stackArr[++top] = num;
    }

    //出栈
    public String pop() {
        if (isFull()) {
            throw new RuntimeException("栈空");
        }
        return stackArr[top--];
    }

    //显示栈
    public void showStack() {
        if (isEmpty()) {
            System.out.println("空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(stackArr[i] + " ");
        }
    }

    //查看栈顶元素
    public String peek() {
        return stackArr[top];
    }

    //查看栈中元素个数
    public int getNum() {
        return top + 1;
    }

    //判断运算符优先级
    public static int priority(char operator) {
        if (operator == '/' || operator == '*')
            return 1;
        if (operator == '+' || operator == '-')
            return 0;
        else
            return -1;
    }

    //简单计算
    public static int simpleCal(int num1, int num2, char operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }

    //判断是否为运算符
    public static boolean isOperator(char operator) {
        if (operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '(' || operator == ')') {
            return true;
        }
        return false;
    }
}