#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
	/*int main()
	{//选择语句复习

		int input;
		printf("要上学了\n");
		printf("你要好好好学习吗？(1/0)>:");
		scanf("%d", &input);
		if (input == 1)
			printf("你成为了一名好学生");
		else
			printf("你成为了一个坏学生");
		return 0;

	}*/

//循环语句复习
//int main()
//	{
//	int word = 0;
//
//
//	while (word < 200000)
//
//	{
//		printf("写一个字,%d\n", word);
//
//		word++;
//
//	}
//	if (word >= 100000)
//	
//		printf("你的论文字数达到,作业完成\n");
//	
//	return 0;
//
//	}


int Add(int x, int y)//xy为参数
{
	int z;
	z = x + y;
	return z;//把整型z返回到开头存入sum
}


int main()
	{
	int numb1, numb2,sum;
	numb1 = 34;
	numb2 = 45;
	sum = Add(numb1, numb2);//采用Add加法函数来计算

	printf("%d\n",sum);
		return 0; 
	}
