#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//位段的定义
struct A
{
	int a : 2;//2指的是占2个bit
	int b : 5;
	int c : 10;
	int d : 30;//位域大小小于等于32
};
int main()
{
	struct A s1;
	printf("%d", sizeof(s1));//8
	return 0;
	//位段的使用是为了节省空间
}
//vs位段的储存方式
//位段中的元素为int或char型
//位段元素储存时先开辟4(int)/1(char等)个字节 再从右向左使用空间 若空间不够 则开辟新的空间
//位段可以在一个字节中存储多个数据，减少空间的浪费
//位段有不跨平台性
//运用 网络数据包的使用 节省空间