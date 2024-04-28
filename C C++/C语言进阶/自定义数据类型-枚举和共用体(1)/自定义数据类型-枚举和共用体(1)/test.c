#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//枚举类型
//enum color
//{
//	red, //默认为第一个为0 枚举类型中的值从上到下递增
//	blue = 3, //枚举类型中的常量可定义初始值，但在括号外无法修改和定义
//    green,
//};
//int main()
//{
//	enum color ru = red;//red 为枚举变量 枚举变量的可能取值 在前规定  枚举变量的大小为4个字节
//	printf("%d %d %d ", red, blue, green);
//	printf("%d", ru);
//	return 0;
//}
//枚举的优点
//1增加了代码的可读性和可维护性
//2和#define定义的标识符相比有类型检查，更加严谨
//3防止了命名污染
//4便于调试
//5使用方便，一次可以定义多个常量
//联合体的定义
//union A
//{
//	char a;
//	int b;
//};
//int main()
//{
//	union A s = { 0 };
//	printf("%d ", sizeof(s));
//	//联合体中的数据存放在同一块空间，同样的地址
//	//联合体的所占空间的大小为其中元素所占字节大小的最大值
//  //联合体大小并且是元素最大对齐数的整数倍
//	//修改一个元素，另一个元素也会变,应只使用一个元素
//	return 0;
//}
//用联合体检测大小端
//int check()
//{
//	union A
//	{
//		char a;
//		int b;
//	}s1;
//	s1.b = 1;//将1存储在b中
//	return s1.a;//取出a
//}
//int main()
//{
//	int ret = check();
//	if (ret == 1)
//		printf("小端");
//	else
//		printf("大端");
//	return 0;
//}
