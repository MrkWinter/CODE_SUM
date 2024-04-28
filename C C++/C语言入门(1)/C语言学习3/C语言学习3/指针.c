#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//内存相当于土地 
//内存经过编号变成一块一块的
//32位计算机表示由32根数据线/地址线来为内存编号
//数据线正电为1负电为0
//一共可以产生2^32个编号 一个编号对应一块内存
//一块内存为一字节
//eg:int 类型占用4个字节也就是4块内存
//地址输出时为16进制的所用的第一块内存编号

//int main()
//{//有一种变量是用存放地址的 ——指针变量
//	int a = 10;//4个字节
//	int b = 10;//
//	int* p = &b;//指针变量P类型为int*  //指针变量存储的是地址即内存编号 32位电脑上指针变量占用4个字节 64位电脑占8个字节
//	printf("%p\n", &a);//&a 为取地址
//	printf("%p\n", p);//打印地址用%p
//	//*--解引用操作符  （解开p引出的a的地址，找到a并加以更改使用）
//	*p = 56;//指针变量p存储了a的地址，*p=56相当于通过p中存储的a的地址找到a，将其=56，等价于a =56
//	printf("%d\n", a);
//	return 0;
//}
int main()
{
	char a = 'w';//创建字符变量a
	char* ch = &a;//取a的地址存储到ch中
	*ch = 'n';//解引用ch 找到a的地址 将内存a中存储的‘w’改为‘n’
	printf("%c\n", a);//输出a (此处a=n)
	printf("%d\n", sizeof(ch));//32位电脑指针变量占4个字节（32个比特位）64位电脑指针变量占8个字节

	return 0;
}



