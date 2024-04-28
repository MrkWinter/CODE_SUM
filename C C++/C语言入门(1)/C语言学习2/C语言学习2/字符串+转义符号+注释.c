#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<string.h>

int main()
{
	//数据在计算机上存储的时候，存储的是二进制
	//给每一个字符编码的方式叫ASCII编码
	char arr1[4] = "abc";//将字符串abc存入创建的数组arr1中
	char arr2[] = { 'a','b','c','\0' };//字符串用""括起来，字符用{''}括起来
                                    //char数据类型 字符型
	                                //打印字符串时候默认字符串最后有0作为结束标志
	                                //打印字符时候需要在字符末尾添加0作为结束标志，否则会打出其他随机值
	printf("%s\n", arr1);
	printf("%s\n", arr2);
	
	printf("%d\n", strlen(arr1));//求字符串长度
	printf("%d\n", strlen(arr2));//加'\0'字符长度是3正确的，不加会使计算一直延后，直到找到0为止，所以字符长度为随机值


	   //转义字符
	printf("abc\n");//\n为转义字符，义为换行
	printf("E:\test\vs项目\\c语言项目2.c\n");//    \t为水平制表符，表示一个TAB	距离的长度，为转义字符
	printf("E:\\test\\vs项目\\c语言项目2.c\n");//   \\为防转义转义符 此处防转义了\t与\v
	printf("\"\n");//同理\"为防转义
	printf("%c\n", '\'\n');//同理\'为防转义
	printf("%d\n", strlen("c:\test\32\test.c"));//打印字符串中字符数:13,原因:\t,\32都为一字符
	                         // \32——意义32为一个8进制数字代表的十进制数字作为ASCII的码值对应的字符，\32为一个转义字符，形式为\ddd(d为数字)
	printf("%c\n", '\x61');//  \x61是一个转义字符，意为61为一个16进制数字转化为十进制数字作为ASCII码值对应的字符，形式为\xdd(d为数字)

	
	//注释：/* */缺陷不能套娃
	

	 return 0;
}