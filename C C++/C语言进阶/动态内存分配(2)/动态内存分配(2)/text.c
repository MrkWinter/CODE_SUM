#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<errno.h>
//��̬�ڴ濪�ٵĳ�������
//1.�����ÿ���ʧ�ܵĿ�ָ��
//2.Խ����ʿ��ٵ��ڴ�
//3.������ջ�����ڴ��ͷ�
//4.ʹ��free�ͷŶ�̬���ٿռ��һ���֣����ص�ָ��p��ò�Ҫ������Ҫʹ��p���ͷſռ䣩
//5.��ͬһ���ڴ����ͷ�
//6.�Զ�̬���ٵ��ڴ������ͷţ��ڴ�й©��
//�������
//void getmemory(char* p)//pΪstr��һ����ʱ����
//{
//	p = (char *)malloc(100);//����������p�ᱻ���٣����ٵ��ڴ��޷��ͷ�
//}
//void test()
//{
//	char* str = NULL;
//	getmemory(str);//str���ݵ���ֵ//
//	strcpy(str, "hellow");//��ָ���޷�����,�������
//	printf(str);//����ֱ�Ӵ�ӡָ��
//}
//int main()
//{
//	test();
//	return 0;
//}
////1.���д���������ֱ���������
////2.��������ڴ�й©������
//�޸�
//void getmemory(char** p)
//{
//	*p = (char *)malloc(100);
//	if (*p == NULL)
//	{
//		printf("%s", strerror(errno));
//	}
//}
//void test()
//{
//	char* str = NULL;
//	getmemory(&str);
//	strcpy(str, "hello");
//	printf(str);
//	free(str);
//	str = NULL;
//}
//int main()
//{
//	test();
//	return 0;
//}
//�Ƿ�����ջ���ڴ�
//int* test()
//{
//	int a = 0;//�Ƿ�����ջ���ڴ� ����static����ȷ 
//	return &a;
//}
//int main()
//{
//	int *p = test();
//	printf("%d",*p);
//	return 0;
//}
//ջ������Ŀռ���������ͻ����� ��̬���Ͷ������ᣬֱ���������

typedef struct stack
{
	int* date;
	int top;
	int size;
}stack;
stack* Inital(int n)
{
	stack* sta = (stack*)malloc(sizeof(stack)*1);
	sta->size = 10;
	sta->top = 0;
	sta->date = (int*)malloc(sizeof(int) * 10);
	sta->date[0] = 1;
	return sta;//sta�������ָ�� ֻ�Ǽ�¼��һ����ַ ���ն�̬������ڴ��ַ ����ֱ�ӷ��ظõ�ַ��ַ����ʱ����������
	//���Կɸ��ݵ�ַ�ҵ����ٵ��ڴ�����
	
	
}
int main()
{

	stack* sta = Inital(10);
	printf("%d", sta->date[0]);

	return 0;
}