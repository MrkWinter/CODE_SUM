#define _CRT_SECURE_NO_WARNINGS 1
#include<iostream>
using namespace std;
//1c++基础入门
//1.1 c++书写hello world
//int main()
//{
//	cout << "hello\n" << endl;
//	system("pause");
//	return 0;
//}
//1.2 注释

//  单行// 多行 /* */


//1.3 变量

//int main()
//{
//	//变量创建 数据类型 变量名 = 变量的初始值
//	int a = 10;
//	cout << "a = " << a << endl; //c++ cout 输出数据无格式化
//	return 0;
//}


//1.4 常量
//#define 宏常量
//const 修饰的常变量
//常量不可修改

//#define Day 7
//int main()
//{
//	cout << "一周一共有" << Day << "天\n" << endl;
//	const int month = 12;
//	cout << "一年一共有" << month << "个月\n" << endl;
//	system("pause");
//	return 0;
//}


//1.5 关键字
//关键字不能用标识符

//int main()
//{
//	system("pause");
//	return 0;
//}


//1.6 标识符命名规则

//标识符不能是关键字
//标识符由字母数字下划线组成
//标识符开头不能是数字
//标识符区分大小写


//2数据类型
//2.1 整型

//int main()
//{
//	short a = 10; //2byte
//	int b = 11;  //4byte
//	long c = 12; //4/8byte
//	long long d = 13; //8byte
//	cout << a << endl;
//	cout << b << endl;//c++ cout 输出内容到屏幕自动换行
//	cout << c << endl;
//	cout << d << endl;
//	system("pause");
//	return 0;
//}


//2.2 sizeof关键字

//int main()
//{
//	int a = sizeof(int);
//	cout << a << endl;
//	cout << sizeof(a) << endl;
//	return 0;
//}


//2.3 实型(浮点型)
//float 7位 4byte
//double 15~16位 8byte

//int main()
//{
//	float a = 3.14f;//计算机默认认为小数为double型
//	cout << a << endl; //c语言按格式化打印%f 不指定保留小数时保留所有0  c++不保留
//	float b = 3e3;  //科学计数法 c语言好像是E
//  system("pause");
//	return 0;
//}


//2.4 字符型
//char 1byte

//int main()
//{
//	char a = 'a'; //ASCII码
//	cout << a << endl;
//	cout << (int)a << endl;//小写字母ASCII码大于大写字母
//	cout << (int)'A' << endl;
//	system("pause");
//	return 0;
//}


//2.5 转义字符
//水平制表符 \t 占8个位置 对齐使用
//反斜杠\输出一个特殊符号 （防转义）


//2.6 字符串类型型
//字符串类型 string 

#include<string>
//int main()
//{
//	string arr = "hello world";//创建一个字符串类型的变量arr
//	cout << arr << endl;
//	system("pause");
//	return 0;
//}


//2.7 布尔类型
//bool 1byte
//值只有true 1 或 false 0 

//int main()
//{
//	bool a = true;//1
//	cout << a << endl;
//	a = false;//0
//	cout << a << endl;
//	system("pause");
//	return 0;
//}

//2.8 数据的输入
//cin

//int main()
//{
//	int a = 0;
//	cout << "请输入值" << endl;
//	cin >> a;//录入整型a的值 c++输入数据无格式化
//	cout << a << endl;
//	string str = "abcd"; //c++ 字符串类型的变量的大小？
//	cin >> str; //录入字符串
//	cout << sizeof(str) << endl;
//	cout << str << endl;
//	bool flag = true;//布尔类型值只有真1假0 非0为真
//	cin >> flag;
//	cout << flag << endl;
//	system("pause");
//	return 0;
//}