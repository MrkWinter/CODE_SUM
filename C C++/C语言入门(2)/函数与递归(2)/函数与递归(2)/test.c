#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//#include"add.h"
//int main()
//{
//	int a = 94;
//	int b = 34;
//	int sum = add(a, b);//自定义函数的标准形式,头文件中声明，源文件定义，main函数中调用
//	printf("%d", sum);
//	return 0;
//}
//函数的递归--
//函数自己调用自己               //在内存中有栈区（局部变量，函数形参） 、堆区（动态开辟的内存，malloc，calloc）
//int main()                       //静态区（全局变量，static修饰的变量）
//{
//	printf("hehe");
//	main();//最简单的递归     //函数调用在栈区调用空间，一直调用会导致栈区溢出而报错
//	return 0;
//}
//当输入1234时用递归在屏幕上打印1 2 3 4 
//void print(int n)//假设传给形参n为123
//{
//	if (n > 9)      //第一次循环调用print（123/10），结束函数调用后打印3
//	{               //第二次循环调用print（12/10），结束函数循环调用后打印2
//		print(n / 10);//第三次循环n<9不调用print函数，打印1—>返回第二次循环函数位置print（12/10），接着打印2
//	}                 //->返回第一次循环调用的函数位置print（123/10），接着打印3
//	printf("%d ", n % 10);//综上完成用递归对1 2 3的打印
//}
//int main()     //递归时要限制条件，每次递归后越来越靠近条件
//{
//	unsigned int a;
//	printf("请输入一个数>:");
//	scanf("%d", &a);
//	print(a);//定义依次打印函数数字的
//	return 0;
//}
//写一个函数求字符串长度(模拟strlen)
#include<string.h>
//int my_strlen(char* str)//用指针变量来接收数组arr传来的第一个字符的地址
//{
//	int count =0;
//	while (*str != '\0')
//	{
//		count++;
//		str++;//一个字符串数组中的字符地址是连续的
//	}
//	return count;
//}
//int main()
//{
//	char arr[] = "bit";
//	int len = my_strlen(arr);//数组arr传参时，只传第一个字符的地址
//	printf("%d\n",len);
//	return 0;
//}
//不使用临时变量来实现strlen函数
//递归方法求"bit"长度  //1+my_strlen("it")--->1+my_strlen("str+1")//这里指str+1的是"b"的地址+1，即数组中第2个元素的地址"i"
//->求1+"it"长度       //1+1+my_strlen("t") --->1+1+my_strlen("str+1+1")这里指str+2的是"i"的地址+1，即数组中第3个元素的地址"t"
//->求1+1+"t"长度      //1+1+1+my_strlen("\0")--->1+1+1+my_strlen(str+1+1+1)这里指str+3的是"t"的地址+1，即数组中第4个元素的地址"\0"
//->求1+1+1+"\0"长度
//大事化小小事化了，递归一定要找到递归的条件，并且每次递归都会向条件靠近
int my_strlen(char* str)
{
	if (*str != '\0')
		return 1 + my_strlen(str + 1);//递归方法求字符串长度
	else                              //这里递归三次，为1"bit"+(1"it"+(1"t"+(0"\0")))=3
		return 0;                     //                        一次   两次  三次
}
int main()
{
	char arr[] = "bit";
	int len = my_strlen(arr);//最后返回字符串长度
	printf("%d\n", len);//打印
	return 0;
}