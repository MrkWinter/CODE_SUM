#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
// main()
//{//�����ؼ���
	//auto�ֲ�����ǰ�Զ��ؼ��֣���ʾ�Զ����ɣ��Զ�ɾ�� auto int a = 38
	//break,case,char,const,continue,default,do,double,else,enum,
	//extern,float,for,goto,if,(signed)int  �з��Ŷ���  ��unsigned int �޷��Ŷ��壬��Զ��������,long,reginster,
//	register int a = 10;//���������a���ڼĴ�������ʸ���
    //return,short,sizeof,static,struck,switch,typedef,union,void,volatile,while

	 
	//typedef  ���Ͷ���  �����ض���
//	typedef unsigned int u_int;
//	unsigned int a = 19;
//	u_int b = 2;





//	return 0;
//}
//static ���ξֲ�����Ϊ�ӳ��ֲ���������������
//static ����ȫ�ֱ���Ϊ�ı�ȫ�ֱ�����������
//static ����ȫ�ֺ���Ϊ�ı亯������������
//void test()//void Ϊ����һ��û�з���ֵ�ĺ��� ��intͬ��λ
//{
//	 static int a = 1;//auto int �Զ������Զ�ɾ��  ������������a��ֵ aΪ��̬�ľֲ�����
//	a++;
//	printf("a = %d\n", a);
//}
//int main()
//{
//	extern int g_val;
//     int i = 0;
//	while (i < 5)
//	{
//		test();//test ����
//		i++;
//
//	}
//
//	printf("%d\n", g_val);
//	return 0;
//}

extern int Add(int, int);//���ⲿ������������
int main()
{
	int a, b,c;
	a = 8;
	b = 4;
	c = Add(a, b);
	printf("sum = %d\n", c);
	return 0;
}