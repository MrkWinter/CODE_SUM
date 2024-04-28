#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
#include<errno.h>
//文件类型分为文本文件和二进制文件

//文本文件存储的是8位二进制的ASCII码值 也就是说打开文本工具时，会每8位读取内容，然后展示结果就是由assic码表编译过的产生的字符文件，可直接观看
//二进制文件就是直接二进制的形式存储的文件，打开后无法观看
//文本文件存储的是字符
//二进制文件存储的是二进制数字
//文件缓存区 输出缓存区  输入缓存区
//程序内存和硬盘间

//打开文件函数 fopen
//FILE* fopen(char* flilenname, char *mode);
//fopen(文件名，文件打开模式)
//文件名可用绝对路径和相对路径来表示，打开模式表示打开的方式
//函数返回的是一个FILE* 类型的结构体指针
//详解 
//当打开文件时系统会自动根据文件内存生成一个文件信息区 
//文件信息区是FILE型的结构体，里面填充了各种文件相关信息
//函数fopen返回的是文件信息区的起始地址
//可根据返回的地址操作文件信息区 达到操作文件的目的
//关闭文件函数 fclose
//fclose(FILE* stream)
//fclose(打开文件产生的指针) 
//通过指针找到文件信息区 释放文件信息区的内存
//最后应把指针置成空指针
//int main()
//{
//	FILE* p = fopen("test.txt", "r"); //若打开成功 返回文件信息区地址 失败 返回空指针'w'为写 无则创建一个新文件 若有 写的形式会把原来的文件内存销毁掉 变成一个新文件
//	if (p == NULL)
//	{
//		printf("%s", strerror(errno));
//	}
//	else
//	{
//		fclose(p);
//		p = NULL;
//	}
//	return 0;
//}
//字符输出函数 fputc(内容，FILE* stream) 适用于所有输出流  输出——》什么 存
//字符输入函数 int fgetc(FILE* stream)  适用于所有输入流
//int main()
//{//打开文件可写
//	FILE* write = fopen("test.txt", "w");
//	if (write == NULL)
//	{
//		printf("%s", strerror(errno));
//		return 0;
//	}
//	//
//	fputc('b',write );
//	fputc('i',write);
//	fputc('t',write );
//	//关闭文件
//	fclose(write);
//	write = NULL;
//	return 0;
//}
//int main()
//{
//	//打开文件可读
//	FILE* read = fopen("test.txt", "r");
//	if (read == NULL)
//	{
//		printf("%s", strerror(errno));
//		return 0;
//	}
//	//
//	printf("%c", fgetc(read));
//	printf("%c", fgetc(read));
//	printf("%c", fgetc(read));
//	//关闭文件
//	fclose(read);
//	read = NULL;
//	return 0;
//}
//从键盘输入
//输出到屏幕
//键盘和屏幕都是外部设备
//键盘 标准输入设备 stdin
//屏幕 标准输出设备 stdout
//两个是 一个程序默认打开的两个设备
//stdin FILE*
//stdout FILE*
//stderr  FILE*
//int main()
//{
//	int ch = fgetc(stdin); //fgetc 适用于所有输入流
//	fputc(ch, stdout); //fputc适用于所以输出流
//
//}
//总结 fput 是输出 （ 输出内容 ， 输出目标）
//fgetc 是输入（） 函数返回值为输入目标 
