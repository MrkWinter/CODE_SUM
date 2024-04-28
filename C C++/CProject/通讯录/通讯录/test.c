#define _CRT_SECURE_NO_WARNINGS 1
#include "contact.h"
void menu()//菜单函数
{
	printf("************************************\n");
	printf("******  1.add     |  2.del    ******\n");
	printf("******  3.search  |  4.modify ******\n");
	printf("******  5.show    |  6.sort   ******\n");
	printf("******  0.exit    |           ******\n");
	printf("************************************\n");
}

int main()
{
	int input;
	//用结构体创建通讯录con 里面包含一个数组和size 1
	struct Contact con;
	Initcontact(&con);//初始化通讯录 2
	do
	{
		menu();
		printf("请输入选项：");
		scanf("%d", &input);
		switch (input)
		{
		case ADD:
			Addcontact(&con);//添加通讯录人员及信息 3
			break;
		case DEL:
			Delcontact(&con);//删除通讯录人员及信息 5
			break;
		case SEARCH:
			Searchcontact(&con);//查找通讯录人员及信息 6
			break;
		case MODIFY:
			Modifycontact(&con);//修改通讯录人员及信息 7
			break;
		case SHOW:
			Showcontact(&con);//显示通讯录人员及信息 4
			break;
		case SORT:
			Sortcontact(&con);//排序通讯录人员及信息 8
			break;
		case 0:
			printf("退出");
			break;
		default:
			printf("无该选项\n");
			printf("输入任意键返回：");
			getchar(); getchar();
			system("cls");
		}
	} while (input);
	
	return 0;
}