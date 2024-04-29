#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<stdlib.h>
//引入
//数据的逻辑结构
//线性结构 线性表 栈 队列 字符串 数组 广义表
//非线性结构 树形结构 图形结构
//树形结构 结点直接有分支 具有层次关系

//5.1.1树的定义
//树是有n个结点的有限集合
//n = 0 称为空树
//n > 0 树的定义 有且仅有一个结点称为根 其余结点可分为m个互不相交的有限集        每个集合又是一棵树 并且称为根的子树
//树的定义决定了树是递归的 是套娃
//树可以用树形结构表示 也可用嵌套集合表示 也可用凹入表示 也可用广义表表示
//
//5.1.2树的基本术语
//
//结点：数据元素及指向子树的分支
//根结点：非空树中无前驱结点的结点
//结点的度：结点拥有的子树数   拥有的后继
//树的度：树内各个结点度数的最大值
//分支结点(非终端结点)： 度 != 0
//内部结点：根结点以外的分支结点
//叶子(终端结点):度数 == 0
//孩子：结点的子树的根称为该结点的孩子 该结点称为孩子的双亲
//兄弟：有共同双亲的结点
//堂兄弟：双亲在同一层的结点
//祖先：从根到该结点所经分支上的所有结点
//子孙：以某结点为根的子树中的任意结点
//树的深度(高度)：树中结点的最大层次
//有序树：树中结点的各个子树从左至右有次序
//无序数：树中结点各子树无次序
//森林：由m(m>=0)棵树互不相交的树的集合  树一定是森林 森林不一定是树
//
//5.1.3二叉树的定义
//
//二叉树和树是两个概念
//二叉树：
//  二叉树是有n(n>=0)个结点的有限集 或者是空集 
//  或者由一个根节点及两棵互不相交的树称为这个根的左子树和右子树
//
//特点：二叉树每个结点最多只有两个孩子 不存在度数大于二的结点
//二叉树子树有左右之分，次序不能颠倒
//二叉树可以是空集 根可以有空的左子树和右子树
//二叉树要区分左子树和右子树  树不用区分
//
//二叉树的基本形态
//5种 空二叉树 根和空的左右子树 根和左 根和右 根和左右
//有关树的基本术语对二叉树适用 但二叉树和树是两个概念
//
//5.2案例引入 
//
//1数据压缩问题
//通过哈夫曼树解决数据文件转换成二进制编码的问题
//
//2用二叉树求解表达式的值
//递归求解 将二叉树中结点定义为第一操作数和第二操作数
//
//5.3树和二叉树的抽象数据类型定义
//二叉树操作
//二叉树的建立
//二叉树的遍历 前中后序遍历
//
//5.4二叉树的性质和存储结构
//
//性质1：二叉树的第i层上最多有2^(i-1)个结点 最少有i个
//性质2: 深度为k的二叉树最多有2^k-1个结点 最少有k个
//性质3: 任何一棵二叉树 如叶子数为n0 度数为2的结点数为n2 则 n0 = n2+1
//即叶子数等于度数为二的结点数+1 用边数相等可以证明 
//
//
//特殊形式的二叉树：满二叉树 完全二叉树
//
//满二叉树：一棵深度为k且有2^k-1 个结点的二叉树
//特点：每一层上的结点数都是最大结点数   叶子结点全部在最底部
//
//完全二叉树：深度为k的有n个结点的二叉树 当且仅当每一个结点都与深度为k
//的满二叉树中编号为1~n的结点一一对应时 称为完全二叉树 
//满二叉树从最后一个结点连续的去掉任意个结点都是完全二叉树
//特点 1.完全二叉树的叶子只可能分布在层次最大的两层上
//     2.对任意结点 如果该结点的右子树的层次为i 那么该结点的右子树的最大层数一定为i或i+1
//性质4:若完全二叉树有n个结点 那么完全二叉树深度为 [log2 n] + 1
//性质5:双亲与孩子的关系 一个结点的编号为i 双亲结点的编号为 [i/2] 孩子结点的编号左孩子为2i 右孩子为2i+1
//如果2i>n 则该结点为叶子结点 无孩子 若 2i+1>n 那么该结点无右孩子
//重点
//
//
//二叉树的顺序存储结构
//
//用数组来表示二叉树
//
//对于完全二叉树 用编号代表数据在二叉树中的储存位置 
//对于非完全二叉树 同样转换成完全二叉树 无数据的位置不存储数据
//
//顺序存储的缺点 
//对于可变的二叉树不适用
//当存储对象结构为右单支数时 比较浪费空间
//
//特点 结点关系蕴涵在其存储位置中 
//浪费空间 适用于存储满二叉树和完全二叉树
//
//typedef struct student {
//	int arr[100];
//}student;
//
//二叉树的链式存储结构 二叉链表
//
//一个结点中定义一个数据域 一个左孩子指针 一个右孩子指针
//
//typedef struct BiNode {
//	int date;
//	struct BiBode* lchild; //左孩子指针
//	struct BiBode* rchild; //右孩子指针
//}BiNode;
//
//链二叉树性质 有n个结点的二叉树链表中 有n+1 个空指针域 
////2n个指针域 - (n-1)个双亲双亲占用一个结点 = n+1个
//
//三叉链表
//
//结点中多一个指针域指向双亲
//
//typedef struct BiNode {
//	int date;
//	struct BiNode* lchild;
//	struct BiNode* rchild;
//	struct BiNode* pchild; //双亲结点指针
//};
//
// 
//5.5.1遍历(周游)二叉树
//
//访问方法 根左右   左根右   左右根 先左后右的方法 递归进行
//访问方法 
//先序 表示的是前缀表式
//中序 表示的是中缀表示
//后序 表示的是后缀表示
//typedef struct BiNode {
//	int date;
//	struct BiNode* lchild;
//	struct BiNode* rchild;
//}BiNode;
//先序遍历 - + a * b - c d / e f 前缀表达式
//中序遍历 a + b * c - d - e / f 中缀表达式
//后序遍历 a b c d - * + e f / - 后缀表达式
//
//以知道二叉树的顺序表示 得到唯一的二叉树
//先序和中序 中序和后序可以得到唯一确定的二叉树
//由先序或后序判断根的位置 中序判断左右子树的位置

