#define _CRT_SECURE_NO_WARNINGS 1
//#include<stdio.h>
//int main()
//{
//	int numb1, numb2, max;
//	numb1 = 3;
//	numb2 = 4;
//	max = MAX(numb1, numb2);//()�������ò�����
//	printf("%d\n", max);
//
//	return 0;
//}
//int MAX(int x, int y)
//{
//	int z;
//	if (x > y)
//		z = x;
//	else
//		z = y;
//	return z;
#include<stdio.h>

//int main()
//{
//	int a = 19;
//	int arr[] = { 1,2,3,4,5,6 };
//	printf("%d\n", sizeof(int));
//	printf("%d\n", sizeof(arr));
//	printf("%d\n", sizeof(arr) / sizeof(arr[0]));
//	return 0;
//}


//#include<stdio.h>
//int main()
//{
//	int a = 0;//4���ֽڣ�32��bitλ
//	//a 000000000000000000000000   
//	int b = ~a;//��(������ȡ��)λȡ��
//	//b 111111111111111111111111
////ԭ�룬���룬����
//	//111111111111111111111111����
//	//111111111111111111111110����
//	//100000000000000000000001ԭ�� 
//
//	//�����ڶ����ƴ����ʱ�򴢴���Ƕ����Ʋ��� �����ԭ��
//
//	printf("%d\n", b);
//
//
//	return 0;
//}
//#include<stdio.h>
//int main()
//{ int r = (int)3.14  int ����ǿ������ת��  ԭ����double�����ȸ�����
//	int a = 10;
//	int b = a++;//��ʹ�ã���++
//	int c = ++a;//��++����ʹ��
//	printf("%d\n%d\n%d\n", a, b, c);
//	return 0;
//}
//#include<stdio.h>
//int main()
//{
//	//!=�����
//	//&&�߼��� ����
//	//||�߼��� ��
//
//	int a = 0;
//	int b = 3;
//	int c = a && b;//��ʾ��
//	int v = a || b;
//	printf("%d\n", c);
//	printf("%d\n", v);
//	return 0;
//}
#include<stdio.h>
int main()
{
	int arr[10] = { 0 };//[]�±����ò�����
	int a, b, max;
	scanf("%d%d",&a,&b);
	max = (a > b ? a : b);//��Ŀ������/����������
	printf("%d\n", max);


	return 0;
}
















