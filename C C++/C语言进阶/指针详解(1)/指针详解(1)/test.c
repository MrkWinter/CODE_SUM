#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//指针学习内容
//1字符指针
//2数组指针
//3指针数组
//4数组传参和指针传参
//5函数指针
//6函数指针数组
//7指向函数指针数组的指针
//8回调函数
//9指针和数组面试题的解析
//一、字符指针
//int main()
//{
//	char* p = "acddd";//常量字符串 首元素地址存到p中
//	//*p 不可修改
//	printf("%s", p);
//	return 0;
//}
//int main()
//{
//	char* p = "abcdefg";
//	char* d = "abcdefg";
//	char arr[] = "acde";
//	char arr1[] = "acde";
//	//arr!=arr1 创建了两块内存
//	if (p == d)
//		printf("hehe");//p与d相同的原因 "abcdef"常量字符串 为同一块内存
//	else
//		printf("haha");
//	return 0;
//}
//二、指针数组
//int main()
//{
//	int a = 2;
//	int b = 3;
//	int c = 5;
//	int d = 0;
//	int* arr[] = { &a,&b,&c,&d };
//	int i;
//	for (i = 0; i < 4; i++)
//	{
//		printf("%d\n", *(arr[i]));
//	}
//	return 0;
//}
//用指针数组打印三个数组
//int main()
//{
//	int arr1[] = { 1,2,3,4 };
//	int arr2[] = { 5,6,7,8 };
//	int arr3[] = { 9,10,11,12 };
//	int* arr[] = { arr1,arr2,arr3 };
//	int i,j;
//	for (i = 0; i < 3; i++)
//	{
//		for (j = 0; j < 4; j++)
//		{
//			printf("%-3d ", *(arr[i] + j));
//		}
//		putchar('\n');
//	}
//	return 0;
//}
//三、数组指针
//int main()
//{
//	int arr[6] = { 1,2,3,4,5,6 };
//	char arr1 = "123";
//	char arr2 = "456";
//	//arr 代表首元素地址
//	//&arr代表整个数组的地址
//	int (*p)[6] = &arr;//存放整个数组的地址的指针为数组指针
//	//类比int *p =&a;  *p = a 这里*p=arr(首元素的地址)//数组名
//	char* pa[3] = { arr1,arr2 };//存放指针的数组为指针数组  char* (*p)[3]
//	char* (*pd)[3] = &pa;//指针数组的数组指针
//	return 0;
//}
//数组指针的使用
//int main()
//{
//	int i;
//	int arr[] = { 1,2,3,4,5,6 };
//	int (*p)[] = &arr;//p中存的是整个元素的地址
//	for (i = 0; i < 6; i++)
//	{
//		printf("%d ", (*p)[i]);//*p相当于arr
//	}  
//	return 0;
//}
//int main()
//{
//	int i;
//	int arr[] = { 1,2,3,4,5,6 };
//	int (*p)[] = &arr;//p中存的是整个元素的地址
//	for (i = 0; i < 6; i++)
//	{
//		printf("%d ", *(*p+i));//*p相当于arr
//	}
//	return 0;
//}
//二维数组中数组指针的使用
//void printf1(int arr[3][4], int x, int y)
//{
//	int i, j;
//	for (i = 0; i < x; i++)
//	{
//		for (j = 0; j < y; j++)
//		{
//			printf("%d ", *(*(arr+i)+j));
//		}                //arr[i][j]
//		putchar('\n');
//	}
//}
//void printf2(int (*p)[4], int x, int y)//数组指针接收整个一维数组的地址(p为指针的指针)
//{
//	int i, j;
//	for (i = 0; i < x; i++)
//	{
//		for (j = 0; j < y; j++)
//		{
//			printf("%d ", *(*(p+i)+j));//p的指针类型为数组指针走一步地址变化为一个数组的长度
//		}                //p[i][j]
//		putchar('\n');
//	}
//}
//void printf3(int(*p)[4], int x, int y)//数组指针接收整个一维数组的地址
//{
//	int i, j;
//	for (i = 0; i < x; i++)
//	{
//		for (j = 0; j < y; j++)
//		{
//			printf("%d ", (*(p+i))[j]);
//		}
//		putchar('\n');
//	}
//}
//int main()
//{
//	int arr[3][4] = { {1,2,3,4}, {2,3,4,5}, {3,4,5,6} };
//	printf1(arr, 3, 4);//二维数组名代表首元素地址————{1,2,3,4}这个一维数组的地址
//	//printf2(arr, 3, 4);
//	//printf3(arr, 3, 4);
//	return 0;
//}
//int main()
//{
//	int arr[] = { 1,2,3 };
//	int* p = arr;
//	printf("%d ", *(p + 1));
//	printf("%d ", *(arr + 1));
//	printf("%d ", arr[1]);
//	printf("%d ", p[1]);
//	//*(p+1)==*(arr+1)==arr[1]==p[1]
//	//x[y]的含义是 表示以地址x向后跳y步后的元素
//	return 0;
//}
//总结 二维数组和指针数组和数组指针的区别于联系
//指针数组 存放的是指针 即一个数组的元素类型为指针 本质上是一维数组 如int* arr[]={&a,&b}; 
//解引用元素得到根据地址找到的对应元素的值
//数组指针 定义一个指针(数组形式)存放整个数组的地址 本质上是指针 如int (*p)[10]=&arr  <——  int (*)[10] p=&arr;
//指针p的类型为int*[10] p为指向10个整型元素即&arr整个数组的指针 *p得到的是该数组(arr)
//二维数组是一维数组中元素为另一个一维数组 套娃
//一维数组的数组名代表首元素地址 数组名加减来表示不同元素的地址 解引用来获取元素
//二维数组数组名同样代表首元素地址 二维数组的数组名代表数组中第一个作为元素的数组的地址 可以说是数组指针
//二维数组的数组名加减来表示作为元素的数组的地址 解引用来获取作为元素的数组(arr) 转化为一维数组
//普通指针int *p = arr 来表示数组的首元素地址 但不能表示一整个数组的地址
//数组指针int (*)p[] = &arr 来表示整个数组的地址 可以用于二维数组的传参
//int main()
//{
//	int arr[] = { 13,4,3 };
//	printf("%d ",*(*(&arr)));//13
//	return 0;
//}
//int (*arr[10])[5]={}  arr为一个10个元素的数组 元素类型为指向5个整型元素的数组指针 ->int *[5] arr[]
//int* (*arr)[5] arr为一个指针 指向有5个元素并且类型为int*型的数组
//int main()
//{
//	int arr[] = { 1,2,34,5,67,2 };//指针类型决定了指针走一步多远 也决定了指针解引用访问地址的范围
//	int* p = &arr;//这里int* 类型为4个字节范围的地址 和int* p =arr;没区别
//	int (*pb)[6] = &arr; 
//	printf("%d ", *p);//p解引用只能访问4个字节的地址所以直接得到首元素1
//	printf("%d ", *(*pb));//pb解引用可以访问整个数组 所以解引用一次得到数组arr(首元素地址) 两次得到首元素
//	return 0;
//}
int main()
{
	return 0;
}