//遍历二叉树的算法实现
//
//先序递归遍历算法
//typedef struct BiNode
//{
//	int date;
//	struct BiNode* lchild;
//	struct BiNode* rchild;
//}BiTree;
//void Pre(BiTree* t1)
//{
//	if (t1 == NULL)
//		return;
//	printf("%d", t1->date);//打印根
//	Pre(t1->lchild); //遍历左子树
//	Pre(t1->rchild); //遍历右子树
//}
//void Inital(BiTree* t1)
//{
//	t1->lchild = NULL;
//	t1->rchild = NULL;
//}
//int main()
//{
//	BiTree T1 = { 0 };
//	Inital(&T1);
//	Pre(&T1);//遍历打印二叉树
//	return 0;
//}
//递归算法的时间复杂度相为 n 空间复杂度为 n
//每个结点经过三次

//中序非递归算法遍历二叉树
//
//用栈访问二叉树
//
//1）建立一个栈 
//
//2）根节点进栈 遍历左子树 
//
//3）根节点出栈 遍历右子树
//
//结点不为空 栈中无结点 
//
//本质是不断访问根结点 
//
//直到栈中无结点且访问的结点为访问完毕
//左子树非空将该结点入栈 
//左子树空将该结点出栈访问右子树
//直到栈为空。。。

//实现

#define MAX 100
//定义栈

