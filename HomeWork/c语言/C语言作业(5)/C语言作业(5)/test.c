#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//int main()//ð������
//{
//	int i, n,temp;
//	int arr[] = { 1,4,2,5,7,8,9,0 };
//	int sz = sizeof(arr) / sizeof(arr[0]);
//	for (n=0;n<sz-1;n++)//��������,n��Ԫ��Ҫn-1��ð������
//	{
//		int c = 1;
//		for (i = 0; i < sz-1-n; i++)//����ÿ�˵ĵ�����������һ��Ҫ����n-1�ε���
//		{
//			if (arr[i] > arr[i + 1])
//			{
//				c = 0;//��˼�룬���û��if����������Ѿ���ɣ�����Ҫ��һ��
//				arr[i] = arr[i] ^ arr[i + 1];//temp= arr[i+1];
//				arr[i + 1] = arr[i] ^ arr[i + 1];	//arr[i + 1] = arr[i];
//				arr[i] = arr[i + 1] ^ arr[i];//arr[i] = temp;
//			}
//		}
//		if (c == 1)
//			break;
//	}
//	for (i = 0; i < sz; i++)
//		printf("%d", arr[i]);
//	return 0;
//}
//�ҳ�ֻ����һ�ε�����
//int main()
//{
//	int i, n;
//	int arr[] = { 1,2,2,1,4,4,6,7,8,7,8 };
//	int sz = sizeof(arr) / sizeof(arr[0]);
//	for (i = 0; i < sz; i++)
//	{
//		int c = 0;
//		for (n = 0; n < sz; n++)
//		{
//			if (arr[i] == arr[n])
//				c += 1;
//		}
//		if (c == 1)
//		{
//			printf("%d", arr[i]);
//			break;
//		}
//	}
//
//
//	return 0;
//}
//�����Ż�
//int main()
//{
//	int i;
//	int arr[] = { 1,2,2,1,4,4,6,7,8,7,8 };
//	int sz = sizeof(arr) / sizeof(arr[0]);
//	for (i = 1; i < sz; i++)
//	{
//		arr[0] ^= arr[i];//0^a=a,�ظ����ε����ֶ��ᱻ��ȥ����Ϊ0������ҵ��ľ��ǳ���һ�ε���
//	}
//	printf("%d", arr[0]);
//	return 0;
//}
#include<stdlib.h>//system����
#include<string.h>//strcmp����
//int main()
//{
//	char input[20] = { 0 };
//	system("shutdown -s -t 300");
//	again:
//	printf("��ĵ��Խ���5�����ڹػ�\n����\"������\"����ȡ��\n");
//	scanf("%s", input);
//	if (strcmp(input, "������") == 0)
//		system("shutdown -a");
//	else
//		goto again;
//	return 0;
//}
//int main()
//{
//	char arr[] = "abcd";//\0�Ǽ����ַ������ַ���ĩβ��,�������ַ�������û�м�
//	int a = sizeof(arr) / sizeof(arr[0]);//0�ǿ��ַ�,Ϊһ���ո����ʾ-ʲôҲû�У�Ϊ�ַ��������ı�־'\0',ascllΪ0���ַ�
//	//a = strlen(arr); //'0'ΪascllֵΪ48���ַ�
//	printf("%d", a);//' 'ΪascllֵΪ32���ַ�
//	return 0;//strlen����ѿո�ͻس���Ϊ�ַ��������ı�־��Ҳ�ῴ���ַ�
//}
//scanf()����ֻ���տո�ͻس�ǰ�Ķ���
//int main()
//{
//	char arr[3] = { 0 };
//	return 0;
//}
//int main()
//{
//	int arr[3][3] = { {1,2,3},{4,5,6},{7,8,9} };
//	int sum=0;
//	sum = arr[0][0] + arr[1][1] + arr[2][2] + arr[0][2] + arr[2][0];
//	printf("�Խ��ߺ�Ϊ:%d", sum);
//	return 0;
//}
//int main()
//{
//	int arr[10] = { 1,4,7,9,13,56,67,80,95 };
//	int i, sz = sizeof(arr) / sizeof(arr[0])-1;
//	scanf("%d", &arr[9]);
//	printf("������Ԫ�شӴ�СΪ:");
//	for (i = sz; i >= 0; i--)
//	{
//		if (arr[i] < arr[i - 1])
//		{
//			arr[i] = arr[i - 1] ^ arr[i];
//			arr[i - 1] = arr[i] ^ arr[i - 1];
//			arr[i] = arr[i] ^ arr[i - 1];
//		}
//		printf("%d ", arr[i]);
//	}
//	return 0;
//}

