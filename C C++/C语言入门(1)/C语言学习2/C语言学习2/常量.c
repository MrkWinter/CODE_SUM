#define _CRT_SECURE_NO_WARNINGS 1
//#include<stdio.h>

//int main()

//{//复习输入加法
	/*int numb1, numb2,sum;

	scanf("%d%d", &numb1, &numb2);

	sum = numb1 + numb2;

	printf("sum = %d\n", sum);*/

	//1字面常量

	//3;
//	4;//直观写出的值叫字面常量

	//2const修饰的常变量
	//const int numb1 = 6;

	//numb1 = 8;不可修改
	//printf("%d", numb1);

	//const具有常属性,const是常变量，本质上是变量，不能当做常量来用
	//const int n = 10;

	//int arr[n] = {0};//n不能使用

	//return 0;
//}
#include<stdio.h>
//3#define 定义的标识符常量
#define MAX 10

enum Sex
{
	MALE,
    FEMALE,//被称为枚举常量
	SECRET

};


int main()

{
	//printf("%d\n", MAX);

//4枚举常量

	enum Sex mike = MALE;

	printf("%d%\n", MALE);
	printf("%d%\n", FEMALE);
	printf("%d%\n", SECRET);
	return 0;
}





