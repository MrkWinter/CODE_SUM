#define _CRT_SECURE_NO_WARNINGS 1
#include "function.h"
//˼· ����ά���鴫���ʼ�������ж����ʼ��
//��time������srand������������г�ʼ��
//�Զ�ά������в���

int main()
{
	srand((unsigned int)time(NULL));//����ʱ����趨���������
	int arr[ROW][COL] = { 0 };
	Inital(arr); //��ʼ����ά����
	Printfarr(arr);//��ӡ��ά����
	int sum = CalculateRowSum(arr,1);//3.����arr�ĵ�һ�еĺ�
	printf("���к�Ϊ:%d\n", sum);
	sum = CalculateDiagonalSum(arr,0);//4.����arr�ĶԽ����ϵĺ� 0Ϊ�� 1Ϊ��
	printf("�Խ��ߺ�Ϊ:%d\n", sum);
	sum = CalculateTrangleSun(arr, 0);//5.����arr�����ǵĺ� 0Ϊ�� 1Ϊ��
	printf("�������ǵĺ�Ϊ:%d\n", sum);
	return 0;
}