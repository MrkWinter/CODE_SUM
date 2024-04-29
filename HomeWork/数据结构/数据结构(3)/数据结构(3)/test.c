#define _CRT_SECURE_NO_WARNINGS 1
//Ҫ�����һ������ 
//1.���п��Բ��ϲ�������
//2.���Բ���ɾ��Ԫ��ָ��һ���� 
//3.���Դ�ӡԪ�� 
//4.���������е����ֵ 
//5.���������������
#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
typedef struct arrlist
{
	int date; //����
	struct arrlist* front;//ǰָ��
	struct arrlist* next;//��ָ��
}arrlist;
void mean()
{
	printf("***********************\n");
	printf("**** 1.add   2.del ****\n");
	printf("**** 3.min   4.pri ****\n");
	printf("**** 5.len   0.exi ****\n");
	printf("***********************\n");
}
void Inital(arrlist* list)
{
	list = (arrlist*)malloc(sizeof(arrlist));
	list->next = NULL;
	list->front = NULL;
}
void listadd(arrlist* list)
{
	arrlist* q = list;
	while (q->next)
	{
		q = q->next;
	}
	arrlist* p = (arrlist*)malloc(sizeof(arrlist));
	printf("������һ����");
	scanf("%d", &(p->date));
	p->next = NULL;
	p->front = q;
	q->next = p;
	printf("��ӳɹ�\n");
}
void positivelist(arrlist* list)
{
	arrlist* p = list;
	for (p = p->next; p!=NULL; p = p->next)
	{
		printf("%d ", p->date);
	}
}
void reverselist(arrlist* list)
{
	arrlist* p = list;
	while (p->next)
	{
		p = p->next;
	}
	for (; p->front != NULL; p = p->front)
	{
		printf("%d ", p->date);
	}
}

void listprintf(arrlist* list)
{
	int input = 0;
	printf("��������ʾ������\n1.����  2.����\n");
	scanf("%d", &input);
	switch (input)
	{
	case 1:
		positivelist(list);
		break;
	case 2:
		reverselist(list);
		break;
	default:
		printf("�������\n");
		break;
	}
}

void listlength(arrlist*list)
{
	int length = 0;
	arrlist* p = list;
	for (p = p->next ; p; p = p->next)
	{
		length++;
	}
	printf("����ĳ���Ϊ%d\n", length);
}

void listmin(arrlist* list)
{
	
	arrlist* p = list;
	int min = list->next->date;
	for (p = p->next; p; p = p->next)
	{
		min = min < p->date ? min : p->date;
	}
	printf("��������С������Ϊ %d\n", min);
}

void listdel(arrlist* list)
{
	int input;
	printf("������Ҫɾ����Ԫ��\n");
	scanf("%d", &input);
	arrlist* p = list;
	for (p = p->next; p; p = p->next)
	{
		if (p->date == input)
		{
			if (p->next == NULL)
			{
				p->front->next = NULL;
				free(p);
				break;
			}
			else
			{
				p->front->next = p->next;
				p->next->front = p->front;
				free(p);
				break;
			}
		}
	}
	printf("ɾ���ɹ�\n");
}
int main()
{
	int input = 1;
	arrlist list = { 0 };
	Inital(&list);
	do
	{
		mean();
		printf("������ѡ�");
		scanf("%d", &input);
		switch(input)
		{
		case 1:
			listadd(&list);
			break;
		case 2:
			listdel(&list);
			break;
		case 3:
			listmin(&list);
			break;
		case 4:
			listprintf(&list);
			break;
		case 5:
			listlength(&list);
			break;
			
		case 0:
			break;
		default:
			printf("�������\n");
			break;
		}
		if (input != 0)
		{
			printf("�����������");
			getchar(); getchar();
			system("cls");
		}

	} while (input);

	return 0;
}