#define _CRT_SECURE_NO_WARNINGS 1
#include"game.h"
void InitBoard(char Board[ROW][COL], int row, int col)
{
	int i, n;
	for (i = 0; i < row; i++)
	{
		for (n = 0; n < col; n++)
		{
			Board[i][n] = ' ';
		}
	}
}
void DisplayBoard(char Board[ROW][COL], int row, int col)
{
	int i, n;
	for (i = 0; i < row; i++)
	{
		for (n = 0; n < col; n++)
		{
			if (n < col - 1)
				printf(" %c |", Board[i][n]);
			else
				printf(" %c \n", Board[i][n]);
		}
		if (i < row - 1)
		{
			for (n = 0; n < col; n++)
			{
				if (n < col - 1)
					printf("---|");
				else
					printf("---\n");
			}
		}
	}
}
void Playmove(char Board[ROW][COL], int row, int col)
{
	int x, y;
	printf("现在轮到您下棋\n");
	while (1)
	{
		printf("请输入坐标:");
		scanf("%d%d", &x, &y);
		if (x >= 1 && x <= row && y >= 1 && y <= col)
		{
			if (Board[x - 1][y - 1] == ' ')
			{
				Board[x - 1][y - 1] = '*';
				break;
			}
			else
				printf("该坐标被占用，请重新输入\n");
		}
		else
			printf("坐标非法，请重新输入\n");
	}
}
void Computermove(char Board[ROW][COL], int row, int col)
{
	printf("现在轮到电脑下棋\n");
	Sleep(1000);
	while (1)
	{
		int x = rand() % row;
		int y = rand() % col;
		if (Board[x][y] == ' ')
		{
			Board[x][y] = '#';
			break;
		}
	}
}
char Is_end(char Board[ROW][COL], int row, int col)
{
	int i, n;
	for (i = 0; i < row; i++)//行相等
	{
		for (n = 0; n < col; n++)
		{
			if (Board[i][0] != Board[i][n])
				break;
		}
		if (n == col && Board[i][0] != ' ')
			return Board[i][0];
	}
	for (n = 0; n < col; n++)//列相等
	{
		for (i = 0; i < row; i++)
		{
			if (Board[0][n] != Board[i][n])
				break;
		}
		if (i == row && Board[0][n] != ' ')
			return Board[0][n];
	}
	for (i = 0; i < row; i++)//右斜下相等
	{
		if (Board[0][0] != Board[i][i])
			break;
	}
	if (i == row && Board[0][0] != ' ')
		return Board[0][0];
	for (i = 1, n = col - 2; n >= 0; i++, n--)//左斜下相等
	{
		if (Board[0][col - 1] != Board[i][n])
			break;
	}
	if (n == -1 && Board[0][col - 1] != ' ')
		return Board[0][col - 1];
	for (i = 0; i < row; i++)//平局
	{
		for (n = 0; n < col; n++)
		{
			if (Board[i][n] == ' ')
				goto qu;
		}
	}
qu:
	if (i == row)
		return 'Q';
}