//typedef struct binode
//{
//	int date;
//	struct binode* lchild;
//	struct binode* rchild;
//}BiTree;
//typedef struct Stack
//{
//	BiTree** date; //存放二叉树根
//	int top; //指向栈顶
//}Stack;
//void InitalStack(Stack* s1)
//{
//	s1->date = (BiTree**)malloc(sizeof(BiTree*)* MAX); //开辟空间存放数据
//	s1->top = -1;//
//}
//void PushStack(Stack* s1, char a)
//{
//	if (s1->top == MAX)
//	{
//		printf("栈满\n");
//		return;
//	}
//	s1->date[++(s1->top)] = a; //将栈顶上移 然后赋值
//}
//void DelectStack(Stack* s1)
//{
//	s1->top = -1;
//	free(s1->date);
//}
//BiTree* PopStack(Stack* s1) //出栈 返回值为char
//{
//	if (s1->top == -1)
//	{
//		perror("栈空\n");
//		return NULL;
//	}
//	BiTree* a = s1->date[(s1->top)--];//栈顶下移
//	return a;
//}
//int LongStack(Stack* s1)
//{
//	return s1->top + 1;
//}
//
//void Inital(BiTree* t1)
//{
//	t1->lchild = NULL;
//	t1->rchild = NULL;
//}
//void InOrderTraverse(BiTree* t1, Stack* s1)
//{
//	BiTree* p = t1;
//	while (p || !LongStack(s1))
//	{
//		if (p)
//		{
//			PushStack(p,s1);
//			p = p->lchild;
//		}
//		else
//		{
//			BiTree* q = PopStack(s1);
//			printf("%d", q->date);//访问根
//			p = q->rchild;
//		}
//	}
//}
//int main()
//{
//	BiTree t1 = { 0 };
//	Stack s1 = { 0 };
//	InitalStack(&s1);//初始化栈
//	Inital(&t1);//初始化树 
//
//	//下面用栈来实现二叉树的非递归访问
//
//	InOrderTraverse(&t1, &s1);
//
//	DelectStack(&s1);
//	return 0;
//}

//二叉树的层次遍历
//
//思想 用队列来实现
//
//若结点不为空 将结点入队 
//
//将该结点出队 将该结点的左右孩子入队 
//
//按从上到下 从左到右的顺序依次访问每一个结点
//
//算法实现
//基本思路
//void LevelOrder(Queue* q1, BiTree* t1)
//{
//	Inital1(q1);
//	Inital2(t1);
//	PushQueue(t1);//将根入队
//	while (LongQueue(q1,t1) != 0)
//	{
//		BiTree* t = PopQueue(q1);
//		printf("%d", t->date); //出队访问
//		将该结点的左右孩子入队
//		if(p->lchild!=NULL)
//		PushQueue(q1, p->lchild);
//		if (p->rchild != NULL)
//		PushQueue(q1, p->rchild);
//	}
//}

//二叉树算法的应用 
//1.二叉树的建立
//建立二叉树结点
//创立一个二叉树 中间存放 china 先序显示遍历为china
//在二叉树创建函数中使用scanf函数 以防止用户输入的字符不够组成二叉树

