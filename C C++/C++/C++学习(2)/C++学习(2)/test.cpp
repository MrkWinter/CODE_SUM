#define _CRT_SECURE_NO_WARNINGS 1
#include<iostream>
#include<string>
#include<Ctime>
using namespace std;
////3.运算符
////算数运算符 赋值运算符 比较运算符 逻辑运算符

//int main()
//{
//	float a = 6;
//	float b = 3; //c++中应该是根据要输出的变量类型自动输出对应格式 
//	cout << a / b << endl;//并且c++得出结果省去小数点后的0
//	//% 和 / 运算符 后操作数不能是0   % 的操作数不能是小数
//  system("pause");
//	return 0;
//}

//4.程序流程结构
//顺序结构   选择结构if switch (三目运算符)  循环结构while for do
//int main()
//{
//	int score = 0;//c++中定义变量要赋初始值 否则可能不能用
//	cin >> score;
//	if (score > 600)
//	{
//		cout << "yes" << endl;
//	}
//
//	int a = 0;
//	int b = 0;
//	int c = 0;
//	cin >> a;
//	cin >> b;
//	cin >> c;
//	if (a > b)
//	{
//		if (a > c)
//			cout << a << endl;
//		else
//			cout << c << endl;
//	}
//	else
//	{
//		if (b > c)
//			cout << b << endl;
//		else
//			cout << c << endl;
//	}
//	system("pause");
//	return 0;
//}
#include<time.h>
#include<stdlib.h>
//int main()
//{
//	srand((unsigned int)time(NULL));
//	int num = rand() % 100;
//	
//	int input = 0;
//	
//	while (1)
//	{
//		cout << "请输入一个数字" << endl;
//		cin >> input;
//		if (input > num)
//			cout << "猜大了" << endl;
//		else if (input < num)
//			cout << "猜小了" << endl;
//		else
//		{
//			cout << "猜对了" << endl;
//			break;
//		}
//	}
//	return 0;
//}
#include<math.h>
//int main()
//{
//	int n = 100;
//	do
//	{
//		if (n == pow(n % 10, 3) + pow(n / 10 % 10, 3) + pow(n / 100 % 10, 3))
//			cout << n << endl;
//		n++;
//	} while (n < 1000);
//	return 0;
//}
//int main()
//{
//	for (int i = 1; i <= 100; i++)
//	{
//		if (i % 7 == 0 || i % 10 == 7 || i / 10 == 7)
//			cout << "敲桌子" << i << endl;
//		else
//			cout << i << endl;
//	}
//	return 0;
//}
//int main()
//{
//	for (int i = 0; i < 10; i++)
//	{
//		for (int j = 0; j < 10; j++)
//		{
//			cout << "* ";//endl是换行的意思 ！！！！！ 
//		}
//		cout << endl;
//	}
//	return 0;
//}
//int main()
//{
//	for (int i = 1; i <= 9; i++)
//	{
//		for (int j = 1; j <= i; j++)
//		{
//			cout << j << "*" << i << "=" << j * i<<"\t" ;//c++如何控制输出数据对齐？\t好像是左边对齐 以8为单位显示对齐 数据过多以8的倍数为单位显示对齐 
//		}
//		cout << endl;
//	}
//	return 0;
//}

//int main()
//{
//	int select = 0;
//	cin >> select;
//	switch (select)
//	{
//	case 1:
//		cout << "a" << endl;
//		break;
//	case 2:
//		cout << "b" << endl;
//		break;
//	case 3:
//		cout << "c" << endl;
//		break;
//	}
//}
//c++ 引的头文件声明 布尔数据类型  字符数据类型 cout 输出 cin 输入 无格式限制  for循环中可定义数据

//5.数组

//数组元素的逆置
//void reveas(int* arr, int sz)
//{
//	for (int i = 0; i < sz; sz--, i++)
//	{
//		arr[i] = arr[i] ^ arr[sz];
//		arr[sz] = arr[i] ^ arr[sz];
//		arr[i] = arr[i] ^ arr[sz];
//	}
//}
//int main()
//{
//	int i;
//	int arr[5] = { 1,3,5,7,8};
//	int sz = sizeof(arr) / sizeof(arr[1])-1;
//	reveas(arr, sz);
//	for (i = 0; i <= sz; i++)
//	{
//		cout << arr[i] << endl;
//    }
//}
//
//int main()
//{
//	int arr[3][4] = { 0 };
//	cout << sizeof(arr) / sizeof(arr[0])<<"\n";//行数
//	cout << sizeof(arr[0]) / sizeof(arr[0][0]);//列数
//
//}
//6.函数
//函数的分文件编写
//7.指针
//空指针 0-255号内存编号是系统使用的，因此不可以访问 空指针编号为0
//int main()
//{
//	int * p = (int*)0x11000;//野指针 系统的空间 非法的空间
//}
// const 修饰的指针 右保指针左保值
//结构体数组
//typedef struct student
//{
//	string name;
//	int age;
//	int score;
//}student;
////int main()
////{
////	student s1[3] = { { "zhang",18,100 },{"lisi",20,120},{"daso",34,290} };
////	for (int i = 0; i < 3; i++)
////	{
////		cout << s1[i].name  << s1[i].age << s1[i].score << endl;
////		cout << s1->name  << s1->age << s1->score << endl;
////	}
////}
////结构体的值传递和地址传递
//void printt(const student *s1)
//{
//	//s1->name = "jjj"; 防止修改
//	cout << s1->name << endl;
//}
//void print(student s1)
//{
//	s1.name = "hiiiiiiii";
//	cout<< s1.name << endl;
//
//}
//int main()
//{
//	student s1 = { "zhang",18,100 };
//
//	print(s1);//值传递
//	cout << s1.name << endl;
//	printt(&s1);//地址传递
//	cout << s1.name << endl;
//}
//结构体案例
//老师带学生
//typedef struct student
//{
//	int age;
//	string name;
//}student;
//typedef struct teacher
//{
//	string T_name;
//	student S_arr[5];
//}teacher;
//void Inital(teacher* T_arr, int n)
//{
//	string name_t = "ABCDE";
//	for (int i = 0; i < n; i++)
//	{
//		T_arr[i].T_name  = "Teacher_";
//		T_arr[i].T_name += name_t[i];//c++中字符串可以进行+ 相对应的为追加 strcat
//
//		for (int j = 0; j < 5; j++)
//		{
//			T_arr[i].S_arr[j].age = rand()%10+ 10;
//			T_arr[i].S_arr[j].name = "student_";
//			T_arr[i].S_arr[j].name += name_t[j];
//		}
//	}
//}
//void printinfo(teacher* T_arr, int n)
//{
//	for (int i = 0; i < n; i++)
//	{
//		cout<<"老师姓名" << T_arr[i].T_name << endl;
//		for (int j = 0; j < 5; j++)
//		{
//			cout <<"\t学生姓名"<< T_arr[i].S_arr[j].name<<endl;
//			cout <<"\t学生年龄"<< T_arr[i].S_arr[j].age<<endl;
//		}
//	}
//}
//int main()
//{
//	srand((unsigned int)time(NULL));
//	teacher T_arr[3];//结构体数组中存储的为结构体元素 T_arr代表首元素地址 解引用得到第一个元素 也就是第一个结构体变量名
//	int len = sizeof(T_arr) / sizeof(T_arr[0]);
//	Inital(T_arr, len);
//	printinfo(T_arr, len);
//	return 0;
//}

