#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
//test.c 可执行程序
//debug debug版本的可执行程序    可以调试
//release release版本的可执行程序  不能调试
//debug 测试版本 它包含调试信息，不做任何优化，便于程序员测试
//release 发布版本  进行了各种优化，在代码速度和大小上都是最优，便于用户使用
//int main()
//{
//	int i;
//	for (i = 0; i < 100; i++)
//	{
//		printf("%d ", i);
//	}
//	system("pause");
//	return 0;
//}
//断点，f9 配合调试f5快速找到问题
//ctrl+f5  开始执行不调试
//f5  开始调试
//f9  添加断点
//f10 逐过程
//f11 逐语句
//shift+f11 跳出函数
//shift+f5 结束调试
//int add(int a, int b)
//{
//	return a + b;
//}
//int main()
//{
//	int i = 0;
//	for (i = 0; i < 10; i++)
//	{
//		printf("%d ", i);
//	}
//	for (i = 0; i < 10; i++)
//	{
//		printf("%d ", 10-i);
//	}
//	printf("%d ", add(1, 4));
//	return 0;
//}
//调用堆栈来查看函数调用情况
//test3()
//{
//	printf("hehe\n");
//}
//test2()
//{
//	test3();
//}
//test1()
//{
//	test2();
//}
//int main()
//{
//	test1();
//	return 0;
//}
//求1!+2!+3!...+n!
//int jei(int n)
//{
//	int sum = 1;
//	int i;
//	for (i = 1; i <= n; i++)
//	{
//		sum *= i;
//	}
//	return sum;
//}
//int sum(int n)
//{
//	int sum = 0;
//	int a = 0;
//	for (a = 1; a <= n; a++)
//	{
//		sum += jei(a);
//	}
//	return sum;
//}
//int main()
//{
//	int a;
//	scanf("%d", &a);
//	printf("%d", sum(a));
//	return 0;
//}
//栈区储存内存地址由高到低使用
//int main()
//{
//	int arr[] = { 1,2,3,4,5,6,7,8,9,10};
//	int i;
//	for (i = 0; i <= 12; i++)
//	{
//		printf("hehe\n");
//		arr[i] = 0;//数组越界访问, &arr[12]为野指针，访问到了i的内存 &arr[12]==&i
//	}
//	//陷入死循环 进入relase版本后不会死循环
//	//relase版本会优化改变内存使用方式 可能会出现bug
//	return 0;
//}
//实现strcpy
//int main()
//{
//	char arr1[] = "#############";
//	char arr2[] = "bit";
//	strcpy(arr1, arr2);
//	printf("%s", arr1);
//	return 0;
//}
//void my_strcpy(char* dest, char* src)
//{
//	while (*src != '\0')//出现问题影响其他代码，并且难以找到错误
//	{
//		*dest = *src;
//		dest++;
//		src++;
//	}
//	*dest = *src;
//}
//int main()
//{
//	char arr1[] = "#############";
//	char arr2[] = "bit";
//	my_strcpy(arr1, arr2);
//	printf("%s", arr1);
//	return 0;
//}
//优化
//void my_strcpy(char* dest, char* src)
//{
//	if (*dest != NULL && *src != NULL)//出现问题不影响其他代码，但不利于检查
//	{
//		while (*dest++ = *src++)//当arr2中的'\0'(ascii码值为0)赋给arr1时结束循环
//		{
//			;
//		}
//	}
//}
//int main()
//{
//	char arr1[] = "#############";
//	char arr2[] = "bit";
//	my_strcpy(arr1, arr2);
//	printf("%s", arr1);
//	return 0;
//}
//优化
#include<assert.h>
//void my_strcpy(char* dest, char* src)
//{
//	assert(dest != NULL);
//	assert(src != NULL);//断言，出错报错，直接找出错误
//	while (*dest++ = *src++)//当arr2中的'\0'(ascii码值为0)赋给arr1时结束循环
//	{
//		;
//	}
//}
//int main()
//{
//	char arr1[] = "#############";
//	char arr2[] = "bit";
//	my_strcpy(arr1, arr2);
//	printf("%s", arr1);
//	return 0;
//}
//优化
//void my_strcpy(char* dest, const char* src)//const修饰防止修改arr2出错
//{
//	assert(dest != NULL);
//	assert(src != NULL);//断言，出错报错，直接找出错误
//	while (*dest++ = *src++)//当arr2中的'\0'(ascii码值为0)赋给arr1时结束循环
//	{
//		;
//	}
//}
//int main()
//{
//	char arr1[] = "#############";
//	char arr2[] = "bit";
//	my_strcpy(arr1, arr2);
//	printf("%s", arr1);
//	return 0;
//}
//const修饰的指针
//int main()
//{
//	int b = 2;
//	int a = 23;
//	const int* p = &a;//const放在*的左边时 修饰*p  不能通过p来改变*p(a) 
//	//*p = 34;错误
//	int* const t = &a;//const放在*的右边时 修饰p  不能改变指针变量p的值
//	//p = &b;错误
//	//总结 右保地址左保值
//	return 0;
//}
//优化
//char* my_strcpy(char* dest, const char* src)//const修饰防止修改arr2出错
//{
//	char* ret = dest;
//	assert(dest != NULL);
//	assert(src != NULL);//断言，出错报错，直接找出错误
//	while (*dest++ = *src++)//当arr2中的'\0'(ascii码值为0)赋给arr1时结束循环
//	{
//		;
//	}
//	return ret;
//}
//int main()
//{
//	char arr1[] = "#############";
//	char arr2[] = "bit";
//	printf("%s",my_strcpy(arr1, arr2));//改为返回值为拷贝后字符串的地址，链式访问进行打印
//	return 0;
//}
//满分strlen函数
//int my_strlen(const char* arr)//防止函数内修改字符串
//{
//	int count = 0;
//	assert(arr != NULL);//指针保护，保护指针的有效性
//	while (*arr++ != '\0')
//	{
//		count++;
//	}
//	return count;
//}
//int main()
//{
//	char arr[] = "abcedfghi";
//	printf("%d", my_strlen(arr));
//	return 0;
//}
//常见的错误类型
//1.编译型错误，2.链接型错误，3.运行时错误