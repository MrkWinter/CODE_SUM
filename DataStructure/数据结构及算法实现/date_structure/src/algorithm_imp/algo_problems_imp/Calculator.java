package algorithm_imp.algo_problems_imp;

/**
 * @author MrkWinter
 * @version 1.0
 * 2 计数器 问题实现
 */
public class Calculator {
    public static void main(String[] args) {
        String expression = "2*2*3+1";
        int calculate = calculate(expression);
        System.out.println(calculate);
    }

    public static int calculate(String expression) {
        //初始化数字栈和符号栈
        ArrayStack numStack = new ArrayStack(20);
        ArrayStack opeStack = new ArrayStack(20);
        char[] expCharArr = expression.toCharArray();
        //初始化所用变量
        String spl = "";
        int num1 = 0;
        int num2 = 0;
        char operator = 0;
        int result = 0;
        //遍历表达式 计算或放入对应的栈中
        for (int i = 0; i < expCharArr.length; i++) {
            char curChar = expCharArr[i];
            if (ArrayStack.isOperator(curChar)) {
                //判断是符号  入符号栈
                if (opeStack.isEmpty())
                    //1. 符号栈为空 直接加入
                    opeStack.push(curChar);
                else if (curChar == '(')
                    //2. 符号为 '(' 直接加入
                    opeStack.push(curChar);
                else if (curChar == ')') {
                    //3. 符号为 ')' 开始括号中的运算 此步是为了简化最终运算 最终运算只有 + 和 -
                    while ((operator = (char) opeStack.pop()) != '(') {
                        //注意括号中的* 和 / 等高运算级的符号以及在下面运算过 所有括号中的运算只有 + 和 /
                        //直到弹出'('为止结束
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        result = ArrayStack.simpleCal(num2, num1, operator);
                        numStack.push(result);
                    }
                } else {
                    //4. 符号为 * / 等高运算优先级的 先进行运算 简化为 + 和 -
                    //试想 2*3*4 + 2
                    while (!opeStack.isEmpty() && ArrayStack.priority((char) opeStack.peek()) > ArrayStack.priority(curChar)) {
                        //如果栈顶的符号运算优先级高 先取出 进行运算
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        operator = (char) opeStack.pop();
                        result = ArrayStack.simpleCal(num2, num1, operator);
                        numStack.push(result);
                    }
                    //2023年9月11日10:34:10
                    // bug： 使用if else 多次高运算级运算 判断只会简化一次
                    //解决： 使用while循环 把所有高运算级运算简化
                    opeStack.push(curChar);
                }
            } else {
                //判断是数字 数字栈
                spl += curChar;
                if (i + 1 == expCharArr.length || ArrayStack.isOperator(expCharArr[i + 1])) {
                    //下一个是符号 或者没有下一个  (注意情况 最后一个必定是数字 第一个条件就是判断最后一个数字的特殊情况)
                    //方法考虑 考虑开头 考虑中间 考虑结尾  两端出问题的可能性较大 -- 临界值问题原则
                    numStack.push(Integer.parseInt(spl));
                    spl = "";
                }
            }
        }
        //符号加入栈完毕 开始出栈计算
        while (numStack.getNum() != 1) {
            // 简单加减运算
            num1 = numStack.pop();
            num2 = numStack.pop();
            operator = (char) opeStack.pop();
            result = ArrayStack.simpleCal(num2, num1, operator);
            numStack.push(result);
        }
        return numStack.peek();
        //返回数字栈最后一个数
    }
}

class ArrayStack {
    private int maxSize;
    private int top;
    private int[] stackArr;

    //初始化栈
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        stackArr = new int[maxSize];
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
    public void push(int num) {
        if (isFull()) {
            throw new RuntimeException("栈满");
        }
        stackArr[++top] = num;
    }

    //出栈
    public int pop() {
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
    public int peek() {
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