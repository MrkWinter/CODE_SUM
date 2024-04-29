#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#define MAX 100
//定义栈
typedef struct Stack
{
	char* date; //存放字符
	int top; //指向栈顶
}Stack;
void InitalStack(Stack* s1)
{
	s1->date = (char*)malloc(sizeof(char)* MAX); //开辟空间存放数据
	s1->top = -1;//
}
void PushStack(Stack* s1, char a)
{
	if (s1->top == MAX)
	{
		printf("栈满\n");
		return;
	}
	s1->date[++(s1->top)] = a; //将栈顶上移 然后赋值
}
void DelectStack(Stack* s1)
{
	s1->top = -1;
	free(s1->date);
}
char PopStack(Stack* s1) //出栈 返回值为char
{
	if (s1->top == -1)
	{
		perror("栈空\n");
		return 'a';
	}
	char a = s1->date[(s1->top)--];//栈顶下移
	return a;
}
int LongStack(Stack* s1)
{
	return s1->top + 1;
}

char BracketsMatch(Stack* s1, char* arr)
{
	int i;
	int flag = 1;//flag==1代表括号匹配
	for (i = 0; arr[i] != '\0'; i++) //遍历所有字符
	{
		if (arr[i] == '(' || arr[i] == '[' || arr[i] == '{')
		{
			PushStack(s1,arr[i]); //将左括号放入栈中
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
	InitalStack(&s1); //初始化栈
	//PushStack(&s1, 'c');//入栈
	//PopStack(&s1); //出栈 返回值为char
	//LongStack(&s1);//求栈中元素个数

	//括号匹配 给定一个字符串 判断括号是否匹配 输出Yes或No
	char arr[100] = { 0 };
	printf("请输入一个字符串\n");
	scanf("%s", arr);
	char result = BracketsMatch(&s1, arr);//括号匹配算法
	printf("该字符串括号匹配的结果为：%c", result);

	DelectStack(&s1);//释放内存
	return 0;
}