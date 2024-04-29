package com.work02;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class Calculate {
    public static void main(String[] args) {
        double x = 1.2;
        double y = 0.8;

        double result = calculateExpression(x, y);

        System.out.println("Expression result: " + result);
    }

    public static double calculateExpression(double x, double y) {
        double numerator = Math.pow(3, x);
        double denominator = Math.pow(3, x) + Math.pow(3, y);
        double logValue = Math.log(numerator / denominator) / Math.log(2);

        double sinValue = Math.sin(Math.sqrt(x));
        double arccosValue = Math.acos(y);

        double expressionResult = logValue * (sinValue + arccosValue);

        return expressionResult;
    }
}

