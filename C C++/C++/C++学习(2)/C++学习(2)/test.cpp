#define _CRT_SECURE_NO_WARNINGS 1
#include<iostream>
#include<string>
#include<Ctime>
using namespace std;
////3.�����
////��������� ��ֵ����� �Ƚ������ �߼������

//int main()
//{
//	float a = 6;
//	float b = 3; //c++��Ӧ���Ǹ���Ҫ����ı��������Զ������Ӧ��ʽ 
//	cout << a / b << endl;//����c++�ó����ʡȥС������0
//	//% �� / ����� �������������0   % �Ĳ�����������С��
//  system("pause");
//	return 0;
//}

//4.�������̽ṹ
//˳��ṹ   ѡ��ṹif switch (��Ŀ�����)  ѭ���ṹwhile for do
//int main()
//{
//	int score = 0;//c++�ж������Ҫ����ʼֵ ������ܲ�����
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
//		cout << "������һ������" << endl;
//		cin >> input;
//		if (input > num)
//			cout << "�´���" << endl;
//		else if (input < num)
//			cout << "��С��" << endl;
//		else
//		{
//			cout << "�¶���" << endl;
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
//			cout << "������" << i << endl;
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
//			cout << "* ";//endl�ǻ��е���˼ ���������� 
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
//			cout << j << "*" << i << "=" << j * i<<"\t" ;//c++��ο���������ݶ��룿\t��������߶��� ��8Ϊ��λ��ʾ���� ���ݹ�����8�ı���Ϊ��λ��ʾ���� 
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
//c++ ����ͷ�ļ����� ������������  �ַ��������� cout ��� cin ���� �޸�ʽ����  forѭ���пɶ�������

//5.����

//����Ԫ�ص�����
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
//	cout << sizeof(arr) / sizeof(arr[0])<<"\n";//����
//	cout << sizeof(arr[0]) / sizeof(arr[0][0]);//����
//
//}
//6.����
//�����ķ��ļ���д
//7.ָ��
//��ָ�� 0-255���ڴ�����ϵͳʹ�õģ���˲����Է��� ��ָ����Ϊ0
//int main()
//{
//	int * p = (int*)0x11000;//Ұָ�� ϵͳ�Ŀռ� �Ƿ��Ŀռ�
//}
// const ���ε�ָ�� �ұ�ָ����ֵ
//�ṹ������
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
////�ṹ���ֵ���ݺ͵�ַ����
//void printt(const student *s1)
//{
//	//s1->name = "jjj"; ��ֹ�޸�
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
//	print(s1);//ֵ����
//	cout << s1.name << endl;
//	printt(&s1);//��ַ����
//	cout << s1.name << endl;
//}
//�ṹ�尸��
//��ʦ��ѧ��
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
//		T_arr[i].T_name += name_t[i];//c++���ַ������Խ���+ ���Ӧ��Ϊ׷�� strcat
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
//		cout<<"��ʦ����" << T_arr[i].T_name << endl;
//		for (int j = 0; j < 5; j++)
//		{
//			cout <<"\tѧ������"<< T_arr[i].S_arr[j].name<<endl;
//			cout <<"\tѧ������"<< T_arr[i].S_arr[j].age<<endl;
//		}
//	}
//}
//int main()
//{
//	srand((unsigned int)time(NULL));
//	teacher T_arr[3];//�ṹ�������д洢��Ϊ�ṹ��Ԫ�� T_arr������Ԫ�ص�ַ �����õõ���һ��Ԫ�� Ҳ���ǵ�һ���ṹ�������
//	int len = sizeof(T_arr) / sizeof(T_arr[0]);
//	Inital(T_arr, len);
//	printinfo(T_arr, len);
//	return 0;
//}

