#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
//练习
//写一个函数指针指向char* my_strcpy(char* dest, const char* src)
//写一个函数指针数组，指针指向四个my_strcpy函数
//int main()
//{
//	char* (*pf)(char*, const char*);//函数指针
//	char* (*pfarr[4])(char*, const char*) = { pf,pf,pf,pf };
//	return 0;
//}
//函数指针数组的使用
//       转移表
//计算器
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
//void menu()
//{
//	printf("**********************\n");
//	printf("*** 1.add   2.sub  ***\n");
//	printf("*** 3.mul   4.div  ***\n");
//	printf("****    0.exit    ****\n");
//	printf("**********************\n");
//}
//int main()
//{	int input;
//    int(*parr[])(int, int) = { 0,add,sub,mul,div };//定义函数指针数组代替Switch case语句
//	do
//	{
//		int x,y;
//		menu();
//		printf("请输入选项：");
//		scanf("%d", &input);
//		if (input >= 1 && input <= 4)
//		{
//			printf("请输入两个操作数：");
//			scanf("%d%d", &x, &y);
//			printf("%d\n", parr[input](x, y));//找到对应的函数进行调用 这里函数指针数组也称为转移表
//
//		}
//		else if (input == 0)
//			printf("退出");
//		else
//			printf("输入错误");
//	} while(input);
//	return 0;
//}
//七、指向函数指针数组的指针
//int add(int x, int y)
//{
//	return x + y;
//}
//int main()
//{
//	int(*p)(int, int) = add;//函数指针
//	int(*parr[])(int, int) = { p };//函数指针数组
//	int(*(*pp)[])(int, int) = &parr;//指向函数指针数组的指针
//	return 0;
//}
//八、回调函数
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
//void menu()
//{
//	printf("**********************\n");
//	printf("*** 1.add   2.sub  ***\n");
//	printf("*** 3.mul   4.div  ***\n");
//	printf("****    0.exit    ****\n");
//	printf("**********************\n");
//}
//void cacl(int(*p)(int, int)) //通过函数指针传参实现函数的多种用处 函数内部调用实参函数 回调函数
//{
//	int x, y;
//	printf("请输入两个数：");
//	scanf("%d%d", &x, &y);
//	printf("%d\n", p(x, y));
//}
//int main()
//{
//	int input;
//	do
//	{
//		menu();
//		printf("请输入选项：");
//		scanf("%d", &input);
//		switch (input)
//		{
//		case 1:
//			cacl(add);
//			break;
//		case 2:
//			cacl(sub);
//			break;
//		case 3:
//			cacl(mul);
//			break;
//		case 4:
//			cacl(div);
//			break;
//		case 0:
//			printf("退出");
//			break;
//		default:
//			printf("错误");
//			break;
//		}
//	} while (input);
//	return 0;
//}
//例 ！万能的数组排序比较函数 qsort函数
//void 指针类型
//int main()
//{
//	int a=1;
//	char b = 'q';
//	int *p = &a; //整形指针
//	char  *pb = &b;//字符指针
//	void *pc = &a;
//	void *pd = &b; //空类型指针 可以接收任何地址
//	//*pc=1;error! 空类型指针不能解引用 因为没有指针类型 
//	//*pd+1;error! 空类型指针不能相加减
//	return 0;
//}
//qsort 函数的传参类型 qsort函数的定义
//void qsort(void* base, size_t numb, size_t width, int (*cmp)(const void* e1,const void* e2))
//{//    目标数组起始地址  数组元素个数   元素大小      自己定义的一个比较元素的函数    
//	//~
//}
//例
int cmp1(const void* e1, const void* e2)
{
	return *(int*)e1 - *(int*)e2;
	//自定义的函数要求为 第一元素大于第二元素 返回大于0的数字 相等返回0 小于返回小于0的数字
	//然后实现从小到大排序(升序)，相反可以实现降序
}
void test1()
{
	int i;
	int arr1[] = { 9,8,7,6,5,4,3,2,1 };
	int sz = sizeof(arr1) / sizeof(arr1[0]);
	qsort(arr1, sz, sizeof(arr1[0]), cmp1);
	for (i = 0; i < sz; i++)
	{
		printf("%d ", arr1[i]);
	}
	putchar('\n');
}
int cmp2(const void* e1, const void* e2)
{
	return (int)(*(float*)e1 - *(float*)e2);
}
void test2()
{
	int i;
	float arr2[] = { 9.0,8.0,7.0,6.0,5.0,4.0,3.0 };
	int sz = sizeof(arr2) / sizeof(arr2[0]);
	qsort(arr2, sz, sizeof(arr2[0]), cmp2);
	for (i = 0; i < sz; i++)
	{
		printf("%f ", arr2[i]);
    }
	putchar('\n');
}
struct stu//结构体使用时声明
	{
		char name[20];
		int age;
	};
int cmp3(const void* e1, const void* e2)
{
	return	((struct stu*)e1)->age - ((struct stu*)e2)->age;
}
void test3()
{
	int i;
	struct stu s1[3] = { {"zhangsan",28},{"lisi",23},{"wangwu",34} };//结构体数组
	int sz = sizeof(s1) / sizeof(s1[0]);
	qsort(s1, sz, sizeof(s1[0]), cmp3);//sizeof(s1) 求首元素大小
	for (i = 0; i < 3; i++)
	{
		printf("%d ", s1[i].age);
	}
	printf("\n");
}
int cmp4(const void* e1, const void* e2)
{
	return strcmp(((struct stu*)e1)->name, ((struct stu*)e2)->name);//字符串比较函数 第一个大于第二个返回大于0的数字
}                                      //第一个等于第二个返回0 第一个小于第二个 返回小于0的数字
void test4()
{
	int i;
	struct stu s1[3] = { {"zhangsan",28},{"lisi",23},{"wangwu",34} };//结构体数组
	int sz = sizeof(s1) / sizeof(s1[0]);
	qsort(s1, sz, sizeof(s1[0]), cmp4);
	for (i = 0; i < 3; i++)
	{
		printf("%s ", s1[i].name);
	}
	printf("\n");
}
int main()
{
	test1();//使用qsort函数排序整形数组
	test2();//排序浮点型数组
	test3();//排序结构体数组按年龄
	test4();//排序结构体数组按名字
	return 0;
}
//总结： qsort 函数是一个实现任意数组排序的函数
//调用函数时使用的实参依次为 (数组起始地址，数组元素个数，数组单个元素的大小，自定义比较函数)
//自定义比较函数必须是函数参数为两个void类型的指针 返回类型为int型
//函数内部通过传入的指针找到元素进行比较 返回值为以下规定时按数组传递的元素数数组内容升序排列
//1.第一元素大于第二元素 返回值大于0
//2.第一元素等于第二元素 返回值等于0
//3.第一元素小于第二元素 返回值小于0
//第一第三条条件相同 结果相反时按降序排列
