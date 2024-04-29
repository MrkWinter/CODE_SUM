#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

//递归计算n的阶乘
//int factorial(int n)
//{
//	if (n == 1)
//		return 1;
//	else
//		return n * factorial(n - 1);
//}
//int main()
//{
//	int n;
//	printf("请输入一个数,计算该数的阶乘:\n");
//	scanf("%d", &n);
//	printf("%d", factorial(n));
//	return 0;
//}

//用递归得到斐波那契数列的前n项

//int fibonacci(int i)
//{
//	if (i == 1)
//		return 0;
//	if (i == 2)
//		return 1;
//	return fibonacci(i-1) + fibonacci(i - 2);
//}
//int main()
//{
//	int n;
//	printf("请输入一个数:\n");
//	scanf("%d", &n);
//	for (int i = 1; i <= n; i++)
//	{
//		printf("%d\t",fibonacci(i));
//	}
//	return 0;
//}

//把任意一个整数转换成字符串 把字符串转换成整数

//char* tostring(int i)
//{
//	int n;
//	int temp = i;
//	for (n = 0; temp; temp = temp / 10,n++);
//	char* str = (char*)malloc(sizeof(char)* n + 2);
//	if (i >= 0)
//	{
//		str[n] = '\0';
//		for (int j = n - 1; j >= 0; j--, i = i / 10)
//		{
//			str[j] = i % 10 + '0';
//		}
//	}
//	else
//	{
//		i = -i;
//		str[n+1] = '\0';
//		for (int j = n; j > 0; j--, i = i / 10)
//		{
//			str[j] = (i % 10) + 0x30;
//		}
//		str[0] = '-';
//	}
//	return str;
//}
//int tointeger(char* str)
//{
//	int ret = 0;
//	int digit = 1;
//	if (str[0] != '-')
//	{
//		for (int i = strlen(str) - 1; i >= 0; i--)
//		{
//			ret += (str[i] - 0x30)*digit;
//			digit *= 10;
//		}
//	}
//	else
//	{
//		for (int i = strlen(str) - 1; i > 0; i--)
//		{
//			ret += (str[i] - '0')*digit;
//			digit *= 10;
//		}
//		ret = -ret;
//	}
//	return ret;
//}
//int main()
//{
//	int i;
//	int input;
//	char str[100];
//	printf("1.输入字符串 2.输入整数\n");
//	scanf("%d", &input);
//	switch (input)
//	{
//		case 1:
//			scanf("%s", str);
//			printf("%d",tointeger(str)); //字符串转化成整数
//			break;
//		case 2:
//			scanf("%d", &i);
//			printf("%s", tostring(i)); //整数转换成字符串
//			break;
//		default:
//			printf("输入错误");
//	}
//
//}
//总结 数字字符转换成数字 -'0'(对应十六进制为0x30 十进制为48 八进制为06 二进制为0b00110000);
//数字转换成数字字符+'0';