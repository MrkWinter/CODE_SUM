#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
int main()
{
	//int a = 34;
	//int* p = &a;
	//*p = 45;//�����ò�����/��ӷ��ʲ�������������*
	//printf("%p\n",p);
	//printf("%d\n",a);

	double b = 3.14;
	double* hi = &b;
	*hi = 5.43;
	printf("%lf\n", b);
	printf("%lf\n", *hi);//double���ʹ�ӡ��lf

	return 0;
}