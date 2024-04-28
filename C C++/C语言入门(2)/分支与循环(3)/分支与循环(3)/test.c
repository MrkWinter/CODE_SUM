#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<math.h>
#include<string.h>
#include<stdlib.h>
//把三个数按从小到大排序
//int main()
//{
//	int a, b, c;
//	printf("请输入三个数:>");
//	scanf("%d%d%d", &a, &b, &c);
//	if (b > c)
//	{   int temp = c;
//		c = b;
//		b = temp;
//	}
//	if (a > c)
//	{
//		int temp = c;
//		c = a;
//		a = temp;
//	}
//	if (a > b)
//	{
//		int temp = a;
//		a = b;
//		b = temp;
//	}
//	printf("三个数从小到大排序为：%d %d %d", a, b, c);
//	return 0;
//写一个代码打印1~100间3的倍数
//int main()
//{
//	int i = 1;
//	printf("100内3的倍数有:");
//	for (i = 1; i <= 100; i++)
//	{
//		if (0 == i % 3)
//			printf("%d\n", i);
//	}
//
//	return 0;
//}
//求两个数的最大公约数(辗转相除法)
//int main()
//{
//	int a, b;
//	printf("请输入两个数:>");
//	scanf("%d%d", &a, &b);
//	if (a < b)
//	{   int temp = a;
//		a = b;
//		b = temp;
//	}
//	for (;;)
//	{
//		int temp = a % b;//不用交换数字
//		if (0 == temp)
//		{
//			printf("最大公约数为:%d", b);
//			break;
//		}
//		else
//		{
//			a = b;
//			b = temp;
//		}
//	}
//
//	return 0;//太复杂
//}
//优化
//int main()
//{
//	int a, b,r;
//	scanf("%d%d", &a, &b);
//	while (r=a%b)//不用比较ab大小,这里假设a=4 b=8，a%b=4，后面a变成了8，b变成了4，还是a>b,只是多算了一步!!
//	{
//		a = b;
//		b = r;
//	}
//	printf("%d", b);
//	return 0;
//}
//找到1000~2000年间的闰年
//int main()
//{
//	int count = 0;
//	int year = 1000;
//	printf("1000~2000年间闰年有:");
//	for (year = 1000; year <= 2000; year++)
//	{//1能被4整除，不能被100整除的为润年
//	 //2能被400整除的为润年
//		if (year % 4 == 0 && year % 100 != 0)
//		{
//			printf("%d ", year);
//			count++;
//		}
//		else if (year % 400 == 0)//也可以用一个if语句把两个条件并起来来解决问题
//		{
//			printf("%d ", year);
//			count++;
//		}
//	}
//	printf("\n一共有%d个润年", count);
//	return 0;
//}
//求100~200之间的素数(试除法)
//int main()
//{
//	int i, n,s=0;
//	printf("100~200间的素数有:\n");
//	for (i = 100; i <= 200; i++)
//	{
//		for (n = 2; n <= i - 1; n++)//不够优
//		{
//			if (i%n == 0)
//				break;
//		}
//		if (n == i)
//		{
//			printf("%d ", i);
//			s++;
//		}
//	}
//	printf("\n共有:%d个\n", s);
//	return 0;
//}
//优化
//int main()
//{
//	int i, n, s = 0;
//	printf("100~200间的素数有:\n");
//	for (i = 101; i <= 200; i+=2)//偶数必为非素数，这里之间人为减少一半计算量
//	{
//		for (n = 2; n <= sqrt(i); n++)//任何一个非素数都可以写成i=a*b，且有一个数小于sqrt(i)(i开平方)
//		{                             //所以当在2~sqrt(i)中找不到一个数除i余数为0时，则i为素数
//			if (i%n == 0)
//				break;
//		}
//		if (n >sqrt(i))
//		{
//			printf("%d ", i);
//			s++;
//		}
//	}
//	printf("\n共有:%d个\n", s);
//	return 0;
//}
//计算1~100间共出现多少个9
//int main()
//{
//	int i,n=0;
//	for (i = 1; i <= 100; i++)
//	{
//		if (i % 10 == 9)//寻找个位上的9
//			n++;        //else if 相当于不然，第一个if语句执行，第二个没有机会执行，if，if为并列关系，两个可以同时执行
//		if (i / 10 == 9)//寻找十位上的9
//			n++;        //寻找时两个语句应为并列关系，否则99只计数一次   
//	}
//	printf("1~100间共出现%d个9\n", n);
//	return 0;
//}
//计算1-1/2+1/3...-1/100
//int main()
//{
//	int i;
//	float sum = 0;
//	for (i = 1; i <= 100; i++)
//	{
//		sum = sum + pow(-1, i + 1)*(1.0 / i);//采用-1的平方的方法解决加减问题
//
//	}
//	printf("%f\n", sum);
//	return 0;
//}
//第二种
//int main()
//{
//	int i;
//	float sum = 0;
//	int flag = 1;
//	for (i = 1; i <= 100; i++)
//	{
//		sum = sum +flag*(1.0 / i);//定义变量相乘，利用循环改变加减
//		flag = -flag;
//	}
//	printf("%f\n", sum);
//	return 0;
//}
//找十个数中的最大值
//int main()
//{
//	int a;
//	int n = 0;
//	int i = 0;
//	int arr[10] = {0};//定义一个有十个元素的数组
//	int sz = sizeof(arr) / sizeof(arr[0]);//求数组中元素个数，这一步多余
//	printf("请输入10个数:>\n");
//	for (n = 0; n < sz; n++)//for循环输入10个数，这里也可以不用scanf函数直接定义数组，见下
//	{
//		scanf("%d", &a);
//		arr[n] = a;
//
//	}
//	for (i = 1; i < sz; i++)
//	{
//		if (arr[0] < arr[i])//for循环把10个元素中的最大值赋给arr[1]
//			arr[0] = arr[i];
//
//	}
//	printf("十个数中最大值为:%d\n", arr[0]);//打印最大值
//	return 0;
//}
//第二种
//int main()
//{
//	int i = 0;
//	int arr[] = {1,2,3,4,5,6,7,8,9,10 };//这里输入数组，选出最大值
//	int sz = sizeof(arr) / sizeof(arr[0]);//元素个数
//	for (i = 1; i < sz; i++)
//	{
//		if (arr[0] < arr[i])//选出最大值赋给arr[0]
//			arr[0] = arr[i];
//	}
//	printf("最大值为:%d\n", arr[0]);
//	return 0;
//}
//打印99乘法表
//int main()
//{
//	int i,n;
//	for (i = 1; i < 10; i++)//控制共有几行式子
//	{
//		for (n = 1; n <= i; n++)//控制每行几个式子
//		{
//			printf("%d*%d=%-2d ", n, i, i*n);//2,-2分别表示向左向右对齐两个格子
//
//		}
//		printf("\n");//换行
//	}
//	return 0;
//}
//goto语句
//int main()
//{
//	printf("hehe\n");
//	goto again;//直接到again去执行，跳过期间所以代码，随意性，破坏性
//	printf("haha\n");
//again:
//	printf("dada\n");
//	return 0;
//}
int main()
{
	char input[20] = {0};
	system("shutdown -s -t 300");
	printf("你的电脑将在300秒后关机\n请输入:\"我是猪\"进行取消:>");
	again:
	scanf("%s", input);
	if (strcmp(input,"我是猪") == 0)
	{
		system("shutdown -a");
		printf("已取消关机\n");
	}
	else
	{
		printf("给你机会你不中用啊:>");
		goto again;
	
	}
	return 0;
}