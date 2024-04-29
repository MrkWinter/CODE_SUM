#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h> 
#include<stdlib.h>
#define MAX 9
//定义队列
typedef struct Queue
{
	int* date; //存放数据
	int front; //队首
	int rear; //队尾
}Queue;
void InitalQueue(Queue* q1)
{
	q1->date = (int*)malloc(sizeof(int)* MAX); //开辟队列内存
	q1->front = q1->rear = 0;
}
void DelectQueue(Queue* q1)
{
	q1->front = q1->rear = 0;
	free(q1->date); //释放内存
}
void PushQueue(Queue* q1, int a)
{
	if ((q1->rear + 1) % MAX == q1->front) //队列满的情况
	{
		printf("队列满\n");
		return;
	}
	*(q1->date + q1->rear) = a;
	q1->rear = (q1->rear + 1) % MAX; //队尾指向下一个
}
int PopQueue(Queue* q1)
{
	if (q1->rear == q1->front)
	{
		perror("队列空\n");
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
	printf("请输入环中元素,共%d个\n",MAX-1);
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
	InitalQueue(&q1); //初始化队列

	//PushQueue(&q1, 2); //入队
	//PopQueue(&q1);//出队 出队返回值为int
	//LongQueue(&q1);//求队长

	//约瑟夫环
	InitalCricle(&q1); //初始化环

	printf("请输入循环出队数M\n");
	int M;
	scanf("%d", &M);
	int result = SolveCricle(&q1,M); //得出最后一个元素
	printf("最后一个元素为%d", result);


	DelectQueue(&q1); //释放内存
	return 0;
}