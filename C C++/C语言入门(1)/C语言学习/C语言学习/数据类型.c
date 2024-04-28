#include<stdio.h>

/*
char  字符类型  //printf("%c\n")打印字符数据 a等
short 短整型 //printf("%d"\n")打印短整型 20等
int  整型  //printf("%d\n")打印整型  200000等
long 长整型//printf("%d\n") 20000000等
long long 长长整型//printf("d\n")2000000000000等
float 单精度浮点数//printf("%f\n")打印浮点数  小数点5个小数
double 双精度浮点数//printf("%lf")打印双精度浮点数  小数点
*/


/*
计算机中单位
bit 比特位                  二进制算法表示数
byte 字节 8 bit             一比特位等于一个二进制数
kb     1024 byte            一字节等于8比特位   1111111111111111 共能表示2^8-1个数字
mb     1024 kb
gb     1024 mb
tb     1024 gb
pb     1024 tb
*/


int main()
{

	char ch = 'A';
		printf("%c\n", ch);//%c 打印字符格式数据
		 
		int age = 20;
		printf("%d\n", age);//打印整型十进制数据
	
		
		float f = 5.0;

		printf("%f\n", f);


		double d = 3.14;

		printf("%lf\n", d);
		
		printf("字符类型申请的内存空间为:%d\n", sizeof(char));//1  2^8-1个数
		printf("短整型申请的内存空间为:%d\n", sizeof(short));//2  2^16-1个数
		printf("整型申请的内存空间为:%d\n", sizeof(int));//4
		printf("长整型类型申请的内存空间为:%d\n", sizeof(long));//4
		printf("长长整型申请的内存空间为:%d\n", sizeof(long long));//8
		printf("单精度浮点数申请的内存空间为:%d\n", sizeof(float));//4
		printf("双精度浮点数申请的内存空间为:%d\n", sizeof(double));//8
		return 0;



}