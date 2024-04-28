#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
#include<assert.h>
//内存拷贝函数memcpy
//memcpy(目标数组，源数组,拷贝字节数) 返回值为指向目标数组的void型指针
//strcpy 和strncpy 有局限性 只能拷贝字符串
//int main()
//{
//	int i;
//	int arr1[] = { 1,2,3,4,5,6 };
//	int arr2[10] = { 0 };
//	int sz = sizeof(arr1) / sizeof(arr1[0]);
//	memcpy(arr2, arr1, 24);
//	for (i = 0; i < sz; i++)
//	{
//		printf("%d ", arr2[i]);
//	}
//	return 0;
//}
//实现
//void* my_memcpy(void* dest,const void* scr, size_t n)
//{
//	assert(dest != NULL);
//	assert(scr != NULL);
//	void* ret = dest;
//	while (n--)//将n个字节拷贝
//	{
//		*(char*)dest = *(char*)scr;
//		++(char*)dest;
//		++(char*)scr;
//	}
//	return ret;
//}
//struct stu
//{
//	char name[10];
//	int age;
//};
//int main()
//{
//	int i;
//	int arr1[] = { 1,2,3,4,5,6 };
//	int arr2[10] = { 0 };
//	int sz = sizeof(arr1) / sizeof(arr1[0]);
//	my_memcpy(arr2, arr1, 24);
//	for (i = 0; i < sz; i++)
//	{
//		printf("%d ", arr2[i]);
//	}
//	return 0;
//}
//void* my_memcpy(void* dest, const void* scr, size_t n)
//{
//	assert(dest != NULL);
//	assert(scr != NULL);
//	void* ret = dest;
//	while (n--)//将n个字节拷贝
//	{
//		*(char*)dest = *(char*)scr;
//		++(char*)dest;
//		++(char*)scr;
//	}
//	return ret;
//}
//struct stu
//{
//	char name[10];
//	int age;
//};
//int main()
//{
//	struct stu s1[2] = { {"zhang",23},{"lis",43} };
//	struct stu s2[3] = { 0 };
//	my_memcpy(s2, s1, sizeof(s1));//可以拷贝任何数组的数据
//	printf("%s ", s2->name);
//	printf("%d ", s2->age);
//	printf("%s ", s2[1].name);
//	printf("%d ", (s2+1)->age);
//	return 0;
//}
//memcpy也有局限性在拷贝自身元素时可能会出错
//内存拷贝函数memove函数--可拷贝自身
//void* my_memmove(void* dest, const void* scr, size_t n)
//{
//	assert(dest&&scr);
//	void* ret = dest;
//	if (scr < dest )//从后向前拷贝
//	{
//		//char* s1 = (char*)dest + n - 1;
//		//char* s2 = (char*)scr + n - 1;
//		//while (n--)
//		//{
//		//	*s1 = *s2;
//		//	s1--;
//		//	s2--;
//		//}//优化
//		while (n--)
//		{
//			*((char*)dest + n) = *((char*)scr + n);//每次n的变化使其从后向前拷贝
//		}
//
//	}
//	else//从前向后拷贝
//	{
//		while (n--)
//		{
//			*(char*)dest = *(char*)scr;
//			++(char*)dest;
//			++(char*)scr;
//		}
//	}
//	return ret;
//}
//int main()
//{
//	int i;
//	int arr1[] = { 1,2,3,4,5,6 };
//	//memmove(arr1 + 1, arr1, 12);
//	my_memmove(arr1 + 1, arr1+2, 12);
//	for (i = 0; i < sizeof(arr1) / sizeof(arr1[0]); i++)
//	{
//		printf("%d ", arr1[i]);
//	}
//	return 0;
//}
//memcmp 内存比较函数的实现
//memcmp(arr1,arr2,比较字节的数字)
//arr1>arr2 返回一个大于0的数字
//arr1==arr2 返回一个0
//arr1<arr2 返回一个小于0的数字
//int my_memcmp(const void* e1,const void* e2, int num)
//{
//	assert(e1&&e2);
//	while (num)
//	{
//		if(*(char*)e1 == *(char*)e2)
//		{
//			((char*)e1)++;
//			((char*)e2)++;
//			num--;
//		}
//		else if (*(char*)e1 > *(char*)e2)
//			return 1;
//		else
//			return -1;
//	}
//	return 0;
//}
//int main()
//{
//	int arr1[] = { 1,2,3,4,5 };
//	int arr2[] = { 1,2,3,5,6 };
//	//int ret = memcmp(arr1, arr2, 8);
//	int ret = my_memcmp(arr1, arr2, 16);
//	printf("%d ", ret);
//	return 0;
//}
//设置内存 memset 函数
//memset(arr,需要存入的东西，要改的字节数)
//memset函数是一个字节一个字节的改的，要改成的内容任意定义，不过只能是一个字节
//int main()
//{
//	int i = 0;
//	char arr1[11] = "";
//	memset(arr1, 'd', 10);
//	printf("%s", arr1);
//	return 0;
//}