//typedef struct Bitree
//{
//	char date;//数据域 存放数据
//	struct Bitree* lchild; //指向左子树
//	struct Bitree* rchild; //指向右子树
//}Bitree;
//Bitree* CreateBitree() {
//	char temp;
//	scanf("%c", &temp); //输入字符 用字符代表有效数据 #代表空
//	getchar();
//	if (temp == '#') {
//		return NULL;
//	} 
//	Bitree* node = (Bitree*)malloc(sizeof(Bitree));
//	node->date = temp;
//	node->lchild = CreateBitree();
//	node->rchild = CreateBitree();
//	return node;
//}
//void TravelBitree(Bitree* b1);
//int main() {
//	Bitree* b1 = CreateBitree();
//	TravelBitree(b1);
//	return;
//}
//void Inital(Bitree* b1)
//{
//	b1->lchild = NULL;
//	b1->rchild = NULL;
//}
//void CreateBitree(Bitree* b1)//c语言中不要传空指针 函数中的指针可以通过malloc函数赋值 但主函数中的指针仍为空！！！
//{
//	char temp;
//	scanf("%c", &temp); //输入字符 用字符代表有效数据 #代表空
//	getchar();//c语言scanf函数每次都会自动吸收一个回车
//	if (temp == '#')
//	{
//		b1 = NULL;//因为是递归调用 当输入数据为#时 代表这个树根为空
//	}
//	else
//	{
//		if (!(b1 = (Bitree*)malloc(sizeof(Bitree))))//因为是递归调用 防止栈溢出
//		{//第一次这里b1已经有开辟了空间 重新将内存返回的指针指向b1 可能会导致内存无法释放
//			perror("over stack");
//		}
//		b1->date = temp; //将数据赋值给新建的子树
//		CreateBitree(b1->lchild);//创建左子树  ？？传参 c++中的引用传参实现
//		CreateBitree(b1->rchild);//创建右子树
//	}
//	return;
//}
//void TravelBitree(Bitree* b1) //先序递归访问
//{
//	if (b1 == NULL)
//	{
//		return;
//	}
//	printf("%c", b1->date);
//	TravelBitree(b1->lchild);//访问左子树
//	TravelBitree(b1->rchild);//访问右子树
//}
//int main()
//{
//	Bitree* b1 = (Bitree*)malloc(sizeof(Bitree));//创建树的根 由于c语言的局限性 传参时直接传左子树的指针 
//	Inital(b1); //初始化树根
//	CreateBitree(b1->lchild );//创建并插入二叉树中数据
//	TravelBitree(b1->rchild);//用递归访问二叉树打印china //将根的左子树作为一个新根传递给函数
//	return 0;
//}
////c语言地址传参的局限性 较难实现二叉树 c++中实现
//
////2.二叉树的拷贝（遍历算法的应用）
//
////思路 将旧子树和新子树传递给函数
////递归拷贝左子树 右子树 若子树为空将新子树也为空
//
////思路实现
//int BitreeCopy(Bitree &b1, Bitree &b2)
//{
//	if (b1 == NULL)
//	{
//		b2 = NULL;
//		return 0;
//	}
//	b2 = new Bitree;//开辟新结点
//	b2->date = b1->date;//保存数据
//	BitreeCopy(b1->lchild, b2->lchild);//拷贝左子树
//	BitreeCopy(b1->rchild, b2->rchild);//拷贝右子树
//	//实际上就是遍历算法的应用
//}
//
//二叉结点总数的计算算法
//int NodeBitree(Bitree* b1)
//{
//	if (T == NULL)
//		return 0;
//	else
//		return NodeBitree(b1->lchild) +
//		NodeBitree(b1->rchild) + 1;
//	//根数 + 左子树结点数 + 右子树结点数
//}
//
//二叉树叶子结点数
//
//int LeadBitree(Bitree* b1)
//{
//	if (T == NULL)
//		return 0;
//	if (b1->lchild == NULL && b1->rchild == NULL)
//		return 1;
//	else
//		return LeadBitree(b1->lchild) +
//		LeadBitree(b1->rchild);
//	//左子树叶子数 + 右子树叶子数
//}

//线索二叉树
//
//有时我们需要找到二叉树中遍历得到的元素的前驱和后继
//解决方法有 增加指针(费时间) 重复查找(费空间)
//引入线索二叉树 
//将二叉树转换成线索二叉树的过程称为二叉树的线索化
//
//线索二叉树就是将二叉树中结点的空指针存放该结点的前驱和后继
//
//要区分左右孩子结点指向的是前驱后继还是左右孩子 
//
//需要在结点中加入Ltag标记 和  Rtag标记 为0记为左右孩子结点
//
//标记为1 表示前后区结点
//
//结点演示
//
//typedef struct BiThrNode
//{
//	int date;
//	int ltag, rtag; //标记
//	struct BiThrNode * lchild;
//	struct BiThrNode * rchild;
//}BiTree;
//
//线索二叉树分为 
//
//1.先序线索二叉树 
//2.中序线索二叉树 
//3.后序线索二叉树
//
//增加头结点的线索二叉树
//
//线索二叉树中一点有两个结点元素 的左子树为空且无前驱 右子树为空且为后继
//
//为方便同一操作 在线索二叉树中增加一个头结点
//
//该头结点的左子树指针 指向根结点 
//右子树指针指向线索二叉树中的尾元素（右子树为空且无后继）
//
//然后使线索二叉树中的首元素的左子树指针指向头结点
//线索二叉树中的尾元素的右子树指针指向头结点
//
//这样就解决了首元素和尾元素中左右孩子指针为空的问题
//
//相当于循环链表

