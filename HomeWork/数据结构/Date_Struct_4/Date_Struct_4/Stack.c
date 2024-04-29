#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#define MAX 100
//����ջ
typedef struct Stack
{
	char* date; //����ַ�
	int top; //ָ��ջ��
}Stack;
void InitalStack(Stack* s1)
{
	s1->date = (char*)malloc(sizeof(char)* MAX); //���ٿռ�������
	s1->top = -1;//
}
void PushStack(Stack* s1, char a)
{
	if (s1->top == MAX)
	{
		printf("ջ��\n");
		return;
	}
	s1->date[++(s1->top)] = a; //��ջ������ Ȼ��ֵ
}
void DelectStack(Stack* s1)
{
	s1->top = -1;
	free(s1->date);
}
char PopStack(Stack* s1) //��ջ ����ֵΪchar
{
	if (s1->top == -1)
	{
		perror("ջ��\n");
		return 'a';
	}
	char a = s1->date[(s1->top)--];//ջ������
	return a;
}
int LongStack(Stack* s1)
{
	return s1->top + 1;
}

char BracketsMatch(Stack* s1, char* arr)
{
	int i;
	int flag = 1;//flag==1��������ƥ��
	for (i = 0; arr[i] != '\0'; i++) //���������ַ�
	{
		if (arr[i] == '(' || arr[i] == '[' || arr[i] == '{')
		{
			PushStack(s1,arr[i]); //�������ŷ���ջ��
		}
		else
		{
			if (arr[i] == ')'&&PopStack(s1) != '(')
			{
				flag = 0;
				break;
			}
			if (arr[i] == ']'&&PopStack(s1) != '[')
			{
				flag = 0;
				break;
			}
			if (arr[i] == '}'&&PopStack(s1) != '{')
			{
				flag = 0;
				break;
			}
		}
	}
	if (LongStack(s1) != 0)
	{
		flag = 0;
	}
	return flag ? 'Y' : 'N';
}
int main()
{
	Stack s1 = { 0 };
	InitalStack(&s1); //��ʼ��ջ
	//PushStack(&s1, 'c');//��ջ
	//PopStack(&s1); //��ջ ����ֵΪchar
	//LongStack(&s1);//��ջ��Ԫ�ظ���

	//����ƥ�� ����һ���ַ��� �ж������Ƿ�ƥ�� ���Yes��No
	char arr[100] = { 0 };
	printf("������һ���ַ���\n");
	scanf("%s", arr);
	char result = BracketsMatch(&s1, arr);//����ƥ���㷨
	printf("���ַ�������ƥ��Ľ��Ϊ��%c", result);

	DelectStack(&s1);//�ͷ��ڴ�
	return 0;
}