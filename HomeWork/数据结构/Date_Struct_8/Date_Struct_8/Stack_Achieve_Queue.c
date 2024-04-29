#define _CRT_SECURE_NO_WARNINGS 1
//用栈实现出队的模拟
//创建两个栈 将数据入第一个栈
//将第一个栈中的元素压到第二个栈中
//第二个栈出栈 出栈顺序即出队的顺序
#include"Head.h"

int main() {
	double arr[10] = { 12.3,45.2,67.3,13.5,23.4,90.1,34.6,73.3,76.4,32.4 };

    stack* s1 = InitalRetStack(sizeof(arr) / sizeof(arr[0])); //初始化并返回一个入队栈
	stack* s2 = InitalRetStack(sizeof(arr) / sizeof(arr[0])); //初始化并返回一个出队栈
	 //s1是入队栈  s2是出队栈

	for (int i = 0; i < sizeof(arr) / sizeof(arr[0]); i++) {
		Push_Queue_Through_Stack(s1, arr[i]); //实现入队   
    }
	for (int j = 0; j < sizeof(arr) / sizeof(arr[0]); j++) {
		printf("%.1f  ", Pop_Queue_Through_Stack(s1, s2));//实现出队
    }

	FreeStack(s1); //释放栈申请的内存
	FreeStack(s2); //释放栈申请的内存
	system("pause");
return 0;
}

//stack* s1 = InitalRetStack(10); //初始化并返回一个队列
//for (int i = 0; i < sizeof(arr) / sizeof(arr[0]); i++) {
//	PushStack(s1, arr[i]); //入栈 模拟一次将一个元素入队
//}
//stack* s2 = InitalRetStack(10); //初始化并返回一个队列
//for (int j = 0; j < s1->size; j++) {
//	PushStack(s2, PopStack(s1));//将栈s1中的元素压栈到s2中
//}
//for (int k = 0; k < s2->size; k++) {
//	printf("%.1f  ", PopStack(s2)); //s2的出栈顺序即是队列的出队顺序
//}
