#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//void diaohuan(int arr[], int n)
//{
//	int i,temp;
//	for (i = 0; i < n; i++, n--)
//	{
//		temp = arr[i];
//		arr[i] = arr[n - 1];
//		arr[n - 1] = temp;
//	}
//}
//void diaohuan(int* p, int n)
//{
//	int i,temp;
//	for (i = 0; i < n; i++, n--)
//	{
//		temp = *(p + i);
//		*(p + i) = *(p + n - 1);
//		*(p + n - 1) = temp;
//	}
//
//}
//int main()
//{
//	int i;
//	int arr[] = { 1,3,4,6,7,8,6,5,9 };
//	int sz = sizeof(arr)/sizeof(arr[0]);
//	diaohuan(arr, sz);
//	for (i = 0; i < sz; i++)
//	{
//		printf("%d", arr[i]);
//	}
//}
//1.
//void copy(char* arr1, char* arr2)
//{
//	for (; *arr1 != '\0'; arr1++, arr2++)
//	{
//		*arr2 = *arr1;
//	}
//	*arr2 = *arr1;
//}
//int main()
//{
//	int i;
//	char arr1[] = "I love china";
//	char arr2[] = "I love that girl";
//	copy(arr1, arr2);
//	printf("%s", arr2);
//	return 0;
//}
//2.
//void copy(char arr1[], char arr2[])
//{
//	int i;
//	for (i=0; arr1[i] != '\0'; i++)
//	{
//		arr2[i] = arr1[i];
//	}
//	arr2[i] = arr1[i];
//}
//int main()
//{
//	int i;
//	char arr1[] = "I love china";
//	char arr2[] = "I love that girl";
//	copy(arr1, arr2);
//	printf("%s", arr2);
//	return 0;
//}
//int main()
//{
//
//	int s = (int)3.14;//强制类型转换 保留为int型
//	printf("%d", s);
//	return 0;
//}
//int main()
//{
//	int a = 3;
//	printf("%d", *(&a));
//
//	return 0;
//}
#include<string.h>
//int main()
//{
//	struct game
//	{
//		int price;
//		char name[];
//	};
//	struct game as = { 13,"huangyedabiaoke" };
//	printf("price is :%d\n", as.price);
//	printf("price is :%s\n", as.name);
//	struct game* p = &as;
//	printf("%d\n", p->price);
//	printf("%s\n", p->name);
//	return 0;
//}
//逆置数组
//void Printf(int arr[], int sz)
//{
//	int i;
//	for (i = 0; i < sz; i++)
//	{
//		printf("%d\n", arr[i]);
//	}
//}
//void nizhi(int arr[], int sz)
//{
//	int left;
//	int right;
//	for (left = 0, right = sz - 1; left < right; left++, right--)
//	{
//		int temp;
//		temp = arr[left];
//		arr[left] = arr[right];
//		arr[right] = temp;
//	}
//	
//}
//int main()
//{
//	int arr[] = { 1,2,3,4,5,6,7,8,9,10 };
//	int sz = sizeof(arr) / sizeof(arr[0]);
//	Printf(arr, sz);
//	nizhi(arr, sz);
//	Printf(arr, sz);
//	return 0;
//}
//int main()
//{
//	int a=0,b=0,c=0,d=0,e=0;
//	char arr[] = "ABCD,abc,123. !";
//	int sz = strlen(arr),i;
//	for (i = 0; i < sz; i++)
//	{
//		if (arr[i] >= 65 && arr[i] <= 90)
//			a++;
//		else if (arr[i] >= 97 && arr[i] <= 112)
//			b++;
//		else if (arr[i] >= 48 && arr[i] <= 57)
//			c++;
//		else if (arr[i] ==32)
//			d++;
//		else
//		    e++;
//	}
//	printf("大写字母个数:%d\n", a);
//	printf("小写字母个数:%d\n", b);
//	printf("数字个数:%d\n", c);
//	printf("空格个数:%d\n", d);
//	printf("其他字符个数:%d\n", e);
//	return 0;
//}
void copy(char* arr1, char* arr2)
{
	for (; *arr1 != '\0'; arr1++, arr2++)
	{
		arr2 = arr1;
	}
	arr2 = arr1;
}
int main()
{
	int i;
	char* arr1 = "I love china";
	char* arr2 = "I love that girl";
	copy(arr1, arr2);
	printf("%s", arr2);
	return 0;
}