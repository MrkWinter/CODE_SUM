#include<stdio.h>

int main()
{//复习输入加法实例

	int numb1 = 0;
	int numb2 = 0;
	int sum = 0;
	scanf("%d,%d", &numb1, &numb2);

	sum = numb1 + numb2;

	printf("sum = %d\n", sum);

	//作用域
	//局部变量的作用域是本代码块内部
	//全局变量的作用域是整个项目
	//extern int 标识符;(生明extern外部符号，对在不同于本文件的其他文件中的全局变量加以使用)

	//生命周期
	//对于一个局部变量来说，进入作用域生命周期开始，出作用域生命周期结束
	//对于一个全局变量来说，生命周期是整个程序的生命周期


	return 0;

	





}