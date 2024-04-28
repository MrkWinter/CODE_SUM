#define _CRT_SECURE_NO_WARNINGS 1
#include"game.h"
void menu()
{
	printf("**********************************\n");
	printf("***** 1.play  2.rule  3.exit *****\n");
	printf("**********************************\n");
}
void game()
{
	char ret;
	char Board[ROW][COL] = { 0 };
	InitBoard(Board, ROW, COL);//初始化棋盘
	DisplayBoard(Board, ROW, COL);//打印棋盘
	while (1)
	{
		Playmove(Board, ROW, COL);
		DisplayBoard(Board, ROW, COL);
		ret = Is_end(Board, ROW, COL);
		if (ret == '*' || ret == '#' || ret == 'Q')
			break;
		Computermove(Board, ROW, COL);
		DisplayBoard(Board, ROW, COL);
		ret = Is_end(Board, ROW, COL);
		if (ret == '*' || ret == '#' || ret == 'Q')
			break;
	}
	if (ret == '*')
	{
		printf("恭喜您获胜!!!(3秒后返回菜单)\n");
		Sleep(3000);
		system("cls");
	}
	else if (ret == '#')
	{
		printf("电脑获胜(3秒后返回菜单)\n");
		Sleep(3000);
		system("cls");
	}
	else if (ret == 'Q')
	{
		printf("双方平局(3秒后返回菜单)\n");
		Sleep(3000);
		system("cls");
	}
}
void rule()
{
	printf("1.玩家和电脑依次下棋\n");
	printf("2.棋子先有三个相连的一方胜利\n");
	printf("(5秒后返回菜单)");
	Sleep(5000);
	system("cls");
}
void test()
{
	int input;
	srand((unsigned int)time(NULL));
	do
	{
		menu();
		printf("请输入选项:");
	again:
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			game();
			break;
		case 2:
			rule();
			break;
		case 3:
			printf("感谢您的游玩\n");
			break;
		default:
			printf("没有此选项请重新输入:");
			goto again;
			break;
		}
	} while (input != 3);
}
int main()
{
	test();
	return 0;
}
