#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
int main()
{
	static int sum = 0;
	int x = 1;
	int i = 1;
	int a, b, c;
	printf("1000000内能既是完全平方数，又是完全立方数的整数有:\n");
	while (i<= 1000)
	{
		a = i * i;
		while (x <= 100)
		{
			b = x * x*x;
			if (a == b)
			{
				printf("%d\n", b);
				sum = sum + 1;
			    break;
			}
				x++;
		}
		i++;
		x = 1;
	}

	printf("一共%d个\n",sum);
	return 0;
}