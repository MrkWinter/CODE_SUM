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
	//MAX(a, b);//���ú���
	c = MAx(a, b)//����define����ĺ� ����Ϊa>b��  ����=a С��=b
	printf("%d\n", c);

	return 0;

}