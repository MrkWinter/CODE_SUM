#define _CRT_SECURE_NO_WARNINGS 1
#include "function.h"
//思路 将二维数组传入初始化函数中对其初始化
//用time函数和srand函数对数组进行初始化
//对二维数组进行操作

int main()
{
	srand((unsigned int)time(NULL));//根据时间戳设定随机数种子
	int arr[ROW][COL] = { 0 };
	Inital(arr); //初始化二维数组
	Printfarr(arr);//打印二维数组
	int sum = CalculateRowSum(arr,1);//3.计算arr的第一行的和
	printf("该行和为:%d\n", sum);
	sum = CalculateDiagonalSum(arr,0);//4.计算arr的对角线上的和 0为左 1为右
	printf("对角线和为:%d\n", sum);
	sum = CalculateTrangleSun(arr, 0);//5.计算arr上三角的和 0为左 1为右
	printf("左上三角的和为:%d\n", sum);
	return 0;
}