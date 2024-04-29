#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//int main()
//{
//	int a, b, c,temp;
//	scanf("%d %d %d", &a, &b, &c);
//	if (a < b)
//	{
//		temp = a;
//		a = b;
//		b = temp;
//	}
//    if (a < c)
//	{
//		temp = a;
//		a = c;
//		c = temp;
//	}
//	if (b<c)
//	{
//		temp = c;
//		b = c;
//		c = temp;
//	}
//	printf("%d %d %d", a, b, c);
//	return 0;
//}
//int main()
//{
//	int a,b,c=1 ;
//	scanf("%d",&b);
//	for (a = 1; a <= b; a++)
//	{
//		c = c * a;
//	}
//	printf("%d", c);
//	return 0;
//}
//int main()
//{
//	int a;
//	char arr[] = "123";
//	int* p = arr;
//	a = strlen(arr);
//	scanf("%s", arr);
//	while (a > 0)
//	{
//		printf("%d", arr[p+a-1]);
//		a--;
//	}
//	return;
//}
//int back(char str,int a)
//{
//	while (a > 0)
//	{
//		printf("%d", *(str+a-1));
//	    a--;
//      }
//
//}
//
//int main()
//{
//	char arr[] = "123";
//	int a = strlen(arr);
//    scanf("%s", arr);
//	back(arr,a);
//	return 0;
//}

//int main()
//{
//	int a,b;
//	scanf("%d",&a);
//	while (a > 0)
//	{
//		b = a % 10;
//		printf("%d", b);
//		a = a / 10;
//	}
//	return 0;
//}
//int main()
//{
//	int a;
//	float b;
//	char c;
//	scanf("%d %f %c", &a, &b, &c);
//	return 0;
//}
//int jiecheng(int a)
//{
//	if (a != 0)
//		return a * jiecheng(a - 1);
//	else
//		return 1;
//}
//int main()
//{
//	int a;
//	printf("输入一个数，求阶乘:>");
//	scanf("%d", &a);
//	printf("%d的阶层为:%d",a, jiecheng(a));
//	return 0;
//}
#include<stdio.h>
#include<windows.h>
//int main(void)
//{
//	float x, y, a;
//	for (y = 1.5; y > -1.5; y -= 0.1)
//	{
//		for (x = -1.5; x < 1.5; x += 0.05)
//		{
//			a = x * x + y * y - 1;
//			putchar(a * a * a - x * x * y * y * y <= 0.0 ? '*' : ' ');
//		}
//		system("color 0c");
//		putchar('\n');
//	}
//	printf("May all lovers unite in marriage!");
//	printf("\n\n\n");
//	return 0;
//}
//int main()
//{
//	int a = 1;
//	for (a = 1; a <= 5; a++)
//	{
//		printf("********\n");
//	}
//
//	return 0;
//}
//int main()
//{
//	int a,b;
//	for (a = 1; a <= 9; a++)
//	{
//		for (b = 1; b <= a; b++)
//		{
//			printf("%d*%d=%-2d ", b, a, b*a);
//
//		}
//		printf("\n");
//	}
//	putchar('\n');
//	return 0;
//}
//int main()
//{
//	float a = 3.4;
//	printf("%d")
//	return 0;
//}
//int main()
//{
//	int a,b;
//	for (a = 1; a <= 5; a++)
//	{
//		for (b =1; b<=a; b++)
//		{
//			printf(" ");
//		}
//		printf("********\n");
//	}
//	putchar('\n');
//	return 0;
//}
//#include<math.h>
//void su(int a)
//{
//	int i;
//	for (i = 2; i <= sqrt(a); i++)
//	{
//		if(a%i == 0)
//		break;
//	}
//	if (i > sqrt(a))
//		printf("%d是素数", a);
//	else
//		printf("%d不是素数", a);
//
//}
//int main()
//{
//	int a;
//	scanf("%d", &a);
//	su(a);
//	return 0;
//}
//int main()
//{
//	int a,sum=0,count=0;
//	while (1)
//	{
//		printf("请输入捐款数:>");
//		scanf("%d", &a);
//		sum += a;
//		count++;
//		if (sum >= 100000)
//		break;
//	}
//	printf("总捐款金额为:%d\n", sum);
//	printf("捐款人数为:%d\n",count);
//	printf("平均每人捐款金额为:%\n", sum/count);
//	return 0;
//}
//int main()
//{
//	int i;
//	for (i = 100; i <= 200; i++)
//	{
//		if (i % 3 != 0)
//			printf("%d ", i);
//		else
//			continue;
//	}
//
//	return 0;
//}
//int main()
//{
//	int i,n;
//	for (i = 1; i <= 4; i++)
//	{
//		for (n = i; n <= 5 * i; n += i)
//		{
//			printf("%d\t", n);//
//
//		}
//		putchar('\n');
//	}
//
//	return 0;
//}
int main()
{
	int i, j, n = 0;
	for (i = 1; i <= 4; i++)
		for (j = 1; j <= 5; j++, n++)
		{
			if (n % 5 == 0) printf("\n");

			printf("%d\t", i*j);
		}
	printf("\n");
	return 0;
}