int main()
{
	int a=0,b=0,c=0,d=0,e=0;
	char arr[] = "ABC,abc,123. !";//����
	scanf("%s", arr);
	int sz = strlen(arr),i;
	for (i = 0; i < sz; i++)
	{
		if (arr[i] >= 65 && arr[i] <= 90)
			a++;
		else if (arr[i] >= 97 && arr[i] <= 112)
			b++;
		else if (arr[i] >= 48 && arr[i] <= 57)
			c++;
		else if (arr[i] ==32)
			d++;
		else
		    e++;
	}
	printf("��д��ĸ����:%d\n", a);
	printf("Сд��ĸ����:%d\n", b);
	printf("���ָ���:%d\n", c);
	printf("�ո����:%d\n", d);
	printf("�����ַ�����:%d\n", e);
	return 0;
}
//int main()
//{
//	char a,b;
//	int arr[] = {1,2,3,4};//һ��һ����ڴ棬�޷�һ��ȡ��
//	printf("%d ", (&arr));
//	printf("%d ", *(&arr));//�����������޷��ó�
//	int* p = &arr;
//	printf("%d ", *p);//�ֿ����������������������飬��ӡ��һԪ��
//	//printf("%d ", arr);
//	//int arr1[3];//����ɲ�����
//	//printf("%d ", arr1);
//	return 0;
//}
//int main()
//{
//	int a=1, b;
//	int arr[] = { 1,2,3,4 };
//	printf("%d ", *(&a));
//	int* p = &a;
//	printf("%d", *p);
//	return 0;
//}
//int main()
//{
//	char a, b;
//	char arr[] = { '1','2','3','4','\0'};//�ַ����飬��'\0',�ɿ����ַ���
//	printf("%s ", arr);//ֱ��������ӡ�����ҵ�\0Ϊֹ
//	puts(arr);
//	return 0;
//}
//������c52
//int j(int c)
//{
//	int i,cnm=1;
//	for (i = 1; i <= c; i++)
//	{
//		cnm *= i;
//	}
//	return cnm;
//}
//int main()
//{
//	int a, b;
//	scanf("%d%d", &a, &b);
//	printf("%d", j(a) / (j(b)*j(a - b)));
//	return 0;
//}
//������
//int age(int a)
//{
//	if (a == 1)
//		return 10;
//	else
//		return age(a - 1) + 2;//�ݹ�ʵ�ʣ�������Ҫ�����������ǰ��һ����Ȼ��涨����Ľ��������Ҳ���Ǻ����ݹ�Ľ�������
//}
//int main()
//{
//	printf("%d", age(5));
//	return 0;
//}
//�ݹ���n�Ľ׳�
//int jie(int a)
//{
//	if (a == 0)
//		printf("��88");
//	else if (a == 1)
//		return 1;
//	else 
//		return a * jie(a - 1);
//}
//int main()
//{
//	int a;
//	scanf("%d", &a);
//	printf("%d",jie(a));
//	return 0;
//}
//int maxr(int a, int b)
//{
//	a = a > b ? a : b;
//	return a;
//}
//int Max(int a, int b, int c, int d)
//{
//	a = maxr(a, b);
//	a = maxr(a, c);
//	a = maxr(a, d);
//	return a;
//}
//int main()
//{
//	int a, b, c, d;
//	scanf("%d%d%d%d", &a, &b, &c, &d);
//	printf("������Ϊ��%d", Max(a, b, c, d));
//	return 0;
//}