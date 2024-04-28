#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#define MAx(X,Y) (X>Y?X:Y);
int MAX(int x, int y)
{
	if (x > y)
		printf("%d\n", x);
	else
		printf("%d\n", y);
}
int main()
{
	int a, b,c;
	scanf("%d%d", &a, &b);
	//MAX(a, b);//调用函数
	c = MAx(a, b)//调用define定义的宏 解释为a>b吗  大于=a 小于=b
	printf("%d\n", c);

	return 0;

}