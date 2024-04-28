#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<assert.h>
#include<string.h>
//字符函数和字符串函数
//求字符串长度strlen 函数实现的三种方法
//1.计数器
//2.递归
//3.指针减指针

//int my_strlen1(const char* arr)
//{
//	assert(arr!=NULL);
//	int count = 0;
//	while (*arr != '\0')//统计'\0'前字符数
//	{
//		count++;
//		arr++;
//	}
//	return count;
//}
//int my_strlen2(const char* arr)
//{
//	assert(arr);
//	if (*arr != '\0')
//	{
//		return 1 + my_strlen2(arr + 1);//第一个字符长度加上之后字符串长度
//	}
//	else//找到'\0'结束，返回0
//		return 0;
//}
//int my_strlen3(const char* arr)
//{
//	assert(arr);
//	char* p = arr;//使指针p指向字符串首元素处
//	while (*arr != '\0')//使指针arr指向字符串'\0'处
//	{
//		arr++;
//	}
//	return arr - p;//指针相减返回其间元素个数
//}
//int main()
//{
//	char arr[] = "abcdefg";
//	printf("%d ", my_strlen1(arr));//1.计数器方法
//	printf("%d ", my_strlen2(arr));//2.递归方法
//	printf("%d ", my_strlen3(arr));//3.指针相减法
//	return 0;
//}
//库函数中strlen返回值为 size_t(unsiged int) 无符号数字
//int main()
//{
//	char arr[] = "abcdefg";
//	char arr2[] = "abc";
//	if (strlen(arr2) - strlen(arr) > 0)//判断结果>0 因为-3被认为无符号数 补码一定是很大的正数
//	{
//		printf("hehe");//打印hehe
//	}
//	else
//		printf("haha");
//	return 0;
//}
//拷贝字符串strcpy函数实现方法
//char* my_strcpy(char* arr1,const char* arr2)
//{
//	assert(arr1 != NULL);
//	assert(arr2 != NULL);
//	char* arr = arr1;
//	while (*arr1++ = *arr2++)//arr2中'\0'赋给arr1后结束循环
//	{
//		;
//	}
//	return arr;
//}
//int main()
//{
//	char arr1[] = "abcdefg";
//	char arr2[] = "bit";
//	printf("%s",my_strcpy(arr1, arr2));//库函数中strcpy函数以char*为返回值
//	return 0;
//}
//对于strcpy (目标字符串，源字符串)
//源字符串必须以'\0'结束
//能将源字符串中'\0'拷贝
//目标空间必须足够大
//目标空间必须可变

//字符串追加函数 strcat函数的实现
//char* my_strcat(char* dest,const char* src)
//{
//	assert(dest&&src);
//	char* arr1 = dest;
//  //1.找到目的字符串的'\0'
//	while (*dest != '\0')
//	{
//		dest++;
//	}
// //2.追加
//	while (*dest++ = *src++)
//	{
//		;
//	}
//	return arr1;
//}
//int main()
//{
//	char arr1[30] = "abcdefg";
//	char arr2[] = "bit";
//	printf("%s", my_strcat(arr1, arr2)); //库函数中strcat函数以char*为返回值
//	return 0;
//}
//对于strcat (目标字符串，源字符串)
//源字符串必须以'\0'结束
//能将源字符串中'\0'拷贝
//目标空间必须足够大
//目标空间必须可变
//字符串比较函数strcmp的实现
//strcmp 比较方法  依次比较字符串中字符的的assis码值
//int my_strcmp(char* arr1, char* arr2)
//{
//	assert(arr1&&arr2);
//	while (*arr1 == *arr2)//找到不相等的字符
//	{
//		if (*arr1 == '\0')//找到相等字符为'\0',则两字符串相等
//			return 0;
//		arr1++;
//		arr2++;
//	}
//	//return *arr1 - *arr2;
//	if (*arr1 > *arr2)
//		return 1;
//	else
//		return -1;
//
//}
//int main()
//{
//	char arr1[] = "abcd";
//	char arr2[] = "abcde";
//	int ret = my_strcmp(arr1, arr2);
//	if (ret > 0)
//	{
//		printf("arr1>arr2");
//	}
//	else if (ret == 0)
//	{
//		printf("arr1==arr2");
//	}
//	else
//	{
//		printf("arr1<arr2");
//	}
//	return 0;
//}
//长度不受限制的字符串函数 strcpy strcat strcmp
//长度受限的字符串函数 strncpy strncat  strncmp
//实现指定字符串拷贝函数strncpy
//拷贝num个字符从源字符到目标空间
//如果源字符串的长度小于num，则拷贝完源字符串后，在目标的后面追加0，直到num个
//char* my_strncpy(char* arr1, const char* arr2,int a)
//{
//	assert(arr1&&arr2);
//	char* arr = arr1;
//	while (a)
//	{
//		if (*arr2 != '\0')
//		{
//			*arr1 = *arr2;
//			arr1++;
//			arr2++;
//		}
//		else if (*arr2 == '\0')
//		{
//			while (a)
//			{
//				*arr1 = '\0';
//				arr1++;
//				a--;
//			}
//			break;
//		}
//		a--;
//	}
//	return arr;
//}
//int main()
//{
//	char arr1[] = "abcdef";
//	char arr2[] = "xxx";
//	printf("%s", my_strncpy(arr1, arr2, 3));
//	return 0;
//}
//指定字符串追加函数strncat
//追加后在字符串后自动补上一个'\0'
//若指定追加字符大于源字符，只把源字符串追加到目标字符串上后补'\0'
//char* my_strncat(char* arr1, const char* arr2, int a)
//{
//	assert(arr1&&arr2);
//	char* arr = arr1;
//	while (*arr1 != '\0')
//	{
//		arr1++;
//	}
//	while (a)
//	{
//		if (*arr2 == '\0')
//			break;
//		*arr1 = *arr2;
//		arr1++;
//		arr2++;
//		a--;
//	}
//	*arr1 = '\0';
//	return arr;
//}
//int main()
//{
//	char arr1[30] = "abcdef";
//	char arr2[] = "ghijk";
//	printf("%s", my_strncat(arr1, arr2, 4));
//	return 0;
//}