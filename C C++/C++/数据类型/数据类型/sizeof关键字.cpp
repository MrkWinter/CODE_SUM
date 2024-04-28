#include<iostream>
using namespace std;

int main()
{   //整型:short(2)  int(4)  long(4)  long long(8)
	//可以利用sizeof求出数据类型占用内存大小
	//语法：sizeof（数据类型/变量）
	short numb1 = 10;
	int numb2 = 10;
	long numb3 = 10;
	long long numb4 = 10;

	cout << "short占用的内存为:" << sizeof(short) << endl;
	cout << "int占用的内存为:" << sizeof(int) << endl;
	cout << "long占用的内存为:" << sizeof(long) << endl;
	cout << "long long占用的内存为:" << sizeof(long long) << endl;


	//整型大小比较
	//short<int<=long<=long long


	system("pause");

	return 0;

}