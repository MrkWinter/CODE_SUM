#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
#include "matrix.h"

int main(int argc, char** argv) {
	   int row;
       int column;
       printf("��������������\n");
       scanf("%d %d",&row,&column);
       Matrix* m1=rand_int(row,column);
       print_matrix(m1);
       printf("��������������\n");
       scanf("%d %d",&row,&column);
       Matrix* m2=rand_int(row,column);
       print_matrix(m2);
       //printf("����ĺ�\n"); 
       //Matrix* m3=add_matrix(m1,m2);
       //print_matrix(m3);
       printf("����ĺ�\n");
       Matrix* m4=add_matrix(m1,m2);
       print_matrix(m4);
	   return 0;
}
