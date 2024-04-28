#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
#include<assert.h>
//指定比较个数的比较字符串函数strncmp
//int my_strncmp(const char* arr1,const char* arr2, int a)
//{
//	assert(arr1&&arr2);
//	while (a)
//	{
//		if (*arr1 == *arr2)
//		{
//			arr1++;
//			arr2++;
//			a--;
//			continue;
//		}
//		else if (*arr1 < *arr2)
//			return -1;
//		else
//			return 1;
//	}
//		return 0;
//}
//int main()
//{
//	const char* arr1 = "abcde";
//	const char* arr2 = "abcdf";
//	int ret = my_strncmp(arr1, arr2, 3);
//	printf("%d ", ret);
//	return 0;
//}
//判断字符串子串函数strstr
//找到了返回子串开始的起始指针，找不到返回NULL
//char* my_strstr(const char* p1, const char* p2)
//{
//	assert(p1&&p2);
//	if (*p2 == '\0')
//	{
//		return p1 + strlen(p1) - 1;
//	}
//	char* s1 = p1;
//	char* s2 = p2;
//	char* cur = p1;
//	while (*cur)//cur 为每次出发坐标 判断每次从cur起能否找到子字符串
//	{
//		s1 = cur;
//		s2 = p2;//重置所找的字符串
//		while (*s1 != '\0'&&*s2 != '\0'&&*s1==*s2)
//		{
//			s1++;
//			s2++;
//		}
//		if (*s2 == '\0')//成立则从cur起有相等字符串
//			return cur;
//		else if (*s1 == '\0')//s1先找到\0 自s1起字符串长度比s2起字符串小 s2不可能和s1相等了
//			break;
//		cur++;
//	}
//	return NULL;
//}
//int main()
//{
//	char* arr1 = "abdddef";
//	char* arr2 = "def";
//	char* ret = my_strstr(arr1,arr2);
//	if (ret == NULL)
//		printf("无该子串");
//	else
//		printf("%s", ret);
//	return 0;
//}
//经典算法KMP算法
//字符串分割函数 strtok
//第一次使用   strtok(目标字符串起始地址，分割标记字符串) 返回分割后的第一个字符串地址
//第二次使用   strtok(NULL,分割标记字符串) 返回分割后的第二个字符串地址
//strtok 使用第二次使用时要使用空指针 该函数能记住第一次分割后未分割字符串的地址
//原理 根据第一次传参得到的目标字符串 向后找到分割标记字符串中的字符后 将该字符改为'\0'，返回该字符串起始地址，并存储了'\0'后的字符串的起始地址
//第二次使用时，直接传空指针，由第一步得到的字符串的起始地址往下找，同第一步操作
//当从起始地址未找到分割标记字符串，而是找到'\0'后，直接返回字符串起始地址，记录'\0'后的地址
//再往下找是空字符串的时候返回空指针
//使用时最好对目标字符串进行备份
//int main()
//{
//	char* ret;
//	char  arr[] = "!?/";
//	char arr1[] = "abc!efg?hij/klm";
//	char arr2[30] = {0};
//	strcpy(arr2, arr1);
//	for (ret = strtok(arr2, arr); ret != NULL; ret = strtok(NULL, arr))
//	{
//		printf("%s ", ret);//打印分段后字符串，共进行了5次函数
//	}
//	return 0;
//}
//错误信息 strerror函数
//strerror能把错误码转换成字符串信息以指针的形式返回
//errno 是一个全局错误码的变量
//当c语言的库函数在执行过程中，出现了错误，就会把对应的错误码赋值到errno中
//打开文件
#include<errno.h>//头文件！！
//int main()
//{//打开文件函数fopen 返回FILE*的指针 打开文件失败时返回NULL
//	FILE* pf = fopen("text.txt", "r");
//	if (pf == NULL)
//	{
//		printf("%s", strerror(errno));//将错误码转换成信息
//	}
//	else
//		printf("打开文件成功");
//	return 0;
//}
//判断字符类型的函数 ，如果是返回一个大于0的数 如果不是返回0 有
//iscontrl isspace isdigit islower isupper isalpha isalnum inpunct isgraph isprint
//字符转换函数tolower大写转小写 toupper小写转大写
//返回值为int 型
#include<ctype.h>//头文件！！
//int main()
//{
//	char a = toupper('a');
//	putchar(a);
//	char b = tolower('B');
//	putchar(b);
//
//	return 0;
//}
//大写转小写
//int main()
//{
//	char arr[] = "I am A Student";
//	int len = strlen(arr);
//	int i;
//	for (i = 0; i < len; i++)
//	{
//		if (isupper(arr[i]))
//		{
//			arr[i] = tolower(arr[i]);
//		}
//	}
//	printf("%s", arr);
//	return 0;
//}