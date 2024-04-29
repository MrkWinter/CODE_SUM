#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<math.h>
//第一题
int main()
{
	double a;
	int b;
	printf("请输入存款金额:>");
	scanf("%lf", &a);
	printf("您有以下存款方式:\n");
	printf("1.一次存五年期\n");
	printf("2.先存2年，到期后将本息再存3年期\n");
	printf("3.先存3年，到期后将本息再存2年期\n");
	printf("4.存一年期，到期后将本息再存一年期，连续存五年\n");
	printf("5.存活期存款，活期利息每一季度结算一次\n");
	printf("请输入存款类型(1~5):>");
	scanf("%d", &b);
	switch (b)
	{
	case 1:
		a = a * (1 + 5 * 0.03);
		break;
	case 2:
		a = a * (1 + 2 * 0.023)*(1 + 3 * 0.0265);
		break;
	case 3:
		a = a * (1 + 3 * 0.0265)*(1 + 2 * 0.023);
		break;
	case 4:
		a = a * (1 + 0.0152)*(1 + 0.0152)*(1 + 0.0152)*(1 + 0.0152)*(1 + 0.0152);
		break;
	case 5:
		a = a * pow((1 + 0.0035 / 4), 20);
		break;
	default:
		printf("没有这种存款方式\n");
		break;
	}
	if (b > 0 && b < 6)
	printf("五年后存款的本息金额为:%lf\n", a);
	return 0;
}
//第二题
//(1)c1=a,c2=b  c1=97,c2=98 原因：%c对应输出的是ASCII码表对应的字符，%d对应输出的是十进制数字
//(2)c1=?,c2=?  c1=-59,c2=-58 原因：前者是数字超过了ASCII码对应符号的显示，后者是存入数数字大于一个字节，超出储存限制，按照补码储存
//(3)c1=a,c2=b  c1=97,c2=98 原因：同(1)不过int型申请4个字节的内存，可打印出197和198

//第三题
//int main()
//{
//	char c1 = 'C', c2 = 'h', c3 = 'i', c4 = 'n', c5 = 'a';
//	c1 = 'G';
//	c2 = 'l';
//	c3 = 'm';
//	c4 = 'r';
//	c5 = 'e';
//	printf("%c%c%c%c%c\n", c1, c2, c3, c4, c5);
//	putchar(c1);
//	putchar(c2); 
//	putchar(c3);
//	putchar(c4);
//	putchar(c5);
//	return 0;
//}
