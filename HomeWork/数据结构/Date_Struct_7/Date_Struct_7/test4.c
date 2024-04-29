#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
void Inital(int* arr)
{
	for (int i = 0; i < 1000; i++)
	{
		int temp;
		while (1)
		{
			temp = rand() % 30;
			if (temp >= 10 && temp < 30)
				break;
		}
		arr[i] = temp;
	}
}
void Printf(int* arr)
{
	for (int i = 0; i < 1000; i++)
	{
		printf("%-3d", arr[i]);
	}
}
void countarrInteger(int* arrcount, int* arr)
{
	int temp;
	for (int i = 0; i < 1000; i++)
	{
		temp = arr[i];
		arrcount[temp - 10] += 1;
	}
}
void countarrInteger2(int* arrcount2, int* arr)
{
	int temp;
	for (int i = 0; i < 1000; i++)
	{
		temp = arr[i];
		arrcount2[temp / 5 - 2] += 1;
	}
}
int main()
{
	srand((unsigned int)time(NULL));
	int arr[1000] = { 0 };
	int arrcount[20] = { 0 };
	int arrcount2[4] = { 0,0,0,0 };
	Inital(arr);
	Printf(arr);

	countarrInteger(arrcount, arr);
	for (int i = 0; i < 20; i++)
	{
		printf("数字%-2d有%-2d个\n", i + 10, arrcount[i]);
	}
	countarrInteger2(arrcount2, arr);

	for (int i = 0; i < 4; i++)
	{
		printf("[%d~%d)有%d个\n", (i + 2) * 5, (i + 2) * 5 + 5, arrcount2[i]);
	}
	return 0;
}