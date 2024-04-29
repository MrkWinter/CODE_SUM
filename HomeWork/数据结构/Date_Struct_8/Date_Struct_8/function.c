#define _CRT_SECURE_NO_WARNINGS 1
#include"Head.h"
int StackIsEmpty(stack* s) { //�ж�ջ�Ƿ�Ϊ��
	return s->top == 0 ? 1 : 0;
}

int StackIsFull(stack* s) { //�ж�ջ�Ƿ���
	return s->size == s->top ? 1 : 0;
}

stack* InitalRetStack(int n) {  //��ʼ��ջ������
	stack* s = (stack*)malloc(sizeof(stack));
	s->stackarr = (double*)malloc(sizeof(double) * n);
	s->size = n;
	s->top = 0;
	return s;
}

void PushStack(stack* s, double i) { //��ջ
	if (StackIsFull(s)) {
		printf("��������\n");
		return;
	}
	s->stackarr[s->top++] = i;
}

double PopStack(stack* s) { //��ջ
	if (StackIsEmpty(s)) {
		printf("�����ѿ� Ĭ�Ϸ���0\n");
		return 0;
	}
	return s->stackarr[--(s->top)];
}

void FreeStack(stack* s) { //���ջ
	free(s->stackarr);
	free(s);
	return;
}

void Push_Queue_Through_Stack(stack* s1, double i) { //��ջʵ�����
	if (StackIsFull(s1)) {
		printf("ջ������");
	}
	PushStack(s1, i);
}

double Pop_Queue_Through_Stack(stack* s1, stack* s2) { //��ջʵ�ֳ���
	if (StackIsEmpty(s2)) {
		//������ջΪ�� �����ջѹ�����ջ ʵ��˳�����
		//��ջs1�е�Ԫ��ѹջ��s2��
		for (int i = 0, capacity = s1->top; i < capacity; i++) {
			PushStack(s2, PopStack(s1));
		}
	}
	return PopStack(s2);
}