#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//int main()
//{ 
//    int a, b, c;
//    scanf("%d%d%d", &a, &b, &c);
//	if (a < b)
//		a = b;
//	else if (a < c)
//		a = c;
//	printf("max =%d", a);
//return 0;
//}
//int main()
//{
//	int a;
//	char arr[20] = "45";
//	scanf("%s", arr);
//	a = strlen(arr);
//	printf("�����������%dλ��", a);
//	return 0;
//}
int main()
{
	int a;
	scanf("%d",&a);
	if (90 <= a && a <= 100)
		printf("�ɼ��ȼ�ΪA");
	else if (80 <= a && a <= 89)
		printf("�ɼ��ȼ�ΪB");
	else if (70 <= a && a <= 79)
		printf("�ɼ��ȼ�ΪC");
	else if (60 <= a && a <= 69)
		printf("�ɼ��ȼ�ΪD");
	else if (0 <= a && a <= 59)
		printf("�ɼ��ȼ�ΪE");
	else
		printf("�ɼ�������");
	return 0;
}