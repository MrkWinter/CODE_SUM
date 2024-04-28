#include<iostream>
using namespace std;

int main()
{
	//1、单精度
	//2、双精度
	//3、默认情况下 输出一个小数 最多显示6位有效数字
	float f1 = 3.14f;
	
	cout << "f1=" << f1 << endl;

	double d1 = 3.14;

	cout << "d1=" << d1 << endl;

	//统计float与double占用的内存空间

	cout << "float占用的内存空间为：" << sizeof(float) << endl;//（4字节）
	
	cout << "double占用的内存空间为:" << sizeof(double) << endl;//(8字节)

	//科学计数法

	float f2 = 3e2;

	cout << "f2=" << f2 << endl;

	float f3 = 3e-2;

	cout << "f3=" << f3 << endl;

	system("pause");

	return 0;

}