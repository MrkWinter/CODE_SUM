#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//野指针：指的是指针指向的位置是不可知的（随机的、不正确的、没有明确限制的）
//如何规避野指针？
//1.指针初始化
//2.小心指针越界
//3.指针指向空间释放即使置NULL
//4.指针使用前检查有效性
//int main()
//{
//	int a = 9;
//	int* pa = &a;//初始化
//	int* pb = NULL;//NULL--用来初始化指针的，或者给指针赋值
//	pa = NULL;//不用时置成空指针
//	if (pa != NULL)//使用前检查是否有意义，检查有效性
//		printf("有效");
//	return 0;
//}
//指针运算
//1.指针+-整数
//int main()
//{
//	int i;
//	int arr[10] = { 1,2,3,4,5,6,7,8,9,10 };
//	int* p = arr;
//	for (i = 0; i < 10; i++)
//	{
//		printf("%d ", *p);
//		p++;//指针加减
//	}
//	return 0;
//}
//2.指针-指针
//int main()
//{
//	int i;
//	int arr[] = { 1,2,3,4,5,6,7,8,9,10 };
//	int* pa = arr;
//	int* pb = &arr[9];
//	printf("%d", pb - pa);//指针-指针是中间的元素个数，指针-指针类型应相等，并且为同一块空间，否则不可预知
//	return 0;
//}
//3.指针的关系运算
//int main()
//{
//	int i;
//	int arr[] = { 1,2,3,4,5,6,7,8,9,10 };
//	int* pa = arr;
//	int* pb = &arr[9];
//	while (pa <= pb)//指针比较大小
//	{               //注意，因为语法规定，数组中的指针允许与数组后面那一块内存的指针比较，不建议与数组前面那一块内存的指针比较
//		printf("%d ", *pa);//不然可能会报错
//		pa++;
//	}
//	return 0;
//}
//strlen函数的实现
//递归求字符串长度
//int str(char arr[])
//{
//	if (*arr == '\0')
//		return 0;
//	else
//		return str(arr + 1)+1;
//}
//int main()
//{
//	char arr[] = "abcdefg";
//	printf("%d ",str(arr));	
//	return 0;
//}
//指针求字符串长度
//int my_strlen(char* arr)
//{
//	char* start = arr;
//	char* end = arr;
//	while (*end !='\0')//找到指向字符串末尾的指针
//	{
//		end++;
//	}
//	return end - start;//末尾指针-初始指针=元素数-1
//}
//int main()
//{
//	char arr[] = "abcdef";
//	printf("%d", my_strlen(arr));
//	return 0;
//}
//指针和数组
//int main()
//{
//	int arr[10] = { 0 };
//	printf("%p\n", arr);//数组名为首元素的地址
//	                    //特殊情况：strlen（arr），&arr
//	printf("%p\n", &arr[0]);
//	return 0;
//}
//int main()
//{
//	int arr[10] = { 0 };
//	int* p = arr;//通过指针可访问数组
//	int i;
//	for (i = 0; i < 10; i++)
//	{
//		*(p + i) = i;
//	}
//	for (i = 0; i < 10; i++)
//	{
//		printf("%d ", *(p + i));
//	}
//	return 0;
//}
//二级指针
//int main()
//{
//	int a = 9;
//	int * pa = &a;//一级指针 
//	//理解：*指pa是指向int型变量的意思
//	int* * ppa = &pa;//二级指针（指向指针的地址）
//	//理解：*(第二颗)指ppa是指向int*型变量的意思
//	**ppa = 10;//二级指针使用
//	printf("%d", **ppa);
//	return 0;
//}
//指针数组
//存放指针的数组
int main()
{
	int a = 2, b = 7, c = 5;
	int* arr[] = { &a,&b,&c };//指针数组
	int i;
	for (i = 0; i < 3; i++)
	{
		printf("%d ", *arr[i]);//找到数组中的地址元素，解引用，打印原数
	}
	return 0;
}