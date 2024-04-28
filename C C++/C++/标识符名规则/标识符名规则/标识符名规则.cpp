#include<iostream>
using namespace std;


int main ()
/*标识符的命名规则
1标识符不可以是关键字
2标识符由字母、数字、下滑线构成
3标识开头只能是字母或下划线
4标识符是区分大小写的
*/


//1标识符不能是关键字
//int int = 10;错误


//2标识符是由字母、数字、下滑线构成
{int abc = 10;
int _abc = 20;
int _abc123 = 30;
//3标识符开头不能是数字，只能是字母或下划线
//int 123abc = 40;错误

//4标识符是区分大小写的
int aaa = 100;


	//cout << AAA <<endl;错误，大写AAA与小写aaa不是同一个名称，非同一标识符

//建议：给变量起名时，最好能做到见名知意
//加法运算实例

int numb1 = 10;
int numb2 = 20;
int sum = numb1 + numb2;
cout << sum << endl;

	system("pause");

	return 0;

}