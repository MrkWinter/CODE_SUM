#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
//输入行数和列数 通过malloc函数动态开辟一个二维数组 用rand函数初始化 范围[-5~5]求其转置 生成同样一个矩阵求和

typedef struct matrix
{
	int* arr;
	int row;
	int col;
}matrix;
void Inital(matrix* mat,int row,int col)
{
	mat->arr = (int*)malloc(sizeof(int)*row*col);
	mat->row = row;
	mat->col = col;
	for (int i = 0; i < row*col; i++)
	{
		if (rand() % 2 == 1)
		{
			mat->arr[i] = rand() % 5 + 1;
		}
		else
		{
			mat->arr[i] = -(rand() % 5 + 1);
		}
	}
}
void Print(matrix* mat)
{
	for (int i = 0; i < mat->row* mat->col; i++)
	{
		if (i%mat->col == 0 && i != 0)
			putchar('\n');
		printf("%3d ",mat->arr[i]);
	}
}
void Transposition(matrix* mat)
{

}
int main()
{
	srand((unsigned int)time(NULL));
	int row, col;
	scanf("%d%d", &row, &col);
	matrix* mat = (matrix*)malloc(sizeof(matrix));
	Inital(mat,row,col);
	Transposition(mat);
	Print(mat);
	return 0;
}