//5.6树和森林
//
//树的存储结构
//1. 双亲表示法
//定义结构数组 存放树的结点 每个结点含两个域
//数据域和双亲域
//
//typedef struct PTNode
//{
//	int date;//存放数据
//	int parent;//指双亲在数组中的位置
//}PTNode;
////树结构
//#define MAX 100
//typedef struct
//{
//	PTNode Nodes[MAX];//c语言中有结构体数组
//	int r;//根结点的位置
//	int n;//结点个数
//};
////特点找双亲容易 找孩子难
//
//2.孩子链表
//
//将树用数组储存起来 但每个结点由数据域和 孩子链表头指针域组成
//将每个结点的孩子在数组中的位置用单链表表示出来 若无孩子 则该单链表为空
//n个结点分别对应n个链表 每个孩子链表的头指针为该结点的指针域
//这样的链表就比较好找孩子在数组中的位置
////孩子结点结构
//typedef struct CTNode
//{
//	int child;
//	struct CTNode* next;//孩子结点组成孩子链表
//}CTNode;
////双亲结点结构
//typedef struct
//{
//	int date;//数组中的数据域
//	CTNode* first;//孩子链表的头指针
//}CTBox;
////定义数组
//typedef struct
//{
//	CTBox nodes[MAX];
//	int n, r;//结点数 和根节点的位置
//}CTree;
////特点 找孩子容易 找双亲难
//
//可以将两种方法进行结合 
//
//为带双亲的孩子链表

//3. 孩子兄弟表示法（二叉链表表示法）（二叉树表示法）
//
//用二叉链包作为数组的存储结构 链表中每个结点的两个指针域
//分别指向下一个孩子结点和下一个兄弟结点 注意兄弟结点要连续指向
//
//形成的二叉链表由一个结点开始 从左下第一个结点起 然后沿着右下一直到头
//就是该结点的所有孩子 
//因为所有孩子存在左边 该孩子的兄弟存在右边
//
//typedef struct CSNode {
//	int date;
//	struct CSNode* firstchild;
//	struct CSNode* nextbling;
//};
//特点找孩子和兄弟容易 找双亲难 
//根据需要可以给每个结点定义双亲结点的指针域
//指向双亲 找双亲就较为容易了

//可以用二叉链表表示法表示树  它们之间可以相互转换
//一颗树有唯一一个二叉树与之相对应
//
//
//  ***树转换成二叉树 三步走
//1加线 兄弟之间加一条线
//2抹线 对于每个结点 除了左孩子外 去除其与其余孩子之间的关系
//3旋转 以树根结点为轴心 将整棵树顺时针旋转45。
//兄弟相连留长子
//
// ***二叉树转换成树
//1加线
//2抹线
//3调整
//相当于树转换成二叉树的逆过程
//左孩右右连双亲
//去掉原来右孩线

//5.6.2
//森林转换成二叉树
//1将各颗树分别转换成二叉树
//2将所有二叉树的根节点连接起来
//3以第一颗二叉树的根节点整个二叉树的根
//4剩余二叉树的根节点作为整个二叉树根的右孩子 顺时针旋转
//树变二叉根相连
//
//将二叉树变为森林
//1抹线
//2还原
//等于森林转换成二叉树的逆过程
//抹去根的右孩线
//孤立二叉再还原

//5.6.3
//树和森林的遍历（三种）
//递归遍历 
//树的遍历
//1先根 然后访问子树
//2后根 先访问子树
//3按层次遍历
//
//森林的遍历（三种）
//方法
//1森林中第一颗树的的根节点
//2森林中第一颗树的根子树
//3森林中其他树构成的森林
//
//即依次从左到右 森林中的每一课树进行先序遍历
//中序遍历 后序遍历

