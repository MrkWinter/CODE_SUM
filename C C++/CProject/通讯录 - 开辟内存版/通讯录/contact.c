#define _CRT_SECURE_NO_WARNINGS 1
#include "contact.h"
void Initcontact(struct Contact* ps)//初始化通讯录
{
	ps->date =(struct PeoInfo*)malloc(STA * sizeof(struct PeoInfo)); //将date 指向的动态内存设置为起始STA个元素
	ps->size = 0;//设置当前通讯录人员数
	ps->capacity = STA;//设置通讯录容量
}
void Addcontact(struct Contact* ps)//添加通讯录成员及信息
{
	if (ps->size == ps->capacity)
	{
		struct PeoInfo* str = (struct PeoInfo*)realloc(ps->date, (ps->capacity + 5) * sizeof(struct PeoInfo));
		if (str == NULL)
		{
			printf("%s\n", strerror(errno));
		}
		else
		{
			ps->date = str;//修改后结构体中指针date改变，销毁时不影响
			ps->capacity += 5;
			printf("通讯录容量提升成功，现容量为%d\n", ps->capacity);
		}
	}
		printf("请输入信息：\n");
		printf("姓名：");
		scanf("%s", ps->date[ps->size].name);
		printf("年龄：");
		scanf("%d", &ps->date[ps->size].age);
		printf("性别：");
		scanf("%s", ps->date[ps->size].sex);
		printf("电话：");
		scanf("%s", ps->date[ps->size].tele);
		printf("地址：");
		scanf("%s", ps->date[ps->size].addr);
		ps->size++;
		printf("添加完成\n");
		printf("输入任意键返回：");
		getchar(); getchar();
		system("cls");
}


void Showcontact(const struct Contact* ps)//显示通讯录人员及信息
{
	int i;
	printf("%-5s %-5s %-5s %-12s %-30s\n", "姓名", "年龄", "性别", "电话", "地址");
	for (i = 0; i < ps->size; i++)
	{
		printf("%-5s %-5d %-5s %-12s %-30s\n", 
			ps->date[i].name,
			ps->date[i].age,
			ps->date[i].sex,
			ps->date[i].tele,
			ps->date[i].addr);
	}
	printf("输入任意键返回：");
	getchar();getchar();
	system("cls");
}
static int Findbyname(const struct Contact* ps, char *name)//根据姓名查找元素返回下标
{
	int i;
	for (i = 0; i < ps->size; i++)
	{
		if (strcmp(ps->date[i].name, name)==0)
		{
			break;
		}
	}
	if (i == ps->size)
		return -1;
	else
		return i;
}


void Delcontact(struct Contact* ps)//删除通讯录人员及信息
{
	int ret;
	char name[MAX_NAME];
	printf("请输入删除人姓名：");
	scanf("%s", name);
	ret = Findbyname(ps, name);//根据姓名查找元素返回下标
	if (ret == -1)
		printf("查无此人\n");
	else
	{
		int i;
		for (i = ret; i < ps->size - 1; i++)
		{
			ps->date[i] = ps->date[i + 1];
		}
		ps->size--;//减少一个人
		printf("删除成功\n");
	}
	printf("输入任意键返回：");
	getchar(); getchar();
	system("cls");
}


void Searchcontact(const struct Contact* ps)//查找通讯录人员及信息
{
	int ret;
	char name[MAX_NAME];
	printf("输入查找人姓名：");
	scanf("%s", name);
	ret = Findbyname(ps, name);
	if (ret == -1)
		printf("查无此人\n");
	else
	{
		printf("%-5s %-5s %-5s %-12s %-30s\n", "姓名", "年龄", "性别", "电话", "地址");
		printf("%-5s %-5d %-5s %-12s %-30s\n",
				ps->date[ret].name,
				ps->date[ret].age,
				ps->date[ret].sex,
				ps->date[ret].tele,
				ps->date[ret].addr);
	}
	printf("输入任意键返回：");
	getchar(); getchar();
	system("cls");
}


void Modifycontact(struct Contact* ps)//修改通讯录人员及信息 
{
	int ret;
	char name[MAX_NAME];
	printf("请输入修改人姓名：");
	scanf("%s", name);
	ret = Findbyname(ps, name);
	if (ret == -1)
		printf("查无此人\n");
	else
	{
		printf("请输入信息：\n");
		printf("姓名：");
		scanf("%s", ps->date[ret].name);
		printf("年龄：");
		scanf("%d", &ps->date[ret].age);
		printf("性别：");
		scanf("%s", ps->date[ret].sex);
		printf("电话：");
		scanf("%s", ps->date[ret].tele);
		printf("地址：");
		scanf("%s", ps->date[ret].addr);
		printf("修改完成\n");
	}
	printf("输入任意键返回：");
	getchar(); getchar();
	system("cls");
}


void menu1()//排序依据表
{
	printf("****************************\n");
	printf("***** 1.姓名  |  2年龄 *****\n");
	printf("***** 3.性别  |  4电话 *****\n");
	printf("***** 5.地址  |        *****\n");
	printf("****************************\n");
}
int absort(const void* e1, const void* e2)//字符排序法
{
	return strcmp((char*)e1, (char*)e2);
}
int numsort(const void* e1, const void* e2)//年龄排序法
{
	return *(int*)e1 - *(int*)e2;
}
void swap(char* p1, char*p2, int width)//交换函数
{
	int i;
	for (i = 0; i < width; i++)
	{
		char temp = *p1;
		*p1 = *p2;
		*p2 = temp;
		p1++;
		p2++;
	}
}
void* my_qsort(void* base, size_t num, size_t width,int(*cmp)(const void* e1, const void* e2))//排序函数
{
	int i,j;
	void * ret = base;
	for (i = 0; i <(int) num - 1; i++)
	{
		for (j = 0; j <(int) num - 1 - i; j++)
		{
			if (cmp((char*)base+j*width, (char*)base +(j+1)*width) > 0)
			{
					swap((char*)base + j * width, (char*)base + (j + 1)*width, width);
			}
		}
	}
	return base;
}
void Sortcontact(struct Contact* ps)//排序通讯录人员及信息
{
	int input;
	menu1();
	printf("请输入排序依据");
	scanf("%d", &input);
	switch(input)
	{
	case 1:
		my_qsort((void*)ps->date[0].name,ps->size, sizeof(ps->date[0]), absort);
		break;
	case 2:
		my_qsort((void*)(&(ps->date[0].age)), ps->size, sizeof(ps->date[0]), numsort);
		break;//当修改数据中有不同长度的名字字符串时，进行年龄排序会造成名字部分丢失
		//可能与结构体的存储方式有关，排序意外修改了储存名字的内存，造成名字消失
	case 3:
		my_qsort((void*)ps->date[0].sex, ps->size, sizeof(ps->date[0]), absort);
		break;
	case 4:
		my_qsort((void*)ps->date[0].tele, ps->size, sizeof(ps->date[0]), absort);
		break;
	case 5 :
		my_qsort((void*)ps->date[0].addr, ps->size, sizeof(ps->date[0]), absort);
		break;
	default:
		printf("无该选项\n");
		break;
	}
	if(input<=5&&input>=1)
	printf("排序完成\n");
	printf("输入任意键返回：");
	getchar(); getchar();
	system("cls");
}

void Destroycontact(struct Contact* ps)//删除通讯录人员及信息
{
	free(ps->date);//释放内存
	ps->date = NULL;
}