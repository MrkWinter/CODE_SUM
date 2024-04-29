#define _CRT_SECURE_NO_WARNINGS 1
//三数求最大
#include<stdio.h>
int max(int x, int y, int z)
{   int m;
	if (x > y, x > z) m = x;
	if (y > x, y > z) m = y;
	else m = z;
	return m;
}
int main()
{   int max(int x, int y, int z);
	int a, b, c, d;
	printf("请输三个数：");
	scanf("%d%d%d", &a,&b,&c);
	d = max(a, b, c);
	printf("max = %d\n", d);

	return 0;
}