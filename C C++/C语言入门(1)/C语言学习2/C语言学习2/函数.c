#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
	/*int main()
	{//ѡ����临ϰ

		int input;
		printf("Ҫ��ѧ��\n");
		printf("��Ҫ�úú�ѧϰ��(1/0)>:");
		scanf("%d", &input);
		if (input == 1)
			printf("���Ϊ��һ����ѧ��");
		else
			printf("���Ϊ��һ����ѧ��");
		return 0;

	}*/

//ѭ����临ϰ
//int main()
//	{
//	int word = 0;
//
//
//	while (word < 200000)
//
//	{
//		printf("дһ����,%d\n", word);
//
//		word++;
//
//	}
//	if (word >= 100000)
//	
//		printf("������������ﵽ,��ҵ���\n");
//	
//	return 0;
//
//	}


int Add(int x, int y)//xyΪ����
{
	int z;
	z = x + y;
	return z;//������z���ص���ͷ����sum
}


int main()
	{
	int numb1, numb2,sum;
	numb1 = 34;
	numb2 = 45;
	sum = Add(numb1, numb2);//����Add�ӷ�����������

	printf("%d\n",sum);
		return 0; 
	}
