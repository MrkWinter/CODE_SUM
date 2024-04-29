#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<string.h>
//数组和
//int getsum(int* arr, int n)
//{
//	int i;
//	int sum = 0;
//	for (i = 0; i < n; i++)
//	{
//		sum += arr[i];
//	}
//	return sum;
//}
//int main()
//{
//	int arr[10] = { 1,2,3,4,5,6,7,8,9,0 };
//	int n = sizeof(arr) / sizeof(arr[1]);
//	int ret = getsum(arr, n);
//	printf("%d", ret);
//	return 0;
//}
//逆序输出
//void reverseput(char arr[])
//{
//	int i;
//	int len = strlen(arr);
//	for (i = len - 1; i >= 0; i--)
//	{
//		printf("%c", arr[i]);
//	}
//	return;
//}
//int main()
//{
//	char arr[20] = "";
//	printf("请输入");
//	scanf("%s", arr);
//	reverseput(arr);
//	return 0;
//}
//
//输出大于0的
//void zput(int* arr,int n)
//{
//	int i;
//	printf("大于0的数有\n");
//	for (i = 0; i < n; i++)
//	{
//		if (arr[i] > 0)
//			printf("%d ", arr[i]);
//	}
//	return;
//}
//int main()
//{
//	int arr[10] = { 1,-3,-6,2,9,10,78,-3,10,45 };
//	int n = sizeof(arr) / sizeof(arr[1]);
//	zput(arr,n);
//	return 0;
//}
//数组倒置
void reversearr(int* arr, int n)
{
	int left = 0;
	int right = n - 1;
	for (; left < right; left++, right--)
	{
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	return;
}
void printarr(int* arr, int n)
{
	int i = 0;
	for (i = 0; i < n; i++)
	{
		printf("%d ", arr[i]);
	}
}
int main()
{
	int arr[10] = { 1,2,3,4,5,6,7,8,9,0 };
	int n = sizeof(arr) / sizeof(arr[1]);
	reversearr(arr,n);
	printarr(arr, n);
	return 0;
}