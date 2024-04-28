#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
//柔性数组 
//结构体中最后一个元素（不能是第一个）允许是未知大小的数组，这叫做柔性数组成员
//struct S
//{
//	int a;
//	int arr[0];
//
//};
//int main()
//{
//	struct S s1;
//	printf("%d\n", sizeof(s1));// 4 结构体中柔性数组不占内存 但可以开辟内存来使用使用它
//	return 0;
//}
//例
//int main()
//{
//	struct S s1;
//	struct S* ps =(struct S*) malloc(sizeof(s1) + 5 * sizeof(int));//等于给柔性数组arr20个字节的空间使用
////定义一块空间 以结构体的方式使用 结构体中包含柔性数组 柔性数组可变化大小 
//	if (ps == NULL)
//		return 0;
//	//使用
//	int i;
//	ps->a = 10;
//	for (i = 0; i < 5; i++)
//	{
//		ps->arr[i] = i;
//	}
//	//开辟新空间使用
//	struct S* str = realloc(ps, sizeof(s1) + sizeof(int)*10);
//	if (str == NULL)
//	{
//		return 0;
//	}
//	else
//	{
//		ps = str;
//	}
//	for (i = 5; i < 10; i++)
//	{
//		ps->arr[i] = i;
//	}
//
//	for (i = 0; i < 10; i++)
//	{
//		printf("%d ", ps->arr[i]);
//	}
//	printf("%d", ps->a);
//	free(ps);
//	ps = NULL;
//	str = NULL;
//		return 0;
//}
//等价于柔性数组的实现形式
struct S
{
	int a;
	int* arr;//采用指针的形式指针指向一块开辟的动态内存的空间
};
int main()
{
	struct S s1;
	struct S* pa = malloc(sizeof(s1));//为结构体申请动态内存空间
	pa->arr = malloc(5 * sizeof(int));
	if (pa->arr == NULL)
		return 0;
	int i;
	for (i = 0; i < 5; i++)
	{
		pa->arr[i] = i;
	}
	//调整大小
	int * prt = realloc(pa->arr, 10 * sizeof(int));
	if (prt == NULL)
		return 0;
	else
		pa->arr = prt;
	for (i = 5; i < 10; i++)
	{
		pa->arr[i] = i;
	}
	for (i = 0; i < 10; i++)
	{
		printf("%d ", pa->arr[i]);
	}
	free(pa->arr);
	pa->arr = NULL;
	prt = NULL;
	free(pa);
	pa = NULL;
	return 0;
}
//总结 柔性数组实现动态内存的方式为  以结构体指针的方式开辟一块动态内存 柔性数组元素根据开辟的内存进行使用
//可调整整个结构体指针指向的内存实现结构体中元素数组对内存的使用
//总的来说是开辟了一整块内存
//结构体中定义指针为元素的实现方式为 先以结构体指针开辟一块动态内存使用 再为指针元素开辟一块动态内存
//根据指针动态内存的调整实现结构体 指针(数组) 元素对内存的使用
//总的来说是两块内存
//对比 柔性数组更优
//1.柔性数组利于内存的释放
//2.柔性数组利于内存的利用 碎片化的内存更少
//3.柔性数组访问数据更快 