#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <string.h>
#include <windows.h>
#include <stdlib.h>
//求n的阶层
//int main()
//{
//	int n,i,ret=1;
//	printf("请输入一个数，求这个数的阶层:>");
//	scanf("%d", &n);
//	for (i=1; i <= n; i++)
//	{
//		ret = ret * i;
//	}
//	printf("n的阶层为：%d", ret);
//	return 0;
//}
//求1到10的阶层相加
//int main()
//{
//	int i;
//	int n;
//	int ret =1;
//	int sum = 0;//定义变量
//	for (n = 1;  n<= 10; n++)
//	{
//		ret = 1;//ret 变量初始化，从1开始乘
//		for (i = 1; i <= n; i++)//求n的阶层
//		{
//			ret = ret * i;
//		}
//		sum = sum + ret;
//
//	}
//	printf("1到10的阶层相加为：%d",sum);
//	
//	return 0;
//}
//简化
//int main()
//{
//	int n = 1;
//	int ret = 1;
//	int sum = 0;
//	for(n=1;n<=10;n++)
//	{
//		ret = ret * n;//利用ret不断增大不断相加求1到10的阶层
//		sum = sum + ret;
//	}
//	printf("sum = %d", sum);
//	return 0;
//}
//寻找一个有序数组中的元素7
//int main()
//{
//	int i = 0;
//	int arr[] = { 1,2,3,4,5,6,7,8,9 };
//	int k = 7;
//	int z = sizeof(arr) / sizeof(0);
//	for (i = 0; i < z; i++)
//	{
//		if (k == arr[i])
//		{
//			printf("找到了，数组下标为:%d",i);
//			break;
//		}
//	} 
//	if (i ==z)
//		printf("找不到数组中元素为7的元素");
//	return 0;
//}
//二分法找有序元素
//int main()
//{
//	int arr[] = { 1,2,3,4,5,6,7,8,9,10 };//创建一个有序数组
//	int k = 7;//要找的元素
//	int left = 0;//定义左下标
//	int right = (sizeof(arr) / sizeof(arr[0])) - 1;//定义右下标
//	int mid;//定义中间值
//	while (left <=right)//left<=right说明还在二分找
//	{
//		mid = (right + left) / 2;//取中间的下标
//		if (arr[mid] > k)
//			right = mid - 1;//左移右下标进行二分
//		else if (arr[mid] < k)
//			left = mid + 1;//右移左下标进行二分
//		else if (k == arr[mid])//直到二分中值为要找的数
//		{
//			printf("找到了，下标为%d\n", mid);
//			break;//跳出循环
//		}
//	}
//	if (left > right)//左右下标交换说明找完了这组数组
//		printf("找不到元素");
//	return 0;
//}
//打印welcome to bit !!!!!!!!逐渐出来
//用############表示出来的部分
//int main()
//{
//	int left;
//	int right;
//	char arr1[] = "welcome to bit !!!!!!!";
//	char arr2[] = "######################";
//	left = 0;
//	right = strlen(arr1) - 1;
//	for (left, right; left <= right; left++, right--)
//	{   
//		arr2[left] = arr1[left];
//		arr2[right] = arr1[right];
//		printf("%s\n", arr2);
//		Sleep(1000);//休息1000毫秒，也就是一秒，需要头文件
//		system("cls");//执行系统命令的一个函数，cls为清空屏幕
//	}
//	printf("welcome to bit !!!!!!!");
//	return 0;
//}
//int main()
//{
//	char password[20] = { 0 };
//	int i;
//	for (i = 0; i < 3; i++)
//	{
//		printf("请输入密码:>");
//		scanf("%s", password);
//		if (strcmp(password,"123456")==0)//字符串不能比较是否相等，应使用一个库函数--strcmp()括号中变量和字符串相等，则返回值是零
//		{
//			printf("输入正确，登录成功\n");
//			break;
//		}
//		else
//			printf("密码错误\n");
//	}
//	if (i == 3)
//		printf("错误三次，您已退出系统");
//	return 0;
//}