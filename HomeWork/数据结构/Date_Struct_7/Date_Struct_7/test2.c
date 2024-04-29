#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
//输入行数和列数 通过malloc函数动态开辟一个二维数组 用rand函数初始化 范围[-5~5]求其转置 生成同样一个矩阵求和
typedef struct matrix
{
	int** arr;
	int row;
	int col;
}matrix;
void Inital(matrix* mat, int row, int col)
{
	mat->row = row;
	mat->col = col;
	mat->arr = (int**)malloc(sizeof(int*)*row);//指针数组
	for (int i = 0; i < col; i++)//但这种方法开辟不是真正意义上的二维数组 数组中每一行地址不连续
	{
		mat->arr[i] = (int*)malloc(sizeof(int)*col);
	}
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			mat->arr[i][j] = rand() % 2 == 1 ? rand() % 5 + 1 : -(rand() % 5 + 1);
		}
	}

}
void Print(matrix* mat)
{
	for (int i = 0; i < mat->row; i++)
	{
		for (int j = 0; j <mat->col; j++)
		{
			printf("%3d", mat->arr[i][j]);
		}
		putchar('\n');
	}
}
void Transposition(matrix* mat2,matrix* mat)
{
	for (int i = 0; i < mat->row; i++)
	{
		for (int j = 0; j < mat->col; j++)
		{
			mat2->arr[j][i] = mat->arr[i][j];
		}
	}
}
void del(matrix* mat)
{
	for (int i = 0; i < mat->row; i++)
	{
		free(mat->arr[i]);
	}
}
void matrixadd(matrix* mat4, matrix* mat3, matrix* mat)
{
	for (int i = 0; i < mat->row; i++)
	{
		for (int j = 0; j < mat->col; j++)
		{
			mat4->arr[i][j] = mat->arr[i][j] + mat3->arr[i][j];
		}
	}
}
int main()
{//
	srand((unsigned int)time(NULL));
	int row, col;
	scanf("%d%d", &row, &col);

	matrix* mat = (matrix*)malloc(sizeof(matrix));
	Inital(mat, row, col);
	Print(mat);
	putchar('\n');

	matrix* mat2 = (matrix*)malloc(sizeof(matrix));
	Inital(mat2, col, row);
	Transposition(mat2,mat);
	Print(mat2); //mat2是mat转置后的矩阵
	putchar('\n');
	
	matrix* mat3 = (matrix*)malloc(sizeof(matrix));
	Inital(mat3, row, col);
	Print(mat3);
	matrix* mat4 = (matrix*)malloc(sizeof(matrix));
	Inital(mat4, row, col);
	matrixadd(mat4, mat3,mat); //mat4 是mat3 和mat 相加后的结果
	Print(mat4);
	
	 del(mat);
	 del(mat2);
	 del(mat3);
	 del(mat4);
	//Print(mat);
	return 0;
}