#include<iostream>
using namespace std;

int main()
{
	//1��������
	//2��˫����
	//3��Ĭ������� ���һ��С�� �����ʾ6λ��Ч����
	float f1 = 3.14f;
	
	cout << "f1=" << f1 << endl;

	double d1 = 3.14;

	cout << "d1=" << d1 << endl;

	//ͳ��float��doubleռ�õ��ڴ�ռ�

	cout << "floatռ�õ��ڴ�ռ�Ϊ��" << sizeof(float) << endl;//��4�ֽڣ�
	
	cout << "doubleռ�õ��ڴ�ռ�Ϊ:" << sizeof(double) << endl;//(8�ֽ�)

	//��ѧ������

	float f2 = 3e2;

	cout << "f2=" << f2 << endl;

	float f3 = 3e-2;

	cout << "f3=" << f3 << endl;

	system("pause");

	return 0;

}