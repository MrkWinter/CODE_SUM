#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//用递归的方法自定义一个函数来求字符串长度（复习）
//int my_strlen(char* p)//循环语句法
//{
//	int count =0;
//	while (*p != '\0')
//	{
//		count++;
//		p++;
//	}
//	return count;
//}
//int main()
//{
//	int ret;
//	char arr[] = "ailixiya";
//	printf("请输入串字符:>");
//	scanf("%s", arr);
//	ret = my_strlen(arr);
//	printf("字符串的长度为:%d", ret);
//    return 0;
//}
//int my_strlen(char* p)
//{
//	if (*p != '\0')
//		return 1 + my_strlen(++p);//这里用++i，若用i++,则会一直递归下去1+1+1+1+1+1....导致栈溢出
//	else                          //i++为先赋值再自增，i++先自增再赋值
//		return 0;
//}
//int main()
//{
//	int ret;
//	char arr[] = "ailixiya";
//	printf("请输入串字符:>");
//	scanf("%s", arr);
//	ret = my_strlen(arr);
//	printf("字符串的长度为:%d", ret);
//	return 0;
//}
//递归与迭代
//求n的阶层
//int Facl(int a)//循环求阶层
//{
//	int i;
//	int ret=1;
//	for(i=1;i<=a;i++)
//	{
//		ret *= i;
//	}
//	return ret;
//}
//int Facl(int a)//递归求阶层
//{
//	if (a > 1)
//		return a * Facl(a - 1);
//	else
//		return 1;
//}
//int main()
//{
//	int a;
//	scanf("%d",&a);
//	printf("%d的阶层为:%d",a, Facl(a));
//	return 0;
//}
//求第n个斐波那契数
//int Fib(int a)
//{
//	if (a <= 2)
//		return 1;//递归算法在此处不太合适，重复的运算太多
//	else         
//		return Fib(a - 1) + Fib(a - 2);//每算一个数，就要算前面两个数
//}
//int main()
//{
//	int a;
//	scanf("%d", &a);//测试驱动开发TDD，先写怎么用，再设计怎么用
//	printf("第%d个斐波那契数为:%d", a, Fib(a));
//	return 0;
//}
//int Fib(int n)
//{
//	int a = 1;
//	int b = 1;
//	int c = 1;//保证n为1，2时斐波那契数为2
//	while (n > 2)
//	{
//		c = a + b;//循环法求斐波那契数
//		a = b;
//		b = c;
//		n--;//保证求的对的斐波那契数要循环的次数
//	}
//	return c;
//}
//int main()
//{
//	int n;
//	scanf("%d", &n);
//	printf("第%d个斐波那契数为:%d", n, Fib(n));
//	return 0;
//}
//递归和循环都能解决问题，但实际时应保证算法效率的前提下，再考虑代码复杂度
//两个经典递归问题---1汉纳塔问题，2青蛙跳台阶问题
//递归在满足必要条件不是死循环下也可能栈溢出
void test()
{
	int n=1;//递归有时会出现很多问题
	while (n < 10000)
	{

		test(n++);//栈溢出
	}
}
int main()
{
	test();
	return 0;
}