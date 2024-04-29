#define _CRT_SECURE_NO_WARNINGS 1
#include<iostream>
#include<string>
#define NUM 30
using namespace std;
typedef struct record {
	string time;
	double amount;
}record;
//bank类
class Bank {
private:
	int count;
	string crDate;
	double balance;
	record arrRecord[NUM];//近30的记录
	int index = 0;
public:
	Bank(int count, string crDate, double balance);
	void saveOrTakeMoney();
	void showRecord();

};
Bank::Bank(int count, string crDate, double balance) {
	this->count = count;
	this->crDate = crDate;
	this->balance = balance;
}
void Bank::saveOrTakeMoney() {
	cout << "请输入存钱或取钱数：" << endl;
	cin >> arrRecord[index].amount;
	if (balance + arrRecord[index].amount < 0) {
		cout << "账户余额不足" << endl;
		return;
	}
	this->balance += arrRecord[index].amount;
	cout << "请输入日期：" << endl;
	cin >> arrRecord[index].time;//输入进入账信息
	index = (++index) % 30;
}
void Bank::showRecord() {
	cout << "---以下是近期的存出款信息---"<<endl;
	for (int i = 0; i < index; i++) {
		cout << "日期"+arrRecord[i].time + "  " << "存/取金额："<<arrRecord[i].amount <<endl;
	}
	cout << "当前剩余存款：" << balance << endl;
}
int main() {
	Bank bank(123456, "2020-2-1", 12000);
	for(int i = 0; i<3;i++)
	bank.saveOrTakeMoney();
	bank.showRecord();
	system("pause");
	return 0;
}