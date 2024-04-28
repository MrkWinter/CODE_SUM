#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//1.特殊的结构体声明
//匿名结构体类型
//struct
//{
//	char a;
//	int b;
//}s1;//结构体变量
//
//struct
//{
//	char a;
//	int b;
//}*p;//结构体指针
//int main()
//{
//	//*p = &s1;//不合法 *p为全局变量
//	return 0;
//}
//结构体的自引用
//struct node
//{
//	int date;
//	struct node* n;
//};
//int main()
//{   struct node s3 = { 3,NULL };	
//    struct node s2 = { 2,&s3 };
//	struct node s1 = { 1,&s2 };
//	printf("%d", s1.n->n->date);//链式
//	return 0;
//}
/*typedef struct stu
{
	char name;
	int age;
}stu;*/ //结构体类型重新定义成stu
//结构体内存对齐
//struct s1
//{
//	char a;
//	char b;
//	int c;
//};
//struct s2
//{
//	char a;
//	int c;
//	char b;
//};
//int main()
//{
//	struct s1 q1 = { 0 };
//	struct s2 q2 = { 0 };
//	printf("%d ", sizeof(q1));//8
//	printf("%d", sizeof(q2));//12
//	return 0;
//}
//结构体内存存储规则
//1第一个成员在结构体变量偏移量为0的地址处
//2其他成员变量要对齐到某个数字（对齐数）的整数倍偏移量的地址处
//vs 默认对齐数为8
//对齐数 == 编译器默认对齐数与元素大小(单位是字节)的最小值 结构体变量偏移量为该结构体成员变量中最大对齐数的倍数
//3结构体的总大小为每个成员变量中最大对齐数的整数倍 
//内存对齐是为了更快的读取内存中的数据 定义结构体时应尽量把小内存的变量放到一块
//修改默认对齐数
//#pragma pack(4)//设置默认对齐数
//struct stu
//{
//	char a;//1
//	double b;//4
//};
//#pragma pack()//取消默认对齐数
//int main()
//{
//	struct stu s1;
//	printf("%d ", sizeof(s1));
//}
//查看成员偏移量 offsetof 宏 返回结构体变量的偏移量(对于起始处的位置)
//#define my_offsetof(struct_stu,e) (int)(&(((struct_stu*)0)->e))//offsetof实现
//#include<stddef.h>
//struct stu
//{
//	char a;//1
//	double b;
//	double c;//4
//};
//int main()
//{
//	printf("%d ", my_offsetof(struct stu, a));
//	printf("%d ", offsetof(struct stu, b));
//	printf("%d ", offsetof(struct stu, c));
//}
//结构体的传参
//struct stu
//{
//	char* name;
//	int age;
//};
//void Inst(struct stu* p1)//传址
//{
//	p1->age = 18;
//	//p1->name = 'a';
//	p1->name = "sdf";//字符串指针类型
//}
//void print1(struct stu s1)//传值
//{
//	printf("%s %d ", s1.name, s1.age);
//}
//int main()
//{
//	struct stu s1;
//	Inst(&s1);
//	print1(s1);
//	return 0;
//}
////传址权限更大 建议结构体传参时用指针 内存占用小 不会容易出现压栈的现象