#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//一.if else 语句  
//语句定义，有分号的为一个语句，;也为一个语句，是空语句
//int main()
//{
//	int age;
//	scanf("输入年龄进行判断：%d", &age);
//	if (age < 18)//为真执行，否则略过
//		printf("未成年\n");
//	else if (18 <= age && age < 28)//表并列    ps：if(18<age<28)为错误语句，计算机只能一次进行一次运算,若age = 10 结果变成：if(0<28)
//		printf("成年");
//	else if (28 <= age && age < 50)//此处为多分支语句 从上到下只执行一个
//		printf("壮年");
//	else if (50 <= age && age < 90)
//		printf("老年");
//	else
//		printf("仙人");
//	return 0;
//两种方式等价，第一种是并列逻辑，第二种是两个逻辑
//if (age < 18);
//printf("未成年\n");
//else
//{
//	if (18 <= age && age < 28)
//		printf("成年");
//	else if (28 <= age && age < 50)
//		printf("壮年");
//	else if (50 <= age && age < 90)
//		printf("老年");
//	else
//		printf("仙人");
//return 0;
//}
//int main()
//{
//	int a = 1;
//	if (a == 1)
//	{
//		printf("2222");
//		printf("33333");//执行多条语句采用代码块
//	}
//return 0;
//}
//int main()
//{//悬空else问题
//	int a = 1;
//	int b = 2;
//	if (a == 3)//此处if语句判断为假，不进入下面if语句
//	   if (b == 1)
//		  printf("hehe");//if els就近原则匹配
//	   else
//		  printf("dada"); //if else为一个整体 
//
//	return 0;
//}
//int main()//输出100内的奇数
//{
//	int a = 1;
//	while(a<=100)
//	{
//		if (1 == a%2)
//			printf("%d ", a);
//		a++;
//	}
//
//
//    return 0;
//}
//二.switch case break语句
//int main()
//{
//	int day;
//	scanf("%d", &day);
//	switch (day)//必须是整型表达式
//	{
//	case 1://case 后必须是整型常量表达式
//	    printf("星期一\n");//根据输入的来确定哪里进入case break走出
//		break;
//	case 2:      
//	    printf("星期二\n");
//		break;
//	case 3:
//		printf("星期三\n");
//		break;
//	case 4:
//		printf("星期四\n");
//		break;
//	case 5:
//		printf("星期五\n");
//		break;
//	case 6:
//		printf("星期六\n");
//		break;
//	case 7:
//	    printf("星期日\n");
//		break;
//	default://没有以上情况时执行默认项(除此之外)
//		printf("输入错误");
//		break;
//	}
//	return 0;
//}
//三.while  for  do while循环语句
//int main()
//{
//	while (1)//括号里为真，执行循环，为假，退出循环（此处为死循环）
//		printf("呵呵");
//	return 0;
//}
//while循环打印一到十
//int main()
//{
//	int a = 1;
//	while (a <= 10)
//	{
//		printf("%d\n", a);
//		a++;
//	}
//	return 0;
//}
//int main()
//{
//	int a = 1;
//	while (a <= 10)
//	{
//		if (5 == a)
//			break;//退出循环break
//		printf("%d\n", a);
//		a++;
//	}
//	return 0;
//}
//int main()
//{
//	int a = 0;
//	while (a < 10)
//	{
//		a++;
//		if (5 == a)
//			continue;//结束整个循环中本次循环，开始继续下次循环(终止本次循环不在执行下面代码，返回开头while重新判断)
//		printf("%d\n", a);//ps：break是永久停止循环，continue是继续下次循环
//	}
//	return 0;
//}
//int main()
//{
//	int ch = getchar();//gatchar()函数接收一个字符存在整型变量ch中 ps:字符型也算是整型类型符，浮点型不算整型类型
//	putchar(ch);  //putchar()输出字符变量,相当于printf("%c",ch);
//	printf("%c\n", ch);
//		return 0;
//}
//int main()
//{
//	int ch = 0;//ctrl + z =EOF，输入停止循环
//	while ((ch = getchar()) != EOF)//EOF文件结束标志end of file -> -1
//	{//getcher()接受一个字符不能是字符串
//
//		putchar(ch);//相当于printf()函数
//	}
//	return 0;
//}
//int main()
//{
//	int a,b;
//	char password[20] = {0};//定义一个数组password，里面存放20个数，占用80个字节，这里只放了一个0
//	printf("请输入密码:>");
//	scanf("%s", password);//数组本身就是一个地址，不用取地址符号，用数组来记录密码
//	printf("请确认(Y:N):>");//scanf,getchar函数是输入函数，scanf取空格和回车之前的信息
//	getchar();//吸收掉scanf函数确认是留在缓存区的回车（\n）这一步用下一步取代
//	while ((b = getchar()) != '\n')//getcher吸收字符直到吸收到回车scanf结束的标志，此步可以吸收掉缓冲区任何多余的字符包括空格以后的
//	{
//		;//空语句，不需要while函数做事情
//
//	}
//		a = getchar();
//	if('Y' ==a )
//		printf("确认成功");
//	else
//		printf("确认失败");
//	return 0;
//}
//int main()
//{
//	int a;
//	while ((a = getchar()) != EOF)
//	{
//		if (a < '0' || a>'9')//筛选是0到9的字符
//			continue;
//		putchar(a);//输出是0到9的字符
//
//	}
//	return 0;
//}
//四.for 语句
//int main()
//{//for 循环打印1到100
//	int a;
//	for (a = 1; a < 100; a++)
//	   //初始化   判断   调整 集一体比while循环更方便，更有优势
//		printf("%d ", a);
//
//	return 0;
//}
//int main()
//{
//	int a;
//	for (a = 1; a < 10; a++)
//	{   if (5 == a)
//			break;//break仍是跳出循环
//		printf("%d ",a);
//    } 
//	return 0;
//}
//int main()
//{
//	int a;
//	for (a = 1; a < 10; a++)//前闭后开建议，循环内不改变量建议
//	{
//		if (5 == a)
//			continue;//不会死循环，停止本次循环后进入a++然后再判断再循环
//		printf("%d ", a);//打印的为12346789
//	}//break在while与for中用法相同continue在while与for中用法不同
//	return 0;
//}
//int main()
//{
//	int a;
//	for (;;)//for初始化的，判断，调整都可以省略，但判断省略后恒为真会陷入死循环
//	{
//		printf("hehe");
//
//	}
//	return 0;
//}
//int main()
//{
//	int a, b;
//	for (a = 0; a < 10; a++)
//	{
//			for (b = 0; b < 10; b++)
//			{
//				printf("haha\n");
//
//			}
//	}
//
//	return 0;
//}//共打印100个haha，for循环套for循环
//int main()
//{
//	int a=0, b=0;
//	for (; a < 10; a++)
//	{
//		for (; b < 10; b++)
//		{
//			printf("haha\n");
//
//		}
//	}
//
//	return 0;
//}//打印10个haha，因为b没有初始化，所以最好不要省略for语句中的内容
//int main()
//{
//	int x, y;
//	for (x = 0, y = 0; x < 2 && y < 5; x++, y++)
//	{
//		printf("哈哈\n");//打印两个哈哈，for语句中两个条件同时成立
//	}
//	return 0;
//}
//int main()
//{//循环多少次？
//	int a, b;
//	for (a = 0, b = 0; b = 0; a++, b++)//0次，因为判断中为赋值语句，b=0恒为假（0），故不进入循环
//		b++;
//	return 0;
//}
//int main()
//{
//	while (1)//非零为真一直循环，0为假停止
//	{
//		printf("hehe");
//
//	}
//	return 0;
//}
//五.do while 语句
//int main()
//{
//	int a =0;
//	do//循环至少执行一次
//	{
//		if (5 == a)
//			continue;//01234死循环continue仍是结束本次循环因为a不能调整所以死循环，ps：break同while for语句中一样
//		printf("%d ", a);
//		a++;
//	}
//	while (a < 10);
//	return 0;
//}