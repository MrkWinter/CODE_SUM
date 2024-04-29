#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
//�������������� ͨ��malloc������̬����һ����ά���� ��rand������ʼ�� ��Χ[-5~5]����ת�� ����ͬ��һ���������
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
	mat->arr = (int**)malloc(sizeof(int*)*row);//ָ������
	for (int i = 0; i < col; i++)//�����ַ������ٲ������������ϵĶ�ά���� ������ÿһ�е�ַ������
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
	Print(mat2); //mat2��matת�ú�ľ���
	putchar('\n');
	
	matrix* mat3 = (matrix*)malloc(sizeof(matrix));
	Inital(mat3, row, col);
	Print(mat3);
	matrix* mat4 = (matrix*)malloc(sizeof(matrix));
	Inital(mat4, row, col);
	matrixadd(mat4, mat3,mat); //mat4 ��mat3 ��mat ��Ӻ�Ľ��
	Print(mat4);
	
	 del(mat);
	 del(mat2);
	 del(mat3);
	 del(mat4);
	//Print(mat);
	return 0;
}