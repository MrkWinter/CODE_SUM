#define _CRT_SECURE_NO_WARNINGS 1
#include "function.h"
void Inital(int arr[ROW][COL])
{
	for (int i = 0; i < ROW; i++)
	{
		for (int j = 0; j < COL; j++)
		{
			arr[i][j] = rand() % SPAN + 1;
		}
	}
	return;
}
void Printfarr(int arr[ROW][COL])
{
	for (int i = 0; i < ROW; i++)
	{
		for (int j = 0; j < COL; j++)
		{
			printf("%d\t", arr[i][j]);
		}
		putchar('\n');
	}
}
int CalculateRowSum(int arr[ROW][COL], int n)
{
	if (n <= 0 || n > ROW) {
		printf("行数应在%d到%d间，默认返回0\n", 1, ROW);
		return 0;
	}
	int sum = arr[n-1][0];
	for (int i = 1; i < COL; i++)
	{
		sum += arr[n - 1][i];
	}
	return sum;
}
int CalculateDiagonalSum(int arr[ROW][COL], int n)
{
	if (ROW != COL)
	{
		printf("该二维数组无对角线,默认返回0\n");
		return 0;
	}
	int sum;
	if (n == 0)
	{
		sum = arr[0][0];
		for (int i = 1, j = 1; i < COL; i++, j++)
		{
			sum += arr[i][j];
		}
	}
	else if(n == 1)
	{
		sum = arr[0][COL - 1];
		for (int i = 1, j = COL - 2; i < ROW; i++, j--)
		{
			sum += arr[i][j];
		}
	}
	else
	{
		printf("函数第二参数为0或1，默认返回0\n");
		return 0;
	}
	return sum;
}
int CalculateTrangleSun(int arr[ROW][COL], int n)
{
	if (ROW != COL) {
		printf("该二维数组无对角线,默认返回0\n");
		return 0;
	}
	int sum;
	if (n == 0)
	{
		sum = arr[0][0];
		for (int i = 0; i < ROW; i++)
		{
			for (int j = 0; j < COL - i; j++)
			{
				sum += arr[i][j];
			}
		}
		sum -= arr[0][0];
	}
	else if (n == 1)
	{
		sum = arr[0][COL - 1];
		for (int i = 0; i < ROW; i++)
		{
			for (int j = COL - 1; j >= i; j--)
			{
				sum += arr[i][j];
			}
		}
		sum -= arr[0][COL - 1];
	}
	else
	{
		printf("函数第二参数为0或1，默认返回0\n");
		return 0;
	}
	return sum;
}