#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<errno.h>
#include<string.h>
//fopoen fclose fputc fgetc 函数的使用
//int main()
//{   //打开文件
//	FILE* wr = fopen("test.txt", "w");
//	if (wr == NULL)
//		printf("%s", strerror(errno));
//	//写入内容
//	//用fputc 输出内容到文件中 fputc(要输出的内容，文件指针(流)/标准输出流(屏幕stdin)))
//	fputc('b', wr);//一次只能输出一个字符
//	fputc('i', wr);
//	fputc('t', wr);
//	//关闭文件
//	fclose(wr);
//	wr = NULL;
//	//打开文件
//	FILE* re = fopen("test.txt", "r");
//	if(re==NULL)
//		printf("%s", strerror(errno));
//	//读出内容
//	//用fgetc 输入(拿出)内容作为返回值 fgetc(文件指针/标准输入流(键盘stdout))
//	printf("%c",fgetc(re));//一次只能输入一个字符 返回值为int型
//	printf("%c",fgetc(re));
//	printf("%c",fgetc(re));
//	//关闭文件
//	fclose(re);
//	re = NULL;
//	return 0;
//}
//输入(读取一行)函数 fgets    char* fgets(char* string,int n,FILE* stream)
//fgets(输入流的信息将放取的字符串数组，要读取的字符个数，文件指针流)
//fgets返回值为存入读取文件信息的字符串指针

//int main()
//{
//	char arr[10] = { 0 };
//	//打开文件
//	FILE* re = fopen("test.txt", "r");
//	if (re == NULL)
//		printf("%s", strerror(errno));
//	//读取文件
//	printf("%s", fgets(arr, 10, re));//只读一行
//	printf("%s", fgets(arr, 10, re));//每次只把新一行的内容存入数组中
//	//输出字符串函数puts  int puts( const char *string );
//    //puts 函数将字符串输出到屏幕上
//	puts(arr);//输出字符串arr到屏幕上
//	//关闭文件
//	fclose(re);
//	re = NULL;
//	return 0;
//}
//输出(一行)fputs 函数 int fputs( const char *string, FILE *stream )
//fputs(要输出的内容，输出的目的流(文件指针))
//int main()
//{
//	char arr[10] = { 0 };
//	//打开文件
//	FILE* wr = fopen("test.txt", "w");
//	if (wr == NULL)
//		printf("%s", strerror(errno));
//	//写入文件
//	fputs("hello\n", wr);
//	fputs("lili\n", wr);
//	//关闭文件
//	fclose(wr);
//	wr = NULL;
//	return 0;
//}
//int main()
//{
//	char buf[1024] = { 0 };
//	//从标准输入流读取信息
//	fgets(buf, 1024, stdin);
//	//输出到标准输出流中
//	fputs(buf, stdout);
//	//等价于
//	gets(buf);
//	puts(buf);
//	return 0;
//}
//格式化形式输出函数fprintf int fprintf( FILE *stream, const char *format [, argument ]...);
//fprintf(文件指针，输入格式，对应内容)
//格式化形式输入函数fscanf fscanf( FILE *stream, const char *format [, argument ]... );
//fscanf(文件指针，输入格式，文件存入的变量地址)

//struct S
//{
//	int a;
//	float b;
//	char c[5];
//};
//int main()
//{
//	struct S s1 = { 100,3.14,"hell" };
//	//打开文件
//	FILE* wr = fopen("test.txt", "w");
//	if (wr == NULL)
//		printf("%s", strerror(errno));
//	//格式化的形式输出内容到文件
//	fprintf(wr, "%d %f %s", s1.a, s1.b, s1.c);
//	//关闭文件
//	fclose(wr);
//	wr = NULL;
//
//	FILE* re = fopen("test.txt", "r");
//	if (re == NULL)
//		printf("%s", strerror(errno));
//	//格式化的形式输入(获取)文件内容
//	fscanf(re, "%d %f %s", &(s1.a), &(s1.b), s1.c);
//	printf("%d %f %s", s1.a, s1.b, s1.c);
//	//关闭文件
//	fclose(re);
//	re = NULL;
//	return 0;
//}
//struct S
//{
//	int a;
//	float b;
//	char c[5];
//};
//int main()
//{
//	struct S s1 = { 0 };
//	//从标准输入流中获取信息
//	fscanf( stdin, "%d %f %s", &(s1.a), &(s1.b), s1.c);
//    //从标准输出流中显示信息
//	fprintf(stdout, "%d %f %s", s1.a, s1.b, s1.c);
//	return 0;
//}
//从字符串中读取格式化的数据   sscanf函数
//把格式化的数据输出成字符串   sprintf函数
//使用格式和fscanf fprintf相同 作用不同
struct S
{
	int a;
	float b;
	char c[5];
};
int main()
{
	char arr[100] = { 0 };
	struct S s1 = { 100,3.14,"hell" };
	sprintf(arr, "%d %f %s", s1.a, s1.b, s1.c);//将结构体内容输出到字符串数组
	printf("%s\n", arr);
	sscanf(arr, "%d %f %s",&s1.a, &s1.b, &s1.c);//将字符串内容输入到结构体中
	printf("%d %f %s\n", s1.a, s1.b, s1.c);
}
//总结 scanf/printf是针对标准输入流/标准输出流 格式化输入/输出的语句
// fscanf/fprintf 是针对所以输入流/所有输出流的 格式化输入/输出的语句
//sscanf/spritnf 前者是从字符串中(输入)读取格式化的数据 后者是把格式化的数据输出成字符串
