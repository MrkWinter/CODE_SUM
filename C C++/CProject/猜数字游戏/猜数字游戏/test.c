#define _CRT_SECURE_NO_WARNINGS 1
//#include<stdio.h>
//#include<windows.h>
//#include<stdlib.h>
//#include<time.h>
//void game()
//{
//	int c = 0;
//	int times = 0;
//	int ret, guess;
//	while( c != 1 && c != 2 && c != 3 && c != 4)
//	{
//		printf("1.简单 2.普通 3.困难 4.超困难\n");
//		printf("请选择难度:>");
//		scanf("%d", &c);
//		if (c != 1 && c != 2 && c != 3 && c != 4)
//			printf("没有此难度\n");
//	}
//	if (1 == c)
//	{
//		ret = rand() % 10+1;
//		//rand函数，从伪随机数表中依次返回一个整型的数字，一般与strand函数一起使用，否则会默认基点为开头，(引stdlib.h)
//		printf("请猜本次的数字(0~10):>");
//	}
//	else if (2 == c)
//	{
//		ret = rand() % 100+1;
//		printf("猜猜本次的数字(0~100):>");
//	}
//	else if (3 == c)
//	{
//		ret = rand() % 1000+1;
//		printf("猜猜本次的数字(0~1000):>");
//	}
//	else if (4 == c)
//	{
//		ret = rand() % 10000+1;
//		printf("猜猜本次的数字(1~10000):>");
//	}
//	while (1)
//	{
//		scanf("%d", &guess);
//		times++;
//		if (ret > guess)
//		{
//			printf("猜小了哦\n");
//			printf("请再次输入:>");
//		}
//		else if (ret < guess)
//		{
//			printf("猜大了哦\n");
//			printf("请再次输入:>");
//		}
//		else
//		{
//			printf("恭喜你，猜对啦!!!\n");
//			break;
//		}
//	}
//	printf("您共用了%d次猜对了数字，下次加油哦\n", times);
//	printf("注：5秒后自动返回菜单");
//	Sleep(5000);
//	system("cls");
//}
//void menu()
//{
//	printf("*************猜数字小游戏**************\n");
//	printf("***************************************\n");
//	printf("****  1.play    2.rule    3.exit  *****\n");
//	printf("***************************************\n");
//}
//int main()
//{    
//	int input = 0;
//	//time函数，根据系统时间返回一个时间戳，返回类型为time_t,这里用了强制类型转换
//	//time(参数类型time_t*timer指针类型)(NULL)为空指针不产生效果(引time.h)
//	srand((unsigned int)time(NULL));
//	//srand函数，设置rand函数的基点srand()中输入一个随机数(unsigned int型)即可达到rand函数返回一个随机数的效果
//	//设置基点当程序跑起来时设置一次就行，多次设置会使生成的随机数值差别不大
//	do
//	{
//		menu();
//		printf("请输入选项:>");
//		scanf("%d", &input);
//		switch (input)
//		{case 1:
//			game();
//			 break;
//		 case 2:
//			 printf("1.开始游戏后系统会自动生成一个数\n");
//			 printf("2.玩家需要根据系统提示直到猜对数字\n");
//			 printf("3.试试你最少能在几次猜对数字吧\n");
//			 printf("注：10秒后自动返回菜单");
//			 Sleep(10000);
//			 system("cls");
//			 break;
//		 case 3:
//		     printf("您已退出游戏，感谢您的游玩\n");
//			 break;
//		 default:
//			 printf("没有这个选项，请重新输入\n");
//			 break;
//		}
//
//	}
//	while (input != 3);
//	return 0;
//}
#include<stdio.h>
//#include<time.h>
//#include<stdlib.h>
void game()
{
	int ret = rand() % 100 + 1;//取1~100的随机数
	while (1)
	{
		int guess;
		printf("猜数字(1~100):");
		scanf("%d", &guess);
		if (guess > ret)
			printf("猜大了，请继续");
		else if (guess < ret)
			printf("猜小了，请继续");
		else
		{
			printf("恭喜你猜对了!\n");
			break;
		}
	}
}
void menu()
{
	printf("**********猜数字小游戏**********\n");
	printf("********************************\n");
	printf("*****  1.play      0.exit  *****\n");
	printf("********************************\n");
}
int main()
{
	int a;
	srand((unsigned int)time(NULL));
	//time函数，根据系统时间返回一个时间戳，返回类型为time_t,这里用了强制类型转换
    //time(time_t*timer的指针类型),这里(NULL)为空指针不产生效果(引time.h头文件)
	//srand函数，设置rand函数的基点srand()中输入一个随机数(unsigned int型)即可达到rand函数返回一个随机数的效果
    //设置基点当程序跑起来时设置一次即可，多次设置会使生成的随机数值差别不大
	do
	{
		menu();//菜单函数
		printf("请选择:>");
		scanf("%d",&a);
		switch (a)
		{
		case 1:
			game();//游戏函数
			break;
		case 0:
			break;
		default:
			printf("没有该选项,请重新输入\n");
			break;
		}
	}
	while (a != 0);
	return 0;
}
//#include<windows.h>
//int main()
//{
//	srand((unsigned int)(time(NULL)));
//	while (1)
//	{
//		int ret;
//		ret = rand();
//		printf("%d\n", ret);
//		Sleep(1000);
//
//	}
//	return 0;
//}