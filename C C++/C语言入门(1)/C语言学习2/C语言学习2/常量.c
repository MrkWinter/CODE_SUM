#define _CRT_SECURE_NO_WARNINGS 1
//#include<stdio.h>

//int main()

//{//��ϰ����ӷ�
	/*int numb1, numb2,sum;

	scanf("%d%d", &numb1, &numb2);

	sum = numb1 + numb2;

	printf("sum = %d\n", sum);*/

	//1���泣��

	//3;
//	4;//ֱ��д����ֵ�����泣��

	//2const���εĳ�����
	//const int numb1 = 6;

	//numb1 = 8;�����޸�
	//printf("%d", numb1);

	//const���г�����,const�ǳ��������������Ǳ��������ܵ�����������
	//const int n = 10;

	//int arr[n] = {0};//n����ʹ��

	//return 0;
//}
#include<stdio.h>
//3#define ����ı�ʶ������
#define MAX 10

enum Sex
{
	MALE,
    FEMALE,//����Ϊö�ٳ���
	SECRET

};


int main()

{
	//printf("%d\n", MAX);

//4ö�ٳ���

	enum Sex mike = MALE;

	printf("%d%\n", MALE);
	printf("%d%\n", FEMALE);
	printf("%d%\n", SECRET);
	return 0;
}





