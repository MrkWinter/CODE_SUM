#include<iostream>
using namespace std;

int main()
{   //����:short(2)  int(4)  long(4)  long long(8)
	//��������sizeof�����������ռ���ڴ��С
	//�﷨��sizeof����������/������
	short numb1 = 10;
	int numb2 = 10;
	long numb3 = 10;
	long long numb4 = 10;

	cout << "shortռ�õ��ڴ�Ϊ:" << sizeof(short) << endl;
	cout << "intռ�õ��ڴ�Ϊ:" << sizeof(int) << endl;
	cout << "longռ�õ��ڴ�Ϊ:" << sizeof(long) << endl;
	cout << "long longռ�õ��ڴ�Ϊ:" << sizeof(long long) << endl;


	//���ʹ�С�Ƚ�
	//short<int<=long<=long long


	system("pause");

	return 0;

}