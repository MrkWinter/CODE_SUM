package com.test;
import java.util.Stack;
public class Homework1 {
	 public static int findGCD(int a, int b) {
	        if (b == 0) {
	            return a;
	        }
	        return findGCD(b, a % b);
	    }

	    public static int findLCM(int a, int b) {
	        return (a * b) / findGCD(a, b);
	    }

	    public static void main(String[] args) {
	        int num1 = 24;
	        int num2 = 36;

	        int gcd = findGCD(num1, num2);
	        int lcm = findLCM(num1, num2);

	        System.out.println("最大公约数：" + gcd);
	        System.out.println("最小公倍数：" + lcm);
	    }
}




class ExpressionCalculator {
    public static int calculateExpression(String expression) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                i--;
                operands.push(num);
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (operators.peek() != '(') {
                    evaluate(operands, operators);
                }
                operators.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)) {
                    evaluate(operands, operators);
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            evaluate(operands, operators);
        }

        return operands.pop();
    }

    private static void evaluate(Stack<Integer> operands, Stack<Character> operators) {
        int b = operands.pop();
        int a = operands.pop();
        char op = operators.pop();
        int result = 0;
        if (op == '+') {
            result = a + b;
        } else if (op == '-') {
            result = a - b;
        } else if (op == '*') {
            result = a * b;
        } else if (op == '/') {
            result = a / b;
        }
        operands.push(result);
    }

    private static int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*' || op == '/') {
            return 2;
        }
        return 0;
    }

    public static void main(String[] args) {
        String expression = "2*(3+5)-6/2"; // 表达式示例
        int result = calculateExpression(expression);
        System.out.println("表达式的值为: " + result);
    }
}

