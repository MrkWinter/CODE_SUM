#define _CRT_SECURE_NO_WARNINGS 1
//要求设计一个链表 
//1.表中可以不断插入数字
//2.可以不断删除元素指定一个数 
//3.可以打印元素 
//4.可以求其中的最大值 
//5.可以逆序输出链表
#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
typedef struct arrlist
{
	int date; //数据
	struct arrlist* front;//前指针
	struct arrlist* next;//后指针
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
	printf("请输入一个数");
	scanf("%d", &(p->date));
	p->next = NULL;
	p->front = q;
	q->next = p;
	printf("添加成功\n");
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
	printf("请输入显示方法：\n1.正序  2.倒序\n");
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
		printf("输入错误\n");
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
	printf("链表的长度为%d\n", length);
}

void listmin(arrlist* list)
{
	
	arrlist* p = list;
	int min = list->next->date;
	for (p = p->next; p; p = p->next)
	{
		min = min < p->date ? min : p->date;
	}
	printf("链表中最小的数字为 %d\n", min);
}

void listdel(arrlist* list)
{
	int input;
	printf("请输入要删除的元素\n");
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
	printf("删除成功\n");
}
int main()
{
	int input = 1;
	arrlist list = { 0 };
	Inital(&list);
	do
	{
		mean();
		printf("请输入选项：");
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
			printf("输入错误\n");
			break;
		}
		if (input != 0)
		{
			printf("按任意键返回");
			getchar(); getchar();
			system("cls");
		}

	} while (input);

	return 0;
}