#define _CRT_SECURE_NO_WARNINGS 1
//#include<stdio.h>
//int main()
//{
//	int numb1, numb2, max;
//	numb1 = 3;
//	numb2 = 4;
//	max = MAX(numb1, numb2);//()函数调用操作符
//	printf("%d\n", max);
//
//	return 0;
//}
//int MAX(int x, int y)
//{
//	int z;
//	if (x > y)
//		z = x;
//	else
//		z = y;
//	return z;
#include<stdio.h>

//int main()
//{
//	int a = 19;
//	int arr[] = { 1,2,3,4,5,6 };
//	printf("%d\n", sizeof(int));
//	printf("%d\n", sizeof(arr));
//	printf("%d\n", sizeof(arr) / sizeof(arr[0]));
//	return 0;
//}


//#include<stdio.h>
//int main()
//{
//	int a = 0;//4个字节，32个bit位
//	//a 000000000000000000000000   
//	int b = ~a;//按(二进制取反)位取反
//	//b 111111111111111111111111
////原码，反码，补码
//	//111111111111111111111111补码
//	//111111111111111111111110反码
//	//100000000000000000000001原码 
//
//	//负数在二进制储存的时候储存的是二进制补码 输出是原码
//
//	printf("%d\n", b);
//
//
//	return 0;
//}
//#include<stdio.h>
//int main()
//{ int r = (int)3.14  int 整型强制类型转换  原先是double单精度浮点型
//	int a = 10;
//	int b = a++;//先使用，后++
//	int c = ++a;//先++，后使用
//	printf("%d\n%d\n%d\n", a, b, c);
//	return 0;
//}
//#include<stdio.h>
//int main()
//{
//	//!=不相等
//	//&&逻辑与 并且
//	//||逻辑或 或
//
//	int a = 0;
//	int b = 3;
//	int c = a && b;//表示真
//	int v = a || b;
//	printf("%d\n", c);
//	printf("%d\n", v);
//	return 0;
//}
#include<stdio.h>
int main()
{
	int arr[10] = { 0 };//[]下表引用操作符
	int a, b, max;
	scanf("%d%d",&a,&b);
	max = (a > b ? a : b);//三目操作符/条件操作符
	printf("%d\n", max);


	return 0;
}
















