#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//int main()
//{
//	int i;
//	float a=1.0, b=2.0;
//	float ret = 0;
//	for (i = 0; i < 20; i++)
//	{
//		float temp;
//		ret += b / a;
//		temp = a + b;
//		a = b;
//		b = temp;
//	}
//	printf("%f", ret);
//	return 0;
//}
//int test(int arr[],int ret,int* count)
//{
//	int i;
//	for (i = 0; i < 4; i++)
//	{
//		ret += arr[i];
//		if (ret == 200)
//		(*count)++;
//		else if (ret < 200)
//			test(arr, ret, count);
//		ret -= arr[i];
//	}
//	return count;
//}
//int main()
//{
//	int ret = 0;
//    static int count = 0;
//	int arr[] = { 150,100,50,50 };
//	printf("%d",test(arr,ret,&count));
//	return 0;
//}
//int main()
//{
//	int arr[10] = { 1,4,7,9,13,56,67,80,95 };
//	int i, sz = sizeof(arr) / sizeof(arr[0]) - 1;
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
//int main()
//{
//	int a;
//	printf("请输入一个5位数：");
//	scanf("%d", &a);
//	if (a % 10 == a / 10000 % 10 && a / 10 % 10 == a / 1000 % 10)
//		printf("%d是回文数", a);
//	else
//		printf("%d不是回文数", a);
//	return 0;
//}
//int main()
//{
//	char arr1[] = { 'a','b','c' };
//	char arr2[] = { 'x','y','z' };
//	printf("%c和%c比\n", arr1[0],arr2[2]);
//	printf("%c和%c比\n", arr1[1], arr2[0]);
//	printf("%c和%c比\n", arr1[2], arr2[1]);
//	return 0;
//}
int main()
{
	int arr[] = { 150,100,50,50 };
	int i,j,k,l,ret=0,count=0;
	for (i = 0; i < 4; i++)
	{
		ret += arr[i];
		if (ret == 200)
			count++;
		else
		{
			for (j = 0; j < 4; j++)
			{
				ret += arr[j];
				if (ret > 200)
					continue;
				else if (ret == 200)
					count++;
				else
				{
					for (k = 0; k < 4; k++)
					{
						ret += arr[k];
						if (ret > 200)
							continue;
						else if (ret == 200)
							count++;
						else
						{
							for (l = 0; l < 4; l++)
							{
								ret += arr[l];
								if (ret > 200)
									continue;
								else if (ret == 200)
									count++;
							}
						}
					}
				}
			}
		}
	}
	printf("%d", ret);
	return 0;
}