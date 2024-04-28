#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//代码由文本到执行完成发生的事情
//test.c->test.exe->执行
//test.c在翻译环境下成为test.exe再在执行环境下运行
//翻译环境下可分为编译步骤和链接步骤 test.c编译完成后成为目标文件 目标文件经过链接成为test.exe
//编译步骤在编译器下进行 分为预编译 编译 汇编 
//1.预编译 这个步骤为文本操作 如#inlude头文件的包含 注释删除变为空格 #define定义的替换  test.c->test.i
//2.编译 这个步骤为转换c为汇编代码 如语法分析 词法分析 语义分析 符号汇总 test.i->test.s
//符号汇总包含 函数名 全局变量等 符号汇总的好处在编译原理中有讲
//3.汇编 这个步骤把汇编代码转换成二进制指令 每个源文件在编译这个步骤进行的符号汇总 在汇编会形成自己的符号表 test.s->test.o
//链接步骤在链接器下进行 分为合并段表 符号表的合并和重定位
//1.合并段表 汇编结束后每个源文件会形成目标文件 目标文件会在链接步骤形成ELF文件 所有elf文件进行段表合并信息
//2.符号表的合并和重定位 目标文件有自己的符号表 所有符号表会进行合并和重定位 最后形成可执行程序 test.exe
//程序执行主要步骤为
//可执行程序载入内存 程序从main函数开始 开始执行代码 程序结束
//预处理详解
//1.预定义符号 __FILE__文件名   __LINE__行号   __DATE__日期   __TIME__时间   __FUNCTION__函数
//__STDC__ 编译器遵循 ANSI C c标准为1，否未定义
//int main()
//{
//	FILE* LOG = fopen("log.txt", "w");
//	int i;
//	int arr[10] = { 0 };
//	for (i = 0; i < 10; i++)
//	{
//		arr[i] = i;
//		printf("%d ", arr[i]);
//		//文件日志
//		fprintf(LOG, "FILE:%s LINE:%d DATE:%s TIME:%s FACTION:%s\n",
//			__FILE__, __LINE__, __DATE__, __TIME__, __FUNCTION__);
//	}
//	fclose(LOG);
//	LOG = NULL;
//	//printf("%d", __STDC__);报红不支持
//	return 0;
//}
//2.#define定义的标识符
//#define可定义任何 包括常量 函数 甚至代码
//#define do_fover for(;;)
//int  main()
//{
//	do_fover//死循环
//		;
//	return 0;
//}
//2.#define 定义的宏 参数替换到文本中
//#define name(参数) stuff
#define pows(x) x*x
//int main()
//{
//	int a = pows(3);
//	printf("%d ", a);
//	a = pows(3 + 1);//7 宏的参数为替换 不是传参
//	printf("%d ", a);
//	a = pows((3 + 1));//16 定义宏时为一个整体最好加上（） 如#define pows(x) ((x)*(x)) 不容易造成错误
//	printf("%d ", a);
//	return 0;
//}
//void print(a)//函数局限性
//{
//	printf("the value of a is %d\n", a, a);
//}
//int main()
//{
//	int a = 1;
//	int b = 2;
//	print(a);
//	print(b);
//	return 0;
//}
//#宏参数 可把参数转换成字符串 "参数"
//可实现字符串插入
//#define PRINT(X) printf("the value of "#X" is %d\n",X)
////#X转换成了"X" printf函数中相邻字符串会自动连接
//int main()
//{
//	int a = 2;
//	int b = 4;
//	PRINT(a);
//	PRINT(b);
//	return 0;
//}
//## 可以把它两边的符号合成一个符号 在宏定义中可形成一个新的标识符
//#define CAT(X,Y) X##Y
//int main()
//{
//	int Class_3 = 34;
//	printf("%d", CAT(Class, _3)); //CAT(Class, _3) 相当于 Class_3
//	return 0;
//}
//宏参数的定义具有副作用
//#define MAX(a,b) ((a)>(b)?(a):(b))
//int main()
//{
//	int a = 9;
//	int b = 4;
//	int max = MAX(a++, b++); //((a++)>(b++)?(a++):(b++)) 宏参数的实质是替换
//	printf("%d ", max);//10
//	printf("%d ", a);//11
//	printf("%d ", b);//5
//	return 0;
//}
//宏和函数的对比
//1.代码长度上 函数更占优势 函数只出现于一个地方 使用时调用就行  定义的宏如果较长 多次使用会使代码长度大幅增加
//2.执行速度上 宏更占优势 宏只是进行替换  而函数调用和返回则需要一定的开销会比较慢
//3.操作符优先级上 函数占优势 宏的替换可能会因符号优先级原因出现错误 函数传参是先计算后传参 求的值更容易预测 不容易出错
//4.带有副作用的参数上 函数更占优势 宏只是完成替换 带有副作用的参数可能会产生不可预料的结果 函数参数传参使求值一次 更容易控制
//5.参数类型上 各有千秋 宏的参数与类型无关 相对较灵活 但也因此不太严谨 函数参数与类型有关 不太灵活 但因此比较严谨
//6.调试方面 函数更占优势 函数可以调试 宏在预处理阶段就完成了替换 不能调试 也不宜观察
//7.递归方面 函数更占优势 函数可递归 宏不能递归
//在某些方面 宏可以做到函数做不到的事 如宏可以传递类型 函数不能
//用于移除一个宏定义 #undef