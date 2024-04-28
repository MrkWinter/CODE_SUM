#define _CRT_SECURE_NO_WARNINGS 1
#include"game.h"
void menu()
{
	printf("**********************************\n");
	printf("***** 1.play  2.rule  3.exit *****\n");
	printf("**********************************\n");

}
void rule()
{
	system("cls");

	printf("1.玩家输入行和列的坐标进行排雷\n");
	printf("2.若该坐标无雷，则显示相邻坐标雷的总数\n");
	printf("3.若该坐标为雷，则游戏失败\n");
	printf("4.将所有雷排完即可获得游戏胜利\n");
	printf("(12秒后返回菜单)");
	Sleep(12000);
	system("cls");
}
void game()
{
	system("cls");
	printf("本局雷数:%d\n", Bomb);
	char mine[ROWS][COLS] = { 0 };//定义含雷盘
	char show[ROWS][COLS] = { 0 };//定义展示盘
	Initboard(mine, ROWS, COLS,' ');//初始化含雷盘
	Initboard(show, ROWS, COLS,'*');//初始化展示盘
	Setbomb(mine, ROW, COL);//步置雷盘上的雷
	Displayboard(show, ROW, COL);//打印展示盘
	play_check_chess(mine, show, ROW, COL);//排雷
}
void test()
{
	int input;
	char arr[] = { 0 };
	do
	{
		srand((unsigned int)time(NULL));
		menu();
		printf("请选择选项:");
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
			printf("感谢您的游玩");
			break;
		default:
			printf("无该选项，请重新选择:");
			gets(arr);
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