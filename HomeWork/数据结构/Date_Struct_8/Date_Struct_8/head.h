#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<Windows.h>
typedef struct stack {
	double* stackarr;
	int top;
	int size;
}stack;

stack* InitalRetStack(int n);  //��ʼ��
int StackIsEmpty(stack* s); 
int StackIsFull(stack* s);
void PushStack(stack* s, double i); //��ջ
double PopStack(stack* s); //��ջ
void FreeStack(stack* s); 
void Push_Queue_Through_Stack(stack* s1, double i); //ͨ��ջ���
double Pop_Queue_Through_Stack(stack* s1, stack* s2); //ͨ��ջ����