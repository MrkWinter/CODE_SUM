#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <assert.h>
#include <stdlib.h>
typedef struct arr
{
	int* arrs; //��������
	int numb;//������Ԫ�ظ���
	int capacity;//��������
}arr;

void Inital(arr* s1)
{
	assert(s1);
	int i;
	if(!(s1->arrs = (int*)malloc(sizeof(int)*15)))
		perror("Inital:error!");
	s1->numb = s1->capacity  = 15;
	for (i = 0; i < 15; i++)
	{
		s1->arrs[i] = i;//0~14��������
	}
}
void Delect(arr* s1, int n)
{
	assert(s1);
	int i;
	for (i = n; i < s1->numb; i++)
	{
		s1->arrs[i - 1] = s1->arrs[i];//ɾ����n��Ԫ��
	}
	s1->numb -= 1;
}
void Dilat(arr* s1)
{
	assert(s1);
	if (s1->numb == s1->capacity)
		if (!(s1->arrs = (int*)realloc(s1->arrs, sizeof(int)*(s1->capacity + 5))))
			perror("Dilat");
	s1->capacity += 5;
}
void Insert(arr* s1, int n, int e)
{
	assert(s1);
	Dilat(s1);//����
	int i;
	for (i = s1->numb - 1; i >= n-1; i--)
	{
		s1->arrs[i+1] = s1->arrs[i];
	}
	s1->arrs[n - 1] = e;
	s1->numb += 1;
}
void print(arr* s1)
{
	assert(s1);
	int i;
	for (i = 0; i < s1->numb; i++)
	{
		printf("%d ", s1->arrs[i]);
	}
}
int main()
{
	arr s1 = { 0 };
	Inital(&s1);//��ʼ������
	//Delect(&s1,3);//ɾ�������е�3��Ԫ��
	Insert(&s1,2,3);//������ڶ���Ԫ��λ�ò���3
	print(&s1);//��ӡ����
	free(s1.arrs);
	s1.arrs = NULL;
	
	return 0;
}