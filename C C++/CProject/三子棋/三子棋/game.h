#define _CRT_SECURE_NO_WARNINGS 1
#include<windows.h>//所需头文件的集合
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#define ROW 3//行列定义
#define COL 3
void InitBoard(char Board[ROW][COL], int row, int col);//函数声明
void DisplayBoard(char Board[ROW][COL], int row, int col);
void Playmove(char Board[ROW][COL], int row, int col);
void Computermove(char Board[ROW][COL], int row, int col);
char Is_end(char Board[ROW][COL], int row, int col);