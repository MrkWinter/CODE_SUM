#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
void Inital1(int (*arr)[4],int row,int col)
{
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			arr[i][j] = rand() % 2 == 1 ? rand() % 5 + 1 : -(rand() % 5 + 1);
		}
	}
}
void Inital2(int(*arr)[2], int row, int col)
{
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			arr[i][j] = rand() % 2 == 1 ? rand() % 5 + 1 : -(rand() % 5 + 1);
		}
	}
}
void multiply(int c[3][2], int a[3][4], int b[4][2], int rowandcol, int firstrow, int secondcol)
{
	int i, j, k;
	for (i = 0; i < firstrow; i++)//从第i行开始
	{
		for (j = 0; j < secondcol; j++)//从第j列开始
		{
			for (k = 0; k < rowandcol; k++)//i行元素和j列元素相乘，结果累加
			{
				c[i][j] +=  a[i][k] * b[k][j];
			}
		}
	}
}

void Print1(int a[3][4], int row, int col)
{
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			printf("%3d", a[i][j]);
		}
		putchar('\n');
	}
}
void Print2(int a[4][2], int row, int col)
{
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			printf("%3d", a[i][j]);
		}
		putchar('\n');
	}
}
void Print3(int a[3][2], int row, int col)
{
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			printf("%3d", a[i][j]);
		}
		putchar('\n');
	}
}
int main()
{
	srand((unsigned int)time(NULL));
	int a[3][4];
	int b[4][2];
	int c[3][2] = {0};
	Inital1(a, 3, 4);
	Print1(a, 3, 4);
	putchar('\n');

	Inital2(b, 4, 2);
	Print2(b, 4, 2);
	putchar('\n');

	multiply(c, a, b,4,3,2); //c = a+ b
	Print3(c,3,2);

	//printf(c, 2, 3);
}