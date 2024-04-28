#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//int Add(int x, int y)//1.自定义函数--自己定义的函数
//{                    //2.库函数---c语言本身提供的函数
//	int z;
//	z = x + y;
//	return z;
//}
//int main()
//{
//	int a = 10;
//	int b = 30;
//	int sum = Add(a, b);//两个输入参数
//	printf("%d", sum);
//	return 0;
//}
//简单总结,C语言常用的函数都有:
//1.IO函数
//2.字符串操作函数
//3.字符操作函数
//4.内存操作函数
//5.时间/日期操作函数
//6.数学函数
//7.其他库函数
#include<string.h>
//int main()
//{//1.strlen --string length 求字符串长度
// //strcpy --string copy  拷贝字符串
//	char arr1[] = { "bit" };//最后有\0为字符串结束的标志
//	char arr2[20] = { "#######" };
//	strcpy(arr2, arr1);//把字符串arr1拷贝到arr2中，\0也拷贝到arr2上了所以只有bit  为bit\0######
//	printf("%s", arr2);//字符串类型为char 打印为%s
//	return 0;
//}
//2.memset--内存设置 memory 内存 --  set设置
//int main()
//{
//	char arr[] = "Hello world";//字符串由字符是组成的
//	memset(arr, '*', 5);//memset(指针类型的变量;设置量;从取地址的第号内存字节起共有多少个内存字节被设置)
//	printf("%s\n", arr);//这里是用'*'替代了arr数组中存放的前5个字符
//	return 0;
//}
//自定义函数
//ret_type fun_name(paral *)//返回类型 函数名 （函数参数）
//{
//
//	statement;//语句块,函数体
//}
//1.选出两个数较大值的函数
//int getmax(int x, int y)//函数的定义
//{
//	if (x > y)
//		return x;
//	else
//		return y;
//}
//
//int main()
//{
//	int a = 49;
//	int b = 99;
//	int max = getmax(a,b);//函数的调用 
//	printf("max=%d\n", max);
//
//	return 0;
//}
//2.交换函数
//错误示范
//void swap(int x, int y)//这里又创建了xy两个变量，a，b的值分别赋给了xy
//{               
//	int temp;         //这里的实际意义为x和y交换变量，与ab无关
//	temp = x;          //形参实际化相当于形参是实参的一种临时拷贝
//	x = y;
//	y = temp;
//}
//int main()
//{
//	int a = 45;
//	int b = 89;
//	swap(a, b);//传值调用
//	printf("a =%d,b=%d", a, b);
//
//	return 0;
//}
//正确示范
//void swap2(int* pa, int* pb)//这里用指针变量来接受ab的地址
//{
//	int temp;//创建一个临时指针变量来进行交换数值
//	temp = *pa;//用变量temp来存放a的值 *pa就等于a
//	*pa = *pb;//通过b的地址来找到b，使b的值赋给a 等价于a =b
//	*pb = temp;//同理
//
//}
//int main()
//{
//	int a = 45;
//	int b = 89;
//	swap2(&a,&b);//这里是用ab的地址来实现ab量的交换 ，传址调用
//	printf("a =%d,b=%d", a, b);
//
//	return 0;
//}
//int getmax(int x, int y)//x,y为形式参数--函数中定义的参数，形式参数只能在函数中起作用
//{
//	if (x > y)
//		return x;
//	else
//		return y;
//}
//int main()
//{
//	int a = 49;
//	int b = 99;
//	int max = getmax(a, b);//a,b 为实际参数--传到函数里的数字，实际参数可为常量，变量，表达式，函数等必须有确定的值
//	printf("max=%d\n", max);
//
//	return 0;
//}
//写一个函数判断一个数是不是素数
#include<math.h>
//int is_prime(int n)//实参a传给形参n
//{
//	int i;
//	for (i = 2; i <= sqrt(n); i++)//for循环验证数a是否只能被1和它本身整除的数
//	{
//		if (n%i == 0)
//			break;//能被整除不是素数，跳出循环
//	}
//	if (sqrt(n) < i)//判断跳出的数是否被别的数整除了
//		return 1;//这里不够简洁，见下面修改
//	else
//		return 0;
//}
//int is_prime(int n)
//{
//	int i;
//	for (i = 2; i <= sqrt(n); i++)
//	{
//		if (n%i == 0)
//			return 0;//retuen 0;比break更强，直接结束函数，可在函数内部任意位置使用，而break;是结束循环
//	}
//	return 1;//能到这里的只有一种情况，不能被2~sqrt(n)内所有数整除，即素数
//}
//int main()
//{
//	int a;
//	scanf("%d", &a);
//	if (is_prime(a) == 1)//括号中调用传值函数来求数字a是否为素数
//		printf("%d是素数\n", a);
//	else
//		printf("%d不是素数\n", a);
//	return 0;
//}
//写一个函数判断一年是不是闰年
//int is_leap_year(int a)
//{
//	if ((a % 4 == 0 && a % 100 != 0) || (a % 400 == 0))//判断是否为闰年
//		return 1;
//	else
//		return 0;
//
//}
//int main()
//{
//	int year;
//	for (year = 1000; year < 3000; year++)//找1000~3000内的闰年
//	{
//		if (1 == is_leap_year(year))//传值函数调用
//			printf("%d ", year);
//	}
//
//	return 0;
//}
//写一个函数二分制查找数组中元素
//错误示范
//int bunary_search(int arr[], int k)//这里的int arr[]为指针接收arr第一个元素地址，大为4，
//{                                 //因为一般数组太大了，计算机不愿意在开辟空间来拷贝地址
//	int sz = sizeof(arr) / sizeof(arr[0]);//而是用指针的形式来找到原数组进行操作
//	int left = 0;
//	int right = sz - 1;
//	while(left<=right)
//	{
//		int mid = (left + right) / 2;//求中间元素
//		if (arr[mid] > k)
//			right = mid - 1;
//		else if (arr[mid] < k)
//			left = mid + 1;
//		else
//			return mid;
//	}
//	return -1;//没有目标元素
//}
//int main()
//{
//	int arr[] = { 1,2,3,4,5,6,7,8,9,10 };//数组名代表指针
//	int k = 7;
//	int ret =bunary_search(arr, k);//二进制查找元素//传arr数组时，实际上传的是arr中第一个元素的地址
//	if (-1 == ret)
//		printf("找不到这样的元素\n");
//	else
//		printf("找到了，元素下标为%d\n", ret);
//	return 0;
//}
//int bunary_search(int arr[], int k,int sz)//这里多一个形参sz来接收数组中元素个数
//{
//	int left = 0;
//	int right = sz - 1;
//	while (left <= right)
//	{
//		int mid = (left + right) / 2;
//		if (arr[mid] > k)
//			right = mid - 1;
//		else if (arr[mid] < k)
//			left = mid + 1;
//		else
//			return mid;
//	}
//	return -1;
//}
//int main()
//{
//	int arr[] = { 1,2,3,4,5,6,7,8,9,10 };
//	int sz = sizeof(arr) / sizeof(arr[0]);//这里选择在函数外求数组中元素个数
//	int k = 7;
//	int ret = bunary_search(arr, k,sz);//传递实参
//	if (-1 == ret)
//		printf("找不到这样的元素\n");
//	else
//		printf("找到了，元素下标为%d\n", ret);
//	return 0;
//}
//写一个函数每调用一次，num+1
//void Add(int* p)
//{
//	(*p)++;//不可*p++，因为++的运算优先级大于*解引用的优先级
//}
//
//int main()
//{
//	int num = 0;
//	Add(&num);//传址调用
//	printf("%d\n", num);
//	Add(&num);
//	printf("%d\n", num);
//	Add(&num);
//	printf("%d\n", num);
//
//	
//	return 0;
//}
//函数的嵌套调用和链式访问
//1.嵌套调用就是函数间能套娃
//2.链式访问
//一个函数接收另一个函数的返回值
//int main()
//{
//	int len = 0;
//	len = strlen("abc");
//	printf("%d\n", len);
//	printf("%d\n", sizeof("abc"));//sizeof的返回值为整型，这里就是链式访问
//	printf("%d\n", strlen("abc"));//strlen求字符串长度不算\n,sizeof求字符串长度算\n字符串中一个字符为一个字节,\n也为一个字节
//	return 0;
//}
//int main()
//{
//	printf("%d", printf("%d", printf("%d", 43)));//链式访问  打印的为4321
//	return 0;//解释：printf()函数的返回值为打印的字符个数，这里由内向外打印
//}
//int Add(int, int);//函数的声明
//int main()
//{
//	int a = 34;
//	int b = 98;
//	int sum = Add(a, b);//函数的调用
//	printf("%d\n", sum);
//	return 0;
//}
//int Add(int x, int y)//函数的定义
//{
//	int z;
//	z = x + y;
//	return z;
//}
//函数声明，函数定义，函数调用的具体使用，---放到多个文件中去--函数调用的模块化
//1.函数声明放到头文件中去，使用时可引用头文件名
//2.函数定义可以放到另一个源文件中去，用来定义函数
//3.函数的调用在主源文件中使用
#include"Add.h"//引用自己的头文件时用""引用
int main()
{
	int a = 34;
	int b = 98;
	int sum = Add(a, b);//直接实现函数的调用
	printf("%d\n", sum);
	return 0;
}
