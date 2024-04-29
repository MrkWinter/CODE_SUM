package com.learn2;

public class Test {
    public static void main(String[] args) {
        double num1 = 3.141592653;
        double num2 = 3.140000000;

        String formattedNum1 = String.format("%.9g", num1);
        String formattedNum2 = String.format("%.9g", num2);

        System.out.println(formattedNum1); // 输出结果为 3.14159265
        System.out.println(formattedNum2); // 输出结果为 3.14
    }
}
