#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//int main()//冒泡排序法
//{
//	int i, n,temp;
//	int arr[] = { 1,4,2,5,7,8,9,0 };
//	int sz = sizeof(arr) / sizeof(arr[0]);
//	for (n=0;n<sz-1;n++)//定义趟数,n个元素要n-1趟冒泡排序
//	{
//		int c = 1;
//		for (i = 0; i < sz-1-n; i++)//定义每趟的调换次数，第一趟要进行n-1次调换
//		{
//			if (arr[i] > arr[i + 1])
//			{
//				c = 0;//逆思想，如果没进if语句则排序已经完成，不需要下一趟
//				arr[i] = arr[i] ^ arr[i + 1];//temp= arr[i+1];
//				arr[i + 1] = arr[i] ^ arr[i + 1];	//arr[i + 1] = arr[i];
//				arr[i] = arr[i + 1] ^ arr[i];//arr[i] = temp;
//			}
//		}
//		if (c == 1)
//			break;
//	}
//	for (i = 0; i < sz; i++)
//		printf("%d", arr[i]);
//	return 0;
//}
//找出只出现一次的数字
//int main()
//{
//	int i, n;
//	int arr[] = { 1,2,2,1,4,4,6,7,8,7,8 };
//	int sz = sizeof(arr) / sizeof(arr[0]);
//	for (i = 0; i < sz; i++)
//	{
//		int c = 0;
//		for (n = 0; n < sz; n++)
//		{
//			if (arr[i] == arr[n])
//				c += 1;
//		}
//		if (c == 1)
//		{
//			printf("%d", arr[i]);
//			break;
//		}
//	}
//
//
//	return 0;
//}
//改善优化
//int main()
//{
//	int i;
//	int arr[] = { 1,2,2,1,4,4,6,7,8,7,8 };
//	int sz = sizeof(arr) / sizeof(arr[0]);
//	for (i = 1; i < sz; i++)
//	{
//		arr[0] ^= arr[i];//0^a=a,重复两次的数字都会被消去，成为0，最后找到的就是出现一次的数
//	}
//	printf("%d", arr[0]);
//	return 0;
//}
#include<stdlib.h>//system函数
#include<string.h>//strcmp函数
//int main()
//{
//	char input[20] = { 0 };
//	system("shutdown -s -t 300");
//	again:
//	printf("你的电脑将在5分钟内关机\n输入\"我是猪\"进行取消\n");
//	scanf("%s", input);
//	if (strcmp(input, "我是猪") == 0)
//		system("shutdown -a");
//	else
//		goto again;
//	return 0;
//}
//int main()
//{
//	char arr[] = "abcd";//\0是加在字符是在字符串末尾的,单个的字符数组中没有加
//	int a = sizeof(arr) / sizeof(arr[0]);//0是空字符,为一个空格的显示-什么也没有，为字符串结束的标志'\0',ascll为0的字符
//	//a = strlen(arr); //'0'为ascll值为48的字符
//	printf("%d", a);//' '为ascll值为32的字符
//	return 0;//strlen不会把空格和回车作为字符串结束的标志，也会看做字符
//}
//scanf()函数只接收空格和回车前的东西
//int main()
//{
//	char arr[3] = { 0 };
//	return 0;
//}
//int main()
//{
//	int arr[3][3] = { {1,2,3},{4,5,6},{7,8,9} };
//	int sum=0;
//	sum = arr[0][0] + arr[1][1] + arr[2][2] + arr[0][2] + arr[2][0];
//	printf("对角线和为:%d", sum);
//	return 0;
//}
//int main()
//{
//	int arr[10] = { 1,4,7,9,13,56,67,80,95 };
//	int i, sz = sizeof(arr) / sizeof(arr[0])-1;
//	scanf("%d", &arr[9]);
//	printf("数组中元素从大到小为:");
//	for (i = sz; i >= 0; i--)
//	{
//		if (arr[i] < arr[i - 1])
//		{
//			arr[i] = arr[i - 1] ^ arr[i];
//			arr[i - 1] = arr[i] ^ arr[i - 1];
//			arr[i] = arr[i] ^ arr[i - 1];
//		}
//		printf("%d ", arr[i]);
//	}
//	return 0;
//}

int main()
{
	int a=0,b=0,c=0,d=0,e=0;
	char arr[] = "ABC,abc,123. !";//文章
	scanf("%s", arr);
	int sz = strlen(arr),i;
	for (i = 0; i < sz; i++)
	{
		if (arr[i] >= 65 && arr[i] <= 90)
			a++;
		else if (arr[i] >= 97 && arr[i] <= 112)
			b++;
		else if (arr[i] >= 48 && arr[i] <= 57)
			c++;
		else if (arr[i] ==32)
			d++;
		else
		    e++;
	}
	printf("大写字母个数:%d\n", a);
	printf("小写字母个数:%d\n", b);
	printf("数字个数:%d\n", c);
	printf("空格个数:%d\n", d);
	printf("其他字符个数:%d\n", e);
	return 0;
}
//int main()
//{
//	char a,b;
//	int arr[] = {1,2,3,4};//一块一块的内存，无法一次取出
//	printf("%d ", (&arr));
//	printf("%d ", *(&arr));//连续解引用无法得出
//	int* p = &arr;
//	printf("%d ", *p);//分开解引用整个整型整型数组，打印第一元素
//	//printf("%d ", arr);
//	//int arr1[3];//数组可不定义
//	//printf("%d ", arr1);
//	return 0;
//}
//int main()
//{
//	int a=1, b;
//	int arr[] = { 1,2,3,4 };
//	printf("%d ", *(&a));
//	int* p = &a;
//	printf("%d", *p);
//	return 0;
//}
//int main()
//{
//	char a, b;
//	char arr[] = { '1','2','3','4','\0'};//字符数组，含'\0',可看成字符串
//	printf("%s ", arr);//直接连续打印出，找到\0为止
//	puts(arr);
//	return 0;
//}
//函数求c52
//int j(int c)
//{
//	int i,cnm=1;
//	for (i = 1; i <= c; i++)
//	{
//		cnm *= i;
//	}
//	return cnm;
//}
//int main()
//{
//	int a, b;
//	scanf("%d%d", &a, &b);
//	printf("%d", j(a) / (j(b)*j(a - b)));
//	return 0;
//}
//求年龄
//int age(int a)
//{
//	if (a == 1)
//		return 10;
//	else
//		return age(a - 1) + 2;//递归实质：由现在要解决的问题向前推一步，然后规定最初的解决方案，也就是函数递归的结束条件
//}
//int main()
//{
//	printf("%d", age(5));
//	return 0;
//}
//递归求n的阶乘
//int jie(int a)
//{
//	if (a == 0)
//		printf("无88");
//	else if (a == 1)
//		return 1;
//	else 
//		return a * jie(a - 1);
//}
//int main()
//{
//	int a;
//	scanf("%d", &a);
//	printf("%d",jie(a));
//	return 0;
//}
//int maxr(int a, int b)
//{
//	a = a > b ? a : b;
//	return a;
//}
//int Max(int a, int b, int c, int d)
//{
//	a = maxr(a, b);
//	a = maxr(a, c);
//	a = maxr(a, d);
//	return a;
//}
//int main()
//{
//	int a, b, c, d;
//	scanf("%d%d%d%d", &a, &b, &c, &d);
//	printf("最大的数为：%d", Max(a, b, c, d));
//	return 0;
//}