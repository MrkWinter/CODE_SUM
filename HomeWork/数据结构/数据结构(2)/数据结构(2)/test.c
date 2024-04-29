#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
typedef struct student
{
	char sex[5];
	int math;
	int china;
}student;
typedef struct student_list //结点
{
	student date;//数据域
	struct student_list* next;//指针域
}student_list;
void Inital(student_list* list)
{
	list->next = NULL;//将头结点的指针域置空
}
void Insert(student_list* list, student* s)
{
	student_list* p = list;
	student_list* temp;//定义指向新结点的指针
	while (p->next != NULL) //找到尾结点
		p = p->next;
	if (!(temp = (student_list*)malloc(sizeof(student_list))))
		perror("Insert:");
	temp->date = *s;//将数据赋给数据域
	temp->next = NULL;
	p->next = temp;//尾结点的指针指向新的结点
	p = NULL;
}
void Printf(student_list* list)
{
	int i = 1;
	student_list* p;
	for (p = list->next; p != NULL; p = p->next,i++)
	{
		printf("第%d名学生的信息如下\n",i);
		printf("性别：%s ", p->date.sex);
		printf("数学成绩：%d ", p->date.math);
		printf("语文成绩：%d\n", p->date.china);
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
	student s1 = {"男",100, 99};//学生数据
	student s2 = {"女", 60, 70};
	student_list list = { 0 };
	Inital(&list);//初始化链表
	Insert(&list, &s1);//链表中插入元素
	Insert(&list, &s2);
	Printf(&list);//打印链表
	Destery(&list);//销毁链表
	return 0;
}