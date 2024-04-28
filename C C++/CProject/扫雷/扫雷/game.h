#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<windows.h>
#define ROW 9
#define COL 9
#define Bomb 10
#define ROWS ROW+2
#define COLS COL+2
void Initboard(char Board[ROWS][COLS], int rows, int cols, char set);
void Displayboard(char Board[ROWS][COLS], int row, int col );
void Setbomb(char mine[ROWS][COLS], int row, int col );
void play_check_chess(char mine[ROWS][COLS], char show[ROWS][COLS], int row, int col);
void findbomb(char mine[ROWS][COLS], char show[ROWS][COLS], int x, int y);
int resetbomb(char show[ROWS][COLS], int row, int col);
