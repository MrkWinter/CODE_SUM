#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
//���Ӷ����ʾ --�ṹ��--�����Լ�����������һ������
//����һ���ṹ������
struct Book
{
	char name[20];
	short price;
};

int main()
{//���ýṹ�����ʹ���һ�������͵Ľṹ�����
	struct Book b1 = { "C���Գ������", 55 };
	printf("������%s\n", b1.name);
	printf("�۸�%dԪ\n", b1.price);
	b1.price = 88;
	printf("�޸ĺ�ļ۸�Ϊ��%dԪ\n", b1.price);
	struct Book* v = &b1;
	//.�ṹ�����.��Ա
	//->�ṹ��ָ��->��Ա
	printf("%s\n", (*v).name);//���ַ�ҵ�b1 (*v)�൱��b1
	printf("%d\n", (*v).price);
	printf("%s\n", v->name);//ָ��ָ��b1 v->�൱��b1.
	printf("%d\n", v->price);

	strcpy(b1.name, "C++");//strcpy �ַ�������--�⺯��--string.h �����������͵��ַ���
	printf("���ĺ��������%s\n", b1.name);
	return 0;
}