#define _CRT_SECURE_NO_WARNINGS 1
#include<iostream>
using namespace std;
//1c++��������
//1.1 c++��дhello world
//int main()
//{
//	cout << "hello\n" << endl;
//	system("pause");
//	return 0;
//}
//1.2 ע��

//  ����// ���� /* */


//1.3 ����

//int main()
//{
//	//�������� �������� ������ = �����ĳ�ʼֵ
//	int a = 10;
//	cout << "a = " << a << endl; //c++ cout ��������޸�ʽ��
//	return 0;
//}


//1.4 ����
//#define �곣��
//const ���εĳ�����
//���������޸�

//#define Day 7
//int main()
//{
//	cout << "һ��һ����" << Day << "��\n" << endl;
//	const int month = 12;
//	cout << "һ��һ����" << month << "����\n" << endl;
//	system("pause");
//	return 0;
//}


//1.5 �ؼ���
//�ؼ��ֲ����ñ�ʶ��

//int main()
//{
//	system("pause");
//	return 0;
//}


//1.6 ��ʶ����������

//��ʶ�������ǹؼ���
//��ʶ������ĸ�����»������
//��ʶ����ͷ����������
//��ʶ�����ִ�Сд


//2��������
//2.1 ����

//int main()
//{
//	short a = 10; //2byte
//	int b = 11;  //4byte
//	long c = 12; //4/8byte
//	long long d = 13; //8byte
//	cout << a << endl;
//	cout << b << endl;//c++ cout ������ݵ���Ļ�Զ�����
//	cout << c << endl;
//	cout << d << endl;
//	system("pause");
//	return 0;
//}


//2.2 sizeof�ؼ���

//int main()
//{
//	int a = sizeof(int);
//	cout << a << endl;
//	cout << sizeof(a) << endl;
//	return 0;
//}


//2.3 ʵ��(������)
//float 7λ 4byte
//double 15~16λ 8byte

//int main()
//{
//	float a = 3.14f;//�����Ĭ����ΪС��Ϊdouble��
//	cout << a << endl; //c���԰���ʽ����ӡ%f ��ָ������С��ʱ��������0  c++������
//	float b = 3e3;  //��ѧ������ c���Ժ�����E
//  system("pause");
//	return 0;
//}


//2.4 �ַ���
//char 1byte

//int main()
//{
//	char a = 'a'; //ASCII��
//	cout << a << endl;
//	cout << (int)a << endl;//Сд��ĸASCII����ڴ�д��ĸ
//	cout << (int)'A' << endl;
//	system("pause");
//	return 0;
//}


//2.5 ת���ַ�
//ˮƽ�Ʊ�� \t ռ8��λ�� ����ʹ��
//��б��\���һ��������� ����ת�壩


//2.6 �ַ���������
//�ַ������� string 

#include<string>
//int main()
//{
//	string arr = "hello world";//����һ���ַ������͵ı���arr
//	cout << arr << endl;
//	system("pause");
//	return 0;
//}


//2.7 ��������
//bool 1byte
//ֵֻ��true 1 �� false 0 

//int main()
//{
//	bool a = true;//1
//	cout << a << endl;
//	a = false;//0
//	cout << a << endl;
//	system("pause");
//	return 0;
//}

//2.8 ���ݵ�����
//cin

//int main()
//{
//	int a = 0;
//	cout << "������ֵ" << endl;
//	cin >> a;//¼������a��ֵ c++���������޸�ʽ��
//	cout << a << endl;
//	string str = "abcd"; //c++ �ַ������͵ı����Ĵ�С��
//	cin >> str; //¼���ַ���
//	cout << sizeof(str) << endl;
//	cout << str << endl;
//	bool flag = true;//��������ֵֻ����1��0 ��0Ϊ��
//	cin >> flag;
//	cout << flag << endl;
//	system("pause");
//	return 0;
//}