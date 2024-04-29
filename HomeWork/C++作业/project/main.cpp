#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
#include "matrix.h"

int main(int argc, char** argv) {
	   int row;
       int column;
       printf("输入行数和列数\n");
       scanf("%d %d",&row,&column);
       Matrix* m1=rand_int(row,column);
       print_matrix(m1);
       printf("输入行数和列数\n");
       scanf("%d %d",&row,&column);
       Matrix* m2=rand_int(row,column);
       print_matrix(m2);
       //printf("矩阵的和\n"); 
       //Matrix* m3=add_matrix(m1,m2);
       //print_matrix(m3);
       printf("矩阵的和\n");
       Matrix* m4=add_matrix(m1,m2);
       print_matrix(m4);
	   return 0;
}
