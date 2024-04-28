#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<errno.h>
//动态内存开辟的常见错误
//1.解引用开辟失败的空指针
//2.越界访问开辟的内存
//3.将处于栈区的内存释放
//4.使用free释放动态开辟空间的一部分（返回的指针p最好不要动，需要使用p来释放空间）
//5.对同一块内存多次释放
//6.对动态开辟的内存忘记释放（内存泄漏）
//错误分析
//void getmemory(char* p)//p为str的一份临时拷贝
//{
//	p = (char *)malloc(100);//函数结束后p会被销毁，开辟的内存无法释放
//}
//void test()
//{
//	char* str = NULL;
//	getmemory(str);//str传递的是值//
//	strcpy(str, "hellow");//空指针无法拷贝,程序崩溃
//	printf(str);//可以直接打印指针
//}
//int main()
//{
//	test();
//	return 0;
//}
////1.运行代码程序会出现崩溃的现象
////2.程序存在内存泄漏的问题
//修改
//void getmemory(char** p)
//{
//	*p = (char *)malloc(100);
//	if (*p == NULL)
//	{
//		printf("%s", strerror(errno));
//	}
//}
//void test()
//{
//	char* str = NULL;
//	getmemory(&str);
//	strcpy(str, "hello");
//	printf(str);
//	free(str);
//	str = NULL;
//}
//int main()
//{
//	test();
//	return 0;
//}
//非法访问栈区内存
//int* test()
//{
//	int a = 0;//非法访问栈区内存 加上static后正确 
//	return &a;
//}
//int main()
//{
//	int *p = test();
//	printf("%d",*p);
//	return 0;
//}
//栈区申请的空间出作用域后就会销毁 静态区和堆区不会，直到程序结束

typedef struct stack
{
	int* date;
	int top;
	int size;
}stack;
stack* Inital(int n)
{
	stack* sta = (stack*)malloc(sizeof(stack)*1);
	sta->size = 10;
	sta->top = 0;
	sta->date = (int*)malloc(sizeof(int) * 10);
	sta->date[0] = 1;
	return sta;//sta保存的是指针 只是记录了一个地址 接收动态分配的内存地址 可以直接返回该地址地址的临时拷贝被销毁
	//但仍可根据地址找到开辟的内存数据
	
	
}
int main()
{

	stack* sta = Inital(10);
	printf("%d", sta->date[0]);

	return 0;
}