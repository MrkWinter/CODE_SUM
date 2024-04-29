#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include<stdlib.h>
#include <Windows.h>
typedef struct treeNode {
	char date;
	struct treeNode* lTreeNode;
	struct treeNode* rTreeNode;
}treeNode;
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
void treaveTree(treeNode* root) {
	if (!root)
		return;
	printf("%c ", root->date);
	treaveTree(root->lTreeNode);
	treaveTree(root->rTreeNode);
}
int main() {
	treeNode* root = createTree();//根节点
	treaveTree(root); //遍历
	system("pause");
	return 0;
}