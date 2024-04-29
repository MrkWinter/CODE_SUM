#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<Windows.h>
#define SIZE 100
typedef struct treeNode {
	char date;
	struct treeNode* lTreeNode;
	struct treeNode* rTreeNode;
}treeNode;

typedef struct queue {
	treeNode* arrque;
	int first;
	int end;
}queue;
queue* Initalqueue() {
	queue* q1 = (queue*)malloc(sizeof(queue));
	q1->arrque = (treeNode*)malloc(sizeof(treeNode)* SIZE);
	q1->first = 0;
	q1->end = 0;
	return q1;
}
void pushQueue(queue* q1,treeNode* t1) {
	if ((q1->end + 1) % 100 == q1->first)
		return;
	q1->arrque[q1->end] = *t1;
	q1->end = (q1->end + 1) % SIZE;
	return;
}
treeNode popQueue(queue* q1) {
	if (q1->first == q1->end) {
		printf("error\n");
		perror("error\n");
	}
	treeNode temp = q1->arrque[q1->first];
	q1->first = (q1->first + 1) % SIZE;
	return temp;
}
int queueIsEmpty(queue* q1) {
	if (q1->end == q1->first)
		return 0;
	return 1;
}

treeNode* createTree() {  //采用函数内接收数据
	char tempDate = 0;
	scanf("%c", &tempDate);
	getchar();

	if (tempDate == '#')
		return NULL;

	treeNode* node = (treeNode*)malloc(sizeof(treeNode));
	node->date = tempDate;
	node->lTreeNode = createTree();
	node->rTreeNode = createTree();
	return node;
}

void levelOrder(treeNode* root) {
	queue* q1 = Initalqueue();
	pushQueue(q1, root);
	while (queueIsEmpty(q1)) {
		treeNode t = popQueue(q1);
		printf("%c ", t.date);
		if(t.lTreeNode!=NULL)
		pushQueue(q1, t.lTreeNode);
		if (t.rTreeNode != NULL)
			pushQueue(q1, t.rTreeNode);
	}
	return;
}
int main() {
	treeNode* root = createTree();
	levelOrder(root);
	system("pause");
	return 0;
}
