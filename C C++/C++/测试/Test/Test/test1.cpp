#define _CRT_SECURE_NO_WARNINGS 1
#include<iostream>
#include<string>
using namespace std;
typedef struct arr {
	string date;
	double moneyChange;
}informationArr;
class Bank {
public :
	int count = 0;
private:
	string account;
	string date;
	double ballance;
	informationArr ifArr[30];
public:
	Bank(string accout, string date, double ballance);
	void putMoney(double money, string date);
	void getMoney(double money, string date);
	void showInformation();

};
Bank::Bank(string account, string date, double ballance) {
	this->account = account;
	this->ballance = ballance;
	this->date = date;
}
void Bank::putMoney(double money, string date) {
	ballance += money;
	ifArr[count].moneyChange = money;
	ifArr[count++].date = date;
}
void Bank::getMoney(double money, string date) {
	ballance -= money;
	ifArr[count].moneyChange = money;
	ifArr[count++].date = date;
}
void Bank::showInformation() {
	for (int i = 0; i < count; i++) {
		cout << "交易信息：" << ifArr[i].moneyChange<< ifArr[i].date << endl;
	}
}
int main() {
	Bank bank("1234342", "2022-1-1", 10000);
	bank.putMoney(1000, "2020-12-2");
	bank.getMoney(300, "2230-2-3");
	bank.showInformation();
	return 0;
}