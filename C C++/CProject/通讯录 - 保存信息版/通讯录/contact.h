#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
#include<Windows.h>
#include<stdlib.h>
#include<errno.h>
//#define MAX 1000
#define MAX_NAME 10
#define MAX_SEX 5
#define MAX_TELE 12
#define MAX_ADDR 30
#define STA 5
struct PeoInfo//通讯录内数组
{
	char name[MAX_NAME];
	int age;
	char sex[MAX_SEX];
	char tele[MAX_TELE];
	char addr[MAX_ADDR];
};
struct Contact//嵌套结构体作为通讯录
{
	struct PeoInfo* date;//结构体指针，指向一块开辟的动态内存
	int size;//表示数组中所存元素个数
	int capacity;//表示通讯录最大容量
};
enum ob
{   
	EXIT,
	ADD,
	DEL,
	SEARCH,
	MODIFY,
	SHOW,
	SORT,
	SAVE
};
//函数声明
void Initcontact(struct Contact* ps);//初始化通讯录
void Addcontact(struct Contact* ps);//添加通讯录成员及信息
void Showcontact(const struct Contact* ps);//显示通讯录人员及信息
void Delcontact(struct Contact* ps);//删除通讯录人员及信息
void Searchcontact(const struct Contact* ps);//查找通讯录人员及信息
void Modifycontact(struct Contact* ps);//修改通讯录人员及信息 
void Sortcontact(struct Contact* ps);//排序通讯录人员及信息
void Destroycontact(struct Contact* ps);//删除通讯录人员及信息
void Savecontact(struct Contact* ps);//保存通讯录人员及信息