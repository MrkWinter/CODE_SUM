#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
typedef struct student
{
	char sex[5];
	int math;
	int china;
}student;
typedef struct student_list //���
{
	student date;//������
	struct student_list* next;//ָ����
}student_list;
void Inital(student_list* list)
{
	list->next = NULL;//��ͷ����ָ�����ÿ�
}
void Insert(student_list* list, student* s)
{
	student_list* p = list;
	student_list* temp;//����ָ���½���ָ��
	while (p->next != NULL) //�ҵ�β���
		p = p->next;
	if (!(temp = (student_list*)malloc(sizeof(student_list))))
		perror("Insert:");
	temp->date = *s;//�����ݸ���������
	temp->next = NULL;
	p->next = temp;//β����ָ��ָ���µĽ��
	p = NULL;
}
void Printf(student_list* list)
{
	int i = 1;
	student_list* p;
	for (p = list->next; p != NULL; p = p->next,i++)
	{
		printf("��%d��ѧ������Ϣ����\n",i);
		printf("�Ա�%s ", p->date.sex);
		printf("��ѧ�ɼ���%d ", p->date.math);
		printf("���ĳɼ���%d\n", p->date.china);
	}
}
void Destery(student_list* list)
{
	student_list* p,* q; 
	for (p = list->next; p != NULL; p = p->next)
	{
		q = p->next;
		free(p);
		p = q;
	}

}
int main()
{
	student s1 = {"��",100, 99};//ѧ������
	student s2 = {"Ů", 60, 70};
	student_list list = { 0 };
	Inital(&list);//��ʼ������
	Insert(&list, &s1);//�����в���Ԫ��
	Insert(&list, &s2);
	Printf(&list);//��ӡ����
	Destery(&list);//��������
	return 0;
}