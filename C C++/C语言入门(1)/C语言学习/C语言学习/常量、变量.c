#include<stdio.h>

//定义变量方式
//数据类型 标识符 = 变量

int numb1 = 10;//全局变量—定义在代码块({})外的变量


int main()
{   
	int numb2 = 30;//局部变量—定义在代码块({})n内的变量

	int numb3 = 1;//为numb3抽取内存  定义一个变量 等于几无所谓
	int numb4 = 1;//为numb4抽取内存  定义一个变量 等于几无所谓
	int sum = 6; //为sum抽取内存 定义一个变量 等于几无所谓

	printf("%d\n", numb1);
	
	//局部变量与全局变量的名字建议不要相同—容易误会，产生bug
	//当局部变量与全局变量的名字相同时，局部变量优先
	//局部变量只能在同一个代码框中使用，而全局变量可以在所有代码框中使用

    //加法实例
    //int numb3 = 0;
    //int numb4 = 0;
    //int sum = 0; c语言定义变量只能定义在代码框开头，否则不运行，改到前几行

	printf("%d\n", numb3 + numb4);

	//输入加法实例
	//输入数据-使用输入函数
	scanf("%d%d", &numb3, &numb4);//%d%d为输入2个数显示出来 &numb3 &numb4为取地址符号 找到上面定义的内存的位置
	sum = numb3 + numb4;//输入的两数之和与sum替代 两数和内存存于sum中
	printf("sum = %d\n", sum);

	//复习
	short age = 20;//向内存申请16个比特位，用于存放20

	float weight = 95.5f;//向内存申请32个字节，用于存放95.5

	printf("%d\n",age );


	printf("%f\n", weight);



	return 0;

}