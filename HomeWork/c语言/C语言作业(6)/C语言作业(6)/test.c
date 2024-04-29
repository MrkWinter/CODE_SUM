#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//void hanoi(int n, char A, char B, char C)
//{
//	if (n == 1)
//		printf("%c-->%c\n", A, C );
//	else
//	{
//		hanoi(n - 1, A, C, B );
//		printf("%c-->%c\n", A, C);
//		hanoi(n - 1, B, A, C );
//	}
//}
//int main()
//{
//	int input;
//	scanf("%d",&input);
//	hanoi(input, 'A', 'B', 'C' );
//	return 0;
//}
//青蛙跳台阶问题 青蛙一次跳1阶或2阶，n阶共有多少种跳法
//int qingwa(int n)
//{
//	if (n == 1)
//		return 1;
//	else if (n == 2)
//		return 2;
//	else
//		return qingwa(n - 1) + qingwa(n - 2);
//}
//int main()
//{
//	int input;
//	scanf("%d", &input);
//	printf("青蛙有%d种跳法", qingwa(input));
//	return 0;
//}
//选择法排序(指针操作法)
//void xuan(int* arr,int sz)//函数定义int arr 指的是整型变量arr 函数定义int arr[] 指定义一个数组指针arr并且能用[]访问数组
// {                         //int* arr 指定义一个指针变量arr 不能使用[]来访问数组元素
//	int* i;
//	int* j;
//	int n = 0,temp;
//	for (i = arr; i <= arr + sz-1; i++,n++)
//	{
//		for (j = arr+n; j <= arr + sz-1; j++)
//		{
//			if (*j < *i)
//			{
//				temp = *j;
//				*j = *i;
//				*i = temp;
//			}
//		}
//	}
//	for (n = 0; n <= sz-1; n++)
//	{
//		printf("%d ", *(arr + n));
//	}
//}
//int main()
//{
//	int arr[] = { 1,4,6,2,8,3,9,5,7 };
//	int sz = sizeof(arr) / sizeof(arr[0]);
//	xuan(arr,sz);
//	return 0;
//}
int max(int a, int b)
{
	return a > b ? a : b;
}
int main()
{
	int a = 5;
	int b = 3;
	int c = 2;
	printf("%d ", max(b, (a, c)));//（a,b）为逗号表达式最终结果为b
	return 0;
}