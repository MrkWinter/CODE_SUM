struct Matrix
{
      int row;
      int column;
      int* base;
};
void print_marix(Matrix* m);
Matrix* rand_int(int row,int column);
void print_matrix(Matrix* m);
Matrix* add_matrix(Matrix* m1,Matrix* m2);
Matrix* multipy_matrix(Matrix* m1,Matrix* m2);
void reshape(Matrix* m,int newrow,int newcolumn);
Matrix* read_file(char* path);
void  write_file(Matrix* m,char* path);
int getValue(Matrix* m,int i,int j);
void putValue(Matrix* m,int i,int j, int value);
