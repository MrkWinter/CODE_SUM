#include <stdio.h>
#include <stdlib.h>
#include "matrix.h"

Matrix* init(int row ,int column)
{
      Matrix* m=(Matrix*)malloc(sizeof(Matrix));
      m->row=row;
      m->column=column;
      m->base=(int*)malloc((row*column)*sizeof(int)) ;
      return m;
}
int getValue(Matrix* m,int i,int j)
{
	return m->base[i*m->column+j];
} 
void putValue(Matrix* m,int i,int j, int value)
{
	m->base[i*m->column+j]=value;
}
Matrix* rand_int(int row,int column)
{
      Matrix* m=(Matrix*)malloc(sizeof(Matrix));
      m->row=row;
      m->column=column;
      m->base=(int*)malloc((row*column)*sizeof(int)) ;
      int* q=m->base;
      for(int i=0;i<row*column;i++)
      {
       	q[i]=rand()%10+1;
	  }
      return m;
}
void print_matrix(Matrix* m)
{
     int row=m->row;
     int column=m->column;
      for(int i=0;i<row;i++)
      {
            for(int j=0;j<column;j++)
            {
                 printf("%3d ",getValue(m,i,j));
            }
            printf("\n");
       }
}
Matrix* add_matrix(Matrix* m1,Matrix* m2)
{
	  int row=m1->row;
	  int column=m1->column;
      Matrix* m3=(Matrix*)malloc(sizeof(Matrix));
      m3->row=row;
      m3->column=column;
      m3->base=(int*)malloc((row*column)*sizeof(int)) ;
      int* q=m3->base;
       for(int i=0;i<row;i++)
       {
            for(int j=0;j<column;j++)
            {
                 //q[i*column+j]=m1->base[i*column+j]+m2->base[i*column+j];
                int  s=getValue(m1,i,j)+getValue(m2,i,j);
                putValue(m3,i,j,s);
            }
            
       }
      
       return m3;
}
Matrix* multipy_matrix(Matrix* m1,Matrix* m2)
{
	
      int row=m1->row;
      int column=m2->column;
	
	  Matrix* m3=(Matrix*)malloc(sizeof(Matrix));
      m3->row=row;
      m3->column=column;
      m3->base=(int*)malloc((row*column)*sizeof(int)) ;
	
	  int s=0;
	  for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				s=0;
				for(int k = 0; k < m1->column; k++){
				  // s+= m1->base[i*m1->column+k]* m2->base[k*m2->column+j];
				  s+=getValue(m1,i,k)*getValue(m2,k,j)
				}
				//m3->base[i*column+j]=s;
				putValue(m3,i,j)=s;
			}
		}
	  return m3;

}

void reshape(Matrix* m,int newrow,int newcolumn)
{

}

Matrix* read_file(char* path)
{
	
}
void  write_file(Matrix* m,char* path)
{
	
}

