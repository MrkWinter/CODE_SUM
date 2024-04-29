#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<Windows.h>
typedef struct stack {
	double* stackarr;
	int top;
	int size;
}stack;

stack* InitalRetStack(int n);  //初始化
int StackIsEmpty(stack* s); 
int StackIsFull(stack* s);
void PushStack(stack* s, double i); //入栈
double PopStack(stack* s); //出栈
void FreeStack(stack* s); 
void Push_Queue_Through_Stack(stack* s1, double i); //通过栈入队
double Pop_Queue_Through_Stack(stack* s1, stack* s2); //通过栈出队