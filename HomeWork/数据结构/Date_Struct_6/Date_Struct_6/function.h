#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<time.h>
#include<stdlib.h>
#define ROW 5
#define COL 5
#define SPAN 100
void Inital(int arr[ROW][COL]);
void Printfarr(int arr[ROW][COL]);
int CalculateRowSum(int arr[ROW][COL],int n);
int CalculateDiagonalSum(int arr[ROW][COL],int n);
int CalculateTrangleSun(int arr[ROW][COL],int n);