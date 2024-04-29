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
//	printf("输入的数字有%d位数", a);
//	return 0;
//}
int main()
{
	int a;
	scanf("%d",&a);
	if (90 <= a && a <= 100)
		printf("成绩等级为A");
	else if (80 <= a && a <= 89)
		printf("成绩等级为B");
	else if (70 <= a && a <= 79)
		printf("成绩等级为C");
	else if (60 <= a && a <= 69)
		printf("成绩等级为D");
	else if (0 <= a && a <= 59)
		printf("成绩等级为E");
	else
		printf("成绩不合理");
	return 0;
}