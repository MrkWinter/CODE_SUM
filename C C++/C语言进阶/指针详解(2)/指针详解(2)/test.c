#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//四、数组参数 指针参数
//总结
//1一维数组的传参
//函数接收一维数组时可以使用
// 相同类型数组接收 元素个数可写可不写
// 类型合适的一维指针接收 
//2二维数组的传参
//函数接收二维数组时可以使用
// 相同类型的二维数组接收 元素行可不写 列需要写
// 类型合适的数组指针接收
//3函数一级指针的传参
//函数中使用一级指针时实参可能为
//一维数组的数组名
//变量的地址
//一级指针
//4函数二级指针的传参
//函数中使用二级指针时实参可能为
//一维指针数组的数组名
//变量的一级指针的地址
//二级指针
//五、函数指针
//数组指针 ->指向数组的指针
//函数指针 ->指向函数的指针
//int add(int x, int y)
//{
//	int z;
//	z = x + y;
//	return z;
//}
//int main()
//{
//	int a = 12;
//	int b = 45;
//	printf("%d ", add(a, b));
//	int(*pa)(int, int) = add;//函数指针的定义
//	//&add和add都代表函数的地址 函数的地址存储在pa中 *pa得到add函数
//	//(*pa)代表pa为指针 (int,int)代表指针指向函数并且函数参数为两个int型 开头int代表函数的返回类型为int型
//	printf("%d ", (*pa)(a, b));
//	return 0;
//}
//例
//void print(char* pa)
//{
//	printf("%s", pa);
//}
//int main()
//{
//	print("abcde");
//	putchar('\n');
//	void(*pa)(char*) = print; //pa为函数指针
//	(*pa)("aaddcc");
//	return 0;
//}
//代码分析
//(*(void(*)())0)()  void(*)()为函数指针类型 void(*)()0即把0强制类型转换成函数指针 指针指向的函数参数类型为空 返回值为void
//*(void(*)()0) 得到函数参数类型为空 返回值为void的函数  (*(void(*)())0)() 即调用以0为地址的这个函数
//总结 为这是一个函数调用 调用的是参数类型为无参 返回值为空的函数
//void (*signal(int, int(*)(int)))(int)
//这是一个函数声明
//signal(int ,void(*)(int))signal 是一个函数 函数参数第一个为int型 第二个为函数指针类型 该函数指针指向的函数参数为int 返回类型为void
//void(*)(int) 是signal函数的返回类型 返回类型为函数指针 该指针指向的函数参数为int 返回类型为void
//简化
//int main()
//{
//	typedef void(*tun)(int); //定义void(*)(int)函数指针类型为tun 定义指针时定义符号和*结合
//	void(*signal(int, void(*)(int)))(int);//可转换为
//	void(*signal(int, tun))(int);//进一步转换为
//	tun signal(int, tun);
// 	return 0;
//}
//int add(int x, int y)
//{
//	int z;
//	z = x + y;
//	return z;
//}
//int main()
//{
//	int a = 12;
//	int b = 45;
//	printf("%d ", add(a, b));
//	int(*pa)(int, int) = add;//函数指针 int(*pa)(int,int)=&add 函数名就代表函数的地址
//	printf("%d ", (*pa)(a, b));//printf("%d ", pa(a, b)); 可以不解引用 指针就代表函数
//	return 0;
//}
//六、函数指针数组
//存放函数指针的数组 (存放函数地址的数组) int (*pa[6])(int,int) 
//int add(int x, int y)
//{
//	return x + y;
//}
//int sub(int x, int y)
//{
//	return x - y;
//}
//int mul(int x, int y)
//{
//	return x * y;
//}
//int div(int x, int y)
//{
//	return x / y;
//}
//int main()
//{
//	int(*parr[4])(int, int) = {add,sub,mul,div};//定义一个函数指针数组  数组元素类型为int(*)(int,int)型的函数指针(地址)
//	int i;    //这里parr数组名代表首元素地址 即函数地址的地址
//	for (i = 0; i < 4; i++)
//	{
//		printf("%d ", parr[i](5, 7));//由下标找到数组中的每个函数的地址 即函数 再进行调用
//	}
//	return 0;
//}
//练习
//写一个函数指针指向char* my_strcpy(char* dest, const char* src)   char*  *parr(char*, cosnt char* )
//写一个函数指针数组，指针指向四个my_strcpy函数     char* (*arr[4])(char*,const char*)={pf,pf,pf,pf}
//int main()
//{
//	char* (*pf)(char*, const char*);//函数指针
//	char* (*pfarr[4])(char*, const char*) = { pf,pf,pf,pf };
//	return 0;
//}

//char* (*p)(char*,const char*) = my_strcpy;
//char* (*p[4])(char*,const char*) = {pf1,pf2,pf3,pf4};