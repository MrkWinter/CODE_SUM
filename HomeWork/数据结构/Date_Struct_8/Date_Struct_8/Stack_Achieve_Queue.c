#define _CRT_SECURE_NO_WARNINGS 1
//��ջʵ�ֳ��ӵ�ģ��
//��������ջ ���������һ��ջ
//����һ��ջ�е�Ԫ��ѹ���ڶ���ջ��
//�ڶ���ջ��ջ ��ջ˳�򼴳��ӵ�˳��
#include"Head.h"

int main() {
	double arr[10] = { 12.3,45.2,67.3,13.5,23.4,90.1,34.6,73.3,76.4,32.4 };

    stack* s1 = InitalRetStack(sizeof(arr) / sizeof(arr[0])); //��ʼ��������һ�����ջ
	stack* s2 = InitalRetStack(sizeof(arr) / sizeof(arr[0])); //��ʼ��������һ������ջ
	 //s1�����ջ  s2�ǳ���ջ

	for (int i = 0; i < sizeof(arr) / sizeof(arr[0]); i++) {
		Push_Queue_Through_Stack(s1, arr[i]); //ʵ�����   
    }
	for (int j = 0; j < sizeof(arr) / sizeof(arr[0]); j++) {
		printf("%.1f  ", Pop_Queue_Through_Stack(s1, s2));//ʵ�ֳ���
    }

	FreeStack(s1); //�ͷ�ջ������ڴ�
	FreeStack(s2); //�ͷ�ջ������ڴ�
	system("pause");
return 0;
}

//stack* s1 = InitalRetStack(10); //��ʼ��������һ������
//for (int i = 0; i < sizeof(arr) / sizeof(arr[0]); i++) {
//	PushStack(s1, arr[i]); //��ջ ģ��һ�ν�һ��Ԫ�����
//}
//stack* s2 = InitalRetStack(10); //��ʼ��������һ������
//for (int j = 0; j < s1->size; j++) {
//	PushStack(s2, PopStack(s1));//��ջs1�е�Ԫ��ѹջ��s2��
//}
//for (int k = 0; k < s2->size; k++) {
//	printf("%.1f  ", PopStack(s2)); //s2�ĳ�ջ˳���Ƕ��еĳ���˳��
//}
