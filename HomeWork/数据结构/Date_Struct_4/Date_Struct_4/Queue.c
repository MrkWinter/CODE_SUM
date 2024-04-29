#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h> 
#include<stdlib.h>
#define MAX 9
//�������
typedef struct Queue
{
	int* date; //�������
	int front; //����
	int rear; //��β
}Queue;
void InitalQueue(Queue* q1)
{
	q1->date = (int*)malloc(sizeof(int)* MAX); //���ٶ����ڴ�
	q1->front = q1->rear = 0;
}
void DelectQueue(Queue* q1)
{
	q1->front = q1->rear = 0;
	free(q1->date); //�ͷ��ڴ�
}
void PushQueue(Queue* q1, int a)
{
	if ((q1->rear + 1) % MAX == q1->front) //�����������
	{
		printf("������\n");
		return;
	}
	*(q1->date + q1->rear) = a;
	q1->rear = (q1->rear + 1) % MAX; //��βָ����һ��
}
int PopQueue(Queue* q1)
{
	if (q1->rear == q1->front)
	{
		perror("���п�\n");
	}
	int a = q1->date[q1->front];
	q1->front = (q1->front + 1) % MAX;
	return a;
}
int LongQueue(Queue* q1)
{
	return (q1->rear - q1->front + MAX) % MAX;
}
void InitalCricle(Queue* q1)
{
	int i;
	printf("�����뻷��Ԫ��,��%d��\n",MAX-1);
	for (i = 0; i < MAX-1; i++)
	{
		int input;
		scanf("%d", &input);
		PushQueue(q1,input);
	}

}
int SolveCricle(Queue* q1, int m)
{
	int i;
	while (LongQueue(q1) != 1)
	{
		for (i = 1; i <= m; i++)
		{
			int temp = PopQueue(q1);
			if (i != m)
			{
				PushQueue(q1, temp);
			}
		}
	}
	return q1->date[q1->front];
}
int main()
{
	Queue  q1 = { 0 };
	InitalQueue(&q1); //��ʼ������

	//PushQueue(&q1, 2); //���
	//PopQueue(&q1);//���� ���ӷ���ֵΪint
	//LongQueue(&q1);//��ӳ�

	//Լɪ��
	InitalCricle(&q1); //��ʼ����

	printf("������ѭ��������M\n");
	int M;
	scanf("%d", &M);
	int result = SolveCricle(&q1,M); //�ó����һ��Ԫ��
	printf("���һ��Ԫ��Ϊ%d", result);


	DelectQueue(&q1); //�ͷ��ڴ�
	return 0;
}