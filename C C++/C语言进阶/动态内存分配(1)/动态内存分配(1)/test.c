#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<errno.h>
#include<string.h>
//内存分为 栈区 堆区 静态区
//栈区 储存 局部变量 函数的形参
//堆区 储存 动态内存分配
//静态区 储存 全局变量 静态变量 
//动态内存分配主要是解决内存开辟局限性的问题的
//动态内存开辟函数 malloc
//malloc(字节大小)
//void * malloc(size_t size)
//若内存有充足空间 则返回 开辟内存的指针 指向首地址 指针类型为void*类型
//若内存不足 则返回空指针
//int main()
//{
//	int* p = (int*)malloc(sizeof(int)*10);//开辟10个整型大小的内存 INT_MAX 很大的字节内存
//	if (p == NULL)//开辟空间时应检查是否开辟成功
//		printf("%s", strerror(errno));//打印错误信息
//	else
//	{//开辟成功 使用空间
//		int i;
//		for (i = 0; i < 10; i++)
//		{
//			*(p + i) = i;
//		}
//		for (i = 0; i < 10; i++)
//		{
//			printf("%d ", *(p + i));
//		}
//	}
//	//当动态申请的空间不再使用时
//	//就应该还给操作系统，不然程序的生命周期结束前会影响其他代码的运行
//	//free函数 释放开辟的动态内存空间 free(开辟空间后返回产生的指针)
//	free(p);
//	//释放内存后指针p仍然有值    不安全     应改为NULL 以防出现错误
//	p = NULL;
//	//malloc函数 free函数 和改空指针 的操作应一块使用
//	return 0;
//}
//动态内存开辟函数calloc 函数
//void * calloc(size_t num, size_t size)
//使用 calloc(开辟元素个数，开辟元素字节大小)
//calloc和malloc 相似 开辟成功返回开辟空间的指针 失败返回NULL
//calloc开辟的空间也需要free函数释放
//calloc函数的不同之处是会把开辟的空间初始化成0
//申请动态内存使用方式不同
//malloc函数在不需要初始化内存的情况下更高效
//calloc函数在需要初始内存的情况下更方便
//int main()
//{
//	int* ret = (int*)calloc(10, sizeof(int));
//	if (ret == NULL)
//	{
//		printf("%s", strerror(errno));//开辟失败打印失败信息
//	}
//	else
//	{
//		int i;
//		for (i = 0; i < 10; i++)
//		{
//			printf("%d ", *(ret + i));//开辟成功打印初始化元素
//		}
//	}
//	free(ret);//释放动态内存
//	ret = NULL;
//	return 0;
//}
//当开辟动态内存空间不足时
//调整开辟内存空间函数 realloc
//void* realloc(void* ptr,size_t size)
//realloc(原开辟动态内存返回的指针或空指针，需要重新开辟动态内存的大小)
//realloc 成功增加开辟内存后返回开辟内存的指针 若开辟失败返回NULL
//realloc 增添开辟内存的方式有
//1.若原开辟的内存块后有充足的内存 则直接在原基础上向后开辟空间 返回原指针的值
//2.若原开辟的内存块后没有充足的内存 则在堆区重新找一块新的内存开辟 把原内存块内数据拷贝到新的内存块
//并且释放原内存块 返回新开辟的内存块的地址作为新的指针
//3.若需要开辟的空间太大 开辟失败 则会返回NULL 当把函数返回值赋给旧指针时 会出现危险 旧指针被覆盖 无法找到旧内存块
//并且无法释放 最好使用一个新的指针作为返回值
//为方便使用指针维护内存 可以进行先判断是否为空指针 再赋值给原指针的方法  最后释放内存
//int main()
//{
//	int* p = malloc(5 * sizeof(int));
//	if (p == NULL)
//	{
//		printf("%s", strerror(errno));
//	}
//	else
//	{
//		int i;
//		for (i = 0; i < 5; i++)
//		{
//			*(p + i) = i;
//		}
//	}
//	//想使用更多空间
//	int* ptr = realloc(p, 10 * sizeof(int));
//	if (ptr == NULL)//保护指针p
//	{printf("%s", strerror(errno));
//	}
//	else
//	{
//		p = ptr;
//		int i;
//		for (i = 5; i < 10; i++)//使用新开辟的空间
//		{
//			*(p + i) = i;
//		}
//		for (i = 0; i < 10; i++)
//		{
//			printf("%d ", *(p + i));
//		}
//	}
//	free(p);//释放内存
//	p = NULL;
//	ptr = NULL;
//	return 0;
//}
//当realloc传空指针时可以和malloc实现一样的功能
//int main()
//{
//	int* p = realloc(NULL, 40);//他们功能相同
//	int* p2 = malloc(40);
//	free(p);
//	p = NULL;
//	free(p2);
//	p2 = NULL;
//	return 0;
//}