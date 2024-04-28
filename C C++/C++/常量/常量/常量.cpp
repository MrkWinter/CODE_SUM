#include<iostream>

using namespace std;

//常量的定义方式
//1#define 宏常量
//2const 修饰的变量

//1 define修饰的宏常量

#define day 7
int main()
{
	//day = 14;//day是一个常量 一旦修改就会报错

	cout << "一周一共有" << day << "天" << endl;

	//const修饰的变量
	const int mouth = 12;
	//mouth = 24;//错误const修饰的变量也称为常量

	cout << "一年一共有" << mouth << "个月份" << endl;
	
	system("pause");

	return 0;

}

