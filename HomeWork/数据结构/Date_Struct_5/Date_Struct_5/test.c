#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

//�ݹ����n�Ľ׳�
//int factorial(int n)
//{
//	if (n == 1)
//		return 1;
//	else
//		return n * factorial(n - 1);
//}
//int main()
//{
//	int n;
//	printf("������һ����,��������Ľ׳�:\n");
//	scanf("%d", &n);
//	printf("%d", factorial(n));
//	return 0;
//}

//�õݹ�õ�쳲��������е�ǰn��

//int fibonacci(int i)
//{
//	if (i == 1)
//		return 0;
//	if (i == 2)
//		return 1;
//	return fibonacci(i-1) + fibonacci(i - 2);
//}
//int main()
//{
//	int n;
//	printf("������һ����:\n");
//	scanf("%d", &n);
//	for (int i = 1; i <= n; i++)
//	{
//		printf("%d\t",fibonacci(i));
//	}
//	return 0;
//}

//������һ������ת�����ַ��� ���ַ���ת��������

//char* tostring(int i)
//{
//	int n;
//	int temp = i;
//	for (n = 0; temp; temp = temp / 10,n++);
//	char* str = (char*)malloc(sizeof(char)* n + 2);
//	if (i >= 0)
//	{
//		str[n] = '\0';
//		for (int j = n - 1; j >= 0; j--, i = i / 10)
//		{
//			str[j] = i % 10 + '0';
//		}
//	}
//	else
//	{
//		i = -i;
//		str[n+1] = '\0';
//		for (int j = n; j > 0; j--, i = i / 10)
//		{
//			str[j] = (i % 10) + 0x30;
//		}
//		str[0] = '-';
//	}
//	return str;
//}
//int tointeger(char* str)
//{
//	int ret = 0;
//	int digit = 1;
//	if (str[0] != '-')
//	{
//		for (int i = strlen(str) - 1; i >= 0; i--)
//		{
//			ret += (str[i] - 0x30)*digit;
//			digit *= 10;
//		}
//	}
//	else
//	{
//		for (int i = strlen(str) - 1; i > 0; i--)
//		{
//			ret += (str[i] - '0')*digit;
//			digit *= 10;
//		}
//		ret = -ret;
//	}
//	return ret;
//}
//int main()
//{
//	int i;
//	int input;
//	char str[100];
//	printf("1.�����ַ��� 2.��������\n");
//	scanf("%d", &input);
//	switch (input)
//	{
//		case 1:
//			scanf("%s", str);
//			printf("%d",tointeger(str)); //�ַ���ת��������
//			break;
//		case 2:
//			scanf("%d", &i);
//			printf("%s", tostring(i)); //����ת�����ַ���
//			break;
//		default:
//			printf("�������");
//	}
//
//}
//�ܽ� �����ַ�ת�������� -'0'(��Ӧʮ������Ϊ0x30 ʮ����Ϊ48 �˽���Ϊ06 ������Ϊ0b00110000);
//����ת���������ַ�+'0';