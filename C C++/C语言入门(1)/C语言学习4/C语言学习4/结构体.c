#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
//复杂对象表示 --结构体--我们自己创建出来的一种类型
//创建一个结构体类型
struct Book
{
	char name[20];
	short price;
};

int main()
{//利用结构体类型创建一个该类型的结构体变量
	struct Book b1 = { "C语言程序设计", 55 };
	printf("书名：%s\n", b1.name);
	printf("价格：%d元\n", b1.price);
	b1.price = 88;
	printf("修改后的价格为：%d元\n", b1.price);
	struct Book* v = &b1;
	//.结构体变量.成员
	//->结构体指针->成员
	printf("%s\n", (*v).name);//解地址找到b1 (*v)相当于b1
	printf("%d\n", (*v).price);
	printf("%s\n", v->name);//指针指向b1 v->相当于b1.
	printf("%d\n", v->price);

	strcpy(b1.name, "C++");//strcpy 字符串拷贝--库函数--string.h 更改数组类型的字符串
	printf("更改后的书名：%s\n", b1.name);
	return 0;
}