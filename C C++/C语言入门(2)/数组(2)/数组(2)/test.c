#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//用函数将一个数组中的元素排序
//void bubble_sort(int arr[], int sz)
//{
//	int i,n;
//	for (i = 0; i < sz - 1; i++)//进行sz-1趟冒泡排序
//	{
//		int j = 1;//用一个变量来检测是否完成任务，提高代码效率
//		for (n = 0; n < sz - 1 - i; n++)//进行一趟很多次的冒泡排序
//		{                               //每趟冒泡排序的次数递减
//			if (arr[n] > arr[n + 1])
//			{
//				int temp = arr[n];
//				arr[n] = arr[n + 1];
//				arr[n + 1] = temp;
//				j = 0;
//			}
//		}
//		if (1 == j)//说明本趟冒泡排序循环中没有进入if语句，完成任务，跳出函数
//			break;
//	}
//}
//int main()
//{
//	int i;
//	int arr[] = { 10,9,8,7,6,5,4,3,2,1 };
//	int sz = sizeof(arr) / sizeof(arr[0]);
//	bubble_sort(arr,sz);//冒泡排序函数 来实现数组中元素按从小到大排列
//	for (i = 0; i < sz; i++)
//	{
//		printf("%d ", arr[i]);
//	}
//	return 0;
//}
int main()
{
	int arr[] = { 1,2,3,4,5,6 };
	printf("%p\n", arr);//与下面等价
	printf("%p\n", &arr[0]);//等价，代表的都是数组中第一个元素的地址
	printf("%d\n", *arr);//1--即第一个元素
	printf("%d\n", *&arr[0]);//1--同上
	//数组名就是首元素的地址(有两个例外)
	//1.sizeof(数组名)--数组名表示的是整个数组,sizeof(arr)就是求arr数组的大小，单位是字节
	//2.&数组名--数组名表示整个数组，&arr就是取出整个元素的地址
	printf("%p\n", &arr);//代表的是取整个数组的地址，而取数组的地址打印时表示的是第一个元素的地址
	//例子
	printf("%p\n", arr);
	printf("%p\n", arr+1);//地址从第一个元素变到第二个元素，变动为4，第一个元素占四字节，所以占用四块内存，就是四个内存编号
	                      //而打印时只显示首元素地址，内存申请后地址生成是成块的，+ 1相当于表示第二个元素的首元素地址
	printf("%p\n", &arr[0]);
	printf("%p\n", &arr[0]+1);//同上
	printf("%p\n", &arr);
	printf("%p\n", &arr+1);//这里地址变动了24，原因是整个数组的内存为24，+1后地址变成了整块数组地址后面第一个地址
	return 0;
}