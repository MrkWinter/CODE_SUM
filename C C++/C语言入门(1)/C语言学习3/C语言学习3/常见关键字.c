#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
// main()
//{//常见关键字
	//auto局部变量前自动关键字，表示自动生成，自动删除 auto int a = 38
	//break,case,char,const,continue,default,do,double,else,enum,
	//extern,float,for,goto,if,(signed)int  有符号定义  （unsigned int 无符号定义，永远是正数）,long,reginster,
//	register int a = 10;//建议把整型a放在寄存器里访问更快
    //return,short,sizeof,static,struck,switch,typedef,union,void,volatile,while

	 
	//typedef  类型定义  类型重定义
//	typedef unsigned int u_int;
//	unsigned int a = 19;
//	u_int b = 2;





//	return 0;
//}
//static 修饰局部变量为延长局部变量的生命周期
//static 修饰全局变量为改变全局变量的作用域
//static 修饰全局函数为改变函数的链接属性
//void test()//void 为定义一个没有返回值的函数 与int同地位
//{
//	 static int a = 1;//auto int 自动生成自动删除  函数结束保留a的值 a为静态的局部变量
//	a++;
//	printf("a = %d\n", a);
//}
//int main()
//{
//	extern int g_val;
//     int i = 0;
//	while (i < 5)
//	{
//		test();//test 函数
//		i++;
//
//	}
//
//	printf("%d\n", g_val);
//	return 0;
//}

extern int Add(int, int);//对外部函数调用声明
int main()
{
	int a, b,c;
	a = 8;
	b = 4;
	c = Add(a, b);
	printf("sum = %d\n", c);
	return 0;
}