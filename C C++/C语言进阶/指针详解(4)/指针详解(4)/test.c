#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//qsort函数的实现
//void swap(char* p1, char*p2, int width)//传递的是数组中相邻两个元素的起始地址
//{//根据元素字节数大小，依次交换该元素的所有字节中所存的数据
// //实现两个元素的交换
//	int i;
//	for (i = 0; i < width; i++)
//	{
//		char temp = *p1;
//		*p1 = *p2;
//		*p2 = temp;
//		p1++;
//		p2++;
//	}
//}
//void my_qsort(void* base, int sz, int width, int(*cmp)(const void* e1,const void* e2))//回调函数机制
//{
//	int i, j;//典型冒泡排序模板
//	for (i = 0; i < sz - 1; i++)//sz-1趟
//	{
//		for (j = 0; j < sz - 1 - i; j++)//sz-1+i 每趟排序次数
//		{
//			if (cmp1((char*)base + j * width, (char*)base + (j + 1)*width) > 0)
//			{//根据所传数组首元素地址，和每个元素大小来找到每个元素的起始地址
//			 //传递给使用者定义的比较函数，调用比较函数来判断第一元素和第二元素大小进行排序
//				swap((char*)base + j * width, (char*)base + (j + 1)*width, width);//交换元素函数
//			}
//
//		}
//	}
//}
//int cmp1(const void* e1,const void* e2)//传递的是数组中相邻两个元素的起始地址
//{
//	return *(int*)e1 - *(int*)e2;//强制类型转换成所比较元素的指针，解引用找到元素比较
//}
//void test1()
//{
//	int i;
//	int arr1[] = {9,8,7,6,5,4,3,2,1};
//	int sz = sizeof(arr1) / sizeof(arr1[0]);
//	my_qsort(arr1, sz, sizeof(arr1[0]), cmp1);//数组起始地址，元素个数，元素大小，比较函数
//	for (i = 0; i < sz; i++)//打印
//	{
//		printf("%d ", arr1[i]);
//	}
//}
//int main()
//{
//	test1();//调用my_qsort排序数组
//	return 0;
//}
//试题分析
//int main()
//{
//	int arr[] = { 1,2,3,4 };
//	printf("%d", sizeof(*&arr));//16 &arr 取出整个数组的地址 解引用得到arr整个数组 sizeiof(arr)等于16 
//	return 0;
//}
//二维数组名指针问题
//int main()
//{
//	int a[3][4] = { 0 };
//	printf("%d\n", sizeof(a));//48 a代表整个二维数组 
//	printf("%d\n", sizeof(a[0][0]));//4 二维数组中第一行第一个元素
//	printf("%d\n", sizeof(a[0]));//16 a[0]代表二维数组中第一个数组元素 第一个为元素的数组代表整个数组
//	printf("%d\n", sizeof(a[0]+1));//4 arr[0]代表二维数组中第一个数组元素 第一个为元素的数组代表这个数组的首元素地址
//	printf("%d\n", sizeof(*(a[0]+1)));//4 arr[0]+1代表二维数组中第一行第二个元素的地址 解引用表示这个元素
//	printf("%d\n", sizeof(a+1));//4 a代表二位数数组的首元素地址 a+1代表二维数组中第二个元素为数组的地址
//	printf("%d\n", sizeof(*(a+1)));//16 *(a+1)代表二维数组中第二个为数组的元素 这个数组代表整个数组
//	printf("%d\n", sizeof(&a[0]+1));//4 &a[0]代表二维数组的首元素地址 +1代表第二个为数组的元素的地址
//	printf("%d\n", sizeof(*(&a[0] + 1)));//16 &a[0]+1代表第二个为数组的元素的地址 解引用得到第二个为数组的元素 这里表示整个数组
//	printf("%d\n", sizeof(*a)); //16 *a代表a的首元素 这个元素为数组 表示整个数组
//	printf("%d\n", sizeof(a[3])); //16 sizeof并不会访问数组 计算a[3]的大小和a[0]一样
//	//总结 一维数组
//	//sizeof(arr) 代表整个数组 &arr 代表整个数组的地址 其余的arr都表示数组的首元素地址
//	//arr+1，arr+2 代表的是第二、三元素的地址 *arr得到数组中的首元素
//	//二维数组
//	//sizeof(arr) 代表整个数组 &arr 代表整个数组的地址 其余的arr有
//	//代表其中包含的第一个为数组的元素的地址 即数组的地址 也是首元素地址 即&arr[0] arr[0]为第一个数组的名字
//	//arr+1,arr+2 代表的是第二、三个数组的地址 *arr 代表的是arr[0]即第一个数组 此时转换成一维数组名分析
//	return 0;
//}
//int main()
//{
//	int arr[] = { 1,2,3,4 };
//	int* prr1 = (int*)(&arr + 1);//prr1所指地址跳到数组后 转换成int*类型
//	int* prr2 = (int*)((int)arr + 1);//prr2所指地址为arr向后一个字节
//	//%x意思是16进制输出（以16进制输出变量地址）C语言中%x是用在标准输出和输入函数里的格式控制符。把整型值按16进制整型输出，不带前导0x
//	printf("%x ", prr1[-1]);//*(prr1-1) 16进制为 0x 00 00 00 04
//	printf("%x ", *prr2);//小端存入 内存分布为 01 00 00 00 | 02 00 00 00 | 03 00 00 00 | 04 00 00 00
//	//*prr2即从prr2向后访问4个字节 16进制为 0x 02 00 00 00 (小端存储，从右往左读)
//	return 0;
//}
//int main()
//{
//	int arr[3][2] = { (2,1),(3,4),(5,7) };//逗号表达式
//	int* p;
//	p = arr[0];//arr[0] 为数组名
//	printf("%d ", p[0]);//1
//	return 0;
//}
//int main()
//{
//	int a[5][5];
//	int(*p)[4];//数组指针类型
//	p = a;//&arr[0]赋给数组指针p  前类型为int(*)[4]后类型为int(*)[5]
//	printf("%p %d\n", &p[4][2] - &a[4][2], &p[4][2] - &a[4][2]);
//	//&p[4][2] -> *(*(p+4)+2) int(*)[4]类型的数组指针 向后走4步共16字节 
//	//解引用得到一个数组 再向后走2字节 取这个数组中第18字节处的地址
//	//&a[4][2] 取第这个数组第22字节处的地址 同为int*类型 相减为元素个数-4
//	//%p为打印16进制地址(无符号数) -4的补码为111111111111111111110 ->fffffffc
//	return 0;
//}
//int main()
//{
//	char* a[] = { "work","at","alibaba" };//定义一个字符指针数组 数组中存储三个char* 类型的指针
//	char** pa = a;//数组a代表首元素的地址 char*类型指针的地址 
//	//char* * pa 第二颗*代表pa为指针 第一颗*代表指针pa指向的元素类型为char*
//	//char *p  p++ 指跳过一个char类型的数据
//	//char* * p p++  指跳过一个char*类型的数据
//	//该数组内的元素为 {char*  char*  char*}
//	pa++;
//	//这里表示跳过一个char*类型的指针 跳过的该指针指向'w' 跳过后pa指向的是下一个char*指针
//	//这个指针指向'a'，所以打印的为at
//	printf("%s\n", *pa);
//	return 0;
//}
//int main()
//{//先画出指针内存图，再进行计算
// //数组中的内存地址是连续的
// //字符串中的内存地址也是连续的
// //由符号优先级进行分步运算
//	char *c[] = { "ENTER","NEW","POINT","FIRST" };
//	char* *cp[] = { c + 3,c + 2,c + 1,c };
//	char** *cpp = cp;
//	printf("%s\n", **++cpp);//"POINT"
//	printf("%s\n", *--*++cpp + 3);//"ER"                                                      
//	printf("%s\n", *cpp[-2] + 3);//"ST"
//	printf("%s\n", cpp[-1][-1] + 1);//"EW"
//	return 0;
//}