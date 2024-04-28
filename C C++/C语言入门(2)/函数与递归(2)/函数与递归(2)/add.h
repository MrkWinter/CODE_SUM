#define _CRT_SECURE_NO_WARNINGS 1
#ifndef __ADD_H__//1--判断是否引过该头文件，若引过，则判断为0，从1到3行代码都跳过
#define __ADD_H__//2--定义包含一次头文件，第二次就包含过了，#ifndef直接判断为假，跳过
int add(int x, int y);//声明函数

#endif//3--这三行的代码是防止多次引用头文件，浪费空间