#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<math.h>
//int main()
//{
//	int c = 1;
//	double i,sum=0.0,temp;
//	for (i = 1; 1.0 / i>pow(0.1,6); i += 2)
//	{
//		temp = (1.0 / i)*c;
//		sum += temp;
//		c = -c;
//	}
//	printf("%.10lf", 4*sum);
//	return 0;
//}
//int main()
//{
//	int input;
//	int i,a=1, b=1, c,temp;
//	scanf("%d", &input);
//	for (i = 1; i <= input; i++)
//	{
//		if (i <= 2)
//			printf("%d\n",a);
//		else
//		{
//			c = a + b;
//			printf("%d\n", c);
//			a = b;
//			b = c;
//		}
//	}
//
//	return 0;
//}
//int fib(int n)
//{
//	if (n <= 2)
//		return 1;
//	else
//		return fib(n - 2) + fib(n - 1);
//}
//int main()
//{
//	int a;
//	scanf("%d", &a);
//	printf("%d",fib(a));
//	return 0;
//}
//int main()
//{
//	int i, n;
//	int arr[3][3] = { {1,2,3},{4,5,6},{7,8,9} };
//	for (i = 0; i < 3; i++)
//	{
//		for (n = 0; n < 3; n++)
//		{
//
//			printf("%d", arr[i][n]);
//		}
//
//		putchar('\n');
//	}
//
//	return 0;
//}
//
//int main()
//{
//	int input,i;
//	scanf("%d", &input);
//	for (i = 2; i <= sqrt(input); i++)
//	{
//		if (input%i == 0)
//			break;
//	}
//	if (i >sqrt(input))
//		printf("%d������", input);
//	else
//		printf("%d��������", input);
//	return 0;
//}
//int main()
//{
//	int i,n;
//	for (i = 100; i <= 300; i++)
//	{
//		for (n = 2; n <= sqrt(i); n++)
//		{
//			if (i%n == 0)
//				break;
//		}
//		if (n > sqrt(i))
//			printf("%d ", i);
//	}
//	return 0;
//}
//int main()
//{
//	int i;
//	int arr[] = { 1,2,3,4,5,6,7,8,9,10 };
//	for (i = 9; i >= 0; i--)
//	{
//		printf("%d ", arr[i]);
//	}
//	return 0;
//}
//���õ���������������������ֵ
//int main()
//{
//	int a = 4;
//	int b = 6;
//	a = a + b;
//	b = a - b;
//	a = a - b;
//	printf("a=%d b=%d", a, b);
//	return 0;
//}
//int main()
//{
//	int a = 2;
//	int b = 4;//��λ�����������Ƚ���
//	a = a ^ b;//ͬʱ���һ�������������ȥ�����ķ�Ϊ��������������֧�ֽ����
//	b = a ^ b;
//	a = a ^ b;
//	printf("a=%d b=%d", a, b);
//	return 0;
//}
int main()
{
	int a = 3;
	int b = 5;//��λ�����������Ƚ���
	a = a ^ (b^b);//ͬʱ���һ�������������ȥ�����ķ�Ϊ������������֧�ֽ����
	printf("a=%d b=%d", a, b);
	return 0;
}