//哈夫曼树及其应用(最优二叉树)
//哈夫曼树可以提高数据运算效率
//
//基本概念
//
//路径：从树的一个结点到另一个结点之间的分支构成两个结点间的路径
//结点的路径长度：两结点间路径上的分支数
//树的路径长度：从树根到每一个结点的路径长度的总和
//(树的路径长度： 结点数目相同的情况下 完全二叉树的数的路径最短 充分条件反过来不成立)
//权：将树中结点赋值给一个有某种意义的数值 这个数值称为该结点的全
//结点的带权路径长度：从根结点到该结点的路径长度与该结点的权的乘积
//树的带权路径长度：WPL： Weighted path length 树中所有叶子结点的带权路径长度之和
//
//哈夫曼树 - 最优树 WPL最短的树  比较时数的度相同
//哈夫曼树 - 最优二叉树 WPL最短的二叉树
//特点 哈夫曼树中权值越大的叶子离根越近 
//具有相同带权结点数的哈夫曼树不唯一
//满二叉树不一定是哈夫曼树

//5.7.2
//哈夫曼树的构造方法
//
//贪心算法 构造哈夫曼树时首先选择权值小的叶子结点
//
//1) 构造森林全是根
//2) 选用两小造新树
//3) 删除两小添新人
//4) 重复2 3 剩单根
//
//哈夫曼树中的结点度数为0 或2 没有度数为 1 的结点
//包含n 个叶子结点的哈夫曼树中共有2n- 1 个结点 其中两两新生成的有n -1 个结点度数为1 其余是叶子结点度数为0
//
//哈夫曼树的构造方法
//
//用结构体数组表示 哈夫曼树中的结点
//
//假如该数组有2^n 个结点
//用后2^n - 1个结点 
//先将n个叶子结点存入前n个位置 不包含0号位
//然后循环n-1次 生成后面 n- 1 个结点 
//选两小造新树
//删除两小添新人
//直到剩最后一个根结点
typedef struct huffmanTree {
	int date;
	int parent;
	int rchild;
	int lchild;
}huffmanTree;
//初始化生成哈夫曼树
void select(huffmanTree* hftree, int k, int* s1, int* s2);

huffmanTree* Inital(int n) {
	if (n <= 1)//一个结点构成哈夫曼树无意义
		return;
	huffmanTree* hftree = (huffmanTree*)malloc(sizeof(huffmanTree)* 2*n);//8个叶子的哈夫曼树用要用15个结点 
	//第一个结点不用 开辟2n个结构结点
	for (int i = 1; i < 2*n; i++) { //1~n个结点中的所有结点元素  代表双亲和孩子的位置的变量置为空
		hftree[i].date = 0;
		hftree[i].parent = 0;
		hftree[i].rchild = 0;
		hftree[i].lchild = 0;
	}
	//给前8个结点加权
	for (int j = 1; j <= n; j++) {
		hftree[j].date = rand() % 10 + 1;
	}
	for (int k = n + 1; k < 2 * n; k++) {
		int s1, s2;
		select(hftree, k, &s1, &s2);//在前k个元素中找到权重最小的两个元素下标
		hftree[k].date = hftree[s1].date + hftree[s2].date;
		hftree[k].lchild = s1;
		hftree[k].rchild = s2;
		hftree[s1].parent = k;
		hftree[s2].parent = k;
	}
	return hftree;
}
void select(huffmanTree* hftree, int k, int* s1, int* s2) { //查找最小的两个元素下标！！！！！
	int temp1;
	for (int i = 1; i < k; i++) { //先从数组中找到一颗树的权
		if (hftree[i].parent == 0) {
			temp1 = hftree[i].date;
			break;
		}
	}
	for (int i = 1; i < k; i++) {  //找到最小值
		if (hftree[i].parent != 0)
			continue;
		if (temp1 > hftree[i].date) {
			temp1 = hftree[i].date;
			*s1 = i;
		}
	}
	int temp2;
    for(int i = 1;i<k;i++) {
		if (hftree[i].parent == 0 && *s1 != i) {
			temp2 = hftree[i].date;
			break;
		}
	}
	for (int i = 1; i < k; i++) {
		if (hftree[i].parent != 0)
			continue;
		if (temp2 > hftree[i].date&& hftree[i].date != temp1) {
			temp2 = hftree[i].date;
			*s2 = i;
		}
	}
}
void freetree(huffmanTree* htree) {
	free(htree);
}
int main() {
	srand((unsigned int)time(NULL));
	huffmanTree* htree = Inital(8);//哈夫曼树有8个结点  
	freetree(htree);
}


