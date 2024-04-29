#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>

int main()
{
int a, b;
printf("请输入两个数：");
scanf("%d%d", &a, &b);
if (a > b)
printf("较大值为:%d\n", b);
if (a == b)
printf("两个数大小相等\n");
else
printf("较大值为%d\n", b);
printf("%%%%%%%%%%%%\n");
printf("  %%%%%%%%%%%%\n");
printf("    %%%%%%%%%%%%\n");
return 0;
}