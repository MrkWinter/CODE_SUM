#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<math.h>
//��һ��
int main()
{
	double a;
	int b;
	printf("����������:>");
	scanf("%lf", &a);
	printf("�������´�ʽ:\n");
	printf("1.һ�δ�������\n");
	printf("2.�ȴ�2�꣬���ں󽫱�Ϣ�ٴ�3����\n");
	printf("3.�ȴ�3�꣬���ں󽫱�Ϣ�ٴ�2����\n");
	printf("4.��һ���ڣ����ں󽫱�Ϣ�ٴ�һ���ڣ�����������\n");
	printf("5.����ڴ�������Ϣÿһ���Ƚ���һ��\n");
	printf("������������(1~5):>");
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
		printf("û�����ִ�ʽ\n");
		break;
	}
	if (b > 0 && b < 6)
	printf("�������ı�Ϣ���Ϊ:%lf\n", a);
	return 0;
}
//�ڶ���
//(1)c1=a,c2=b  c1=97,c2=98 ԭ��%c��Ӧ�������ASCII����Ӧ���ַ���%d��Ӧ�������ʮ��������
//(2)c1=?,c2=?  c1=-59,c2=-58 ԭ��ǰ�������ֳ�����ASCII���Ӧ���ŵ���ʾ�������Ǵ��������ִ���һ���ֽڣ������������ƣ����ղ��봢��
//(3)c1=a,c2=b  c1=97,c2=98 ԭ��ͬ(1)����int������4���ֽڵ��ڴ棬�ɴ�ӡ��197��198

//������
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
