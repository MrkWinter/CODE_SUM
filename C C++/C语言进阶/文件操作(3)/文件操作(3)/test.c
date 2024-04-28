#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
#include<errno.h>
//以二进制的形式输出(写)fwrite函数size_t fwrite( void *buffer, size_t size, size_t count, FILE *stream );
//fwrite(要输出数据的变量的地址，输出数据的元素大小，输出数据的元素个数，输出数据的文件指针)
//以二进制的形式输入(读)fread函数 size_t fread( void *buffer, size_t size, size_t count, FILE *stream );
//fread(读出数据存放的变量的地址，输入数据的元素大小，输入数据的元素个数，输入数据的文件指针)
//struct S
//{
//	char name[10];
//	int age;
//	float socre;
//};
//
//int main()
//{
//	struct S s1 = { "zhangsan",18,59.9 };
//	struct S s2 = { 0 };
//	char buf[100] = { 0 };
//	FILE* wr = fopen("test.txt", "wb");//wb是以二进制的形式写入
//	if (wr == NULL)
//		return 0;
//	fwrite(&s1, sizeof(s1), 1, wr);
//	fclose(wr);
//	wr = NULL;
//	FILE* re = fopen("test.txt", "rb");//rb是以二进制的形式读出
//	if (re == NULL)
//		return 0;
//	fread(&s2, sizeof(s2), 1, re);
//	printf("%s %d %.2f", s2.name, s2.age, s2.socre);
//	fclose(re);
//	re = NULL;
//	return 0;
//}
//总结：文件的顺序读写函数有
//fputc fgetc fputs fgets fprintf fscanf spritf sscanf fwrite fread 等
//下面来介绍文件的随机读写
//fseek int fseek( FILE *stream, long offset, int origin );
//定位文件指针 fseek(文件指针，文件指针偏移量，文件指针偏移的起始位置) 
//起始位置有三种 SEEK_CUR(当前位置)   SEEK_END(末尾位置)末尾位置为最后文本的后面  SEEK_SET(起始位置)
//int main()
//{
//	FILE* read = fopen("test.txt", "r");
//	if (read == NULL)
//		return 0;
//	fseek(read, -1, SEEK_END);//定位文件指针位置为f
//	int ret = fgetc(read);
//	printf("%c", ret);
//	fclose(read);
//	read = NULL;
//	return 0;
//}
// ftell long ftell( FILE *stream );
//返回文件(位置)指针相当于起始位置的偏移量 ftell(文件指针)
//rewind void rewind( FILE *stream );
//将文件指针返回起始位置
//int main()
//{
//	FILE* read = fopen("test.txt", "r");
//	if (read == NULL)
//		return 0;
//	fseek(read, -1, SEEK_END);//定位文件指针位置为f
//	int ret = fgetc(read);//每读一个向后偏移一位
//	printf("%c\n", ret);
//	printf("%d\n",(int)ftell(read));//偏移量为6
//	rewind(read);//返回起始位置
//	printf("%d\n", (int)ftell(read));//偏移量为0
//	fclose(read);
//	read = NULL;
//	return 0;
//}
//判断文件出错原因函数 ferror (feof) 
//ferror(文件指针) 读取失败结束 返回非0值有错误)
//读取文件末尾EOF结束 返回值为0 (无错误) EOF —— end of file 文件结尾 值为-1
//feof(文件指针) 读取文件末尾EOF 返回值为非0值 (无错误)
//返回值为0 (有错误)
//ferror判断是有错误的  feor判断是无错误的
//文件读取正常结束标志
//fegetc 返回值为EOF
//fegets 返回值为空指针
//fread 返回值小于实际要读的数
//int main()
//{
//	FILE* pf = fopen("test.txt", "r");
//	if (pf == NULL)
//	{//perror函数可打印自定义错误信息提示 并且在后加上错误信息
//		//相当于 printf("open the file2: %s",strerror(errno));
//		//相对来说更简洁方便
//		perror("open the file2");
//		return 0;
//	}
//	int ch=0;
//	while ((ch = fgetc(pf)) != EOF)//直到输出文件末尾或错误跳出循环
//	{
//		putchar(ch);
//	}
//	if (ferror(pf))//返回非0值存在错误
//		printf("error\n");
//	else if (feof(pf))//返回非0值不存在错误
//		printf("end of file\n");
//	fclose(pf);
//	pf = NULL;
//	return 0;
//}