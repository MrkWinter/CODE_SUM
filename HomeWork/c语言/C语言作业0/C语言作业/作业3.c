#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
float x = 3.14;
int main()
{   float r,h,c,s,v,S,V;
	printf("请输入圆的半径为:");
	scanf("%f", &r);
	printf("请输入圆柱的高为:");
	scanf("%f", &h);
	c = 2 * x * r;
	printf("圆的周长为:%.2f\n", c);
	s = x * r*r;
	printf("圆的面积为:%.2f\n",s);
	v = s * h;
	printf("圆柱的体积为:%.2f\n", v);
	S = 4 * x * r*r;
	printf("以r为半径的球的表面积为:%.2f\n", S);
	V = x * r*r*r * 4 / 3;
	printf("以r为半径的球的体积为:%.2f\n", V);
	return 0;
}