#define _CRT_SECURE_NO_WARNINGS 1
#include"Head.h"
int StackIsEmpty(stack* s) { //判断栈是否为空
	return s->top == 0 ? 1 : 0;
}

int StackIsFull(stack* s) { //判断栈是否满
	return s->size == s->top ? 1 : 0;
}

stack* InitalRetStack(int n) {  //初始化栈并返回
	stack* s = (stack*)malloc(sizeof(stack));
	s->stackarr = (double*)malloc(sizeof(double) * n);
	s->size = n;
	s->top = 0;
	return s;
}

void PushStack(stack* s, double i) { //入栈
	if (StackIsFull(s)) {
		printf("队列已满\n");
		return;
	}
	s->stackarr[s->top++] = i;
}

double PopStack(stack* s) { //出栈
	if (StackIsEmpty(s)) {
		printf("队列已空 默认返回0\n");
		return 0;
	}
	return s->stackarr[--(s->top)];
}

void FreeStack(stack* s) { //清空栈
	free(s->stackarr);
	free(s);
	return;
}

void Push_Queue_Through_Stack(stack* s1, double i) { //用栈实现入队
	if (StackIsFull(s1)) {
		printf("栈队列满");
	}
	PushStack(s1, i);
}

double Pop_Queue_Through_Stack(stack* s1, stack* s2) { //用栈实现出队
	if (StackIsEmpty(s2)) {
		//若出队栈为空 将入队栈压入出队栈 实现顺序出队
		//将栈s1中的元素压栈到s2中
		for (int i = 0, capacity = s1->top; i < capacity; i++) {
			PushStack(s2, PopStack(s1));
		}
	}
	return PopStack(s2);
}