#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//命令行定义 --在命令行中定义符号

#define HELL
//条件编译 若满足则编译 不满足则不编译 在预编译直接删除

//int main()
//{
//	int arr[10] = { 1,2,3,4,5,6,7,8,9 };
//	int i;
//	for (i = 0; i < 10; i++)
//	{
//		arr[i] = i;
//#ifdef HELL //若有#define 定义则编译 无 则不编译 和#if defined(标识符)一样 和 ifndef HELL / #if !defined(标识符) 相反
//		printf("%d", arr[i]);
//#endif
//	}
//
//	return 0;
//}

//int main()
//{
//	int arr[10] = { 1,2,3,4,5,6,7,8,9 };
//	int i;
//	for (i = 0; i < 10; i++)
//	{
//		arr[i] = i;
//#if 0 //若有#if (常量表达式) 为真则编译 为假 则不编译
//		printf("%d", arr[i]);
//#endif
//	}
//
//	return 0;
//}

//int main()
//{
//#if 1-1     //和if else 语句一样 不过为真编译 为假不编译
//	printf("hehe"); 
//#elif 1-2
//	printf("dada");
//#else
//	printf("haha");
//#endif
//	return 0;
//}
//此外还有嵌套编译
//文件包含   #include 引入头文件的方式
//1.#include<  > 引用库函数 直接在库函数中查找 然后包含文件
//2.#include"  " 先在本地文件查找 找不到再在官方文件库里查找 然后包含
//如何避免文件多次包含
//1.
//#ifndef _HEEL_
//#define _HEEL_
//int add(int x, int y);
//#endif
////只会进行一次包含，第二次包含因为定义了_HEEL_ 就不会再编译
////2.
//#pragma once
//	int Add(int x, int y);
////现代写法 但在究编译器下无法使用
//ofsetof 宏 得出结构体的偏移量 的实现
//以0为结构体地址找到成员然后去成员的地址就是成员的偏移量
#include<stddef.h>
#define OFFSETOF(struct_name,member) (int)(&((struct_name*)0)->member)
//struct S
//{
//	char a;
//	int b;
//	float c;
//};
//int main()
//{
//	int ret = offsetof(struct S, b);
//	printf("%d ", ret);
//	ret = OFFSETOF(struct S, c);
//	printf("%d ",ret);
//
//	return 0;
//}
// 题目：找出单身狗