#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//struct结构体关键字 student结构体标签 struct student结构体类型
//struct student
//{//成员变量
//	char name[20];
//	short age;
//	char tele[12];
//	char sex[5];
//};//s1,s2,s3;//变量列表 全局结构体变量 不建议使用
//int main()
//{
//	struct student student1;
//	return 0;
//}
//typedef struct student
//{//成员变量
//	char name[20];
//	short age;
//	char tele[12];
//	char sex[5];
//}stu;//typedef 给struct student 重新定义stu为struct student结构体类型
//int main()
//{
//	struct student s2;//等价 定义结构体变量
//	stu s1 = { "张三",18,17338405790,"男生" };//结构体变量的初始化
//	return 0;
//struct s
//{
//	int a;
//	char c;
//	char arr[20];
//	double d;
// };
//struct l
//{
//	char ch[10];
//	struct s s1;//结构体类型可以套娃
//	char* p;
//};
//int main()
//{
//	char arr[] = "dadadada";
//	struct l l1 = { "hehe",{100,'c',"hello world",3.14},arr };// 结构体变量的初始化
//	printf("%s\n", l1.ch);//hehe
//	printf("%d\n", l1.s1.a);//100
//	printf("%s\n", l1.s1.arr);//hello world 
//	printf("%s\n", l1.p);//dadada 结构体成员的访问
//	return 0;
//}
//结构体传参,打印结构体变量成员
//typedef struct stu
//{
//	char name[10];
//	char tele[12];
//	short age;
//	char sex[5];
//
//}stu;
//void print1(stu s1) //独立开辟空间不建议使用
//{
//	printf("名字为%s\n", s1.name);
//	printf("电话为%s\n", s1.tele);
//	printf("年龄为%d\n", s1.age);
//	printf("性别为%s\n", s1.sex);
//}
//void print2(stu* s1) //操纵地址，建议使用
//{
//	printf("名字为%s\n", s1->name);
//	printf("电话为%s\n", s1->tele);
//	printf("年龄为%d\n", s1->age);//s1为结构体指针
//	printf("性别为%s\n", s1->sex);//->操作符访问结构体变量成员
//}
//int main()
//{
//	stu s1 = { "张三","17338405790",18,"男" };
//	print1(s1);//传实参
//	print2(&s1);//传地址
//	return 0;
//}
//补充：函数传参时会进行压栈操作
//内存分为 栈区，堆区，静态区
//数据结构 线性数据结构 顺序表，链表，栈，队列 
//树形数据结构 二叉树 
//图 ...
//
