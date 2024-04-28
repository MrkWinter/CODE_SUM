#define _CRT_SECURE_NO_WARNINGS 1
//数组的创建
//数组元素类型 数组名 [元素个数]
#include<stdio.h>
#include<string.h>
//int main()
//{
//	int arr1[3];//[]内必须是常量
//	int arr2[10] = { 1,2,3 };//不完全初始化，剩下的为0
//	char arr3[5] = { 'a','b','c' };//剩下的为0
//	char arr4[5] = { "abc" };//剩下的为一个\0（显示的还为0）和一个0
//	char arr5[] = { "abcdef" };//[]里面不定义元素个数必须初始化，计算机会根据初始化内容自动定义元素个数，这里为[7]个元素
//	printf("%d\n", sizeof(arr5));//sizeof计算arr4所占空间大小，共七个元素
//	printf("%d\n", strlen(arr5)); //strlen求字符串长度，遇到\0停止，也就是\0前字符个数
//	return 0;
//}
//1.strlen 与sizeof没有什么关联
//2.strlen--是求字符串长度的 只能针对字符串求长度--是库函数-得引头文件夹
//3.sizeof--计算变量，数组，类型的大小-单位是字节--是操作符
//一维数组的使用
//int main()
//{
//	char arr1[] = "abc";//字符串数组 []下标引用操作符
//	char arr2[] = { 'a','b','c' };//字符数组 其中无\0
//	printf("%d\n", sizeof(arr1));//4
//	printf("%d\n", sizeof(arr2));//3
//	printf("%d\n", strlen(arr1));//3
//	printf("%d\n", strlen(arr2));//随机值 在内存中找\0  所以随机的
//	return 0;
//}
//int main()
//{
//	char arr1[] = "abcdefg";//[a][b][c][d][e][f][g][\0]
//	//printf("%c\n", arr1[3]);//找到第四个元素d
//	int i;
//	for (i = 0; i <=6; i++)
//	{
//		printf("%c ", arr1[i]);//数组的访问
//	}
//	return 0;
//}
//int main()
//{
//	int arr[] = { 1,2,3,4,5,6,7,8 };//整型数组 其中无\0
//	int len = sizeof(arr) / sizeof(arr[0]);
//	int i = 1;
//	for (i = 0; i < len; i++)
//	{
//
//		printf("%d ", arr[i]);
//
//	}
//	return 0;
//}
//一维数组在内存中的存储
//int main()
//{
//	int arr[] = { 1,2,3,4,5,6,7,8,9,10 };//数组在内存中是连续存放的
//	int i;
//	int sz = sizeof(arr) / sizeof(arr[0]);
//	for(i=0;i<sz;i++)
//	{
//		printf("&arr[%d]=%p\n", i, &arr[i]);//同一个一维数组中每个元素的地址是连续的
//	return 0;
//}
//二维数组的创建和初始化
//int main()
//{
//	int arr1[2][3] = { {1,2,3},{4,5,6} };
//	//第一个[2]指的是2行，第二个[3]指的是3列{1,2,3}指的是第一行的3个元素，｛4,5,6｝指的是第二行的3个元素
//	int arr[][5] = { {1,2,3,4,5},{5,6,7} };//可以省略行，但不可以省略列;此处是2行5列,为初始化的元素默认为0
//	return  0;
//}
//二维数组的使用
//int main()
//{//打印二维数组
//	int arr1[3][4] = { {1,2,3,4},{5,6,7,8},{9,9,9,9} };
//	int i, n;
//	for (i = 0; i < 3; i++)//打印行
//	{
//		for (n = 0; n < 4; n++)//打印列
//		{
//			printf("%d ", arr1[i][n]);//二维数组也是通过下标来访问
//		}
//		putchar('\n');
//	}
//	return 0;
//}
//int main()
//{//打印二维数组地址
//	int arr1[3][4] = { {1,2,3,4},{5,6,7,8},{9,9,9,9} };//二维数组在内存中也是连续开辟空间｛第一行[][]｝｛第二行[][]｝。。。
//	int i, n;//二维数组可以看成一维数组的叠加，对上面数组来说arr1[2][3]表示的就是就是第三行的一维数组中的第四个元素
//	for (i = 0; i < 3; i++)
//	{
//		for (n = 0; n < 4; n++)
//		{
//			printf("&arr[%d][%d]=%p\n", i, n, &arr1[i][n]);//打印二维数组地址
//		}//二维数组的地址在内存中也是连续的
//
//	}
//	return 0;
//	}
//
void bubble_sort(int arr[], int n)
{
	int i,j;
	for (i = 0; i < n - 1; i++)//遍历
	{
		for (j = 0; j < n - 1 - i; j++)
		{
			if (arr[j] > arr[j + 1])
			{
				int temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}
	}

}
int main()
{
	int i;
	int arr[] = { 1,3,2,4,6,8,5,7,9,0 };//定义数组
	int n = sizeof(arr) / sizeof(arr[0]);//n元素个数
	bubble_sort(arr, n);
	for (i = 0; i < n; i++)
	{
		printf("%d ",arr[i]);
	}
	return 0;
}