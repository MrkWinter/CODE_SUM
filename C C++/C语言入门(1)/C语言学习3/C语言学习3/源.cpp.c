#define _CRT_SECURE_NO_WARNINGS 1
int g_val = 40;//这里加上static就不可以用了，使静态的全局变量只能在源文件内部使用
int Add(int a, int b)//这里加上static就不可以用了，函数有外部链接属性，加上就只有内部链接属性了
{
	int z;
	z = a + b;
	return z;
}